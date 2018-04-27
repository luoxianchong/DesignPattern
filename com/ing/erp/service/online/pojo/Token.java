package com.ing.erp.service.online.pojo;

public class Token {
	
	private String shopNick;
	private String secret;
	private String session;
	
	public Token(String shopNick,String secret,String session){
		this.secret=secret;
		this.session=session;
		this.shopNick=shopNick;
	}
	
	public String getShopNick() {
		return shopNick;
	}
	public void setShopNick(String shopNick) {
		this.shopNick = shopNick;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}

}
