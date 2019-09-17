package br.com.btsoftware.dto;

import br.com.btsoftware.domain.enums.Role;

public class UserUpdateRoleDTO {
	private Role role;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
