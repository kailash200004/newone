package com.jci.dao_phase2;

import java.util.List;

import com.jci.model.CreditNotes;
import com.jci.model.settlemetCnDnModel;

public interface CreditNoteGenerationDao {
	List<Object[]> getAllVerifiedWeighment();
	void create(CreditNotes creditNotes);
	List<CreditNotes> getAllCreditNotes();
	void chageStatusTo1(int id);
	int getCountRO(String ro);
	List<Object[]> getAllMillsOfContracts();
	List<Object[]> findDetails(String table, String contractNoString);
	public void saveSettlementOfCnDn(settlemetCnDnModel settlemetCnDnModel);
}
