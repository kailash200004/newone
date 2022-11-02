package com.jci.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "[tbl_policeStation]", schema = "dbo")
public class PoliceStationModel
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "police_stationName")
	private String police_stationName ;

	@Column(name = "Block_name")
	private String Block_name;



	public String getpolice_stationName() {
		return police_stationName;
	}

	public void setpolice_stationName(String police_stationName) {
		this.police_stationName = police_stationName;
	}

	public String getBlock_name() {
		return Block_name;
	}

	public void setBlock_name(String Block_name) {
		this.Block_name = Block_name;
	}

}
