package ba.unsa.etf.si.app.sistemZaEvidencijuStalnihSredstava;


import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFileChooser;
import javax.swing.JLabel;


import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JSpinner;

import org.hibernate.Query;
import org.hibernate.Session;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import ba.unsa.etf.si.klase.StalnoSredstvo;
import ba.unsa.etf.si.util.HibernateUtil;

import com.itextpdf.text.Font;
import com.toedter.calendar.JDateChooser;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javax.swing.SpinnerNumberModel;

public class NabavljenaSredstva extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private Session session;
	private JDateChooser dateChooser;
	private JDateChooser dateChooser_1;
	private JSpinner spinner;
	private JSpinner spinner_1;
	
	private String getPath() {
		JFileChooser chooser;
		String path = "";
		
	    chooser = new JFileChooser(); 
	    chooser.setCurrentDirectory(new java.io.File("."));
	    chooser.setDialogTitle("Izbor putanje");
	    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    
	    chooser.setAcceptAllFileFilterUsed(false);
	        
	    if (chooser.showOpenDialog(chooser) == JFileChooser.APPROVE_OPTION) { 	      
	    	path = chooser.getSelectedFile().toString();
	      }
    
		return path;
	
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Session sesija = HibernateUtil.getSessionFactory().openSession();
					NabavljenaSredstva frame = new NabavljenaSredstva(sesija);
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
	public NabavljenaSredstva(Session sesija) {
		setResizable(false);
		session = sesija;
		setTitle("Nabavljena stalna sredstva");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 587, 277);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnUredu = new JButton("Uredu");
		btnUredu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Random rand = new Random();
				int x = rand.nextInt(1000);
						
				final String FILE = getPath() + File.separator + "NabavljenaStalnaSredstva_" + x +".pdf"; 
			    final Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD); 
			    final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
			    
			    try { 
			        Document document = new Document(); 
			        PdfWriter.getInstance(document, new FileOutputStream(FILE)); 
			        document.open(); 
			        
			        //addMetaData(document); 
			        document.addTitle("Izvjestaj o nabavljenim stalnim sredstvima"); 
			        	        
			        Paragraph preface = new Paragraph(); 
			        preface.add(new Paragraph(" ")); 
			        Date d = new Date();
			        preface.add(new Paragraph(" "));
			        String s = Integer.toString(d.getDay())+"." + Integer.toString(d.getMonth())+".20"+Integer.toString(d.getYear()-100) + ".";
			        preface.add(new Paragraph("Datum: " + s, smallBold));
			        preface.add(new Paragraph(" "));
			        preface.add(new Paragraph(" "));
			        document.add(preface);
			        Paragraph nesto=new Paragraph("Izvjestaj o nabavljenim stalnim sredstvima");
			        nesto.setAlignment(Element.ALIGN_CENTER);
			        document.add(nesto);
			        preface = new Paragraph();
			        Query query = session.createQuery("from StalnoSredstvo");
					List<StalnoSredstvo> result = (List<StalnoSredstvo>)query.list();
					List<StalnoSredstvo> pravi = new ArrayList<StalnoSredstvo> ();
					for(StalnoSredstvo k : result)
					{
						if(!k.isOtpisano() && !k.isuUpotrebi() &&(dateChooser.getDate().equals(dateChooser_1.getDate())|| (k.getDatumNabavke().before(dateChooser_1.getDate())&& k.getDatumNabavke().after(dateChooser.getDate()))) && (textField.getText().equals("")||textField.getText().equals(k.getLokacija())) && ((spinner.getValue().equals(0) && spinner_1.getValue().equals(0))|| ((Integer)spinner.getValue()<k.getNabavnaVrijednost()&& (Integer)spinner_1.getValue()>k.getNabavnaVrijednost()))  )
						{
							pravi.add(k);
						}
					}
					 preface.add(new Paragraph(" "));
				     preface.add(new Paragraph(" "));
					preface.add(new Paragraph("Broj nabavljenih stalnih sredstava:  " + Integer.toString(pravi.size()), smallBold));
					preface.add(new Paragraph(" "));
					preface.add(new Paragraph(" "));
			        document.add(preface); 
			        
			        PdfPTable table = new PdfPTable(5); 
			      
			        PdfPCell c1 = new PdfPCell(new Phrase("Lokacija")); 
			        c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
			        table.addCell(c1); 
			      
			        c1 = new PdfPCell(new Phrase("Naziv")); 
			        c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
			        table.addCell(c1); 
			      
			        c1 = new PdfPCell(new Phrase("Tip")); 
			        c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
			        table.addCell(c1); 
			          
			        c1 = new PdfPCell(new Phrase("Nabavna vrijednost")); 
			        c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
			        table.addCell(c1); 
			        
			        c1 = new PdfPCell(new Phrase("Datum nabavke")); 
			        c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
			        table.addCell(c1);
			        
			        table.setHeaderRows(1); 
			        for(int i=0; i<pravi.size(); i++)
			        {
			        	table.addCell(pravi.get(i).getLokacija());
			        	table.addCell(pravi.get(i).getNaziv());
			        	table.addCell(pravi.get(i).getTip().toString());
			        	table.addCell(Double.toString(pravi.get(i).getNabavnaVrijednost())+" KM");      
			        	table.addCell(Integer.toString(pravi.get(i).getDatumNabavke().getDay())+"." + Integer.toString(pravi.get(i).getDatumNabavke().getMonth())+".20"+Integer.toString(pravi.get(i).getDatumNabavke().getYear()-100)+".");
			        }
			        
			        document.add(table); 

			        document.close(); 
			          
			        if (Desktop.isDesktopSupported()) { 
			              try { 
			                  File myFile = new File(FILE); 
			                  Desktop.getDesktop().open(myFile); 
			              } catch (IOException ex) { 
			                  // no application registered for PDFs 
			              } 
			          } 
			      } catch (Exception ex) { 
			        ex.printStackTrace(); 
			      }
			}
		});
		btnUredu.setBounds(374, 209, 89, 23);
		contentPane.add(btnUredu);
		
		JButton btnIzai = new JButton("Iza\u0111i");
		btnIzai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnIzai.setBounds(473, 209, 89, 23);
		contentPane.add(btnIzai);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setToolTipText("Datum nabavke");
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datum nabavke", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 21, 301, 101);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Gornja granica: ");
		label.setBounds(27, 28, 97, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Donja granica: ");
		label_1.setBounds(27, 59, 97, 14);
		panel.add(label_1);
		
		dateChooser = new JDateChooser(new Date());
		dateChooser.setBounds(134, 22, 132, 20);
		panel.add(dateChooser);
		
		dateChooser_1 = new JDateChooser(new Date());
		dateChooser_1.setBounds(134, 59, 132, 20);
		panel.add(dateChooser_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Vrijednost nabavljenog sredstva", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 133, 301, 99);
		contentPane.add(panel_1);
		
		JLabel label_2 = new JLabel("Gornja granica: ");
		label_2.setBounds(44, 32, 97, 14);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("Donja granica: ");
		label_3.setBounds(44, 60, 97, 14);
		panel_1.add(label_3);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		spinner.setBounds(151, 29, 82, 20);
		panel_1.add(spinner);
		
		spinner_1 = new JSpinner();
		spinner_1.setBounds(151, 54, 82, 20);
		panel_1.add(spinner_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dodatno", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(321, 21, 241, 101);
		contentPane.add(panel_2);
		
		JLabel label_4 = new JLabel("Lokacija:");
		label_4.setBounds(36, 29, 68, 14);
		panel_2.add(label_4);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(114, 26, 117, 20);
		panel_2.add(textField);
		
		JLabel label_5 = new JLabel("Grupa:");
		label_5.setBounds(36, 60, 47, 14);
		panel_2.add(label_5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(114, 57, 117, 20);
		panel_2.add(comboBox);
	}
}
