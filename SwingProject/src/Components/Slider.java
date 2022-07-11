package Components;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Slider extends JFrame {

	private JPanel contentPane;
	int w, h;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Slider frame = new Slider();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Slider() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSlider slider = new JSlider();		
		slider.setPaintTicks(true);
		slider.setMinimum(10);
		slider.setBounds(10, 11, 200, 26);
		contentPane.add(slider);
		
		JSlider slider_1 = new JSlider();		
		slider_1.setPaintTicks(true);
		slider_1.setMinimum(10);
		slider_1.setOrientation(SwingConstants.VERTICAL);
		slider_1.setBounds(381, 11, 31, 239);
		contentPane.add(slider_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setBounds(167, 102, 50, 50);
		contentPane.add(btnNewButton);
		w=50;
		h=50;
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				w=slider.getValue();
				btnNewButton.setBounds(167, 102, w, h);
			}
		});
		slider_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				h=slider_1.getValue();
				btnNewButton.setBounds(167, 102, w, h);
			}
		});
	}
}
