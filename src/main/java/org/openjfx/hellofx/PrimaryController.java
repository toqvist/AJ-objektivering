package org.openjfx.hellofx;

import org.openjfx.hellofx.model.FileReader;

import java.io.File;
import java.io.IOException;
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
                new FileChooser.ExtensionFilter("JSON", "*.json"));

        File file = fileChooser.showOpenDialog(null);
        FileReader.read(file);

        System.out.println(file);
    }

}