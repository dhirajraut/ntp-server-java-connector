package com.galaxy.util.ntpconnector;

import java.net.InetAddress;
import java.util.Date;

import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;
import org.apache.commons.net.ntp.TimeStamp;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class NtpConnector {

	static String NTP_SERVER = "time-a.nist.gov";
	
	public static void main(String[] args) throws Exception {
		
		log.info("System Time: " + new Date());

		InetAddress inetAddress = InetAddress.getByName(NTP_SERVER);
		NTPUDPClient timeClient = new NTPUDPClient();
		TimeInfo timeInfo = timeClient.getTime(inetAddress);

		long returnTime = timeInfo.getMessage().getTransmitTimeStamp().getTime();
		TimeStamp ntpTime = TimeStamp.getNtpTime(returnTime);
		log.info("NTP Time: " + ntpTime.toDateString());
	}
}
