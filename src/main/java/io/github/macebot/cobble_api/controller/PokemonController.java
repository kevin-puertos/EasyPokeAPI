package io.github.macebot.cobble_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PokemonController {



    @GetMapping(value = "/pokemon/Charizard")
    public  String  getCharizard(){
        String uri = "https://pokeapi.co/api/v2/pokemon/charizard";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        return  result;
    }

}
