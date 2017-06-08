package Lab23Extra;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class Program2 extends JApplet {

 private static final long serialVersionUID = 1L;
 private CarPanel Panel1 = new CarPanel();
 private CarPanel Panel2 = new CarPanel();
 private CarPanel Panel3 = new CarPanel();
 private CarPanel Panel4 = new CarPanel();
 private JTextField jTextField1 = new JTextField("100");
 private JTextField jTextField2 = new JTextField("100");
 private JTextField jTextField3 = new JTextField("100");
 private JTextField jTextField4 = new JTextField("100");
 
 
 public static void main(String[] args) {
  JFrame frame = new JFrame();
  frame.add(new Program2());
  frame.setTitle("Program2");
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setSize(1000, 800);
  frame.setLocationRelativeTo(null);
  frame.setVisible(true);
 }

 
 public Program2() {
  JPanel panel2 = new JPanel(new GridLayout(1, 8));
  jTextField1.addKeyListener(new KeyAdapter()
  {   
   @Override
   public void keyReleased(KeyEvent e) 
   {
    try 
    {
     Panel1.setSpeed(Integer.parseInt(jTextField1.getText()));     
    } 
    catch (NumberFormatException e2)  {}
   }
  });
  
  jTextField2.addKeyListener(new KeyAdapter() 
  {   
   @Override
   public void keyReleased(KeyEvent e) {
    try 
    {
     Panel2.setSpeed(Integer.parseInt(jTextField2.getText()));     
    } catch (NumberFormatException e2) {
    }
   }
  });
  
  jTextField3.addKeyListener(new KeyAdapter() {   
   @Override
   public void keyReleased(KeyEvent e) {
    try {
     Panel3.setSpeed(Integer.parseInt(jTextField3.getText()));     
    } catch (NumberFormatException e2) {
    }
   }
  });
  
  jTextField4.addKeyListener(new KeyAdapter() {   
   @Override
   public void keyReleased(KeyEvent e) {
    try {
     Panel4.setSpeed(Integer.parseInt(jTextField4.getText()));     
    } catch (NumberFormatException e2) {
    }
   }
  });
  
  panel2.add(new JLabel("Car 1: ", JLabel.RIGHT));
  panel2.add(jTextField1);
  panel2.add(new JLabel("Car 2: ", JLabel.RIGHT));
  panel2.add(jTextField2);
  panel2.add(new JLabel("Car 3: ", JLabel.RIGHT));
  panel2.add(jTextField3);
  panel2.add(new JLabel("Car 4: ", JLabel.RIGHT));
  panel2.add(jTextField4);
  add(panel2, BorderLayout.NORTH);
  JPanel panel1 = new JPanel(new GridLayout(4, 1));
  panel1.add(Panel1);
  panel1.add(Panel2);
  panel1.add(Panel3);
  panel1.add(Panel4);
  add(panel1, BorderLayout.CENTER);
 }

 class CarPanel extends JPanel  implements Runnable  {
  private int yPos;
  private int xPos;
  private int size = 20;
  private int speed = 100;
  private boolean firstRun = true;
  private static final long serialVersionUID = 1L;

  public CarPanel() {
   setBorder(new LineBorder(Color.BLACK));
   Thread thread = new Thread(this);
   thread.start();
  }
  
  public void setSpeed(int speed) {
   if (speed < 1) {
    speed = 1;
   }
   this.speed = speed;
  }
  
  @Override
  protected void paintComponent(Graphics g) {
   super.paintComponent(g);
   if (firstRun) {
    xPos = - 5* size;
    firstRun = false;
   }
   yPos = getHeight();
   g.setColor(Color.BLACK);
   g.fillOval(xPos + size, yPos - size, size, size);
   g.fillOval(xPos + 3 * size, yPos - size, size, size);
   g.setColor(Color.MAGENTA);
   g.fillRect(xPos, yPos - 2 * size, 5 * size, size);
   g.setColor(Color.GREEN);
   Polygon p = new Polygon();
   p.addPoint(xPos + size, yPos - 2 * size);
   p.addPoint(xPos + 2 * size, yPos - 3 * size);
   p.addPoint(xPos + 3 * size, yPos - 3 * size);
   p.addPoint(xPos + 4 * size, yPos - 2 * size);
   g.fillPolygon(p);
  }
 
  @Override
  public void run() {
   try {
    while (true) {
     Thread.sleep(speed);
     xPos += 1;
     if (xPos >= getWidth()) {
      xPos = -5 * size;
     }
     repaint();
    }
   } catch (InterruptedException e) {
    e.printStackTrace();
   }
  }

 }
}