package es.nom.marcosfernandez.stocks.repositories;


import es.nom.marcosfernandez.stocks.model.Share;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShareRepository extends ReactiveCrudRepository<Share, String> {

}
