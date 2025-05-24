package com.SegundoExamenJuanFlores.demo.Service;

import java.util.Collection;


import org.springframework.stereotype.Service;

import com.SegundoExamenJuanFlores.demo.DTO.EventoRequest;
import com.SegundoExamenJuanFlores.demo.DTO.EventoResponse;





@Service
public interface EventoService {
	
		Collection<EventoResponse> findAllCliente ();
		
		//Para buscar por id del cliente
		EventoResponse findByIdEvento(Long idEvento);
		//Para crear cliente
		void saveEvento (EventoRequest request);
		//Para Actualizar cliente
		void updateEvento(Long id, EventoRequest request);
		
		void deleteEvento (Long idEvento);
		
}
