package com.jci.service.Impl_phase2;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao_phase2.EntryofGradeCompositionDao;
import com.jci.model.EntryofGradeCompositionModel;
import com.jci.service_phase2.EntryofGradeCompositionService;

@Service
public class EntryofGradeCompositionServiceImpl implements EntryofGradeCompositionService {

	@Autowired
	EntryofGradeCompositionDao entryofGradeCompositionDao;

	@Override
	public void create(EntryofGradeCompositionModel egc) {
		entryofGradeCompositionDao.create(egc);
	}

	@Override
	public List<Object> getAllJuteCombination() {
		List<Object> allJuteCombination = entryofGradeCompositionDao.getAllJuteCombination();
		return allJuteCombination;
	}

	@Override
	public List<String> gellAllLabelName() {
		List<String> list = entryofGradeCompositionDao.getAllLabelName();
		return list;
	}

	@Override
	public List<EntryofGradeCompositionModel> getAllEGC() {
		List<EntryofGradeCompositionModel> list = entryofGradeCompositionDao.getAllEGC();
		return list;
	}

	@Override
	public void delete(BigInteger id) {
		this.entryofGradeCompositionDao.delete(id);
	}

	@Override
	public void update(EntryofGradeCompositionModel egc) {
		this.entryofGradeCompositionDao.update(egc);

	}

	@Override
	public EntryofGradeCompositionModel Edit(BigInteger id) {
		return this.entryofGradeCompositionDao.edit(id);

	}

	@Override
	public EntryofGradeCompositionModel getSpecificGradeComposition(BigInteger grade_id) {
		EntryofGradeCompositionModel entryofGradeCompositionModel = entryofGradeCompositionDao
				.getSecificGradeComposition(grade_id);
		return entryofGradeCompositionModel;
	}

	@Override
	public void updateJuteVariety(String juteVariety, String labelName, String preJuteVariety) {
		this.entryofGradeCompositionDao.updateJuteVariety(juteVariety, labelName, preJuteVariety);
	}

	@Override
	public boolean isValidLabelName(String labelName) {
		return this.entryofGradeCompositionDao.isValidLabelName(labelName);
	}
}
