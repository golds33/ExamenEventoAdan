package com.SegundoExamenJuanFlores.demo.Mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Component;

import com.SegundoExamenJuanFlores.demo.DTO.EventoResponse;
import com.SegundoExamenJuanFlores.demo.Model.Evento;


@Component
public class EventoMapper {
	public Collection<EventoResponse> toListEventoToClienteEvento(Collection<Evento> listEvento) {
        Collection<EventoResponse> listEventoResponses = new ArrayList<>();

        if(listEvento != null && !listEvento.isEmpty()) {
            for (Evento evento : listEvento) {
                EventoResponse eventoResponse = new EventoResponse();
                eventoResponse.setId(evento.getId());
                eventoResponse.setNombre(evento.getNombre());
               eventoResponse.setUbicacion(evento.getUbicacion());
                eventoResponse.setFechaInicio(evento.getFechaInicio());
               
               eventoResponse.setFechaFin(evento.getFechaFin());
               eventoResponse.setOrganizador(evento.getOrganizador());
               eventoResponse.setFechaCreacion(LocalDateTime.now());
            }
        }

        return listEventoResponses;
    }

    public EventoResponse toEventoToEventoResponse(Evento evento) {
    	EventoResponse eventoResponse = new EventoResponse();
        if(evento != null) {
        	eventoResponse.setNombre(evento.getNombre());
        	eventoResponse.setUbicacion(evento.getUbicacion());
             eventoResponse.setFechaInicio(evento.getFechaInicio());
             eventoResponse.setFechaFin(evento.getFechaFin());
             eventoResponse.setOrganizador(evento.getOrganizador());
        }
        return eventoResponse;
    }
    
}
