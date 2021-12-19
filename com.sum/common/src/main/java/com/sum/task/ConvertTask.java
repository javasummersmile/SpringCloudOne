package com.sum.task;

/**
 * @author summerSmile
 * @date 2021/12/19
 * @apiNote
 * 异步任务
 * 等数据导入完成之后，一定要调用countDownLatch.countDown()
 * 不然，这个主线程将会被阻塞
 */


