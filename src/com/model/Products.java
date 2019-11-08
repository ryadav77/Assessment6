package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Products {
	
@Id
@GeneratedValue
private int id;
private String name;
private int quantity;
private double price;
private String desc;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getDesc() {
	return desc;
}
public void setDesc(String desc) {
	this.desc = desc;
}
public Products() {
	
}
public Products(String name, int quantity, double price, String desc) {
	super();
	
	this.name = name;
	this.quantity = quantity;
	this.price = price;
	this.desc = desc;
}





}
