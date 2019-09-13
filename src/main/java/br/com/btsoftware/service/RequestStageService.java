package br.com.btsoftware.service;

import br.com.btsoftware.domain.RequestStage;
import br.com.btsoftware.domain.enums.RequestState;
import br.com.btsoftware.exception.NotFoundException;
import br.com.btsoftware.model.PageModel;
import br.com.btsoftware.model.PageRequestModel;
import br.com.btsoftware.repository.RequestRepository;
import br.com.btsoftware.repository.RequestStageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RequestStageService {
    @Autowired
    private RequestStageRepository requestStageRepository;
    @Autowired
    private RequestRepository requestRepository;

    public RequestStage save(RequestStage stage) {
        stage.setId(null);
        stage.setRealizationDate(new Date());

        RequestStage createdStage = requestStageRepository.save(stage);

        Long requestId = stage.getRequest().getId();

        RequestState state = stage.getState();

        requestRepository.updateStatus(requestId,state);

        return createdStage;
    }

    public RequestStage getById(Long id) {
        Optional<RequestStage> result = requestStageRepository.findById(id);

        return result.orElseThrow(()->new NotFoundException("Não existe estagios de venda com esse id=" + id));
    }

    public List<RequestStage> listAllByRequestId(Long requestId) {
        List<RequestStage> stages = requestStageRepository.findAllByRequestId(requestId);

        return stages;
    }
    
    public PageModel<RequestStage> listAllByRequestIdOnLazyMode(Long requestId, PageRequestModel pr) {
    	Pageable pageable = PageRequest.of(pr.getPage(), pr.getSize());
    	Page<RequestStage> page = requestStageRepository.findAllByRequestId(requestId, pageable);
    	
    	PageModel<RequestStage> pm = new PageModel<>((int)page.getTotalElements(), page.getSize(), page.getTotalPages(), page.getContent());
        return pm;
    }
}
