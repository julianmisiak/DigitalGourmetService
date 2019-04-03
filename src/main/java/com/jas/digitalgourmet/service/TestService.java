package com.jas.digitalgourmet.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jas.digitalgourmet.controller.dto.TestDTO;
import com.jas.digitalgourmet.dao.TestDAO;
import com.jas.digitalgourmet.model.Test;
import com.jas.digitalgourmet.service.translateobject.TranslateObject;

@Service
@Transactional(readOnly = true)
public class TestService {
	private final TestDAO dao;

	public TestService(TestDAO dao) {
		super();
		this.dao = dao;
	}
	
	@Transactional
	public TestDTO create(Test test) {
		return TranslateObject.getInstance().translateToDTO(this.dao.save(test)) ;
	}

}
