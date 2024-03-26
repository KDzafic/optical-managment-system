module com.example.patientsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.patientsystem to javafx.fxml;
    exports com.example.patientsystem;
}