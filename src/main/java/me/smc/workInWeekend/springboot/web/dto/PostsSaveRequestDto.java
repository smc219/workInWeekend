package me.smc.workInWeekend.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import me.smc.workInWeekend.springboot.domain.posts.Posts;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
	private String author;
	private String title;
	private String content;

	@Builder
	public PostsSaveRequestDto(String title, String author, String content) {
		this.title = title;
		this.author = author;
		this.content = content;
	}

	public Posts toEntity() {
		return Posts.builder().title(this.title).author(this.author).contents(this.content).build();
	}

}
