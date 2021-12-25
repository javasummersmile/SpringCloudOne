package com.sum.designMode.singleton;

/**
 * @author summerSmile
 * @date 2021/12/19
 * @apiNote
 * 比较饥饿，实例在初始化的时候就已经建好了，
 * 没有线性安全问题，但是浪费空间
 */
public class EHanSingleton {

    private static EHanSingleton instance = new EHanSingleton();

    private EHanSingleton(){

    }

    public static EHanSingleton getInstance(){
        return instance;
    }
}
