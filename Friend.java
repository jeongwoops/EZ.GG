package com.kh.ez.member.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Friend {
	private int userNo;
	private int friendNo;
	private String status;
}
