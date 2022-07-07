package br.com.caelum.clines.api.users;

public class UserView {

	private String name;
	private String email;

	public UserView(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

}
