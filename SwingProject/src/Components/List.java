package Components;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.awt.event.ActionEvent;

public class List extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					List frame = new List();
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
	public List() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"a", "b", "c", "d", "e", "f"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(26, 26, 58, 66);
		//contentPane.add(list);
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(109, 26, 66, 66);
		contentPane.add(scrollPane);
		
		JButton btnSelect = new JButton("Select");
		
		btnSelect.setBounds(109, 133, 89, 23);
		contentPane.add(btnSelect);
		
		JLabel lblSelected = new JLabel("lblSelected");
		lblSelected.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelected.setBounds(104, 179, 129, 32);
		contentPane.add(lblSelected);
		
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Collection selectList = list.getSelectedValuesList();
				String s = selectList.toString();
				System.out.println(s);
				lblSelected.setText(s);
				
			}
		});
	}
}
