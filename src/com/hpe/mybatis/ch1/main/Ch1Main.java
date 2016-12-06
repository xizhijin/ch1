package com.hpe.mybatis.ch1.main;

import org.apache.ibatis.session.SqlSession;

import com.hpe.mybatis.ch1.mapper.RoleMapper;
import com.hpe.mybatis.ch1.po.Role;
import com.hpe.mybatis.ch1.util.SqlSessionFactoryUtil;

public class Ch1Main {

	public static void main(String[] args) {
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtil.openSqlSession();
			
			//MyBatis的方式：获取映射器，让映射器通过命名空间和方法名找到对应的SQL，发送给数据库执行后返回结果
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			Role role1 = new Role();
			role1.setRoleName("test?");
			role1.setNote("testNote");
			roleMapper.insertRole(role1);
			
			//传统的iBatis方式：直接通过命名信息去执行SQL返回结果
			Role role2 = sqlSession.selectOne("getRole", 4L);
			System.out.println("The roleName is " + role2.getRoleName());
			
			roleMapper.deleteRole(1L);
			sqlSession.commit();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
			sqlSession.rollback();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
}
