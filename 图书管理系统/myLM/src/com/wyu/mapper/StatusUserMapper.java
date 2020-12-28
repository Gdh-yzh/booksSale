package com.wyu.mapper;

import com.wyu.pojo.StatusUser;
import com.wyu.pojo.StatusUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StatusUserMapper {
    int countByExample(StatusUserExample example);

    int deleteByExample(StatusUserExample example);

    int deleteByPrimaryKey(Integer userstatusnumber);

    int insert(StatusUser record);

    int insertSelective(StatusUser record);

    List<StatusUser> selectByExample(StatusUserExample example);

    StatusUser selectByPrimaryKey(Integer userstatusnumber);

    int updateByExampleSelective(@Param("record") StatusUser record, @Param("example") StatusUserExample example);

    int updateByExample(@Param("record") StatusUser record, @Param("example") StatusUserExample example);

    int updateByPrimaryKeySelective(StatusUser record);

    int updateByPrimaryKey(StatusUser record);
}