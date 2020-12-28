package com.wyu.mapper;

import com.wyu.pojo.TypebookCf;
import com.wyu.pojo.TypebookCfExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TypebookCfMapper {
    int countByExample(TypebookCfExample example);

    int deleteByExample(TypebookCfExample example);

    int deleteByPrimaryKey(Integer typebookCfnumber);

    int insert(TypebookCf record);

    int insertSelective(TypebookCf record);

    List<TypebookCf> selectByExample(TypebookCfExample example);

    TypebookCf selectByPrimaryKey(Integer typebookCfnumber);

    int updateByExampleSelective(@Param("record") TypebookCf record, @Param("example") TypebookCfExample example);

    int updateByExample(@Param("record") TypebookCf record, @Param("example") TypebookCfExample example);

    int updateByPrimaryKeySelective(TypebookCf record);

    int updateByPrimaryKey(TypebookCf record);
}