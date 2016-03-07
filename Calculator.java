import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator implements ActionListener{
   private JFrame frame;
   private JTextField display;
   private JButton bksp;
   private JButton ce;
   private JButton c;
   private JButton divide;
   private JButton sqrt;
   private JButton b7;
   private JButton b8;
   private JButton b9;
   private JButton mult;
   private JButton mod;
   private JButton b4;
   private JButton b5;
   private JButton b6;
   private JButton minus;
   private JButton recip;
   private JButton b1;
   private JButton b2;
   private JButton b3;
   private JButton add;
   private JButton posNeg;
   private JButton b0;
   private JButton deci;
   private JButton equal;
   private JLabel title;
   private double stored;
   private int op;
   
   
   public Calculator(){
      stored = 0;
      frame = new JFrame("Calculator");
      frame.setSize(new Dimension(340, 220));
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setResizable(false);
      display = new JTextField(16);
      title = new JLabel("CSc 20 Lab 08");
      
      frame.setLayout(new BorderLayout());
      JPanel j1 = new JPanel(new BorderLayout());//GridLayout(2, 1));
      j1.add(title, BorderLayout.CENTER);
      j1.add(display, BorderLayout.SOUTH);
      frame.add(j1, BorderLayout.NORTH);
      
      JPanel j2 = new JPanel(new GridLayout(4, 5));
      j2.add(bksp = new JButton("BkSP"));
      j2.add(ce = new JButton("CE"));
      j2.add(c = new JButton("C"));
      j2.add(divide = new JButton("/"));
      j2.add(sqrt = new JButton("sqrt"));
      j2.add(b7 = new JButton("7"));
      j2.add(b8 = new JButton("8"));
      j2.add(b9 = new JButton("9"));
      j2.add(mult = new JButton("*"));
      j2.add(mod = new JButton("%"));
      j2.add(b4 = new JButton("4"));
      j2.add(b5 = new JButton("5"));
      j2.add(b6 = new JButton("6"));
      j2.add(minus = new JButton("-"));
      j2.add(recip = new JButton("1/x"));
      j2.add(b1 = new JButton("1"));
      j2.add(b2 = new JButton("2"));
      j2.add(b3 = new JButton("3"));
      j2.add(add = new JButton("+"));
      j2.add(posNeg = new JButton("+/-"));
      
      frame.add(j2, BorderLayout.CENTER);
      
      JPanel j3 = new JPanel(new GridLayout(1 , 3));
      j3.add(b0 = new JButton("0"));
      j3.add(deci = new JButton("."));
      j3.add(equal = new JButton("="));

      frame.add(j3, BorderLayout.SOUTH);
      bksp.addActionListener(this);
      ce.addActionListener(this);
      c.addActionListener(this);
      divide.addActionListener(this);
      sqrt.addActionListener(this);
      b7.addActionListener(this);
      b8.addActionListener(this);
      b9.addActionListener(this);
      mult.addActionListener(this);
      mod.addActionListener(this);
      b4.addActionListener(this);
      b5.addActionListener(this);
      b6.addActionListener(this);
      minus.addActionListener(this);
      recip.addActionListener(this);
      b1.addActionListener(this);
      b2.addActionListener(this);
      b3.addActionListener(this);
      add.addActionListener(this);
      posNeg.addActionListener(this);
      b0.addActionListener(this);
      deci.addActionListener(this);
      equal.addActionListener(this);
     
      frame.setVisible(true);
   }
   
   
   
   public void actionPerformed(ActionEvent event){
      JButton button = (JButton)(event.getSource());
      String text = display.getText();
      if (button.getText().equals("CE") || button.getText().equals("C")){
         display.setText("");
      }
      
      else{
         if(button.getText().equals("BkSP")){
            
            if(!(text.equals(""))){
               display.setText(text.substring(0, text.length() - 1));
            }
         }
         else{
            if (button.getText().equals(".")){
               if(!(text.contains("."))){
                  if(text.equals("")){
                     text = "0";
                  }
                  display.setText(text + button.getText());
               }
            }
            else{
               if (button.getText().equals("+/-")){
                  if (!(text.equals(""))){
                     if (!(text.contains("-"))){
                        display.setText("-" + text);
                     }
                     else{
                        display.setText(text.substring(1, text.length()));
                     }
                  }
               }
               else{
                  display.setText(text + button.getText());
               }
            }
         }
      }
   }
   
   
   public static void main(String[] args){
      Calculator gui = new Calculator();
   }
}