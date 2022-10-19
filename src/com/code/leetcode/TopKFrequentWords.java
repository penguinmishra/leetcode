package com.code.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/top-k-frequent-words/
 */
public class TopKFrequentWords {
	public static void main(String[] args) {
		TopKFrequentWords o = new TopKFrequentWords();
		String[] arr = { "i", "love", "leetcode", "i", "love", "coding" };
		System.out.println(o.topKFrequent(arr, 2));
		System.out.println(o.topKFrequent2(arr, 2));
	}

	public List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> m = new HashMap<>();
		for (String w : words) m.put(w, m.getOrDefault(w, 0) + 1);
		List<Map.Entry<String, Integer>> l = new ArrayList<>();
		l.addAll(m.entrySet());
		Collections.sort(l, (a, b) -> a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey())
				: b.getValue() - a.getValue());
		List<String> res = new ArrayList<>();
		for (int i = 0; i < k; i++) res.add(l.get(i).getKey());
		return res;
	}
	
	public List<String> topKFrequent2(String[] words, int k) {
		Map<String, Integer> m = new HashMap<>();
		for (String w : words)
			m.put(w, m.getOrDefault(w, 0) + 1);
		Queue<Map.Entry<String, Integer>> p = new PriorityQueue<>((a,
				b) -> a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
		for (Map.Entry<String, Integer> e : m.entrySet()) p.offer(e);
		List<String> l = new ArrayList<>();
		for (int i = 0; i < k; i++) l.add(p.poll().getKey());
		return l;
	}
}
