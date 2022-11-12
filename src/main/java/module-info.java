module aplication.jogodavelha {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens aplication.jogodavelha to javafx.fxml;
    exports aplication.jogodavelha;
}