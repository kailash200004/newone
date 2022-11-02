package com.jci.dao;

import java.util.List;

import com.jci.model.DailyPurchaseConfModel;

public interface DailyPurchaseConfDao {

	public void create(DailyPurchaseConfModel dailyPurchaseConfModel);
	public void update(DailyPurchaseConfModel dailyPurchaseConfModel);
	public DailyPurchaseConfModel edit(int id);
	public void delete(int id);
	public DailyPurchaseConfModel find(int id);
	public List <DailyPurchaseConfModel> getAll();
	public boolean submitform(DailyPurchaseConfModel dailyPurchaseConfModel);

}
