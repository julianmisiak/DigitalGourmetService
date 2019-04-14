package com.jas.digitalgourmet.service.translateobject;

import com.jas.digitalgourmet.controller.dto.DataTransferObject;
import com.jas.digitalgourmet.controller.dto.UserDTO;
import com.jas.digitalgourmet.model.PersistentObject;
import com.jas.digitalgourmet.model.User;

public class TranslateObject {
	public static TranslateObject instance = null;

	public static TranslateObject getInstance() {
		if (instance == null) {
			instance = new TranslateObject();
		}
		return instance;
	}

	private void fillPersistentObject(PersistentObject po, DataTransferObject dto) {
		po.setOID(dto.getOid());
		po.setCreateTimestamp(dto.getCreateTimestamp());
		po.setModificationTimestamp(dto.getModificationTimestamp());
		po.setCreationUser(dto.getCreationUser());
		po.setModificationUser(dto.getModificationUser());
	}

	private void fillDataTransferObject(PersistentObject po, DataTransferObject dto) {
		dto.setOid(po.getOID());
		dto.setCreateTimestamp(po.getCreateTimestamp());
		dto.setModificationTimestamp(po.getModificationTimestamp());
		dto.setCreationUser(po.getCreationUser());
		dto.setModificationUser(po.getModificationUser());
	}

	/*
	 * * * * User * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 */
	private void fillPersistentObject(User po, UserDTO dto) {
		fillPersistentObject((PersistentObject) po, (DataTransferObject) dto);
		po.setUserName(dto.getUserName());
		po.setPassword(dto.getPassword());
	}

	private void fillDataTransferObject(User po, UserDTO dto) {
		fillDataTransferObject((PersistentObject) po, (DataTransferObject) dto);
		dto.setUserName(po.getCreationUser());
		dto.setPassword(po.getPassword());
	}

	public User translateToPersistentObject(UserDTO dto) {
		User po = new User();
		fillPersistentObject(po, dto);
		return po;
	}

	public UserDTO translateToDTO(User po) {
		UserDTO dto = new UserDTO();
		fillDataTransferObject(po, dto);
		return dto;
	}

}
