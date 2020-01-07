package edu.citytech.games;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Paint;

public class GamesController {

	@FXML
	private FlowPane fpgames;

	@FXML
	private Button btnReset;

	@FXML
	private Label lbl_1;

	@FXML
	private Label lbl_2;

	@FXML
	private Label lbl_3;

	@FXML
	private Label lbl_4;

	@FXML
	private Label lbl_5;

	@FXML
	private Label lbl_6;

	@FXML
	private Label lbl_7;

	@FXML
	private Label lbl_8;

	@FXML
	private Label lbl_9;

	@FXML
	private Label lblMessage;

	private boolean isX = false;
	private boolean winner = false;
	private boolean Draw = false;

	@FXML
	void onMouseClick(MouseEvent event) {
		// downcasting
		if (!Draw) {

			if (!winner && !Draw) {
				Label label = (Label) event.getSource();

				lblMessage.setText("");
				if ((!label.getText().equals("?"))) {
					String value = "illegal move, Cheater!";
					lblMessage.setText(value);

					return;

				}

				String nextMove = isX ? "X" : "O";
				label.setText(nextMove);
				isX = !isX;

				String p1, p2, p3, p4, p5, p6, p7, p8, p9;
				p1 = lbl_1.getText();
				p2 = lbl_2.getText();
				p3 = lbl_3.getText();

				p4 = lbl_4.getText();
				p5 = lbl_5.getText();
				p6 = lbl_6.getText();

				p7 = lbl_7.getText();
				p8 = lbl_8.getText();
				p9 = lbl_9.getText();

				winner = ((!p3.equals("?") && p1.equals(p2) && p2.equals(p3))
						|| (!p6.equals("?") && p4.equals(p5) && p5.equals(p6))
						|| (!p9.equals("?") && p7.equals(p8) && p8.equals(p9))
						|| (!p7.equals("?") && p1.equals(p4) && p4.equals(p7))
						|| (!p8.equals("?") && p2.equals(p5) && p5.equals(p8))
						|| (!p9.equals("?") && p3.equals(p6) && p6.equals(p9))
						|| (!p9.equals("?") && p1.equals(p5) && p5.equals(p9))
						|| (!p7.equals("?") && p3.equals(p5) && p5.equals(p7)));

				Draw = ((!p1.equals("?") && !p2.equals("?") && !p3.equals("?") && !p4.equals("?") && !p5.equals("?")
						&& !p6.equals("?") && !p7.equals("?") && !p8.equals("?") && !p9.equals("?")) && !winner);

				if (Draw) {
					lblMessage.setText("It's a draw ");
					lblMessage.setTextFill(Paint.valueOf("blue"));
					return;
				}

				if (winner) {
					lblMessage.setText("The winner is: " + nextMove);

					lblMessage.setTextFill(Paint.valueOf("red"));

					if ((!p3.equals("?") && p1.equals(p2) && p2.equals(p3))) {
						lbl_1.setTextFill(Paint.valueOf("red"));
						lbl_2.setTextFill(Paint.valueOf("red"));
						lbl_3.setTextFill(Paint.valueOf("red"));
						highlightWinningCombo(lbl_1, lbl_2, lbl_3);
					}
					if ((!p6.equals("?") && p4.equals(p5) && p5.equals(p6))) {
						lbl_4.setTextFill(Paint.valueOf("red"));
						lbl_5.setTextFill(Paint.valueOf("red"));
						lbl_6.setTextFill(Paint.valueOf("red"));
						highlightWinningCombo(lbl_4, lbl_5, lbl_6);
					}
					if ((!p9.equals("?") && p7.equals(p8) && p8.equals(p9))) {
						lbl_7.setTextFill(Paint.valueOf("red"));
						lbl_8.setTextFill(Paint.valueOf("red"));
						lbl_9.setTextFill(Paint.valueOf("red"));
						highlightWinningCombo(lbl_7, lbl_8, lbl_9);

					}
					if ((!p7.equals("?") && p1.equals(p4) && p4.equals(p7))) {
						lbl_1.setTextFill(Paint.valueOf("red"));
						lbl_4.setTextFill(Paint.valueOf("red"));
						lbl_7.setTextFill(Paint.valueOf("red"));
						highlightWinningCombo(lbl_1, lbl_4, lbl_7);

					}

					if ((!p8.equals("?") && p2.equals(p5) && p5.equals(p8))) {
						lbl_2.setTextFill(Paint.valueOf("red"));
						lbl_5.setTextFill(Paint.valueOf("red"));
						lbl_8.setTextFill(Paint.valueOf("red"));
						highlightWinningCombo(lbl_2, lbl_5, lbl_8);

					}
					if ((!p9.equals("?") && p3.equals(p6) && p6.equals(p9))) {
						lbl_3.setTextFill(Paint.valueOf("red"));
						lbl_6.setTextFill(Paint.valueOf("red"));
						lbl_9.setTextFill(Paint.valueOf("red"));
						highlightWinningCombo(lbl_3, lbl_6, lbl_9);

					}
					if ((!p9.equals("?") && p1.equals(p5) && p5.equals(p9))) {
						lbl_1.setTextFill(Paint.valueOf("red"));
						lbl_5.setTextFill(Paint.valueOf("red"));
						lbl_9.setTextFill(Paint.valueOf("red"));
						highlightWinningCombo(lbl_1, lbl_5, lbl_9);

					}
					if ((!p7.equals("?") && p3.equals(p5) && p5.equals(p7))) {
						lbl_3.setTextFill(Paint.valueOf("red"));
						lbl_5.setTextFill(Paint.valueOf("red"));
						lbl_7.setTextFill(Paint.valueOf("red"));
						highlightWinningCombo(lbl_3, lbl_5, lbl_7);

					}

				}

			}

			else {
				lblMessage.setText("Determined Player");

			}

		}

	}

	
	/*
	Alert pane2 = new Alert(Alert.AlertType.INFORMATION);
	pane2.setContentText("Yellow Won");
	pane2.show();
	
	Alert pane1 = new Alert(Alert.AlertType.INFORMATION);
	pane1.setContentText("Red Won");
	pane1.show();
	
	
			/*
		if (!redMove) {
		Alert pane2 = new Alert(Alert.AlertType.INFORMATION);
		pane2.setContentText("Yellow Won");
		pane2.show();
		
		System.out.println("Winner: " +  pane2);}
		else if (redMove) {
		
		
		Alert pane1 = new Alert(Alert.AlertType.INFORMATION);
		pane1.setContentText("Red Won");
		pane1.show();
		
		System.out.println("Winner: " +  pane1);}
		*/
	
	
	@FXML
	
	
	void reset(ActionEvent event) {

		this.lblMessage.setText("");

		ObservableList<javafx.scene.Node> items = this.fpgames.getChildren();
		items.forEach(e -> {

			Label lbl = (Label) e;
			lbl.setText("?");
		});

		lbl_1.setTextFill(Paint.valueOf("black"));
		lbl_2.setTextFill(Paint.valueOf("black"));
		lbl_3.setTextFill(Paint.valueOf("black"));
		lbl_4.setTextFill(Paint.valueOf("black"));
		lbl_5.setTextFill(Paint.valueOf("black"));
		lbl_6.setTextFill(Paint.valueOf("black"));
		lbl_7.setTextFill(Paint.valueOf("black"));
		lbl_8.setTextFill(Paint.valueOf("black"));
		lbl_9.setTextFill(Paint.valueOf("black"));

		lbl_1.getStyleClass().clear();
		lbl_2.getStyleClass().clear();
		lbl_3.getStyleClass().clear();
		lbl_4.getStyleClass().clear();
		lbl_5.getStyleClass().clear();
		lbl_6.getStyleClass().clear();
		lbl_7.getStyleClass().clear();
		lbl_8.getStyleClass().clear();
		lbl_9.getStyleClass().clear();

		lbl_1.getStyleClass().add("custom-label");
		lbl_2.getStyleClass().add("custom-label");
		lbl_3.getStyleClass().add("custom-label");
		lbl_4.getStyleClass().add("custom-label");
		lbl_5.getStyleClass().add("custom-label");
		lbl_6.getStyleClass().add("custom-label");
		lbl_7.getStyleClass().add("custom-label");
		lbl_8.getStyleClass().add("custom-label");
		lbl_9.getStyleClass().add("custom-label");

		

		lblMessage.setText("");
		lblMessage.setTextFill(Paint.valueOf("black"));
		winner = false;
		Draw = false;
	}

	private void highlightWinningCombo(Label first, Label second, Label third) {
		first.getStyleClass().add("winning-square");
		second.getStyleClass().add("winning-square");
		third.getStyleClass().add("winning-square");
	}

}
