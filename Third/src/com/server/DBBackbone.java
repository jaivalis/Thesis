package com.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.joda.time.DateTime;
/*
 * Singleton class.
 */
public class DBBackbone {
	private static Connection con;
	private static final org.joda.time.format.DateTimeFormatter dateOnlyFormat =
			org.joda.time.format.DateTimeFormat.forPattern("YYYY-MM-dd");
	private static final org.joda.time.format.DateTimeFormatter dtf =
			org.joda.time.format.DateTimeFormat.forPattern("YYYY-MM-dd HH:mm:ss");

	private static DBBackbone instance = null;
	private static Statement stmt;

	private static void connectToDB() {
		String url		= "jdbc:mysql://localhost:3306/";
		String dbName	= "logdbb";
		String driver	= "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "zoot";
		try {
			Class.forName(driver).newInstance();
			con = DriverManager.getConnection(url+dbName,userName,password);
			System.out.println("Connected to the database...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static DBBackbone getInstance() {
		if(instance == null) {
			instance = new DBBackbone();
			connectToDB();
		}
		return instance;
	}

	protected DBBackbone() { }

	@Override
	public void finalize() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Specific day
	public ResultSet getTransactionsFromDay(int site, DateTime dt) {
		//SELECT * FROM logdbb.transactions where tDateAndTime>'2012-08-15 00:00:00' AND tDateAndTime<'2012-08-15 23:59:59'
		String date = dateOnlyFormat.print(dt);
		String query = "SELECT * FROM transactions WHERE site = " + site +
				" AND tDateAndTime>'" + date + " 00:00:00' AND tDateAndTime<'" + date + " 23:59:59' AND SUserSessionID<>'-'";
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public ResultSet getTransactionsFromDays(int site, DateTime dateTime, int daysForth) {
		String date = dateOnlyFormat.print(dateTime);
		String endDate = dateOnlyFormat.print(dateTime.plusDays(daysForth));
		String query = "SELECT * FROM transactions WHERE site = " + site +
				" AND tDateAndTime>'" + date + " 00:00:00' AND tDateAndTime<'" + endDate + " 23:59:59' AND SUserSessionID<>'-'";
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public ResultSet getSessionsFromDays(int site, DateTime dateTime, int daysForth) {
		String date = dateOnlyFormat.print(dateTime);
		String endDate = dateOnlyFormat.print(dateTime.plusDays(daysForth));
		String query = "SELECT DISTINCT SUserSessionID,aRemoteIPAddress FROM transactions WHERE site = " + site +
				" AND tDateAndTime>'" + date + " 00:00:00' AND tDateAndTime<'" + endDate + " 23:59:59' AND SUserSessionID<>'-'";
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// used in map
	public ResultSet getDistinctIPsFromDays(int site, DateTime dateTime, int daysForth) {
		//SELECT DISTINCT aRemoteIPAddress FROM logdbb.transactions WHERE
		//	tDateAndTime>'2012-08-15 00:00:00' AND tDateAndTime<'2012-08-15 23:59:59'
		String date = dateOnlyFormat.print(dateTime);
		String endDate = dateOnlyFormat.print(dateTime.plusDays(daysForth));
		String query = "SELECT DISTINCT aRemoteIPAddress FROM transactions WHERE site = " + site +
				" AND tDateAndTime>'" + date + " 00:00:00' AND tDateAndTime<'" + endDate + " 23:59:59' AND SUserSessionID<>'-'";
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// XXX: UNUSED
	public ResultSet getTransactionsFromPastHours(int site, int hours) {
		//SELECT * FROM logdbb.transactions where site = 15 AND tDateAndTime>'2012-08-01 16:00:44';
		DateTime dt = new DateTime();
		dt = dt.minusHours(hours);
		String date = dtf.print(dt);
		String query = "SELECT * FROM transactions WHERE site = " + site + " AND tDateAndTime > '" + date + "'";
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public ResultSet getActiveSessionsForPastMinutes(int site, int mins) {
		//SELECT DISTINCT aRemoteIPAddress FROM logdbb.transactions where site = 15 AND tDateAndTime>55000
		DateTime dt = new DateTime();
		dt = dt.minusMinutes(mins);
		String date = dtf.print(dt);
		String query = "SELECT DISTINCT aRemoteIPAddress,tDateAndTime,SUserSessionID FROM transactions " +
				"WHERE site = " + site + " AND tDateAndTime > '" + date + "'";
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public ResultSet getDistinctAgentsSessionsForPastDays(int site, int days) {
		//SELECT DISTINCT SUserSessionID,agent FROM logdbb.transactions where site = 15 AND tDateAndTime>'2012-08-01 16:00:44'
		DateTime dt = new DateTime();
		dt = dt.minusDays(days);
		String date = dateOnlyFormat.print(dt);
		String query = "SELECT DISTINCT SUserSessionID,agent FROM transactions " +
				"WHERE site=" + site + " AND tDateAndTime>'" + date + "' AND SUserSessionID<>'-'  AND agent<>'-'";
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public ResultSet getDistinctAgentsForPastDays(int site, int days) {
		//SELECT DISTINCT agent FROM logdbb.transactions where site = 15 AND tDateAndTime>'2012-08-01 16:00:44' AND agent<>'null'
		DateTime dt = new DateTime();
		dt = dt.minusDays(days);
		String date = dateOnlyFormat.print(dt);
		String query = "SELECT DISTINCT agent FROM transactions " +
				"WHERE site = " + site + " AND tDateAndTime > '" + date + "' AND SUserSessionID<>'-' AND agent<>'null'";
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * Code is the auto-number of the DB. Called for real-time update.
	 * @param lastCode is the Code of the last transmitted entry.
	 */
	public ResultSet getOnlineUsers(int site, int lastCode) {
		//SELECT * FROM logdbb.transactions where entryCode>55000;
		String query = "SELECT * FROM transactions WHERE site = " + site + " AND code > " + lastCode;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/* XXX: not yet used
	 * Code is the auto-number of the DB. Called for real-time update.
	 * @param lastCode is the Code of the last transmitted entry.
	 */
	public ResultSet getTransactionsAfter(int site, int lastCode) {
		//SELECT * FROM logdbb.transactions where entryCode>55000;
		String query = "SELECT * FROM transactions WHERE site = " + site + " AND code > " + lastCode;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// Specific day
	public long getBytesForDay(int site, DateTime dateTime) {
		//SELECT * FROM logdbb.transactions where tDateAndTime>'2012-08-15 00:00:00' AND tDateAndTime<'2012-08-15 23:59:59'
		String date = dateOnlyFormat.print(dateTime);
		String query = "SELECT SUM(BBytesSent) FROM transactions WHERE site = " + site +
				" AND tDateAndTime>'" + date + " 00:00:00' AND tDateAndTime<'" + date + " 23:59:59'";
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			return rs.getLong("BBytesSent");
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public long getTotalBytesForDateRange(int site, DateTime dateTime, int daysForth) {
		//SELECT SUM(BBytesSent) FROM logdbb.transactions where tDateAndTime>'2012-08-15 00:00:00' AND tDateAndTime<'2012-08-15 23:59:59'
		String date = dateOnlyFormat.print(dateTime);
		String endDate = dateOnlyFormat.print(dateTime.plusDays(daysForth));
		String query = "SELECT SUM(BBytesSent) FROM transactions WHERE site = " + site +
				" AND tDateAndTime>'" + date + " 00:00:00' AND tDateAndTime<'" + endDate + " 23:59:59'";
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			return rs.getLong("BBytesSent");
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public ResultSet getByteMsecSum(int site, int daysBack) {
		//Select sum(BBytesSent),sum(DMillisToProcess) FROM transactions WHERE site = 15 AND tDateAndTime > '2012-09-27 17:39:04'
		DateTime dt = new DateTime();
		dt = dt.minusDays(daysBack);
		String date = dateOnlyFormat.print(dt);
		String query = "SELECT SUM(BBytesSent),SUM(DMillisToProcess) FROM transactions WHERE site = " + site +
				" AND tDateAndTime>'" + date + " 00:00:00'";
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public ResultSet getReferers(int site, int daysBack) {
		//SELECT DISTINCT SUserSessionID,referer FROM transactions WHERE site=15 AND tDateAndTime>'2012-08-01 02:02:51'
		//AND referer NOT LIKE '%caivalis.dyndns%' AND referer NOT LIKE '%localhost%';
		String query = "";
		if (daysBack != -1) {
			DateTime dt = new DateTime();
			dt = dt.minusDays(daysBack);
			String date = dateOnlyFormat.print(dt);
			query = "SELECT DISTINCT SUserSessionID,referer FROM transactions WHERE site = " + site +
					" AND tDateAndTime>'" + date + " 00:00:00' AND referer NOT LIKE '%caivalis.dyndns%' AND referer NOT LIKE '%localhost%'";
		}
		else {
			query = "SELECT DISTINCT SUserSessionID,referer FROM transactions WHERE site = " + site +
					" AND referer NOT LIKE '%caivalis.dyndns%' AND referer NOT LIKE '%localhost%'";
		}
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
