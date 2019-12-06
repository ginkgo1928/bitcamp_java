package com.jstl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor

public class PersonDTO {
	@NonNull
	private String name;//전체가 아니라 이것만 걸림
	
	private int age;
	
	
	
}
