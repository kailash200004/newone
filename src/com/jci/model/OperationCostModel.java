package com.jci.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "operation_cost_master", schema = "dbo")
public class OperationCostModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cost_id")
	private int cost_id;

	@Column(name="cost_name")
	private String cost_name;

	public int getCost_id() {
		return cost_id;
	}

	public void setCost_id(int cost_id) {
		this.cost_id = cost_id;
	}

	public String getCost_name() {
		return cost_name;
	}

	public void setCost_name(String cost_name) {
		this.cost_name = cost_name;
	}

	public OperationCostModel(int cost_id, String cost_name) {
		super();
		this.cost_id = cost_id;
		this.cost_name = cost_name;
	}

	public OperationCostModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "OperationCostModel [cost_id=" + cost_id + ", cost_name=" + cost_name + "]";
	}
	
	
}
