package com.geektrust.familytree.constants;

/**
 * Assuming there are only 2 genders.
 * 
 * @author srivatsav
 *
 */

public class Constants {

	public static final String ADD_CHILD = "ADD_CHILD";
	public static final String GET_RELATIONSHIP = "GET_RELATIONSHIP";
	public static final String CHILD_ADDITION_SUCCEEDED = "CHILD_ADDITION_SUCCEEDED";
	public static final String NONE = "NONE";
	public static final String PERSON_NOT_FOUND = "PERSON_NOT_FOUND";
	public static final String CHILD_ADDITION_FAILED = "CHILD_ADDITION_FAILED";
	public static final String UNSUPPORTED_GENDER = "UNSUPPORTED_GENDER";

	public static final String KING_SHAN = "King Shan";
	public static final String QUEEN_ANGA = "Queen Anga";
	public static final String CHIT = "Chit";
	public static final String AMBA = "Amba";
	public static final String TRITHA = "Tritha";
	public static final String VRITHA = "Vritha";
	public static final String JAYA = "Jaya";
	public static final String DRITHA = "Dritha";
	public static final String YODHAN = "Yodhan";
	public static final String ISH = "Ish";
	public static final String VICH = "Vich";
	public static final String LIKA = "Lika";
	public static final String VILA = "Vila";
	public static final String CHIKA = "Chika";
	public static final String ARAS = "Aras";
	public static final String CHITRA = "Chitra";
	public static final String AHIT = "Ahit";
	public static final String ARIT = "Arit";
	public static final String JNKI = "Jnki";
	public static final String LAKI = "Laki";
	public static final String LAVNYA = "Lavnya";
	public static final String VYAN = "Vyan";
	public static final String SATYA = "Satya";
	public static final String ATYA = "Atya";
	public static final String VYAS = "Vyas";
	public static final String KRPI = "Krpi";
	public static final String KRIYA = "Kriya";
	public static final String KRITHI = "Krithi";
	public static final String ASVA = "Asva";
	public static final String SATVY = "Satvy";
	public static final String VASA = "Vasa";

	public static final String SON = "Son";
	public static final String DAUGHTER = "daughter";
	public static final String SIBLINGS = "siblings";
	public static final String PATERNAL_UNCLE = "Paternal-Uncle";
	public static final String MATERNAL_UNCLE = "Maternal-Uncle";
	public static final String MATERNAL_AUNT = "Maternal-Aunt";
	public static final String PATERNAL_AUNT = "Paternal-Aunt";
	public static final String SISTER_IN_LAW = "Sister-In-Law";
	public static final String BROTHER_IN_LAW = "Brother-In-Law";

	public enum Gender {
		Male, Female;

		public static boolean isValid(String str) {
			if (str == null)
				return false;
			for (Gender gender : Gender.values()) {
				if (gender.name().equals(str)) {
					return true;
				}
			}
			return false;
		}
	}

}
