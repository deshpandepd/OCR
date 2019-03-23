import org.opencv.imgcodecs.Imgcodecs;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.opencv.core.*;
import org.opencv.imgproc.*; 
class OCRTest{
	 public static void main(String[] args) {

		    // Load the native library.
		        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		        new OCRTest().analysis();
		    }
    public void analysis(){

        Mat Main = Imgcodecs.imread("SS2.png", Imgcodecs.IMREAD_UNCHANGED);  // Highgui.imread("/.../Ole.png");
        Mat rgb = new Mat();

        Imgproc.pyrUp(Main, rgb);
  
        Imgproc.resize(rgb, rgb, new Size(990, 400));
        Mat imgGray = new Mat();
        Imgproc.cvtColor(rgb, imgGray, Imgproc.COLOR_BGR2GRAY);
        Imgcodecs.imwrite("Gray.jpg", imgGray);
        
        
        Mat imgGaussianBlur = new Mat(); 
        Imgproc.GaussianBlur(imgGray,imgGaussianBlur,new Size(3, 3),0);
        Imgcodecs.imwrite("gaussian_blur.jpg", imgGaussianBlur);  
        
        
        Mat imgAdaptiveThreshold = new Mat();
        Imgproc.adaptiveThreshold(imgGaussianBlur, imgAdaptiveThreshold, 200, Imgproc.ADAPTIVE_THRESH_MEAN_C,
                Imgproc.THRESH_BINARY, 9, 12);
        imgAdaptiveThreshold.convertTo(imgAdaptiveThreshold, -1, 2, 50); 
        
        int erosion_size = 3;
        int dilation_size = 3;
        
        Mat element = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new  Size(2*erosion_size + 1, 2*erosion_size+1));
        Imgproc.equalizeHist(imgAdaptiveThreshold, imgAdaptiveThreshold);
        Imgcodecs.imwrite("adaptive_threshold.jpg", imgAdaptiveThreshold);
        
        
        
        
    }
}