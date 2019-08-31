package br.com.btsoftware.repository;

import br.com.btsoftware.domain.Request;
import br.com.btsoftware.domain.enums.RequestState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {

    public List<Request> findAllByOwnerId(Long id);

    @Query("UPDATE requests SET state = ?2 WHERE id = ?1")
    public Request updateStatus(Long id, RequestState state);

}
