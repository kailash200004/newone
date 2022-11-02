package com.jci.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jcibalepreparation", schema = "dbo")
public class BalePreparation {

	@Id
	@Column(name="bale_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int baleId;

	@Column(name="packing_date")
	private Date packingDate;

	@Column(name="crop_year")
	private String cropYear;

	@Column(name="bin_no")
	private String binNo;

	@Column(name="basis")
	private String basis;

	@Column(name="jute_variety")
	private String juteVariety;

	@Column(name="slip_no_from")
	private String slipNoFrom;

	@Column(name="slip_no_to")
	private String slipNoTo;

	@Column(name="bale_no")
	private int bale_no;

	@Column(name="created_by")
	private int createdBy;

	@Column(name="status")
	private int status;

	@Column(name="creation_date")
	private Date creation_date;

	@Column(name="place_of_packing")
	private String placeOfPacking;

	@Column(name="jute_grade")
	private String jute_grade;

	@Column(name="grade1")
	private  double grade1;

	@Column(name="grade2")
	private  double grade2;

	@Column(name="grade3")
	private  double grade3;

	@Column(name="grade4")
	private  double grade4;

	@Column(name="grade5")
	private  double grade5;

	@Column(name="grade6")
	private  double grade6;

	@Column(name="grade7")
	private  double grade7;

	@Column(name="grade8")
	private  double grade8;


	public String getJute_grade() {
		return jute_grade;
	}

	public void setJute_grade(String jute_grade) {
		this.jute_grade = jute_grade;
	}

	public String getCropYear() {
		return cropYear;
	}

	public void setCropYear(String cropYear) {
		this.cropYear = cropYear;
	}

	public String getPlaceOfPacking() {
		return placeOfPacking;
	}

	public void setPlaceOfPacking(String placeOfPacking) {
		this.placeOfPacking = placeOfPacking;
	}

	public BalePreparation() {

	}

	public BalePreparation(int baleId, Date packingDate, String cropYear, String binNo, String basis,
			String juteVariety, String slipNoFrom, String slipNoTo, int bale_no, int createdBy, int status,
			Date creation_date, String placeOfPacking, String jute_grade, double grade1, double grade2, double grade3,
			double grade4, double grade5, double grade6, double grade7, double grade8) {
		this.baleId = baleId;
		this.packingDate = packingDate;
		this.cropYear = cropYear;
		this.binNo = binNo;
		this.basis = basis;
		this.juteVariety = juteVariety;
		this.slipNoFrom = slipNoFrom;
		this.slipNoTo = slipNoTo;
		this.bale_no = bale_no;
		this.createdBy = createdBy;
		this.status = status;
		this.creation_date = creation_date;
		this.placeOfPacking = placeOfPacking;
		this.jute_grade = jute_grade;
		this.grade1 = grade1;
		this.grade2 = grade2;
		this.grade3 = grade3;
		this.grade4 = grade4;
		this.grade5 = grade5;
		this.grade6 = grade6;
		this.grade7 = grade7;
		this.grade8 = grade8;
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

	public int getBaleId() {
		return baleId;
	}

	public void setBaleId(int baleId) {
		this.baleId = baleId;
	}

	public Date getPackingDate() {
		return packingDate;
	}

	public void setPackingDate(Date packingDate) {
		this.packingDate = packingDate;
	}

	public String getBinNo() {
		return binNo;
	}

	public void setBinNo(String binNo) {
		this.binNo = binNo;
	}

	public String getBasis() {
		return basis;
	}

	public void setBasis(String basis) {
		this.basis = basis;
	}

	public String getJuteVariety() {
		return juteVariety;
	}

	public void setJuteVariety(String juteVariety) {
		this.juteVariety = juteVariety;
	}

	public String getSlipNoFrom() {
		return slipNoFrom;
	}

	public void setSlipNoFrom(String slipNoFrom) {
		this.slipNoFrom = slipNoFrom;
	}

	public String getSlipNoTo() {
		return slipNoTo;
	}

	public void setSlipNoTo(String slipNoTo) {
		this.slipNoTo = slipNoTo;
	}

	public int getBale_no() {
		return bale_no;
	}

	public void setBale_no(int bale_no) {
		this.bale_no = bale_no;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	@Override
	public String toString() {
		return "BalePreparation [baleId=" + baleId + ", packingDate=" + packingDate + ", cropYear=" + cropYear
				+ ", binNo=" + binNo + ", basis=" + basis + ", juteVariety=" + juteVariety + ", slipNoFrom="
				+ slipNoFrom + ", slipNoTo=" + slipNoTo + ", bale_no=" + bale_no + ", createdBy=" + createdBy
				+ ", status=" + status + ", creation_date=" + creation_date + ", placeOfPacking=" + placeOfPacking
				+ ", jute_grade=" + jute_grade + ", grade1=" + grade1 + ", grade2=" + grade2 + ", grade3=" + grade3
				+ ", grade4=" + grade4 + ", grade5=" + grade5 + ", grade6=" + grade6 + ", grade7=" + grade7
				+ ", grade8=" + grade8 + "]";
	}
}
