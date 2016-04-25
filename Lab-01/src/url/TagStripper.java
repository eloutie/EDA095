package url;

import java.io.IOException;
import java.io.Writer;

import javax.swing.text.html.HTMLEditorKit;

public class TagStripper extends HTMLEditorKit.ParserCallback {
	private Writer out;

	public TagStripper(Writer out) {
		this.out = out;
	}

	public void handleText(char[] text, int position) {
		try {
			out.write(text);
			out.flush();
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}
}
