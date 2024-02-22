package br.com.pet.adoteumpet.api.pet.mappers;

import br.com.pet.adoteumpet.core.models.Pet;
import br.com.pet.adoteumpet.api.pet.dtos.PetResponse;
import org.springframework.stereotype.Component;

@Component
public class PetMapper {
    public PetResponse toResponse(Pet pet){
        return PetResponse.builder()
                .id(pet.getId())
                .name(pet.getName())
                .historia(pet.getHistoria())
                .foto(pet.getFoto())
                .build();
    }

    public Pet toModel(PetResponse petRequest){
        return Pet.builder()
                .name(petRequest.getName())
                .historia(petRequest.getHistoria())
                .foto(petRequest.getFoto())
                .build();
    }
}
