package wasdev.sample.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.TargetDataLine;

import org.apache.commons.io.FileUtils;

import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.speech_to_text.v1.RecognizeOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;
import com.ibm.watson.developer_cloud.speech_to_text.v1.websocket.BaseRecognizeDelegate;
import com.ibm.watson.developer_cloud.util.CredentialUtils;

@WebServlet("/SimpleServlet")
public class Speech extends HttpServlet {
   
	 private SpeechToText s2t = new SpeechToText();
	 
	 public String voz_a_texto(String direccionAudio) throws ServletException, IOException{
	   s2t.setUsernameAndPassword("fe0c1e3d-4bce-4310-b6e0-4c256e1b6f25", "LOrTEqJhjYSc");
	   SpeechResults results = s2t.recognize(new File(direccionAudio));
	   System.out.println(results.getResults().get(0).toString());
	   return results.getResults().get(0).toString();
	   
	 }
 
	 public static void main(String[] args) throws ServletException, IOException {
		 Speech ss = new Speech();
		 ss.voz_a_texto("C:/Users/Sussana/Downloads/Es_ES_spk24_16khz.wav");
	}
	 
 private static final long serialVersionUID = 1L;

}
