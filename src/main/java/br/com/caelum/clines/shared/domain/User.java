package br.com.caelum.clines.shared.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "users")
public class User {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String name;

	@NotNull
	private String email;

	@NotNull
	private String password;

	public User() {
		super();
	}

	public User(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

}
