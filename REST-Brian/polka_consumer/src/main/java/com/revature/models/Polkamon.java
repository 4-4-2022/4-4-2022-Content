package com.revature.models;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Polkamon {
	
	private String name;
	private List<Ability> abilities;
	public Polkamon(String name, List<Ability> abilities) {
		super();
		this.name = name;
		this.abilities = abilities;
	}
	public Polkamon() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Ability> getAbilities() {
		return abilities;
	}
	public void setAbilities(List<Ability> abilities) {
		this.abilities = abilities;
	}
	@Override
	public int hashCode() {
		return Objects.hash(abilities, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Polkamon other = (Polkamon) obj;
		return Objects.equals(abilities, other.abilities) && Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "Polkamon [name=" + name + ", abilities=" + abilities + "]";
	}
	
	
}
