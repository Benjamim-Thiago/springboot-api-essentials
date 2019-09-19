package br.com.btsoftware.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.btsoftware.domain.Request;
import br.com.btsoftware.domain.RequestStage;
import br.com.btsoftware.domain.User;
import br.com.btsoftware.domain.enums.RequestState;

public class RequestSavedDTO {
	@NotBlank(message = "Subject é obrigatório")
	private String subject;

	private String description;

	@NotNull(message = "Informe state")
	private RequestState state;

	@NotNull(message = "Usuário deve ser informado")
	private User owner;
	private List<RequestStage> stages = new ArrayList<RequestStage>();

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public RequestState getState() {
		return state;
	}

	public void setState(RequestState state) {
		this.state = state;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public List<RequestStage> getStages() {
		return stages;
	}

	public void setStages(List<RequestStage> stages) {
		this.stages = stages;
	}

	public Request transformToRequest() {
		System.out.println(this.state);
		Request request = new Request(null, this.subject, this.description, null, this.state, this.owner, this.stages);
		return request;
	}
}
