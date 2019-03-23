import static org.junit.Assert.assertTrue;

import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.lept.PIX;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.tesseract.TessBaseAPI;
import org.bytedeco.javacpp.lept;
 



public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 BytePointer outText;

	        TessBaseAPI api = new TessBaseAPI();
	        api.SetVariable("tessedit_char_whitelist", "()0123456789,abcdefghijklmnopqrstuvwxyzABCDEFGHJKLMNPQRSTUVWXY");
	        // Initialize tesseract-ocr with English, without specifying tessdata path
	        if (api.Init(".", "ENG") != 0) {
	            System.err.println("Could not initialize tesseract.");
	            System.exit(1);
	        }
	     
lept l = new lept();
	        // Open input image with leptonica library
 	        PIX image = l.pixRead("adaptive_threshold.jpg");
	        api.SetImage(image); 
	        
	        // Get OCR result
	        outText = api.GetUTF8Text();
	        String string = outText.getString();
 	        System.out.println("OCR output:\n" + string);

	       
	        api.End();
	        outText.deallocate();
	        
	}

}
