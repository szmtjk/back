package com.xingyi.logistic.business.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by WCL on 2018/1/20.
 */
@XmlRootElement(name="textmessagesend")
public class TextMessageSend
{
    private Long textmessageid;
    private String devicecode;
    private String textmessagetitle;
    private String textmessage;
    private String servertime;

    public Long getTextmessageid() {
        return textmessageid;
    }

    public void setTextmessageid(Long textmessageid) {
        this.textmessageid = textmessageid;
    }

    public String getDevicecode() {
        return devicecode;
    }

    public void setDevicecode(String devicecode) {
        this.devicecode = devicecode;
    }

    public String getTextmessagetitle() {
        return textmessagetitle;
    }

    public void setTextmessagetitle(String textmessagetitle) {
        this.textmessagetitle = textmessagetitle;
    }

    public String getTextmessage() {
        return textmessage;
    }

    public void setTextmessage(String textmessage) {
        this.textmessage = textmessage;
    }

    public String getServertime() {
        return servertime;
    }

    public void setServertime(String servertime) {
        this.servertime = servertime;
    }
}
