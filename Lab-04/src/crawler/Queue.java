package crawler;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Queue {
	private ArrayList<URL> toVisit;
	private Set<URL> visited;
	private ArrayList<URL> emailAddresses;

	public Queue(String start) {
		toVisit = new ArrayList<URL>();
		visited = Collections.synchronizedSet(new HashSet<URL>());
		emailAddresses = new ArrayList<URL>();
	}
	
	public synchronized void pushURL(URL url) {
		if(!visited.contains(url)) {
			toVisit.add(url);
			visited.add(url);
			notifyAll();
		}
	}
	
	public synchronized URL popURL(URL url) {
		while(toVisit.isEmpty()) {
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		int index = toVisit.indexOf(url);
		return toVisit.remove(index);
	}

	public synchronized boolean isEmpty() {
		return toVisit.isEmpty();
	}
}
