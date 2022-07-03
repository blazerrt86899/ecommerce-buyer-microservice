package com.ecommerce.model;

public class AuthToken {

    private String token;
    private String username;
    private Integer buyerId;

    public AuthToken(){

    }

    public AuthToken(String token, String username,Integer buyerId){
        this.token = token;
        this.username = username;
        this.buyerId =  buyerId;
    }
    
    public Integer getBuyerId() {
		return buyerId;
	}
    public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}

    public AuthToken(String token){
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
