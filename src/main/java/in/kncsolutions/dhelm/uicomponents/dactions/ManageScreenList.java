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
package in.kncsolutions.dhelm.uicomponents.dactions;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Color;
import javafx.scene.layout.Region;
import javafx.scene.Node;
import javafx.collections.FXCollections;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.controlsfx.control.textfield.TextFields;
/**
*
*/
public abstract class ManageScreenList{
private GridPane gp;
private StackPane cBox;
private VBox bg;
private HBox slHolder;
private ComboBox listSelector,stockSelector;
private final List<String> listScreen=Arrays.asList("SL1", "SL2", "SL3","SL4","SL5");
private Label als,sl; 
private TableView tView;
private TableColumn stockSymbol,ltp,change;
private Button add;
/**
*
*/
public ManageScreenList(){
  als = new Label("Select Screen list : ");
  als.setFont(Font.font ("Verdana",FontWeight.BOLD, 20));
  als.setTextFill(Color.BLUE);
  bg=new VBox();
  gp=new GridPane();
  gp.setPadding(new Insets(5, 5, 5, 5));
  gp.setAlignment(Pos.TOP_CENTER); 
  cBox=new StackPane();
  initListSelector(); 
  initStockSelector();
  initList();  
  gp.add(als,0,0);
  gp.add(listSelector,1,0);
  gp.add(sl,0,1);
  gp.add(slHolder,1,1);  
  bg.getChildren().add(gp);
  bg.getChildren().add(cBox);
}
/**
*
*/
private void initListSelector(){
  listSelector=new ComboBox();
  listSelector.setStyle("-fx-font: 15px \"Serif\";-fx-font-weight: bold;");
  listSelector.setMinWidth(250);
  listSelector.getItems().addAll(listScreen);
  listSelector.getSelectionModel().selectFirst();
}
/**
*
*/
private void initStockSelector(){
  sl = new Label("Search : ");
  sl.setFont(Font.font ("Verdana",FontWeight.BOLD, 20));
  sl.setTextFill(Color.BLUE);
  stockSelector=new ComboBox();
  //stockSelector.setPrefWidth((listSelector.getWidth()*2)/3);
  stockSelector.getItems().addAll(getStockList());
  stockSelector.getSelectionModel().selectFirst();
  stockSelector.setEditable(true);
  TextFields.bindAutoCompletion(stockSelector.getEditor(), stockSelector.getItems());
  add=new Button("Add");
  //add.setPrefWidth((listSelector.getWidth()*1)/3);
  slHolder=new HBox();
  slHolder.getChildren().add(stockSelector);
  slHolder.getChildren().add(add);
  slHolder.setMinWidth(listSelector.getWidth());
}
/**
*
*/
public abstract List<String> getStockList();
/**
*
*/
private void initList(){
  tView = new TableView();
  stockSymbol = new TableColumn("Stock");
  ltp = new TableColumn("LTP");
  change = new TableColumn("% Change");
  tView.getColumns().addAll(stockSymbol,ltp, change);
  cBox.getChildren().add(tView);
}
/**
*@return Returns the MangeScreenList panel  contained in a VBox.
*/
public VBox getManageScreenListPanel(){
  return bg;
}

}