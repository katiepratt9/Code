package Mans;

	import java.awt.EventQueue;
	import javax.swing.JFrame;

	public class Pacman extends JFrame {

	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public Pacman() {
	        
	        initUI();
	    }
	    
	    private void initUI() {
	        
	        add(new Board());
	        setTitle("Pacman");//form text title
	        setDefaultCloseOperation(EXIT_ON_CLOSE);//when click x exit
	        setSize(380, 420);//size of form
	        setLocationRelativeTo(null);//where it should open on screen doesnt matter
	        setVisible(true);//form is visible
	    }

	    public static void main(String[] args) {

	        EventQueue.invokeLater(new Runnable() {

	            @Override
	            public void run() {
	                Pacman ex = new Pacman();//when die reload pacman
	                ex.setVisible(true);//set it to visible
	            }
	        });
	    }
	}
