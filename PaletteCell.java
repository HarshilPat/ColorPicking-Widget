package A1;

import javafx.scene.control.ListCell;

public class PaletteCell extends ListCell<ColorPalette> {
    public PaletteCell(){
        super();
    }
    public void updateItem(ColorPalette item, boolean empty){
        super.updateItem(item,empty);
        PaletteView pv = new PaletteView(item);
        setGraphic(pv);
    }
}
