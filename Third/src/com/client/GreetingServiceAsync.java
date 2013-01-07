package com.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void getTotalBytesForDateRange(int shop, String dt, int daysForth, AsyncCallback<Long> callback);

	//	void getBytesFromDay(int shop, String dt, AsyncCallback<Object> callback,
	//			AsyncCallback<Pair<String, Integer>> callback2);

	void getBytesForDateRange(int site, String date, int daysForth,
			AsyncCallback<SerializableContainer> asyncCallback);

	void getVisitorLocationsForDateRange(int site, String date, int daysForth,
			AsyncCallback<SerializableContainer> callback);

	void getActiveSessionsForThePastXMins(int site, int mins, AsyncCallback<Integer> callback);

	void getActiveSessionsForPastMins(int site, int containerSize, AsyncCallback<SerializableContainer> callback);

	void getBrowserForPastDays(int site, int containerSize, AsyncCallback<SerializableContainer> callback);

	void getOSForPastDays(int site, int containerSize, AsyncCallback<SerializableContainer> callback);

	void getAverageSpeed(int site, int daysBack, AsyncCallback<Double> callback);

	void getReferersForPastDays(int site, int containerSize, AsyncCallback<SerializableContainer> callback);
}
