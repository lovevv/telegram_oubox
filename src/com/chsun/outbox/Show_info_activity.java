package com.chsun.outbox;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class Show_info_activity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.show_info);
		
		TextView show_themeTextView=(TextView)findViewById(R.id.show_info_theme);
		TextView show_contentTextView=(TextView)findViewById(R.id.show_info_content);
		Intent intent=getIntent();
		String data_themeString=intent.getStringExtra("show_theme");
		String data_contentString=intent.getStringExtra("show_content");
			
		show_themeTextView.setText(data_themeString);
		show_contentTextView.setText(data_contentString);
	}
}
