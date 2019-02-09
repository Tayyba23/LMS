package com.example.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("storage")
public class AppProperties {
	  private String format = "json";

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}
	  
}
