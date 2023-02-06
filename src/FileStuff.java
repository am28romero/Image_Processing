import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors

public class FileStuff {
    public static void main(String[] args) {
        try {
            FileWriter myWriter = new FileWriter("log.txt");
            myWriter.write("");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}