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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
*
*/
public class DPopUp{
public static Alert alert;
/**
*@param message:the warning message.
*/
public static void Warn(String message){
  alert = new Alert(AlertType.INFORMATION);
  alert.setTitle("Warning!!");
  alert.setHeaderText(null);
  alert.setContentText(message);
  alert.showAndWait();
}

}