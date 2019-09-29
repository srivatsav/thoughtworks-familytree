package com.geektrust.familytree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.geektrust.familytree.constants.Constants;
import com.geektrust.familytree.constants.Constants.Gender;

/**
 * This is an entity of every Family. This contains all the information of a
 * family.
 * 
 * @author srivatsav
 *
 */
public class Family {

	Map<String, Person> familyTree = new HashMap<String, Person>();

	/**
	 * Adds a person to a Family Tree.
	 * 
	 * @param person
	 */
	public void addPerson(Person person) {
		familyTree.put(person.getName(), person);
	}

	/**
	 * Adds a new Child with given childName and gender to the given Mother.
	 * 
	 * Assumption: Allowing addition of a child to mother who doesn't have a
	 * husband.
	 * 
	 * @param motherName
	 * @param childName
	 * @param gender
	 */
	public void addChild(String motherName, String childName, Gender gender) {
		Person mother = familyTree.get(motherName);
		if (mother == null) {
			System.out.println(Constants.PERSON_NOT_FOUND);
			return;
		}
		if (!(mother.getGender() == Gender.Female)) {
			System.out.println(Constants.CHILD_ADDITION_FAILED);
			return;
		}
		Person child = new Person(childName, gender);
		mother.addChild(child);
		addPerson(child);
		System.out.println(Constants.CHILD_ADDITION_SUCCEEDED);

	}

	/**
	 * Gets Persons related to a given Name.
	 * 
	 * @param personName
	 * @param relation
	 */
	public void getRelation(String personName, String relation) {
		Person person = familyTree.get(personName);
		if (person == null) {
			System.out.println(Constants.PERSON_NOT_FOUND);
			return;
		}

		switch (relation) {
		case Constants.SON: {
			List<Person> children = person.getChildren(Gender.Male);
			printFoundPersons(children);
			break;
		}
		case Constants.DAUGHTER: {
			List<Person> children = person.getChildren(Gender.Female);
			printFoundPersons(children);
			break;
		}
		case Constants.SIBLINGS: {
			List<Person> siblings = person.getSiblings();
			printFoundPersons(siblings);
			break;
		}
		case Constants.PATERNAL_UNCLE: {
			Person father = person.getFather();
			if (father == null) {
				printFoundNobody();
				return;
			}
			List<Person> paternalUncles = father.getSiblings(Gender.Male);
			printFoundPersons(paternalUncles);
			break;
		}
		case Constants.MATERNAL_UNCLE: {
			Person mother = person.getMother();
			if (mother == null) {
				printFoundNobody();
				return;
			}
			List<Person> maternalUncles = mother.getSiblings(Gender.Male);
			printFoundPersons(maternalUncles);
			break;
		}

		case Constants.MATERNAL_AUNT: {
			Person mother = person.getMother();
			if (mother == null) {
				printFoundNobody();
				return;
			}
			List<Person> maternalAunts = mother.getSiblings(Gender.Female);
			printFoundPersons(maternalAunts);
			break;
		}

		case Constants.PATERNAL_AUNT: {
			Person father = person.getFather();
			if (father == null) {
				printFoundNobody();
				return;
			}
			List<Person> paternalAunts = father.getSiblings(Gender.Female);
			printFoundPersons(paternalAunts);
			break;
		}

		case Constants.SISTER_IN_LAW: {
			Person spouse = person.getSpouse();
			checkAndPrintSistersOfSpouse(spouse);
			checkAndPrintWivesOfSiblings(person);
			break;

		}

		case Constants.BROTHER_IN_LAW: {
			Person spouse = person.getSpouse();
			checkAndPrintBrothersOfSpouse(spouse);
			checkAndPrintHusbandsOfSiblings(person);
			break;
		}

		default:
			break;

		}

	}

	/**
	 * Print the list of persons in the desired format.
	 * 
	 * @param persons
	 */
	private void printFoundPersons(List<Person> persons) {
		if (persons == null || persons.size() == 0) {
			printFoundNobody();
			return;
		}
		for (int i = 0; i < persons.size(); i++) {
			System.out.print(persons.get(i).getName() + " ");
		}
		System.out.println();
	}

	/**
	 * Print when nobody is found for a given relation.
	 */
	private void printFoundNobody() {
		System.out.println(Constants.NONE);
	}

	/**
	 * Checks for Husbands of Siblings.
	 * 
	 * @param person
	 */
	private void checkAndPrintHusbandsOfSiblings(Person person) {
		List<Person> femaleSiblings = person.getSiblings(Gender.Female);
		if (femaleSiblings != null && femaleSiblings.size() > 0) {
			for (int i = 0; i < femaleSiblings.size(); i++) {
				if (femaleSiblings.get(i).getSpouse() != null)
					System.out.println(femaleSiblings.get(i).getSpouse().getName() + " ");
			}
		} else {
			printFoundNobody();
		}
	}

	/**
	 * Checks for Wives of Siblings.
	 * 
	 * @param person
	 */
	private void checkAndPrintWivesOfSiblings(Person person) {
		List<Person> maleSiblings = person.getSiblings(Gender.Male);
		if (maleSiblings != null && maleSiblings.size() > 0) {
			for (int i = 0; i < maleSiblings.size(); i++) {
				if (maleSiblings.get(i).getSpouse() != null)
					System.out.println(maleSiblings.get(i).getSpouse().getName() + " ");
			}
		} else {
			printFoundNobody();
		}
	}

	/**
	 * Checks for Sisters of Spouse.
	 * 
	 * @param spouse
	 */
	private void checkAndPrintSistersOfSpouse(Person spouse) {
		if (spouse != null && spouse.getSisters() != null && spouse.getSisters().size() > 0) {
			List<Person> sistersOfSpouse = spouse.getSiblings(Gender.Female);
			printFoundPersons(sistersOfSpouse);
		} else {
			printFoundNobody();
		}
	}

	/**
	 * Checks for Brothers of Spouse.
	 * 
	 * @param spouse
	 */
	private void checkAndPrintBrothersOfSpouse(Person spouse) {
		if (spouse != null && spouse.getBrothers() != null && spouse.getBrothers().size() > 0) {
			List<Person> brothersOfSpouse = spouse.getSiblings(Gender.Male);
			printFoundPersons(brothersOfSpouse);
		} else {
			printFoundNobody();
		}
	}

}
