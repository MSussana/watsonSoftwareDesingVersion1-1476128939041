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
import com.ibm.watson.developer_cloud.language_translation.*;
import com.ibm.watson.developer_cloud.language_translation.v2.*;
import com.ibm.watson.developer_cloud.language_translation.v2.model.*;
import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;
import com.ibm.watson.developer_cloud.util.CredentialUtils;


@WebServlet("/SimpleServlet")
public class Translation extends HttpServlet{
		
	private LanguageTranslation s2t = new LanguageTranslation();
	
	@Override
	public void init() throws ServletException {
	   super.init();
	   String vcap = System.getProperty("VCAP_SERVICES");
	   if (vcap == null){
	     try {
	       vcap = FileUtils.readFileToString(new File("C:/Users/Sussana/Downloads/vcap.txt"));
	     } catch (IOException e) {
	       e.printStackTrace();
	     }
	   }
	   CredentialUtils.setServices(vcap);
	   s2t.setApiKey(CredentialUtils.getAPIKey("language_translation"));
	 }

	 public void traducir() throws ServletException, IOException{
		s2t.setUsernameAndPassword("40a32988-cc12-4b21-84c4-afc9cf73bcc6", "OL3Jz2ojbLuo");
	   TranslationResult result = s2t.translate("hello", "en", "es");
	   System.out.println(result);
	   
	 }

private static final long serialVersionUID = 1L;

}

