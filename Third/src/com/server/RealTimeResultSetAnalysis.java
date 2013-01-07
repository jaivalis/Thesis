package com.server;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.client.SerializableContainer;
import com.google.gwt.dev.util.collect.HashMap;

public class RealTimeResultSetAnalysis {


	public static SerializableContainer getActiveSessionsForPastMinutes(ResultSet rs, String initialDate) {
		SerializableContainer res = new SerializableContainer();
		Set<String> uniqueSessions = new HashSet<String>();
		String time, prevTime = "";
		try {
			while (rs.next()) {
				time = rs.getString("tDateAndTime").substring(0, 16) + ":00";	// substring ignores seconds
				if (!time.equals(prevTime)) {									// new minute
					if (!prevTime.equals("")) { 								//  > must make an entry for the previous minute
						uniqueSessions.remove("-");								// some entries don't have 'SUserSessionID' column
						res.put(prevTime, uniqueSessions.size());
						uniqueSessions = new HashSet<String>();
					}
				}
				uniqueSessions.add(rs.getString("SUserSessionID"));
				prevTime = time;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Util.fillEmptyValues(res, initialDate);
	}

	public static int getActiveSessionsCountForPastMinutes(ResultSet rs) {
		Set<String> uniqueSessions = new HashSet<String>();
		try {
			while (rs.next()) {
				uniqueSessions.add(rs.getString("SUserSessionID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return uniqueSessions.size();
	}

	public static SerializableContainer getOS(ResultSet agentsSessions, ResultSet agents) {
		SerializableContainer res = new SerializableContainer();
		HashMap<String, String> agentToOS = new HashMap<String, String>();	// translates agent to os
		String agent;
		try {
			while (agents.next()) {		// this way I avoid calling Util many times.
				agent = agents.getString("agent");
				agentToOS.put(agent, Util.getOS(agent));
			}
			while (agentsSessions.next()) {
				agent = agentsSessions.getString("agent");
				res.increment(agentToOS.get(agent));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public static SerializableContainer getBrowser(ResultSet agentsSessions, ResultSet agents) {
		SerializableContainer res = new SerializableContainer();
		HashMap<String, String> agentToBrowser = new HashMap<String, String>();	// translates agent to browser
		String agent;
		try {
			while (agents.next()) {		// this way I avoid calling Util many times.
				agent = agents.getString("agent");
				agentToBrowser.put(agent, Util.getBrowser(agent));
			}
			while (agentsSessions.next()) {
				agent = agentsSessions.getString("agent");
				res.increment(agentToBrowser.get(agent));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}


}
