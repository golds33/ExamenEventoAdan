
 package com.SegundoExamenJuanFlores.demo.Controller;
 
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SegundoExamenJuanFlores.demo.DTO.EventoRequest;
import com.SegundoExamenJuanFlores.demo.DTO.EventoResponse;

import com.SegundoExamenJuanFlores.demo.Service.EventoService;



@RestController
@RequestMapping("/api")
public class EventoController {

	 @Autowired
	    EventoService eventoService;

	    @GetMapping("/eventos/all")
	    public ResponseEntity<Collection<EventoResponse>> getEventos(){
	        return  ResponseEntity.ok(eventoService.findAllCliente());
	    }

	    @GetMapping("/eventos/{id}")
	    public ResponseEntity<EventoResponse> getEventosById(@PathVariable Long id){
	        return  ResponseEntity.ok(eventoService.findByIdEvento(id));
	    }

	    @PostMapping("/eventos/guardar")
	    public void saveEventosById(@RequestBody EventoRequest request){
	    	eventoService.saveEvento(request);
	    	
	    }

	    @PutMapping("/update/eventos/{id}")
	    public void updateEventosById(@PathVariable Long id, @RequestBody EventoRequest request){
	    	eventoService.updateEvento(id, request);
	    }

	    @DeleteMapping("/delete/eventos/{id}")
	    public void deleteEventosById(@PathVariable Long id){
	    	eventoService.deleteEvento(id);
	    }
}
