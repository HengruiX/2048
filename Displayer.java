import javax.swing.*;

public class Displayer {

    public static void display(){

        JFrame frame = new JFrame("game");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new GamePanel());
        frame.pack();
        frame.setVisible(true);
    }
}
