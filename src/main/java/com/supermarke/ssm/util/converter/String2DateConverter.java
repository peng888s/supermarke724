package com.supermarke.ssm.util.converter;

import org.apache.log4j.Logger;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class String2DateConverter implements Converter<String, Date> {
    private Logger logger = Logger.getLogger(String2DateConverter.class);

    private String datePattern;

    public String2DateConverter(String datePattern){
        this.datePattern = datePattern;
    }

    @Override
    public Date convert(String s) {
        Date parse = null;
        try {
            parse = new SimpleDateFormat(datePattern).parse(s);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return parse;
    }
}
