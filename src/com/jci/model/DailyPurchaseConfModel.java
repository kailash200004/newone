package com.jci.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="jcidpc", schema="dbo")
public class DailyPurchaseConfModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="dpcid")
	private int dpcid;

	@Column(name="formno")
	private String formno;

	@Column(name="datepurchase")
	private Date datepurchase;

	@Column(name="basis")
	private String basis;

	@Column(name="cropyr")
	private String cropyr;

	@Column(name="placeofpurchase")
	private String placeofpurchase;

	@Column(name="binno")
	private int binno;

	@Column(name="jutevariety")
	private String jutevariety;

	@Column(name="gquantity")
	private double gquantity;

	@Column(name="dquantity")
	private double dquantity;

	@Column(name="netquantity")
	private double netquantity;

	@Column(name="fibervalue")
	private int fibervalue;

	@Column(name="grade1")
	private double grade1;

	@Column(name="grade2")
	private double grade2;

	@Column(name="grade3")
	private double grade3;

	@Column(name="grade4")
	private double grade4;

	@Column(name="grade5")
	private double grade5;

	@Column(name="grade6")
	private double grade6;

	@Column(name="grade7")
	private double grade7;

	@Column(name="grade8")
	private double grade8;

	@Column(name="ipaddress")
	private String ipaddress;

	@Column(name="createdby")
	private int createdby;

	@Column(name="rateslipno")
	private String rateslipno;

	public DailyPurchaseConfModel() {

	}

	public DailyPurchaseConfModel(int dpcid, String formno, Date datepurchase, String basis, String cropyr,
			String placeofpurchase, int binno, String jutevariety, double gquantity, double dquantity,
			double netquantity, int fibervalue, String ipaddresss, int createdby,
			String ipaddress, String rateslipno) {
		this.dpcid = dpcid;
		this.formno = formno;
		this.datepurchase = datepurchase;
		this.basis = basis;
		this.cropyr = cropyr;
		this.placeofpurchase = placeofpurchase;
		this.binno = binno;
		this.jutevariety = jutevariety;
		this.gquantity = gquantity;
		this.dquantity = dquantity;
		this.netquantity = netquantity;
		this.fibervalue = fibervalue;

		this.ipaddress = ipaddress;
		this.createdby = createdby;
		this.ipaddress = ipaddress;
		this.rateslipno = rateslipno;
	}

	public int getDpcid() {
		return dpcid;
	}

	public void setDpcid(int dpcid) {
		this.dpcid = dpcid;
	}

	public String getFormno() {
		return formno;
	}

	public void setFormno(String formno) {
		this.formno = formno;
	}

	public Date getDatepurchase() {
		return datepurchase;
	}

	public void setDatepurchase(Date datepurchase) {
		this.datepurchase = datepurchase;
	}

	public String getBasis() {
		return basis;
	}

	public void setBasis(String basis) {
		this.basis = basis;
	}

	public String getCropyr() {
		return cropyr;
	}

	public void setCropyr(String cropyr) {
		this.cropyr = cropyr;
	}

	public String getPlaceofpurchase() {
		return placeofpurchase;
	}

	public void setPlaceofpurchase(String placeofpurchase) {
		this.placeofpurchase = placeofpurchase;
	}

	public int getBinno() {
		return binno;
	}

	public void setBinno(int binno) {
		this.binno = binno;
	}

	public String getJutevariety() {
		return jutevariety;
	}

	public void setJutevariety(String jutevariety) {
		this.jutevariety = jutevariety;
	}

	public double getGquantity() {
		return gquantity;
	}

	public void setGquantity(double gquantity) {
		this.gquantity = gquantity;
	}

	public double getDquantity() {
		return dquantity;
	}

	public void setDquantity(double dquantity) {
		this.dquantity = dquantity;
	}

	public double getNetquantity() {
		return netquantity;
	}

	public void setNetquantity(double netquantity) {
		this.netquantity = netquantity;
	}

	public int getFibervalue() {
		return fibervalue;
	}

	public void setFibervalue(int fibervalue) {
		this.fibervalue = fibervalue;
	}



	public String getIpaddresss() {
		return ipaddress;
	}

	public void setIpaddresss(String ipaddresss) {
		this.ipaddress = ipaddresss;
	}

	public int getCreatedby() {
		return createdby;
	}

	public void setCreatedby(int createdby) {
		this.createdby = createdby;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public String getRateslipno() {
		return rateslipno;
	}

	public void setRateslipno(String rateslipno) {
		this.rateslipno = rateslipno;
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

	public double getGrade7() {
		return grade7;
	}

	public void setGrade7(double grade7) {
		this.grade7 = grade7;
	}

	public double getGrade8() {
		return grade8;
	}

	public void setGrade8(double grade8) {
		this.grade8 = grade8;
	}


	@Override
	public String toString() {
		return "DailyPurchaseConfModel [dpcid=" + dpcid + ", formno=" + formno + ", datepurchase=" + datepurchase
				+ ", basis=" + basis + ", cropyr=" + cropyr + ", placeofpurchase=" + placeofpurchase + ", binno="
				+ binno + ", jutevariety=" + jutevariety + ", gquantity=" + gquantity + ", dquantity=" + dquantity
				+ ", netquantity=" + netquantity + ", fibervalue=" + fibervalue + ", grade1=" + grade1 + ", grade2="
				+ grade2 + ", grade3=" + grade3 + ", grade4=" + grade4 + ", grade5=" + grade5 + ", grade6=" + grade6
				+ ", grade7=" + grade7 + ", grade8=" + grade8 + ", ipaddress=" + ipaddress + ", createdby=" + createdby
				+ ", rateslipno=" + rateslipno + "]";
	}

}