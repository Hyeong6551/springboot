package com.companydu.crud_mini_project.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GoodsDto {
	private int goods_no;
	private String goods_image;
	private String goods_name;
	private int goods_price;
	private String goods_content;
	
	public GoodsDto(String goods_image, String goods_name, int goods_price) {
		super();
		this.goods_image = goods_image;
		this.goods_name = goods_name;
		this.goods_price = goods_price;
	}
}
