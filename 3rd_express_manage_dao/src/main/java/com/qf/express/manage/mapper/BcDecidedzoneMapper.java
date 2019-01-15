package com.qf.express.manage.mapper;

import com.qf.express.manage.entity.BcDecidedzone;
import com.qf.express.manage.entity.BcDecidedzoneExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BcDecidedzoneMapper {
    int countByExample(BcDecidedzoneExample example);

    int deleteByExample(BcDecidedzoneExample example);

    int deleteByPrimaryKey(String id);

    int insert(BcDecidedzone record);

    int insertSelective(BcDecidedzone record);

    List<BcDecidedzone> selectByExample(BcDecidedzoneExample example);

    BcDecidedzone selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BcDecidedzone record, @Param("example") BcDecidedzoneExample example);

    int updateByExample(@Param("record") BcDecidedzone record, @Param("example") BcDecidedzoneExample example);

    int updateByPrimaryKeySelective(BcDecidedzone record);

    int updateByPrimaryKey(BcDecidedzone record);
}