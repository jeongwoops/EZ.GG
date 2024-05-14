package com.kh.ez.pgame.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Pgame {
	
	private int userNo;
	private int pGameNo;
	private String pGameTitle;
	private int pGameColor;
	private int pGamePosition;
	private int pGameChampion;
	private int pGameK;
	private int pGameD;
	private int pGameA;
	private int pGameWinLose;
	private String pGameMvp;
	
	
	private String T1top;
	private String T1jug;
	private String T1mid;
	private String T1adc;
	private String T1sup;
	private String T2top;
	private String T2jug;
	private String T2mid;
	private String T2adc;
	private String T2sup;

}
