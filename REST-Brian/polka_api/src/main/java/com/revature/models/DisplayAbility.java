package com.revature.models;

import java.util.Objects;

public class DisplayAbility {
	
	private long id;
	private String name;
	private String url;
	public DisplayAbility(long id, String name, String url) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
	}
	public DisplayAbility() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
		return Objects.hash(id, name, url);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DisplayAbility other = (DisplayAbility) obj;
		return id == other.id && Objects.equals(name, other.name) && Objects.equals(url, other.url);
	}
	@Override
	public String toString() {
		return "DisplayAbility [id=" + id + ", name=" + name + ", url=" + url + "]";
	}
	
	

}
