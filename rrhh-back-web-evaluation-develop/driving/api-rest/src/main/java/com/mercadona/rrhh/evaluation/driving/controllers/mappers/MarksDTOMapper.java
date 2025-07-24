package com.mercadona.rrhh.evaluation.driving.controllers.mappers;

import com.mercadona.framework.cna.lib.web.builders.MercadonaPageResponseBuilder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { MercadonaPageResponseBuilder.class })
public abstract class MarksDTOMapper {

}
