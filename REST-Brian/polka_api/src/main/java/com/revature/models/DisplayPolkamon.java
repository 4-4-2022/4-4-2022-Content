package com.revature.models;

import java.util.List;
import java.util.Objects;

public class DisplayPolkamon {
	
	private long id;
	private String name;
	private List<DisplayAbility> abilities;
	public DisplayPolkamon(long id, String name, List<DisplayAbility> abilities) {
		super();
		this.id = id;
		this.name = name;
		this.abilities = abilities;
	}
	public DisplayPolkamon() {
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
	public List<DisplayAbility> getAbilities() {
		return abilities;
	}
	public void setAbilities(List<DisplayAbility> abilities) {
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
		DisplayPolkamon other = (DisplayPolkamon) obj;
		return Objects.equals(abilities, other.abilities) && id == other.id && Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "DisplayPolkamon [id=" + id + ", name=" + name + ", abilities=" + abilities + "]";
	}
	
	

}
