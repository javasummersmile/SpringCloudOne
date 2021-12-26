package com.sum.designMode.factory;

import com.sum.enums.FileTypeResolveEnum;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author summerSmile
 * @date 2021/12/26
 * @apiNote
 */
public class StrategyUseService implements ApplicationContextAware {

    private Map<FileTypeResolveEnum, IFileStrategy> iFileStrategyMap =  new ConcurrentHashMap<>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        final Map<String, IFileStrategy> tempMap = applicationContext.getBeansOfType(IFileStrategy.class);
        tempMap.values().forEach(strategyService -> iFileStrategyMap.put(strategyService.getFileType(), strategyService));
    }
}
