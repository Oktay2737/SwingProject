package Components;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;

public class ScrollPane extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScrollPane frame = new ScrollPane();
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
	public ScrollPane() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JEditorPane editorPane = new JEditorPane();//EDİTOR PANE CONTENTPANE EKLENMİYOR. 
		//SCROLLPANE'NİN CONSTRUCTORUNA EKLENİYOR.
		editorPane.setBounds(10, 28, 75, 86);
		//contentPane.add(editorPane);
		
		JScrollPane scrollPane = new JScrollPane(editorPane);
		scrollPane.setBounds(104, 28, 80, 86);
		contentPane.add(scrollPane);
	}
}
