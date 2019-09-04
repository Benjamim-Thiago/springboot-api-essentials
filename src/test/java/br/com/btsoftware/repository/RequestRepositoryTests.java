package br.com.btsoftware.repository;

import br.com.btsoftware.domain.Request;
import br.com.btsoftware.domain.User;
import br.com.btsoftware.domain.enums.RequestState;
import br.com.btsoftware.domain.enums.Role;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
public class RequestRepositoryTests {
    @Autowired
    private RequestRepository requestRepository;

    @Test
    @Ignore
    public void AsaveTest() {
        User owner = new User();
        owner.setId(1L);

        Request request = new Request(null, "Novo Laptop HP", "Pretendo obter um laptop HP", new Date(), RequestState.OPEN, owner, null);

        Request createdRequest = requestRepository.save(request);

        assertThat(createdRequest.getId()).isEqualTo(1L);
    }

    @Test
    @Ignore
    public void updateTest() {
        User owner = new User();
        owner.setId(1L);

        Request request = new Request(1L, "Novo Laptop HP", "Pretendo obter um laptop HP, de RAM 16 GB", null, RequestState.OPEN, owner, null);

        Request updatedRequest = requestRepository.save(request);

        assertThat(updatedRequest.getDescription()).isEqualTo("Pretendo obter um laptop HP, de RAM 16 GB");
    }

    @Test
    @Ignore
    public void getByIdTest() {
        Optional<Request> result = requestRepository.findById(1L);
        Request request = result.get();

        assertThat(request.getSubject()).isEqualTo("Novo Laptop HP");
    }

    @Test
    @Ignore
    public void listTest() {
        List<Request> requests = requestRepository.findAll();
        assertThat(requests.size()).isEqualTo(1);
    }

    @Test
    @Ignore
    public void listByOwnerIdTest() {
        List<Request> requests = requestRepository.findAllByOwnerId(1L);
        assertThat(requests.size()).isEqualTo(1);
    }

    @Test
    public void updateStatusTest() {
        int affectedRows = requestRepository.updateStatus(1L, RequestState.IN_PROGRESS);
        assertThat(affectedRows).isEqualTo(1);
    }


}
