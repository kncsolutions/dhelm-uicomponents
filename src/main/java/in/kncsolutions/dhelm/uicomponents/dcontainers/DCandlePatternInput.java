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
import in.kncsolutions.dhelm.chart.ChartParameters;
import in.kncsolutions.dhelm.mathcal.ValidityChecker;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
/**
*
*/
public abstract class DCandlePatternInput{
private GridPane gp;
private Label title,exTitle,ct;
private Text id_ae,id_be;
private RadioButton ae_id,be_id;
public static String SelectedExchange;
private ToggleGroup exchange;
private ComboBox ctSelector;
private Label brn,lrn,lsPercentage,trn,percentageLs,percentageUs;
private TextField brnTf,lrnTf,lsPercentageTf,trnTf,percentageLsTf,percentageUsTf;
private Button help,scan;
public  boolean IsCandleScanning=false;
/**
*
*/
public DCandlePatternInput(){
  setInputParamUI();
}
/**
*
*/
private void setInputParamUI(){
  title = new Label("Set Parameters:: ");
  title.setFont(Font.font ("Verdana",FontWeight.BOLD, 16));
  title.setTextFill(Color.BLACK);
  exTitle = new Label("Select Exchange: ");
  exTitle.setFont(Font.font ("Verdana",FontWeight.BOLD, 14));
  exTitle.setTextFill(Color.BLUE);
  exchange = new ToggleGroup();
  gp=new GridPane();
  gp.setPadding(new Insets(5, 5, 5, 5));
  
  gp.setAlignment(Pos.TOP_CENTER);
  gp.setVgap(5);
  gp.add(title,0,0);
  gp.add(exTitle,0,1);
  
  setExchangeSelector();
  
  ct=new Label("Chart DataGap: ");
  ct.setFont(Font.font ("Verdana",FontWeight.BOLD, 14));
  ct.setTextFill(Color.BLUE);
  ctSelector=new ComboBox();
  ctSelector.setStyle("-fx-font: 15px \"Serif\";-fx-font-weight: bold;");
  ctSelector.setMinWidth(250);
  setChartDataGapList();
  gp.add(ct,0,3);
  gp.add(ctSelector,1,3);
  setInputParameterFields();

  }
/**
*
*/
private void setChartDataGapList(){
       ctSelector.getItems().addAll(Arrays.asList(ChartParameters.ChartDataGapList));
       ctSelector.getSelectionModel().selectFirst();
       ctSelector.valueProperty().addListener(new ChangeListener<String>(){
        @Override public void changed(ObservableValue ov, String t, String t1){
          System.out.println(t1);
          ChartParameters.setChartDataGap(t1);
        }    
    });


}

/**
*
*/
private void setExchangeSelector(){
  id_ae=new Text("A Stock Exchange");
  id_ae.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
  id_be=new Text("B Stock Exchange ");
  id_be.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
  ae_id=new RadioButton(id_ae.getText());
  ae_id.setSelected(true);        
  ae_id.setToggleGroup(exchange);
  ae_id.setFont(Font.font("Tahoma", FontWeight.BOLD, 12));        
  be_id=new RadioButton(id_be.getText());
  be_id.setSelected(false);    
  be_id.setFont(Font.font("Tahoma", FontWeight.BOLD, 12));
  be_id.setToggleGroup(exchange);
  gp.add(ae_id,0,2);
  gp.add(be_id,1,2);

  exchange.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
    public void changed(ObservableValue<? extends Toggle> ov,
        Toggle old_toggle, Toggle new_toggle) {
        String str="";
            if (exchange.getSelectedToggle() != null) {
                if(exchange.getSelectedToggle().equals(ae_id)){
                    SelectedExchange="A Stock Exchange";                    
                }
                if(exchange.getSelectedToggle().equals(be_id)){
                    SelectedExchange="B Stock Exchange";                    
                }
                System.out.println("Seleted item is: "+SelectedExchange);
            }                
        }
        });


  
}
/**
*
*/
private void setInputParameterFields(){
  brn = new Label("Body Reference Number ");
  brn.setFont(Font.font ("Verdana",FontWeight.BOLD, 14));
  brn.setTextFill(Color.BLUE);
  brnTf=new TextField();
  brnTf.setMinWidth(250);
  gp.add(brn,0,4);
  gp.add(brnTf,1,4);
  
  lrn = new Label("Length Reference Number ");
  lrn.setFont(Font.font ("Verdana",FontWeight.BOLD, 14));
  lrn.setTextFill(Color.BLUE);
  lrnTf=new TextField();
  lrnTf.setMinWidth(250);
  gp.add(lrn,0,5);
  gp.add(lrnTf,1,5);
  
  lsPercentage = new Label("Long Short  Reference Percentage ");
  lsPercentage.setFont(Font.font ("Verdana",FontWeight.BOLD, 14));
  lsPercentage.setTextFill(Color.BLUE);
  lsPercentageTf=new TextField();
  lsPercentageTf.setMinWidth(250);
  gp.add(lsPercentage,0,6);
  gp.add(lsPercentageTf,1,6);


  trn = new Label("Previous trend Reference Number of periods ");
  trn.setFont(Font.font ("Verdana",FontWeight.BOLD, 14));
  trn.setTextFill(Color.BLUE);
  trnTf=new TextField();
  trnTf.setMinWidth(250);
  gp.add(trn,0,7);
  gp.add(trnTf,1,7);
  
  percentageLs = new Label("Lower Shadow Percentage Reference ");
  percentageLs.setFont(Font.font ("Verdana",FontWeight.BOLD, 14));
  percentageLs.setTextFill(Color.BLUE);
  percentageLsTf=new TextField();
  percentageLsTf.setMinWidth(250);
  gp.add(percentageLs,0,8);
  gp.add(percentageLsTf,1,8);
  
  percentageUs = new Label("Upper Shadow Percentage Reference ");
  percentageUs.setFont(Font.font ("Verdana",FontWeight.BOLD, 14));
  percentageUs.setTextFill(Color.BLUE);
  percentageUsTf=new TextField();
  percentageUsTf.setMinWidth(250);
  gp.add(percentageUs,0,9);
  gp.add(percentageUsTf,1,9);
  
  gp.getStylesheets().add("Dbutton.css");
  help=new Button("Instructions");
  help.getStyleClass().add("btn-theme3");
  scan=new Button("START SCANNING");
  scan.getStyleClass().add("btn-theme3");
  scan.setMinWidth(250);
  setScanControl();
  gp.add(help,0,10);
  gp.add(scan,1,10);
}
/**
*
*/
private void setScanControl(){
  scan.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
            public void handle(ActionEvent event) {
                System.out.println("Start Scanning...");               
               if(getChartDataGap()==null || getBodyReferenceNumber()==0 || getLengthReferenceNumber()==0
                    ||  getLongShortPercentage()==0 || getTrendReferenceNumber()==0
                    ||  getLowerShadowPercentage()==0 || getUpperShadowPercentage()==0){
                    DPopUp.Warn("Enter Valid data..");                    
                }
                else{
                    setScanButtonControl();                  
                }

              }
            
        });


}
/**
*
*/
public abstract void setScanButtonControl();
/**
*@return Returns the panel containing the input interface for scanning candle patterns.
*/
public ToggleGroup getExchangeToggle(){
  return exchange;
}
/**
*The task of this function is to remove the selectors for demo exchanges.
*/
public void removeDemoExchanges(){
 gp.getChildren().remove(ae_id);
 gp.getChildren().remove(be_id);

}
/**
*@param b pass true if presently scanning is in progress.
*/
public void setCandleScanningStatus(Boolean b){
  IsCandleScanning=b;
}

/**
*@return returns true if presently scanning is in progress.
*/
public boolean getCandleScanningStatus(){
  return IsCandleScanning;
}
/**
*@retun Returns the selected chart type from the set {"select","day","minute","3minute","5minute",
*                                             "10minute","15minute","30minute",
*                                             "60minute","week"}
*/
public String getChartDataGap(){
  if(!ChartParameters.getChartDataGap().equals("select"))
    return ChartParameters.getChartDataGap();
  return null;
}
/**
*@return Returns an integer entered by the user which indicates the number of previous periods with 
*respect to which the computation of the body type for the lates candle will be done. Latest body can be a long or short one. 
*/
public int getBodyReferenceNumber(){
   if(brnTf.getText()!=null && ValidityChecker.IsObjectInteger(brnTf.getText()))
     return Integer.parseInt(brnTf.getText());
   return 0;
}
/**
*@return Returns an integer entered by the user which indicates the number of previous periods with 
*respect to which the computation of the length type for the lates candle will be done. Latest candle can be a long or short one. 
*/
public int getLengthReferenceNumber(){
   if(lrnTf.getText()!=null && ValidityChecker.IsObjectInteger(lrnTf.getText()))
     return Integer.parseInt(lrnTf.getText());
   return 0;
}
/**
*@return Returns an double value entered by the user which indicates the percentage by which if the length of the latest candle exceeds the average length of certain previous
*candle, it will be treated as a long candle,otherwise short. 
*/
public double getLongShortPercentage(){
   if(lsPercentageTf.getText()!=null&& ValidityChecker.IsObjectDouble(lsPercentageTf.getText()))
     return Double.parseDouble(lsPercentageTf.getText());
   return 0;
}
/**
*@return Returns an integer entered by the user which indicates the number of previous periods with 
*respect to which the trend will be computed.
*/
public int getTrendReferenceNumber(){
   if(trnTf.getText()!=null && ValidityChecker.IsObjectInteger(trnTf.getText()))
     return Integer.parseInt(trnTf.getText());
   return 0;
}
/**
*@return Returns an double value entered by the user which indicates the percentage by which lower shadow can be smaller than the body
*in certain candle stick patterns.
*/
public double getLowerShadowPercentage(){
   if(percentageLsTf.getText()!=null&& ValidityChecker.IsObjectDouble(percentageLsTf.getText()))
     return Double.parseDouble(percentageLsTf.getText());
   return 0;
}
/**
*@return Returns an double value entered by the user which indicates the percentage by which upper shadow can be smaller than the body
*in certain candle stick patterns.
*/
public double getUpperShadowPercentage(){
   if(percentageUsTf.getText()!=null&& ValidityChecker.IsObjectDouble(percentageUsTf.getText()))
     return Double.parseDouble(percentageUsTf.getText());
   return 0;
}
/**
*@return the START SCAN button. 
*/
public Button getStartScanButton(){
  return scan;
}

/**
*@param s:  Set an integer programatiicaly which indicates the number of previous periods with 
*respect to which the computation of the body type for the lates candle will be done. Latest body can be a long or short one. 
*/
public void setBodyReferenceNumber(int s){
   brnTf.setText(Integer.toString(s));
}
/**
*@param s:  Set an integer programatiicaly which indicates the number of previous periods with 
*respect to which the computation of the length type for the lates candle will be done. Latest candle can be a long or short one. 
*/
public void setLengthReferenceNumber(int s){
  lrnTf.setText(Integer.toString(s));
}
/**
*param s:  Set an double value programatiicaly which indicates the percentage by which if the length of the latest candle exceeds the average length of certain previous
*candle, it will be treated as a long candle,otherwise short. 
*/
public void setLongShortPercentage(double s){
   lsPercentageTf.setText(Double.toString(s));
}
/**
*param s:  Set an integer programatiicaly which indicates the number of previous periods with 
*respect to which the trend will be computed.
*/
public void setTrendReferenceNumber(int s){
   trnTf.setText(Integer.toString(s));
}
/**
*param s:  set an double value programatiicaly which indicates the percentage by which lower shadow can be smaller than the body
*in certain candle stick patterns.
*/
public void setLowerShadowPercentage(double s){
   percentageLsTf.setText(Double.toString(s));
}
/**
*param s:  Set a double value programatiicaly which indicates the percentage by which upper shadow can be smaller than the body
*in certain candle stick patterns.
*/
public void setUpperShadowPercentage(double s){
  percentageUsTf.setText(Double.toString(s));
}


/**
*@return Returns the panel containing the input interface for scanning candle patterns.
*/
public GridPane getView(){
  return gp;
}
}
