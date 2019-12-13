package dev.fvames;

import dev.fvames.entity.SysDict;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO 类描述
 *
 * @author
 * @version 2019/12/13 16:20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class JdbcTemplateTest {

	public static final int COUNT = 10;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	public void testBatchInsert() {
		List<SysDict> list = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			SysDict dict = new SysDict();
			dict.setType("DEPT");
			dict.setName("dept-"+i);
			dict.setValue(String.valueOf(i));

			list.add(dict);
		}

		String sql = "insert into sys_dict(type, name, value) values (?, ?, ?)";
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				SysDict sysDict = list.get(i);
				ps.setString(1, sysDict.getName());
				ps.setString(2, sysDict.getName());
				ps.setString(3, sysDict.getValue());
			}

			@Override
			public int getBatchSize() {
				return list.size();
			}
		});


	}
}
