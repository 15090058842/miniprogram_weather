package com.zy.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class SKOpenId {
    //openId, sessionKey, unionId
    String openid;
    String session_key;
    String unionId;

    @Override
    public String toString() {
        return "SKOpenId{" +
                "openId='" + openid + '\'' +
                ", sessionKey='" + session_key + '\'' +
                ", unionId='" + unionId + '\'' +
                '}';
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }
}
