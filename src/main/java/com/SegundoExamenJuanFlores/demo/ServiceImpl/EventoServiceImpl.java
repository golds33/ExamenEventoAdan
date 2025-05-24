package com.SegundoExamenJuanFlores.demo.ServiceImpl;


import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SegundoExamenJuanFlores.demo.DTO.EventoRequest;
import com.SegundoExamenJuanFlores.demo.DTO.EventoResponse;
import com.SegundoExamenJuanFlores.demo.Mapper.EventoMapper;
import com.SegundoExamenJuanFlores.demo.Model.Evento;
import com.SegundoExamenJuanFlores.demo.Repository.EventoRepository;
import com.SegundoExamenJuanFlores.demo.Service.EventoService;





@Service
public class EventoServiceImpl implements EventoService {
	
	 @Autowired
	    private EventoRepository eventoRepository;

	    @Autowired
	    private EventoMapper eventoMapper;

		@Override
		public Collection<EventoResponse> findAllCliente() {
			Collection<Evento> ListEventoResponses=eventoRepository.findAll();
			return eventoMapper.toListEventoToClienteEvento(ListEventoResponses);
		}

		@Override
		public EventoResponse findByIdEvento(Long idEvento) {
			Evento evento=eventoRepository.findById(idEvento).orElse(null);
			return eventoMapper.toEventoToEventoResponse(evento);
		}

		@Override
		public void saveEvento(EventoRequest request) {
			Evento newEvento = new Evento();
			 System.out.println("que llega" + request);
			 newEvento.setId(request.getId());
			 newEvento.setNombre(request.getNombre());
			 newEvento.setUbicacion(request.getUbicacion());
			 newEvento.setFechaInicio(request.getFechaInicio());
			 newEvento.setFechaFin(request.getFechaFin());
			 newEvento.setOrganizador(request.getOrganizador());
			 newEvento.setFechaCreacion(LocalDateTime.now());
			eventoRepository.save(newEvento);
		}

		@Override
		public void updateEvento(Long id, EventoRequest request) {
	        // Buscar el evento por ID
	        Optional<Evento> optionalEvento = eventoRepository.findById(id);
	        if (optionalEvento.isPresent()) {
	            Evento evento = optionalEvento.get();
	
	            evento.setNombre(request.getNombre());
	            evento.setUbicacion(request.getUbicacion());
	       
	            evento.setFechaInicio(request.getFechaInicio());
	            evento.setFechaFin(request.getFechaFin());
	            evento.setOrganizador(request.getOrganizador());
	  
	            eventoRepository.save(evento);
	        } else {
	            // Manejar el caso en que no se encuentre el evento
	            throw new RuntimeException("Evento no encontrado con ID: " + id);
	        }
	    }

		@Override
		public void deleteEvento(Long idEvento) {
			Evento evento =eventoRepository.findById(idEvento).orElse(null);
			if (evento!=null) {
				eventoRepository.delete(evento);
			}
			
		}

	
	




}
