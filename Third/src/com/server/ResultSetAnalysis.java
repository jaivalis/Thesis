package com.server;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Set;

import com.client.SerializableContainer;
import com.google.gwt.dev.util.collect.HashMap;

public class ResultSetAnalysis {

	public static float getAverageResponseTime(ResultSet rs, float currentResponseTime) {
		float totalBytes = 0;
		int records = 0;
		try {
			while (rs.next()) {
				totalBytes += rs.getInt("DMillisToProcess");
				records++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (records == 0)
			return 0;
		return (currentResponseTime + totalBytes/records)/2;
	}

	/*
	 * <Container size='2'>
	 *		{2012-08-15, 2311404}
	 *		{2012-09-03, 400395}
	 * </Container>
	 */
	public static SerializableContainer getBytesForDateRange(ResultSet rs) {
		SerializableContainer res = new SerializableContainer();
		try {
			while (rs.next()) { // split on " " to get date only (not time)
				res.put(rs.getString("tDateAndTime").split(" ")[0], rs.getInt("BBytesSent"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	//	public static int getTotalBytesSent(ResultSet rs) {
	//		int res = 0;
	//		try {
	//			while (rs.next()) {
	//				res += rs.getInt("BBytesSent");
	//			}
	//		} catch (SQLException e) {
	//			e.printStackTrace();
	//		} return res;
	//	}


	//	public static SerializableContainer getTotalBytesSentDaily(ResultSet rs) {
	//		SerializableContainer res = new SerializableContainer();
	//		try {
	//			while (rs.next()) {
	//				res.put(rs.getString("tDateAndTime"), rs.getInt("BBytesSent"));
	//			}
	//		} catch (SQLException e) {
	//			e.printStackTrace();
	//		}
	//		return res;
	//	}

	public static SerializableContainer getVisitorLocations(ResultSet rs, ResultSet distinctIPs) {
		SerializableContainer res = new SerializableContainer();
		HashMap<String, String> hm = new HashMap<String, String>();
		String code,ip;
		try {
			while (distinctIPs.next()) {
				code = Util.getIPLocation(distinctIPs.getString("aRemoteIPAddress"));
				hm.put(distinctIPs.getString("aRemoteIPAddress"), code);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				ip = hm.get(rs.getString("aRemoteIPAddress"));
				if (!ip.equals("")) {
					res.increment( ip );
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}


	public static SerializableContainer getActiveSessionsForPastHalfHours(ResultSet rs, String initialDate) {
		SerializableContainer res = new SerializableContainer();
		Set<String> uniqueSessions = new HashSet<String>();
		String extime, time, prevTime = "";
		try {
			while (rs.next()) {
				extime = rs.getString("tDateAndTime").substring(0, 16) + ":00";	// substring ignores seconds
				time = Util.getMatchingHalfHour(extime);
				if (!time.equals(prevTime)) {									// new minute
					if (!prevTime.equals("")) { 								//  > must make an entry for the previous minute
						//System.out.println(uniqueSessions.size());
						res.put(prevTime, uniqueSessions.size());
						uniqueSessions = new HashSet<String>();
						//System.out.println("~~"+uniqueSessions.size());
					}
				}
				uniqueSessions.add(rs.getString("SUserSessionID"));
				prevTime = time;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Util.fillEmptyHalfHourValues(res, initialDate);
		//return res;
	}

	public static SerializableContainer getActiveSessionsForPastHours(ResultSet rs, String initialDate) {
		SerializableContainer res = new SerializableContainer();
		Set<String> uniqueSessions = new HashSet<String>();
		String extime, time, prevTime = "";
		try {
			while (rs.next()) {
				extime = rs.getString("tDateAndTime");
				time = Util.getMatchingHour(extime);
				if (!time.equals(prevTime)) {									// new hour
					if (!prevTime.equals("")) { 								//  > must make an entry for the previous minute
						//System.out.println(uniqueSessions.size());
						res.put(prevTime, uniqueSessions.size());
						uniqueSessions = new HashSet<String>();
						//System.out.println("~~"+uniqueSessions.size());
					}
				}
				uniqueSessions.add(rs.getString("SUserSessionID"));
				prevTime = time;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Util.fillEmptyHourValues(res, initialDate);
		//return res;
	}

	public static SerializableContainer getActiveSessionsForPastDays(ResultSet rs, String initialDate) {
		SerializableContainer res = new SerializableContainer();
		Set<String> uniqueSessions = new HashSet<String>();
		String date, prevDate = "";
		try {
			while (rs.next()) {
				date = rs.getString("tDateAndTime").split(" ")[0];		// ignores time
				if (!date.equals(prevDate)) {							// new day
					if (!prevDate.equals("")) { 						//  > must make an entry for the previous minute
						res.put(prevDate, uniqueSessions.size());
						uniqueSessions = new HashSet<String>();
					}
				}
				uniqueSessions.add(rs.getString("SUserSessionID"));
				prevDate = date;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Util.fillEmptyDaysValues(res, initialDate);
		//return res;
	}

	public static double getAverageSpeed(ResultSet rs) {
		try {
			while (rs.next()) {
				double bytes = rs.getDouble("sum(BBytesSent)");
				double msecs = rs.getDouble("sum(DMillisToProcess)");
				return Double.parseDouble(new DecimalFormat("#.#").format(bytes/msecs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0.0;
		}
		return 0.0;
	}

	public static SerializableContainer getReferers(ResultSet rs) {
		SerializableContainer res = new SerializableContainer();
		String referer = "";
		try {
			while (rs.next()) {
				referer = rs.getString("referer");
				if (referer.equals("null")) referer = "deliberate hits";
				res.increment(referer);
			}
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
