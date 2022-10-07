package com.ideas2it.employeemanagement.model;

/**
 * It presents employee details.
 * 
 * @version	1.0.2
 * @author	suganya J
 */
public class Address {
    
    private String firstLine;
    private String secondLine;
    private String city;
    private String district;
    private String state;
    private String pinCode;
    private String addressType;
 
    public void setFirstLine(String firstLine) {

        this.firstLine = firstLine;
    } 
    
    public String getFirstLine() {

        return firstLine;
    }  

    public void setSecondLine(String secondLine) {

        this.secondLine = secondLine;
    } 
    
    public String getSecondLine() {

        return secondLine;
    } 

    public void setCity(String city) {

        this.city = city;
    } 
    
    public String getCity() {

        return city;
    } 

    public void setDistrict(String district) {

        this.district = district;
    } 
    
    public String getDistrict() {

        return district;
    } 

    public void setState(String state) {

        this.state = state;
    } 
    
    public String getState() {

        return state;
    } 

    public void setPinCode(String pinCode) {

        this.pinCode = pinCode;
    } 
    
    public String getPinCode() {

        return pinCode;
    }

    public void setAddressType(String addressType) {

        this.addressType = addressType;
    } 
    
    public String getAddressType() {

        return addressType;
    } 
	
	public String toString() {

        return  "\nAddress Line          : " + firstLine + "," + secondLine 
		        + "\nCity                  : "+ city
                + "\nDistrict              : "+ district 
                + "\nState                 : "+ state
                + "\npincode               : "+ pinCode
                + "\nAddress Type          : "+ addressType;
    }
}