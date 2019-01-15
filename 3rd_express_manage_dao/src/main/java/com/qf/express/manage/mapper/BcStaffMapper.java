package com.qf.express.manage.mapper;

import com.qf.express.manage.entity.BcStaff;
import com.qf.express.manage.entity.BcStaffExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BcStaffMapper {
    int countByExample(BcStaffExample example);

    int deleteByExample(BcStaffExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BcStaff record);

    int insertSelective(BcStaff record);

    List<BcStaff> selectByExample(BcStaffExample example);

    BcStaff selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BcStaff record, @Param("example") BcStaffExample example);

    int updateByExample(@Param("record") BcStaff record, @Param("example") BcStaffExample example);

    int updateByPrimaryKeySelective(BcStaff record);

    int updateByPrimaryKey(BcStaff record);
}