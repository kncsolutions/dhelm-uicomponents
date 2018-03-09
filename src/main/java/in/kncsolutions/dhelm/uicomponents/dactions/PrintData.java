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
import javafx.print.JobSettings;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.transform.Scale;
import javafx.scene.layout.VBox;
/**
*
*/
public class PrintData{
private PrinterJob job;
private Printer printer;
private PageLayout pageLayout;
private JobSettings jobSettings;
/**
*
*/
public PrintData(Node node, Stage owner){
  job = PrinterJob.createPrinterJob();
  printer = job.getPrinter();
  pageLayout = printer.createPageLayout(Paper.A4, PageOrientation.LANDSCAPE, Printer.MarginType.HARDWARE_MINIMUM);
  double scaleX = pageLayout.getPrintableWidth() / (node.getBoundsInParent().getWidth());
  double scaleY = pageLayout.getPrintableHeight() / (node.getBoundsInParent().getHeight());
  jobSettings = job.getJobSettings();
  jobSettings.setPageLayout(pageLayout);
  System.out.println("ScaleX : "+node.getBoundsInParent().getWidth());
  System.out.println("ScaleY : "+node.getBoundsInParent().getHeight());
  node.getTransforms().add(new Scale(0.7, 0.7));
  if (job == null) {
   System.out.println("Cannot find printer");
	 return;
  }		
  // Show the page setup dialog
  //boolean proceed = job.showPageSetupDialog(owner);
  boolean proceed = job.showPrintDialog(owner);
  if (proceed){
    System.out.println("proceeding");
    PrintData(job, node);
  }
}
/**
*
*/
private void PrintData(PrinterJob job, Node node){
  boolean printed = job.printPage(node);
  if (printed){
    job.endJob();
  }
}
}