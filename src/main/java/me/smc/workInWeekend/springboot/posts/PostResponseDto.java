package me.smc.workInWeekend.springboot.posts;

import lombok.Builder;
import lombok.Getter;

@Getter
public class PostResponseDto {
	String title;
	String author;
	String content;

	@Builder
	public PostResponseDto(String title, String author, String content) {
		this.title = title;
		this.author = author;
		this.content = content;
	}
}
