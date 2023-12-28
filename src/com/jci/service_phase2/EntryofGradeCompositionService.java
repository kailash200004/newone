package com.jci.service_phase2;

import java.math.BigInteger;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jci.model.EntryofGradeCompositionModel;
 
public interface EntryofGradeCompositionService {
  public void create(EntryofGradeCompositionModel egc);
  public List<Object> getAllJuteCombination();
  public List<String> gellAllLabelName();
  public List<EntryofGradeCompositionModel> getAllEGC();
  public void delete(BigInteger id);
  public EntryofGradeCompositionModel Edit(BigInteger id);
  public void update(EntryofGradeCompositionModel egc);
  public EntryofGradeCompositionModel getSpecificGradeComposition(BigInteger grade_id);
public void updateJuteVariety(String juteVariety , String labelName,String preJuteVariety);
public boolean isValidLabelName(String labelName);

}
