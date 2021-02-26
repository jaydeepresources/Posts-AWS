package com.aws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
public class AWSPostsController {

	@Autowired
	private PostsRepository postsRepository;

	@GetMapping("/posts/all")
	public List<Post> getPosts() {
		return (List<Post>) postsRepository.findAll();
	}

	@PostMapping("/posts/add")
	public Post addPost(@RequestBody Post post) {
		return postsRepository.save(post);
	}

	@PutMapping("/posts/update")
	public Post updatePost(@RequestBody Post post) {
		return postsRepository.save(post);
	}

	@DeleteMapping("/posts/delete/{id}")
	public Status deletePost(@PathVariable Integer id) {

		try {
			postsRepository.deleteById(id);
			return new Status(true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new Status(false);
		}
	}

}
