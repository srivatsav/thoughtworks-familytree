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
		case "Son": {
			person.printChild(Gender.Male);
			System.out.println();
			break;
		}
		case "daughter": {
			person.printChild(Gender.Female);
			System.out.println();
			break;
		}
		case "siblings": {
			person.printSibling();
			System.out.println();
			break;
		}
		case "Paternal-Uncle": {
			Person father = person.getFather();
			if (father == null) {
				System.out.println(Constants.NONE);
				return;
			}
			father.printSibling(Gender.Male);
			System.out.println();
			break;
		}
		case "Maternal-Uncle": {
			Person mother = person.getMother();
			if (mother == null) {
				System.out.println(Constants.NONE);
				return;
			}
			mother.printSibling(Gender.Male);
			System.out.println();
			break;
		}

		case "Maternal-Aunt": {
			Person mother = person.getMother();
			if (mother == null) {
				System.out.println(Constants.NONE);
				return;
			}
			mother.printSibling(Gender.Female);
			System.out.println();
			break;
		}

		case "Paternal-Aunt": {
			Person father = person.getFather();
			if (father == null) {
				System.out.println(Constants.NONE);
				return;
			}
			father.printSibling(Gender.Female);
			System.out.println();
			break;
		}

		case "Sister-In-Law": {
			Person spouse = person.getSpouse();
			boolean sisterInLawPresent = false;

			if (spouse != null && spouse.getSisters() != null && spouse.getSisters().size() > 0) {
				sisterInLawPresent = true;
				spouse.printSibling(Gender.Female);
				System.out.println();
			}

			List<Person> maleSiblings = person.getSiblings(Gender.Male);
			if (maleSiblings != null && maleSiblings.size() > 0) {
				sisterInLawPresent = true;
				for (int i = 0; i < maleSiblings.size(); i++) {
					if (maleSiblings.get(i).getSpouse() != null)
						System.out.println(maleSiblings.get(i).getSpouse().getName() + " ");
				}
			}

			if (sisterInLawPresent == false) {
				System.out.println(Constants.NONE);
			}

			break;

		}

		case "Brother-In-Law": {
			Person spouse = person.getSpouse();
			boolean brotherInLawPresent = false;

			if (spouse != null && spouse.getBrothers() != null && spouse.getBrothers().size() > 0) {
				brotherInLawPresent = true;
				spouse.printSibling(Gender.Male);
				System.out.println();
			}

			List<Person> femaleSiblings = person.getSiblings(Gender.Female);
			if (femaleSiblings != null && femaleSiblings.size() > 0) {
				brotherInLawPresent = true;
				for (int i = 0; i < femaleSiblings.size(); i++) {
					if (femaleSiblings.get(i).getSpouse() != null)
						System.out.println(femaleSiblings.get(i).getSpouse().getName() + " ");
				}
			}

			if (brotherInLawPresent == false) {
				System.out.println(Constants.NONE);
			}

			break;

		}

		default:
			break;

		}

	}

}
