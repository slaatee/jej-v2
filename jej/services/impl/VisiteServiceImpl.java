package com.jeanneeetjean.jej.services.impl;

import com.jeanneeetjean.jej.dto.VisiteDto;
import com.jeanneeetjean.jej.exception.EntityNotFoundException;
import com.jeanneeetjean.jej.exception.ErrorCodes;
import com.jeanneeetjean.jej.exception.InvalidEntityException;
import com.jeanneeetjean.jej.repository.VisiteRepository;
import com.jeanneeetjean.jej.services.VisiteService;

import com.jeanneeetjean.jej.validator.VisiteValidator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class VisiteServiceImpl implements VisiteService {
    private final VisiteRepository visiteRepository;

    @Autowired
    public VisiteServiceImpl(VisiteRepository visiteRepository){this.visiteRepository=visiteRepository;}

    @Override
    public VisiteDto save(VisiteDto dto) {
        List<String> errors = VisiteValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("Visite est pas valide {}", dto);
            throw new InvalidEntityException("la visiten'est pas valide", ErrorCodes.VISITE_NOT_VALID, errors);
        }
        return VisiteDto.fromEntity(
                visiteRepository.save(
                        VisiteDto.toEntity(dto)
                )
        );
    }

    @Override
    public VisiteDto findById(Integer id) {
        if(id ==null){
            log.error("Visite id est null");
            return null;
        }
        return visiteRepository.findById(id).map(VisiteDto::fromEntity).orElseThrow(()->
                new EntityNotFoundException("aucun Colis avec l'ID"+ id + "n'a été trouvé dans la base",ErrorCodes.VISITE_NOT_FOUND));
    }

    @Override
    public VisiteDto findByNom(String nom) {
        if(nom== null){
            log.error("nom  colis est null");
            return null;
        }
        return visiteRepository.findByNom(nom)
                .map(VisiteDto::fromEntity)
                .orElseThrow(()->
                        new EntityNotFoundException(
                                "Aucun visite avec le nom = "+ nom +"n'a été trouvé dans la base",
                                ErrorCodes.VISITE_NOT_FOUND                       )
                );
    }

    @Override
    public VisiteDto findByMail(String mail) {
        if(mail == null){
            log.error("nom visite est null");
            return null;
        }
        return visiteRepository.findByNom(mail)
                .map(VisiteDto::fromEntity)
                .orElseThrow(()->
                        new EntityNotFoundException(
                                "Aucune visite avec le mail = "+ mail +"n'a été trouvé dans la base",
                                ErrorCodes.VISITE_NOT_FOUND                       )
                );
    }
    @Override
    public List<VisiteDto> findAll() {
        return visiteRepository.findAll().stream()
                .map(VisiteDto::fromEntity)
                .collect(Collectors.toList());
    }


    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("id est null");
            return ;
        }
       visiteRepository.deleteById(id);
    }
}
