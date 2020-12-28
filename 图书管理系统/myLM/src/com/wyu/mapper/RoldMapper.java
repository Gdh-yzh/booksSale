package com.wyu.mapper;

import com.wyu.pojo.Rold;
import com.wyu.pojo.RoldExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoldMapper {
    int countByExample(RoldExample example);

    int deleteByExample(RoldExample example);

    int deleteByPrimaryKey(Integer roldnumber);

    int insert(Rold record);

    int insertSelective(Rold record);

    List<Rold> selectByExample(RoldExample example);

    Rold selectByPrimaryKey(Integer roldnumber);

    int updateByExampleSelective(@Param("record") Rold record, @Param("example") RoldExample example);

    int updateByExample(@Param("record") Rold record, @Param("example") RoldExample example);

    int updateByPrimaryKeySelective(Rold record);

    int updateByPrimaryKey(Rold record);
}