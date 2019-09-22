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
	private List<Person> maleChildren;
	private List<Person> femaleChildren;
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
		maleChildren = new ArrayList<Person>();
		femaleChildren = new ArrayList<Person>();
		brothers = new ArrayList<Person>();
		sisters = new ArrayList<Person>();
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
		maleChildren = new ArrayList<Person>();
		femaleChildren = new ArrayList<Person>();
		brothers = new ArrayList<Person>();
		sisters = new ArrayList<Person>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person getSpouse() {
		return spouse;
	}

	public void setSpouse(Person spouse) {
		this.spouse = spouse;
	}

	public Person getMother() {
		return mother;
	}

	public void setMother(Person mother) {
		this.mother = mother;
	}

	public Person getFather() {
		return father;
	}

	public void setFather(Person father) {
		this.father = father;
	}

	public List<Person> getBrothers() {
		return brothers;
	}

	public void setBrothers(List<Person> brothers) {
		this.brothers = brothers;
	}

	public List<Person> getSisters() {
		return sisters;
	}

	public void setSisters(List<Person> sisters) {
		this.sisters = sisters;
	}

	public List<Person> getMaleChildren() {
		return maleChildren;
	}

	public void setMaleChildren(List<Person> maleChildren) {
		this.maleChildren = maleChildren;
	}

	public List<Person> getFemaleChildren() {
		return femaleChildren;
	}

	public void setFemaleChildren(List<Person> femaleChildren) {
		this.femaleChildren = femaleChildren;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * This method takes child as parameter and adds itself to existing siblings and
	 * also to it's own mother and father as a child .
	 * 
	 * @param child
	 */
	public void addChild(Person child) {

		for (int i = 0; i < maleChildren.size(); i++) {
			child.addSibling(maleChildren.get(i));
			maleChildren.get(i).addSibling(child);
		}

		for (int i = 0; i < femaleChildren.size(); i++) {
			child.addSibling(femaleChildren.get(i));
			femaleChildren.get(i).addSibling(child);
		}

		if (child.getGender() == Gender.Male) {
			maleChildren.add(child);
			this.spouse.maleChildren.add(child);
		} else {
			femaleChildren.add(child);
			this.spouse.femaleChildren.add(child);
		}
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
	 * 
	 * @param gender
	 */
	public void printChild(Gender gender) {
		if (gender == null)
			return;

		List<Person> children = Gender.Male == gender ? maleChildren : femaleChildren;

		if (children.size() == 0) {
			System.out.print("NONE");
			return;
		}

		for (int i = 0; i < children.size(); i++) {
			System.out.print(children.get(i).name + " ");
		}
		return;
	}

	/**
	 * 
	 */
	public void printChild() {

		List<Person> children = maleChildren;
		children.addAll(femaleChildren);

		if (children == null || children.size() == 0) {
			System.out.print("NONE");
			return;
		}
		for (int i = 0; i < children.size(); i++) {
			System.out.print(children.get(i).name + " ");
		}
	}

	/**
	 * 
	 */
	public void printSibling() {
		List<Person> siblings = brothers;
		siblings.addAll(sisters);
		if (siblings == null || siblings.size() == 0) {
			System.out.print("NONE");
			return;
		}
		for (int i = 0; i < siblings.size(); i++) {
			System.out.print(siblings.get(i).name + " ");
		}
	}

	/**
	 * 
	 * @param gender
	 */
	public void printSibling(Gender gender) {
		if (gender == null)
			return;

		List<Person> siblings = Gender.Male == gender ? brothers : sisters;
		if (siblings.size() == 0) {
			System.out.print("NONE");
			return;
		}
		for (int i = 0; i < siblings.size(); i++) {
			System.out.print(siblings.get(i).name + " ");
		}
		return;
	}

	/**
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
