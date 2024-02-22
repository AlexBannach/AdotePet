package br.com.pet.adoteumpet.core.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class PetNotFoundException extends EntityNotFoundException{
    public PetNotFoundException() {

        super("Pet não encontrado");
    }

    public PetNotFoundException(String message) {

        super(message);
    }
}

