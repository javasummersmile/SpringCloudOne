package com.sum.designMode.singleton;

/**
 * @author summerSmile
 * @date 2021/12/25
 * @apiNote
 * 双重校验锁实现的单例模式
 * 综合了懒汉式和饿汉式的优缺点
 * synchronized 内外都加上if条件判断
 * 既保证了线程安全，又提高了执行效率，还节省了空间
 * 可在实例域需要延迟初始化时使用
 */
public class DoubleCheckSingleton {
    private static DoubleCheckSingleton instance;
    private DoubleCheckSingleton(){

    }
    public static DoubleCheckSingleton getInstance(){
        if (instance == null){
            synchronized (DoubleCheckSingleton.class){
                if (instance == null){
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
}
