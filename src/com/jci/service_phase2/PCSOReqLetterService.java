package com.jci.service_phase2;

import java.util.List;

import com.jci.model.PCSORequestLetter;

public interface PCSOReqLetterService {
	
	public void create(PCSORequestLetter requestLetter);
	public List<PCSORequestLetter> getLetters();
	public void delete(int id);
	public List<PCSORequestLetter> getTopThreeRecords(String cropString);
	public void setEmailStatus(int id, int i);
	public double getTotalContractedQty(String cropYearString);
}
