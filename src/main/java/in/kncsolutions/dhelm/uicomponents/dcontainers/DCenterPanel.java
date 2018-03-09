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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.control.*;
import java.util.List;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Color;
import javafx.scene.layout.Region;
import javafx.scene.Node;
import javafx.collections.FXCollections;
/**
*
*/
public class DCenterPanel{
private GridPane gp;
private StackPane prmBox;
private VBox bg;
private ComboBox algoSelector;
private Label als; 
/**
*
*/
public DCenterPanel(){
  als = new Label("Select Algorithm : ");
  als.setFont(Font.font ("Verdana",FontWeight.BOLD, 20));
  als.setTextFill(Color.BLUE);
  bg=new VBox();
  gp=new GridPane();
  gp.setPadding(new Insets(5, 5, 5, 5));
  gp.setAlignment(Pos.TOP_CENTER);
  algoSelector=new ComboBox();
  algoSelector.setStyle("-fx-font: 15px \"Serif\";-fx-font-weight: bold;");
  algoSelector.setMinWidth(250);
  gp.add(als,0,0);
  gp.add(algoSelector,1,0);
  prmBox=new StackPane();
  bg.getChildren().add(gp);
  bg.getChildren().add(prmBox);
}
/**
*@param algoList : List of algorithms by name.
*/
public void setAlgoList(List<String> algoList){
  algoSelector.getItems().addAll(algoList);
}
/**
*Removes the input field ui.
*/
public void cleanParamPane(){
  prmBox.getChildren().clear();
}

/**
*@param params : Input fields to get user parameters for selected algorithm.
*/
public void setParamPane(Pane params){
  prmBox.getChildren().clear();
  prmBox.getChildren().add(params);
}
/**
*@return Returns the center panel  contained in a VBox.
*/
public VBox getDCenterPanel(){
  return bg;
}
/**
*@return Returns the center panel algorithm selector panel contained in a GridPane.
*/
public GridPane getDAlgoSelectorPanel(){
  return gp;
}
/**
*@return Returns the algorithm selector combobox.
*/
public ComboBox getAlgoSelector(){
  return algoSelector;
}
}