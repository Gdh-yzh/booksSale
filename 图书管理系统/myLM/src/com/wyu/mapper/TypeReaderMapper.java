package com.wyu.mapper;

import com.wyu.pojo.TypeReader;
import com.wyu.pojo.TypeReaderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TypeReaderMapper {
    int countByExample(TypeReaderExample example);

    int deleteByExample(TypeReaderExample example);

    int deleteByPrimaryKey(Integer readertypenumber);

    int insert(TypeReader record);

    int insertSelective(TypeReader record);

    List<TypeReader> selectByExample(TypeReaderExample example);

    TypeReader selectByPrimaryKey(Integer readertypenumber);

    int updateByExampleSelective(@Param("record") TypeReader record, @Param("example") TypeReaderExample example);

    int updateByExample(@Param("record") TypeReader record, @Param("example") TypeReaderExample example);

    int updateByPrimaryKeySelective(TypeReader record);

    int updateByPrimaryKey(TypeReader record);
}