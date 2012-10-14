package com.olivee.web.spring;

import java.text.SimpleDateFormat;

import javax.annotation.PostConstruct;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.springframework.stereotype.Component;

@Component("jacksonDateMapper")
public class DateMapper extends ObjectMapper {

	private String mask = "MM dd yyyy HH mm ss";

	@PostConstruct
	public void afterPropertiesSet() throws Exception {
		super.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
                            //Using Jackson > 1.8 it's possible to invoke 'getSerializationConfig().withDateFormat(new SimpleDateFormat(mask));', doesnt work ;(
		getSerializationConfig().setDateFormat(new SimpleDateFormat(mask));
	}
	
	public void setMask(String mask) {
		this.mask = mask;
	}

}
