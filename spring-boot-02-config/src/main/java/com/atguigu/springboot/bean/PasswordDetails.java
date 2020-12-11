package com.atguigu.springboot.bean;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "details")
public class PasswordDetails {

	private List<String> scope;
	private String clientId;
	private String clientSecret;
	private String type;
	public List<String> getScope() {
		return scope;
	}
	public void setScope(List<String> scope) {
		this.scope = scope;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClientSecret() {
		return clientSecret;
	}
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "PasswordDetails [scope=" + scope + ", clientId=" + clientId + ", clientSecret=" + clientSecret
				+ ", type=" + type + "]";
	}
	
}
