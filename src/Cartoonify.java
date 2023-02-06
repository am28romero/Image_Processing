import org.opencv.core.*;
import org.opencv.highgui.HighGui;
import org.opencv.highgui.ImageWindow;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.photo.Photo;

public class Cartoonify {
    public static void main(String[] args) {
        // Load the OpenCV library
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        // Create a new black image with a size of 320x240
//        Mat image = new Mat(240, 320, CvType.CV_8UC3, new Scalar(0,0,0));
        Mat image = Imgcodecs.imread("C:\\Users\\AMR3579\\IdeaProjects\\Testing Proj\\src\\image.jpg");
        Imgproc.resize(image, image, new Size(360, 752));
        HighGui.imshow("Original Image", image);
        Mat cartoon = image.clone();

        // Convert the image to a cartoon
        Imgproc.bilateralFilter(image, cartoon, 1, 1000, 0.8f);
//        Photo.stylization(image, cartoon, 10, 0.5f);

        // Display the image in a window
        HighGui.imshow("Cartoonified Image", cartoon);
        HighGui.waitKey();

        // Save the cartoon image
        Imgcodecs.imwrite("cartoon.jpg", image);
    }
}