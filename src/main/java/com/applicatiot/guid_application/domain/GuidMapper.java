package com.applicatiot.guid_application.domain;

import com.applicatiot.guid_application.external.GuidEntity;
import org.springframework.stereotype.Component;

@Component
public class GuidMapper {

    public GuidDto mapToGuidDto(GuidEntity guidEntity) {
        return GuidDto.builder()
                .idGuid(guidEntity.idGuid)
                .name(guidEntity.name)
                .build();
    }

    public GuidEntity mapToGuidEntity(GuidDto guidDto) {
        return GuidEntity.builder()
                .idGuid(guidDto.idGuid)
                .name(guidDto.name)
                .build();
    }
}
