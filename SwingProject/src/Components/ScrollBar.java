package Components;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;

public class ScrollBar extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScrollBar frame = new ScrollBar();
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
	public ScrollBar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setUnitIncrement(10);
		scrollBar.setMaximum(110);
		scrollBar.setOrientation(JScrollBar.HORIZONTAL);
		scrollBar.setBounds(52, 33, 314, 17);
		contentPane.add(scrollBar);
		
		JLabel lblValue = new JLabel("  Value");
		lblValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblValue.setBounds(157, 91, 101, 24);
		contentPane.add(lblValue);
		
		scrollBar.addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent e) {
				lblValue.setText(Integer.toString(scrollBar.getValue()));
			}
		});
	}

}
