package org.openjfx.hellofx;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;

import javafx.fxml.FXML;


import javafx.stage.FileChooser;

public class PrimaryController {

    @FXML
    private void readFile() throws IOException {

        //Initialize FileChooser, filter by extensions .csv and .json
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Files", "*.*"),
                new FileChooser.ExtensionFilter("CSV", "*.csv"),
                new FileChooser.ExtensionFilter("JSON", "*.json"),
                new FileChooser.ExtensionFilter("XML", "*.xml"));	

        File file = fileChooser.showOpenDialog(null);
        LinkedHashMap map = FileReader.read(file);

        // System.out.println(file);
    }

}