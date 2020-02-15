//Authors: Gordon Bittner
//		   Bronson Batad
// Midterm CIT230

import javafx.event.*;
import javafx.stage.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;


public class Output extends Stage
{
	public Output(String from, String to, double amount, double converted, int height, int width)
	{
		super();
		this.initModality(Modality.WINDOW_MODAL);
		Label startAmount = new Label(amount + from);
		Label endAmount = new Label("Is equal to: " + converted + " " + to);
		
		Button closeButton = new Button("Done");
		
		closeButton.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{
				if(e.getSource() instanceof Button)
				{
					Button callingButton = (Button) e.getSource();
					Window dialogToClose = callingButton.getScene().getWindow();
					dialogToClose.hide();
				}
			}
		});
	VBox layout = new VBox(10.0);
	layout.setAlignment(Pos.BASELINE_CENTER);
	layout.getChildren().addAll(startAmount, endAmount);
	this.setScene(new Scene(layout, width, height));
	this.setResizable(false);
	this.show();
	}
}