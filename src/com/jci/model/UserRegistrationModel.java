package com.jci.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jciumt", schema = "dbo")
public class UserRegistrationModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "refid")
	private int refid;

	@Column(name="username")
	private String username;

	@Column(name="password")
	private String password;

	@Column(name="datelastchangepassword")
	private Date datelastchangepassword;

	@Column(name="updatedat")
	private Date updatedat;

	@Column(name="registrationdate")
	private Date registrationdate;


	@Column(name="lockedchances")
	private int lockedchances;


	@Column(name="is_active")
	private int is_active;

	@Column(name="ipaddress")
	private String ipaddress;

	@Column(name="ho")
	private int ho;

	@Column(name="zoneId")
	private String zone;

	@Column(name="regionId")
	private String region;

	@Column(name="dpcId")
	private String dpcId;

	@Column(name="employeeid")
	private String employeeid;

	@Column(name="employeename")
	private String employeename;

	@Column(name="email")
	private String email;

	@Column(name="mobileno")
	private String mobileno;

	@Column(name="usertype")
	private String usertype;


	@Column (name = "roleId")
	private int roleId;

	public UserRegistrationModel() {

	}

	public Date getUpdatedat() {
		return updatedat;
	}

	public void setUpdatedat(Date updatedat) {
		this.updatedat = updatedat;
	}

	public String getDpcId() {
		return dpcId;
	}







	public void setDpcId(String dpcId) {
		this.dpcId = dpcId;
	}







	public int getRoleId() {
		return roleId;
	}







	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}







	public int getRefid() {
		return refid;
	}

	public void setRefid(int refid) {
		this.refid = refid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDatelastchangepassword() {
		return datelastchangepassword;
	}

	public void setDatelastchangepassword(Date datelastchangepassword) {
		this.datelastchangepassword = datelastchangepassword;
	}

	public Date getInfoupdatedate() {
		return updatedat;
	}

	public void setInfoupdatedate(Date infoupdatedate) {
		this.updatedat = infoupdatedate;
	}

	public Date getRegistrationdate() {
		return registrationdate;
	}

	public void setRegistrationdate(Date registrationdate) {
		this.registrationdate = registrationdate;
	}


	public int getLockedchances() {
		return lockedchances;
	}

	public void setLockedchances(int lockedchances) {
		this.lockedchances = lockedchances;
	}

	public int getIs_active() {
		return is_active;
	}

	public void setIs_active(int is_active) {
		this.is_active = is_active;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public int getHo() {
		return ho;
	}

	public void setHo(int ho) {
		this.ho = ho;
	}

	public String getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Override
	public String toString() {
		return "UserRegistrationModel [refid=" + refid + ", username=" + username + ", password=" + password
				+ ", datelastchangepassword=" + datelastchangepassword + ", updatedat=" + updatedat
				+ ", registrationdate=" + registrationdate + ", lockedchances=" + lockedchances + ", is_active="
				+ is_active + ", ipaddress=" + ipaddress + ", ho=" + ho + ", zone=" + zone + ", region=" + region
				+ ", dpcId=" + dpcId + ", employeeid=" + employeeid + ", employeename=" + employeename + ", email="
				+ email + ", mobileno=" + mobileno + ", usertype=" + usertype + ", roleId=" + roleId + "]";
	}

	public UserRegistrationModel(int refid, String username, String password, Date datelastchangepassword,
			Date updatedat, Date registrationdate, int lockedchances, int is_active, String ipaddress, int ho,
			String zone, String region, String dpcId, String employeeid, String employeename, String email,
			String mobileno, String usertype, int roleId) {
		super();
		this.refid = refid;
		this.username = username;
		this.password = password;
		this.datelastchangepassword = datelastchangepassword;
		this.updatedat = updatedat;
		this.registrationdate = registrationdate;
		this.lockedchances = lockedchances;
		this.is_active = is_active;
		this.ipaddress = ipaddress;
		this.ho = ho;
		this.zone = zone;
		this.region = region;
		this.dpcId = dpcId;
		this.employeeid = employeeid;
		this.employeename = employeename;
		this.email = email;
		this.mobileno = mobileno;
		this.usertype = usertype;
		this.roleId = roleId;
	}







}
