package com.qf.express.manage.mapper;

import com.qf.express.manage.entity.QpNoticebill;
import com.qf.express.manage.entity.QpNoticebillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QpNoticebillMapper {
    int countByExample(QpNoticebillExample example);

    int deleteByExample(QpNoticebillExample example);

    int deleteByPrimaryKey(String id);

    int insert(QpNoticebill record);

    int insertSelective(QpNoticebill record);

    List<QpNoticebill> selectByExample(QpNoticebillExample example);

    QpNoticebill selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") QpNoticebill record, @Param("example") QpNoticebillExample example);

    int updateByExample(@Param("record") QpNoticebill record, @Param("example") QpNoticebillExample example);

    int updateByPrimaryKeySelective(QpNoticebill record);

    int updateByPrimaryKey(QpNoticebill record);
}