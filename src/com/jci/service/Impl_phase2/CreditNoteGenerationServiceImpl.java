package com.jci.service.Impl_phase2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao_phase2.CreditNoteGenerationDao;
import com.jci.model.CreditNotes;
import com.jci.model.settlemetCnDnModel;
import com.jci.service_phase2.CreditNoteGenerationService;


@Service
public class CreditNoteGenerationServiceImpl implements CreditNoteGenerationService {

	@Autowired
	CreditNoteGenerationDao creditNoteGenerationDao;
	
	@Override
	public List<Object[]> getAllVerifiedWeighment() {
		return creditNoteGenerationDao.getAllVerifiedWeighment();
	}

	@Override
	public void create(CreditNotes creditNotes) {
	    creditNoteGenerationDao.create(creditNotes);
		
	}

	@Override
	public List<CreditNotes> getAllCreditNotes() {
		return creditNoteGenerationDao.getAllCreditNotes();
	}

	@Override
	public void chageStatusTo1(int id) {
	creditNoteGenerationDao.chageStatusTo1(id);
		
	}

	@Override
	public int getCountOfRo(String ro) {
		return creditNoteGenerationDao.getCountRO(ro);
	}

	@Override
	public List<Object[]> getAllMillsOfContracts() {
	return creditNoteGenerationDao.getAllMillsOfContracts();
	}

	@Override
	public List<Object[]> findDetails(String table, String contractNoString) {
		return creditNoteGenerationDao.findDetails(table, contractNoString);
	}

	@Override
	public void saveSettlementOfCnDn(settlemetCnDnModel settlemetCnDnModel) {
		 creditNoteGenerationDao.saveSettlementOfCnDn(settlemetCnDnModel) ;
		
	}

}
