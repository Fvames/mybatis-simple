package dev.fvames.mapper;

import dev.fvames.entity.SysDict;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysDictMapper {
    int insert(SysDict record);

    List<SysDict> selectAll();
}