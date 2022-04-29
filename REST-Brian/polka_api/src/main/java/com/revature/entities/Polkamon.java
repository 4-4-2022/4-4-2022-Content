package com.revature.entities;

import java.util.List;
import java.util.Objects;

public class Polkamon {

	private long id;
	private String name;
	private List<Integer> abilities;
	public Polkamon(long id, String name, List<Integer> abilities) {
		super();
		this.id = id;
		this.name = name;
		this.abilities = abilities;
	}
	
	public Polkamon() {
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
	public List<Integer> getAbilities() {
		return abilities;
	}
	public void setAbilities(List<Integer> abilities) {
		this.abilities = abilities;
	}

	@Override
	public int hashCode() {
		return Objects.hash(abilities, id, name);
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
		return Objects.equals(abilities, other.abilities) && id == other.id && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Polkamon [id=" + id + ", name=" + name + ", abilities=" + abilities + "]";
	}
	
	
	
}
