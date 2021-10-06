/*
 * 
 */
package es.soltel.rtur.demospringnative.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import es.soltel.rtur.demospringnative.model.Libro;
import reactor.core.publisher.Mono;

@Repository
public interface LibroRepository extends  R2dbcRepository<Libro, Long>{
	
	Mono<Libro> findByCodigo(String codigoProvincia);
	Mono<Void> deleteByCodigo(String codigo);
}
