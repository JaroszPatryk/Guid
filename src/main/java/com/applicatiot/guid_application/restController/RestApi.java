package com.applicatiot.guid_application.restController;

import com.applicatiot.guid_application.domain.GuidDto;
import com.applicatiot.guid_application.domain.ServiceGuid;
import com.sun.istack.NotNull;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RestController
@RequestMapping("/guid/")
public class RestApi {

    private final ServiceGuid serviceGuid;

    public RestApi(ServiceGuid serviceGuid) {
        this.serviceGuid = serviceGuid;
    }


    @PostMapping("add")
    @Produces(MediaType.APPLICATION_JSON)
    public String addItem(@RequestBody GuidDto guidDto) throws Exception {
        try {
            serviceGuid.saveToDb(guidDto);
            return "pozycja została dodana do bazy";
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Wartość wejściowa jest null, sprawdz wartosci podane w body ", ex);
        }
    }


    @GetMapping("get")
    @Produces(MediaType.APPLICATION_JSON)
    public GuidDto getItem(@QueryParam("id") @NotNull Long id) throws Exception {
        try {
            return serviceGuid.getId(id);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Pozycja ze wskazanym id nie istnieje ", ex);
        }
    }
}
