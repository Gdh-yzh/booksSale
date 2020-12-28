package com.wyu.mapper;

import com.wyu.pojo.LocationBook;
import com.wyu.pojo.LocationBookExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LocationBookMapper {
    int countByExample(LocationBookExample example);

    int deleteByExample(LocationBookExample example);

    int deleteByPrimaryKey(String booknumber);

    int insert(LocationBook record);

    int insertSelective(LocationBook record);

    List<LocationBook> selectByExample(LocationBookExample example);

    LocationBook selectByPrimaryKey(String booknumber);

    int updateByExampleSelective(@Param("record") LocationBook record, @Param("example") LocationBookExample example);

    int updateByExample(@Param("record") LocationBook record, @Param("example") LocationBookExample example);

    int updateByPrimaryKeySelective(LocationBook record);

    int updateByPrimaryKey(LocationBook record);
}