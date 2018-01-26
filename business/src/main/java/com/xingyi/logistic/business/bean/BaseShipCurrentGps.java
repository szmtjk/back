package com.xingyi.logistic.business.bean;

/**
 * Created by WCL on 2018/1/12.
 */
public class BaseShipCurrentGps extends BaseModelAndDO {
    private Long shipId;
    //定位数据
    private String shipNo;
    private String devId;
    private long longitude;
    private long latitude;
    private String runkm;//当天行驶里程
    private String gpsTime;
    private long speed;
    private long angle;
    private long alarmType;
    private long areaId;
    private int upstatue = 1;//更新到数据的状态；0表示末更新；1表示已更新
    private int isSaveDb = 1;//0表示数据库中不存在【用插入操作】，1表示数据中存在【用修改操作】，

    //进站离站
    private int inOrOut = 1;//进出站类型；1进站；0出站
    private String linecode;//线路编号
    private String orderno;//序号
    private String fieldcode;//当前港口编号
    private String servertime;//服务器时间

    //进站
    private String occurtime;//发生时间【进入港口时间】

    //出站
    private String entertime;//进入港口时间
    private String leavetime;//离开港口时间


    public int getInOrOut() {
        return inOrOut;
    }

    public void setInOrOut(int inOrOut) {
        this.inOrOut = inOrOut;
    }

    public String getLinecode() {
        return linecode;
    }

    public void setLinecode(String linecode) {
        this.linecode = linecode;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public String getFieldcode() {
        return fieldcode;
    }

    public void setFieldcode(String fieldcode) {
        this.fieldcode = fieldcode;
    }

    public String getServertime() {
        return servertime;
    }

    public void setServertime(String servertime) {
        this.servertime = servertime;
    }

    public String getOccurtime() {
        return occurtime;
    }

    public void setOccurtime(String occurtime) {
        this.occurtime = occurtime;
    }

    public String getEntertime() {
        return entertime;
    }

    public void setEntertime(String entertime) {
        this.entertime = entertime;
    }

    public String getLeavetime() {
        return leavetime;
    }

    public void setLeavetime(String leavetime) {
        this.leavetime = leavetime;
    }

    public String getShipNo() {
        return shipNo;
    }

    public void setShipNo(String shipNo) {
        this.shipNo = shipNo;
    }

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public String getGpsTime() {
        return gpsTime;
    }

    public void setGpsTime(String gpsTime) {
        this.gpsTime = gpsTime;
    }

    public long getSpeed() {
        return speed;
    }

    public void setSpeed(long speed) {
        this.speed = speed;
    }

    public long getAngle() {
        return angle;
    }

    public void setAngle(long angle) {
        this.angle = angle;
    }

    public long getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(long alarmType) {
        this.alarmType = alarmType;
    }

    public long getAreaId() {
        return areaId;
    }

    public void setAreaId(long areaId) {
        this.areaId = areaId;
    }

    public int getUpstatue() {
        return upstatue;
    }

    public void setUpstatue(int upstatue) {
        this.upstatue = upstatue;
    }

    public int getIsSaveDb() {
        return isSaveDb;
    }

    public void setIsSaveDb(int isSaveDb) {
        this.isSaveDb = isSaveDb;
    }

    public String getRunkm() {
        return runkm;
    }

    public void setRunkm(String runkm) {
        this.runkm = runkm;
    }

    public Long getShipId() {
        return shipId;
    }

    public void setShipId(Long shipId) {
        this.shipId = shipId;
    }

    @Override
    public String toString() {
        return "BaseShipCurrentGps{" +
                "shipId='" + shipId + '\'' +
                "shipNo='" + shipNo + '\'' +
                ", devId='" + devId + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", runkm=" + runkm +
                ", gpsTime='" + gpsTime + '\'' +
                ", speed=" + speed +
                ", angle=" + angle +
                ", alarmType=" + alarmType +
                ", areaId=" + areaId +
                ", upstatue=" + upstatue +
                ", isSaveDb=" + isSaveDb +
                ", inOrOut=" + inOrOut +
                ", linecode='" + linecode + '\'' +
                ", orderno='" + orderno + '\'' +
                ", fieldcode='" + fieldcode + '\'' +
                ", servertime='" + servertime + '\'' +
                ", occurtime='" + occurtime + '\'' +
                ", entertime='" + entertime + '\'' +
                ", leavetime='" + leavetime + '\'' +
                '}';
    }
}
