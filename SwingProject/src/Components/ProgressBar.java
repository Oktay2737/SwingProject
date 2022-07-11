package Components;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;

public class ProgressBar extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProgressBar frame = new ProgressBar();
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
	public ProgressBar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setForeground(Color.GREEN);
		progressBar.setBackground(Color.LIGHT_GRAY);
		progressBar.setValue(50);
		progressBar.setBounds(20, 28, 146, 14);
		contentPane.add(progressBar);
		
		JSpinner spinner = new JSpinner();		
		spinner.setModel(new SpinnerNumberModel(50, 0, 100, 1));
		spinner.setBounds(20, 65, 146, 20);
		contentPane.add(spinner);
		
		JProgressBar progressBar_1 = new JProgressBar();
		progressBar_1.setStringPainted(true);
		progressBar_1.setForeground(Color.RED);
		progressBar_1.setBounds(20, 151, 146, 26);
		contentPane.add(progressBar_1);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread t1 = new Thread() {
					public void run() {
						for(int i =0;i<101;i++) {
							try {
								TimeUnit.MILLISECONDS.sleep(10);
							} catch (Exception e2) {
								e2.printStackTrace();
							}
							progressBar_1.setValue(i);
						}
					}
				};
				t1.start();
			}
		});
		btnStart.setBounds(20, 195, 146, 23);
		contentPane.add(btnStart);
		
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				progressBar.setValue(Integer.parseInt(spinner.getValue().toString()));
			}
		});
	}
}
