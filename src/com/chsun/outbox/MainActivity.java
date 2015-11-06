package com.chsun.outbox;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;

import android.R.bool;
import android.R.integer;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

	private Button  searchButton;
	private Button  synchronousButton;
	private Button  logoutButton;	
	LinearLayout testLayout;
	private boolean clickSearch=false;
	
	private ArrayList<TelegramData> groupResource=new ArrayList<TelegramData>();
	private ArrayList<ArrayList<Telegram_child_item> >childResource=new ArrayList<ArrayList<Telegram_child_item>>();
	ExpandableListView listView;
	
	ImageView imageView;
	boolean group_isspand=true; //默认是不点击这个的话就不展开
	boolean isLongPause=false;  //  这个字段是用来进行屏蔽长按事件发生的时候会触发一个单击事件的情况
	boolean isFirstShowActionBar=false;
	Telegram_adapter adapter;
	ActionBar actionBar;	
	RelativeLayout part1;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//requestWindowFeature(Window.FEATURE_NO_TITLE);  设置不显示actionbar  这个时候
		setContentView(R.layout.activity_main);
		
		init();
		set_click_event();
		init_group();
		init_child();
		
		adapter=new Telegram_adapter(MainActivity.this, groupResource, childResource,listView);
		
		listView.setAdapter(adapter);
		listView.setChoiceMode(2);  //设置多选模式
		listView.setOnItemLongClickListener(new QuickWayListener());  //listView.setMultiChoiceModeListener(listener)
		
	}
	
	public ExpandableListView getListView() //用于获取在适配器中通过context来获取listview的对象  这也是一个实现的方式
	{
		return listView;
	}	
	
	
	private class QuickWayListener implements OnItemLongClickListener
 	{
 		@Override
 		public boolean onItemLongClick(AdapterView<?> parent, View view,
 				int position, long id) {
 			// TODO Auto-generated method stub
 			int group_pos=(Integer)view.getTag(R.id.child_mail_state);
 			int child_pos=(Integer)view.getTag(R.id.child_mail_state_image);
 			isLongPause=true;
 			
 			if(!isFirstShowActionBar)
 			{
 				actionBar=getActionBar();  //设置action bar可以显示
 	 			actionBar.show(); 
 	 			part1.setVisibility(8);
 	 			isFirstShowActionBar=true;
 			}
 
 			//隐藏布局
 			//=(LinearLayout)findViewById(R.layout.part1);
 			//part1.setVisibility(2);
 			
 			
 			if(child_pos==-1) 
 			{
 				Log.d("俺的是父项  组号是 ：",""+group_pos);   //说明这个时候长按的是group的项目
 				//adapter.getGroupView(position, isExpanded, convertView, parent)
 				if(listView.isItemChecked(group_pos))
 					listView.setItemChecked(group_pos, false);
 				else
 					listView.setItemChecked(group_pos,true);		
 			}
 			else
 			{
 				Log.d("俺的是子项  子项是 ： ",""+child_pos); //说明设置的是子项
 				//listView.setItemChecked(child_pos, true);
 				
			}
 			return false;
 		}
 	}
	
	
	
	
	
	public void init_group()
	{
		TelegramData data1=new TelegramData("普通","两会指导精神报告","扎实推荐司法改革，认真总结试点经验",R.drawable.addit,"收件人\n收件人B",R.drawable.retract,"09:35:03\n2015-11-03");
		groupResource.add(data1);
		
		TelegramData data2=new TelegramData("普通","两会指导精神报告","扎实推荐司法改革，认真总结试点经验",R.drawable.addit,"收件人\n收件人B",R.drawable.retract,"09:35:03\n2015-11-03");
		groupResource.add(data2);
		
		TelegramData data3=new TelegramData("普通","两会指导精神报告","扎实推荐司法改革，认真总结试点经验",R.drawable.addit,"收件人\n收件人B",R.drawable.retract,"09:35:03\n2015-11-03");
		groupResource.add(data3);
		
		TelegramData data4=new TelegramData("普通","两会指导精神报告","扎实推荐司法改革，认真总结试点经验",R.drawable.addit,"收件人\n收件人B",R.drawable.retract,"09:35:03\n2015-11-03");
		groupResource.add(data4);
		
		TelegramData data5=new TelegramData("普通","两会指导精神报告","扎实推荐司法改革，认真总结试点经验",R.drawable.addit,"收件人\n收件人B",R.drawable.retract,"09:35:03\n2015-11-03");
		groupResource.add(data5);
		
		TelegramData data6=new TelegramData("普通","两会指导精神报告","扎实推荐司法改革，认真总结试点经验",R.drawable.addit,"收件人\n收件人B",R.drawable.retract,"09:35:03\n2015-11-03");
		groupResource.add(data6);
	}
	public void init_child()
	{
		
		Telegram_child_item data1=new Telegram_child_item(R.drawable.mail_read, "已读", "中国铁路工会", 
				"电话\n2321321321","地点\n北京市朝阳区三里屯北32号","读取时间\n09:35:03\n2015-11-03");
		
		Telegram_child_item data2=new Telegram_child_item(R.drawable.mail_read, "已读", "中国铁路工会", 
				"电话\n2321321321","地点\n北京市朝阳区三里屯北32号","读取时间\n09:35:03\n2015-11-03");
		
		Telegram_child_item data3=new Telegram_child_item(R.drawable.mail_read, "已读", "中国铁路工会", 
				"电话\n2321321321","地点\n北京市朝阳区三里屯北32号","读取时间\n09:35:03\n2015-11-03");
		
		Telegram_child_item data4=new Telegram_child_item(R.drawable.mail_read, "已读", "中国铁路工会", 
				"电话\n2321321321","地点\n北京市朝阳区三里屯北32号","读取时间\n09:35:03\n2015-11-03");
		
		ArrayList<Telegram_child_item> tmp=new ArrayList<Telegram_child_item>();
		tmp.add(data1);
		tmp.add(data2);
		tmp.add(data3);
		tmp.add(data4);
		childResource.add(tmp);
		
		
	}
	private void init()
	{
		searchButton=(Button)findViewById(R.id.search);
		synchronousButton=(Button)findViewById(R.id.synchronize);
		logoutButton=(Button)findViewById(R.id.logout);
		testLayout=(LinearLayout)findViewById(R.id.set_search);
		part1=(RelativeLayout)findViewById(R.id.title_outbox);
		
		listView=(ExpandableListView)findViewById(R.id.expandablelistview);
		
		actionBar = getActionBar();
		actionBar.hide();
	}
	
	private void set_click_event()
	{
		
		/*
		 * @chsun  设置搜索点击事件的响应
		 * 
		 */
		searchButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(!clickSearch)
				{
					
					Log.d("tiaoshi", "in the search click");
					testLayout.setVisibility(0);
					clickSearch=true;
				}
				else 
				{
					testLayout.setVisibility(8);
					clickSearch=false;
				}
				
			}
		});		
			
		
		listView.setOnChildClickListener(new OnChildClickListener() {
			
			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				// TODO Auto-generated method stub
				Log.d("child", "be clicked");
				return false;
			}
		});
		
		listView.setOnGroupClickListener(new OnGroupClickListener() {
			
			@Override
			public boolean onGroupClick(ExpandableListView parent, View v,
					int groupPosition, long id) {
				// TODO Auto-generated method stub
				Log.d("group", "be clicked");
				if(!isLongPause)
				{
					TelegramData showData=(TelegramData)adapter.getGroup(groupPosition);
					//	Log.d("fds",showData.getTheme());
					//	Log.d("fds",showData.getContent());
						
						Intent intent=new Intent(MainActivity.this,Show_info_activity.class);
						intent.putExtra("show_theme", showData.getTheme());
						intent.putExtra("show_content", showData.getContent());
						startActivity(intent);
				}
				
				isLongPause=false;				 //用于屏蔽单击事件
				return true; //返回true的时候不展开  返回false的时候展开组列表
			}
		});	
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		switch (id) {
		case R.id.action_select_all:
			group_select_all();
			return true;
		case R.id.action_select_all_not:
			group_select_all_not();
			return true;
		case R.id.action_Unselected:
			group_select_unselect();
			return true;
		case R.id.action_cancel:
			group_select_cancell();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private void group_select_all()
	{
		for(int i=0;i<groupResource.size();i++)
			listView.setItemChecked(i, true);
		//return;
	}
	private void group_select_all_not()
	{
		for(int i=0;i<groupResource.size();i++)
			listView.setItemChecked(i, false);
	}
	private void group_select_unselect()
	{
		for(int i=0;i<groupResource.size();i++)
			if(listView.isItemChecked(i))
				listView.setItemChecked(i, false);
			else {
				listView.setItemChecked(i, true);
			}			
	}
	private void group_select_cancell()  //当点击取消的时候  这个时候需要将actionbar隐藏  原来的part1的布局显示  将所有的组项的选中状态设置为未选中  清除标记action第一次显示的情况
	{
		actionBar.hide();
		part1.setVisibility(0);
		group_select_all_not();
		isFirstShowActionBar=false;
	}

}

