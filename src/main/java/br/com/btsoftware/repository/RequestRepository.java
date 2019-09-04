package br.com.btsoftware.repository;

import br.com.btsoftware.domain.Request;
import br.com.btsoftware.domain.enums.RequestState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {

    public List<Request> findAllByOwnerId(Long id);

    @Transactional(readOnly = false)
    @Modifying
    @Query("UPDATE requests SET state = ?2 WHERE id = ?1")
    public int updateStatus(Long id, RequestState state);

}
