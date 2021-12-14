package me.smc.workInWeekend.springboot.web;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.swing.*;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import lombok.extern.java.Log;
import me.smc.workInWeekend.springboot.domain.posts.Posts;
import me.smc.workInWeekend.springboot.domain.posts.PostsRepository;
import me.smc.workInWeekend.springboot.posts.PostsService;
import me.smc.workInWeekend.springboot.web.dto.PostUpdatedto;
import me.smc.workInWeekend.springboot.web.dto.PostsSaveRequestDto;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PostApiControllerTest {
	@LocalServerPort
	private	int localPort;

	@Autowired
	private PostApiController postApiController;

	@Autowired
	private PostsService postsService;

	@Autowired
	private PostsRepository postsRepository;

	private HttpHeaders headers;
	private TestRestTemplate restTemplate;
	private Long testId;
	@BeforeEach
	void setup() {
		String title = "setup title";
		String content = "setup content";
		String author = "setup author";
	}
	@Test
	void Post_된다() throws Exception
	{
		String title = "title";
		String content = "contents";
		String author = "author";

		String url = "http://localhost:" + localPort + "/api/v1/posts";
		PostsSaveRequestDto postsSaveRequestDto = PostsSaveRequestDto.builder().title(title).content(content).author(author).build();
		restTemplate = new TestRestTemplate();

		ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, postsSaveRequestDto, Long.class); // Return type을 Response Entity로 바꿔주고 난 이후에는 Test를 통과하는걸 확인할 수 있었다. 왜일까?

		Assertions.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);

		List<Posts> postsList = postsRepository.findAll();

	}

	@Test
	void Post_update_된다() throws Exception {
		String title = "title";
		String content = "contents";
		String author = "author";

		String baseurl = "http://localhost:" + localPort;
		String postUrl = baseurl + "/api/v1/posts";
		PostsSaveRequestDto postsSaveRequestDto = PostsSaveRequestDto.builder().title(title).content(content).author(author).build();
		restTemplate = new TestRestTemplate();

		ResponseEntity<Long> responseEntity = restTemplate.postForEntity(postUrl, postsSaveRequestDto, Long.class); // Return type을 Response Entity로 바꿔주고 난 이후에는 Test를 통과하는걸 확인할 수 있었다. 왜일까?

		String changedTitle = "changedTitle";
		String changedContents = "changedContents";

		String updateUrl = baseurl + "/api/v1/posts/" + Long.toString(responseEntity.getBody());
		PostUpdatedto request = PostUpdatedto.builder().contents(changedContents).title(changedTitle).build();
		restTemplate.exchange(updateUrl, HttpMethod.PUT, responseEntity, Long.class);



	}


}