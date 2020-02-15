//Authors: Gordon Bittner
// 	 	   Bronson Batad
// Midterm CIT230

import javafx.application.Application;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;

public class Midterm extends Application
{
	
	private Label conv = new Label("Enter measurement: ");
	private TextField convText = new TextField();
	private Label from = new Label("From:");
	private ChoiceBox<String> fromBox = new ChoiceBox<>();
	private Label to = new Label("To:" );
	private ChoiceBox<String> toBox = new ChoiceBox<>();
	private Button convertButton = new Button("Convert");
	private Button clearButton = new Button("Clear");
	private FlowPane pane = new FlowPane();
	private Scene scene;	

	
	@Override
	public void start(Stage primaryStage)
	{
		
		convText.setPrefColumnCount(1);
		clearButton.setAlignment(Pos.CENTER);
		convertButton.setAlignment(Pos.CENTER);

		
		fromBox.getItems().addAll("Teaspoon(s)", "Tablespoon(s)", "Ounce(s)", "Cup(s)", "Pint(s)", "Quart(s)", "Gallon(s)");
		fromBox.setValue("Teaspoon(s)");
		toBox.getItems().addAll("Teaspoon(s)", "Tablespoon(s)", "Ounce(s)", "Cup(s)", "Pint(s)", "Quart(s)", "Gallon(s)");
		toBox.setValue("Teaspoon(s)");
		
		convertButton.setOnAction(new ButtonListener());
		clearButton.setOnAction(new ButtonListener());
		
		pane.getChildren().addAll(conv, convText, from, fromBox, to, toBox, convertButton, clearButton);
		VBox layout = new VBox(10.0);
		layout.getChildren().addAll(conv, convText, from, fromBox, to, toBox, convertButton, clearButton);
		primaryStage.setScene(new Scene(layout, 300, 300));
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	
	private class ButtonListener implements EventHandler<ActionEvent>
	{
		double amount;
		int from;
		int to;
		Button pressedButton = new Button();
		
		
		@Override
		public void handle(ActionEvent e)
		{
			pressedButton = (Button) e.getSource();
			if(pressedButton.getText().equals("Convert"))
			{
				try
				{
					String start = fromBox.getValue().toString();
					String conversion = toBox.getValue().toString();
					Conversion convertMeasure = new Conversion();
					amount = Double.parseDouble(convText.getText());
					if(start.equals("Teaspoon(s)"))
					{
						from = 0;
					}
					else if(start.equals("Tablespoon(s)"))
					{
						from = 1;
					}
					else if(start.equals("Ounce(s)"))
					{
						from = 2;
					}
					else if(start.equals("Cup(s)"))
					{
						from = 3;
					}
					else if(start.equals("Pint(s)"))
					{
						from = 4;
					}
					else if(start.equals("Quart(s)"))
					{
						from = 5;
					}
					else if(start.equals("Gallon(s)"))
					{
						from = 6;
					}
					
					
					if(conversion.equals("Teaspoon(s)"))
					{
						to = 0;
					}
					else if(conversion.equals("Tablespoon(s)"))
					{
						to = 1;
					}
					else if(conversion.equals("Ounce(s)"))
					{
						to = 2;
					}
					else if(conversion.equals("Cup(s)"))
					{
						to = 3;
					}
					else if(conversion.equals("Pint(s)"))
					{
						to = 4;
					}
					else if(conversion.equals("Quart(s)"))
					{
						to = 5;
					}
					else if(conversion.equals("Gallon(s)"))
					{
						to = 6;
					}
					
					convertMeasure.convertMeasurement(amount, from, to);
					new Output(start, conversion, amount, convertMeasure.getConvertOut(), 300, 300);
				}
				catch(Exception f)
				{
					JOptionPane.showMessageDialog(null, f);
				}
			}
			if(pressedButton.getText().equals("Clear"))
			{
				convText.clear();
				fromBox.setValue("Teaspoon(s)");
				toBox.setValue("Teaspoon(s)");
			}
		}
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}
			
				
				
					
	
		