package com.wl.authorization.model;

/**
 * Token的Model类，可以增加字段提高安全性，例如时间戳、url签名
 * @author wangliang
 *
 */
public class TokenModel {
	
	private Integer userId;
	private String token ;
	
	
	public TokenModel(Integer userId, String token) {
		super();
		this.userId = userId;
		this.token = token;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
}
