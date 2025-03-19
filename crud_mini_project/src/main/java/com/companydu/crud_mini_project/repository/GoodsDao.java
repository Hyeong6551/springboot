package com.companydu.crud_mini_project.repository;

import java.util.List;

import com.companydu.crud_mini_project.entity.GoodsDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class GoodsDao {

	private final JdbcTemplate jdbcTemplate;

	public GoodsDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// 상품 생성 (Create)
	public int insertGoods(GoodsDto goods) {
		String sql = "INSERT INTO goods (goods_no,goods_image, goods_name, goods_price, goods_content)"+
		            " VALUES (NULL, ?, ?, ?, ?)";
		return jdbcTemplate.update(sql, goods.getGoods_image(), goods.getGoods_price(), goods.getGoods_name(), goods.getGoods_content());
	}
	
	// 상품 전체 조회
	public List<GoodsDto> selectAllGoods() {
		String sql = "SELECT * FROM goods";
		return jdbcTemplate.query(sql,goodsDtoRowMapper());
	}
	
	// 상품 개별 조회 (Read)
	public GoodsDto selectGoods(int goods_no) {
		String sql = "SELECT * FROM goods WHERE goods_no=?";
		return jdbcTemplate.queryForObject(sql, new Object[]{goods_no}, goodsDtoRowMapper());
	}
	
	// 상품 삭제 (Delete)
	public int deleteGoods(int goods_no) {
		String sql = "DELETE FROM goods WHERE goods_no=?";
		return jdbcTemplate.update(sql,goods_no);
	}

	private RowMapper<GoodsDto> goodsDtoRowMapper(){
		return (rs, rowNum) -> {
			GoodsDto goods = new GoodsDto();
			goods.setGoods_no(rs.getInt("goods_no"));
			goods.setGoods_image(rs.getString("goods_image"));
			goods.setGoods_name(rs.getString("goods_name"));
			goods.setGoods_price(rs.getInt("goods_price"));
			goods.setGoods_content(rs.getString("goods_content"));
			return goods;
		};
	}
}