package com.revature.models;

import java.util.List;
import java.util.Objects;

public class PolkaDTO {

	private long id;
	private String name;
	private List<Integer> abilities;
	public PolkaDTO(long id, String name, List<Integer> abilities) {
		super();
		this.id = id;
		this.name = name;
		this.abilities = abilities;
	}
	public PolkaDTO() {
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
	public String toString() {
		return "PolkaDTO [id=" + id + ", name=" + name + ", abilities=" + abilities + "]";
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
		PolkaDTO other = (PolkaDTO) obj;
		return Objects.equals(abilities, other.abilities) && id == other.id && Objects.equals(name, other.name);
	}
	
	
}
