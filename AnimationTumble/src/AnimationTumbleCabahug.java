import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.management.timer.Timer;
//import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class AnimationTumbleCabahug extends JFrame {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JPanel panel = new JPanel();
	Timer timer;
	int x = 0;
	int y = 35;
	final int WIDTH = 200;
	final int HIGHT = 100;
	final int PANEL_WIDTH = 500;
	final int PANEL_HEIGHT = 500;
	int xVelocity = 10;
	int yVelocity = 10;
	Graphics2D rectangle;
	JButton stopStart = new JButton("Start/Stop");
	public AnimationTumbleCabahug() {
	        super("Animation Tumble");
	        
	        
	        setSize(500,500);
	       // stopStart.setLocation(500, 500);
	        panel.setBackground(Color.GRAY);
	        panel.setSize(PANEL_WIDTH,PANEL_HEIGHT);
	        panel.add(stopStart);
	        setResizable(false);
	        Timer timer = new Timer();
	        
	        timer.start();
	        stopStart.addMouseListener(new MouseAdapter() {
				int clicked = 0;
				

				@Override

				public void mouseClicked(MouseEvent e) {

					clicked++;
					Color[] colors = new Color[2];
					colors[0] = Color.green;
					colors[1] = Color.red;
					if (clicked % 2 != 0) {
						stopStart.setText("End");

						// For each button in the ArrayList change the colors from green to red randomly
					
							new Thread() {
								public void run() {
									while (stopStart.getText().equals("End")) {
										// While text is equal to End run the program

										try {
											// This randomly changes the colors
											sleep(100);// time in milliseconds
											
											if (x >= PANEL_WIDTH-WIDTH || x<0) {
												xVelocity = xVelocity*-1;
											}
											x = x + xVelocity;
											if (y >= PANEL_WIDTH-WIDTH || y<0) {
												yVelocity = yVelocity*-1;
											}
											y = y + yVelocity;
											
											Random change = new Random();
											int changes = change.nextInt(colors.length);
											Color shade = colors[changes];
											rectangle.setPaint(shade);
											repaint();

										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										} // end of try-catch

									} // end of while
								}// end of run
							}.start();// method executes the thread

						
					} else {
						// else stop where the last color change was and end the color changing
						stopStart.setText("Begin");
						
					} // end of if-else
				}// end of mouse clicked method

			});  
	  
	        
	        
	        add(panel);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);
	       
	       
	        setVisible(true);
	    }
		
	    void drawRectangles(Graphics g) {
	         rectangle = (Graphics2D) g;
	 
	        rectangle.setPaint(Color.BLUE);
	       
	        rectangle.fillRect(x, y, WIDTH, HIGHT);
	        // Defines an array of colors with green and red
			Color[] colors = new Color[2];
			colors[0] = Color.green;
			colors[1] = Color.red;
			
			
	 
	    }
	 
	    public void paint(Graphics g) {
	        super.paint(g);
	        drawRectangles(g);
	    }
	    
	    
	 
	    public static void main(String[] args) throws Exception {
	 
	        SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                new AnimationTumbleCabahug();
	            }
	        });
	        
		    
	       
}

		
	    

}
