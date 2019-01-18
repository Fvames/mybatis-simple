package dev.lishengjie;

import dev.lishengjie.config.DataSourceConfig;
import dev.lishengjie.config.MyBatisConfigeration;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by James on 2019/1/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataSourceConfig.class, MyBatisConfigeration.class})
public class BaseTest {
}
