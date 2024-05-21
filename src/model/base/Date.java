/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.base;

/**
 *
 * @author anisl
 */

import java.io.Serializable;

public class Date implements Serializable{
	private int day;
	private int month;
	private int year;
	
	public Date(int d, int m, int y) {
		day = d;
		month = m;
		year = y;
	}
	public Date(String bdy) {
		String[] st=bdy.split("/");
		day=Integer.parseInt(st[0]);
		month=Integer.parseInt(st[1]);
		year=Integer.parseInt(st[2]);
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String toString() {
		return day + "/" + month + "/" + year;
	}
	

}