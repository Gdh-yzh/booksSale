package com.wyu.mapper;

import com.wyu.pojo.ClassificationBook;
import com.wyu.pojo.ClassificationBookExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassificationBookMapper {
    int countByExample(ClassificationBookExample example);

    int deleteByExample(ClassificationBookExample example);

    int deleteByPrimaryKey(Integer classificationnumber);

    int insert(ClassificationBook record);

    int insertSelective(ClassificationBook record);

    List<ClassificationBook> selectByExample(ClassificationBookExample example);

    ClassificationBook selectByPrimaryKey(Integer classificationnumber);

    int updateByExampleSelective(@Param("record") ClassificationBook record, @Param("example") ClassificationBookExample example);

    int updateByExample(@Param("record") ClassificationBook record, @Param("example") ClassificationBookExample example);

    int updateByPrimaryKeySelective(ClassificationBook record);

    int updateByPrimaryKey(ClassificationBook record);
}