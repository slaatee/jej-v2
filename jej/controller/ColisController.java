package com.jeanneeetjean.jej.controller;
import com.jeanneeetjean.jej.controller.api.ColisApi;
import com.jeanneeetjean.jej.dto.ColisDto;
import com.jeanneeetjean.jej.model.Colis;
import com.jeanneeetjean.jej.repository.ColisRepository;
import com.jeanneeetjean.jej.services.ColisService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


public class ColisController implements ColisApi {

    private ColisService colisService;

    @Autowired
    public ColisController(ColisService colisService ){
        this.colisService= colisService;
    }

    @Override
    public ColisDto save(ColisDto dto) {
        return colisService.save(dto);
    }

    @Override
    public ColisDto findById(Integer id) {
        return colisService.findById(id);
    }

    @Override
    public List<ColisDto> findAll() {
        return colisService.findAll();
    }

    @Override
    public void delete(Integer id) {
        colisService.delete(id);
    }
}
