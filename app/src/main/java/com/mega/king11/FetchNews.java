package com.mega.king11;

public class FetchNews {
    String desc1,desc2,desc3,purl1,purl2,purl3,title1,subtitle;
    public FetchNews(){

    }

    public FetchNews(String desc1, String desc2, String desc3, String purl1, String purl2, String purl3, String title1, String subtitle) {
        this.desc1 = desc1;
        this.desc2 = desc2;
        this.desc3 = desc3;
        this.purl1 = purl1;
        this.purl2 = purl2;
        this.purl3 = purl3;
        this.title1 = title1;
        this.subtitle = subtitle;
    }

    public String getDesc1() {
        return desc1;
    }

    public void setDesc1(String desc1) {
        this.desc1 = desc1;
    }

    public String getDesc2() {
        return desc2;
    }

    public void setDesc2(String desc2) {
        this.desc2 = desc2;
    }

    public String getDesc3() {
        return desc3;
    }

    public void setDesc3(String desc3) {
        this.desc3 = desc3;
    }

    public String getPurl1() {
        return purl1;
    }

    public void setPurl1(String purl1) {
        this.purl1 = purl1;
    }

    public String getPurl2() {
        return purl2;
    }

    public void setPurl2(String purl2) {
        this.purl2 = purl2;
    }

    public String getPurl3() {
        return purl3;
    }

    public void setPurl3(String purl3) {
        this.purl3 = purl3;
    }

    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}
