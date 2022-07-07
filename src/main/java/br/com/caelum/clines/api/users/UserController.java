package br.com.caelum.clines.api.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {

	private final UserService service;

	@Autowired
	public UserController(UserService service) {
		super();
		this.service = service;
	}

	@GetMapping
	List<UserView> list() {
		return service.findAll();
	}

}
