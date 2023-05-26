package com.jeanneeetjean.jej.services.impl;

import com.jeanneeetjean.jej.dto.ArticleDto;
import com.jeanneeetjean.jej.dto.ColisDto;
import com.jeanneeetjean.jej.exception.EntityNotFoundException;
import com.jeanneeetjean.jej.exception.ErrorCodes;
import com.jeanneeetjean.jej.exception.InvalidEntityException;
import com.jeanneeetjean.jej.repository.ColisRepository;
import com.jeanneeetjean.jej.services.ColisService;
import com.jeanneeetjean.jej.validator.ColisValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ColisServiceImpl implements ColisService {

    private ColisRepository colisRepository;

    @Autowired
    public ColisServiceImpl(ColisRepository colisRepository){
        this.colisRepository= colisRepository;
    }

    @Override
    public ColisDto save(ColisDto dto) {
        List<String> errors = ColisValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("Colis is not valid {}", dto);
            throw new InvalidEntityException("Le colis n'est pas valide", ErrorCodes.COLIS_NOT_VALID, errors);
        }
        return ColisDto.fromEntity(
                colisRepository.save(
                        ColisDto.toEntity(dto)
                )
        );
    }

    @Override
    public ColisDto findById(Integer id) {
       if(id ==null){
           log.error("Colis id est null");
           return null;
       }
       return colisRepository.findById(id).map(ColisDto::fromEntity).orElseThrow(()->
               new EntityNotFoundException("aucun Colis avec l'ID"+ id + "n'a été trouvé dans la base",ErrorCodes.COLIS_NOT_FOUND));
    }

    @Override
    public ColisDto findByNom(String nom) {
        if(nom== null){
            log.error("nom  colis est null");
            return null;
        }
        return colisRepository.findByNom(nom)
                .map(ColisDto::fromEntity)
                .orElseThrow(()->
                        new EntityNotFoundException(
                                "Aucun colis avec le nom = "+ nom +"n'a été trouvé dans la base",
                                ErrorCodes.COLIS_NOT_FOUND                       )
                );
    }

    @Override
    public ColisDto findByMail(String mail) {
        if(mail == null){
            log.error("nom  colis est null");
            return null;
        }
        return colisRepository.findByNom(mail)
                .map(ColisDto::fromEntity)
                .orElseThrow(()->
                        new EntityNotFoundException(
                                "Aucun colis avec le mail = "+ mail +"n'a été trouvé dans la base",
                                ErrorCodes.COLIS_NOT_FOUND                       )
                );
    }

    @Override
    public List<ColisDto> findAll() {
        return colisRepository.findAll().stream()
                .map(ColisDto::fromEntity)
                .collect(Collectors.toList());
    }


    @Override
    public void delete(Integer id) {
            if(id == null){
                log.error("id est null");
                return ;
            }
            colisRepository.deleteById(id);
    }
}
