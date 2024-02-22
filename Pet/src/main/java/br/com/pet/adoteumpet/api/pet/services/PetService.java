package br.com.pet.adoteumpet.api.pet.services;

import br.com.pet.adoteumpet.api.pet.dtos.PetResponse;
import br.com.pet.adoteumpet.api.pet.mappers.PetMapper;
import br.com.pet.adoteumpet.core.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private PetMapper petMapper;

    public List<PetResponse> findAll() {

        return petRepository.findAll()
                .stream()
                .map(petMapper::toResponse)
                .toList();
    }

    public PetResponse create(PetResponse petRequest) {
        var petToCreate = petMapper.toModel(petRequest);
        var createPet = petRepository.save(petToCreate);
        return petMapper.toResponse(createPet);

    }
}
