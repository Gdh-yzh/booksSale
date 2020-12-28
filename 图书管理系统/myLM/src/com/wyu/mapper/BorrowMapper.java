package com.wyu.mapper;

import com.wyu.pojo.Borrow;
import com.wyu.pojo.BorrowAll;
import com.wyu.pojo.BorrowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BorrowMapper {
	int countByExample(BorrowExample example);

	int deleteByExample(BorrowExample example);

	int deleteByPrimaryKey(String borrownumber);

	int insert(Borrow record);

	int insertSelective(Borrow record);

	List<Borrow> selectByExample(BorrowExample example);

	// 联合查询
	List<BorrowAll> selectByExampleBorrowAll(BorrowExample example);

//	 统计最大借阅本数 
	BorrowAll countMaxBookBorrow();

	// 统计借阅的读者数量

	BorrowAll countReaderAmountBorrow();

	Borrow selectByPrimaryKey(String borrownumber);

	int updateByExampleSelective(@Param("record") Borrow record, @Param("example") BorrowExample example);

	int updateByExample(@Param("record") Borrow record, @Param("example") BorrowExample example);

	int updateByPrimaryKeySelective(Borrow record);

	int updateByPrimaryKey(Borrow record);
}