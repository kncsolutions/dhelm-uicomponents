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
package in.kncsolutions.dhelm.uicomponents.dbutton;
import javafx.scene.control.Button;


/**
*
*/
public class Dbutton{
  private Button btn;
  /**
  *
  */
  public Dbutton(String title){
    btn = new Button(title);
	setCustomStyle();
  }
  
  /**
  *
  */
  private void setCustomStyle(){
    btn.getStylesheets().add("Dbutton.css");
	btn.getStyleClass().add("btn-theme1");
  }
  /**
  *@param i : The index for the inbuilt button themes.
  */
  public void chooseStyle(int i){
    btn.getStylesheets().add("Dbutton.css");
    switch(i){
	  case 1:
	    btn.getStyleClass().add("btn-theme1");
		break;
      case 2:
	   btn.getStyleClass().add("btn-theme2");
       break;
      case 3:
       btn.getStyleClass().add("btn-theme3"); 
	   break;
	}
	
  }
  /**
  *
  */
  public void setCustomStyle(String css,String theme){
    btn.getStylesheets().add(css);
	btn.getStyleClass().add(theme);
  }
  /**
  *@param width: set the preferred width.
  *@param height: set the preferred height.
  */
  public void setDimension(double width,double height){
	btn.setPrefWidth(width);
	btn.setPrefHeight(height);
  }
  /**
  *@return: Returns the customized button.
  */
  public Button getButton(){
    return btn;
  }
}