module com.example.weather {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires json.simple;

    opens com.example.weather to javafx.fxml;
    exports com.example.weather;
}