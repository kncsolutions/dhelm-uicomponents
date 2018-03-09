/**
*Copyright 2017 Pallav Nandi Chaudhuri@Knc Solutions Private Limited

*Licensed under the Apache License, Version 2.0 (the "License");
*you may not use this file except in compliance with the License.
*You may obtain a copy of the License at

* http://www.apache.org/licenses/LICENSE-2.0

*Unless required by applicable law or agreed to in writing, software
*distributed under the License is distributed on an "AS IS" BASIS,
*WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*See the License for the specific language governing permissions and
*limitations under the License.
*/
package in.kncsolutions.dhelm.uicomponents.dweb;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.concurrent.Worker.State;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.net.*;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;
import java.security.NoSuchAlgorithmException;
import java.security.KeyManagementException;
/**
*
*/
public class DwebView{
  private StackPane stackPane; 
  private final WebView browser;
  private final WebEngine webEngine;
  private String URL;
  /**
  *@url : The url which have to be opened in the webview by default.
  */
  public DwebView(String url){
  // System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
   allURLacceptor();
	browser = new WebView();
	webEngine = browser.getEngine();
	stackPane=new StackPane(browser);
	webEngine.setJavaScriptEnabled(true);
	/*webEngine.getLoadWorker().stateProperty()
        .addListener(new ChangeListener<State>() {
          @Override
          public void changed(ObservableValue ov, State oldState, State newState) {

            if (newState == Worker.State.SUCCEEDED) {
			  URL=webEngine.getLocation();
			  System.out.println(URL);
            }

          }
        });*/
	   CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
	   webEngine.load(url);
  }
  /**
  *
  */
  private void allURLacceptor(){
    try{
        TrustManager trm = new X509TrustManager() {
        public X509Certificate[] getAcceptedIssuers() {return null;}
        public void checkClientTrusted(X509Certificate[] certs, String authType) {}
        public void checkServerTrusted(X509Certificate[] certs, String authType) {}
    };

    SSLContext sc = SSLContext.getInstance("SSL");  
    sc.init(null, new TrustManager[] { trm }, null);
    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
    }catch(NoSuchAlgorithmException e){
    }catch(KeyManagementException e){}
  }
  /**
  *@param width: set the preferred width.
  *@param height: set the preferred height.
  */
  public void  setDimensions(double width,double height){
    stackPane.setPrefWidth(width);
	stackPane.setPrefHeight(height);
  }
  /**
  *@return : A StackPane containing the webview with desired url.
  */
  public StackPane getDwebView(){
    return stackPane;
  }
  /**
  *@return : Returns the redirected URL
  */
  public String getRedirectedUrl(){
    return URL;
  }
  /**
  *@return : Returns the WebEngine
  */
  public WebEngine getWebEngine(){
    return webEngine;
  }
}