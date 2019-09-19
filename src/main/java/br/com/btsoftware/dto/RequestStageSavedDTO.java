package br.com.btsoftware.dto;

import javax.validation.constraints.NotNull;

import br.com.btsoftware.domain.Request;
import br.com.btsoftware.domain.RequestStage;
import br.com.btsoftware.domain.User;
import br.com.btsoftware.domain.enums.RequestState;

public class RequestStageSavedDTO {
	private String description;

	@NotNull(message = "State required")
	private RequestState state;
	
	@NotNull(message = "Request required")
	private Request request;
	
	@NotNull(message = "Owner required")
	private User owner;

	public RequestStageSavedDTO() {
		super();
	}

	public RequestStageSavedDTO(String description, RequestState state, Request request, User owner) {
		super();
		this.description = description;
		this.state = state;
		this.request = request;
		this.owner = owner;
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

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	public RequestStage transformToRequestStage() {
		RequestStage stage = new RequestStage(null, description, null, state, request, owner);
		return stage;
	}

}
