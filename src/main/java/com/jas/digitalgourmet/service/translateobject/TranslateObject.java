package com.jas.digitalgourmet.service.translateobject;

import com.jas.digitalgourmet.controller.dto.DataTransferObject;
import com.jas.digitalgourmet.controller.dto.TestDTO;
import com.jas.digitalgourmet.model.PersistentObject;
import com.jas.digitalgourmet.model.Test;

public class TranslateObject{
	public static TranslateObject instance = null;

	public static TranslateObject getInstance() {
		if(instance == null) {
			instance = new TranslateObject();
		}
		return instance;
	}

	private void fillPersistentObject(PersistentObject po, DataTransferObject dto) {
		po.setOID(dto.getOID());
		po.setCreateTimestamp(dto.getCreateTimestamp());
		po.setModificationTimestamp(dto.getModificationTimestamp());
		po.setCreationUser(dto.getCreationUser());
		po.setModificationUser(dto.getModificationUser());
	}
	
	private void fillDataTransferObject(PersistentObject po, DataTransferObject dto) {
		dto.setOID(po.getOID());
		dto.setCreateTimestamp(po.getCreateTimestamp());
		dto.setModificationTimestamp(po.getModificationTimestamp());
		dto.setCreationUser(po.getCreationUser());
		dto.setModificationUser(po.getModificationUser());
	}
	
	private void fillPersistentObject(Test po, TestDTO dto) {
		fillPersistentObject((PersistentObject)po, (DataTransferObject)dto);
	}
	
	private void fillDataTransferObject(Test po, TestDTO dto) {
		fillDataTransferObject((PersistentObject)po, (DataTransferObject)dto);
	}

	public Test translateToPersistentObject(TestDTO dto) {
		Test po = new Test();
		fillPersistentObject(po, dto);
		return po;
	}
	
	public TestDTO translateToDTO(Test po) {
		TestDTO dto = new TestDTO();
		fillDataTransferObject(po, dto);
		return dto;
	}
	

}
