package es.soltel.rtur.demospringnative.service;

import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import es.soltel.rtur.demospringnative.model.Libro;
import es.soltel.rtur.demospringnative.repository.LibroRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.slf4j.Logger;

@Controller

@Service
public class LibroServiceImpl implements LibroService {

	private static Logger log = LoggerFactory.getLogger(LibroServiceImpl.class);

	private LibroRepository libroRepository;

	public LibroServiceImpl(LibroRepository libroRepository) {
		this.libroRepository = libroRepository;
		LoggerFactory.getLogger(LibroServiceImpl.class);
	}

	@Override
	public Mono<Libro> findByCodigo(String codigo) {
		return libroRepository.findByCodigo(codigo).doOnNext(p -> log.info("libro with id " + p.getId()));
	}

	@Override
	public Mono<Libro> findById(Long id) {
		return libroRepository.findById(id).doOnNext(p -> log.info("libro with id " + p.getId()));
	}

	@Override
	public Mono<Void> deleteById(Long id) {
		return libroRepository.deleteById(id).doOnNext(c -> log.info("libro with id {} deleted", id));
	}

	@Override
	public Mono<Libro> save(Libro libro) {

		return libroRepository.save(libro);
	}

	@Override
	public Flux<Libro> findAll(Sort sort) {
		return libroRepository.findAll(sort);
	}

	@Override
	public Mono<Libro> postlibro(Libro libro) {

		return libroRepository.save(libro);
	}

	@Override
	public Mono<Libro> updatelibro(Libro libro) {

		libroRepository.findByCodigo(libro.getCodigo()).map(libroDestino -> {
			libroDestino.setAutor(libro.getAutor());
			libroDestino.setSinopsis(libro.getSinopsis());
			libroDestino.setTitulo(libro.getTitulo());
			return libroDestino;
		}).subscribe(libroDestino -> {
			libroRepository.save(libroDestino).subscribe(s -> log.debug("SAVED DATA " + s));
		});
		return Mono.just(libro);
	}

	@Override
	public Mono deletelibro(String codlibro) {
		return libroRepository.deleteByCodigo(codlibro);
	}

}
