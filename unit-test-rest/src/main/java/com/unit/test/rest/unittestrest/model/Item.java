package com.unit.test.rest.unittestrest.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Item {
	
	@Id
	private int id;
	private String name;
	private int price;
	private int quantity;

	@Transient
	private int value;
	
	protected Item() {}
	
	public Item(int id, String name, int price, int quantity) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return String.format("Item [$d, %s, %d, %d]", id, name, price, quantity);
//		return String.format("Item {id:$d, name:%s, price:%d, quantity:%d}", id, name, price, quantity);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, price, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Item)) {
			return false;
		}
		Item other = (Item) obj;
		return id == other.id && Objects.equals(name, other.name) && price == other.price && quantity == other.quantity;
	}
	
	
}
