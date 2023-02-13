package com.jci.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.PcsoentryDao;
import com.jci.model.EntryofpcsoModel;
import com.jci.service.PcsoentryService;

@Service
public class PcsoentryServiceImpl implements PcsoentryService {
	
	@Autowired
	PcsoentryDao pcsoentrydao;

	public void create(EntryofpcsoModel entryofpcso) {
		// TODO Auto-generated method stub
		pcsoentrydao.create(entryofpcso);
		
	}

}
