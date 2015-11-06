package com.chsun.outbox;

public class Telegram_child_item {

	private int mail_read_image;
	private String mail_read_state;
	private String reveive_apartment;
	private String telephone;
	private String where_place;
	private String read_time;
	
	
	
	public Telegram_child_item(int image,String state,String apartment,
			String phone,String place,String time) {
		// TODO Auto-generated constructor stub
		this.mail_read_image=image;
		this.mail_read_state=state;
		this.reveive_apartment=apartment;
		this.telephone=phone;
		this.where_place=place;
		this.read_time=time;
	}
	
	
	public int get_image()
	{
		return mail_read_image;
	}
	
	public String get_state()
	{
		return mail_read_state;
	}
	public String get_apartment()
	{
		return reveive_apartment;
	}
	public String get_phone()
	{
		return telephone;
	}
	public String get_place()
	{
		return where_place;
	}
	public String get_time()
	{
		return read_time;
	}
}
