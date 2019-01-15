package com.qf.express.manage.mapper;

import com.qf.express.manage.entity.RoleAuthority;
import com.qf.express.manage.entity.RoleAuthorityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleAuthorityMapper {
    int countByExample(RoleAuthorityExample example);

    int deleteByExample(RoleAuthorityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoleAuthority record);

    int insertSelective(RoleAuthority record);

    List<RoleAuthority> selectByExample(RoleAuthorityExample example);

    RoleAuthority selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoleAuthority record, @Param("example") RoleAuthorityExample example);

    int updateByExample(@Param("record") RoleAuthority record, @Param("example") RoleAuthorityExample example);

    int updateByPrimaryKeySelective(RoleAuthority record);

    int updateByPrimaryKey(RoleAuthority record);
    
    //根据角色id 查询这个角色拥有的操作权利的路径字符串
    List<String> selectAuthorityByRoleid(Integer roleid);
    //根据角色id 查询这个角色拥有的操作权利的名字字段
    List<String> selectAuthorityTextByRoleid(Integer roleid);
}