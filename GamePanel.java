import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;


public class GamePanel extends JPanel {

    private Game game;
    public static final int SIDE = 100;
    private boolean isLost;

    private List<ImageIcon> icons = new ArrayList<ImageIcon>();

    {
        icons.add(new ImageIcon("./src/image/2.png"));
        icons.add(new ImageIcon("./src/image/4.png"));
        icons.add(new ImageIcon("./src/image/8.png"));
        icons.add(new ImageIcon("./src/image/16.png"));
        icons.add(new ImageIcon("./src/image/32.png"));
        icons.add(new ImageIcon("./src/image/64.png"));
        icons.add(new ImageIcon("./src/image/128.png"));
        icons.add(new ImageIcon("./src/image/256.png"));
        icons.add(new ImageIcon("./src/image/512.png"));
        icons.add(new ImageIcon("./src/image/1024.png"));
        icons.add(new ImageIcon("./src/image/2048.png"));
    }

    public GamePanel() {
        game = new Game();

        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(Game.ROWS * SIDE, Game.COLUMNS * SIDE));
        setFocusable(true);

        addKeyListener(new directionListener());
        isLost = false;
    }

    private ImageIcon getIcon(int number) {
        int idx = (int) (Math.log(number) / Math.log(2)) - 1;
        return icons.get(idx);
    }

    public void paint(Graphics page) {
        super.paint(page);
        int[][] board = game.getGameBoard();
        for (int i = 0; i < Game.ROWS; i++) {
            for (int j = 0; j < Game.COLUMNS; j++) {
                if (board[i][j] != 0)
                    getIcon(board[i][j]).paintIcon(this, page, j * SIDE, i * SIDE);
            }
        }
        if (isLost){
            reset();
        }
    }

    private class directionListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    isLost = !game.left();
                    break;
                case KeyEvent.VK_RIGHT:
                    isLost = !game.right();
                    break;
                case KeyEvent.VK_UP:
                    isLost = !game.up();
                    break;
                case KeyEvent.VK_DOWN:
                    isLost = !game.down();
            }
            repaint();

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    private void reset(){
        int restart = JOptionPane.showConfirmDialog(null,"You lost!\n Do you want to start again?");
        if (restart == JOptionPane.YES_OPTION){
        	isLost = false;
            game = new Game();
            repaint();
        }
        else{
            System.exit(1);
        }
    }
}
