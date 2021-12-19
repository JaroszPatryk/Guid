package com.applicatiot.guid_application.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GuidDto {

    @NotNull
    public Long idGuid;
    @NotNull
    public String name;

}

