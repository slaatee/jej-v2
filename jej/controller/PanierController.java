package com.jeanneeetjean.jej.controller;

import com.jeanneeetjean.jej.controller.api.PanierApi;
import com.jeanneeetjean.jej.dto.PanierDto;
import com.jeanneeetjean.jej.model.Panier;
import com.jeanneeetjean.jej.repository.PanierRepository;

import com.jeanneeetjean.jej.services.PanierService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;



public class PanierController implements PanierApi {

    private PanierService panierService;

    @Autowired
    public PanierController (PanierService panierService){
        this.panierService =panierService;
    }

    @Override
    public PanierDto save(PanierDto dto) {
        return panierService.save(dto);
    }

    @Override
    public PanierDto findById(Integer id) {
        return panierService.findById(id);
    }

    @Override
    public List<PanierDto> findAll() {
        return panierService.findAll();
    }

    @Override
    public void delete(Integer id) {
        panierService.delete(id);
    }
}
