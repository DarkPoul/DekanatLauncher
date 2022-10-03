module org.ioc {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;

    opens org.ioc to javafx.fxml;
    opens org.ioc.models to javafx.base;
    opens org.ioc.controller to javafx.fxml;

    exports org.ioc;
    opens org.ioc.DataBase to javafx.fxml;
}
