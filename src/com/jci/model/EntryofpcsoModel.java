package com.jci.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Entity
@Table(name = "jcientryof_pcso", schema = "dbo")

public class EntryofpcsoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pcsorefid")
	private int pcsorefid;

	@Column(name = "reference_no",length = 256)
	@NotNull
	private String reference_no;

	@Column(name = "reference_date",length = 256)
	@Nullable
	private String reference_date;

	@Column(name = "pcso_date")
	@NotNull
	private String pcso_date;

	@Column(name = "letter_ref",length = 256)
	@NotNull
	private String letterRef;

	@Column(name = "Jute_ratio" , length = 256)
	@NotNull
	private String juteRatio;


	@Column(name = "Delivery_period" , length = 256)
	@NotNull
	private String deliveryPeriod;

	@Column(name = "Letter_path" , length = 256)
	@NotNull
	private String letterPath;

	@Column(name = "mill_code")
	@NotNull
	private String mill_code;

	@Column(name = "mill_name" , length = 256)
	@NotNull
	private String mill_name;

	@Column(name = "Allocated_qty")
	@NotNull
	private Double allocatedQty = 0.0;
	

	@Column(name = "pcso_qty")
	@NotNull
	private Double pcsoQty = 0.0;

	@Column(name = "created_date")
	private Date created_date;

	@Column(name = "Pcso_contract_flag")
	private int pcsoContractFlag = 0;

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

	public String getReference_date() {
		return reference_date;
	}

	public void setReference_date(String reference_date) {
		this.reference_date = reference_date;
	}

	public String getPcso_date() {
		return pcso_date;
	}

	public void setPcso_date(String pcso_date) {
		this.pcso_date = pcso_date;
	}

	public String getLetterRef() {
		return letterRef;
	}

	public void setLetterRef(String letterRef) {
		this.letterRef = letterRef;
	}

	public String getJuteRatio() {
		return juteRatio;
	}

	public void setJuteRatio(String juteRatio) {
		this.juteRatio = juteRatio;
	}

	public String getDeliveryPeriod() {
		return deliveryPeriod;
	}

	public void setDeliveryPeriod(String deliveryPeriod) {
		this.deliveryPeriod = deliveryPeriod;
	}

	public String getLetterPath() {
		return letterPath;
	}

	public void setLetterPath(String letterPath) {
		this.letterPath = letterPath;
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

	public Double getAllocatedQty() {
		return allocatedQty;
	}

	public void setAllocatedQty(Double allocatedQty) {
		this.allocatedQty = allocatedQty;
	}

	public Double getPcsoQty() {
		return pcsoQty;
	}

	public void setPcsoQty(Double pcsoQty) {
		this.pcsoQty = pcsoQty;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public int getPcsoContractFlag() {
		return pcsoContractFlag;
	}

	public void setPcsoContractFlag(int pcsoContractFlag) {
		this.pcsoContractFlag = pcsoContractFlag;
	}

	@Override
	public String toString() {
		return "EntryofpcsoModel [pcsorefid=" + pcsorefid + ", reference_no=" + reference_no + ", reference_date="
				+ reference_date + ", pcso_date=" + pcso_date + ", letterRef=" + letterRef + ", juteRatio=" + juteRatio
				+ ", deliveryPeriod=" + deliveryPeriod + ", letterPath=" + letterPath + ", mill_code=" + mill_code
				+ ", mill_name=" + mill_name + ", allocatedQty=" + allocatedQty + ", pcsoQty=" + pcsoQty
				+ ", created_date=" + created_date + ", pcsoContractFlag=" + pcsoContractFlag + "]";
	}

	public EntryofpcsoModel(int pcsorefid, String reference_no, String reference_date, String pcso_date,
			String letterRef, String juteRatio, String deliveryPeriod, String letterPath, String mill_code,
			String mill_name, Double allocatedQty, Double pcsoQty, Date created_date, int pcsoContractFlag) {
		super();
		this.pcsorefid = pcsorefid;
		this.reference_no = reference_no;
		this.reference_date = reference_date;
		this.pcso_date = pcso_date;
		this.letterRef = letterRef;
		this.juteRatio = juteRatio;
		this.deliveryPeriod = deliveryPeriod;
		this.letterPath = letterPath;
		this.mill_code = mill_code;
		this.mill_name = mill_name;
		this.allocatedQty = allocatedQty;
		this.pcsoQty = pcsoQty;
		this.created_date = created_date;
		this.pcsoContractFlag = pcsoContractFlag;
	}

	public EntryofpcsoModel() {
		super();
		// TODO Auto-generated constructor stub
	}
}

