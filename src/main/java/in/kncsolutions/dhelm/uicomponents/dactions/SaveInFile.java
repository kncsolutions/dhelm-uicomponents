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
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;
/**
*This class can be used to save the generated result in the specified format.
*/
public class SaveInFile{
private FileChooser fileChooser;
private File file;
/**
*@param stage The stage on which the save application has to be performed
*@param description: The description for extension filter of the file chooser
*@param extensions : The list of extensions for the file chooser.
*@param text: The text which have to be saved.
*/
public SaveInFile(Stage stage,String description,List<String> extensions,String text){
  fileChooser = new FileChooser();
  FileChooser.ExtensionFilter extFilter = 
                new FileChooser.ExtensionFilter(description,extensions);
  fileChooser.getExtensionFilters().add(extFilter);
  file = fileChooser.showSaveDialog(stage);
  if(file != null){
      saveInFile(text);
  }
}
/**
*@param stage The stage on which the save application has to be performed
*@param description: The description for extension filter of the file chooser
*@param extensions : The extensions for the file chooser.
*@param text: The text which have to be saved.
*/
public SaveInFile(Stage stage,String description,String extension,String text){
  fileChooser = new FileChooser();
  FileChooser.ExtensionFilter extFilter = 
                new FileChooser.ExtensionFilter(description,extension);
  fileChooser.getExtensionFilters().add(extFilter);
  file = fileChooser.showSaveDialog(stage);
  if(file != null){
      saveInFile(text);
  }
}

/**
*
*/
private void saveInFile(String text){
    try{
      FileWriter fileWriter;              
      fileWriter = new FileWriter(file);
      fileWriter.write(text);
      fileWriter.close();
      } catch (IOException ex) {
         ex.printStackTrace();
        }
}
}