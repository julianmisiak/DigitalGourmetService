package com.jas.digitalgourmet.service.translateobject;

import java.util.ArrayList;
import java.util.List;

import com.jas.digitalgourmet.controller.dto.AddressDTO;
import com.jas.digitalgourmet.controller.dto.DataTransferObject;
import com.jas.digitalgourmet.controller.dto.DataTransferObjectLogicalDelete;
import com.jas.digitalgourmet.controller.dto.PersonDTO;
import com.jas.digitalgourmet.controller.dto.UserDTO;
import com.jas.digitalgourmet.model.Address;
import com.jas.digitalgourmet.model.Gender;
import com.jas.digitalgourmet.model.PersistentObject;
import com.jas.digitalgourmet.model.PersistentObjectLogicalDelete;
import com.jas.digitalgourmet.model.Person;
import com.jas.digitalgourmet.model.User;

public class TranslateObject {
	public static TranslateObject instance = null;

	public static TranslateObject getInstance() {
		if (instance == null) {
			instance = new TranslateObject();
		}
		return instance;
	}

	/*
	 * * * * DataTransferObject * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * * * * * * *
	 */

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
	 * * * * DataTransferObjectLogicalDelete * * * * * * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * *
	 */

	private void fillPersistentObject(PersistentObjectLogicalDelete po, DataTransferObjectLogicalDelete dto) {
		fillPersistentObject((PersistentObject) po, (DataTransferObject) dto);
		po.setIsActive(dto.getIsActive());
	}

	private void fillDataTransferObject(PersistentObjectLogicalDelete po, DataTransferObjectLogicalDelete dto) {
		fillDataTransferObject((PersistentObject) po, (DataTransferObject) dto);
		dto.setIsActive(po.getIsActive());
	}
	
	/*
	 * * * * Address * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 */
	private void fillPersistentObject(Address po, AddressDTO dto) {
		fillPersistentObject((PersistentObjectLogicalDelete) po, (DataTransferObjectLogicalDelete) dto);
		po.setProvince(dto.getProvince());
		po.setDistrict(dto.getDistrict());
		po.setLocation(dto.getLocation());
		po.setPostalCode(dto.getPostalCode());
		po.setStreet(dto.getStreet());
		po.setNumber(dto.getNumber());
		po.setIsDepartment(dto.getIsDepartment());
		po.setDepartment(dto.getDepartment());
		po.setIsDefault(dto.getIsDefault());
	}

	private void fillDataTransferObject(Address po, AddressDTO dto) {
		fillDataTransferObject((PersistentObjectLogicalDelete) po, (DataTransferObjectLogicalDelete) dto);
		dto.setProvince(po.getProvince());
		dto.setDistrict(po.getDistrict());
		dto.setLocation(po.getLocation());
		dto.setPostalCode(po.getPostalCode());
		dto.setStreet(po.getStreet());
		dto.setNumber(po.getNumber());
		dto.setIsDepartment(po.getIsDepartment());
		dto.setDepartment(po.getDepartment());
		dto.setIsDefault(po.getIsDefault());
	}
	
	/*
	 * * * * Person * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 */
	private void fillPersistentObject(Person po, PersonDTO dto) {
		fillPersistentObject((PersistentObjectLogicalDelete) po, (DataTransferObjectLogicalDelete) dto);
		po.setName(dto.getName());
		po.setSurname(dto.getSurname());
		po.setIdCard(dto.getIdCard());
		po.setGender(dto.getGender());
		po.setEmail(dto.getEmail());
		
		List<Address> addresses = new ArrayList<>();
		dto.getAddresses().forEach(addressDTO -> {
			Address address = new Address();
			fillPersistentObject(address, addressDTO);
			address.setPerson(po);
			addresses.add(address);
		});
		po.setAddresses(addresses);
		
	}

	private void fillDataTransferObject(Person po, PersonDTO dto) {
		fillDataTransferObject((PersistentObjectLogicalDelete) po, (DataTransferObjectLogicalDelete) dto);
		dto.setName(po.getName());
		dto.setSurname(po.getSurname());
		dto.setIdCard(po.getIdCard());
		dto.setGender(po.getGender());
		dto.setEmail(po.getEmail());
		
		List<AddressDTO> addressesDTO = new ArrayList<>();
		po.getAddresses().forEach(address -> {
			AddressDTO addressDTO = new AddressDTO();
			fillDataTransferObject(address, addressDTO);
			addressesDTO.add(addressDTO);
		});
		dto.setAddresses(addressesDTO);
	}
	
	
	/*
	 * * * * User * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 */
	private void fillPersistentObject(User po, UserDTO dto) {
		fillPersistentObject((Person) po, (PersonDTO) dto);
		po.setUserName(dto.getUserName());
		po.setPassword(dto.getPassword());
	}

	private void fillDataTransferObject(User po, UserDTO dto) {
		fillDataTransferObject((Person) po, (PersonDTO) dto);
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
