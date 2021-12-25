/**
 * Harshil Patel
 * hap793 11290942
 * CMPT381 A1
 */
package A1;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;

public class Palette extends Application {
    public Circle circle1,circle2,circle3,color_cir;
    public Button palBtn,listBtn;
    public Slider red,green,blue;
    public Label rlabel,glabel,blabel,rValue,gValue,bValue;
    public ColorPalette cP;

    @Override
    public void start(Stage PrimaryStage) throws IOException {
        Group root = new Group();
        root.minHeight(600);
        root.minWidth(600);

        PrimaryStage.setTitle("Color Palette");
        color_cir = new Circle(150,150,100,Color.GREY);

        circle1 = new Circle(50,485,50);
        circle2 = new Circle(150,485,50);
        circle3 = new Circle(250,485,50);

        palBtn = new Button("Add to Palette");
        palBtn.relocate(100,375);
        listBtn = new Button("Add to List");
        listBtn.relocate(100,550);

        red = new Slider();
        red.setMin(0);red.setMax(255);
        green = new Slider();
        green.setMin(0);green.setMax(255);
        blue = new Slider();
        blue.setMin(0);blue.setMax(255);
        red.setLayoutX(75);red.setLayoutY(275);
        green.setLayoutY(300);green.setLayoutX(75);
        blue.setLayoutX(75);blue.setLayoutY(325);

        rlabel = new Label("Red:");
        rlabel.setLayoutX(20);rlabel.setLayoutY(275);
        glabel = new Label("Green:");
        glabel.setLayoutX(20);glabel.setLayoutY(300);
        blabel = new Label("Blue:");
        blabel.setLayoutX(20);blabel.setLayoutY(325);

        rValue = new Label(""+((int) red.getValue()));
        rValue.setLabelFor(red);
        rValue.setLayoutX(225);rValue.setLayoutY(275);
        gValue = new Label(""+((int) green.getValue()));
        gValue.setLabelFor(green);
        gValue.setLayoutX(225);gValue.setLayoutY(300);
        bValue = new Label(""+((int) blue.getValue()));
        bValue.setLabelFor(blue);
        bValue.setLayoutX(225);bValue.setLayoutY(325);


        ObservableList<ColorPalette> placeholderText = FXCollections.observableArrayList();
        ListView<ColorPalette> Listpalette = new ListView<ColorPalette>(placeholderText);
        Listpalette.setMinSize(300,600);

        HBox windowBox = new HBox();
        windowBox.setSpacing(10);
        windowBox.setMinSize(600,600);

        VBox b1 = new VBox();
        b1.setMinSize(300,600);
        b1.setAlignment(Pos.CENTER_LEFT);

        VBox b2 = new VBox();
        b2.setMinSize(300,600);
        b2.setAlignment(Pos.CENTER_RIGHT);
        b2.getChildren().add(Listpalette);

        windowBox.getChildren().add(b1);
        windowBox.getChildren().add(b2);

        final Color[] currentColor = {(Color) color_cir.getFill()};


        cP = new ColorPalette();
        red.valueProperty().addListener((observable, oldValue, newValue) -> {
            cP.setColor();
            red.setValue((Double) newValue);
            rValue.setText(String.valueOf(newValue));
        });
        green.valueProperty().addListener((observable, oldValue, newValue) -> {
            cP.setColor();
            green.setValue((Double) newValue);
            gValue.setText(String.valueOf(newValue.intValue()));
        });
        blue.valueProperty().addListener((observable, oldValue, newValue) -> {
            cP.setColor();
            blue.setValue((Double) newValue);
            bValue.setText(String.valueOf(newValue.intValue()));
        });
        palBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                currentColor[0] = (Color) color_cir.getFill();
                cP.addColor(currentColor[0]);
            }
        });
        listBtn.setOnAction(actionEvent ->Listpalette.setCellFactory(listItem->new PaletteCell()));

        root.getChildren().addAll(windowBox,color_cir,palBtn,listBtn,red,green,blue,rlabel,
                glabel,blabel,rValue,gValue,bValue,
                circle1,circle2,circle3);
        Scene scene = new Scene(root);

        PrimaryStage.setScene(scene);
        PrimaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}