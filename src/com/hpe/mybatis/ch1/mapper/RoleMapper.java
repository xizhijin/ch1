package com.hpe.mybatis.ch1.mapper;

import com.hpe.mybatis.ch1.po.Role;

public interface RoleMapper {
	public Role getRole(Long id);
	public void deleteRole(Long id);
	public void insertRole(Role role);
}
