package com.xingyi.logistic.business.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @JdbcDao.java Create on2014-12-19 下午1:32:47
 * @author 陈建华
 **/

public class JdbcDao {
	public static Connection getCon() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/xyl?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=UTF-8";
			String user = "root";
			String password = "123";
			try {
				conn = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				System.out.println("获取链接异常");
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}

	public static void getColum(String sql) {
		Connection conn = getCon();
		PreparedStatement psmt = null;
		List<String> colList = new ArrayList<String>();
		List<String> typeList = new ArrayList<String>();
		try {
			psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			if (rsmd != null) {
				int count = rsmd.getColumnCount();
				for (int i = 2; i <= count; i++) {
					colList.add(rsmd.getColumnName(i));
					typeList.add(rsmd.getColumnClassName(i));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		for (int i = 0; i < colList.size(); i++) {

			System.out.print(getPri(typeList.get(i), colList.get(i)));
			
		}
		
		/*for (int i = 0; i < colList.size(); i++) {
			System.out.println();
			System.out.print(creatGetMethod(getDataType(typeList.get(i)),
					colList.get(i)));
			System.out.println();
			System.out.print(creatSetMethod(getDataType(typeList.get(i)),
					colList.get(i)));
		}*/
		
	}
	
	public static void main(String args[]) {
//		System.out.println(changeCol("c_qwe_qwe"));
		getColum("select * from Contract");
	}

	public static String replaceString(String ostr){
		String str = "_";
		int index = ostr.indexOf(str);
		String newStr=ostr;
		if(index!=-1){
			newStr = newStr.substring(0, index + 1)
					+ newStr.substring(index + 1, index + 2).toUpperCase() + newStr
					.substring(index + 2);
			newStr = newStr.replaceFirst(""+newStr.charAt(index), "");
			newStr = replaceString(newStr);
		}
		return newStr;
	}

	
	public static String changeCol(String columname) {
		String lowerstr = columname.toLowerCase();
		return replaceString(lowerstr);
	}
	

	public static String getOrSetStr(String col) {
		String s = changeCol(col);
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}

	public static String getPri(String dataType, String col) {
		return "private " + getDataType(dataType) + " " + changeCol(col)
				+ ";\n\n";
	}

	public static String getDataType(String type) {
		if (type.equals("java.math.BigDecimal")) {
			return "int";
		} else if (type.equals("java.lang.String")) {
			return "String";
		} else if (type.equals("java.sql.Timestamp")) {
			return "Date";
		} else {
			return "String";
		}
	}

	/*
	 * public String getPcId() { return pcId; }
	 */
	public static String creatGetMethod(String dataType, String col) {
		return "public " + dataType + " get" + getOrSetStr(col) + "(){\n\t"
				+ "return " + changeCol(col) + ";\n}";
	}

	/*
	 * public void setPcId(String pcId) { this.pcId = pcId; }
	 */
	public static String creatSetMethod(String dataType, String col) {
		String changeStr = changeCol(col);
		return "public void set" + getOrSetStr(col) + "(" + dataType + " "
				+ changeStr + "){\n\t" + "this." + changeStr + "= " + changeStr
				+ ";\n}";
	}

	public static String getStr(String columname) {
		int i = columname.indexOf("_");
		String lowerstr = columname.toLowerCase();
		if (i != -1) {
			return changeCol(lowerstr);
		} else {
			return columname.toLowerCase();
		}
	}
	
}
