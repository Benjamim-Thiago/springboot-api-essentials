package br.com.btsoftware.dto;

import javax.validation.constraints.NotNull;

import br.com.btsoftware.domain.enums.Role;

public class UserUpdateRoleDTO {
	
	@NotNull(message = "Role required.")
	private Role role;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
