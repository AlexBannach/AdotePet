package br.com.pet.adoteumpet.api.pet.controllers;

import br.com.pet.adoteumpet.api.pet.services.PetService;
import br.com.pet.adoteumpet.api.pet.dtos.PetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController // Indica que a classe é um controlador REST
@RequestMapping("/api/pets") // Indica o caminho base para a URL de requisição
public class PetController {

    @Autowired
    private PetService petService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED) // Retorna o status 201
    public PetResponse create(@RequestBody @Valid PetResponse petRequest) {

        return petService.create(petRequest);
    }

    @Autowired

    @GetMapping // Mapeia a URL /pets para o método findAll
    public List<PetResponse> findAll() {

        return petService.findAll();
    }


}
