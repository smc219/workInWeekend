package me.smc.workInWeekend.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.RequiredArgsConstructor;
import me.smc.workInWeekend.springboot.posts.PostsService;
import me.smc.workInWeekend.springboot.web.dto.PostsSaveRequestDto;

@Controller
@RequiredArgsConstructor
public class PostApiController {
	private final PostsService postsService;

	@PostMapping("/api/v1/posts")
	Long save(@RequestBody PostsSaveRequestDto postsSaveRequestDto)
	{

	}
}
