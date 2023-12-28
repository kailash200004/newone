package com.jci.model;
 

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jcisettlement_cndn", schema = "dbo")
public class settlemetCnDnModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int Initiation_ref_no;
	
	@Column(name = "Contract_no")
	public String contractNo;
	
	@Column(name = "Credit_note_no")
	public String creditNoteNo;
	
	@Column(name = "Debit_note_no")
	public String debitNoteNo;
	
	@Column(name = "Initiation_amt")
	public Double  initiationAmt;
	
	
	@Column(name = "Initiation_date")
	public Date initiateDate;


	public int getInitiation_ref_no() {
		return Initiation_ref_no;
	}


	public void setInitiation_ref_no(int initiation_ref_no) {
		Initiation_ref_no = initiation_ref_no;
	}


	public String getContractNo() {
		return contractNo;
	}


	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}


	public String getCreditNoteNo() {
		return creditNoteNo;
	}


	public void setCreditNoteNo(String creditNoteNo) {
		this.creditNoteNo = creditNoteNo;
	}


	public String getDebitNoteNo() {
		return debitNoteNo;
	}


	public void setDebitNoteNo(String debitNoteNo) {
		this.debitNoteNo = debitNoteNo;
	}


	public Double getInitiationAmt() {
		return initiationAmt;
	}


	public void setInitiationAmt(Double initiationAmt) {
		this.initiationAmt = initiationAmt;
	}


	public Date getInitiateDate() {
		return initiateDate;
	}


	public void setInitiateDate(Date initiateDate) {
		this.initiateDate = initiateDate;
	}


	@Override
	public String toString() {
		return "settlemetCnDnModel [Initiation_ref_no=" + Initiation_ref_no + ", contractNo=" + contractNo
				+ ", creditNoteNo=" + creditNoteNo + ", debitNoteNo=" + debitNoteNo + ", initiationAmt=" + initiationAmt
				+ ", initiateDate=" + initiateDate + "]";
	}


	public settlemetCnDnModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
