package com.sum.designMode.factory;

/**
 * @author summerSmile
 * @date 2021/12/25
 * @apiNote
 */
public class BFileResolve implements IFileResolveFactory{

    @Override
    public void resolve() {
        System.out.println("B文件类型解析");
    }
}
