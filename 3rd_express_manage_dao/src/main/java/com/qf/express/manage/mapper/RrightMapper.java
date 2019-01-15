package com.qf.express.manage.mapper;

import com.qf.express.manage.entity.Rright;
import com.qf.express.manage.entity.RrightExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RrightMapper {
    int countByExample(RrightExample example);

    int deleteByExample(RrightExample example);

    int deleteByPrimaryKey(Integer rightid);

    int insert(Rright record);

    int insertSelective(Rright record);

    List<Rright> selectByExample(RrightExample example);

    Rright selectByPrimaryKey(Integer rightid);

    int updateByExampleSelective(@Param("record") Rright record, @Param("example") RrightExample example);

    int updateByExample(@Param("record") Rright record, @Param("example") RrightExample example);

    int updateByPrimaryKeySelective(Rright record);

    int updateByPrimaryKey(Rright record);
    
    //根据角色id 和 父亲 id查询这个父亲下面对应的权利节点
    List<Rright> selectRightByPidAndRoleid(@Param("roleid") Integer roleid,
    		@Param("parentid") Integer parentid);
    //查询权利的集合 为了 添加和 修改
    List<Rright> selectrightsforcurd(@Param("roleid") Integer roleid,@Param("parentid") Integer parentid);
}