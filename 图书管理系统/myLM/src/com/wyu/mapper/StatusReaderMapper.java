package com.wyu.mapper;

import com.wyu.pojo.StatusReader;
import com.wyu.pojo.StatusReaderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StatusReaderMapper {
    int countByExample(StatusReaderExample example);

    int deleteByExample(StatusReaderExample example);

    int deleteByPrimaryKey(Integer readerstatusnumber);

    int insert(StatusReader record);

    int insertSelective(StatusReader record);

    List<StatusReader> selectByExample(StatusReaderExample example);

    StatusReader selectByPrimaryKey(Integer readerstatusnumber);

    int updateByExampleSelective(@Param("record") StatusReader record, @Param("example") StatusReaderExample example);

    int updateByExample(@Param("record") StatusReader record, @Param("example") StatusReaderExample example);

    int updateByPrimaryKeySelective(StatusReader record);

    int updateByPrimaryKey(StatusReader record);
}