package com.dogancankilic.rxjavaretrofitplayground.Model;

import com.google.gson.annotations.SerializedName;

public class Model {

	@SerializedName("date")
	private String date;

	@SerializedName("copyright")
	private String copyright;

	@SerializedName("media_type")
	private String mediaType;

	@SerializedName("hdurl")
	private String hdurl;

	@SerializedName("service_version")
	private String serviceVersion;

	@SerializedName("explanation")
	private String explanation;

	@SerializedName("title")
	private String title;

	@SerializedName("url")
	private String url;

	public String getDate(){
		return date;
	}

	public String getCopyright(){
		return copyright;
	}

	public String getMediaType(){
		return mediaType;
	}

	public String getHdurl(){
		return hdurl;
	}

	public String getServiceVersion(){
		return serviceVersion;
	}

	public String getExplanation(){
		return explanation;
	}

	public String getTitle(){
		return title;
	}

	public String getUrl(){
		return url;
	}
}