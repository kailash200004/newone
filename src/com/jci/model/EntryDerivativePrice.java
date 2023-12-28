package com.jci.model;

import java.util.Date;

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
	private String delivery_type;
	private String state_id;
	private String state_name;
	private String state;

	private String district;
	private String district_id;
	private String district_name;
	private int created_by;
	private String status;
	private Date creation_date;
	private String jute_variety;
	private String grade1;
	private String grade2;
	private String grade3;
	private String grade4;
	private String grade5;
	private String grade6;
    private Date updateDateAndTimeDate;
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

	public String getState_name() {
		return state_name;
	}

	public void setState_name(String state_name) {
		this.state_name = state_name;
	}

	public String getDistrict_name() {
		return district_name;
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

	public void setDistrict_name(String district_name) {
		this.district_name = district_name;
	}


	public int getDer_id() {
		return der_id;
	}

	@Override
	public String toString() {
		return "EntryDerivativePrice [der_id=" + der_id + ", crop_year=" + crop_year + ", delivery_type="
				+ delivery_type + ", state_id=" + state_id + ", state_name=" + state_name + ", district_id="
				+ district_id + ", district_name=" + district_name + ", created_by=" + created_by + ", status=" + status
				+ ", creation_date=" + creation_date + ", jute_variety=" + jute_variety + ", grade1=" + grade1
				+ ", grade2=" + grade2 + ", grade3=" + grade3 + ", grade4=" + grade4 + ", grade5=" + grade5
				+ ", grade6=" + grade6 + "]";
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

	public int getCreated_by() {
		return created_by;
	}

	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date created_Date) {
		this.creation_date = created_Date;
	}
	
	public Date getUpdateDateAndTime() {
		return updateDateAndTimeDate;
	}
	
	public void setUpdateDateAndTime(Date updatedDate) {
		this.updateDateAndTimeDate = updatedDate;
	}

	public String getJute_variety() {
		return jute_variety;
	}

	public void setJute_variety(String jute_variety) {
		this.jute_variety = jute_variety;
	}

	public String getGrade1() {
		return grade1;
	}

	public void setGrade1(String grade1) {
		this.grade1 = grade1;
	}

	public String getGrade2() {
		return grade2;
	}

	public void setGrade2(String grade2) {
		this.grade2 = grade2;
	}

	public String getGrade3() {
		return grade3;
	}

	public void setGrade3(String grade3) {
		this.grade3 = grade3;
	}

	public String getGrade4() {
		return grade4;
	}

	public void setGrade4(String grade4) {
		this.grade4 = grade4;
	}

	public String getGrade5() {
		return grade5;
	}

	public void setGrade5(String grade5) {
		this.grade5 = grade5;
	}

	public String getGrade6() {
		return grade6;
	}

	public void setGrade6(String grade6) {
		this.grade6 = grade6;
	}

}