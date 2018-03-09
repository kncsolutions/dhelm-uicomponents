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
import javafx.scene.layout.Pane;
/**
*
*/
public class DRightPanel{
private StackPane cBox;
/**
*
*/
public DRightPanel(){
  cBox=new StackPane();
}
/**
*Removes the output ui.
*/
public void cleanRightPane(){
  cBox.getChildren().clear();
}

/**
*@param params : right pane node.
*/
public void setContent(Pane params){
  cBox.getChildren().clear();
  cBox.getChildren().add(params);
}
/**
*@returns a stackpane
*/
public StackPane getDRightPanel(){
  return cBox;
}
}