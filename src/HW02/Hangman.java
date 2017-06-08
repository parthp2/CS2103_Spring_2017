package HW02;

import javafx.animation.PathTransition;
import javafx.animation.Transition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.ArrayList;


public class Hangman extends Application {
	
	
    @Override
    public void start(Stage primaryStage) throws Exception {

        HPane pane = new HPane();

        Scene sc = new Scene(pane, 500, 500);
        
        sc.setOnKeyPressed(e-> 
        {
            pane.sendKeyCode(e.getCode());
        });

        primaryStage.setScene(sc);
        primaryStage.setTitle("Hangman HomeWork");
        primaryStage.show();
    }

    private class HPane extends Pane {

        // List of words
        private String[] words = {"Programming", "Java", "Is","Fun","Parth"};

        private double width = 500;
        private double height = 500;
        private final int THRESHOLD = 7;

      

        // Hangman
        Circle head;
        Line bottom;
        

        String word;
        ArrayList<Character> guessed = new ArrayList<>();
        ArrayList<Character> incorrect = new ArrayList<>();

        Label lblHidden = new Label();
        Label lblMissed = new Label();
        Label lblMessage = new Label();

        boolean isPlaying = true;

        PathTransition path;

        HPane() {
            startGame();
        }

        private void startGame() {

            getChildren().clear();
            guessed.clear();
            incorrect.clear();

            if (path != null) {
                path.stop();
            }

            word = getRandomWord();

            lblHidden.setText(getHiddenWord());
            lblMissed.setText("Missed letters: \n  ");
            lblMessage.setText("New Game: Make a guess!");

            double x = width * 0.4;
            double y = height * 0.8;
            lblHidden.setLayoutX(x);
            lblHidden.setLayoutY(y);

            lblMissed.setLayoutX(x);
            lblMissed.setLayoutY(y * 1.05);

            lblMessage.setLayoutX(x);
            lblMessage.setLayoutY(y * 1.15);

            getChildren().addAll(lblHidden, lblMissed, lblMessage);
            draw();
        }

        private void draw() {
           
            for (int i = 1; i <= guessed.size(); i++) {
                drawHangman(i);
            }
        }

        private void drawHangman(int i) {
            switch (i) {
                case 1: drawLife1(); break;
                case 2:drawLife2(); break;
                case 3: drawLife3(); break;
                case 4: drawLife4(); break;
                case 5: drawLife5(); break;
                case 6: drawLife6(); break;
                case 7: drawLife7(); break;
            }
        }

       
        private void drawLife1() {
        	bottom = new Line(50,380,450,380);
            double radius = width * 0.1;
            head = new Circle(250, 0 + radius, radius, Color.TRANSPARENT);
            head.setStroke(Color.BLACK);
            getChildren().addAll(head,bottom);
        }

        private void drawLife2() {
        	getChildren().remove(head);
        	bottom = new Line(50,380,450,380);
            double radius = width * 0.1;
            head = new Circle(250, 30 + radius, radius, Color.TRANSPARENT);
            head.setStroke(Color.BLACK);
            getChildren().addAll(head,bottom);
        }

        private void drawLife3() {
        	getChildren().remove(head);
        	bottom = new Line(50,380,450,380);
            double radius = width * 0.1;
            head = new Circle(250, 80 + radius, radius, Color.TRANSPARENT);
            head.setStroke(Color.BLACK);
            getChildren().addAll(head,bottom);
        }

        private void drawLife4() {
        	getChildren().remove(head);
        	bottom = new Line(50,380,450,380);
            double radius = width * 0.1;
            head = new Circle(250, 130 + radius, radius, Color.TRANSPARENT);
            head.setStroke(Color.BLACK);
            getChildren().addAll(head,bottom);
        }

        private void drawLife5() {
        	getChildren().remove(head);
        	bottom = new Line(50,380,450,380);
            double radius = width * 0.1;
            head = new Circle(250, 180 + radius, radius, Color.TRANSPARENT);
            head.setStroke(Color.BLACK);
            getChildren().addAll(head,bottom);
        }

        private void drawLife6() {
        	getChildren().remove(head);
        	bottom = new Line(50,380,450,380);
            double radius = width * 0.1;
            head = new Circle(250, 230 + radius, radius, Color.TRANSPARENT);
            head.setStroke(Color.BLACK);
            getChildren().addAll(head,bottom);
        }

        private void drawLife7() {
        	getChildren().remove(head);
        	bottom = new Line(50,380,450,380);
            double radius = width * 0.1;
            head = new Circle(250, 280 + radius, radius, Color.TRANSPARENT);
            head.setStroke(Color.BLACK);
            getChildren().addAll(head,bottom);
        }

        private boolean makeGuess(char ch) {

            if (!isPlaying) return false;

            
            if (isRepeatedGuess(ch)) {
                lblMessage.setText(ch + " has already been used! Try again.");
                return false; 
            }

          
            guessed.add(ch);

            String newWord = getHiddenWord(); 
           
            if (newWord.equalsIgnoreCase(lblHidden.getText())) {

                incorrect.add(ch); // keep track of incorrect guesses

                if ((incorrect.size() == THRESHOLD)) {
                    lblMessage.setText("You lost! Press enter to try again.");
                    isPlaying = false; 
                } else {
                    lblMessage.setText(ch + " is incorrect guess! \nYou have " + (THRESHOLD - incorrect.size()) + " lives left.");
                }
                lblMissed.setText(lblMissed.getText() + Character.toLowerCase(ch));
                drawHangman(incorrect.size());
                return false; 
            } 
            else 
            {
                
                lblHidden.setText(newWord);
                String s = "Correct!";
               
                if (newWord.equalsIgnoreCase(word)) {
                    s += " You won the game! \n Press Enter to continue";
                    isPlaying = false;
                }
                lblMessage.setText(s);
            }
            return true;
        }

        public void sendKeyCode(KeyCode key) {
            if (key == KeyCode.ENTER && !isPlaying) {
                isPlaying = true;
                startGame();
            } else if (key.isLetterKey()) {
                makeGuess(key.getName().charAt(0));
            }
        }

        private boolean isRepeatedGuess(char ch) {
            ch = Character.toUpperCase(ch);
            for (char letter : guessed) {
                if (letter == ch) {
                    return true;
                }
            }
            return false;
        }

        private String getHiddenWord() {

            String s = "";
            for (int i = 0; i < word.length(); i++) {
                boolean isMatched = false;
                for (char ch : guessed) {
                    if (Character.toLowerCase(ch) == Character.toLowerCase(word.charAt(i))) {
                        s += word.charAt(i);
                        isMatched = true;
                        break;
                    }
                }
                if (!isMatched) {
                    s += "*";
                }
            }
            return s;
        }

        private String getRandomWord() {
            return words[(int) (Math.random() * words.length)];
        }
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}