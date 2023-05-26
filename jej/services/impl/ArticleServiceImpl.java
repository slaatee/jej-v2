package com.jeanneeetjean.jej.services.impl;

import com.jeanneeetjean.jej.dto.ArticleDto;
import com.jeanneeetjean.jej.exception.EntityNotFoundException;
import com.jeanneeetjean.jej.exception.ErrorCodes;
import com.jeanneeetjean.jej.exception.InvalidEntityException;
import com.jeanneeetjean.jej.repository.ArticleRepository;
import com.jeanneeetjean.jej.services.ArticleService;
import com.jeanneeetjean.jej.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl (ArticleRepository articleRepository){
                this.articleRepository =articleRepository;
    }
    @Override
    public ArticleDto save(ArticleDto dto) {
        List<String> errors = ArticleValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("Article is not valid {}", dto);
            throw new InvalidEntityException("L'article n'est pas valide", ErrorCodes.ARTICLE_NOT_VALID, errors);
        }
        return ArticleDto.fromEntity(
                articleRepository.save(
                        ArticleDto.toEntity(dto)
                )
        );
    }

    @Override
    public ArticleDto findById(Integer id) {
       if(id==null){
           log.error("Article ID est null");
           return null;
       }
       return articleRepository.findById(id).map(ArticleDto::fromEntity).orElseThrow(()->
               new EntityNotFoundException("aucun article avec l'ID ="+ id + "n'a été trouvé dans la base",ErrorCodes.ARTICLE_NOT_FOUND));
    }

    @Override
    public ArticleDto findByNom(String nom) {
        if(StringUtils.hasLength(nom)){
            log.error("Article nom est null");
            return null;
        }
        return  articleRepository.findByNom(nom)
                .map(ArticleDto::fromEntity)
                .orElseThrow(()->
                        new EntityNotFoundException(
                                "Aucun Article avec le nom = "+ nom +"n'a été trouvé dans la base",
                                ErrorCodes.ARTICLE_NOT_FOUND                       )
                );
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleRepository.findAll().stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }


    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Article ID est null");
            return;
        }
        articleRepository.deleteById(id);
    }
}
