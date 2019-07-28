package com.wesleyxbz.springbootmvc.web.conversor;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToInteger implements Converter<String, Integer> {

    @Override
    public Integer convert(String text) {

        text = text.trim(); // "trim" = remove espaços em branco da string

        if (text.matches("[0-9]+")) { // Se a string tiver valores menores que 0-9 retorna false
            return Integer.valueOf(text);
        }

        return null;
    }

}