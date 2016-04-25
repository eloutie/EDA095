package runnableRunner;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import executorRunner.ExecutorRunner;
import threadRunner.ThreadRunner;
import url.LinkGetter;

public class MainRunner {
	
	private static int THREAD_COUNT = 3;
	
	public static URL getNextElement() {
		return null;
	}
	
	public static void main(String args[]) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Skriv en url: ");
		String myURL = scan.next();
		List<URL> URLlist = new ArrayList<URL>();
		URL url = null;
		
		try {
			url = new URL(myURL);
			LinkGetter lg = new LinkGetter();
			List<String> list = lg.getLinks(url.toString());

			for (String s : list) {
				if (s.endsWith(".pdf")) {
					URL u = new URL(url, s);
					URLlist.add(u);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		System.out.println("Vilken metod vill du köra?\n"
				+ "1: RunnableRunner\n"
				+ "2: ThreadRunner\n"
				+ "3: ExecutableRunner");
		
		switch (scan.nextInt()) {
			case 1: for(URL u : URLlist) {
					Thread t = new Thread(new RunnableRunner(u));
					t.run();
					}
					break;
			case 2: for (int i = 0; i < 20; i++) {
					new Thread(new ThreadRunner(URLlist)).start();
					}
					break;
			case 3: ExecutorService pool = Executors.newFixedThreadPool(THREAD_COUNT);
					for (URL u : URLlist) {
						ExecutorRunner task = new ExecutorRunner(u);
						pool.submit(task);
					}
					pool.shutdown();
					break;
			default: break;
		}
		scan.close();
	}
}
