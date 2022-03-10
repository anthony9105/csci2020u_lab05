/**
 Anthony Liscio
 Lab 05
 Student Course Information Table with JavaFX
 */

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    public void start(Stage primaryStage)
    {
        // TableView object of StudentRecord objects
        TableView<StudentRecord> table = new TableView<StudentRecord>();

        // creating DataSource object and local observable list created by the DataSource class
        DataSource ds = new DataSource();
        ObservableList<StudentRecord> marks = ds.getAllMarks();

        // Scene layout component
        Scene scene = new Scene(new Group());
        primaryStage.setTitle("Lab05 Solutions");
        primaryStage.setWidth(700);
        primaryStage.setHeight(350);

        table.setEditable(false);   // so the user cannot change the table values themselves

        // ** Student ID column **
        TableColumn studentIDCol = new TableColumn("SID");      // creating a TableColumn object with title: "SID"
        studentIDCol.setMinWidth(100);
        // setting the column values from the StudentRecord object and keyword "studentID" attribute
        studentIDCol.setCellValueFactory(new PropertyValueFactory<StudentRecord, String>("studentID"));

        // ** Assignment column **
        TableColumn assignmentCol = new TableColumn("Assignment");  // creating a TableColumn object with title: "Assignment"
        assignmentCol.setMinWidth(90);
        // setting the column values from the StudentRecord object and keyword "assignment" attribute
        assignmentCol.setCellValueFactory(new PropertyValueFactory<StudentRecord, String>("assignments"));

        // ** Midterm column **
        TableColumn midtermCol = new TableColumn("Midterm");        // creating a TableColumn object with title: "Midterm"
        midtermCol.setMinWidth(90);
        // setting the column values from the StudentRecord object and keyword "midterm" attribute
        midtermCol.setCellValueFactory(new PropertyValueFactory<StudentRecord, String>("midterm"));

        // ** Final Exam column **
        TableColumn examCol = new TableColumn("Final Exam");        // creating a TableColumn object with title: "Final Exam"
        examCol.setMinWidth(90);
        // setting the column values from the StudentRecord object and keyword "exam" attribute
        examCol.setCellValueFactory(new PropertyValueFactory<StudentRecord, String>("exam"));

        // ** Final Grade column **
        TableColumn finalGradeCol = new TableColumn("Final Grade"); // creating a TableColumn object with title: "Final Grade"
        finalGradeCol.setMinWidth(90);
        // setting the column values from the StudentRecord object and keyword "finalMark" attribute
        finalGradeCol.setCellValueFactory(new PropertyValueFactory<StudentRecord, String>("finalMark"));

        // ** Letter Grade column **
        TableColumn letterGradeCol = new TableColumn("Letter Grade"); // creating a TableColumn object with title: "Letter Grade"
        letterGradeCol.setMinWidth(90);
        // setting the column values from the StudentRecord object and keyword "letterGrade" attribute
        letterGradeCol.setCellValueFactory(new PropertyValueFactory<StudentRecord, String>("letterGrade"));

        // setting items and columns
        table.setItems(marks);
        table.getColumns().addAll(studentIDCol, assignmentCol, midtermCol, examCol, finalGradeCol, letterGradeCol);

        // adding the table to a VBox layout component
        VBox vbox = new VBox();
        vbox.getChildren().addAll(table);
        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        // setting the scene to the primary stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}