package com.wyu.mapper;

import com.wyu.pojo.ReaderAll;
import com.wyu.pojo.Reader;
import com.wyu.pojo.ReaderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReaderMapper {
    int countByExample(ReaderExample example);

    int deleteByExample(ReaderExample example);

    int deleteByPrimaryKey(String readernumber);

    int insert(Reader record);

    int insertSelective(Reader record);

    List<Reader> selectByExample(ReaderExample example);
    
    List<ReaderAll> selectByExampleAll(ReaderExample example);

    Reader selectByPrimaryKey(String readernumber);

    int updateByExampleSelective(@Param("record") Reader record, @Param("example") ReaderExample example);

    int updateByExample(@Param("record") Reader record, @Param("example") ReaderExample example);

    int updateByPrimaryKeySelective(Reader record);

    int updateByPrimaryKey(Reader record);
}