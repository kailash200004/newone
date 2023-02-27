package com.jci.dao;

import java.util.List;

import com.jci.model.EntryofpcsoModel;

public interface PcsoentryDao {

	public void create(EntryofpcsoModel entryofpcso);

	public List<EntryofpcsoModel> getAlldata();

}
