package ba.unsa.etf.si.app.sistemZaEvidencijuStalnihSredstava;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.Query;
import org.hibernate.Session;

import ba.unsa.etf.si.klase.TipStalnogSredstva;
import ba.unsa.etf.si.util.HibernateUtil;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class BrisanjeTipaStalnogSredstva extends JFrame {

	private JPanel contentPane;
	private Session session;
	private JComboBox kombo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Session sesija = HibernateUtil.getSessionFactory().openSession();
					BrisanjeTipaStalnogSredstva frame = new BrisanjeTipaStalnogSredstva(sesija);
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
	public void refresh()
	{
		try 
		{
			kombo.removeAllItems();
			List<TipStalnogSredstva> k = TipStalnogSredstva.SviTipovi(session);
			for(TipStalnogSredstva s : k)
			{
				kombo.addItem(s);
			}
		} 
		catch (Exception e1) 
		{
			JOptionPane.showMessageDialog(this, "Nema Tipova pa se nemogu ni obrisat");
			dispose();
			
		}
	}
	public BrisanjeTipaStalnogSredstva(Session sesija) {
		session = sesija;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 268, 166);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox= new JComboBox();
		try 
		{
			
			List<TipStalnogSredstva> k = TipStalnogSredstva.SviTipovi(session);
			for(TipStalnogSredstva s : k)
			{
				comboBox.addItem(s);
			}
		} 
		catch (Exception e1) 
		{
			JOptionPane.showMessageDialog(this, "Nema Tipova pa se nemogu ni obrisat");
			dispose();
			
		}
		
		comboBox.setBounds(85, 53, 157, 20);
		contentPane.add(comboBox);
		kombo = comboBox;
		
		JLabel lblIzaberiteTipStalnog = new JLabel("Izaberite tip stalnog sredstva:");
		lblIzaberiteTipStalnog.setBounds(69, 27, 171, 14);
		contentPane.add(lblIzaberiteTipStalnog);
		
		JButton btnObrii = new JButton("Obriši");
		btnObrii.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TipStalnogSredstva tip= (TipStalnogSredstva)kombo.getSelectedItem();
				try {
					tip.obrisi(session);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Greska pri brisanju tipa.");
					return;
				}
				JOptionPane.showMessageDialog(null, "Tip sredstva obrisan.");
				refresh();
			}
		});
		btnObrii.setBounds(69, 93, 84, 23);
		contentPane.add(btnObrii);
		
		JButton btnIzai = new JButton("Izađi");
		btnIzai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnIzai.setBounds(163, 93, 79, 23);
		contentPane.add(btnIzai);
	}
}
