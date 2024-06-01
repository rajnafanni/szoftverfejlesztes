package game;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import model.GameTable;
import model.JSONWriter;
import model.Direction;

public class JatekController {

    Image fal = new Image(getClass().getResourceAsStream("/images/fal.png"));
    Image alap = new Image(getClass().getResourceAsStream("/images/alap.png"));
    Image start = new Image(getClass().getResourceAsStream("/images/start.png"));
    Image cel = new Image(getClass().getResourceAsStream("/images/cel.png"));
    Image voltmar = new Image(getClass().getResourceAsStream("/images/voltmar.png"));
    Image playerImage = new Image(getClass().getResourceAsStream("/images/jatekos.png"));

    private GameTable gameTable;
    private ImageView playerImageView;

    @FXML
    private GridPane gridPane;

    @FXML
    public void initialize() {
        gameTable = new GameTable();
        setupGrid();

        playerImageView = new ImageView(playerImage);
        playerImageView.setFitWidth(30);
        playerImageView.setFitHeight(30);
        playerImageView.setPreserveRatio(true);
        updatePlayerPosition();
        gridPane.getChildren().add(playerImageView);
        addClickListeners();
    }


    private void setupGrid() {
        for (int row = 0; row < GameTable.SIZE; row++) {
            for (int col = 0; col < GameTable.SIZE; col++) {
                ImageView imageView = new ImageView();
                imageView.setFitWidth(30);
                imageView.setFitHeight(30);
                imageView.setPreserveRatio(true);


                Image image = getImageForValue(gameTable.getValueAt(row, col));
                imageView.setImage(image);


                GridPane.setRowIndex(imageView, row);
                GridPane.setColumnIndex(imageView, col);


                gridPane.getChildren().add(imageView);
            }
        }
    }

    private void updatePlayerPosition() {
        int playerRow = gameTable.getPlayer().getRow();
        int playerCol = gameTable.getPlayer().getCol();
        GridPane.setRowIndex(playerImageView, playerRow);
        GridPane.setColumnIndex(playerImageView, playerCol);
    }


    private void updateGrid() {
        gridPane.getChildren().clear();
        setupGrid();

        gridPane.getChildren().add(playerImageView);
        updatePlayerPosition();
        addClickListeners();
    }


    private Image getImageForValue(int value) {
        switch (value) {
            case 1:
                return fal;
            case 2:
                return start;
            case 3:
                return cel;
            case 4:
                return voltmar;
            default:
                return alap;
        }
    }


    private void addClickListeners() {
        for (int row = 0; row < GameTable.SIZE; row++) {
            for (int col = 0; col < GameTable.SIZE; col++) {
                ImageView imageView = getNodeByRowColumnIndex(row, col);
                if (imageView != null) {
                    imageView.setOnMouseClicked(event -> {
                        int clickedRow = GridPane.getRowIndex(imageView);
                        int clickedCol = GridPane.getColumnIndex(imageView);

                        int currentPlayerRow = gameTable.getPlayer().getRow();
                        int currentPlayerCol = gameTable.getPlayer().getCol();

                        Direction direction = null;
                        if (clickedRow < currentPlayerRow) {
                            direction = Direction.UP;
                        } else if (clickedRow > currentPlayerRow) {
                            direction = Direction.DOWN;
                        } else if (clickedCol < currentPlayerCol) {
                            direction = Direction.LEFT;
                        } else if (clickedCol > currentPlayerCol) {
                            direction = Direction.RIGHT;
                        }

                        if (direction != null && gameTable.canMoveTo(clickedRow, clickedCol)) {
                            gameTable.movePlayerTo(clickedRow, clickedCol);
                            updateGrid();
                            if (gameTable.getValueAt
                                    (clickedRow, clickedCol) == 3) {
                                showAlert("Ügyes fickó vagy! Célba értél!", "Lépések száma: " + gameTable.getStepCount());
                            }
                            System.out.println("Player moved to (" + clickedRow + ", " + clickedCol + ")");
                            JSONWriter.writeGameTableToJSON(gameTable, "gameTable.json");
                        } else {
                            System.out.println("Érvénytelen lépés!");
                        }
                    });
                }
            }
        }
    }


    private ImageView getNodeByRowColumnIndex(int row, int col) {
        for (var node : gridPane.getChildren()) {
            if (GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == col) {
                return (ImageView) node;
            }
        }
        return null;
    }


    private void showAlert(String title, String content) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
