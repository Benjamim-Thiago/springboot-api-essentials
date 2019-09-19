package br.com.btsoftware.resource;

import br.com.btsoftware.domain.RequestStage;
import br.com.btsoftware.dto.RequestStageSavedDTO;
import br.com.btsoftware.service.RequestStageService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "request-stages")
public class RequestStageResource {
	@Autowired
	private RequestStageService stageService;

	@PostMapping
	public ResponseEntity<RequestStage> save(@RequestBody @Valid RequestStageSavedDTO stage) {
		RequestStage SaveStage = stage.transformToRequestStage();
		RequestStage createdStage = stageService.save(SaveStage);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(createdStage);
	}

	@GetMapping("/{id}")
	public ResponseEntity<RequestStage> getById(@PathVariable(name = "id") Long id) {
		RequestStage stage = stageService.getById(id);
		return ResponseEntity.ok(stage);
	}
}
