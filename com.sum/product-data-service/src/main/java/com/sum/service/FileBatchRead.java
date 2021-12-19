package com.sum.service;

/**
 * @author summerSmile
 * @date 2021/12/19
 * @apiNote
 * 一个超大的文件，我们可以采用拆分文件的方式，将其拆分成多份文件，然后部署多个应用程序提高读取速度。
 * 另外读取过程我们还可以使用多线程的方式并发导入，不过我们需要注意线程池满载之后，将会拒绝后续任务。
 * 我们可以通过扩展线程池，自定义拒绝策略，使读取主线程阻塞。
 *
 * 作者：Java干货铺
 * 链接：https://juejin.cn/post/7042173639604568072
 * 来源：稀土掘金
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public interface FileBatchRead {
    /**
     * 将文件转成Stream流读取
     */
    void simpleStreamReadFile();

    /**
     * 多线程读取
     */
    void threadReadFile();

    /**
     * 多线程导入
     */
    void threadImportReadFile();
}
