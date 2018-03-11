package es.nom.marcosfernandez.stocks.controllers;

import es.nom.marcosfernandez.stocks.model.Share;
import es.nom.marcosfernandez.stocks.repositories.ShareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private ShareRepository shareRepository;

    @GetMapping
    public String greeting(@RequestParam(required = false, defaultValue = "") String name) {
        return  name.isEmpty()? "Hey!" : "Hey, " + name + "!";
    }

    //@RequestMapping(value = "",method= RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
    @GetMapping(value = "/stocks", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Share> getAll() {
        Flux<Share> lista = shareRepository.findAll();
        return lista;
    }

    @PostMapping("/stocks")
    public Mono<Void> createShare(@RequestBody Flux<Share> shares) {
        return shares
                .map(share -> {
                    System.out.println("We will save " + share + "to a Reactive DB");
                    return share;
                })
                .then();
    }

}
