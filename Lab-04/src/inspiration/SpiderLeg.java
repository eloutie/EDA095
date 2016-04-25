package lab;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.lang.model.util.Elements;
import javax.swing.text.Document;
import javax.swing.text.html.parser.Element;

import org.jsoup.Jsoup;

public class SpiderLeg {
	
	private List<String> links = new LinkedList<String>(); // Just a list of URLs
	private Document htmlDocument; // This is our web page, or in other words, our document
	
	
	// Give it a URL and it makes an HTTP request for a web page
	public void crawl(String url)
    {
        try
        {
            Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
            Document htmlDocument = connection.get();
            this.htmlDocument = htmlDocument;

            System.out.println("Received web page at " + url);

            Elements linksOnPage = htmlDocument.select("a[href]");
            System.out.println("Found (" + linksOnPage.size() + ") links");
            for(Element link : linksOnPage)
            {
                this.links.add(link.absUrl("href"));
            }
        }
        catch(IOException ioe)
        {
            // We were not successful in our HTTP request
            System.out.println("Error in out HTTP request " + ioe);
        }
    }
	
	// Tries to find a word on the page
	public boolean searchForWord(String word) {
		return true;
	}
	
	// Returns a list of all the URLs on the page
	public List<String> getLinks() {
		List<String> l = new ArrayList<String>();
		return l;
	}
}