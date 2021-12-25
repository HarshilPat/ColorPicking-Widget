package A1;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class PaletteView extends Pane {
    public Circle palCir1,palCir2,palCir3;
    public HBox viewBox;
    public ColorPalette cPal;

    public PaletteView(ColorPalette colP){
        palCir1=new Circle(50);
        palCir2=new Circle(50);
        palCir3=new Circle(50);

        viewBox.getChildren().addAll(palCir1,palCir2,palCir3);

        if (colP!=null)cPal=colP;
        else cPal=new ColorPalette();
    }


}
