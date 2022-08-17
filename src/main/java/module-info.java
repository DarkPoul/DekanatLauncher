module org.ioc {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;
    requires java.sql;
    requires mysql.connector.java;

    opens org.ioc to javafx.fxml;
    opens org.ioc.controller to javafx.fxml;
    exports org.ioc;
}
