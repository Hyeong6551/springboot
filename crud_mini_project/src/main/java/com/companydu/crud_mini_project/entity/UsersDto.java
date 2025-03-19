package com.companydu.crud_mini_project.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsersDto {
	private String user_id;
	private String user_name;
	private String user_password;
	private String user_address;
	private String user_postcode;
	private String user_date;
	private GoodsDto goodsDto;

	public UsersDto(String user_id, String user_name, String user_password, String user_address, String user_postcode,
			String user_date) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_password = user_password;
		this.user_address = user_address;
		this.user_postcode = user_postcode;
		this.user_date = user_date;
	}
	
	public UsersDto(String user_id, String user_name, String user_address, String user_postcode) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_address = user_address;
		this.user_postcode = user_postcode;
	}
	
	public UsersDto(String user_id, String user_name, String user_address, String user_postcode, GoodsDto goodsDto) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_address = user_address;
		this.user_postcode = user_postcode;
		this.goodsDto = goodsDto;
	}
}
