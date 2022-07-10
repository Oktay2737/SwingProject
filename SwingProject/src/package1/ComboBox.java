package package1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ComboBox extends JFrame {

	private JPanel Window;
	
	DefaultComboBoxModel model_red = new DefaultComboBoxModel<>();
	DefaultComboBoxModel model_green = new DefaultComboBoxModel<>();
	DefaultComboBoxModel model_blue = new DefaultComboBoxModel<>();
	int r,g,b;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComboBox frame = new ComboBox();
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
	public ComboBox() {
		r=255;g=255;b=255;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		Window = new JPanel();
		Window.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Window);
		Window.setLayout(null);
		
		JComboBox RedValue = new JComboBox();
		RedValue.setBounds(31, 34, 74, 22);
		Window.add(RedValue);
		
		JComboBox GreenValue = new JComboBox();
		GreenValue.setBounds(165, 34, 74, 22);
		Window.add(GreenValue);
		
		JComboBox BlueValue = new JComboBox();
		BlueValue.setBounds(297, 34, 81, 22);
		Window.add(BlueValue);
		
		for(int i =0; i<256; i++) {
			model_red.addElement(i);
			model_green.addElement(i);
			model_blue.addElement(i);
		}
		RedValue.setModel(model_red);
		GreenValue.setModel(model_green);
		BlueValue.setModel(model_blue);
		
		JLabel redBoard = new JLabel("Red");
		redBoard.setOpaque(true);
		redBoard.setHorizontalAlignment(SwingConstants.CENTER);
		redBoard.setBounds(31, 78, 46, 14);
		Window.add(redBoard);
		
		JLabel greenBoard = new JLabel("Green");
		greenBoard.setOpaque(true);
		greenBoard.setHorizontalAlignment(SwingConstants.CENTER);
		greenBoard.setBounds(165, 78, 46, 14);
		Window.add(greenBoard);
		
		JLabel blueBoard = new JLabel("Blue");
		blueBoard.setOpaque(true);
		blueBoard.setHorizontalAlignment(SwingConstants.CENTER);
		blueBoard.setBounds(297, 78, 46, 14);
		Window.add(blueBoard);
		
		RedValue.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				r=RedValue.getSelectedIndex();
				redBoard.setBackground(new Color(r,0,0));
			}
		});
		GreenValue.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				g=RedValue.getSelectedIndex();
				greenBoard.setBackground(new Color(0,g,0));
			}
		});
		BlueValue.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				b=BlueValue.getSelectedIndex();
				blueBoard.setBackground(new Color(0,0,b));
			}
		});
	}
}
