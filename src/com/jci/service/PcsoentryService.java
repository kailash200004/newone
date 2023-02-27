package com.jci.service;

import java.util.List;

import com.jci.model.EntryofpcsoModel;

public interface PcsoentryService {
	
	void create(EntryofpcsoModel entryofpcso);

	List<EntryofpcsoModel> getAlldata();

}
