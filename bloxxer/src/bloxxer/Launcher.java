package bloxxer;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToggleButton;

import grapchis.Screen;
import input.InputHandler;

public class Launcher extends Canvas {

	public static final int WIDTH = 600;
	public static final int HEIGHT = 800;
	public static final String TITLE = "bloxxer launcher";
	
	public static void main(String[] args) {
		Launcher launcher = new Launcher();
		JFrame frame = new JFrame();
		JToggleButton button = new JToggleButton("play!");
		button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
		        Display.main(args);
		    }
		});
		frame.add(button);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setTitle(TITLE);
	}
	
	public void start(String[] args) {
		Display.main(args);
	}
	
}
