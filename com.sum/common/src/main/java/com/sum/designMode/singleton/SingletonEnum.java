package com.sum.designMode.singleton;

/**
 * @author summerSmile
 * @date 2021/12/25
 * @apiNote
 * 枚举实现的单例
 * 自动支持序列化机制，防止多次实例化
 */
public enum SingletonEnum {

    INSTANCE;

    public SingletonEnum getInstance(){
        return INSTANCE;
    }
}
