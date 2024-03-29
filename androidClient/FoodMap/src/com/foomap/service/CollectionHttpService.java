package com.foomap.service;

import java.util.HashMap;
import android.content.Context;



public class CollectionHttpService  extends HttpServiceHelper{
	
    private final String BASE_URL = SERVICE_URL+"collection/";
	private final String GET_URL=BASE_URL+"collection_get";
	private final String ADD_URL=BASE_URL+"collection_add";
	private final String DEL_URL=BASE_URL+"collection_delete";
	private final String CHECK_URL=BASE_URL+"collection_iscollect";
	
	public CollectionHttpService(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	//获得收藏数据
	public void getCollection(String userId,IOnHttpRequeseListener listener)
	{
	   HashMap<String, String> map=new HashMap<String, String>();
	   map.put("userId", userId);
	   setRequestListener(listener);
	   get_Asyn(GET_URL, map);
	}
	//添加收藏
	public void add(String userId,int shopId,IOnHttpRequeseListener listener)
	{
		  HashMap<String, String> map=new HashMap<String, String>();
		  setRequestListener(listener);
		  map.put("userId", userId);
		  map.put("shopId", shopId+"");
		  get_Asyn(ADD_URL, map);
	}
	//取消收藏
	public void del(String userId,int shopId,IOnHttpRequeseListener listener)
	{
		  HashMap<String, String> map=new HashMap<String, String>();
		  setRequestListener(listener);
		  map.put("userId", userId);
		  map.put("shopId", shopId+"");
		  get_Asyn(DEL_URL, map);
	}
	//判断是否收藏
	public void isCollection(String userId,int shopId,IOnHttpRequeseListener listener)
	{
		  HashMap<String, String> map=new HashMap<String, String>();
		  setRequestListener(listener);
		  map.put("userId", userId);
		  map.put("shopId", shopId+"");
		  get_Asyn(CHECK_URL, map);
	}
	
	
	
	@Override
	protected String postMethod() {
		// TODO Auto-generated method stub
		return null;
	}

}
