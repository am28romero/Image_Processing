import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class Testing {
	public static void main(String[] args) {
		try (
			BufferedInputStream in = new BufferedInputStream(new URL("https://www.w3schools.com/images/img_backend_300.png").openStream());
			FileOutputStream fileOutputStream = new FileOutputStream("img_backend_300.png")) {
				byte[] dataBuffer = new byte[1024];
				int bytesRead;
				while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
					fileOutputStream.write(dataBuffer, 0, bytesRead);
				}
		} catch (IOException e) {
			// handle exception
		}
	}
}