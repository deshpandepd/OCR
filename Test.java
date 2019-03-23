import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;


public class Test {

	 static int width; 
	   static int height; 
	   static double alpha = 1 ;
	   static double beta = 100;
    public static void main(String[] args) throws DocumentException, MalformedURLException, IOException     {
    
    	
    	 
        try { 
    
           // For proper execution of native libraries 
           // Core.NATIVE_LIBRARY_NAME must be loaded before 
              // calling any of the opencv methods 
          System.loadLibrary( Core.NATIVE_LIBRARY_NAME ); 
    
           // input image 
           Mat source =   
            Imgcodecs.imread("openCVImg.jpg", Imgcodecs.IMREAD_COLOR); 
           Mat destination = new Mat(source.rows(), source.cols(), source.type()); 
    
           // applying brightness enhacement 
           source.convertTo(destination, -1, alpha, beta); 
    
           // output image 
           Imgcodecs.imwrite("openCVImg1.jpg", destination); 
             
        } catch (Exception e) { 
           System.out.println("error: " + e.getMessage()); 
        } 
    }

    
}