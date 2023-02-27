package com.jci.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jcientryofpcso", schema = "dbo")

public class EntryofpcsoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pcsorefid")
	private int pcsorefid;
	
	@Column(name = "reference_no")
	private String reference_no;
	
	@Column(name = "reference_date")
	private Date reference_date;
	
	@Column(name = "pcso_date")
	private Date pcso_date;
	
	@Column(name = "mill_code")
	private String mill_code;
	
	@Column(name = "mill_name")
	private String mill_name;
	
	@Column(name = "total_allocation")
	private String total_allocation;
	
	@Column(name = "created_date")
	private String created_date;
	
	@Column(name = "contract_generated")
	private int contract_generated;
	
	@Column(name = "sumof_totalallocation")
	private double sumof_totalallocation;
	

	public double getSumof_totalallocation() {
		return sumof_totalallocation;
	}

	public void setSumof_totalallocation(double sumof_totalallocation) {
		this.sumof_totalallocation = sumof_totalallocation;
	}

	public int getPcsorefid() {
		return pcsorefid;
	}

	public void setPcsorefid(int pcsorefid) {
		this.pcsorefid = pcsorefid;
	}

	public String getReference_no() {
		return reference_no;
	}

	public void setReference_no(String reference_no) {
		this.reference_no = reference_no;
	}

	public Date getReference_date() {
		return reference_date;
	}

	public void setReference_date(Date reference_date) {
		this.reference_date = reference_date;
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

	public String getMill_name() {
		return mill_name;
	}

	public void setMill_name(String mill_name) {
		this.mill_name = mill_name;
	}

	public String getTotal_allocation() {
		return total_allocation;
	}

	public void setTotal_allocation(String total_allocation) {
		this.total_allocation = total_allocation;
	}

	public String getCreated_date() {
		return created_date;
	}

	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	
	
	public int getContract_generated() {
		return contract_generated;
	}

	public void setContract_generated(int contract_generated) {
		this.contract_generated = contract_generated;
	}


	@Override
	public String toString() {
		return "EntryofpcsoModel [pcsorefid=" + pcsorefid + ", reference_no=" + reference_no + ", reference_date="
				+ reference_date + ", pcso_date=" + pcso_date + ", mill_code=" + mill_code + ", mill_name=" + mill_name
				+ ", total_allocation=" + total_allocation + ", created_date=" + created_date + ", contract_generated="
				+ contract_generated + ", sumof_totalallocation=" + sumof_totalallocation + "]";
	}

	
	public EntryofpcsoModel(int pcsorefid, String reference_no, Date reference_date, Date pcso_date, String mill_code,
			String mill_name, String total_allocation, String created_date, int contract_generated,
			double sumof_totalallocation) {
		super();
		this.pcsorefid = pcsorefid;
		this.reference_no = reference_no;
		this.reference_date = reference_date;
		this.pcso_date = pcso_date;
		this.mill_code = mill_code;
		this.mill_name = mill_name;
		this.total_allocation = total_allocation;
		this.created_date = created_date;
		this.contract_generated = contract_generated;
		this.sumof_totalallocation = sumof_totalallocation;
	}

	public EntryofpcsoModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
