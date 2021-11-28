package me.smc.workInWeekend.springboot.web.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloResponseDtoTest {

	@Test
	public void 롬복_기능_테스트() {
		String name = "test";
		int amount = 100;

		HelloResponseDto helloResponseDto = new HelloResponseDto(name, amount);

		Assertions.assertEquals(amount, helloResponseDto.getAmount());
		Assertions.assertEquals(name, helloResponseDto.getName());
	}
}
