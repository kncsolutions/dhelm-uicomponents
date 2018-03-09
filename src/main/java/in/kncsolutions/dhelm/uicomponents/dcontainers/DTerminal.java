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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text; 
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.ScrollPane;
/**
*
*/
public  class DTerminal{
private BorderPane bPane;
private ToolBar maintoolBar; 
private StackPane descriptionBox,rightContainer;
private TabPane tCenterPane,tRightPane,tBottomPane;
private Tab t;
private VBox v;
private Text description;
private ScrollPane spR;

/**
*
*/
public DTerminal(){
  maintoolBar = new ToolBar();
  tCenterPane=new TabPane();
  tBottomPane=new TabPane();
  tRightPane=new TabPane();
  t=new Tab();
  t.setText("Home");
  bPane=new BorderPane();
  bPane.setTop(maintoolBar);
  setCentre();
  setBottom();
}
/**
*This method is used to set the main toolbar contents
*/
public void setMainToolBar(){
}
/**
*This method is used to set the centre  contents
*/
private void setCentre(){
  descriptionBox=new StackPane();
  descriptionBox.setPadding(new Insets(5, 5, 5, 5));
  descriptionBox.setAlignment(Pos.TOP_CENTER);
  v=new VBox();
  v.setPadding(new Insets(5, 5, 5, 5));
  v.setAlignment(Pos.TOP_CENTER);
  Label l1=new Label("DHELM");
  l1.setFont(Font.font ("Verdana",FontWeight.BOLD, 20));
  l1.setTextFill(Color.BLUE);
  v.getChildren().add(l1);
  descriptionBox.getChildren().add(v);
  t.setContent(descriptionBox);
  tCenterPane.getTabs().add(t);
  bPane.setCenter(tCenterPane);
}
/**
*
*/
private void setBottom(){
  bPane.setBottom(tBottomPane);
}
/**
*
*/
public void setRight(){
  rightContainer=new StackPane();
  rightContainer.setPadding(new Insets(5, 5, 5, 5));
  rightContainer.setAlignment(Pos.TOP_CENTER);
  spR=new ScrollPane(tRightPane);
  rightContainer.getChildren().add(spR);
  bPane.setRight(rightContainer);
}

/**
*@return Returns the home tab.
*/
public Tab getHomeTab(){
  return t;
}

/**
*@return Returns the main background.
*/
public BorderPane getMainBackground(){
  return bPane;
}
/**
*@param tab : The tab to be added to center panel
*/
public void addToCenterPanel(Tab tab){
  tCenterPane.getTabs().add(tab);
}
/**
*@param tab : The tab to be added to bottom panel
*/
public void addToBottomPanel(Tab tab){
  tBottomPane.getTabs().add(tab);
}
/**
*@param tab : The tab to be added to right panel
*/
public void addToRightPanel(Tab tab){
  tRightPane.getTabs().add(tab);
}

/**
*@return Returns the main toolbar.
*/
public ToolBar getMainToolBar(){
  return maintoolBar;
}
/**
*@return Returns the main toolbar.
*/
public VBox getCenterPanel(){
  return v;
}
/**
*
*/
}