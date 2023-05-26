package com.jeanneeetjean.jej.controller;
import com.jeanneeetjean.jej.controller.api.ArticleApi;
import com.jeanneeetjean.jej.dto.ArticleDto;
import com.jeanneeetjean.jej.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ArticleController implements ArticleApi {

    private ArticleService articleService;

    @Autowired
    public ArticleController(
            ArticleService articleService
    ) {
        this.articleService = articleService;
    }

    @Override
    public ArticleDto save(ArticleDto dto) {
        return articleService.save(dto);
    }

    @Override
    public ArticleDto findById(Integer id) {
        return articleService.findById(id);
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleService.findAll();
    }

    @Override
    public void delete(Integer id) {
       articleService.delete(id);
    }
}