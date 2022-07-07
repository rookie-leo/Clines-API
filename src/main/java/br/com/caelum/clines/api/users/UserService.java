package br.com.caelum.clines.api.users;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;
    private final UserViewMapper viewMapper;
    
    @Autowired
	public UserService(UserRepository repository, UserViewMapper viewMapper) {
		super();
		this.repository = repository;
		this.viewMapper = viewMapper;
	}

	public List<UserView> findAll() {
		return repository.findAll().stream().map(viewMapper::map).collect(toList());
	}

}
