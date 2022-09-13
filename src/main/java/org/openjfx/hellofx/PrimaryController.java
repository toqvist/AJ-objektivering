package org.openjfx.hellofx;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class PrimaryController {

    @FXML
    private void readFile(ActionEvent event) throws IOException {

        // Initialize FileChooser, filter by extensions .csv and .json
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Files", "*.*"),
                new FileChooser.ExtensionFilter("CSV", "*.csv"),
                new FileChooser.ExtensionFilter("JSON", "*.json"),
                new FileChooser.ExtensionFilter("XML", "*.xml"));

        File file = fileChooser.showOpenDialog(null);
        LinkedHashMap<String, ArrayList<String>> map = FileReader.read(file);

        buildTable(map, event);

    }

    public static void buildTable(LinkedHashMap<String, ArrayList<String>> map, ActionEvent event) {

        TableView tableView = new TableView();

        tableView.setEditable(true);

        // Create a map as a data item for the table columns
        ObservableList<Map<String, Object>> items = FXCollections.<Map<String, Object>>observableArrayList();

        // For each key/value pair in map, create a column with the key as the label
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {

            TableColumn<Map, String> column = new TableColumn<>(entry.getKey());
            column.setCellValueFactory(new MapValueFactory<>(entry.getKey()));
            tableView.getColumns().add(column);

        }

    
        ArrayList<String> firstList = map.entrySet().iterator().next().getValue();

        //For each item (row)
        for (int i = 0; i < firstList.size(); i++) {

            Map<String, Object> item = new HashMap<>();

            //Populate with values from each column
            int j = 0;
            for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {

                ArrayList<String> list = entry.getValue();                
                item.put(entry.getKey(), list.get(j+i));

            }
            j++;
            items.add(item);
        }

        // Add the items to the table
        tableView.getItems().addAll(items);

        // Get the stage from the event
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        // Group and add objects to the scene
        Group root = new Group(tableView);
        Scene scene = new Scene(root, 800, 1200);

        stage.setScene(scene);
        stage.show();
    }

    public static void sysout(LinkedHashMap<String, ArrayList<String>> map) {
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {

            System.out.println(entry.getKey());
            // entry.getValue();

            for (String element : entry.getValue()) {
                System.out.println(element);
            }
        }
    }
}