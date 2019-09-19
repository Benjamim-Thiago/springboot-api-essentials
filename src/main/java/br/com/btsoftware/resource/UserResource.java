package br.com.btsoftware.resource;

import br.com.btsoftware.domain.Request;
import br.com.btsoftware.domain.User;
import br.com.btsoftware.dto.UserLoginDTO;
import br.com.btsoftware.dto.UserSavedDTO;
import br.com.btsoftware.dto.UserUpdateRoleDTO;
import br.com.btsoftware.dto.UserUpdatedDTO;
import br.com.btsoftware.model.PageModel;
import br.com.btsoftware.model.PageRequestModel;
import br.com.btsoftware.service.RequestService;
import br.com.btsoftware.service.UserService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "users")
public class UserResource {
	@Autowired
	private UserService userService;
	@Autowired
	private RequestService requestService;

	@PostMapping
	public ResponseEntity<User> save(@RequestBody @Valid UserSavedDTO userDTO) {
		User userToSave = userDTO.transformToUser();
		User createdUser = userService.save(userToSave);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
	}

	@PutMapping("/{id}")
	public ResponseEntity<User> update(@PathVariable(name = "id") Long id, @RequestBody @Valid UserUpdatedDTO userDTO) {
		User userToUpdate = userDTO.transformToUser();
		userToUpdate.setId(id);
		
		User updateUser = userService.update(userToUpdate);
		return ResponseEntity.ok(updateUser);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getById(@PathVariable(name = "id") Long id) {
		User user = userService.getById(id);
		return ResponseEntity.ok(user);
	}

	@GetMapping
	public ResponseEntity<PageModel<User>> listAll(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "10") int size) {

		PageRequestModel pr = new PageRequestModel(page, size);
		PageModel<User> pm = userService.listAllOnLazyMode(pr);
		return ResponseEntity.ok(pm);
	}

	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody @Valid UserLoginDTO user) {
		User loggedUser = userService.login(user.getEmail(), user.getPassword());
		return ResponseEntity.ok(loggedUser);
	}

	@GetMapping("/{id}/requests")
	public ResponseEntity<PageModel<Request>> listAllRequestsById(@PathVariable(name = "id") Long id,
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "10") int size) {

		PageRequestModel pr = new PageRequestModel(page, size);

		PageModel<Request> pm = requestService.listAllByOwnerIdOnLazyMode(id, pr);

		return ResponseEntity.ok(pm);
	}
	
	@PatchMapping("/role/{id}")
	public ResponseEntity<?> updateRole(@PathVariable(name = "id") Long id, @RequestBody @Valid UserUpdateRoleDTO userDTO){
		User user =  new User();
		user.setId(id);
		user.setRole(userDTO.getRole());
		
		userService.updateRole(user);
		
		return ResponseEntity.ok().build();
	}

}
