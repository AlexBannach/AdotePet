package br.com.pet.adoteumpet.api.pet.validators;

import br.com.pet.adoteumpet.core.repositories.PetRepository;
import jakarta.validation.ConstraintValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PetExistsByIdValidator implements ConstraintValidator<PetExistsById, Long>{


    @Autowired
    private PetRepository petRepository;

    @Override
    public boolean isValid(Long aLong, jakarta.validation.ConstraintValidatorContext constraintValidatorContext) {
        if (aLong == null) {
            return true;
        }
        return petRepository.existsById(aLong);
    }
}
