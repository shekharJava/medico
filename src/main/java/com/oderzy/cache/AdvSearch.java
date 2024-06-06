package com.oderzy.cache;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class AdvSearch {

	// private Object high;
	// {alphabates, nameKey}
	private static ConcurrentHashMap<String, HashSet<String>> allKeys;
	// {alphabates, Keywords}
	private static ConcurrentHashMap<String, HashSet<String>> allKeywords;
	// {alphabates, products }
	private static ConcurrentHashMap<String, HashSet<String>> allItems;
	private static double highPercent = 0.0;
	private static String highlyMatchKey;

	@PostConstruct
	private void initalize() {

		allKeys = new ConcurrentHashMap<String, HashSet<String>>();
		allKeywords = new ConcurrentHashMap<String, HashSet<String>>();
		allItems = new ConcurrentHashMap<String, HashSet<String>>();

		//noinspection DuplicatedCode
		allKeys.put("a", new HashSet<>());
		allKeys.put("b", new HashSet<>());
		allKeys.put("c", new HashSet<>());
		allKeys.put("d", new HashSet<>());
		allKeys.put("e", new HashSet<>());
		allKeys.put("f", new HashSet<>());
		allKeys.put("g", new HashSet<>());
		allKeys.put("h", new HashSet<>());
		allKeys.put("i", new HashSet<>());
		allKeys.put("j", new HashSet<>());
		allKeys.put("k", new HashSet<>());
		allKeys.put("l", new HashSet<>());
		allKeys.put("m", new HashSet<>());
		allKeys.put("n", new HashSet<>());
		allKeys.put("o", new HashSet<>());
		allKeys.put("p", new HashSet<>());
		allKeys.put("r", new HashSet<>());
		allKeys.put("s", new HashSet<>());
		allKeys.put("t", new HashSet<>());
		allKeys.put("u", new HashSet<>());
		allKeys.put("v", new HashSet<>());
		allKeys.put("w", new HashSet<>());
		allKeys.put("y", new HashSet<>());
		allKeys.put("1", new HashSet<>());
		allKeys.put("5", new HashSet<>());
		allKeys.put("2", new HashSet<>());

		//noinspection DuplicatedCode
		allItems.put("a", new HashSet<>());
		allItems.put("b", new HashSet<>());
		allItems.put("c", new HashSet<>());
		allItems.put("d", new HashSet<>());
		allItems.put("e", new HashSet<>());
		allItems.put("f", new HashSet<>());
		allItems.put("g", new HashSet<>());
		allItems.put("h", new HashSet<>());
		allItems.put("i", new HashSet<>());
		allItems.put("j", new HashSet<>());
		allItems.put("k", new HashSet<>());
		allItems.put("l", new HashSet<>());
		allItems.put("m", new HashSet<>());
		allItems.put("n", new HashSet<>());
		allItems.put("o", new HashSet<>());
		allItems.put("p", new HashSet<>());
		allItems.put("r", new HashSet<>());
		allItems.put("s", new HashSet<>());
		allItems.put("t", new HashSet<>());
		allItems.put("u", new HashSet<>());
		allItems.put("v", new HashSet<>());
		allItems.put("w", new HashSet<>());

		//noinspection DuplicatedCode
		allKeywords.put("a", new HashSet<>());
		allKeywords.put("b", new HashSet<>());
		allKeywords.put("c", new HashSet<>());
		allKeywords.put("d", new HashSet<>());
		allKeywords.put("e", new HashSet<>());
		allKeywords.put("f", new HashSet<>());
		allKeywords.put("g", new HashSet<>());
		allKeywords.put("h", new HashSet<>());
		allKeywords.put("i", new HashSet<>());
		allKeywords.put("j", new HashSet<>());
		allKeywords.put("k", new HashSet<>());
		allKeywords.put("l", new HashSet<>());
		allKeywords.put("m", new HashSet<>());
		allKeywords.put("n", new HashSet<>());
		allKeywords.put("o", new HashSet<>());
		allKeywords.put("p", new HashSet<>());
		allKeywords.put("r", new HashSet<>());
		allKeywords.put("s", new HashSet<>());
		allKeywords.put("t", new HashSet<>());
		allKeywords.put("u", new HashSet<>());
		allKeywords.put("v", new HashSet<>());
		allKeywords.put("w", new HashSet<>());
		allKeywords.put("y", new HashSet<>());

	}

	/* -------------------- RetrivalOperations */

	public ConcurrentHashMap<String, HashSet<String>> getKeys() {
		return allKeys;
	}

	public ConcurrentHashMap<String, HashSet<String>> getItems() {
		return allItems;
	}

	public String singleMatch(String name) {
		double highest = 0.0;
		String finalMatch = null;
		List<String> matchesOutput = match(name);
		for (String item : matchesOutput) {
			double curr = similarity(name, item);
			if (highest < curr) {
				highest = curr;
				finalMatch = item;
			}
		}
		return finalMatch;
	}

	public List<String> match(String name) {
		name = name.toLowerCase();
		List<String> matchesOutput = new ArrayList<>();
		double high = 0;
		String max = "";
		Set<String> finalSet;
		List<String> matches = new ArrayList<>();
		List<String> multiMatch = new ArrayList<>();
		List<String> matchedKeys = this.matchedKey(name);

		for (String mkk : matchedKeys) {
			String firstChar = mkk.substring(0, 1).toLowerCase();
			try {
				allItems.get(firstChar).stream().forEach(a -> {
					if (a.contains(mkk)) {

						if (matches.contains(a)) {
							multiMatch.add(a);
						}
						matches.add(a);
					}

				});
			} catch (NullPointerException ne) {
				matches.forEach(m -> {
					if (m.contains(mkk))
						multiMatch.add(m);

				});

			}
		}
		if (multiMatch.size() > 0) {
			double _curr;
			for (String mm : multiMatch) {
				_curr = similarity(name, mm);
				// System.out.println(_curr+" "+mm);
				if (high < _curr) {
					max = mm;
					high = _curr;
				}
			}
			matchesOutput.add(max);
			matchesOutput.addAll(multiMatch);
		} else
			matchesOutput = matches;

		finalSet = new HashSet<String>(matchesOutput);
		matchesOutput = new ArrayList<String>(finalSet);
		return matchesOutput;
	}

	private List<String> matchedKey(String name) {
		List<String> listHigh;
		List<String> listaverage;
		Set<String> uniq;
		List<String> HIGHmatchedKeys = new ArrayList<>();

		for (String nameKey : name.split(" ")) {
			String firstChar = null;

			try {
				firstChar = nameKey.substring(0, 1).toLowerCase();
				highPercent = 0;
				if (allKeys.get(firstChar).contains(nameKey))
					HIGHmatchedKeys.add(nameKey);
				else {
					listHigh = new ArrayList<>();
					listaverage = new ArrayList<>();
					for (String k : allKeys.get(firstChar)) {
						double curr = similarity(nameKey, k);
						if (curr > 0.4) {
							System.out.println(nameKey + "----" + curr + " ......" + k);
							if (highPercent < curr) {
								highPercent = curr;
								highlyMatchKey = k;
							}
							if (curr > 0.65)
								listHigh.add(k);
							else
								listaverage.add(k);

						}
					}
					HIGHmatchedKeys.add(highlyMatchKey);

					if (listaverage.size() > 3 && listHigh.size() != 0)
						HIGHmatchedKeys.addAll(listHigh);
					else
						HIGHmatchedKeys.addAll(listaverage);
					listaverage = null;
					listHigh = null;
				}
			} catch (NullPointerException n) {
			} catch (StringIndexOutOfBoundsException e) {
				// TODO: handle exception
			}

		}
		uniq = new HashSet<>(HIGHmatchedKeys);
		HIGHmatchedKeys = new ArrayList<String>(uniq);
		return HIGHmatchedKeys;
	}

	///////////////////////////////////////////////////////////////////
	////////////////// Matching Keys //////////////////////////////////
	public List<String> allMatchedKey(String name) {
		Set<String> uniq;
		List<String> HIGHmatchedKeys = new ArrayList<>();

		for (String nameKey : name.split(" ")) {
			String firstChar = null;

			try {
				firstChar = nameKey.substring(0, 1).toLowerCase();
				highPercent = 0;
				allKeywords.get("t").forEach(s-> System.out.println(s));
				if (allKeywords.get(firstChar).contains(nameKey))
					HIGHmatchedKeys.add(nameKey);
				else {
					for (String k : allKeywords.get(firstChar)) {
						double curr = similarity(nameKey, k);
						System.out.println(nameKey +"----------"+curr+k);
						if (curr > 0.5)
							HIGHmatchedKeys.add(k);
					}
				}
			} catch (NullPointerException n) {
			} catch (StringIndexOutOfBoundsException e) {
				// TODO: handle exception
			}

		}
		uniq = new HashSet<>(HIGHmatchedKeys);
		HIGHmatchedKeys = new ArrayList<String>(uniq);
		
		return HIGHmatchedKeys;
	}

	//@PostConstruct
	public void refreshStocks() {
/*
		Executors.newSingleThreadExecutor().execute(new Runnable() {
			@Override
			public void run() {

				List<String> data = service.findAllItemsName("SBP001");
				data.forEach(nam -> {
					String[] keys = nam.split(" ");
					for (String key : keys) {
						try {
							String s = key.substring(0, 1).toLowerCase();
							allKeys.get(s).add(key.toLowerCase());
							allItems.get(s).add(nam.toLowerCase());

						} catch (NullPointerException e) {
						} catch (StringIndexOutOfBoundsException S) {
						}
					}

				});

				List<String> keydata = service.findAllItemsKeywords();
				keydata.forEach(nam -> {
					try {
						String[] keys = nam.split(" ");
						for (String key : keys) {
							String s = key.substring(0, 1).toLowerCase();
							allKeywords.get(s).add(key.toLowerCase());
						}
					} catch (NullPointerException e) {
					} catch (StringIndexOutOfBoundsException S) {
					}

				});

			}

		});*/
	}

	public static Double similarity(String s1, String s2) {
		@SuppressWarnings("DuplicatedCode") String longer = s1, shorter = s2;
		if (s1.length() < s2.length()) {
			longer = s2;
			shorter = s1;
		}
		int longerLength = longer.length();
		if (longerLength == 0) {
			return 1.0; /* both strings have zero length */
		}
		return (longerLength - getLevenshteinDistance(longer, shorter)) / (double) longerLength;
	}

	/**
	 * LevenshteinDistance copied from
	 * https://commons.apache.org/proper/commons-lang/javadocs/api-2.5/src-html/org/apache/commons/lang/StringUtils.html#line.6162
	 */
	public static int getLevenshteinDistance(String s, String t) {
		//noinspection DuplicatedCode
		if (s == null || t == null) {
			throw new IllegalArgumentException("Strings must not be null");
		}

		int n = s.length(); // length of s
		int m = t.length(); // length of t

		if (n == 0) {
			return m;
		} else if (m == 0) {
			return n;
		}

		if (n > m) {
			// swap the input strings to consume less memory
			String tmp = s;
			s = t;
			t = tmp;
			n = m;
			m = t.length();
		}

		int[] p = new int[n + 1]; // 'previous' cost array, horizontally
		int[] d = new int[n + 1]; // cost array, horizontally
		int[] _d ; // placeholder to assist in swapping p and d

		// indexes into strings s and t
		int i; // iterates through s
		int j; // iterates through t

		char t_j; // jth character of t

		int cost; // cost

		for (i = 0; i <= n; i++) {
			p[i] = i;
		}

		for (j = 1; j <= m; j++) {
			t_j = t.charAt(j - 1);
			d[0] = j;

			for (i = 1; i <= n; i++) {
				cost = s.charAt(i - 1) == t_j ? 0 : 1;
				// minimum of cell to the left+1, to the top+1, diagonally left and up +cost
				d[i] = Math.min(Math.min(d[i - 1] + 1, p[i] + 1), p[i - 1] + cost);
			}

			// copy current distance counts to 'previous row' distance counts
			_d = p;
			p = d;
			d = _d;
		}

		// our last action in the above loop was to switch d and p, so p now
		// actually has the most recent cost counts
		return p[n];
	}

	public static void set(double val) {
		highPercent = val;
	}

	public static double get() {
		return highPercent;
	}
}
