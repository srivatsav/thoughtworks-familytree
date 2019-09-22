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

	public enum Gender {
		Male, Female;
		
		public static boolean isValid(String str) {
			if(str==null) return false;
			for(Gender gender : Gender.values()) {
				if(gender.name().equals(str)) {
					return true;
				}
			}
			return false;
		}
	}

}

