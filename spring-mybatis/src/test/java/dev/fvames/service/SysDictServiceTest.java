package dev.fvames.service;

import dev.fvames.entity.SysDict;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * TODO 类描述
 *
 * @author
 * @version 2019/12/12 15:00
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class SysDictServiceTest {

	@Autowired
	private SysDictService sysDictService;

	@Test
	public void testInsert() {
		SysDict sysDict = new SysDict();
		sysDict.setType("SEX");
		sysDict.setName("性别:男");
		sysDict.setValue("1");
		sysDict.setCreateTime(new Date());
		sysDict.setCreateUser(1);
		sysDict.setUpdateTime(new Date());
		sysDict.setUpdateUser(1);

		sysDictService.insert(sysDict);
	}

	@Test
	public void testSelectAll() {
		List<SysDict> list = sysDictService.findList();
		list.forEach(System.out::println);
	}
}
