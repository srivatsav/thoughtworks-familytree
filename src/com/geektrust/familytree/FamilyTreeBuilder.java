package com.geektrust.familytree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.geektrust.familytree.constants.Constants;
import com.geektrust.familytree.constants.Constants.Gender;

/**
 * This is main entry of the Application.
 * 
 * @author srivatsav
 *
 */
public class FamilyTreeBuilder {

	public static void main(String[] args) {

		FamilyTreeBuilder treeBuilder = new FamilyTreeBuilder();
		Family family = new Family();
		treeBuilder.buildFamilyTree(family);

		try {
			String filePath = args[0];
			File file = new File(filePath);
			BufferedReader br = new BufferedReader(new FileReader(file));
			String str;
			while ((str = br.readLine()) != null) {
				String[] inputArray = str.split(" ");

				switch (inputArray[0]) {
				case Constants.ADD_CHILD:
					boolean isGenderValid = Gender.isValid(inputArray[3]);
					if (isGenderValid) {
						family.addChild(inputArray[1], inputArray[2], Gender.valueOf(inputArray[3]));
					} else {
						System.out.print(Constants.UNSUPPORTED_GENDER);
						break;
					}
				case Constants.GET_RELATIONSHIP:
					family.getRelation(inputArray[1], inputArray[2]);
					break;
				default:
					break;
				}
			}

			br.close();

		} catch (FileNotFoundException e) {
			System.out.println("File Not found " + e);
		} catch (IOException e) {
			System.out.println("IOException " + e);
		} catch (Exception e) {
			System.out.println("Technical Error " + e);
		}
	}

	/**
	 * Builds a Family Tree with all relations.
	 * 
	 * @param family
	 */
	private void buildFamilyTree(Family family) {

		Person king = new Person(Constants.KING_SHAN, Gender.Male);
		Person queen = new Person(Constants.QUEEN_ANGA, Gender.Female, king);
		king.setSpouse(queen);
		family.addPerson(king);
		family.addPerson(queen);

		Person amba = new Person(Constants.AMBA, Gender.Female);
		Person chit = new Person(Constants.CHIT, Gender.Male, amba);
		amba.setSpouse(chit);
		queen.addChild(chit);
		family.addPerson(amba);
		family.addPerson(chit);

		Person tritha = new Person(Constants.TRITHA, Gender.Female);
		Person vritha = new Person(Constants.VRITHA, Gender.Male);
		amba.addChild(tritha);
		amba.addChild(vritha);
		family.addPerson(tritha);
		family.addPerson(vritha);

		Person jaya = new Person(Constants.JAYA, Gender.Male);
		Person dritha = new Person(Constants.DRITHA, Gender.Female, jaya);
		Person yodhan = new Person(Constants.YODHAN, Gender.Male);
		jaya.setSpouse(dritha);
		dritha.addChild(yodhan);
		amba.addChild(dritha);
		family.addPerson(jaya);
		family.addPerson(dritha);
		family.addPerson(yodhan);

		Person ish = new Person(Constants.ISH, Gender.Male);
		queen.addChild(ish);
		family.addPerson(ish);

		Person vich = new Person(Constants.VICH, Gender.Male);
		Person lika = new Person(Constants.LIKA, Gender.Female, vich);
		Person vila = new Person(Constants.VILA, Gender.Female);
		Person chika = new Person(Constants.CHIKA, Gender.Female);
		vich.setSpouse(lika);
		lika.addChild(vila);
		lika.addChild(chika);
		queen.addChild(vich);
		family.addPerson(vich);
		family.addPerson(lika);
		family.addPerson(vila);
		family.addPerson(chika);

		Person aras = new Person(Constants.ARAS, Gender.Male);
		Person chitra = new Person(Constants.CHITRA, Gender.Female, aras);
		aras.setSpouse(chitra);
		queen.addChild(aras);
		family.addPerson(aras);
		family.addPerson(chitra);

		Person ahit = new Person(Constants.AHIT, Gender.Male);
		chitra.addChild(ahit);
		family.addPerson(ahit);

		Person arit = new Person(Constants.ARIT, Gender.Male);
		Person jnki = new Person(Constants.JNKI, Gender.Female, arit);
		arit.setSpouse(jnki);
		Person laki = new Person(Constants.LAKI, Gender.Male);
		Person lavnya = new Person(Constants.LAVNYA, Gender.Female);
		chitra.addChild(jnki);
		jnki.addChild(laki);
		jnki.addChild(lavnya);
		family.addPerson(arit);
		family.addPerson(jnki);
		family.addPerson(laki);
		family.addPerson(lavnya);

		Person vyan = new Person(Constants.VYAN, Gender.Male);
		Person satya = new Person(Constants.SATYA, Gender.Female, vyan);
		vyan.setSpouse(satya);
		queen.addChild(satya);
		Person atya = new Person(Constants.ATYA, Gender.Female);
		satya.addChild(atya);
		Person vyas = new Person(Constants.VYAS, Gender.Male);
		Person krpi = new Person(Constants.KRPI, Gender.Female, vyas);
		vyas.setSpouse(krpi);
		satya.addChild(vyas);
		Person kriya = new Person(Constants.KRIYA, Gender.Male);
		Person krithi = new Person(Constants.KRITHI, Gender.Female);
		krpi.addChild(kriya);
		krpi.addChild(krithi);
		Person asva = new Person(Constants.ASVA, Gender.Male);
		Person satvy = new Person(Constants.SATVY, Gender.Female, asva);
		asva.setSpouse(satvy);
		satya.addChild(asva);
		Person vasa = new Person(Constants.VASA, Gender.Male);
		satvy.addChild(vasa);
		family.addPerson(vyan);
		family.addPerson(satya);
		family.addPerson(atya);
		family.addPerson(vyas);
		family.addPerson(krpi);
		family.addPerson(kriya);
		family.addPerson(krithi);
		family.addPerson(asva);
		family.addPerson(satvy);
		family.addPerson(vasa);
	}
}
