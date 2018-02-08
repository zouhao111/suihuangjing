package com.erich.saleticket.dao.tdht;

import com.erich.saleticket.model.tdht.Uav;
import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

@DAO
public interface UavDataDAO {
	
	/**
	 * 无人机采集数据
	 */
	
	@SQL("INSERT INTO tabuav (ID, Time,Lat,Lon,Alt,Yaw,Roll,Pitch,Speed,CO,SO2,NO2,O3,PM10,PM25,NH3,CO2,H2S,Temp,Dumidity) VALUES (:1.ID,:1.strTime,:1.Lat,:1.Lon,:1.Alt,:1.Yaw,:1.Roll,:1.Pitch,:1.Speed,:1.CO,:1.SO2,:1.NO2,:1.O3,:1.PM10,:1.PM25,:1.NH3,:1.CO2,:1.H2S,:1.Temp,:1.Dumidity)")
	public int addUavData(Uav uav);
	
}