package kr.co.koreait;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Ex30_1_UserDao {
	private final String URL;
	
	public Ex30_1_UserDao(String dbPath) {
		this.URL = "jdbc:sqlite:" + dbPath;
		initSchema();
	}
	
	private Connection conn() {
		Connection c = null;
		try {
			c = DriverManager.getConnection(URL);
			Statement s = c.createStatement();
			s.execute("PRAGMA foreign_keys=ON"); // 외래키 제약 허용
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	private void initSchema() {
		String sql = """
				CREATE TABLE IF NOT EXISTS users (
					id 		INTEGER PRIMARY KEY AUTOINCREMENT,
					name 	TEXT	NOT NULL,
					age 	INTEGER,
					email 	TEXT	UNIQUE
				)
				""";
		
		try(Connection c = conn(); Statement st = c.createStatement()) {
			st.execute(sql);
		} catch(SQLException e) { 
			
		}
	}

	// 1. 유저 추가
	public void insert(Ex30_1_User user) {
		String sql = """
				INSERT INTO users(name, age, email)
				VALUES(?,?,?)
				""";
		
		try(Connection c = conn(); PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setString(1, user.getName()); 
			ps.setInt(2, user.getAge());
			ps.setString(3,  user.getEmail());
			ps.executeUpdate();
		} catch(SQLException e) {
			
		}
	}
	
	// 2. 전체 유저 조회
	public List<Ex30_1_User> findAll() throws SQLException {
		String sql = """
				SELECT * FROM users
				ORDER BY id
				""";
		
		try(Connection c = conn(); PreparedStatement ps = c.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery(); // select 실행할 때는 요고
			List<Ex30_1_User> list = new ArrayList<>();
			
			while(rs.next()) {
				Integer id = rs.getInt("id");
				String name = rs.getString("name");
				Integer age = rs.getInt("age");
				String email = rs.getString("email");
				Ex30_1_User user = new Ex30_1_User(id, name, age, email);
				list.add(user);
				
			}
			
			return list;
		}
	}
	
	// 3. 특정 유저 조회
	public Ex30_1_User find(int id) throws SQLException {
		String sql = """
				SELECT * FROM users
				WHERE id=?
				""";
		
		try(Connection c = conn(); PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Integer resultId = rs.getInt("id");
				String name = rs.getString("name");
				Integer age = rs.getInt("age");
				String email = rs.getString("email");
				return new Ex30_1_User(resultId, name, age, email);
			}
			
		}
		return null;
	}

	// 4. 유저 수정
	public int update(Ex30_1_User users) throws SQLException {
		String sql = """
				UPDATE users 
				SET name=?, age=?, email=?
				WHERE id=? 
				""";
		try(Connection c = conn(); PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setString(1, users.getName());
			ps.setInt(2, users.getAge());
			ps.setString(3, users.getEmail());
			ps.setInt(4, users.getId());
			return ps.executeUpdate(); 
		}
	}

	public int delete(int id) throws SQLException {
		String sql = """
				DELETE FROM users
				WHERE id=?
				""";
		try(Connection c = conn(); PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setInt(1, id); // 쿼리 작성까지 한 거임
			return ps.executeUpdate(); // 쿼리 실행
		}
	}
}
