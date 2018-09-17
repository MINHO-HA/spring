package com.name.git.controller;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class test {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://192.168.0.134:3306/spring_ex?useSSL=false&serverTimezone=Asia/Seoul";
	private static final String USER = "java2";
	private static final String PASSWORD = "java2";

	@Test
	public void testConnection() throws Exception {
		Class.forName(DRIVER);
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
			System.out.println(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
