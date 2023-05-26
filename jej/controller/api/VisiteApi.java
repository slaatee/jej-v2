package com.jeanneeetjean.jej.controller.api;


import com.jeanneeetjean.jej.dto.VisiteDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.jeanneeetjean.jej.utils.Constants.APP_ROOT;

public interface VisiteApi {

    @PostMapping(value = APP_ROOT + "/visites/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    VisiteDto save(@RequestBody VisiteDto dto);

    @GetMapping(value = APP_ROOT + "/visites/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    VisiteDto findById(@PathVariable("idVisite") Integer id);

    @GetMapping(value = APP_ROOT + "/visites/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<VisiteDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/visites/delete/{idVisite}")
    void delete(@PathVariable("idVisite") Integer id);
}
