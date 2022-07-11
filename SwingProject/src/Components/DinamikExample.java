package Components;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class DinamikExample extends JFrame {

	private JPanel contentPane;
	JLabel[] labels;
	JTextField[] textFields;
	private JTextField txtNumber;
	private JButton btnCreate;
	JButton btnGetDers = new JButton("GetDers");
	JButton btnClear = new JButton("Clear");
	private JTextPane textPaneDersler;
	int number;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DinamikExample frame = new DinamikExample();
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
	public DinamikExample() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		/*
		JLabel lblDers_1 = new JLabel("Ders 1");
		lblDers_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDers_1.setBounds(10, 40, 46, 14);
		contentPane.add(lblDers_1);
		*/
		txtNumber = new JTextField();
		txtNumber.setBounds(10, 8, 86, 20);
		contentPane.add(txtNumber);
		txtNumber.setColumns(10);
		
		btnCreate = new JButton("Create");
		btnCreate.setBounds(106, 7, 89, 23);
		contentPane.add(btnCreate);
		
		textPaneDersler = new JTextPane();
		textPaneDersler.setEditable(false);
		textPaneDersler.setBounds(256, 42, 131, 150);
		contentPane.add(textPaneDersler);
		textPaneDersler.setVisible(false);
		
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number = Integer.parseInt(txtNumber.getText());
				labels = new JLabel[number];
				textFields = new JTextField[number];
				for(int i=0;i<number;i++) {
					String dersSira ="Ders"+" "+(i+1);
					labels[i] = new JLabel(dersSira);
					labels[i].setHorizontalAlignment(SwingConstants.CENTER);
					labels[i].setBounds(10, 40+(i*20), 46, 14);
					contentPane.add(labels[i]);
					
					textFields[i] = new JTextField();
					textFields[i].setBounds(80, 40+(i*20), 100, 20);
					contentPane.add(textFields[i]);
					contentPane.repaint();
				}
				
				btnCreate.setEnabled(false);
				
				btnGetDers.setBounds(20, 40+((number+1)*20), 89, 23);
				contentPane.add(btnGetDers);
				btnClear.setBounds(120, 40+((number+1)*20), 89, 23);
				contentPane.add(btnClear);
				//contentPane.repaint();
				
			}
		});
		btnGetDers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dersler="";
				for(int i =0;i< textFields.length;i++) {
					dersler+=textFields[i].getText()+" \n";
				}
				textPaneDersler.setVisible(true);
				textPaneDersler.setText(dersler);
			}
		});
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<number;i++) {
				contentPane.remove(textFields[i]);
				contentPane.remove(labels[i]);
				contentPane.remove(btnGetDers);
				contentPane.remove(btnClear);
				btnCreate.setEnabled(true);
				textPaneDersler.setVisible(false);
				contentPane.revalidate();
				contentPane.repaint();
				}
			}
		});
	}

}
