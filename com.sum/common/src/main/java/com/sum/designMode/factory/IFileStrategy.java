package com.sum.designMode.factory;

import com.sum.enums.FileTypeResolveEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author summerSmile
 * @date 2021/12/25
 * @apiNote
 */
@Component
public class IFileStrategy {
    @Autowired
    IFileResolveFactory fileResolveFactory;

    public IFileResolveFactory getFileStrategy(String fileType){
        if (fileType.equals(FileTypeResolveEnum.FILE_A_RESOLVE)){
            fileResolveFactory = new AFileResolve();
        }else if (fileType.equals(FileTypeResolveEnum.FILE_B_RESOLVE)){
            fileResolveFactory = new BFileResolve();
        }else {
            fileResolveFactory = new DefaultFileResolve();
        }
        return fileResolveFactory;
    }

    public FileTypeResolveEnum getFileType() {
        return FileTypeResolveEnum.FILE_B_RESOLVE;
    }
}
