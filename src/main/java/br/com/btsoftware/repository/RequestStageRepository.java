package br.com.btsoftware.repository;

import br.com.btsoftware.domain.RequestStage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestStageRepository extends JpaRepository<RequestStage, Long> {

    public List<RequestStage> findAllByRequestId(Long id);

}
