package br.com.caelum.clines.api.users;

import java.util.List;

import org.springframework.data.repository.Repository;

import br.com.caelum.clines.shared.domain.User;

public interface UserRepository extends Repository<User, Long> {

	List<User> findAll();
	
}
