package br.com.pet.adoteumpet.core.repositories;

import br.com.pet.adoteumpet.core.exceptions.PetNotFoundException;
import br.com.pet.adoteumpet.core.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
    default Pet findByIdOrElseThrow(Long id) {

        return findById(id).orElseThrow(PetNotFoundException::new);
    }
}
