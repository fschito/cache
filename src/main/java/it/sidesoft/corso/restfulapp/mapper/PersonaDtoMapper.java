package it.sidesoft.corso.restfulapp.mapper;

import it.sidesoft.corso.restfulapp.dto.PersonaDto;
import it.sidesoft.corso.restfulapp.dto.ProgettoDto;
import it.sidesoft.corso.restfulapp.model.Persona;
import it.sidesoft.corso.restfulapp.model.Progetto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PersonaDtoMapper {

    PersonaDto toDto(Persona entity);

    List<PersonaDto> toDto(List<Persona> entity);

    @Mapping(target = "persone", ignore = true)
    ProgettoDto toDto(Progetto entity);

    //@Mapping(target = "id", ignore = true)
    Persona toEntity(PersonaDto dto);

}
