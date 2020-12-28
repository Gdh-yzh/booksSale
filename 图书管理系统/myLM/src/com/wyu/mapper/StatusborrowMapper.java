package com.wyu.mapper;

import com.wyu.pojo.Statusborrow;
import com.wyu.pojo.StatusborrowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StatusborrowMapper {
    int countByExample(StatusborrowExample example);

    int deleteByExample(StatusborrowExample example);

    int deleteByPrimaryKey(Integer statusborrownumber);

    int insert(Statusborrow record);

    int insertSelective(Statusborrow record);

    List<Statusborrow> selectByExample(StatusborrowExample example);

    Statusborrow selectByPrimaryKey(Integer statusborrownumber);

    int updateByExampleSelective(@Param("record") Statusborrow record, @Param("example") StatusborrowExample example);

    int updateByExample(@Param("record") Statusborrow record, @Param("example") StatusborrowExample example);

    int updateByPrimaryKeySelective(Statusborrow record);

    int updateByPrimaryKey(Statusborrow record);
}