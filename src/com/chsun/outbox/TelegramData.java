package com.chsun.outbox;

import java.sql.Struct;

import android.R.bool;
import android.R.integer;

public class TelegramData {

	private String LEVEL_IMAGE; //级别
	private String THEME;//主题
	private String CONTENT;//内容
	private int ADDITION;//附件  这里要放个图标
	private String RECEIVER;//接受人
	private int EXPAND_IMAGE;//是否展开
	private String TIME;//时间
	

	
	public TelegramData(String l_Image,String themeString,String content,
			int addtion,String receiver,int expand_image,
			String times) {
		// TODO Auto-generated constructor stub
		
		this.LEVEL_IMAGE=l_Image;
		this.THEME=themeString;
		this.CONTENT=content;
		this.ADDITION=addtion;
		this.RECEIVER=receiver;
		this.EXPAND_IMAGE=expand_image;
		this.TIME=times;
			
	}	
	
	public String getLevel()
	{
		return LEVEL_IMAGE;
	}
	
	public String getTheme()
	{
		return THEME;
	}
	
	public String getContent()
	{
		return CONTENT;
	}
	
	public int getAddition()
	{
		return ADDITION;
	}
	public String getReceiver()
	{
		return RECEIVER;
	}
	public int getExpandImage()
	{
		return EXPAND_IMAGE;
	}
	public String getTime()
	{
		return TIME;
	}
	
	
}


