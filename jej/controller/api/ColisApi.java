package com.jeanneeetjean.jej.controller.api;

import com.jeanneeetjean.jej.dto.ColisDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.jeanneeetjean.jej.utils.Constants.APP_ROOT;

public interface ColisApi {

    @PostMapping(value = APP_ROOT + "/colis/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ColisDto save(@RequestBody ColisDto dto);

    @GetMapping(value = APP_ROOT + "/colis/{idColis}", produces = MediaType.APPLICATION_JSON_VALUE)
    ColisDto findById(@PathVariable("idArticle") Integer id);

    @GetMapping(value = APP_ROOT + "/colis/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ColisDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/colis/delete/{idColis}")
    void delete(@PathVariable("idColis") Integer id);
}
