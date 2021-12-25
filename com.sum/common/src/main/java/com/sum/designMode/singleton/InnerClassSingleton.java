package com.sum.designMode.singleton;

/**
 * @author summerSmile
 * @date 2021/12/25
 * @apiNote
 * 静态内部类的实现方式效果类似与双重校验锁
 * 只适用于静态域场景
 */
public class InnerClassSingleton {

    private static class InnerClassSingletonHolder{
        private static final InnerClassSingleton INSTANCE = new InnerClassSingleton();
    }

    private InnerClassSingleton(){

    }

    public static final InnerClassSingleton getInstance(){
        return InnerClassSingletonHolder.INSTANCE;
    }
}
