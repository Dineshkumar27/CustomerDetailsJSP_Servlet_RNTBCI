package com.jsptraining;

public class Customer {
private String customerName;
private String customerCity;
private boolean isPrivileged;
public Customer(String customerName, String customerCity, boolean isPriviledged) {
	super();
	this.customerName = customerName;
	this.customerCity = customerCity;
	this.isPrivileged = isPrivileged;
}
public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
public String getCustomerCity() {
	return customerCity;
}
public void setCustomerCity(String customerCity) {
	this.customerCity = customerCity;
}
public boolean isPrivileged() {
	return isPrivileged;
}
public void setPriviledged(boolean isPrivileged) {
	this.isPrivileged = isPrivileged;
}

}
