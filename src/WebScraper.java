import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WebScraper {
	public static void main(String[] args) throws IOException {
		LocalDateTime now = LocalDateTime.now();

		// Initialize the file writer
		FileWriter myWriter;
		try {
			// Start the File writer and name it log.txt in the append mode
			myWriter = new FileWriter("log.txt",true);
			myWriter.write("\n\n" + now.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + "\n"); //
			System.out.println(now.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}

		// Connect to the website using the Jsoup library
		Document doc = Jsoup.connect("https://www.w3schools.com/tags/default.asp").get();

		// Get all image elements on the page
		Elements images = doc.select("img[src]");
		for (Element image : images) {
			// Get the image source URL and log to the text file
			String src = image.attr("src");
			System.out.println("Image URL: " + src);
			myWriter.write("Image URL: " + src + "\n");
		}

		// Get all divs in the selected website and print out all of their attributes
		Elements divs = doc.select("div");
		for (Element div : divs) {
			assert div != null;
			String className = div.attr("class");
			System.out.println("Div Classname: " + className);

			div.attributes().forEach(System.out::println);
			div.attributes().forEach(x -> {
				try {
					myWriter.write("Div Attributes: " + x + "\n");
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			});
		}
		// Close the file writer and save the file
		myWriter.close();
	}
}