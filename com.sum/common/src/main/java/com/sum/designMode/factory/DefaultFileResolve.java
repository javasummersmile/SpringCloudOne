package com.sum.designMode.factory;

/**
 * @author summerSmile
 * @date 2021/12/25
 * @apiNote
 */
public class DefaultFileResolve implements IFileResolveFactory{
    @Override
    public void resolve() {
        System.out.println("默认文件解析类型");
    }
}
