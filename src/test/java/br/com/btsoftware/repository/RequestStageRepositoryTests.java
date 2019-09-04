package br.com.btsoftware.repository;

import br.com.btsoftware.domain.Request;
import br.com.btsoftware.domain.RequestStage;
import br.com.btsoftware.domain.User;
import br.com.btsoftware.domain.enums.RequestState;
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
public class RequestStageRepositoryTests {
    @Autowired
    private RequestStageRepository requestStageRepository;

    @Test
    public void AsaveTest() {
        User owner = new User();
        owner.setId(1L);
        
        Request request = new Request();
        request.setId(1L);

        RequestStage requestState = new RequestStage(null,"Compra de um laptop HP, de RAM 16 GB", new Date(), RequestState.CLOSED,request, owner);

        RequestStage createdStage = requestStageRepository.save(requestState);

        assertThat(createdStage.getId()).isEqualTo(1L);
    }

    @Test
    public void getByIdTest() {
        Optional<RequestStage> result = requestStageRepository.findById(1L);
        RequestStage requestStage = result.get();

        assertThat(requestStage.getDescription()).isEqualTo("Compra de um laptop HP, de RAM 16 GB");
    }
   

    @Test
    public void listByRequestIdTest() {
        List<RequestStage> requests = requestStageRepository.findAllByRequestId(1L);
        assertThat(requests.size()).isEqualTo(1);
    }


}
