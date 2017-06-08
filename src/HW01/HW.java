package HW01;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class HW extends Application{
	
	public static void main(String args[])
	{
		Application.launch(args);
	}
	
	@Override
	public void start(Stage stage)
	{
		tree t=new tree();
		t.draw();
		
		BorderPane bp=new BorderPane(t);
		
		Scene scence= new Scene(bp); 
		
		
		TextField text=new TextField("0");
		text.setAlignment(Pos.BASELINE_CENTER);
		
		
		
		HBox h=new HBox();
		Label l=new Label("Enter an Order:");
		Button b=new Button("Display");
		h.setAlignment(Pos.BASELINE_CENTER);
		h.getChildren().add(l);
		h.getChildren().add(text);
		h.getChildren().add(b);
		
		b.setOnAction(
				
				e->{
					
					  
			                try {
			                    t.setOrder(Integer.parseInt(text.getText()));

			                } catch (NumberFormatException ex) {
			                    t.setOrder(0);
			                    text.setText("0");
			                }

			                t.draw();
			           
					
			}	);
		
		
		bp.setBottom(h);
		stage.setScene(scence);
		stage.setTitle("HW01");
		stage.show();
	}
	
	public class tree extends Pane
	{
		double s1,s2,size;
		int order=0;
		
		tree()
		{
				s1=600;
				s2=600;
				size=Math.min(s1,s2) *0.4;
				setMinSize(s1,s2);
				draw();
		}
		
		public  void draw()
		{
			getChildren().clear();
		    double x = s1 * 0.30;
	        double y = s2 * 0.70;
	        draw(x, y, order, size);
			
		}
		
		private void draw(double x, double y, int order, double lastSize) {

            Line l1 = new Line(x, y, x, y - lastSize);
            Line l2 = new Line(x + lastSize, y, x + lastSize, y - lastSize);
            Line l3 = new Line(x, y - (lastSize / 2), x + lastSize, y - (lastSize / 2));
            getChildren().addAll(l1, l2, l3);

            if (order > 0) {
                double halfSize = lastSize / 2;
                double offset = halfSize / 2;
                // top left , top right H
                draw(l1.getStartX() - offset, l1.getEndY() + halfSize / 2, order - 1, halfSize);
                draw(l2.getStartX() - offset, l1.getEndY() + halfSize / 2, order - 1, halfSize);
                // bottom left, bottom right H
                draw(l1.getEndX() - offset, l1.getStartY() + halfSize / 2, order - 1, halfSize);
                draw(l2.getEndX() - offset, l1.getStartY() + halfSize / 2, order - 1, halfSize);
            }
        }

		 
		 public void setOrder(int order) 
		 {
	            this.order = order;
	        }
	}
}
