package com.mega.king11;

public class FetchRankPlayer {
    String team,player;
    Long sno,point;

     FetchRankPlayer() {
    }

    public FetchRankPlayer(String team, String player, Long sno, Long point) {
        this.team = team;
        this.player = player;
        this.sno = sno;
        this.point = point;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public Long getSno() {
        return sno;
    }

    public void setSno(Long sno) {
        this.sno = sno;
    }

    public Long getPoint() {
        return point;
    }

    public void setPoint(Long point) {
        this.point = point;
    }
}
