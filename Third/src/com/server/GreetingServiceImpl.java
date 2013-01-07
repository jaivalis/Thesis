package com.server;

import java.sql.ResultSet;

import org.joda.time.DateTime;

import com.client.GreetingService;
import com.client.SerializableContainer;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService {

	@Override
	public long getTotalBytesForDateRange(int site, String date, int daysForth) {
		return DBBackbone.getInstance().getTotalBytesForDateRange(site, new DateTime(date), daysForth);
	}

	@Override
	public SerializableContainer getBytesForDateRange(int site, String date, int daysForth) {
		ResultSet rs = DBBackbone.getInstance().getTransactionsFromDays(site, new DateTime(date), daysForth);
		SerializableContainer res = ResultSetAnalysis.getBytesForDateRange(rs);
		return res;
	}

	private static final org.joda.time.format.DateTimeFormatter dt =
			org.joda.time.format.DateTimeFormat.forPattern("YYYY-MM-dd");

	@Override
	public SerializableContainer getVisitorLocationsForDateRange(int site, String date, int daysForth) {
		if (date == null) {			// requested VisitorLocations for past days till current date
			DateTime initialDt = new DateTime();
			initialDt = initialDt.minusDays(daysForth);
			date = dt.print(initialDt);
		}
		ResultSet rs = DBBackbone.getInstance().getSessionsFromDays(site, new DateTime(date), daysForth);
		ResultSet distinctIPs = DBBackbone.getInstance().getDistinctIPsFromDays(site, new DateTime(date), daysForth);
		SerializableContainer res = ResultSetAnalysis.getVisitorLocations(rs, distinctIPs);
		return res;
	}

	@Override
	public int getActiveSessionsForThePastXMins(int site, int mins) {
		ResultSet transactionsForPastXMinutes = DBBackbone.getInstance().getActiveSessionsForPastMinutes(site, mins);
		int res = RealTimeResultSetAnalysis.getActiveSessionsCountForPastMinutes(transactionsForPastXMinutes);
		return res;
	}

	private static final org.joda.time.format.DateTimeFormatter dtf =
			org.joda.time.format.DateTimeFormat.forPattern("YYYY-MM-dd HH:mm:ss");

	@Override
	public SerializableContainer getActiveSessionsForPastMins(int site, int containerSize) {
		DateTime initialDt = new DateTime();
		String initialDate = dtf.print(initialDt.minusMinutes(containerSize)).substring(0,17)+"00";	// ignore seconds

		if ( containerSize <= 600 ) {			// go for minute precision
			ResultSet transactionsForPastXMinutes = DBBackbone.getInstance().getActiveSessionsForPastMinutes(site, containerSize);
			return RealTimeResultSetAnalysis.getActiveSessionsForPastMinutes(transactionsForPastXMinutes, initialDate);
		} else if (containerSize <= 1440) {		// go for 30 mins precision (daily visits)
			ResultSet transactionsForPastXMinutes = DBBackbone.getInstance().getActiveSessionsForPastMinutes(site, containerSize);
			return ResultSetAnalysis.getActiveSessionsForPastHalfHours(transactionsForPastXMinutes, initialDate);
		} else if (containerSize <= 10080) {	// go for hourly precision (weekly visits)
			ResultSet transactionsForPastXMinutes = DBBackbone.getInstance().getActiveSessionsForPastMinutes(site, containerSize);
			return ResultSetAnalysis.getActiveSessionsForPastHours(transactionsForPastXMinutes, initialDate);
		} else {								// if (containerSize <= 1440 * 30 ) {	// go for daily precision (monthly visits)
			ResultSet transactionsForPastXMinutes = DBBackbone.getInstance().getActiveSessionsForPastMinutes(site, containerSize);
			return ResultSetAnalysis.getActiveSessionsForPastDays(transactionsForPastXMinutes, initialDate);
		}
	}

	@Override
	public SerializableContainer getOSForPastDays(int site, int days) {
		ResultSet agentsSessions = DBBackbone.getInstance().getDistinctAgentsSessionsForPastDays(site, days);
		ResultSet agents = DBBackbone.getInstance().getDistinctAgentsSessionsForPastDays(site, days);
		SerializableContainer res = RealTimeResultSetAnalysis.getOS(agentsSessions, agents);
		return res;

	}

	@Override
	public SerializableContainer getBrowserForPastDays(int site, int days) {
		ResultSet agentsSessions = DBBackbone.getInstance().getDistinctAgentsSessionsForPastDays(site, days);
		ResultSet agents = DBBackbone.getInstance().getDistinctAgentsSessionsForPastDays(site, days);
		SerializableContainer res = RealTimeResultSetAnalysis.getBrowser(agentsSessions, agents);
		return res;
	}

	@Override
	public double getAverageSpeed(int site, int daysBack) {
		ResultSet bytesMsecs = DBBackbone.getInstance().getByteMsecSum(site, daysBack);
		return ResultSetAnalysis.getAverageSpeed(bytesMsecs);
	}

	@Override
	public SerializableContainer getReferersForPastDays(int site, int daysBack) {
		ResultSet referers = DBBackbone.getInstance().getReferers(site, daysBack);
		return ResultSetAnalysis.getReferers(referers);
	}
}
