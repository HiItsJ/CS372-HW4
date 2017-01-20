import javax.swing.*;
import java.awt.*;
import java.util.*;

public class DiceRoll implements Runnable{

  JLabel label;

  public DiceRoll(JLabel l){
    label = l;
  }
  public void run(){
    Image dice1 = Toolkit.getDefaultToolkit().getImage("/Users/Josiah/Desktop/CS/CS372-ALL/Dice1.png");
    Image dice2 = Toolkit.getDefaultToolkit().getImage("/Users/Josiah/Desktop/CS/CS372-ALL/Dice2.png");
    Image dice3 = Toolkit.getDefaultToolkit().getImage("/Users/Josiah/Desktop/CS/CS372-ALL/Dice3.png");
    Image dice4 = Toolkit.getDefaultToolkit().getImage("/Users/Josiah/Desktop/CS/CS372-ALL/Dice4.png");
    Image dice5 = Toolkit.getDefaultToolkit().getImage("/Users/Josiah/Desktop/CS/CS372-ALL/Dice5.png");
    Image dice6 = Toolkit.getDefaultToolkit().getImage("/Users/Josiah/Desktop/CS/CS372-ALL/Dice6.png");
    dice1 = dice1.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
    dice2 = dice2.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
    dice3 = dice3.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
    dice4 = dice4.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
    dice5 = dice5.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
    dice6 = dice6.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
    ImageIcon icon1 = new ImageIcon(dice1);
    ImageIcon icon2 = new ImageIcon(dice2);
    ImageIcon icon3 = new ImageIcon(dice3);
    ImageIcon icon4 = new ImageIcon(dice4);
    ImageIcon icon5 = new ImageIcon(dice5);
    ImageIcon icon6 = new ImageIcon(dice6);

    ImageIcon[] icons = new ImageIcon[6];
    icons[0] = icon1;
    icons[1] = icon2;
    icons[2] = icon3;
    icons[3] = icon4;
    icons[4] = icon5;
    icons[5] = icon6;

    Random rand = new Random();
    int n;

    for (int x=10; x>=0; x--){
      n = rand.nextInt(6);
      label.setIcon(icons[n]);
      try{
        Thread.sleep(100);
      }
      catch(InterruptedException ex){;}
    }
  }
}
