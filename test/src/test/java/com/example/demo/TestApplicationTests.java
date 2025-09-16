package com.example.demo;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.comment.Comment;
import com.example.demo.comment.CommentRepository;

@SpringBootTest
class TestApplicationTests {

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Test
	void contextLoads() {
		// Post 클래스를 기반으로 객체를 만들고 활용해보기. 
		
		
		
		Post p1 = new Post();
		p1.setContent("내용입니다.");
		p1.setTitle("제목입니다.");
		p1.setCreateAt(LocalDateTime.now());
		this.postRepository.save(p1);
		
		
		//service
		Optional<Comment> o1 = this.commentRepository.findById(18L);
		
		Comment p = o1.get();

		System.out.println(p.getContent());

		
		
		
		
		
	}

}
