package br.com.pet.adoteumpet.core.models;

import jakarta.persistence.*;
import lombok.*;


@Data //Ele gera todos os getters e setters, toString, equals e hashcode
@Builder //Padrão de projeto
@Entity //Indica que a classe é uma entidade do banco de dados
@NoArgsConstructor //Construtor sem argumentos
@AllArgsConstructor //Construtor com todos os argumentos
@EqualsAndHashCode(onlyExplicitlyIncluded = true) //Gera o equals e hashcode apenas com os atributos marcados com @EqualsAndHashCode.Include
public class Pet {

    @Id //Indica que o atributo é a chave primária
    @EqualsAndHashCode.Include //Indica que o atributo deve ser incluído no equals e hashcode
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Indica que o valor do atributo é gerado automaticamente pelo banco de dados
    private Long id;

    @Column(nullable = false, length = 100) //Indica que o atributo não pode ser nulo e que o tamanho máximo é 100 caracteres
    private String name;

    @Column(nullable = false) //Indica que o atributo não pode ser nulo
    private String historia;

    @Column(nullable = false) //Indica que o atributo não pode ser nulo
    private String foto;
}
