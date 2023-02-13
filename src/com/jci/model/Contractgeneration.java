package com.jci.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jcicontractgeneration", schema = "dbo")
public class Contractgeneration {
	@Id
	@Column(name="contract_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int contract_id;
	private String contract_number;
	private String contract_date;
	private String full_contactnumber;
	private String crop_year;
	private String variety_gradewisequantity;
	private String delibry_type;
	private String created_date;
	
	
	public Contractgeneration() {
		
	}
	
	



	public Contractgeneration(int contract_id, String contract_number, String contract_date, String full_contactnumber,
			String crop_year, String variety_gradewisequantity, String delibry_type, String created_date) {
		super();
		this.contract_id = contract_id;
		this.contract_number = contract_number;
		this.contract_date = contract_date;
		this.full_contactnumber = full_contactnumber;
		this.crop_year = crop_year;
		this.variety_gradewisequantity = variety_gradewisequantity;
		this.delibry_type = delibry_type;
		this.created_date = created_date;
	}





	public String getCreated_date() {
		return created_date;
	}


	public String setCreated_date(String created_date) {
		return this.created_date = created_date;
	}


	public int getContract_id() {
		return contract_id;
	}
	public void setContract_id(int contract_id) {
		this.contract_id = contract_id;
	}
	public String getContract_number() {
		return contract_number;
	}
	public void setContract_number(String contract_number) {
		this.contract_number = contract_number;
	}
	public String getContract_date() {
		return contract_date;
	}
	public void setContract_date(String contract_date) {
		this.contract_date = contract_date;
	}
	public String getFull_contactnumber() {
		return full_contactnumber;
	}
	public void setFull_contactnumber(String full_contactnumber) {
		this.full_contactnumber = full_contactnumber;
	}
	public String getCrop_year() {
		return crop_year;
	}
	public void setCrop_year(String crop_year) {
		this.crop_year = crop_year;
	}
	public String getVariety_gradewisequantity() {
		return variety_gradewisequantity;
	}
	public void setVariety_gradewisequantity(String variety_gradewisequantity) {
		this.variety_gradewisequantity = variety_gradewisequantity;
	}
	public String getDelibry_type() {
		return delibry_type;
	}
	public void setDelibry_type(String delibry_type) {
		this.delibry_type = delibry_type;
	}





	@Override
	public String toString() {
		return "Contractgeneration [contract_id=" + contract_id + ", contract_number=" + contract_number
				+ ", contract_date=" + contract_date + ", full_contactnumber=" + full_contactnumber + ", crop_year="
				+ crop_year + ", variety_gradewisequantity=" + variety_gradewisequantity + ", delibry_type="
				+ delibry_type + ", created_date=" + created_date + "]";
	}

	
	
	
	
}
