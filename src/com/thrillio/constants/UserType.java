package com.thrillio.constants;

public enum UserType {

	USER("user"), EDITOR("editor"), CHIEF_EDITOR("chiefeditor");

	private UserType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	private String name;
}
