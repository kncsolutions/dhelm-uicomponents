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
package in.kncsolutions.dhelm.uicomponents.dcontainers;
import javafx.scene.layout.StackPane;


/**
*
*/
public class DstackPane{
  private StackPane sPane;
  /**
  *
  */
  public DstackPane(){
    sPane = new StackPane();
	setCustomStyle();
  }
  
  /**
  *
  */
  private void setCustomStyle(){
    sPane.getStylesheets().add("DstackPane.css");
	sPane.getStyleClass().add("stackpane-theme1");
  }
  
  /**
  *
  */
  public void setCustomStyle(String s){
	sPane.getStyleClass().add(s);
  }
  /**
  *@param width: set the preferred width.
  *@param height: set the preferred height.
  */
  public void setDimension(double width,double height){
	sPane.setPrefWidth(width);
	sPane.setPrefHeight(height);
  }
  /**
  *@return: Returns the customized stackpane.
  */
  public StackPane getStackPane(){
    return sPane;
  }
}