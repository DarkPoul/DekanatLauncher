module org.ioc {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;
    requires java.sql;
    requires mysql.connector.java;
    requires org.apache.poi.poi;

    opens org.ioc to javafx.fxml;
    opens org.ioc.models to javafx.base;
    opens org.ioc.controller to javafx.fxml;
    opens org.ioc.settings to javafx.fxml;

    exports org.ioc;
    opens org.ioc.DataBase to javafx.fxml;
}
