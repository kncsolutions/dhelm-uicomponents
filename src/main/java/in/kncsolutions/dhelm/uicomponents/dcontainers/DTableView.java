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
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.geometry.Insets;
import java.util.ArrayList;
import java.util.List;
/**
*
*/
public abstract class DTableView{
private Label tableTitle;
private TableView tView;
final VBox container = new VBox();
/**
*@param title : Title of the table.
@param t : The list of all the table columns.
*/
public DTableView(String title){
  tableTitle=new Label(title);
  tableTitle.setFont(new Font("Arial", 14));
  container.setSpacing(5);
  container.setPadding(new Insets(10, 0, 0, 10));
  tView=new TableView();
}
/**
*
*/
public  void setColumns(List<TableColumn> t){
  for(int i=0;i<t.size();i++){
    tView.getColumns().add(t.get(i));
  }
}
/**
*@return Returns the table view which will contain all data
*/
public TableView getTableView(){
  return tView;
}
/**
*@return returns the VBox containing the table along with all other items.
*/
public VBox getWholeContainer(){
  container.getChildren().addAll(tableTitle,tView);
  return container;
}
}