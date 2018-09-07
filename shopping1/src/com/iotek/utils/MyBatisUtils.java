package com.iotek.utils;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtils {

	private static SqlSessionFactory sessionFactory;

	static {
		try {
			// 加载配置文件
			Reader reader = Resources.getResourceAsReader("mybatis.xml");
			// 构建sqlsession工厂
			sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SqlSession getSession() {
		return sessionFactory.openSession();
	}

	public static void close(SqlSession session) {
		session.close();
	}
}
