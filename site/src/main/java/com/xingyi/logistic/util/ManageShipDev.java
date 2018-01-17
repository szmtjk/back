package com.xingyi.logistic.util;

import com.xingyi.logistic.business.model.ShipDev;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by WCL on 2018/1/13.
 */
public class ManageShipDev
{
    public ConcurrentHashMap<String, ShipDev> mHashMap;

    public ManageShipDev()
    {
        mHashMap = new ConcurrentHashMap<>();
    }

    /**
     * 加入设备
     * @param devid
     * @return
     */
    public ShipDev add(String devid)
    {
        ShipDev mShipDev =  mHashMap.get(devid);
        if (mShipDev == null)
        {
            mShipDev = new ShipDev();
            mShipDev.setDevId(devid);
        }
        return mShipDev;
    }

    /**
     * 加入设备
     * @param shipDev
     * @return
     */
    public ShipDev add(ShipDev shipDev)
    {
        if (mHashMap.get(shipDev.getDevId()) == null)
        {
            mHashMap.put(shipDev.getDevId(), shipDev);
        }
        return shipDev;
    }

    /**
     * 根据设备号取船号
     * @param devId
     * @return
     */
    public String getShipNo(String devId)
    {
        if (mHashMap.containsKey(devId))
        {
            return mHashMap.get(devId).getShipNo();
        }
        return null;
    }

    public int size()
    {
        return mHashMap.size();
    }

    public void clear()
    {
        mHashMap.clear();
    }

    public ShipDev get(String devid)
    {
        return mHashMap.get(devid);
    }
}
