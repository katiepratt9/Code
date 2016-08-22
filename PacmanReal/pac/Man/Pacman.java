package Man;
import java.awt.EventQueue;

import javax.swing.JFrame;
public class Pacman extends JFrame {
	private static final long serialVersionUID = 1L;
public Pacman() {
        
        initUI();
    }
    
    private void initUI() {
        
        new CreateBoard();
        setTitle("Pacman");//form text title
        setDefaultCloseOperation(EXIT_ON_CLOSE);//when click x exit
        setSize(380, 420);//size of form
        setLocationRelativeTo(null);//where it should open on screen doesnt matter
        setVisible(true);//form is visible
    }
    
}
