package br.com.btsoftware.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.btsoftware.domain.Request;
import br.com.btsoftware.domain.RequestStage;
import br.com.btsoftware.domain.User;

public class RequestUpdatedDTO {
	@NotBlank
	private String subject;

	private String description;
	@NotNull
	private User owner;
	private List<RequestStage> stages = new ArrayList<RequestStage>();

	public RequestUpdatedDTO() {
		super();
	}

	public RequestUpdatedDTO(String subject, String description, User owner, List<RequestStage> stages) {
		super();
		this.subject = subject;
		this.description = description;
		this.owner = owner;
		this.stages = stages;
	}

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
		Request request = new Request(null, this.subject, this.description, null, null, this.owner, this.stages);
		return request;
	}
}
