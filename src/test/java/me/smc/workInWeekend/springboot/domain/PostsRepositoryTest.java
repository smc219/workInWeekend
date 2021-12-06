package me.smc.workInWeekend.springboot.domain;

import javax.swing.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import me.smc.workInWeekend.springboot.domain.posts.Posts;
import me.smc.workInWeekend.springboot.domain.posts.PostsRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostsRepositoryTest {

	@Autowired
	private PostsRepository postsRepository;
	Posts posts;
	@Before
	void setup() {
		posts = Posts.builder().title("helloWorld!").contents("none").author("hi!").build();
	}

	@Test
	void save() {
		postsRepository.save(posts);
		// 왜 김영한 강의에서 굳이 JpaRepository를 쓰지 않았는지 알겠다. 다양한 조건에 따른 검색 결과를 만들고 싶은데 현재 코드에서는 그럴 수 없기 떄문이다.
	}

}
