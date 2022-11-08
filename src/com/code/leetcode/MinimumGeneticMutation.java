package com.code.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/minimum-genetic-mutation/
 */
public class MinimumGeneticMutation {
	public static void main(String[] args) {
		MinimumGeneticMutation o = new MinimumGeneticMutation();
		String startGene = "AACCGGTT";
		String endGene = "AACCGCTA";
		String[] bank = { "AACCGGTA", "AACCGCTA", "AAACGGTA" };
		System.out.println(o.minMutation(startGene, endGene, bank));
	}

	public int minMutation(String startGene, String endGene, String[] bank) {
		if (Objects.equals(startGene, endGene))
			return 0;

		if (bank.length == 0)
			return -1;

		int answer = 0;

		Queue<String> q = new LinkedList<>();
		Set<Character> charSet = new HashSet<>(List.of('A', 'C', 'G', 'T'));
		Set<String> bankSet = new HashSet<>();
		for (String bankStr : bank)
			bankSet.add(bankStr);

		q.offer(startGene);
		Set<String> visited = new HashSet<>();

		while (!q.isEmpty()) {
			int size = q.size(); // size of the q can increase/decrease inside the while loop. So, store in a variable
			while (size-- > 0) {
				String s = q.poll();
				visited.add(s);
				if (Objects.equals(s, endGene))
					return answer;
				char[] startCharArr = s.toCharArray();
				for (int i = 0; i < startCharArr.length; i++) {
					char a = startCharArr[i];
					for (char b : charSet) {
						startCharArr[i] = b;
						String m = new String(startCharArr);
						if (bankSet.contains(m) && !visited.contains(m)) {
							q.offer(m);
							visited.add(m);
						}
					}
					startCharArr[i] = a;
				}
			}
			answer += 1; // increment once size is consumed. Go on to next batch size
		}
		return -1;
	}
}

/**
 * int main() {
    // T varies depending on the problem
    queue<T> q;
    // a hash map to store if we've visited a node
    unordered_map<T, int> vis;
    // step count
    int steps = 0;
    // push the starting point to the queue
    q.push(start);
    // mark it visited
    vis[start] = 1;
    // BFS
    while (!q.empty()) {
        // iterate from the back because the size of q varies
        // which would result in wrong answer if you iterate from 0
        // alternatively, you can define a new variable for q.size() before the for-loop
        // i.e. 
        // int n = q.size();
        // for (int i = 0; i < n; i++) { 
        for (int i = q.size(); i > 0; i--) {
            // get the element from the queue
            auto current_node = q.front(); q.pop();
            // check if we reach the ending point
            if (current_node == end) return steps;
            {
                // some logic here
                // ...
                if (!vis[next_node]) {
                    // push the next node to the queue
                    q.push(next_node);
                    // and mark it visited
                    vis[next_node] = 1;
                }
            }
        }
        // increase the step count
        steps += 1;
    }
    return steps;
}*/
