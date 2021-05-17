package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GridPaneExample extends Application {
    @Override
    public void start(Stage stage) {
        //creating label email
        Text FirstNameText = new Text("First Name");

        //creating label password
        Text LastNameText = new Text("Last name");

        Text EmailText = new Text("Email");

        //Creating Text Filed for email
        TextField FnameField = new TextField();

        //Creating Text Filed for password
        TextField LnameField = new TextField();

        TextField EmailField = new TextField();

        //Creating Buttons
        Button SubmitButton = new Button("Submit");
        Button ClearButton = new Button("Clear");

        //Creating a Grid Pane
        GridPane gridPane = new GridPane();

        //Setting size for the pane
        gridPane.setMinSize(400, 200);

        //Setting the padding
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        //Setting the vertical and horizontal gaps between the columns
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        //Setting the Grid alignment
        gridPane.setAlignment(Pos.CENTER);

        //Arranging all the nodes in the grid
        gridPane.add(FirstNameText, 0, 0);
        gridPane.add(FnameField, 1, 0);
        gridPane.add(LastNameText, 0, 1);
        gridPane.add(LnameField, 1, 1);
        gridPane.add(EmailText, 0, 2);
        gridPane.add(EmailField, 1, 2);
        gridPane.add(SubmitButton, 0, 3);
        gridPane.add(ClearButton, 1, 3);

        //Creating a scene object
        Scene scene = new Scene(gridPane);

        //Setting title to the Stage
        stage.setTitle("Grid Pane Example");

        //Adding scene to the stage
        stage.setScene(scene);

        //Displaying the contents of the stage
        stage.show();

        SubmitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    FileWriter csvWriter=new FileWriter("data.csv");
                    csvWriter.append(FnameField.getText());
                    csvWriter.append(",");
                    csvWriter.append(LnameField.getText());
                    csvWriter.append(",");
                    csvWriter.append(EmailField.getText());
                    csvWriter.append("\n");

                    csvWriter.flush();
                    csvWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        ClearButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FnameField.setText("");
                LnameField.setText("");
                EmailField.setText("");
            }
        });
    }
    public static void main(String args[]){
        launch(args);
    }
} 