package com.heraizen.domain;

import java.util.UUID;

public class Products {
	private String pid;
	private String pname;
	private double price;
	public Products(String pname, double price, String pid) {
		super();
		this.pid=pid;
		this.pname = pname;
		this.price = price;
	}
	public Products() {
		// TODO Auto-generated constructor stub
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}
