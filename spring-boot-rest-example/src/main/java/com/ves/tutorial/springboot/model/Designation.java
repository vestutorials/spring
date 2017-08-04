package com.ves.tutorial.springboot.model;

/**
 * Designation Enum.
 * 
 * @author VES Tutorials
 *
 */
public enum Designation {
	CLERK("Clerk"), 
	OFFICER("Officer"), 
	MANAGER("Manager"), 
	SENIOR_MANAGER("Senior Manager"), 
	DIVISIONAL_MANAGER("Divisional Manager"), 
	ASSISTANT_GENERAL_MANAGER("Assistant General Manager"), 
	DEPT_GENERAL_MANAGER("Deputy General Manager"), 
	GENERAL_MANAGER("General Manager");

	private String name;

	private Designation(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
	
}