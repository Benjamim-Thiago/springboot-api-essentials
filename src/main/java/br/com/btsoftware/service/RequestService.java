package br.com.btsoftware.service;

import br.com.btsoftware.domain.Request;
import br.com.btsoftware.domain.enums.RequestState;
import br.com.btsoftware.exception.NotFoundException;
import br.com.btsoftware.model.PageModel;
import br.com.btsoftware.model.PageRequestModel;
import br.com.btsoftware.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RequestService {
	@Autowired
	private RequestRepository requestRepository;

	public Request save(Request request) {
		request.setId(null);
		request.setState(RequestState.OPEN);
		request.setCreateDate(new Date());

		Request createdRequest = requestRepository.save(request);

		return createdRequest;
	}

	public Request update(Request request) {
		Request updatedRequest = requestRepository.save(request);

		return updatedRequest;
	}

	public Request getById(Long id) {
		Optional<Request> result = requestRepository.findById(id);

		return result.orElseThrow(() -> new NotFoundException("There are not request with id = " + id));
	}

	public List<Request> listAll() {
		List<Request> requests = requestRepository.findAll();

		return requests;
	}
	
	 public PageModel<Request> listAllOnLazyMode(PageRequestModel pr) {
		Pageable pageable = PageRequest.of(pr.getPage(), pr.getSize());
		Page<Request> page = requestRepository.findAll(pageable);
		
		PageModel<Request> pm = new PageModel<>((int)page.getTotalElements(), page.getSize(), page.getTotalPages(), page.getContent());
		return pm;
	}

	public List<Request> listAllByOwnerId(Long id) {
		List<Request> requests = requestRepository.findAllByOwnerId(id);

		return requests;
	}

	public PageModel<Request> listAllByOwnerIdOnLazyMode(Long ownerId, PageRequestModel pr) {
    	Pageable pageable = PageRequest.of(pr.getPage(), pr.getSize());
    	Page<Request> page = requestRepository.findAllByOwnerId(ownerId, pageable);
    	
    	PageModel<Request> pm = new PageModel<>((int)page.getTotalElements(), page.getSize(), page.getTotalPages(), page.getContent());
        return pm;
    }
}
