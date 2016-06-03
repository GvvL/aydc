package com.aydc.client.entity;

/**
 */
public class BannerBean extends Bean{

    /**
     * id : 25
     * positionid : 1
     * positionnum : 2
     * banner_title : 麻辣系列
     * banner_content : /Uploads/banner_content/2016/04-06/5704bb11110001.jpg
     * status : 1
     * banner_link :
     * banner_start : 1459440000
     * banner_end : 1490976000
     * banner_width : 0
     * banner_height : 0
     * addtime : 1459927825
     * banner_type : 1
     * user_id : 8
     */

    private int id;
    private int positionid;
    private int positionnum;
    private String banner_title;
    private String banner_content;
    private int status;
    private String banner_link;
    private long banner_start;
    private long banner_end;
    private String banner_width;
    private String banner_height;
    private long addtime;
    private int banner_type;
    private int user_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPositionid() {
        return positionid;
    }

    public void setPositionid(int positionid) {
        this.positionid = positionid;
    }

    public int getPositionnum() {
        return positionnum;
    }

    public void setPositionnum(int positionnum) {
        this.positionnum = positionnum;
    }

    public String getBanner_title() {
        return banner_title;
    }

    public void setBanner_title(String banner_title) {
        this.banner_title = banner_title;
    }

    public String getBanner_content() {
        return banner_content;
    }

    public void setBanner_content(String banner_content) {
        this.banner_content = banner_content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getBanner_link() {
        return banner_link;
    }

    public void setBanner_link(String banner_link) {
        this.banner_link = banner_link;
    }

    public long getBanner_start() {
        return banner_start;
    }

    public void setBanner_start(long banner_start) {
        this.banner_start = banner_start;
    }

    public long getBanner_end() {
        return banner_end;
    }

    public void setBanner_end(long banner_end) {
        this.banner_end = banner_end;
    }

    public String getBanner_width() {
        return banner_width;
    }

    public void setBanner_width(String banner_width) {
        this.banner_width = banner_width;
    }

    public String getBanner_height() {
        return banner_height;
    }

    public void setBanner_height(String banner_height) {
        this.banner_height = banner_height;
    }

    public long getAddtime() {
        return addtime;
    }

    public void setAddtime(long addtime) {
        this.addtime = addtime;
    }

    public int getBanner_type() {
        return banner_type;
    }

    public void setBanner_type(int banner_type) {
        this.banner_type = banner_type;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
