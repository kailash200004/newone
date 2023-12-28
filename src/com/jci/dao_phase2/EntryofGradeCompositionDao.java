package com.jci.dao_phase2;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import com.jci.model.EntryofGradeCompositionModel;

public interface EntryofGradeCompositionDao {
	public void create(EntryofGradeCompositionModel egc);

	public List<Object> getAllJuteCombination();

	public List<String> getAllLabelName();

	public List<EntryofGradeCompositionModel> getAllEGC();

	public void delete(BigInteger id);

	public void update(EntryofGradeCompositionModel egc);

	public EntryofGradeCompositionModel edit(BigInteger id);

	public EntryofGradeCompositionModel getSecificGradeComposition(BigInteger grade_id);

	public void updateJuteVariety(String juteVariety, String labelName, String preJuteVariety);

	public boolean isValidLabelName(String labelName);

//	public Date convertToDate(String date);
}
