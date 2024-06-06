package com.oderzy.universe.common.constants;

import java.util.HashMap;
import java.util.Map;

enum Roles {
	ROLE_PRSN, ROLE_DOC, ROLE_DOC_STAFF, ROLE_MED, ROLE_MED_STAFF, ROLE_LAB, ROLE_LAB_STAFF
}

public class PersonRole {

	private static final Map<Integer, Roles> LOOK_MAP = new HashMap<>();

	static {
		LOOK_MAP.put(10, Roles.ROLE_PRSN);
		LOOK_MAP.put(50, Roles.ROLE_DOC);
		LOOK_MAP.put(51, Roles.ROLE_DOC_STAFF);
		LOOK_MAP.put(80, Roles.ROLE_LAB);
		LOOK_MAP.put(81, Roles.ROLE_LAB_STAFF);
		LOOK_MAP.put(91, Roles.ROLE_MED);
		LOOK_MAP.put(92, Roles.ROLE_MED_STAFF);
	}

	public static String getRole(Integer code) {
		return LOOK_MAP.get(code).toString();
	}
}
