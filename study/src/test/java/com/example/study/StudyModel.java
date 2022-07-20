package com.example.study;

import lombok.Builder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
public class StudyModel {

	@NonNull
	private String id;
	
}
