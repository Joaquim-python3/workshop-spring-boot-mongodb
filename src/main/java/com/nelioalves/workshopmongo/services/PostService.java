package com.nelioalves.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.workshopmongo.domain.Post;
import com.nelioalves.workshopmongo.repository.PostRepository;
import com.nelioalves.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	// nao precisa intanciar objeto
	@Autowired
	private PostRepository repo;


	public Post findById(String id) {
		// SPRING 1.X.X
//		User user = repo.findOne(id);
//		if(user == null) {
//			throw new ObjectNotFoundException("Objeto nao encontrado");
//		}
//		return user;
		// SPRING 2.X.X
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));

	}
	
	public List<Post> findByTitle(String text){
		return repo.searchTitle(text);
	}

}
