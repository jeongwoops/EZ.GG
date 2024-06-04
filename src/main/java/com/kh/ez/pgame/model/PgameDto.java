package com.kh.ez.pgame.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class PgameDto {

    private int  pGameNo;
    private String nickName;
    private int pGameWinLose;
    private String pWinLose;
    private double pGameK;
    private double pGameD;
    private double pGameA;
    private String pChampion;

    
    public void setpGameWinLose(int pGameWinLose) {
        this.pGameWinLose = pGameWinLose;
        this.pWinLose = pGameWinLose == 1 ? "승리" : "패배";
    }

    
}
