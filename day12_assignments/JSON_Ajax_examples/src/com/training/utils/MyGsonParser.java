package com.training.utils;

import com.google.gson.Gson;

public class MyGsonParser {

	private Gson gsonParser;
	
	public MyGsonParser() {
		super();
		// TODO Auto-generated constructor stub
		
		this.gsonParser=new Gson();
	}
	
	public String transformToGson(Object srcObj)
	{
		return gsonParser.toJson(srcObj);
	}
	
	public Object gsonToJava(String srcString, Class cls)
	{
		return gsonParser.fromJson(srcString, cls);
	}

}
