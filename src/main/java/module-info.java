module com.example.sem04_02 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sem04_02 to javafx.fxml;
    exports com.example.sem04_02;
}