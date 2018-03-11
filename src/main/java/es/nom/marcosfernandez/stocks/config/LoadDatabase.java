package es.nom.marcosfernandez.stocks.config;

import es.nom.marcosfernandez.stocks.model.Share;
import es.nom.marcosfernandez.stocks.repositories.ShareRepository;
import reactor.core.publisher.Flux;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class LoadDatabase {

    //@Bean
    CommandLineRunner init(ShareRepository repository) {
        return args -> {
            Flux.just(
                    new Share("BKT"),
                    new Share("OHL"),
                    new Share("ABG"))
                    .flatMap(repository::save)
                    .subscribe(System.out::println);
        };

    }
}
