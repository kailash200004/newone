package com.jci.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jcimra", schema = "dbo")
public class MarketArrivalModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mrarefid")
	private int mrarefid;

	@Column(name = "dpc_code")
	private String dpcnames;

	@Column(name = "datearrival")
	private Date datearrival;

	@Column(name = "jutevariety")
	private String jutevariety;

	@Column(name = "cropyr")
	private String cropyr;

	@Column(name = "arrivedqty")
	private String arrivedqty;

	@Column(name = "mixmois")
	private String mixmois;

	@Column(name = "maxmois")
	private String maxmois;

	@Column(name = "region_id")
	private String region_id;

	@Column(name = "createddate")
	private Date createddate;


	@Column(name = "creadtedby")
	private int creadtedby;

	@Column(name = "no_arrival")
	private String no_arrival;
	
	@Column(name = "basis")
	private String basis;
	
	@Column(name = "grade1")
	private String grade1;
	
	@Column(name = "grade2")
	private String grade2;
	
	@Column(name = "grade3")
	private String grade3;
	
	@Column(name = "grade4")
	private String grade4;
	
	@Column(name = "grade5")
	private String grade5;
	
	@Column(name = "grade6")
	private String grade6;
	
	@Column(name = "grade7")
	private String grade7;
	
	@Column(name = "grade8")
	private String grade8;
	
	@Column(name = "grade_rate1")
	private int grade_rate1;
	
	@Column(name = "grade_rate2")
	private int grade_rate2;
	
	@Column(name = "grade_rate3")
	private int grade_rate3;
	
	@Column(name = "grade_rate4")
	private int grade_rate4;
	
	@Column(name = "grade_rate5")
	private int grade_rate5;
	
	@Column(name = "grade_rate6")
	private int grade_rate6;
	
	@Column(name = "grade_rate7")
	private int grade_rate7;
	
	@Column(name = "grade_rate8")
	private int grade_rate8;

	public int getMrarefid() {
		return mrarefid;
	}

	public void setMrarefid(int mrarefid) {
		this.mrarefid = mrarefid;
	}

	public String getDpcnames() {
		return dpcnames;
	}

	public void setDpcnames(String dpcnames) {
		this.dpcnames = dpcnames;
	}

	public Date getDatearrival() {
		return datearrival;
	}

	public void setDatearrival(Date datearrival) {
		this.datearrival = datearrival;
	}

	public String getJutevariety() {
		return jutevariety;
	}

	public void setJutevariety(String jutevariety) {
		this.jutevariety = jutevariety;
	}

	public String getCropyr() {
		return cropyr;
	}

	public void setCropyr(String cropyr) {
		this.cropyr = cropyr;
	}

	public String getArrivedqty() {
		return arrivedqty;
	}

	public void setArrivedqty(String arrivedqty) {
		this.arrivedqty = arrivedqty;
	}

	public String getMixmois() {
		return mixmois;
	}

	public void setMixmois(String mixmois) {
		this.mixmois = mixmois;
	}

	public String getMaxmois() {
		return maxmois;
	}

	public void setMaxmois(String maxmois) {
		this.maxmois = maxmois;
	}

	public String getRegion_id() {
		return region_id;
	}

	public void setRegion_id(String region_id) {
		this.region_id = region_id;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public int getCreadtedby() {
		return creadtedby;
	}

	public void setCreadtedby(int creadtedby) {
		this.creadtedby = creadtedby;
	}

	public String getNo_arrival() {
		return no_arrival;
	}

	public void setNo_arrival(String no_arrival) {
		this.no_arrival = no_arrival;
	}

	public String getBasis() {
		return basis;
	}

	public void setBasis(String basis) {
		this.basis = basis;
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

	public String getGrade7() {
		return grade7;
	}

	public void setGrade7(String grade7) {
		this.grade7 = grade7;
	}

	public String getGrade8() {
		return grade8;
	}

	public void setGrade8(String grade8) {
		this.grade8 = grade8;
	}

	public int getGrade_rate1() {
		return grade_rate1;
	}

	public void setGrade_rate1(int grade_rate1) {
		this.grade_rate1 = grade_rate1;
	}

	public int getGrade_rate2() {
		return grade_rate2;
	}

	public void setGrade_rate2(int grade_rate2) {
		this.grade_rate2 = grade_rate2;
	}

	public int getGrade_rate3() {
		return grade_rate3;
	}

	public void setGrade_rate3(int grade_rate3) {
		this.grade_rate3 = grade_rate3;
	}

	public int getGrade_rate4() {
		return grade_rate4;
	}

	public void setGrade_rate4(int grade_rate4) {
		this.grade_rate4 = grade_rate4;
	}

	public int getGrade_rate5() {
		return grade_rate5;
	}

	public void setGrade_rate5(int grade_rate5) {
		this.grade_rate5 = grade_rate5;
	}

	public int getGrade_rate6() {
		return grade_rate6;
	}

	public void setGrade_rate6(int grade_rate6) {
		this.grade_rate6 = grade_rate6;
	}

	public int getGrade_rate7() {
		return grade_rate7;
	}

	public void setGrade_rate7(int grade_rate7) {
		this.grade_rate7 = grade_rate7;
	}

	public int getGrade_rate8() {
		return grade_rate8;
	}

	public void setGrade_rate8(int grade_rate8) {
		this.grade_rate8 = grade_rate8;
	}
	
	 
	
	 


	
}









