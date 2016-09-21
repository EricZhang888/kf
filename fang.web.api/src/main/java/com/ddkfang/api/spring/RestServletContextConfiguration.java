package com.ddkfang.api.spring;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import javax.xml.transform.Source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@EnableSpringDataWebSupport
@ComponentScan(basePackages = "com.ddkfang")
public class RestServletContextConfiguration extends WebMvcConfigurerAdapter {
	@Autowired
	ApplicationContext applicationContext;

	//	@Inject
	//	ObjectMapper objectMapper;
	//
	//	@Inject
	//	Marshaller marshaller;
	//
	//	@Inject
	//	Unmarshaller unmarshaller;
	//
	//	@Inject
	//	SpringValidatorAdapter validator;

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters)
	{
		converters.add(new SourceHttpMessageConverter<Source>());

		MarshallingHttpMessageConverter xmlConverter = new MarshallingHttpMessageConverter();
		xmlConverter.setSupportedMediaTypes(
				Arrays.asList(new MediaType("application", "xml", Charset.forName("UTF-8")),
						new MediaType("text", "xml", Charset.forName("UTF-8"))));
		//xmlConverter.setMarshaller(this.marshaller);
		//xmlConverter.setUnmarshaller(this.unmarshaller);
		converters.add(xmlConverter);

		MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
		jsonConverter.setSupportedMediaTypes(
				Arrays.asList(new MediaType("application", "json", Charset.forName("UTF-8")),
						new MediaType("text", "json", Charset.forName("UTF-8"))));
		//jsonConverter.setObjectMapper(this.objectMapper);
		converters.add(jsonConverter);
	}
}
