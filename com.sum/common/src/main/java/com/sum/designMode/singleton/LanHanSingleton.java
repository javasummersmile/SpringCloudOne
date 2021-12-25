package com.sum.designMode.singleton;

/**
 * @author summerSmile
 * @date 2021/12/19
 * @apiNote
 * 懒汉式单例模式
 * 比较懒，实例在需要用到的时候才去创建。如果有则返回，没有则新建，
 * 需要加上synchronized关键字，要不然存在线性安全问题
 */
public class LanHanSingleton {
    private static LanHanSingleton instance;

    private LanHanSingleton() {

    }

    public static LanHanSingleton getInstance(){
        if (instance == null){
            instance = new LanHanSingleton();
        }
        return instance;
    }
}
