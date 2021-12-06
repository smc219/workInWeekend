package me.smc.workInWeekend.springboot.web.dto;

import lombok.Builder;
import me.smc.workInWeekend.springboot.domain.posts.Posts;

public class PostsSaveRequestDto {
	String author;
	String title;
	String content;

	@Builder
	public PostsSaveRequestDto(String author, String title, String content) {
		this.author = author;
		this.title = title;
		this.content = content;
	}

	public Posts toEntity() {
		return Posts.builder().author(this.author).contents(this.content).contents(this.content).build();
	}

}
