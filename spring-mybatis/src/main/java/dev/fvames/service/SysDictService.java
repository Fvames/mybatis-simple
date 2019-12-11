package dev.fvames.service;

import dev.fvames.entity.SysDict;
import dev.fvames.mapper.SysDictMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO 类描述
 *
 * @author
 * @version 2019/12/11 10:32
 */
@Service
public class SysDictService {

	@Autowired
	private SysDictMapper sysDictMapper;

	public int insert(SysDict dict) {
		return sysDictMapper.insert(dict);
	}

	public List<SysDict> findList() {
		return sysDictMapper.selectAll();
	}
}
