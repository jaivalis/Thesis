package com.client;

import java.util.Date;
import java.util.Set;
import java.util.TreeMap;

import ca.nanometrics.gflot.client.DataPoint;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.IsSerializable;

public class SerializableContainer implements IsSerializable{
	TreeMap<String, Integer> container;	// keeping entries sorted based on String key

	public SerializableContainer() { container = new TreeMap<String, Integer>();}

	//	public void incrementBy(String key, Integer value) {
	//		int prev = 0;
	//		if (value == 0)	return;
	//		if (container.containsKey(key)) {
	//			prev = container.get(key);
	//			container.remove(key);
	//		} container.put(key, value + prev);
	//	}

	/*
	 * replaces existing value with new one
	 */
	public void put(String key, Integer value) {
		if (value == 0)	return;
		if (container.containsKey(key)) {
			container.remove(key);
		} container.put(key, value);
	}

	public void putVisitorCount(String key, Integer value) {
		if (container.containsKey(key)) {
			container.remove(key);
		} container.put(key, value);
	}

	/*
	 * if @param key exists increment, else put(key,1)
	 */
	public void increment(String key) {
		int prev = 0;
		if (container.containsKey(key)) {
			prev = container.get(key);
			container.remove(key);
		} container.put(key, prev + 1);
	}

	public Set<String> keySet() {
		return container.keySet();
	}

	public int get(String key) {
		return container.get(key);
	}

	@SuppressWarnings("deprecation")
	public DataPoint[] getDateTimeDataPoint() {
		DataPoint[] res = new DataPoint[container.keySet().size() + 1];
		int i=0;
		Date date;
		String fullDate = "";
		DateTimeFormat dtf = DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss");
		for (String key: container.keySet()){
			if (key.length() != 19) { fullDate = key + " 00:00:00"; }
			else { fullDate = key; }
			date = dtf.parse(fullDate);

			long dt = Date.UTC( date.getYear(),
					date.getMonth(), date.getDate(), date.getHours(), date.getMinutes(),
					date.getSeconds() );
			res[i++] = new DataPoint(dt, container.get(key));
		}
		return res;
	}

	@SuppressWarnings("deprecation")
	public DataPoint[] getDateDataPoint() {
		DataPoint[] res = new DataPoint[container.keySet().size() + 1];
		int i=0;
		Date date = null;
		DateTimeFormat dtf = DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss");
		for (String key: container.keySet()){
			date = dtf.parse(key);

			long dt = Date.UTC( date.getYear(),
					date.getMonth(), date.getDate(), date.getHours(), date.getMinutes(),
					date.getSeconds() );
			res[i++] = new DataPoint(dt, container.get(key));
		}
		return res;
	}

	public boolean containsKey(String key) {
		return container.containsKey(key);
	}

	public int size() {
		return container.size();
	}

	@Override
	public String toString() {
		String s = "<Container size='" + size() + "'>";
		for (String k: container.keySet()){
			s += "\n\t{" + k + ", " + container.get(k) + "}";
		}
		return s + "\n</Container>";
	}
}
