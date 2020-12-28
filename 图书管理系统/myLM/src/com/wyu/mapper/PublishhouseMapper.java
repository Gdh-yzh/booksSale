package com.wyu.mapper;

import com.wyu.pojo.Publishhouse;
import com.wyu.pojo.PublishhouseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PublishhouseMapper {
    int countByExample(PublishhouseExample example);

    int deleteByExample(PublishhouseExample example);

    int deleteByPrimaryKey(Integer publishhousenumber);

    int insert(Publishhouse record);

    int insertSelective(Publishhouse record);

    List<Publishhouse> selectByExample(PublishhouseExample example);

    Publishhouse selectByPrimaryKey(Integer publishhousenumber);

    int updateByExampleSelective(@Param("record") Publishhouse record, @Param("example") PublishhouseExample example);

    int updateByExample(@Param("record") Publishhouse record, @Param("example") PublishhouseExample example);

    int updateByPrimaryKeySelective(Publishhouse record);

    int updateByPrimaryKey(Publishhouse record);
}