package com.qf.express.manage.mapper;

import com.qf.express.manage.entity.BcSubarea;
import com.qf.express.manage.entity.BcSubareaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BcSubareaMapper {
	int countByExample(BcSubareaExample example);

	int deleteByExample(BcSubareaExample example);

	int deleteByPrimaryKey(String id);

	int insert(BcSubarea record);

	int insertSelective(BcSubarea record);

	List<BcSubarea> selectByExample(BcSubareaExample example);

	BcSubarea selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") BcSubarea record, @Param("example") BcSubareaExample example);

	int updateByExample(@Param("record") BcSubarea record, @Param("example") BcSubareaExample example);

	int updateByPrimaryKeySelective(BcSubarea record);

	int updateByPrimaryKey(BcSubarea record);
	
	List<BcSubarea> selectXQbyAccessKey(@Param("keys") List<String> keys);

}