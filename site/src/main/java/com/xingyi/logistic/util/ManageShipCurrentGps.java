package com.xingyi.logistic.util;

import com.xingyi.logistic.business.model.ShipCurrentGps;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by WCL on 2018/1/12.
 */
public class ManageShipCurrentGps
{
    public ConcurrentHashMap<String, ShipCurrentGps> mHashMap;

    public ManageShipCurrentGps()
    {
        mHashMap = new ConcurrentHashMap<>();
    }

    public ShipCurrentGps add(String devid)
    {
        ShipCurrentGps mShipCurrentGps = mHashMap.get(devid);
        if (mShipCurrentGps == null)
        {
            mShipCurrentGps = new ShipCurrentGps();
            mShipCurrentGps.setDevId(devid);
            mShipCurrentGps.setIsSaveDb(0);
            mShipCurrentGps.setUpstatue(0);
            mHashMap.put(devid, mShipCurrentGps);
        }
        return mShipCurrentGps;
    }

    /**
     * 定位
     * @param xmlMap
     * @return
     */
    public ShipCurrentGps add(Map<String, String> xmlMap)
    {
        ShipCurrentGps mShipCurrentGps = mHashMap.get(xmlMap.get("devicecode"));
        mShipCurrentGps = getShipCurrentGps(xmlMap, mShipCurrentGps);
        mShipCurrentGps.setUpstatue(0);
        mShipCurrentGps.setAlarmType(Long.parseLong(xmlMap.get("state")));
        mShipCurrentGps.setLatitude(new Double(Double.parseDouble(xmlMap.get("lat")) * 1000000).longValue());
        mShipCurrentGps.setLongitude(new Double(Double.parseDouble(xmlMap.get("lng")) * 1000000).longValue());
        mShipCurrentGps.setSpeed(Long.parseLong(xmlMap.get("speed")));
        mShipCurrentGps.setAngle(Long.parseLong(xmlMap.get("angle")));
        mShipCurrentGps.setGpsTime(xmlMap.get("occurtime"));
        mShipCurrentGps.setAreaId(Long.parseLong(xmlMap.get("areacode")));
        return mShipCurrentGps;
    }


    /**
     * 进站
     * @param xmlMap
     * @return
     */
    public ShipCurrentGps addEnterStation(Map<String, String> xmlMap)
    {
        ShipCurrentGps mShipCurrentGps = mHashMap.get(xmlMap.get("devicecode"));
        mShipCurrentGps = getShipCurrentGps(xmlMap, mShipCurrentGps);
        mShipCurrentGps.setInOrOut(1);
        dealEnterOrLeaveInfo(xmlMap, mShipCurrentGps);
        mShipCurrentGps.setOccurtime(xmlMap.get("occurtime"));
        return mShipCurrentGps;
    }


    /**
     * 出站
     * @param xmlMap
     * @return
     */
    public ShipCurrentGps addLeaveStation(Map<String, String> xmlMap)
    {
        ShipCurrentGps mShipCurrentGps = mHashMap.get(xmlMap.get("devicecode"));
        mShipCurrentGps = getShipCurrentGps(xmlMap, mShipCurrentGps);
        mShipCurrentGps.setInOrOut(0);
        dealEnterOrLeaveInfo(xmlMap, mShipCurrentGps);
        mShipCurrentGps.setEntertime(xmlMap.get("entertime"));
        mShipCurrentGps.setLeavetime(xmlMap.get("leavetime"));
        return mShipCurrentGps;
    }


    /**
     * 进出站公共
     * @param xmlMap
     * @param mShipCurrentGps
     */
    private void dealEnterOrLeaveInfo(Map<String, String> xmlMap, ShipCurrentGps mShipCurrentGps)
    {
        mShipCurrentGps.setUpstatue(0);
        mShipCurrentGps.setLinecode(xmlMap.get("linecode"));
        //mShipCurrentGps.setOrderno(xmlMap.get("orderno"));
        mShipCurrentGps.setAlarmType(Long.parseLong(xmlMap.get("state")));
        mShipCurrentGps.setFieldcode(xmlMap.get("fieldcode"));
        mShipCurrentGps.setServertime(xmlMap.get("servertime"));
    }


    /**
     * 公共处理
     * @param xmlMap
     * @param mShipCurrentGps
     */
    private ShipCurrentGps getShipCurrentGps(Map<String, String> xmlMap, ShipCurrentGps mShipCurrentGps)
    {
        if (mShipCurrentGps == null)
        {
            mShipCurrentGps = new ShipCurrentGps();
            mShipCurrentGps.setDevId(xmlMap.get("devicecode"));
            mShipCurrentGps.setIsSaveDb(0);
            mHashMap.put(xmlMap.get("devicecode"), mShipCurrentGps);
        }
        return mShipCurrentGps;
    }

    public ShipCurrentGps add(ShipCurrentGps mShipCurrentGps)
    {
        if (mHashMap.get(mShipCurrentGps.getDevId()) == null)
        {
            mHashMap.put(mShipCurrentGps.getDevId(), mShipCurrentGps);
        }
        return mShipCurrentGps;
    }

    public int size()
    {
        return mHashMap.size();
    }

    public void clear()
    {
        mHashMap.clear();
    }

    public ShipCurrentGps get(String devid)
    {
        return mHashMap.get(devid);
    }

}
