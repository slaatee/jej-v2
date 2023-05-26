package com.jeanneeetjean.jej.services.impl;

import com.jeanneeetjean.jej.dto.PanierDto;
import com.jeanneeetjean.jej.exception.EntityNotFoundException;
import com.jeanneeetjean.jej.exception.ErrorCodes;
import com.jeanneeetjean.jej.exception.InvalidEntityException;
import com.jeanneeetjean.jej.repository.PanierRepository;
import com.jeanneeetjean.jej.services.PanierService;
import com.jeanneeetjean.jej.validator.PanierValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PanierServiceImpl implements PanierService {

    private PanierRepository panierRepository;

    @Autowired
    public PanierServiceImpl(PanierRepository panierRepository){this.panierRepository=panierRepository;}

    @Override
    public PanierDto save(PanierDto dto) {
        List<String>errors = PanierValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("Panier est pas valide {}", dto);
            throw new InvalidEntityException("le panier n'est pas valide", ErrorCodes.PANIER_NOT_VALID, errors);
        }
        return PanierDto.fromEntity(
                panierRepository.save(
                        PanierDto.toEntity(dto)
                )
        );
    }

    @Override
    public PanierDto findById(Integer id) {
        if(id ==null){
            log.error("Panier id est null");
            return null;
        }
        return panierRepository.findById(id).map(PanierDto::fromEntity).orElseThrow(()->
                new EntityNotFoundException("aucun Colis avec l'ID"+ id + "n'a été trouvé dans la base",ErrorCodes.PANIER_NOT_FOUND));
    }

    @Override
    public PanierDto findByNom(String nom) {
        if(nom== null){
            log.error("nom  colis est null");
            return null;
        }
        return panierRepository.findByNom(nom)
                .map(PanierDto::fromEntity)
                .orElseThrow(()->
                        new EntityNotFoundException(
                                "Aucun panier avec le nom = "+ nom +"n'a été trouvé dans la base",
                                ErrorCodes.PANIER_NOT_FOUND                       )
                );
    }

    @Override
    public PanierDto findByMail(String mail) {
        if(mail == null){
            log.error("nom panier est null");
            return null;
        }
        return panierRepository.findByNom(mail)
                .map(PanierDto::fromEntity)
                .orElseThrow(()->
                        new EntityNotFoundException(
                                "Aucun panier avec le mail = "+ mail +"n'a été trouvé dans la base",
                                ErrorCodes.PANIER_NOT_FOUND                       )
                );
    }
    @Override
    public List<PanierDto> findAll() {
        return panierRepository.findAll().stream()
                .map(PanierDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("id est null");
            return ;
        }
        panierRepository.deleteById(id);
    }
}
