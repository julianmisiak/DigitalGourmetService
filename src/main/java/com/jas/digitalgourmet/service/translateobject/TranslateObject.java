package com.jas.digitalgourmet.service.translateobject;

import java.util.ArrayList;
import java.util.List;

import com.jas.digitalgourmet.controller.dto.AccessResourceDTO;
import com.jas.digitalgourmet.controller.dto.AddressDTO;
import com.jas.digitalgourmet.controller.dto.DataTransferObject;
import com.jas.digitalgourmet.controller.dto.DataTransferObjectLogicalDelete;
import com.jas.digitalgourmet.controller.dto.PersonDTO;
import com.jas.digitalgourmet.controller.dto.RoleDTO;
import com.jas.digitalgourmet.controller.dto.UserDTO;
import com.jas.digitalgourmet.model.AccessResource;
import com.jas.digitalgourmet.model.Address;
import com.jas.digitalgourmet.model.Gender;
import com.jas.digitalgourmet.model.PersistentObject;
import com.jas.digitalgourmet.model.PersistentObjectLogicalDelete;
import com.jas.digitalgourmet.model.Person;
import com.jas.digitalgourmet.model.Role;
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
	 */

	private void fillPersistentObject(PersistentObject po, DataTransferObject dto) {
		po.setOID(dto.getOid());
		po.setCreateTimestamp(dto.getCreateTimestamp());
		po.setModificationTimestamp(dto.getModificationTimestamp());
		po.setCreationUser(dto.getCreationUser());
		po.setModificationUser(dto.getModificationUser());
		po.setVersion(dto.getVersion());
	}

	private void fillDataTransferObject(PersistentObject po, DataTransferObject dto) {
		dto.setOid(po.getOID());
		dto.setCreateTimestamp(po.getCreateTimestamp());
		dto.setModificationTimestamp(po.getModificationTimestamp());
		dto.setCreationUser(po.getCreationUser());
		dto.setModificationUser(po.getModificationUser());
		dto.setVersion(po.getVersion());
	}

	/*
	 * * * * DataTransferObjectLogicalDelete * * * * * * * * * * * * * * * * * * * *
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

		List<Role> roles = new ArrayList<>();
		dto.getRoles().forEach(roleDTO -> {
			Role role = new Role();
			fillPersistentObject(role, roleDTO);
			roles.add(role);
		});
		po.setRoles(roles);

	}

	private void fillDataTransferObject(User po, UserDTO dto) {
		fillDataTransferObject((Person) po, (PersonDTO) dto);
		dto.setUserName(po.getUserName());
		dto.setPassword(po.getPassword());

		List<RoleDTO> rolesDTO = new ArrayList<>();
		po.getRoles().forEach(role -> {
			RoleDTO roleDTO = new RoleDTO();
			fillDataTransferObject(role, roleDTO);
			rolesDTO.add(roleDTO);
		});
		dto.setRoles(rolesDTO);
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

	/*
	 * * * * AccessResources * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 */
	private void fillPersistentObject(AccessResource po, AccessResourceDTO dto) {
		fillPersistentObject((PersistentObject) po, (DataTransferObject) dto);
		po.setName(dto.getName());
	}

	private void fillDataTransferObject(AccessResource po, AccessResourceDTO dto) {
		fillDataTransferObject((PersistentObject) po, (DataTransferObject) dto);
		dto.setName(po.getName());
	}

	/*
	 * * * * Roles * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 */
	private void fillPersistentObject(Role po, RoleDTO dto) {
		fillPersistentObject((PersistentObjectLogicalDelete) po, (DataTransferObjectLogicalDelete) dto);
		po.setName(dto.getName());
		po.setDescription(dto.getDescription());

		List<AccessResource> accessResources = new ArrayList<>();
		dto.getAccessResources().forEach(accessResourceDTO -> {
			AccessResource accessResource = new AccessResource();
			fillPersistentObject(accessResource, accessResourceDTO);
			accessResource.setRole(po);
			accessResources.add(accessResource);
		});
		po.setAccessResources(accessResources);
	}

	private void fillDataTransferObject(Role po, RoleDTO dto) {
		fillDataTransferObject((PersistentObjectLogicalDelete) po, (DataTransferObjectLogicalDelete) dto);
		dto.setName(po.getName());
		dto.setDescription(po.getDescription());

		List<AccessResourceDTO> accessResourcesDTO = new ArrayList<>();
		po.getAccessResources().forEach(accessResource -> {
			AccessResourceDTO accessResourceDTO = new AccessResourceDTO();
			fillDataTransferObject(accessResource, accessResourceDTO);
			accessResourcesDTO.add(accessResourceDTO);
		});
		dto.setAccessResources(accessResourcesDTO);

	}

	public Role translateToPersistentObject(RoleDTO dto) {
		Role po = new Role();
		fillPersistentObject(po, dto);
		return po;
	}

	public RoleDTO translateToDTO(Role po) {
		RoleDTO dto = new RoleDTO();
		fillDataTransferObject(po, dto);
		return dto;
	}

}
