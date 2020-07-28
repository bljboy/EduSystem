package com.edu.edusystem.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DBHelper {
	////静态方法也叫类方法，调用时直接用类的名称来调用//////
	//DBHelper.iniConnection();
	// //////////对于一个数据访问来说，主要有一些什么功能呢
	// 1.查询操作
	// 2.增删改操作
	// 3.首行首列 select count(*)
	// ///////初始化连接////////
	private static Connection connection=null;
	private static PreparedStatement pstm=null;
	private static ResultSet rset=null;
	public  static Connection iniConnection() {
		// ///1.准备//////////////////
		//jdbc:mysql://localhost:3306/jsjdata?useUnicode=true&characterEncoding=utf8
		String url = "jdbc:mysql://cdb-omcraf3e.cd.tencentcdb.com:10142/EduSystem?useUnicode=true&characterEncoding=utf8";
		String username = "edu_system_account";
		String pwd = "qwert12345";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn = DriverManager.getConnection(url, username, pwd);
			return cn;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}

	public static void colseCn(ResultSet rs, java.sql.PreparedStatement ps,
							   Connection cn) {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		if (ps != null)
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		if (cn != null)
			try {
				cn.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
	}

	// ///////////////
	/**
	 * @param sqlString
	 *            传入的增删改的sql语句
	 * @param objects
	 *            传入参数，用数组来传
	 * @return
	 */
	public static boolean Update(String sqlString, Object[] objects) {
		Connection cn = iniConnection();
		java.sql.PreparedStatement ps = null;
		try {
			ps = cn.prepareStatement(sqlString);
			// /////////参数处理/////////////
			if (objects != null) {
				for (int i = 0; i < objects.length; i++) {
					ps.setObject(i + 1, objects[i]);
				}
			}
			// //////////////////
			if (ps.executeUpdate() >= 1) {
				colseCn(null, ps, cn);
				return true;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		colseCn(null, ps, cn);
		return false;
	}

	// ////返回首行首列 例 select count(*)////////
	public static String getScalar(String sqlString, Object[] objects) {
		Connection cn = iniConnection();
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;
		String result = "";
		try {
			ps = cn.prepareStatement(sqlString);
			// /////////参数处理/////////////
			if (objects != null) {
				for (int i = 0; i < objects.length; i++) {
					ps.setObject(i + 1, objects[i]);
				}
			}
			// ///有可能是空表////////////////
			rs = ps.executeQuery();
			// ///ResultSet是一个邮标，不能关闭连接，使用时必须持续连接/////////
			rs.next();
			result = rs.getString(1);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		colseCn(rs, ps, cn);
		return result;
	}
	// ///这个方法我们尽量不用 因为它要持续保持连接/////不进行服务器配置连接数为20////
	/////定义 datacolmn   datarow   datatable////////////

	// ///这个方法我们尽量不用 因为它要持续保持连接/////不进行服务器配置连接数为20////
	public static ResultSet Query(String sqlString, Object[] objects) {
		connection= iniConnection();
		try {
			pstm = connection.prepareStatement(sqlString);
			// /////////参数处理/////////////
			if (objects != null) {
				for (int i = 0; i < objects.length; i++) {
					pstm.setObject(i + 1, objects[i]);
				}
			}
			// ///有可能是空表////////////////
			rset = pstm.executeQuery();
			// ///ResultSet是一个邮标，不能关闭连接，使用时必须持续连接/////////
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return rset;
	}
	////list为列表/////
	public static List<HashMap<String, Object>> getList(String sqlString, Object[] objects) {
		Connection cn= iniConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<HashMap<String, Object>> list=new ArrayList<>();
		try {
			ps = cn.prepareStatement(sqlString);
			// /////////参数处理/////////////
			if (objects != null) {
				for (int i = 0; i < objects.length; i++) {
					ps.setObject(i + 1, objects[i]);
				}
			}
			// ///有可能是空表////////////////
			rs = ps.executeQuery();



			ResultSetMetaData rsmd=rs.getMetaData();
			while (rs.next()) {
				HashMap<String, Object> row=new HashMap<>();
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					row.put(rsmd.getColumnName(i), rs.getObject(i));
				}
				list.add(row);
			}
			// ///ResultSet是一个邮标，不能关闭连接，使用时必须持续连接/////////
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		colseCn(rs, ps, cn);
		return list;
	}

	///////这里关闭的是静态的三个成员///
	public static void closeCn1(){
		try {
			rset.close();
			pstm.close();
			connection.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}


	}
}
