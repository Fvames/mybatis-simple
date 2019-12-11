package dev.fvames.mapper;

import dev.fvames.entity.SysDict;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * TODO 类描述
 *
 * @author
 * @version 2019/12/11 10:41
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class SysDictMapperTest {

	@Autowired
	private SysDictMapper sysDictMapper;

	@Test
	public void testInsert() {
		SysDict sysDict = new SysDict();
		sysDict.setType("SEX");
		sysDict.setName("性别:女");
		sysDict.setValue("0");
		sysDict.setCreateTime(new Date());
		sysDict.setCreateUser(1);
		sysDict.setUpdateTime(new Date());
		sysDict.setUpdateUser(1);

		sysDictMapper.insert(sysDict);
	}
}
