module org.ioc {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;

    opens org.ioc to javafx.fxml;
    opens org.ioc.controller to javafx.fxml;
    exports org.ioc;
}
