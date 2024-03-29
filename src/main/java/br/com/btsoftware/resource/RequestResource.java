package br.com.btsoftware.resource;

import br.com.btsoftware.domain.Request;
import br.com.btsoftware.domain.RequestStage;
import br.com.btsoftware.dto.RequestSavedDTO;
import br.com.btsoftware.dto.RequestUpdatedDTO;
import br.com.btsoftware.model.PageModel;
import br.com.btsoftware.model.PageRequestModel;
import br.com.btsoftware.service.RequestService;
import br.com.btsoftware.service.RequestStageService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "requests")
public class RequestResource {
	@Autowired
	private RequestService requestService;

	@Autowired
	private RequestStageService requestStageService;

	@PostMapping
	public ResponseEntity<Request> save(@RequestBody @Valid RequestSavedDTO requestDTO) {
		Request requestToSave = requestDTO.transformToRequest();
		Request createdRequest = requestService.save(requestToSave);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdRequest);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Request> update(@PathVariable(name = "id") Long id, @RequestBody @Valid RequestUpdatedDTO requestDTO) {
		Request requestToUpdate = requestDTO.transformToRequest();
		requestToUpdate.setId(id);
		
		Request updatedRequest = requestService.update(requestToUpdate);
		return ResponseEntity.ok(updatedRequest);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Request> getById(@PathVariable(name = "id") Long id) {
		Request request = requestService.getById(id);
		return ResponseEntity.ok(request);
	}

	@GetMapping
	public ResponseEntity<PageModel<Request>> listAll(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "10") int size) {

		PageRequestModel pr = new PageRequestModel(page, size);
		PageModel<Request> pm = requestService.listAllOnLazyMode(pr);
		return ResponseEntity.ok(pm);
	}

	@GetMapping("/{id}/request-stages")
	public ResponseEntity<PageModel<RequestStage>> listAllStagesById(@PathVariable(name = "id") Long id,
			@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "size", defaultValue = "10") int size) {
		
		PageRequestModel pr = new PageRequestModel(page, size);
		PageModel<RequestStage> pm = requestStageService.listAllByRequestIdOnLazyMode(id, pr);

		return ResponseEntity.ok(pm);
	}
}
