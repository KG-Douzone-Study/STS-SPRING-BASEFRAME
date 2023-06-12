package com.rio.base.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {
	
	@Builder.Default // 인스턴스를 만들때 특정 필드를 특정 값으로 초기화하고 싶다면 @Builder.Default
	@Min(value = 1)
	@Positive // 양수만 가능
	private int page = 1;
	
	@Builder.Default
	@Min(value = 10)
	@Max(value = 100)
	@Positive
	private int size = 10;
	
	public int getSkip() {
		return (page -1) * 10;
	}
	
}
