package br.com.btsoftware.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.btsoftware.domain.Request;
import br.com.btsoftware.domain.RequestStage;
import br.com.btsoftware.domain.User;
import br.com.btsoftware.domain.enums.Role;

public class UserSavedDTO {
	
	@NotBlank(message = "Nome não pode estar em branco")
	private String name;
	
	@Email(message = "E-mail deve ser válido")
	private String email;
	
	@Size(min = 7, max = 99, message = "Senha deve ter 7 a 99 caracteres")
	private String password;
	
	@NotNull(message = "Role deve ser informado")
	private Role role;

	private List<Request> requests = new ArrayList<Request>();

	private List<RequestStage> stages = new ArrayList<RequestStage>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	public List<RequestStage> getStages() {
		return stages;
	}

	public void setStages(List<RequestStage> stages) {
		this.stages = stages;
	}
	
	public User transformToUser() {
		User user = new User(null, this.name, this.email, this.password, this.role, this.requests, this.stages);
	    return user;
	}
}
