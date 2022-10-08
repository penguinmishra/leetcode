package com.code.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/time-based-key-value-store/
 */
public class TimeMap {

	private Map<String, List<ValueTimePair>> m = new HashMap<>();

	public TimeMap() {
		m = new HashMap<>();
	}

	public void set(String key, String value, int timestamp) {
		if (!m.containsKey(key)) m.put(key, new ArrayList<>());
		m.get(key).add(new ValueTimePair(value, timestamp));
	}

	public String get(String key, int timestamp) {
		if (!m.containsKey(key)) return "";

		String result = "";
		List<ValueTimePair> l = m.get(key);
		int left = 0, right = l.size() - 1;
		while (left <= right) {
			int m = left + (right - left) / 2;
			ValueTimePair tv = l.get(m);
			if (tv.t <= timestamp) {
				/*
				 * if we found a tv where time <= given timestamp, save it to result because it
				 * might be the only occurrence.
				 */
				result = tv.v;
				/* Move left index one step forward and keep looking for a higher tv time */
				left = m + 1;
			} else right = m - 1;
		}
		return result;
	}
}

class ValueTimePair {
	String v;
	int t;

	public ValueTimePair(String v, int t) {
		this.v = v;
		this.t = t;
	}
}
