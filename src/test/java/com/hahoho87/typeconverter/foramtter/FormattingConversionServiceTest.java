package com.hahoho87.typeconverter.foramtter;

import com.hahoho87.typeconverter.converter.IpPortToStringConverter;
import com.hahoho87.typeconverter.converter.StringToIpPortConverter;
import com.hahoho87.typeconverter.type.IpPort;
import org.junit.jupiter.api.Test;
import org.springframework.format.support.DefaultFormattingConversionService;

import static org.assertj.core.api.Assertions.assertThat;

class FormattingConversionServiceTest {

    @Test
    void formattingConversionServiceTest() {
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
        // converter 등록
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());
        // formatter 등록
        conversionService.addFormatter(new MyNumberFormatter());

        // converter 사용
        IpPort ipPort = conversionService.convert("127.0.0.1:8080", IpPort.class);
        assertThat(ipPort).isEqualTo(new IpPort("127.0.0.1", 8080));

        // formatter 사용
        assertThat(conversionService.convert(1000, String.class)).isEqualTo("1,000");
        assertThat(conversionService.convert("1,000", Long.class)).isEqualTo(1000L);
    }
}
