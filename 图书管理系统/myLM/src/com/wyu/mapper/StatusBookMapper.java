package com.wyu.mapper;

import com.wyu.pojo.StatusBook;
import com.wyu.pojo.StatusBookExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StatusBookMapper {
    int countByExample(StatusBookExample example);

    int deleteByExample(StatusBookExample example);

    int deleteByPrimaryKey(Integer bookstatusnumber);

    int insert(StatusBook record);

    int insertSelective(StatusBook record);

    List<StatusBook> selectByExample(StatusBookExample example);

    StatusBook selectByPrimaryKey(Integer bookstatusnumber);

    int updateByExampleSelective(@Param("record") StatusBook record, @Param("example") StatusBookExample example);

    int updateByExample(@Param("record") StatusBook record, @Param("example") StatusBookExample example);

    int updateByPrimaryKeySelective(StatusBook record);

    int updateByPrimaryKey(StatusBook record);
}