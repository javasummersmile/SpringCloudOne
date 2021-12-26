package com.sum.designMode.factory;

/**
 * @author summerSmile
 * @date 2021/12/25
 * @apiNote
 */
public class AFileResolve implements IFileResolveFactory{
    @Override
    public void resolve() {
        System.out.println("文件A类型解析");
    }
}
