package com.applicatiot.guid_application.domain;

import com.applicatiot.guid_application.external.GuidEntity;
import com.applicatiot.guid_application.external.GuidRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@ComponentScan
public class ServiceGuid {

    private final GuidRepository guidRepository;
    private final GuidMapper guidMapper;

    public ServiceGuid(GuidRepository guidRepository, GuidMapper guidMapper) {
        this.guidRepository = guidRepository;
        this.guidMapper = guidMapper;
    }

    public void saveToDb(GuidDto guidDto) throws Exception {
        try {
            GuidEntity guidEntity = guidMapper.mapToGuidEntity(guidDto);
            GuidEntity savedEntity = guidRepository.save(guidEntity);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Błąd podczas zapisu do bazy danych ", ex);
        }
    }

    public GuidDto getId(Long id) throws Exception {
        GuidDto guidDto;
        try {
            GuidEntity guidEntity = guidRepository.findGuidEntityById(id);

            guidDto = guidMapper.mapToGuidDto(guidEntity);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Błąd podczas pobrania z bazy danych ", ex);
        }
        return guidDto;

    }
}
