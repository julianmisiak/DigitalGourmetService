package com.jas.digitalgourmet.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.jas.digitalgourmet.controller.dto.RoleDTO;
import com.jas.digitalgourmet.controller.dto.UserDTO;
import com.jas.digitalgourmet.dao.RoleDAO;
import com.jas.digitalgourmet.model.Role;
import com.jas.digitalgourmet.model.User;
import com.jas.digitalgourmet.service.translateobject.TranslateObject;
import com.jas.digitalgourmet.util.BusinessException;

@Service
public class RoleService {
	private final RoleDAO dao;

	public RoleService(RoleDAO dao) {
		super();
		this.dao = dao;
	}

	public List<RoleDTO> findAllRoles(Boolean isActive) {
		List<Role> roles = dao.findAllRoles(isActive);
		List<RoleDTO> RolesDTO = new ArrayList<>();

		roles.forEach(role -> {
			RoleDTO roleDTO = TranslateObject.getInstance().translateToDTO(role);
			RolesDTO.add(roleDTO);
		});

		return RolesDTO;
	}

	public Integer inactiveObjectById(Long oid) {
		hasDeleteRole(oid);
		return dao.inactiveObjectById(oid);
	}

	public Role saveOrUpdateRole(RoleDTO roleDTO) {
		try {
			Role role = TranslateObject.getInstance().translateToPersistentObject(roleDTO);
			return dao.save(role);
		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
			throw new BusinessException("Hubo un error desconocido");
		}
	}

	public RoleDTO getRoleById(Long OID) {
		Role role = dao.findById(OID).get();
		return TranslateObject.getInstance().translateToDTO(role);
	}

	private List<User> getUsersByRole(Long OID) {
		Role role = dao.findById(OID).get();
		return role.getUsers();
	}

	private void hasDeleteRole(Long oid) {
		List<User> users = getUsersByRole(oid);
		 if( !(users == null || users.isEmpty())) { 
			 List<String> userNameList = new ArrayList<>();
			 users.forEach((data) -> {
				 userNameList.add(data.getUserName());
			 });
			 throw new BusinessException("No se puede elimninar, debido que tiene asociados los siguientes usuarios: " + userNameList.toString());
		 }
	}

}
