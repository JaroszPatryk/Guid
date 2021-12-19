package com.applicatiot.guid_application;

import com.applicatiot.guid_application.domain.GuidDto;


public class GuidSample {

    public static GuidDto.GuidDtoBuilder guidSampleTest(){
        return GuidDto.builder()
                .idGuid(3452345L)
                .name("Testowy guid");


    }
}
