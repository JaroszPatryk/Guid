package com.applicatiot.guid_application;


import com.applicatiot.guid_application.domain.GuidDto;
import com.applicatiot.guid_application.domain.ServiceGuid;
import com.applicatiot.guid_application.external.GuidEntity;
import com.applicatiot.guid_application.external.GuidRepository;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.Optional;

@SpringBootTest
public class ServiceTests implements WithAssertions {

    @Autowired
    ServiceGuid serviceGuid;

    @Autowired
    GuidRepository guidRepository;

    @Test
    void shouldSaveToDb() throws Exception {
        //given
        GuidDto guidDtoSample = GuidSample.guidSampleTest().build();

        //when
        serviceGuid.saveToDb(guidDtoSample);

        Optional<GuidEntity> getbyId = guidRepository.findById(1L);
        //then
        assertThat(getbyId).isPresent();
    }
}
