package com.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	long getTotalBytesForDateRange(int site, String dt, int daysForth);

	//	Pair<String, Integer> getBytesFromDay(int site, String dt,
	//			AsyncCallback<Object> callback);

	SerializableContainer getBytesForDateRange(int site, String date, int daysForth);

	SerializableContainer getVisitorLocationsForDateRange (int site, String date, int daysForth);

	/*
	 * Returns the total number of visitors for the past @param mins minutes
	 */
	int getActiveSessionsForThePastXMins(int site, int mins);

	/*
	 * Returns a SerializableContainer containing pairs of <# of Minute, #of visitors> for each minute
	 * within this range : [-@param: containerSize, 0].
	 */
	SerializableContainer getActiveSessionsForPastMins(int site, int containerSize);

	SerializableContainer getOSForPastDays(int site, int containerSize);

	SerializableContainer getBrowserForPastDays(int site, int containerSize);

	double getAverageSpeed(int site, int daysBack);

	SerializableContainer getReferersForPastDays(int site, int containerSize);
}
