package br.com.pet.adoteumpet.api.adocao.dtos;

import java.math.BigDecimal;


import br.com.pet.adoteumpet.api.pet.validators.PetExistsById;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AdocaoRequest {

    @Email//Deve ser um email válido
    @NotNull //Não pode ser nulo
    @NotEmpty  //Não pode ser vazio
    @Size (max = 255) //Tamanho máximo de 255 caracteres
    private String email;

    @NotNull //Não pode ser nulo
    @Min(10) //Valor mínimo de 10
    @Max(100) //Valor máximo de 100
    private BigDecimal valor;

    @NotNull //Não pode ser nulo
    @Positive //Deve ser um valor positivo (maior que 0)
    @PetExistsById //Deve existir um pet com o id informado
    private Long petId;
}