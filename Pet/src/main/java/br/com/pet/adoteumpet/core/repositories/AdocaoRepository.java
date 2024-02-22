package br.com.pet.adoteumpet.core.repositories;

import br.com.pet.adoteumpet.core.models.Adocao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdocaoRepository extends JpaRepository<Adocao, Long> {
}
