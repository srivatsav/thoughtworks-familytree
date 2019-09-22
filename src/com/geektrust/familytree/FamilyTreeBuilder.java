package com.geektrust.familytree;

import com.geektrust.familytree.constants.Gender;

public class FamilyTreeBuilder {

	public static void main(String[] args) {
		FamilyTreeBuilder treeBuilder = new FamilyTreeBuilder();
		Family family = new Family();
		treeBuilder.buildFamilyTree(family);

//		family.getRelation("Yodhan", "Maternal-Aunt");

	}

	/**
	 * Builds a Family Tree with all relations.
	 * 
	 * @param family
	 */
	private void buildFamilyTree(Family family) {

		Person king = new Person("King Shan", Gender.Male);
		Person queen = new Person("Queen Anga", Gender.Female, king);
		king.setSpouse(queen);
		family.addPerson(king);
		family.addPerson(queen);

		Person amba = new Person("Amba", Gender.Female);
		Person chit = new Person("Chit", Gender.Male, amba);
		amba.setSpouse(chit);
		queen.addChild(chit);
		family.addPerson(amba);
		family.addPerson(chit);

		Person tritha = new Person("Tritha", Gender.Female);
		Person vritha = new Person("Vritha", Gender.Male);
		amba.addChild(tritha);
		amba.addChild(vritha);
		family.addPerson(tritha);
		family.addPerson(vritha);

		Person jaya = new Person("Jaya", Gender.Male);
		Person dritha = new Person("Dritha", Gender.Female, jaya);
		Person yodhan = new Person("Yodhan", Gender.Male);
		jaya.setSpouse(dritha);
		dritha.addChild(yodhan);
		amba.addChild(dritha);
		family.addPerson(jaya);
		family.addPerson(dritha);
		family.addPerson(yodhan);

		Person ish = new Person("Ish", Gender.Male);
		queen.addChild(ish);
		family.addPerson(ish);

		Person vich = new Person("Vich", Gender.Male);
		Person lika = new Person("Lika", Gender.Female, vich);
		Person vila = new Person("Vila", Gender.Female);
		Person chika = new Person("Chika", Gender.Female);
		vich.setSpouse(lika);
		lika.addChild(vila);
		lika.addChild(chika);
		queen.addChild(vich);
		family.addPerson(vich);
		family.addPerson(lika);
		family.addPerson(vila);
		family.addPerson(chika);

		Person aras = new Person("Aras", Gender.Male);
		Person chitra = new Person("Chitra", Gender.Female, aras);
		aras.setSpouse(chitra);
		queen.addChild(aras);
		family.addPerson(aras);
		family.addPerson(chitra);

		Person ahit = new Person("Ahit", Gender.Male);
		chitra.addChild(ahit);
		family.addPerson(ahit);

		Person arit = new Person("Arit", Gender.Male);
		Person jnki = new Person("Jnki", Gender.Female, arit);
		arit.setSpouse(jnki);
		Person laki = new Person("Laki", Gender.Male);
		Person lavnya = new Person("Lavnya", Gender.Female);
		chitra.addChild(jnki);
		jnki.addChild(laki);
		jnki.addChild(lavnya);
		family.addPerson(arit);
		family.addPerson(jnki);
		family.addPerson(laki);
		family.addPerson(lavnya);

		Person vyan = new Person("Vyan", Gender.Male);
		Person satya = new Person("Satya", Gender.Female, vyan);
		vyan.setSpouse(satya);
		queen.addChild(satya);
		Person atya = new Person("Atya", Gender.Female);
		satya.addChild(atya);
		Person vyas = new Person("Vyas", Gender.Male);
		Person krpi = new Person("Krpi", Gender.Female, vyas);
		vyas.setSpouse(krpi);
		satya.addChild(vyas);
		Person kriya = new Person("Kriya", Gender.Male);
		Person krithi = new Person("Krithi", Gender.Female);
		krpi.addChild(kriya);
		krpi.addChild(krithi);
		Person asva = new Person("Asva", Gender.Male);
		Person satvy = new Person("Satvy", Gender.Female, asva);
		asva.setSpouse(satvy);
		satya.addChild(asva);
		Person vasa = new Person("Vasa", Gender.Male);
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
