package com.wesleyxbz.springbootmvc.web.conversor;

import com.wesleyxbz.springbootmvc.domain.Cargo;
import com.wesleyxbz.springbootmvc.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToCargoConversor implements Converter<String, Cargo> {

    @Autowired
    private CargoService service;

    @Override
    public Cargo convert(String text) {
        if (text.isEmpty()) {
            return null;
        }

        Long id = Long.valueOf(text);
        return service.buscarPorId(id);
    }

}
