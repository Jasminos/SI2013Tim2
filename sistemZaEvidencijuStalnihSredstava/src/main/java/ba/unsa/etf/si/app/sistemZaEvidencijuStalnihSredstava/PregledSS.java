package ba.unsa.etf.si.app.sistemZaEvidencijuStalnihSredstava;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;

import ba.unsa.etf.si.util.HibernateUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PregledSS extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private Session session;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Session sesija = HibernateUtil.getSessionFactory().openSession();
					PregledSS frame = new PregledSS(sesija);
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
	public PregledSS(Session sesija) {
		session = sesija;
		setTitle("Pregled stalnh sredstava");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 597, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIzaberiteParametarPretrage = new JLabel("Izaberite parametar pretrage:");
		lblIzaberiteParametarPretrage.setBounds(21, 24, 186, 14);
		contentPane.add(lblIzaberiteParametarPretrage);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(204, 21, 100, 20);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(31, 56, 144, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnPretraite = new JButton("Pretra\u017Eite");
		btnPretraite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JOptionPane.showMessageDialog(null, "Nije implementirano!");
			}
		});
		btnPretraite.setBounds(204, 55, 100, 23);
		contentPane.add(btnPretraite);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 101, 561, 187);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Naziv", "Tip", "Datum nabavke", "Datum stavljanja u upotrebu", "Datum isteka vrijednosti"
			}
		));
		table.getColumnModel().getColumn(2).setPreferredWidth(110);
		table.getColumnModel().getColumn(3).setPreferredWidth(191);
		table.getColumnModel().getColumn(4).setPreferredWidth(166);
		scrollPane.setViewportView(table);
		
		JButton btnIzai = new JButton("Iza\u0111i");
		btnIzai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnIzai.setBounds(453, 306, 89, 23);
		contentPane.add(btnIzai);
	}
}
