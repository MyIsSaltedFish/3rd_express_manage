package com.qf.express.manage.mapper;

import com.qf.express.manage.entity.BcRegion;
import com.qf.express.manage.entity.BcRegionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BcRegionMapper {
    int countByExample(BcRegionExample example);

    int deleteByExample(BcRegionExample example);

    int deleteByPrimaryKey(String id);

    int insert(BcRegion record);

    int insertSelective(BcRegion record);

    List<BcRegion> selectByExample(BcRegionExample example);

    BcRegion selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BcRegion record, @Param("example") BcRegionExample example);

    int updateByExample(@Param("record") BcRegion record, @Param("example") BcRegionExample example);

    int updateByPrimaryKeySelective(BcRegion record);

    int updateByPrimaryKey(BcRegion record);
}