package game;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.GameTable;

public class JatekController {

    Image fal = new Image(getClass().getResourceAsStream("/images/fal.png"));
    Image alap = new Image(getClass().getResourceAsStream("/images/alap.png"));
    Image start = new Image(getClass().getResourceAsStream("/images/start.png"));
    Image cel = new Image(getClass().getResourceAsStream("/images/cel.png"));
    Image voltmar = new Image(getClass().getResourceAsStream("/images/voltmar.png"));

    @FXML
    private GridPane gridPane;

    @FXML
    public void initialize() {
        GameTable gameTable = new GameTable();

        // Létrehozzuk a játéktábla grafikus reprezentációját
        for (int row = 0; row < GameTable.SIZE; row++) {
            for (int col = 0; col < GameTable.SIZE; col++) {
                ImageView imageView = new ImageView();
                imageView.setFitWidth(30);
                imageView.setFitHeight(30);
                imageView.setPreserveRatio(true);

                int value = gameTable.getValueAt(row, col);
                switch (value) {
                    case 1:
                        imageView.setImage(fal);
                        break;
                    case 2:
                        imageView.setImage(start);
                        break;
                    case 3:
                        imageView.setImage(cel);
                        break;
                    default:
                        imageView.setImage(alap);
                        break;
                }

                gridPane.add(imageView, col, row); // Hozzáadjuk a képet a GridPane-hez
            }
        }
    }
}
