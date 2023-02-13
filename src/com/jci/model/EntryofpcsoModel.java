package com.jci.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "entryofpcso", schema = "dbo")

public class EntryofpcsoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pcsorefid")
	private int pcsorefid;
	
	@Column(name = "Reference_no")
	private String Reference_no;
	
	@Column(name = "Reference_date")
	private Date Reference_date;
	
	@Column(name = "pcso_date")
	private Date pcso_date;
	
	@Column(name = "mill_code")
	private String mill_code;
	
	@Column(name = "total_allocation")
	private String total_allocation;
	
	
	
	
	

	public EntryofpcsoModel() {
		// TODO Auto-generated constructor stub
	}

	public EntryofpcsoModel(int pcsorefid, String reference_no, Date reference_date, Date pcso_date, String mill_code,
			String total_allocation) {
		super();
		this.pcsorefid = pcsorefid;
		Reference_no = reference_no;
		Reference_date = reference_date;
		this.pcso_date = pcso_date;
		this.mill_code = mill_code;
		this.total_allocation = total_allocation;
	}

	public int getPcsorefid() {
		return pcsorefid;
	}

	public void setPcsorefid(int pcsorefid) {
		this.pcsorefid = pcsorefid;
	}

	public String getReference_no() {
		return Reference_no;
	}

	public void setReference_no(String reference_no) {
		Reference_no = reference_no;
	}

	public Date getReference_date() {
		return Reference_date;
	}

	public void setReference_date(Date reference_date) {
		Reference_date = reference_date;
	}

	public Date getPcso_date() {
		return pcso_date;
	}

	public void setPcso_date(Date pcso_date) {
		this.pcso_date = pcso_date;
	}

	public String getMill_code() {
		return mill_code;
	}

	public void setMill_code(String mill_code) {
		this.mill_code = mill_code;
	}

	public String getTotal_allocation() {
		return total_allocation;
	}

	public void setTotal_allocation(String total_allocation) {
		this.total_allocation = total_allocation;
	}

}
