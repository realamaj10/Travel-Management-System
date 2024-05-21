/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.base;

import java.io.Serializable;

public abstract class User implements Serializable {
	private int ID;
	public static int k=0;
	private String username;
	private String password;
	protected UserType type;
	public User(String user,String pass){
		ID=k++;
		username=user;
		password=pass;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserType getType() {
		return type;
	}
	public abstract void setType(UserType type);
	
}

