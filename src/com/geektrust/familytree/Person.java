package com.geektrust.familytree;

import java.util.ArrayList;
import java.util.List;

import com.geektrust.familytree.constants.Constants.Gender;

/**
 * This is an entity of every person in a family. This contains all the info of
 * a Person.
 * 
 * @author srivatsav
 *
 */
public class Person {
	private String name;
	private Person spouse;
	private Person mother;
	private Person father;
	private List<Person> brothers;
	private List<Person> sisters;
	private List<Person> children;
	private Gender gender;

	/**
	 * Creates a new person without any spouse.
	 * 
	 * @param name
	 * @param gender
	 */
	Person(String name, Gender gender) {
		this.name = name;
		this.gender = gender;
		brothers = new ArrayList<Person>();
		sisters = new ArrayList<Person>();
		children = new ArrayList<Person>();
	}

	/**
	 * Creates a new person with spouse.
	 * 
	 * @param name
	 * @param gender
	 */
	Person(String name, Gender gender, Person spouse) {
		this.name = name;
		this.gender = gender;
		this.spouse = spouse;
		brothers = new ArrayList<Person>();
		sisters = new ArrayList<Person>();
		children = new ArrayList<Person>();
	}

	public String getName() {
		return name;
	}

	public Person getSpouse() {
		return spouse;
	}

	public Person getMother() {
		return mother;
	}

	public Person getFather() {
		return father;
	}

	public void setSpouse(Person spouse) {
		this.spouse = spouse;
	}

	public List<Person> getBrothers() {
		return brothers;
	}

	public List<Person> getSisters() {
		return sisters;
	}

	public Gender getGender() {
		return gender;
	}

	public void setMother(Person mother) {
		this.mother = mother;
	}

	public void setFather(Person father) {
		this.father = father;
	}

	/**
	 * This method takes child as parameter and adds itself to existing siblings and
	 * also to it's own mother and father as a child .
	 * 
	 * @param child
	 */
	public void addChild(Person child) {

		for (int i = 0; i < children.size(); i++) {
			child.addSibling(children.get(i));
			children.get(i).addSibling(child);
		}
		children.add(child);
		this.spouse.children.add(child);
		child.setMother(this);
		child.setFather(this.spouse);

	}

	/**
	 * Adds a given person to the siblings.
	 * 
	 * @param sibling
	 */
	public void addSibling(Person sibling) {
		if (Gender.Female == sibling.getGender())
			sisters.add(sibling);
		else
			brothers.add(sibling);
	}

	/**
	 * Returns gender specific Child.
	 * 
	 * @param gender
	 */
	public List<Person> getChildren(Gender gender) {
		List<Person> filteredChildren = new ArrayList<>();
		if (gender == null)
			return filteredChildren;
		for (Person person : children) {
			if (person.getGender() == gender) {
				filteredChildren.add(person);
			}
		}
		return filteredChildren;
	}

	/**
	 * Returns all siblings.
	 */
	public List<Person> getSiblings() {
		List<Person> siblings = new ArrayList<>();
		siblings.addAll(brothers);
		siblings.addAll(sisters);
		return siblings;
	}

	/**
	 * Get siblings based on gender.
	 * 
	 * @param gender
	 * @return
	 */
	public List<Person> getSiblings(Gender gender) {
		List<Person> result = new ArrayList<>();
		if (gender == null)
			return result;

		List<Person> siblings = Gender.Male == gender ? brothers : sisters;
		if (siblings.size() == 0) {
			return result;
		}
		for (int i = 0; i < siblings.size(); i++) {
			result.add(siblings.get(i));
		}
		return result;
	}
}
