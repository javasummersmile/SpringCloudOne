package com.sum.service.impl;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.sum.service.FileBatchRead;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.*;

import static com.sum.process.CommonApiService.convertToDB;

/**
 * @author summerSmile
 * @date 2021/12/19
 * @apiNote
 */
public class FileBatchReadImpl implements FileBatchRead {
    private final String path = "";
    private final String encoding = "UTF-8";

    // 自定义线程池拒绝策略，当队列满时改为调用BlockingQueue.put实现生产者阻塞
    RejectedExecutionException rejectedExecutionException = new RejectedExecutionException() {

        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            if (!executor.isShutdown()) {
                try {
                    executor.getQueue().put(r);
                } catch (InterruptedException e) {
                    // should not be interrupted
                }
            }
        }
    };

    static ExecutorService executorService = new ThreadPoolExecutor(
            5,
            10,
            60,
            TimeUnit.MINUTES,
            // 文件数量，假设文件包含10W行
            new ArrayBlockingQueue<>(10 * 10000),
            // guava提供
            new ThreadFactoryBuilder().setNameFormat("test-%d").build());

    @Override
    public void simpleStreamReadFile() {
        try {
            Files.lines(Paths.get(path), Charset.defaultCharset()).forEach(line -> {
                convertToDB(line);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void threadReadFile() {
        File file = new File(path);
        try(LineIterator iterator = IOUtils.lineIterator(new FileInputStream(file),encoding)){
            // 存储每个任务执行的行数
            List<String> lines = Lists.newArrayList();
            // 存储异步任务
            List<ConvertTask> tasks = Lists.newArrayList();
            while (iterator.hasNext()){
                String line = iterator.nextLine();
                lines.add(line);
                // 设置每个线程执行的行数
                if (lines.size() == 1000){
                    // 新建异步任务
                    tasks.add(new ConvertTask(Lists.newArrayList(lines)));
                    lines.clear();
                }
                if (tasks.size() == 10){
                    asyncBatchExecuteTask(tasks);
                }

                /*executorService.submit(() -> {
                    convertToDB(line);
                });*/
            }
            // 文件读取结束，可能还存在未被读取内容
            tasks.add(new ConvertTask(Lists.newArrayList(lines)));
            // 最后再执行一次
            asyncBatchExecuteTask(tasks);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void threadImportReadFile() {
        ExecutorService executorService = new ThreadPoolExecutor(
                5,10,60,TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(100),
                new ThreadFactoryBuilder().setNameFormat("test-%d").build(),
                (r, executor) -> {
                    if (!executor.isShutdown()){
                        try {
                            // 主线程将会被阻塞
                            executor.getQueue().put(r);
                        }catch (InterruptedException e) {
                            // should not be interrupted
                        }
                    }
                }
        );
        File file = new File(path);

        try(LineIterator iterator = IOUtils.lineIterator(new FileInputStream(file),encoding)){
            while (iterator.hasNext()){
                String line = iterator.nextLine();
                executorService.submit(() -> convertToDB(line));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private static class ConvertTask implements Runnable{
        private CountDownLatch countDownLatch;
        private List<String> lines;
        public ConvertTask(List<String> lines) {
            this.lines = lines;
        }
        public void setCountDownLatch(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }
        @Override
        public void run() {
            try {
                for (String line : lines){
                    convertToDB(line);
                }
            }finally {
                countDownLatch.countDown();
            }
        }
    }

    /**
     * 批量执行任务
     * @param tasks
     */
    private static void asyncBatchExecuteTask(List<ConvertTask> tasks) throws InterruptedException{
        final CountDownLatch countDownLatch = new CountDownLatch(tasks.size());
        for (ConvertTask task : tasks){
            task.setCountDownLatch(countDownLatch);
            executorService.submit(task);
        }
        // 主线程等待异步任务 countDownLatch 执行结束
        countDownLatch.await();
        // 清空，重新添加任务
        tasks.clear();
    }


}
