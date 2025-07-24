package com.mercadona.rrhh.evaluation.driving.controllers.mappers;

import com.mercadona.framework.cna.lib.web.builders.MercadonaPageResponseBuilder;
import com.mercadona.rrhh.evaluation.driving.controllers.DTOs.MarksDTO;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

@Mapper(componentModel = "spring", uses = { MercadonaPageResponseBuilder.class })
public abstract class MarksDTOMapper {

    @Autowired
    protected RestTemplate restTemplate;

    public MarksDTO getMarksDto(Long id) {
        String url = "http://rrhh-api:8081/api/employees/" + id;
        return restTemplate.getForObject(url, MarksDTO.class);
    }
}
