package com.jas.digitalgourmet.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jas.digitalgourmet.dao.TestDAO;
import com.jas.digitalgourmet.model.Test;

@Service
@Transactional(readOnly = true)
public class TestService {
	private final TestDAO dao;

	public TestService(TestDAO dao) {
		super();
		this.dao = dao;
	}
	
	@Transactional
	public Test create(Test test) {
		return this.dao.save(test);
	}

}
