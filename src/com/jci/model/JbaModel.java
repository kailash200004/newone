package com.jci.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jcijba", schema = "dbo")
public class JbaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "jbaid")
	private int id;
	@Column(name = "jbaDate")
	private String jbaDate;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJbaDate() {
		return jbaDate;
	}
	public void setJbaDate(String jbaDate) {
		this.jbaDate = jbaDate;
	}
	public String getCropyr() {
		return cropyr;
	}
	public void setCropyr(String cropyr) {
		this.cropyr = cropyr;
	}

	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getGradeWisePrice() {
		return gradeWisePrice;
	}
	public void setGradeWisePrice(String gradeWisePrice) {
		this.gradeWisePrice = gradeWisePrice;
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
	public void setJutevariety(String jutevariety) {
		this.jutevariety = jutevariety;
	}

	@Column(name="jutevariety")
	private String jutevariety;

	@Column(name="cropyr")
	private String cropyr;

	@Column(name="areaCode")
	private  String areaCode;

	@Column(name="gradeWisePrice")
	private  String gradeWisePrice;

	@Column(name = "createddate")
	private Date createddate;

	@Column(name = "createdfrom")
	private String createdfrom;

	@Column(name = "creadtedby")
	private int creadtedby;

	@Column(name = "ipaddress")
	private String ipaddress;

	@Column(name="gradewisepp1")
	private  double gradewisepp1;

	@Column(name="gradewisepp2")
	private  double gradewisepp2;

	@Column(name="gradewisepp3")
	private  double gradewisepp3;

	@Column(name="gradewisepp4")
	private  double gradewisepp4;

	@Column(name="gradewisepp5")
	private  double gradewisepp5;

	@Column(name="gradewisepp6")
	private  double gradewisepp6;

	@Column(name="gradewisepp7")
	private  double gradewisepp7;

	@Column(name="gradewisepp8")
	private  double gradewisepp8;

	public JbaModel(int id, String jbaDate, String jutevariety, String cropyr, String areaCode, String gradeWisePrice,
			Date createddate, String createdfrom, int creadtedby, String ipaddress, double gradewisepp1,
			double gradewisepp2, double gradewisepp3, double gradewisepp4, double gradewisepp5, double gradewisepp6,
			double gradewisepp7, double gradewisepp8) {
		this.id = id;
		this.jbaDate = jbaDate;
		this.jutevariety = jutevariety;
		this.cropyr = cropyr;
		this.areaCode = areaCode;
		this.gradeWisePrice = gradeWisePrice;
		this.createddate = createddate;
		this.createdfrom = createdfrom;
		this.creadtedby = creadtedby;
		this.ipaddress = ipaddress;
		this.gradewisepp1 = gradewisepp1;
		this.gradewisepp2 = gradewisepp2;
		this.gradewisepp3 = gradewisepp3;
		this.gradewisepp4 = gradewisepp4;
		this.gradewisepp5 = gradewisepp5;
		this.gradewisepp6 = gradewisepp6;
		this.gradewisepp7 = gradewisepp7;
		this.gradewisepp8 = gradewisepp8;
	}
	public double getGradewisepp1() {
		return gradewisepp1;
	}
	public void setGradewisepp1(double gradewisepp1) {
		this.gradewisepp1 = gradewisepp1;
	}
	public double getGradewisepp2() {
		return gradewisepp2;
	}
	public void setGradewisepp2(double gradewisepp2) {
		this.gradewisepp2 = gradewisepp2;
	}
	public double getGradewisepp3() {
		return gradewisepp3;
	}
	public void setGradewisepp3(double gradewisepp3) {
		this.gradewisepp3 = gradewisepp3;
	}
	public double getGradewisepp4() {
		return gradewisepp4;
	}
	public void setGradewisepp4(double gradewisepp4) {
		this.gradewisepp4 = gradewisepp4;
	}
	public double getGradewisepp5() {
		return gradewisepp5;
	}
	public void setGradewisepp5(double gradewisepp5) {
		this.gradewisepp5 = gradewisepp5;
	}
	public double getGradewisepp6() {
		return gradewisepp6;
	}
	public void setGradewisepp6(double gradewisepp6) {
		this.gradewisepp6 = gradewisepp6;
	}
	public double getGradewisepp7() {
		return gradewisepp7;
	}
	public void setGradewisepp7(double gradewisepp7) {
		this.gradewisepp7 = gradewisepp7;
	}
	public double getGradewisepp8() {
		return gradewisepp8;
	}
	public void setGradewisepp8(double gradewisepp8) {
		this.gradewisepp8 = gradewisepp8;
	}
	public String getJutevariety() {
		return jutevariety;
	}
	public JbaModel() {

	}

	public JbaModel(int jbaid, String jbaDate, String jutevariety, String cropyr, String basis,
			String areaCode, String gradeWisePrice,Date createddate,
			String createdfrom, int creadtedby, String ipaddress) {
		this.id = jbaid;
		this.jbaDate = jbaDate;
		this.jutevariety = jutevariety;
		this.cropyr = cropyr;
		this.areaCode = areaCode;
		this.gradeWisePrice = gradeWisePrice;
		this.createddate = createddate;
		this.createdfrom = createdfrom;
		this.creadtedby = creadtedby;
		this.ipaddress = ipaddress;
	}

	@Override
	public String toString() {
		return "JbaModel [id=" + id + ", jbaDate=" + jbaDate + ", jutevariety=" + jutevariety + ", cropyr=" + cropyr
				+ ", areaCode=" + areaCode + ", gradeWisePrice=" + gradeWisePrice + ", createddate=" + createddate
				+ ", createdfrom=" + createdfrom + ", creadtedby=" + creadtedby + ", ipaddress=" + ipaddress
				+ ", gradewisepp1=" + gradewisepp1 + ", gradewisepp2=" + gradewisepp2 + ", gradewisepp3=" + gradewisepp3
				+ ", gradewisepp4=" + gradewisepp4 + ", gradewisepp5=" + gradewisepp5 + ", gradewisepp6=" + gradewisepp6
				+ ", gradewisepp7=" + gradewisepp7 + ", gradewisepp8=" + gradewisepp8 + "]";
	}
}