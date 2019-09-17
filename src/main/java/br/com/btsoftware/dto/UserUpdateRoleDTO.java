package br.com.btsoftware.dto;

import javax.validation.constraints.NotBlank;

import br.com.btsoftware.domain.enums.Role;

public class UserUpdateRoleDTO {
	
	@NotBlank(message = "Role required")
	private Role role;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
