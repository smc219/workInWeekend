package me.smc.workInWeekend.springboot.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import me.smc.workInWeekend.springboot.domain.posts.Posts;
import me.smc.workInWeekend.springboot.posts.PostResponseDto;
import me.smc.workInWeekend.springboot.posts.PostsService;
import me.smc.workInWeekend.springboot.web.dto.PostUpdatedto;
import me.smc.workInWeekend.springboot.web.dto.PostsSaveRequestDto;

@RequiredArgsConstructor
@RestController // Parsing Error의 원인을 알았다...ㅠㅠ 이 부분이 @Controller로 되어 있어서 그랬음 ㅠ
public class PostApiController {
	private final PostsService postsService;

	@PostMapping("/api/v1/posts")
	public Long save(@RequestBody PostsSaveRequestDto postsSaveRequestDto)
	{
		return postsService.save(postsSaveRequestDto);
	}

	@PutMapping("/api/v1/posts/{id}")
	public Long update(@PathVariable Long id, @RequestBody PostUpdatedto postUpdatedto) {
		Long updatedId = postsService.update(id, postUpdatedto);
		return updatedId;
	}

	@GetMapping("/api/v1/posts{id}")
	public PostResponseDto search(@PathVariable Long id) {
		return postsService.search(id);
	}
}
