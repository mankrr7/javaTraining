package utils;

import java.util.List;

public class Util {

	//Return true if duplicate else false
	public static boolean verifyDuplicateList(List<String> strList) {
		for (int i = 0; i < strList.size(); i++) {
			for (int j = 0; j < strList.size(); j++) {
				if (strList.get(i).equals(strList.get(j)) && i != j) {
					System.out.println("true");
					return true;
				}
			}
		}
		System.out.println("false");
		return false;
	}
}
