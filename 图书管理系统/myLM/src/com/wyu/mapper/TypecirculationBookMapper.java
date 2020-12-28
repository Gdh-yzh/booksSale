package com.wyu.mapper;

import com.wyu.pojo.TypecirculationBook;
import com.wyu.pojo.TypecirculationBookExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TypecirculationBookMapper {
    int countByExample(TypecirculationBookExample example);

    int deleteByExample(TypecirculationBookExample example);

    int deleteByPrimaryKey(Integer typecirculationnumber);

    int insert(TypecirculationBook record);

    int insertSelective(TypecirculationBook record);

    List<TypecirculationBook> selectByExample(TypecirculationBookExample example);

    TypecirculationBook selectByPrimaryKey(Integer typecirculationnumber);

    int updateByExampleSelective(@Param("record") TypecirculationBook record, @Param("example") TypecirculationBookExample example);

    int updateByExample(@Param("record") TypecirculationBook record, @Param("example") TypecirculationBookExample example);

    int updateByPrimaryKeySelective(TypecirculationBook record);

    int updateByPrimaryKey(TypecirculationBook record);
}