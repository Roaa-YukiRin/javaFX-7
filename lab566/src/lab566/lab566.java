/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */

package lab566;


import java.io.PrintWriter;
import java.time.LocalDate;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author mac
 */
public class lab566 extends Application {
    Scene WarehouseInventory ;    //Warehouse Inventory Scene
    Scene SearchScene ;  //Search Scene
    
    //
    java.io.File file=new java.io.File("item.txt");
    PrintWriter output;
    @Override
    public void start(Stage primaryStage) {
      
        //######## Task1: Observablelists
        //
        ObservableList<String> obItems =FXCollections.observableArrayList("Rice");
        ObservableList<String>  obQuantity=FXCollections.observableArrayList("100KG");
        ObservableList<String>  obCategory=FXCollections.observableArrayList("Sereal");
       ObservableList<String>  obExDate=FXCollections.observableArrayList("2022-10-10");
       ObservableList<String>   obItemFilter=FXCollections.observableArrayList();


        //The WarehouseInventory Scene ------------------------------------------------------------------------------------------

        Label ItemName  = new Label("Item Name: ");
        Label ItemQuantity  = new Label("Item Quantity: ");
        Label ItemCategory  = new Label("Item Category: ");
        Label ItemExDate  = new Label("Item Expiry Date: ");
   
        TextField txItemName = new TextField();
        TextField txQuantity = new TextField();
        ComboBox<String> Category = new ComboBox();
        Category.getItems().addAll("Fruits", "Vegetables","Meat","Drinks","Sereal", "Bread", "Supplies");
        Category.setValue("Fruits");
        
        ComboBox cboQType = new ComboBox();
        cboQType.getItems().addAll("Packs", "Boxes", "KG", "Grams");
        cboQType.setValue("Boxes");
         
        DatePicker ExDate = new DatePicker();
        ExDate.setValue(LocalDate.now());
        
        
        GridPane form = new GridPane();
        form.add(ItemName,0,0);
        form.add(txItemName,1,0);

        form.add(ItemQuantity,0,1);
        form.add(txQuantity,1,1);
        form.add(cboQType, 2, 1);

        form.add(ItemCategory,0,2);
        form.add(Category,1,2);

        form.add(ItemExDate,0,3);
        form.add(ExDate,1,3);

        form.setAlignment(Pos.CENTER);
        form.setHgap(10);
        form.setVgap(10);

        Button Add = new Button("Add");
        Button Update = new Button("Update");
        Button Search = new Button("Search");
        Button Clear = new Button ("Clear");
        Button ExportToFile=new Button("Export to file");

        HBox buttons = new HBox(20);
        buttons.setAlignment(Pos.CENTER);
        buttons.getChildren().addAll(Add,Update,Clear, ExportToFile);

        Label lblmsg = new Label();
        lblmsg.setTextFill(Color.DARKRED);
        lblmsg.setMaxHeight(30);
        lblmsg.setMaxWidth(500);
        lblmsg.setMinHeight(30);
        lblmsg.setMinWidth(500);
        lblmsg.setFont(new Font(16.0));
        lblmsg.setAlignment(Pos.CENTER);
        
       
       
        ListView lvItems = new ListView(obItems);

        ListView lvQuantity = new ListView(obQuantity);

        ListView lvCategory = new ListView(obCategory);

        ListView lvExDate = new ListView(obExDate);



        HBox lvs = new HBox(10);
        lvs.setAlignment(Pos.CENTER);
        lvs.setMaxWidth(700);
        lvs.setMinWidth(700);
        lvs.setMaxHeight(300);
        lvs.setMinHeight(300);


        VBox VBlvName = new VBox(10);

        VBox VBlvMobile = new VBox(10);

        VBox VBlvClinic = new VBox(10);

        VBox VBlvTime = new VBox(10);

        VBlvName.getChildren().addAll(new Label("Item Name: "), new ScrollPane(lvItems));
        VBlvMobile.getChildren().addAll(new Label("Quantity: "), new ScrollPane(lvQuantity));
        VBlvClinic.getChildren().addAll(new Label("Category: "), new ScrollPane(lvCategory));
        VBlvTime.getChildren().addAll(new Label("Expiry Date: "), new ScrollPane(lvExDate));

        lvs.getChildren().addAll(VBlvName,VBlvMobile,VBlvClinic,VBlvTime);
        
        HBox btSearch = new HBox(20);
        btSearch.getChildren().add(Search);
        btSearch.setAlignment(Pos.BOTTOM_RIGHT);
        btSearch.setPadding(new Insets (20));
        
        VBox controls = new VBox(10);
        controls.setAlignment(Pos.CENTER);
        controls.getChildren().addAll(form,lblmsg, buttons, lvs, btSearch);
        
        WarehouseInventory = new Scene(controls, 800, 630);
        
        //The Search Scene -----------------------------------------------------------------------------------------

        VBox searchControl = new VBox();
        Label lbltf = new Label("Enter the Item name: ") ;

        TextField tfSearch = new TextField();
        Button SearchItem = new Button("Search");
        Label msg = new Label();
        msg.setTextFill(Color.DARKRED);
        msg.setMaxHeight(100);
        msg.setMaxWidth(700);
        msg.setMinHeight(100);
        msg.setMinWidth(700);
        msg.setFont(new Font(20.0));
        
        Button Back = new Button("Back");

        HBox  paneSearch = new HBox(lbltf, tfSearch, SearchItem);
        paneSearch.setAlignment(Pos.TOP_LEFT);
        paneSearch.setSpacing(10);

        searchControl.getChildren().addAll(paneSearch, msg);
        searchControl.setAlignment(Pos.TOP_LEFT);
        searchControl.setSpacing(10);


        HBox filter = new HBox(10);
        filter.setAlignment(Pos.TOP_LEFT);
        ComboBox<String> Itemfilter = new ComboBox();
        Itemfilter.getItems().addAll("Fruits", "Vegetables","Meat","Drinks","Sereal", "Bread", "Supplies");
        Itemfilter.setValue("Fruits");
        ListView lvItemsByCategory = new ListView(obItemFilter);
        lvItemsByCategory.setPrefWidth(750);

        filter.getChildren().addAll(new Label("Filter Items by Category: "), Itemfilter);
        VBox cboFilter = new VBox(20);
        cboFilter.getChildren().add(lvItemsByCategory);


        VBox root2 = new VBox(10);
        root2.setPadding(new Insets(20));
        HBox back = new HBox(10);
        back.setAlignment(Pos.BOTTOM_RIGHT);
        back.getChildren().add(Back);
        root2.getChildren().addAll(searchControl,filter, cboFilter,back);
        
        //Actions of Scene WarehouseInventory ------------------------------------------------------------------------------------------
        //###### Task 2.1: Add an ActionEvent on the Add button:
    //###### Task 2.1: Add an ActionEvent on the Add button:

        Add.setOnAction(e -> {
            String str = txItemName.getText();
            String str2 = txQuantity.getText();
            boolean g = false;
            for (char c : str2.toCharArray()) {
                if (!Character.isDigit(c)) {
                    g = true;
                }
            }
            if (g) {
                lblmsg.setText("The Quantity must be digit only ");
            } else if (obItems.contains(txItemName.getText())) {
                lblmsg.setText("The item already inserted");
            } else if (!str.isEmpty() && !str2.isEmpty()) {

                obItems.add(str);
                obQuantity.add(str2 + " " + cboQType.getValue());
                obCategory.add(Category.getValue());
                obExDate.add(ExDate.getValue().toString());
                lblmsg.setText(null);
                //obExDate.add(ExDate.getValue().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));

            } else if (!str.isEmpty() && str2.isEmpty()) {
                lblmsg.setText("Enter the quantity");
            } else if (!str2.isEmpty() && str.isEmpty()) {
                lblmsg.setText("Enter the  item name ");
            } else {
                lblmsg.setText("Enter the item name and quantity");
            }

        });


        //##### Task 2.3: Add an ActionEvent on the Update button:
        /////////////////////////////////////
     Update.setOnAction(e -> {
            String ItmNamee = txItemName.getText();
            boolean g = false;
            for (char c : txQuantity.getText().toString().toCharArray()) {
                if (!Character.isDigit(c)) {
                    g = true;
                }
            }
            if (g) {
                lblmsg.setText("The Quantity must be digit only ");
            } else {

                int IndexOfItem = obItems.indexOf(ItmNamee);

                obQuantity.set(IndexOfItem, (txQuantity.getText().toString() + " " + cboQType.getValue()));

                obCategory.set(IndexOfItem, Category.getValue());

                obExDate.set(IndexOfItem, ExDate.getValue().toString());
                lblmsg.setText(" Item " + ItmNamee + "was updated");

            }
        });

        //##### Task 2.4: Add an ActionEvent on the â€œSearchâ€ button:
        SearchScene = new Scene(root2, 800, 700);
        Search.setOnAction(e -> {
            primaryStage.setScene(SearchScene);
        });
        

        
        
        //##### Task 2.5: Add an ActionEvent on the â€œClearâ€‌ button:
      Clear.setOnAction(e -> {
            txItemName.clear();
            txQuantity.clear();
        });



        //Actions of Scene Search
        //##### Task 3.1: Add an ActionEvent on the SearchItem button:
      //##### Task 3.1: Add an ActionEvent on the SearchItem button:
        SearchItem.setOnAction(e -> {

            if (tfSearch.getText().isEmpty()) {
                msg.setText(" Enter the item name to search the information");

            } else if (obItems.isEmpty()) {
                msg.setText("No items in the list");
            } else if (!obItems.isEmpty()) {
                for (String s : obItems) {
                    if (s.contains(tfSearch.getText())) {
                        int t = obItems.indexOf(s);
                        msg.setText(" The quantity of : " + obItems.get(t) + " is " + obQuantity.get(t) + "  Expire at: " + obExDate.get(t));
                    }
                }
            }

            if (!obItems.isEmpty()) {
                boolean flag = true;
                for (String s : obItems) {
                    if (s.contains(tfSearch.getText())) {
                        flag = false;
                    }
                }
                if (flag) {
                    msg.setText("The item not found");
                }
            }

        });
        //Task 3.2: Add an ActionEvent on the Itemfilter combobox:
     Itemfilter.setOnAction(e -> {
            obItemFilter.clear();
            for (int i = 0; i < obCategory.size(); i++) {
                if (Itemfilter.getValue().equals(obCategory.get(i))) {
                    obItemFilter.add("Item Name: " + obItems.get(i).toString() + "  Quantity: " + obQuantity.get(i).toString() + "  Expiry Date: " + obExDate.get(i).toString());
                }
            }

        });


        //Task 3.3: Add an ActionEvent on the Back button:
     Back.setOnAction(e -> {
            primaryStage.setScene(WarehouseInventory);
        });
        

        
        //###### Task 2.2: Add Listeners on the lvItems, lvQuantity, lvCategory and lvExDate ListViews:
        //###### You only need to uncomment the following part
      /////task file
        ExportToFile.setOnAction(e -> {

            try {
                output = new PrintWriter(file);
                for (int i = 0; i < obItems.size(); i++) {
                    //ياخذ من الاوبزيفبول لست ويحطها في الأوتبوت الي تودي ع الفايل 
                    output.append("Item Name:" + obItems.get(i) + " " + "Category:" + obCategory.get(i) + " " + "Quantity :" + obQuantity.get(i) + " " + "ExDate:" + obExDate.get(i));
                    output.println();

                }
                output.close();
            } catch (java.io.IOException ex) {
                System.out.println(ex.toString());
                System.out.println("unfinding");
            }
       
        });
    
        
        lvItems.getSelectionModel().selectedItemProperty().addListener(e-> {
          
            lvItems.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            int index = lvItems.getSelectionModel().getSelectedIndex();
            //System.out.println(index);
            lvQuantity.getSelectionModel().select(index);
            lvCategory.getSelectionModel().select(index);
            lvExDate.getSelectionModel().select(index);
            
            txItemName.setText(obItems.get(index));
            
            String[] Q = obQuantity.get(index).split(" ");
            String quant = Q[0];
            txQuantity.setText(quant);
            
            Category.setValue(obCategory.get(index));
            ExDate.setValue(LocalDate.parse(obExDate.get(index)));
           

        });

        lvQuantity.getSelectionModel().selectedItemProperty().addListener(e-> {
            lvQuantity.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            int index = lvQuantity.getSelectionModel().getSelectedIndex();
            lvItems.getSelectionModel().select(index);
            lvCategory.getSelectionModel().select(index);
            lvExDate.getSelectionModel().select(index);

            txItemName.setText(obItems.get(index));
            
            String[] Q = obQuantity.get(index).split(" ");
            String quant = Q[0];
            txQuantity.setText(quant);
            Category.setValue(obCategory.get(index));
            ExDate.setValue(LocalDate.parse(obExDate.get(index)));

        });

        lvCategory.getSelectionModel().selectedItemProperty().addListener(e-> {
            lvCategory.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            int index = lvCategory.getSelectionModel().getSelectedIndex();
            //System.out.println(index);
            lvItems.getSelectionModel().select(index);
            lvQuantity.getSelectionModel().select(index);
            lvExDate.getSelectionModel().select(index);

            txItemName.setText(obItems.get(index));
            String[] Q = obQuantity.get(index).split(" ");
            String quant = Q[0];
            txQuantity.setText(quant);
            Category.setValue(obCategory.get(index));
            ExDate.setValue(LocalDate.parse(obExDate.get(index)));


        });


        lvExDate.getSelectionModel().selectedItemProperty().addListener(e-> {
            lvExDate.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            int index = lvExDate.getSelectionModel().getSelectedIndex();
            
            lvItems.getSelectionModel().select(index);
            lvQuantity.getSelectionModel().select(index);
            lvCategory.getSelectionModel().select(index);

            txItemName.setText(obItems.get(index));
            String[] Q = obQuantity.get(index).split(" ");
            String quant = Q[0];
            txQuantity.setText(quant);
            Category.setValue(obCategory.get(index));
            ExDate.setValue(LocalDate.parse(obExDate.get(index)));



        });
        
        
        
   

      
        primaryStage.setTitle("Warehouse Inventory");
        primaryStage.setScene(WarehouseInventory);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }
    
}
