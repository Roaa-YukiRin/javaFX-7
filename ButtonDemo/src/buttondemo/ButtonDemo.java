/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buttondemo;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author HP
 */
public class ButtonDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       Text text = new Text(50, 50, "JavaFX Programming");

                Pane paneForText = new Pane();
          paneForText.getChildren().add(text);
          
          HBox paneForButtons = new HBox(20);
//               // ImageView l = new ImageView("sample/images/L.png");
//             //   l.setFitWidth(10);
//             //   l.setFitHeight(10);
//                ImageView r = new ImageView("sample/images/R.png");
//                r.setFitWidth(10);
//                r.setFitHeight(10);
//           
                Button btLeft = new Button("Left" );
                Button btRight = new Button("Right");
                
                btLeft.setContentDisplay(ContentDisplay.LEFT);
                btRight.setContentDisplay(ContentDisplay.RIGHT);
                
                paneForButtons.getChildren().addAll(btLeft, btRight);
                paneForButtons.setAlignment(Pos.CENTER);
                paneForButtons.setStyle("-fx-border-color: green");

                BorderPane paneForAll = new BorderPane();
                paneForAll.setBottom(paneForButtons);
                paneForAll.setCenter(paneForText);
                
                //onaction
                    btLeft.setOnAction(e -> text.setX(text.getX() - 10));
                    btRight.setOnAction(e -> text.setX(text.getX() + 10));
                    

          Scene scene = new Scene(paneForAll, 400, 200);
          primaryStage.setTitle("ButtonDemo");
          primaryStage.setScene(scene); 
          primaryStage.show();
             }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
