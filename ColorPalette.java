package A1;

import javafx.scene.paint.Color;

public class ColorPalette extends Palette {

    public Color color_1 = Color.WHITE;
    public Color color_2 = Color.WHITE;
    public Color color_3 = Color.WHITE;

    public ColorPalette(){
        super();
    }

    public void addColor(Color c) {
        if (color_1 == Color.WHITE) {
            circle1.setFill(c);
            color_1 = c;
        } else if (color_2 == Color.WHITE) {
            circle2.setFill(c);
            color_2 = c;
        } else if (color_3 == Color.WHITE) {
            circle3.setFill(c);
            color_1 = color_2 = Color.WHITE;
        }
    }

    public void setColor() {
        Color c = Color.rgb((int) red.getValue(), (int) green.getValue(), (int) blue.getValue());
        color_cir.setFill(c);
    }

    public String toString() {
        Color c1, c2, c3;
        c1 = (Color) circle1.getFill();
        c2 = (Color) circle2.getFill();
        c3 = (Color) circle3.getFill();
        Color[] a = {c1, c2, c3};
        String s = "";
        for (Color color : a) {
            s = s + (int) color.getRed() * 255 + "," + (int) color.getGreen() * 255 + "," + (int) color.getBlue() * 255 + "\n";
        }
        return s;
    }
}
