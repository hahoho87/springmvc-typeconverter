package com.hahoho87.typeconverter;

import com.hahoho87.typeconverter.converter.IntegerToStringConverter;
import com.hahoho87.typeconverter.converter.IpPortToStringConverter;
import com.hahoho87.typeconverter.converter.StringToIntegerConverter;
import com.hahoho87.typeconverter.converter.StringToIpPortConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToIntegerConverter());
        registry.addConverter(new IntegerToStringConverter());
        registry.addConverter(new StringToIpPortConverter());
        registry.addConverter(new IpPortToStringConverter());
    }
}
