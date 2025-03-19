package com.companydu.crud_mini_project.repository;

import com.companydu.crud_mini_project.entity.UsersDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UsersDao {

	private JdbcTemplate jdbcTemplate;

	public UsersDao(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }
	// 회원가입 (Create)
	public int insertUser(UsersDto users) {
		String sql = "INSERT INTO users (user_name, user_id, user_password, user_address,user_postcode) "+
					"VALUES(?,?,?,?,?);";
		return jdbcTemplate.update(sql,users.getUser_name(),users.getUser_id(),users.getUser_password(),users.getUser_address(), users.getUser_postcode());
	}
	
	// 개별 회원 조회 (Read)
	public UsersDto selectUser(String user_id){
		String sql = "SELECT * FROM users where user_id=?";
		return jdbcTemplate.queryForObject(sql, new Object[]{user_id}, UsersDtoRowMapper());
	}
	
	// 정보 수정 (Update)
	public int updateUser(UsersDto users) {
		String sql = "UPDATE users SET user_password=?, user_name=?, "
					+ "user_address=?, user_postcode=? WHERE user_id=?";
		return jdbcTemplate.update(sql,users.getUser_password(),users.getUser_name(),users.getUser_address(),users.getUser_postcode(),users.getUser_id());
	}
	
	// 회원 탈퇴 (Delete)
	public int deleteUser(String user_id) {
		String sql = "DELETE FROM users WHERE user_id=?";
		return jdbcTemplate.update(sql,user_id);
	}

	private RowMapper<UsersDto> UsersDtoRowMapper(){
		return (rs, rowNum) -> {
			UsersDto users = new UsersDto();
			users.setUser_id(rs.getString("user_id"));
			users.setUser_name(rs.getString("user_name"));
			users.setUser_password(rs.getString("user_password"));
			users.setUser_date(rs.getString("user_date"));
			users.setUser_address(rs.getString("user_address"));
			users.setUser_postcode(rs.getString("user_postcode"));
			return users;
		};
	}
}
