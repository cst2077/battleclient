

import javax.swing.JFrame;

public class RType extends JFrame {

    public RType() {
    	Board board =new Board();
        add(board);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setTitle("R - Type");
        setResizable(false);
        setVisible(true);
        (new Thread(new Client(board.craft))).start();
    }

    public static void main(String[] args) {
        new RType();
    }
}
