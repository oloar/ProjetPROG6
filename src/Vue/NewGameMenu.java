package Vue;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.text.*;

public class NewGameMenu extends VBox {
	private static NewGameMenu instance = null;
	
	public static NewGameMenu getInstance() {
		if(instance == null)
			instance = new NewGameMenu();
		return instance;
	}
	
	private NewGameMenu() {
		Font.loadFont(getClass().getResourceAsStream("LuckiestCuy.ttf"), 14);
		this.getStyleClass().add("menu");
		this.getStylesheets().add("banquise.css");
		create_elements();
	}
	
private void create_elements() {
		this.getStyleClass().add("menu");
		// Allocations
		Button config = new Button("Config.");
		Button jouer = new Button("Jouer");
		Button retour = new Button("Retour");
		Label mapName = new Label("Banquise");
		HBox mapSelection = new HBox();
		Button leftMap = new Button();
		Button rightMap = new Button();
		Button mapButton = new Button();
		
		config.getStyleClass().add("textbutton");
		jouer.getStyleClass().add("textbutton");
		retour.getStyleClass().add("textbutton");
		
		mapButton.getStyleClass().addAll("mapbutton");
		
		leftMap.getStyleClass().addAll("iconbutton", "leftbutton");
		rightMap.getStyleClass().addAll("iconbutton", "rightbutton");
		
		config.getStyleClass().add("config");
		mapSelection.setAlignment(Pos.CENTER);
		
		mapSelection.getStyleClass().add("mapselection");
		mapSelection.getChildren().add(rightMap);
		mapSelection.getChildren().add(mapButton);
		mapSelection.getChildren().add(leftMap);
		
		this.getChildren().add(mapName);
		this.getChildren().add(config);
		this.getChildren().add(mapSelection);
		this.getChildren().add(jouer);
		this.getChildren().add(retour);
		
		retour.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
			}
		});
	}
}