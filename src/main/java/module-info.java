module hellofx {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    
    requires com.google.gson;
    requires json.simple;
    opens org.openjfx.hellofx to javafx.fxml;
    exports org.openjfx.hellofx;
}