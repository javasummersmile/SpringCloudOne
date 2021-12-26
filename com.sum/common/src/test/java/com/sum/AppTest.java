package com.sum;

import com.sum.designMode.factory.IFileResolveFactory;
import com.sum.designMode.factory.IFileStrategy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
@WebAppConfiguration
public class AppTest 
{

    @Autowired
    private IFileStrategy iFileStrategy;

    @Test
    public void testFactory(){
        final IFileResolveFactory fileStrategy = iFileStrategy.getFileStrategy("A");
        fileStrategy.resolve();
    }
}
