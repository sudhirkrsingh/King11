package com.mega.king11;

public class FetchRankTeam
{
    String team;
    Long sno,rating,point;

   FetchRankTeam(){

   }

    public FetchRankTeam(String team, Long sno, Long rating, Long point) {
        this.team = team;
        this.sno = sno;
        this.rating = rating;
        this.point = point;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Long getSno() {
        return sno;
    }

    public void setSno(Long sno) {
        this.sno = sno;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public Long getPoint() {
        return point;
    }

    public void setPoint(Long point) {
        this.point = point;
    }
}
