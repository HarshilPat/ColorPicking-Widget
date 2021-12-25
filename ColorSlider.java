package A1;

import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;

public class ColorSlider extends Pane {
    public Label label,value;
    public Slider slider;

    public ColorSlider(String title){
        label = new Label(title);
        slider = new Slider(0,255,50);
        value=new Label((int)slider.getValue()+"");
    }

    public int getValue(){
        return (int) slider.getValue();
    }

    public void setValue(int n){
        slider.setValue(n);
    }
}
