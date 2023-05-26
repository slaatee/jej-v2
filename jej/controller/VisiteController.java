package com.jeanneeetjean.jej.controller;


import com.jeanneeetjean.jej.controller.api.VisiteApi;
import com.jeanneeetjean.jej.dto.VisiteDto;
import com.jeanneeetjean.jej.services.VisiteService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class VisiteController  implements VisiteApi {

    private VisiteService visiteService;

    @Autowired
    public VisiteController( VisiteService visiteService){
        this.visiteService=visiteService;
    }
    @Override
    public VisiteDto save(VisiteDto dto) {
        return visiteService.save(dto);
    }

    @Override
    public VisiteDto findById(Integer id) {
        return visiteService.findById(id);
    }

    @Override
    public List<VisiteDto> findAll() {
        return visiteService.findAll();
    }

    @Override
    public void delete(Integer id) {
        visiteService.delete(id);
    }
}