package com.jci.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "jcirop", schema = "dbo")
public class RopeMakingModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rpmrefid")
	private int rpmrefid;

	@Column(name = "datereport")
	private Date datereport;

	@Column(name="basis")
	private String basis;

	@Column(name="cropyr")
	private String cropyr;

	@Column(name="placeofactivity")
	private String placeofactivity;

	@Column(name="binno")
	private String binno;

	@Column(name="jutevariety")
	private  String jutevariety;

	@Column(name="createddate")
	private Date createddate;

	@Column(name="createdfrom")
	private  String createdfrom;

	@Column(name="creadtedby")
	private  int creadtedby;

	@Column(name="ipaddress")
	private  String ipaddress;

	@Column(name="ropemade")
	private  String ropemade;

	@Column(name="ropeused")
	private  String ropeused;
	@Column(name="rope_balance")
	private  String rope_balance;

	@Transient
	@JsonInclude
	String dpc;

	public RopeMakingModel() {

	}

	public String getDpc() {
		return dpc;
	}

	public void setDpc(String dpc) {
		this.dpc = dpc;
	}

	public int getRpmrefid() {
		return rpmrefid;
	}


	public void setRpmrefid(int rpmrefid) {
		this.rpmrefid = rpmrefid;
	}


	public Date getDatereport() {
		return datereport;
	}


	public void setDatereport(Date datereport) {
		this.datereport = datereport;
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


	public String getPlaceofactivity() {
		return placeofactivity;
	}


	public void setPlaceofactivity(String placeofactivity) {
		this.placeofactivity = placeofactivity;
	}


	public String getBinno() {
		return binno;
	}


	public void setBinno(String binno) {
		this.binno = binno;
	}


	public String getJutevariety() {
		return jutevariety;
	}


	public void setJutevariety(String jutevariety) {
		this.jutevariety = jutevariety;
	}


	public Date getCreateddate() {
		return createddate;
	}


	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}


	public String getCreatedfrom() {
		return createdfrom;
	}


	public void setCreatedfrom(String createdfrom) {
		this.createdfrom = createdfrom;
	}


	public int getCreadtedby() {
		return creadtedby;
	}


	public void setCreadtedby(int creadtedby) {
		this.creadtedby = creadtedby;
	}


	public String getIpaddress() {
		return ipaddress;
	}


	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}


	public String getRopemade() {
		return ropemade;
	}


	public void setRopemade(String ropemade) {
		this.ropemade = ropemade;
	}


	public String getRopeused() {
		return ropeused;
	}


	public void setRopeused(String ropeused) {
		this.ropeused = ropeused;
	}


	public String getRope_balance() {
		return rope_balance;
	}


	public void setRope_balance(String rope_balance) {
		this.rope_balance = rope_balance;
	}

	public RopeMakingModel(int rpmrefid, Date datereport, String basis, String cropyr, String  placeofactivity,
			String binno, String jutevariety, Date createddate, String createdfrom, int creadtedby, String ipaddress,
			String ropemade, String ropeused, String rope_balance) {
		this.rpmrefid = rpmrefid;
		this.datereport = datereport;
		this.basis = basis;
		this.cropyr = cropyr;
		this.placeofactivity = placeofactivity;
		this.binno = binno;
		this.jutevariety = jutevariety;
		this.createddate = createddate;
		this.createdfrom = createdfrom;
		this.creadtedby = creadtedby;
		this.ipaddress = ipaddress;
		this.ropemade = ropemade;
		this.ropeused = ropeused;
		this.rope_balance = rope_balance;
	}

	@Override
	public String toString() {
		return "RopeMakingModel [rpmrefid=" + rpmrefid + ", datereport=" + datereport + ", basis=" + basis + ", cropyr="
				+ cropyr + ", placeofactivity=" + placeofactivity + ", binno=" + binno + ", jutevariety=" + jutevariety
				+ ", createddate=" + createddate + ", createdfrom=" + createdfrom + ", creadtedby=" + creadtedby
				+ ", ipaddress=" + ipaddress + ", ropemade=" + ropemade + ", ropeused=" + ropeused + ", rope_balance="
				+ rope_balance + "]";
	}

}
