package com.revature.entities;

import java.util.Objects;

public class Bread {

	private long id;
	private String name;
	private String color;
	private int weight;
	public Bread(long id, String name, String color, int weight) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.weight = weight;
	}
	public Bread() {
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
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	@Override
	public int hashCode() {
		return Objects.hash(color, id, name, weight);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bread other = (Bread) obj;
		return Objects.equals(color, other.color) && id == other.id && Objects.equals(name, other.name)
				&& weight == other.weight;
	}
	@Override
	public String toString() {
		return "Bread [id=" + id + ", name=" + name + ", color=" + color + ", weight=" + weight + "]";
	}
	
	
}
