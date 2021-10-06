package es.soltel.rtur.demospringnative.controller;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.soltel.rtur.demospringnative.model.Libro;
import es.soltel.rtur.demospringnative.service.LibroService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/libros")

public class LibroController {

	private LibroService libroService;

	public LibroController(LibroService libroService) {
		this.libroService = libroService;
	}

	@GetMapping(value = "/{codigo}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Mono<Libro> getMapProvincia(@PathVariable String codigo) {
		return libroService.findByCodigo(codigo);
	}

	@GetMapping(value = "/", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Libro> getMapDatosProvincias() {
		Sort orden = Sort.by(Order.asc("titulo"));
		return libroService.findAll(orden);
	}

	@PostMapping("")
	public Mono<Libro> postlibro(@RequestBody Libro libro) {

		return libroService.updatelibro(libro);
	}

	@PutMapping("")
	public Mono<Libro> updatelibro(@RequestBody Libro libro) {

		return libroService.save(libro);

	}

	@DeleteMapping("/{codigo}")
	public Mono deletelibro(@PathVariable String codigo) {
		return libroService.deletelibro(codigo);
	}

}
