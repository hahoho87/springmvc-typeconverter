package com.hahoho87.typeconverter.converter;

import com.hahoho87.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;

import static org.assertj.core.api.Assertions.assertThat;

class ConversionServiceTest {

    @Test
    void conversionServiceTest() {
        DefaultConversionService conversionService = getDefaultConversionService();

        assertThat(conversionService.convert("10", Integer.class)).isEqualTo(10);
        assertThat(conversionService.convert(10, String.class)).isEqualTo("10");
        IpPort result = conversionService.convert("127.0.0.1:8080", IpPort.class);
        IpPort ipPort = new IpPort("127.0.0.1", 8080);
        assertThat(result).isEqualTo(ipPort);
        String ipPortToString = conversionService.convert(ipPort, String.class);
        assertThat(ipPortToString).isEqualTo("127.0.0.1:8080");
    }

    private DefaultConversionService getDefaultConversionService() {
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new StringToIntegerConverter());
        conversionService.addConverter(new IntegerToStringConverter());
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());
        return conversionService;
    }
}
