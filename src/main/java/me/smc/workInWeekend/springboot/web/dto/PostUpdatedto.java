package me.smc.workInWeekend.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class PostUpdatedto {
	private String title;
	private String contents;

	@Builder
	public PostUpdatedto(String title, String contents) {
		this.title = title;
		this.contents = contents;
	}
}
