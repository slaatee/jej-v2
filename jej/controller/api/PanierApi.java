package com.jeanneeetjean.jej.controller.api;

import com.jeanneeetjean.jej.dto.PanierDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.jeanneeetjean.jej.utils.Constants.APP_ROOT;

public interface PanierApi {
    @PostMapping(value = APP_ROOT + "/paniers/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    PanierDto save(@RequestBody PanierDto dto);

    @GetMapping(value = APP_ROOT + "/paniers/{idPanier}", produces = MediaType.APPLICATION_JSON_VALUE)
    PanierDto findById(@PathVariable("idPanier") Integer id);

    @GetMapping(value = APP_ROOT + "/paniers/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<PanierDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/paniers/delete/{idPanier}")
    void delete(@PathVariable("idPanier") Integer id);
}
