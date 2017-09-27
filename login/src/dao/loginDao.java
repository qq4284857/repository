package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import entity.User;

public class loginDao {

	public User seachAll(User userseachAll) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/name", "root", "123456");

			Statement stat = conn.createStatement();

			ResultSet rs = stat
					.executeQuery("select * from user where username='"
							+ userseachAll.getName() + "'and password='"
							+ userseachAll.getPassword() + "'");

			while (rs.next()) {

				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userseachAll;

	}

	public User add(User userseachAll) {
		User user=null;
		Statement stat=null;
		ResultSet rs =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/name", "root", "123456");

			stat = conn.createStatement();
			String sql = "inser into user(name,password)values(?,?)";
			rs = stat
					.executeQuery(sql);

			while (rs.next()) {

				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userseachAll;

	}

}
