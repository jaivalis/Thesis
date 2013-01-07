package com.server;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.joda.time.DateTime;


import nl.bitwalker.useragentutils.UserAgent;

import com.client.SerializableContainer;

public class Util {

	private static final org.joda.time.format.DateTimeFormatter dtf =
			org.joda.time.format.DateTimeFormat.forPattern("YYYY-MM-dd HH:mm:ss");

	/*
	 * Expensive. Not to be called frequently.
	 */
	public static String getIPLocation(String ip) {
		String loc = "Unresolved";
		InetAddress addr;
		try {
			addr = InetAddress.getByName(ip);
			loc = addr.getCanonicalHostName();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		String country = loc.substring(loc.length()-3).replaceAll("[^A-Za-z]", "").toUpperCase();
		if (country.equals("OST") || country.equals("NET"))	return "";
		if (country.equals("COM"))	return "US";
		if (country.equals("UK"))	return "GB";
		return country;
	}

	public static int lengthOf(ResultSet rs) {
		int i = 0;
		try {
			while (rs.next()) {	 i++; }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public static String getMatchingHalfHour(String time) {
		int minute = Integer.parseInt(time.substring(14, 16));
		if (minute<30) {
			return time.substring(0, 14) + "00:00";
		} else {
			return time.substring(0, 14) + "30:00";
		}
	}

	public static String getMatchingDay(String time) {
		return time.substring(0, 10) + " 00:00:00";
	}

	public static SerializableContainer fillEmptyValues(SerializableContainer sc, String firstDateTime) {
		DateTime dt = dtf.parseDateTime(firstDateTime);
		String date = dtf.print(dt);
		DateTime curDate = new DateTime();
		String currDate = dtf.print(curDate).substring(0,17)+"00";
		while (!date.equals(currDate)) {
			date = dtf.print(dt);
			if (!sc.containsKey(date)) {
				sc.putVisitorCount(date, 0);
			}
			dt = dt.plusMinutes(1);
		}
		return sc;
	}

	public static SerializableContainer fillEmptyHalfHourValues(SerializableContainer sc, String initialDateTime) {
		DateTime dt = dtf.parseDateTime(initialDateTime);
		String date = getMatchingHalfHour(dtf.print(dt));
		DateTime curDate = new DateTime();
		String currDate = getMatchingHalfHour(dtf.print(curDate).substring(0,17)+"00");
		while (!date.equals(currDate)) {
			date = getMatchingHalfHour(dtf.print(dt));
			if (!sc.containsKey(date)) {
				sc.putVisitorCount(date, 0);
			}
			dt = dt.plusMinutes(30);
		}
		return sc;
	}

	public static String getBrowser(String userAgent) {
		return 	UserAgent.parseUserAgentString(userAgent).getBrowser().getName();
	}

	public static String getOS(String userAgent) {
		return 	UserAgent.parseUserAgentString(userAgent).getOperatingSystem().getName();
	}

	public static SerializableContainer fillEmptyDaysValues(SerializableContainer sc, String initialDateTime) {
		DateTime dt = dtf.parseDateTime(initialDateTime);
		String date = getMatchingDay(dtf.print(dt));
		DateTime curDate = new DateTime();
		String currDate = getMatchingDay(dtf.print(curDate));
		while (!date.equals(currDate)) {
			date = getMatchingDay(dtf.print(dt));
			if (!sc.containsKey(date)) {
				sc.putVisitorCount(date, 0);
			}
			dt = dt.plusDays(1);
		}
		return sc;
	}

	public static String getMatchingHour(String time) {
		return time.substring(0, 13) + ":00:00";
	}


	public static SerializableContainer fillEmptyHourValues(SerializableContainer sc, String initialDateTime) {
		DateTime dt = dtf.parseDateTime(initialDateTime);
		String date = getMatchingHour(dtf.print(dt));
		DateTime curDate = new DateTime();
		String currDate = getMatchingHour(dtf.print(curDate));
		while (!date.equals(currDate)) {
			date = getMatchingHour(dtf.print(dt));
			if (!sc.containsKey(date)) {
				sc.putVisitorCount(date, 0);
			}
			dt = dt.plusHours(1);
		}
		return sc;
	}
}
