package es.soltel.rtur.demospringnative.service;

import org.springframework.data.domain.Sort;

import es.soltel.rtur.demospringnative.model.Libro;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LibroService {

	Mono<Libro> findByCodigo(String codigo);
	Mono<Libro> findById(Long id);
	Mono<Void> deleteById(Long id);
	Mono<Libro> save(Libro libro);
	Flux<Libro> findAll(Sort sort);
	Mono<Libro> postlibro(Libro libro);
	Mono<Libro> updatelibro(Libro libro);
	Mono deletelibro(String codlibro);
}