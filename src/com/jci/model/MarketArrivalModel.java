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

	@Column(name = "dpcnames")
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

	@Column(name = "esgradeoutturn")
	private String esgradeoutturn;

	@Column(name = "createddate")
	private Date createddate;

	@Column(name = "createdfrom")
	private String createdfrom;

	@Column(name = "creadtedby")
	private int creadtedby;

	@Column(name = "ipaddress")
	private String ipaddress;

	public MarketArrivalModel() {

	}

	public MarketArrivalModel(int mrarefid, String dpcnames, Date datearrival, String jutevariety, String cropyr,
			String arrivedqty, String mixmois, String maxmois, String esgradeoutturn, Date createddate,
			String createdfrom, int creadtedby, String ipaddress) {
		this.mrarefid = mrarefid;
		this.dpcnames = dpcnames;
		this.datearrival = datearrival;
		this.jutevariety = jutevariety;
		this.cropyr = cropyr;
		this.arrivedqty = arrivedqty;
		this.mixmois = mixmois;
		this.maxmois = maxmois;
		this.esgradeoutturn = esgradeoutturn;
		this.createddate = createddate;
		this.createdfrom = createdfrom;
		this.creadtedby = creadtedby;
		this.ipaddress = ipaddress;
	}

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

	public String getEsgradeoutturn() {
		return esgradeoutturn;
	}

	public void setEsgradeoutturn(String esgradeoutturn) {
		this.esgradeoutturn = esgradeoutturn;
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

	@Override
	public String toString() {
		return "MarketArrivalModel [mrarefid=" + mrarefid + ", dpcnames=" + dpcnames + ", datearrival=" + datearrival
				+ ", jutevariety=" + jutevariety + ", cropyr=" + cropyr + ", arrivedqty=" + arrivedqty + ", mixmois="
				+ mixmois + ", maxmois=" + maxmois + ", esgradeoutturn=" + esgradeoutturn + ", createddate="
				+ createddate + ", createdfrom=" + createdfrom + ", creadtedby=" + creadtedby + ", ipaddress="
				+ ipaddress + "]";
	}
}









