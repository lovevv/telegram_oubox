package com.chsun.outbox;

import java.util.ArrayList;

import junit.framework.TestListener;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemLongClickListener;

public class Telegram_adapter extends BaseExpandableListAdapter{
	private ArrayList<TelegramData> groupList;
	private ArrayList<ArrayList<Telegram_child_item> >childList;
	private Context mContext;
	private int selectedGroupPosition = -1;
    private int selectedChildPosition = -1;
    private ExpandableListView listView;
   

  
    
    
	public Telegram_adapter(Context context,ArrayList<TelegramData> groupList, ArrayList<ArrayList<Telegram_child_item>> childList
			,ExpandableListView listView) {  //这里传入了一个listview的对象给构造函数  否则可以通过context来进行获取也是可以的
		// TODO Auto-generated constructor stub
		this.groupList=groupList;
		this.childList=childList;
		this.mContext=context;
		this.listView=listView;
	//	this.listView=listView;
	}
	
	@Override
	public Object getChild(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return childList.get(groupPosition).get(childPosition);
	}
	
	@Override
	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return childPosition;
	}
	
	public void setSelectedPosition(int selectedGroupPosition, int selectedChildPosition) {
        this.selectedGroupPosition = selectedGroupPosition;
        this.selectedChildPosition = selectedChildPosition;
    }
	

    @Override
    public int getChildrenCount(int groupPosition) {
    	// TODO Auto-generated method stub
    	return childList.get(groupPosition).size();
    }
     
    
    
     @Override
    public View getChildView(int groupPosition, int childPosition,
    		boolean isLastChild, View convertView, ViewGroup parent) {
    	// TODO Auto-generated method stub
    	 Telegram_child_item telegram_child_item=(Telegram_child_item)getChild(groupPosition, childPosition);
    	 View view;
    	 child_view_holder view_holder;
    	 
    	 
    	 if(convertView==null)
    	 {
    		 view=LayoutInflater.from(mContext).inflate(R.layout.telegramdata_child, null);
    		 view_holder=new child_view_holder();
    		 
    		 view_holder.maiImageView=(ImageView)view.findViewById(R.id.child_mail_state_image);
    		 view_holder.mailstate=(TextView)view.findViewById(R.id.child_mail_state);
    		 view_holder.apartemt_string=(TextView)view.findViewById(R.id.child_partment);
    		 view_holder.phone_string=(TextView)view.findViewById(R.id.child_telephone);
    		 view_holder.place_string=(TextView)view.findViewById(R.id.child_place);
    		 view_holder.time_string=(TextView)view.findViewById(R.id.child_read_time);
    		 view.setTag(view_holder);
    	 }
    	 else
    	 {
    		 view=convertView;
    		 view_holder=(child_view_holder)view.getTag();
    	 }
    	 
    	 
    	 view_holder.maiImageView.setImageResource(telegram_child_item.get_image());
    	 view_holder.mailstate.setText(telegram_child_item.get_state());
    	 view_holder.apartemt_string.setText(telegram_child_item.get_apartment());
    	 view_holder.phone_string.setText(telegram_child_item.get_phone());
    	 view_holder.place_string.setText(telegram_child_item.get_place());
    	 view_holder.time_string.setText(telegram_child_item.get_time());
    	 
    	 
    	 
    	 view.setTag(R.id.child_mail_state, groupPosition);
    	 view.setTag(R.id.child_mail_state_image, childPosition);
    	 return view;   	
    }
     
    class child_view_holder
    {
    	ImageView maiImageView;
    	TextView mailstate;
    	TextView apartemt_string;
    	TextView phone_string;
    	TextView place_string;
    	TextView time_string;
    }
   
 ////////////////////////////////////////////////////////////////////////////////////////////
     
     @Override
    public Object getGroup(int groupPosition) {
    	// TODO Auto-generated method stub
    	 return groupList.get(groupPosition);
    }
     
     
 	
 	
 	
    @Override
    public int getGroupCount() {
    	// TODO Auto-generated method stub
    	return groupList.size();
    }
    
    @Override
    public long getGroupId(int groupPosition) {
    	// TODO Auto-generated method stub
    	return groupPosition;
    }
    
    @Override
    public View getGroupView(int groupPosition, final boolean isExpanded,
    		View convertView, ViewGroup parent) {
    	// TODO Auto-generated method stub
    	View view;
    	TelegramData groupData=(TelegramData)getGroup(groupPosition);
    	group_view_holder view_holder;
    	
    	if(convertView==null)
    	{
    		view=LayoutInflater.from(mContext).inflate(R.layout.telegramdata_group, null);
    		view_holder=new group_view_holder();
    		
    		view_holder.mail_level=(TextView)view.findViewById(R.id.group_level_title);
    		view_holder.theme_string=(TextView)view.findViewById(R.id.group_theme_textview);
    		view_holder.context_string=(TextView)view.findViewById(R.id.group_content_textview);
    		view_holder.addition_imageView=(ImageView)view.findViewById(R.id.group_additon_image);
        	
    		view_holder.receive_string=(TextView)view.findViewById(R.id.group_receiver);
        	
    		view_holder.imageView=(ImageView)view.findViewById(R.id.group_ispand);
        	
    		view_holder.imageView.setOnClickListener(new mOnClickListener(groupPosition,isExpanded	,view_holder.imageView));
    		view_holder.time_string=(TextView)view.findViewById(R.id.group_time);
    		 
    		MainActivity activity = (MainActivity)mContext;
        	// listView=
    		view_holder.group_listView=activity.getListView();
    		view.setTag(view_holder); //将这个存储在其中
    	}
    	else {
			view=convertView;
			view_holder=(group_view_holder)view.getTag();
		}
    	
    	
    	 
    	view_holder.mail_level.setText(groupData.getLevel());
    	view_holder.theme_string.setText(groupData.getTheme());
    	view_holder.context_string.setText(groupData.getContent());
    	view_holder.addition_imageView.setImageResource(groupData.getAddition());
    	view_holder.receive_string.setText(groupData.getReceiver());
    	// imageView.setImageResource(groupData.getExpandImage());
    	view_holder.time_string.setText(groupData.getTime());
    	 
    	 view.setTag(R.id.child_mail_state, groupPosition);
    	 view.setTag(R.id.child_mail_state_image, -1);
    	 
    	 
    	
    	 
    	
    		 if(view_holder.group_listView.isItemChecked(groupPosition))
    		 {
    			 Log.d("in the groupview", "item chicked");
    			 view.setBackgroundColor(Color.GREEN);
    		 }
    		 else 
    		 {
    			 view.setBackgroundColor(Color.WHITE);
    		 }
    	 
    	return view;
    }
    
    class group_view_holder
  	 {
    	TextView mail_level;
    	TextView theme_string;
    	TextView context_string;
    	ImageView addition_imageView;
    	TextView receive_string;
    	ImageView imageView;
    	TextView time_string;
    	ExpandableListView group_listView;
  	 }
    
    
    
    
    private class mOnClickListener implements OnClickListener
    {
    	int groupPosition;
    	boolean isExpanded = true;
    	ImageView imageView;
    //	MainActivity activity = (MainActivity)mContext;
    	public mOnClickListener(int groupPosition,boolean isExpand,ImageView imageView)
    	{
    		this.groupPosition = groupPosition;
    		this.isExpanded=isExpand;
    		this.imageView=imageView;
    	}
    	@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Log.d("fdsfd", "hello ");
			if(isExpanded==true)
			{
				//修改图
				listView.collapseGroup(groupPosition);
				imageView.setImageResource(R.drawable.retract);
				isExpanded = false;
			}
			else
			{
				Log.d("fdsfd", "sbssbbsb");
				listView.expandGroup(groupPosition);
				imageView.setImageResource(R.drawable.spread);	
				
				isExpanded = true;
			}
			
		}   	
    }
    
    
    @Override
    public boolean hasStableIds() {
    	// TODO Auto-generated method stub
    	return true;
    }
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
    	// TODO Auto-generated method stub
    	return true;
    }
    
     
     
}
