package com.jci.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jcientry_derivative_price", schema = "dbo")
public class EntryDerivativePriceModel {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "der_id")
   private int der_id;
   
   @Column(name = "crop_year")
   private String crop_year;
   
   @Column(name = "delivery_type")
   private String delivery_type;
   
   @Column(name = "state_id")
   private String state_id;
   
   @Column(name = "state_name")
   private String state_name;
   
   @Column(name = "district_id")
   private String district_id;
   
   @Column(name = "district_name")
   private String district_name;
   
   @Column(name = "created_by")
   private String created_by;
   
   @Column(name = "status")
   private int status;
   
   @Column(name = "creation_date")
   private String creation_date;
   
   @Column(name = "jute_variety")
   private String jute_variety;
   
   @Column(name = "rate")
   private String rate;
   
   @Column(name = "grade1")
   private double grade1;
   
   @Column(name = "grade2")
   private double grade2;
   
   @Column(name = "grade3")
   private double grade3;
   
   @Column(name = "grade4")
   private double grade4;
   
   @Column(name = "grade5")
   private double grade5;
   
   @Column(name = "grade6")
   private double grade6;

   
   
   
public String getState_name() {
	return state_name;
}

public void setState_name(String state_name) {
	this.state_name = state_name;
}

public String getDistrict_name() {
	return district_name;
}

public void setDistrict_name(String district_name) {
	this.district_name = district_name;
}

public String getRate() {
	return rate;
}

public void setRate(String rate) {
	this.rate = rate;
}

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

public String getDelivery_type() {
	return delivery_type;
}

public void setDelivery_type(String delivery_type) {
	this.delivery_type = delivery_type;
}



public String getState_id() {
	return state_id;
}

public void setState_id(String state_id) {
	this.state_id = state_id;
}

public String getDistrict_id() {
	return district_id;
}

public void setDistrict_id(String district_id) {
	this.district_id = district_id;
}

public String getCreated_by() {
	return created_by;
}

public void setCreated_by(String created_by) {
	this.created_by = created_by;
}

public int getStatus() {
	return status;
}

public void setStatus(int status) {
	this.status = status;
}

public String getCreation_date() {
	return creation_date;
}

public void setCreation_date(String creation_date) {
	this.creation_date = creation_date;
}

public String getJute_variety() {
	return jute_variety;
}

public void setJute_variety(String jute_variety) {
	this.jute_variety = jute_variety;
}

public double getGrade1() {
	return grade1;
}

public void setGrade1(double grade1) {
	this.grade1 = grade1;
}

public double getGrade2() {
	return grade2;
}

public void setGrade2(double grade2) {
	this.grade2 = grade2;
}

public double getGrade3() {
	return grade3;
}

public void setGrade3(double grade3) {
	this.grade3 = grade3;
}

public double getGrade4() {
	return grade4;
}

public void setGrade4(double grade4) {
	this.grade4 = grade4;
}

public double getGrade5() {
	return grade5;
}

public void setGrade5(double grade5) {
	this.grade5 = grade5;
}

public double getGrade6() {
	return grade6;
}

public void setGrade6(double grade6) {
	this.grade6 = grade6;
}


@Override
public String toString() {
	return "EntryDerivativePriceModel [der_id=" + der_id + ", crop_year=" + crop_year + ", delivery_type="
			+ delivery_type + ", state_id=" + state_id + ", state_name=" + state_name + ", district_id=" + district_id
			+ ", district_name=" + district_name + ", created_by=" + created_by + ", status=" + status
			+ ", creation_date=" + creation_date + ", jute_variety=" + jute_variety + ", rate=" + rate + ", grade1="
			+ grade1 + ", grade2=" + grade2 + ", grade3=" + grade3 + ", grade4=" + grade4 + ", grade5=" + grade5
			+ ", grade6=" + grade6 + "]";
}


public EntryDerivativePriceModel(int der_id, String crop_year, String delivery_type, String state_id, String state_name,
		String district_id, String district_name, String created_by, int status, String creation_date,
		String jute_variety, String rate, double grade1, double grade2, double grade3, double grade4, double grade5,
		double grade6) {
	super();
	this.der_id = der_id;
	this.crop_year = crop_year;
	this.delivery_type = delivery_type;
	this.state_id = state_id;
	this.state_name = state_name;
	this.district_id = district_id;
	this.district_name = district_name;
	this.created_by = created_by;
	this.status = status;
	this.creation_date = creation_date;
	this.jute_variety = jute_variety;
	this.rate = rate;
	this.grade1 = grade1;
	this.grade2 = grade2;
	this.grade3 = grade3;
	this.grade4 = grade4;
	this.grade5 = grade5;
	this.grade6 = grade6;
}

public EntryDerivativePriceModel() {
	super();
	// TODO Auto-generated constructor stub
}
   
   
}
