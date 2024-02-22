package br.com.pet.adoteumpet.api.adocao.services;


import br.com.pet.adoteumpet.api.adocao.dtos.AdocaoRequest;
import br.com.pet.adoteumpet.api.adocao.dtos.AdocaoResponse;
import br.com.pet.adoteumpet.api.adocao.mappers.AdocaoMapper;
import br.com.pet.adoteumpet.core.repositories.AdocaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdocaoService {

    @Autowired
    private AdocaoRepository adocaoRepository;

    @Autowired
    private AdocaoMapper adocaoMapper;

    public AdocaoResponse create(AdocaoRequest adocaoRequest) {
        var adocaoToCreate = adocaoMapper.toModel(adocaoRequest);
        var createAdocao = adocaoRepository.save(adocaoToCreate);
        return adocaoMapper.toResponse(createAdocao);
    }
    public List<AdocaoResponse> findAll() {
        return adocaoRepository.findAll().stream()
                .map(adocaoMapper::toResponse)
                .toList();
    }
}
