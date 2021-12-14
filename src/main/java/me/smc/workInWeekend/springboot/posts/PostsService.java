package me.smc.workInWeekend.springboot.posts;

import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import me.smc.workInWeekend.springboot.domain.posts.Posts;
import me.smc.workInWeekend.springboot.domain.posts.PostsRepository;
import me.smc.workInWeekend.springboot.web.dto.PostUpdatedto;
import me.smc.workInWeekend.springboot.web.dto.PostsSaveRequestDto;

@Service
@RequiredArgsConstructor
public class PostsService {

	private final PostsRepository postsRepository;

	@Transactional
	public Long save(PostsSaveRequestDto posts)
	{
		return postsRepository.save(posts.toEntity()).getId();
	}

	@Transactional
	public Long update(Long id, PostUpdatedto postUpdatedto)
	{
		Posts post = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("없는 ID 입니다."));
		post.setTitle(postUpdatedto.getTitle());
		post.setContents(postUpdatedto.getContents());
		return post.getId();
	}

	public PostResponseDto search(Long id) {
		Posts post = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("없는 ID 입니다."));
		return new PostResponseDto(post.getTitle(), post.getAuthor(), post.getContents());
	}



}
