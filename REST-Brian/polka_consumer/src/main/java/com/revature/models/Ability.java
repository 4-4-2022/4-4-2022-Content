package com.revature.models;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Ability {

	private String name;
	private String url;
	public Ability(String name, String url) {
		super();
		this.name = name;
		this.url = url;
	}
	public Ability() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public int hashCode() {
		return Objects.hash(name, url);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ability other = (Ability) obj;
		return Objects.equals(name, other.name) && Objects.equals(url, other.url);
	}
	@Override
	public String toString() {
		return "Ability [name=" + name + ", url=" + url + "]";
	}
	
	
}
