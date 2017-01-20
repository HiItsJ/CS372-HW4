import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class DiceThread extends JFrame implements ActionListener{

  JButton button;

  DiceRoll[] dr;
  Thread[] ts;

  public DiceThread(){
    setSize(800, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new FlowLayout());

    dr = new DiceRoll[4];
    for (int x=0; x<4; x++){
      JLabel l  = new JLabel();
      dr[x] = new DiceRoll(l);
      this.add(l);
    }
    button = new JButton("Roll");
    button.addActionListener(this);
    this.add(button);

    this.setVisible(true);

    ts = new Thread[4];
    for (int x=0; x<4; x++){
      ts[x] = new Thread(dr[x]);
      ts[x].start();
      try{
        Thread.sleep(100);
      }
      catch (InterruptedException ex){;}
    }
    /*
    JLabel i = new JLabel();
    try{
      URL iu = new URL("http://www.psdgraphics.com/file/rocket-icon.jpg");
      Image img = Toolkit.getDefaultToolkit().getImage(iu);
      ImageIcon icon = new ImageIcon(img);
      i.setIcon(icon);
    }
    catch (Exception ex) {i.setText("dang it");}
    this.add(i);
    revalidate();
    */
  }
  public void ThreadStart(){
    ts = new Thread[4];
    for (int x=0; x<4; x++){
      ts[x] = new Thread(dr[x]);
      ts[x].start();
      try{
        Thread.sleep(100);
      }
      catch (InterruptedException ex){;}
    }
    for (int i=0; i<4; i++) {
      try {
        ts[i].join();
      }
      catch (InterruptedException ex) {;}
    }
  }
  public void actionPerformed(ActionEvent e){
    if (e.getSource()==button){
      ThreadStart();
    }
  }
  public static void main(String[] args){
    DiceThread dt = new DiceThread();
  }
}
