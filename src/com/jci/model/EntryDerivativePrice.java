package com.jci.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jcientry_derivative_price", schema = "dbo")
public class EntryDerivativePrice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int der_id;
   private String crop_year;
   private String delibry_type;
   private String state;
   private String district;
   private String created_by;
   private String status;
   private String creation_date;
   private String tgr1;
   private String tgr2;
   private String tgr3;
   private String tgr4;
   private String tgr5;
   private String wgr1;
   private String wgr2;
   private String wgr3;
   private String wgr4;
   private String wgr5;
   private String mgr1;
   private String mgr2;
   private String mgr3;
   private String mgr4;
   private String mgr5;
   private String mgr6;
   private String bgr1;
   private String  bgr2;
   private String bgr3;
   private String bgr4;
   private String bgr5;
   private String bgr6;
 
   
public int getDer_id() {
	return der_id;
}
public void setDer_id(int der_id) {
	this.der_id = der_id;
}
public String getCrop_year() {
	return crop_year;
}
public void setCrop_year(String crop_year) {
	this.crop_year = crop_year;
}
public String getDelibry_type() {
	return delibry_type;
}
public void setDelibry_type(String delibry_type) {
	this.delibry_type = delibry_type;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getDistrict() {
	return district;
}
public void setDistrict(String district) {
	this.district = district;
}

public String getCreated_by() {
	return created_by;
}
public void setCreated_by(String created_by) {
	this.created_by = created_by;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getCreation_date() {
	return creation_date;
}
public String setCreation_date(String creation_date) {
	return this.creation_date = creation_date;
}
public String getTgr1() {
	return tgr1;
}
public void setTgr1(String tgr1) {
	this.tgr1 = tgr1;
}
public String getTgr2() {
	return tgr2;
}
public void setTgr2(String tgr2) {
	this.tgr2 = tgr2;
}
public String getTgr3() {
	return tgr3;
}
public void setTgr3(String tgr3) {
	this.tgr3 = tgr3;
}
public String getTgr4() {
	return tgr4;
}
public void setTgr4(String tgr4) {
	this.tgr4 = tgr4;
}
public String getTgr5() {
	return tgr5;
}
public void setTgr5(String tgr5) {
	this.tgr5 = tgr5;
}
public String getWgr1() {
	return wgr1;
}
public void setWgr1(String wgr1) {
	this.wgr1 = wgr1;
}
public String getWgr2() {
	return wgr2;
}
public void setWgr2(String wgr2) {
	this.wgr2 = wgr2;
}
public String getWgr3() {
	return wgr3;
}
public void setWgr3(String wgr3) {
	this.wgr3 = wgr3;
}
public String getWgr4() {
	return wgr4;
}
public void setWgr4(String wgr4) {
	this.wgr4 = wgr4;
}
public String getWgr5() {
	return wgr5;
}
public void setWgr5(String wgr5) {
	this.wgr5 = wgr5;
}
public String getMgr1() {
	return mgr1;
}
public void setMgr1(String mgr1) {
	this.mgr1 = mgr1;
}
public String getMgr2() {
	return mgr2;
}
public void setMgr2(String mgr2) {
	this.mgr2 = mgr2;
}
public String getMgr3() {
	return mgr3;
}
public void setMgr3(String mgr3) {
	this.mgr3 = mgr3;
}
public String getMgr4() {
	return mgr4;
}
public void setMgr4(String mgr4) {
	this.mgr4 = mgr4;
}
public String getMgr5() {
	return mgr5;
}
public void setMgr5(String mgr5) {
	this.mgr5 = mgr5;
}
public String getMgr6() {
	return mgr6;
}
public void setMgr6(String mgr6) {
	this.mgr6 = mgr6;
}
public String getBgr1() {
	return bgr1;
}
public void setBgr1(String bgr1) {
	this.bgr1 = bgr1;
}
public String getBgr2() {
	return bgr2;
}
public void setBgr2(String bgr2) {
	this.bgr2 = bgr2;
}
public String getBgr3() {
	return bgr3;
}
public void setBgr3(String bgr3) {
	this.bgr3 = bgr3;
}
public String getBgr4() {
	return bgr4;
}
public void setBgr4(String bgr4) {
	this.bgr4 = bgr4;
}
public String getBgr5() {
	return bgr5;
}
public void setBgr5(String bgr5) {
	this.bgr5 = bgr5;
}
public String getBgr6() {
	return bgr6;
}
public void setBgr6(String bgr6) {
	this.bgr6 = bgr6;
}
@Override
public String toString() {
	return "EntryDerivativePrice [der_id=" + der_id + ", crop_year=" + crop_year + ", delibry_type=" + delibry_type
			+ ", state=" + state + ", district=" + district + ", created_by=" + created_by + ", status=" + status + ", creation_date=" + creation_date
			+ ", tgr1=" + tgr1 + ", tgr2=" + tgr2 + ", tgr3=" + tgr3 + ", tgr4=" + tgr4 + ", tgr5=" + tgr5 + ", wgr1="
			+ wgr1 + ", wgr2=" + wgr2 + ", wgr3=" + wgr3 + ", wgr4=" + wgr4 + ", wgr5=" + wgr5 + ", mgr1=" + mgr1
			+ ", mgr2=" + mgr2 + ", mgr3=" + mgr3 + ", mgr4=" + mgr4 + ", mgr5=" + mgr5 + ", mgr6=" + mgr6 + ", bgr1="
			+ bgr1 + ", bgr2=" + bgr2 + ", bgr3=" + bgr3 + ", bgr4=" + bgr4 + ", bgr5=" + bgr5 + ", bgr6=" + bgr6 + "]";
}
   
   
}
