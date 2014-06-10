package ba.unsa.etf.si.app.sistemZaEvidencijuStalnihSredstava;


import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;

import ba.unsa.etf.si.klase.StalnoSredstvo;
import ba.unsa.etf.si.util.HibernateUtil;

import com.toedter.calendar.JDateChooser;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

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

import com.itextpdf.text.Font;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class OtpisanaiProdanaSredstva extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private Session session;
	private JFileChooser chooser;
	private JDateChooser dateChooser;
	private JDateChooser dateChooser_1; 
	private JDateChooser dateChooser_2;
	private JDateChooser dateChooser_3;
	private JDateChooser dateChooser_4;
	private JDateChooser dateChooser_5;
	private JSpinner spinner;
	private JSpinner spinner_1;
	private JSpinner spinner_2;
	private JSpinner spinner_3;
	
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
					OtpisanaiProdanaSredstva frame = new OtpisanaiProdanaSredstva(sesija);
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
	public OtpisanaiProdanaSredstva(Session sesija) {
		setResizable(false);
		session = sesija;
		setTitle("Otpisana/prodana stalna sredstva");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 626, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnUredu = new JButton("Uredu");
		btnUredu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Random rand = new Random();
				int x = rand.nextInt(1000);
						
				final String FILE = getPath() + File.separator + "OtpisanaiProdanaSredstva_" + x +".pdf"; 
			    final Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD); 
			    final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
			    
			    try { 
			        Document document1 = new Document(); 
			        PdfWriter.getInstance(document1, new FileOutputStream(FILE)); 
			        document1.open();
			        Image To_be_Added = Image.getInstance("images.jpg");
			        To_be_Added.setAlignment(Image.RIGHT | Image.TEXTWRAP);
		            document1.add(To_be_Added);
		            
			        
			        //addMetaData(document);

			        document1.addTitle("Izvještaj o otpisanim i prodanim sredstvima"); 
			        	        
			        Paragraph preface = new Paragraph(); 
			        preface.add(new Paragraph(" ")); 
			        Paragraph nesto1=new Paragraph("Trgovina d.o.o");
			        nesto1.setAlignment(Element.ALIGN_LEFT);
			        nesto1.setFont(smallBold);
			        document1.add(nesto1);
			      
			       
			        Paragraph nesto2=new Paragraph("Sarajevo");
			        nesto2.setAlignment(Element.ALIGN_LEFT);
			        nesto2.setFont(smallBold);
			        document1.add(nesto2);
			       
			        Paragraph nesto3=new Paragraph("Tel/fax: 033/123-456");
			        nesto3.setAlignment(Element.ALIGN_LEFT);
			        nesto3.setFont(smallBold);
			        document1.add(nesto3);
			        

		            document1.add( Chunk.NEWLINE );
		            document1.add( Chunk.NEWLINE );
		            document1.add( Chunk.NEWLINE );
			       
			        Date d = new Date();
			        
			        preface.add(new Paragraph(" "));
			        String s = Integer.toString(d.getDay())+"." + Integer.toString(d.getMonth())+".20"+Integer.toString(d.getYear()-100) + ".";
			        preface.add(new Paragraph("Datum: " + s, smallBold));
			        preface.add(new Paragraph(" "));
			        preface.add(new Paragraph(" "));
			        document1.add(preface);
			        Paragraph nesto=new Paragraph("Izvještaj o otpisanim i prodanim sredstvima");
			        nesto.setAlignment(Element.ALIGN_CENTER);
			        document1.add(nesto);
			        preface = new Paragraph();
			        Query query = session.createQuery("from StalnoSredstvo");
					List<StalnoSredstvo> result = (List<StalnoSredstvo>)query.list();
					List<StalnoSredstvo> pravi = new ArrayList<StalnoSredstvo> ();
					for(StalnoSredstvo k : result)
					{
						boolean okZaIspisati = false;//a ovdje ovaj dateChosser je gornja granica i logicno je da ide before trebalo bi mozda obrnuto ne kontam koji je veci od ovih choosera? dateChooser je gornji a ovaj _1 je donja xDgr alniocalloaodkaopfgjapogjaposgjpaogj aaaaaaaaaaaaaaaa
						if(k.isOtpisano() || k.isProdano()) okZaIspisati=true;
							if(k.getDatumNabavke().after(dateChooser.getDate()) || k.getDatumNabavke().before(dateChooser_1.getDate()))
								if(!dateChooser.getDate().equals(dateChooser_1.getDate()))
								{
									if(!(dateChooser.getDate().equals(dateChooser_1.getDate())))
										
									okZaIspisati = false;
									
								}
							if(k.getDatumStavljanjaUUpotrebu().after(dateChooser_3.getDate()) || k.getDatumStavljanjaUUpotrebu().before(dateChooser_2.getDate()))
								if(!dateChooser_3.getDate().equals(dateChooser_2.getDate()))
								{
									okZaIspisati = false;
									
								}
							if(k.getDatumOtpisivanja().after(dateChooser_4.getDate()) || k.getDatumOtpisivanja().before(dateChooser_5.getDate()))
								if(!dateChooser_4.getDate().equals(dateChooser_5.getDate()))
								{
									okZaIspisati = false;
								
								}
							if(k.getNabavnaVrijednost() < (Integer)spinner.getValue() || k.getNabavnaVrijednost() > (Integer)spinner_1.getValue())
								if(spinner.getValue().equals(spinner_1.getValue()))
								{
									okZaIspisati = false;
								
								}	
							if(k.getStopaAmortizacije() < (Integer)spinner_2.getValue() || k.getStopaAmortizacije() > (Integer)spinner_3.getValue())
								if(spinner_2.getValue().equals(spinner_3.getValue()))
								{
									okZaIspisati = false;
									
								}
							if(!k.getLokacija().equals(textField.getText()))
								if(!textField.getText().equals(""))
								{
									okZaIspisati = false;
									
								}
						if(okZaIspisati)
							pravi.add(k);
					}
					
					 preface.add(new Paragraph(" "));
				     preface.add(new Paragraph(" "));
					preface.add(new Paragraph("Broj otpisanih i prodanih sredstava:  " + Integer.toString(pravi.size()), smallBold));
					preface.add(new Paragraph(" "));
					preface.add(new Paragraph(" "));
			        document1.add(preface); 
			        
			        PdfPTable table = new PdfPTable(5); 
			      
			        
			      
			        PdfPCell c1 = new PdfPCell(new Phrase("Naziv")); 
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
			        
			        c1 = new PdfPCell(new Phrase("Datum stavljanja u upotrebu")); 
			        c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
			        table.addCell(c1);
			        
			        c1 = new PdfPCell(new Phrase("Datum otpisivanja")); 
			        c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
			        table.addCell(c1);
			        
			        table.setHeaderRows(1); 
			        for(int i=0; i<pravi.size(); i++)
			        {
			        	
			        	table.addCell(pravi.get(i).getNaziv());
			        	table.addCell(pravi.get(i).getTip().toString());
			        	table.addCell(Double.toString(pravi.get(i).getNabavnaVrijednost())+" KM");      
			        	table.addCell(Integer.toString(pravi.get(i).getDatumNabavke().getDay())+"." + Integer.toString(pravi.get(i).getDatumNabavke().getMonth())+".20"+Integer.toString(pravi.get(i).getDatumNabavke().getYear()-100)+".");
			        	table.addCell(Integer.toString(pravi.get(i).getDatumStavljanjaUUpotrebu().getDay())+"." + Integer.toString(pravi.get(i).getDatumStavljanjaUUpotrebu().getMonth())+".20"+Integer.toString(pravi.get(i).getDatumStavljanjaUUpotrebu().getYear()-100)+".");
			        	Date datum = null;
						if(pravi.get(i).isOtpisano()){
			        		datum = pravi.get(i).getDatumOtpisivanja();
			        		}
			        		else if(pravi.get(i).isProdano()){
			        		datum = pravi.get(i).getDatumProdaje();
			        		}
			        	
			        		int dan = datum.getDay();
			        		int mjesec = datum.getMonth()+1;
			        		int godina = datum.getYear()+1900;
			        		table.addCell(Integer.toString(dan)
			        			+"." + Integer.toString(mjesec)
			        			+"."+Integer.toString(godina)
			        			+".");
			        }
			        
			        
			        
			        document1.add(table); 

			        document1.close(); 
			          
			        if (Desktop.isDesktopSupported()) { 
			              try { 
			                  File myFile = new File(FILE); 
			                  Desktop.getDesktop().open(myFile); 
			              } catch (IOException ex) { 
			                  // no application registered for PDFs 
			              } 
			          } 
					}catch (Exception ex) { 
			        ex.printStackTrace(); 
			      }
			}
			});
		btnUredu.setBounds(394, 386, 89, 23);
		contentPane.add(btnUredu);
		
		
		
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setToolTipText("Datum nabavke");
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datum nabavke", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 22, 297, 101);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Gornja granica: ");
		label.setBounds(27, 34, 97, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Donja granica: ");
		label_1.setBounds(27, 65, 97, 14);
		panel.add(label_1);
		Date dajeIsti=new Date();
		dateChooser = new JDateChooser(dajeIsti);
		dateChooser.setBounds(134, 28, 136, 20);
		panel.add(dateChooser);
		
		dateChooser_1 = new JDateChooser(dajeIsti);
		dateChooser_1.setBounds(134, 59, 136, 20);
		panel.add(dateChooser_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Vrijednost sredstva na datum nabavke", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(336, 22, 246, 101);
		contentPane.add(panel_1);
		
		spinner = new JSpinner();
		spinner.setBounds(148, 31, 76, 20);
		panel_1.add(spinner);
		
		spinner_1 = new JSpinner();
		spinner_1.setBounds(148, 56, 76, 20);
		panel_1.add(spinner_1);
		
		JLabel label_2 = new JLabel("Gornja granica: ");
		label_2.setBounds(41, 31, 97, 14);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("Donja granica: ");
		label_3.setBounds(41, 59, 97, 14);
		panel_1.add(label_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datum stavljanja sredstva u upotrebu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 140, 297, 101);
		contentPane.add(panel_2);
		
		JLabel label_4 = new JLabel("Gornja granica: ");
		label_4.setBounds(20, 33, 97, 14);
		panel_2.add(label_4);
		
		JLabel label_5 = new JLabel("Donja granica: ");
		label_5.setBounds(20, 64, 97, 14);
		panel_2.add(label_5);
		
		dateChooser_2 = new JDateChooser(dajeIsti);
		dateChooser_2.setBounds(127, 58, 143, 20);
		panel_2.add(dateChooser_2);
		
		 dateChooser_3 = new JDateChooser(dajeIsti);
		dateChooser_3.setBounds(127, 27, 143, 20);
		panel_2.add(dateChooser_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Stopa amortizacije sredstva", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(336, 140, 246, 101);
		contentPane.add(panel_3);
		
		JLabel label_6 = new JLabel("Gornja granica: ");
		label_6.setBounds(31, 32, 97, 14);
		panel_3.add(label_6);
		
		JLabel label_7 = new JLabel("Donja granica: ");
		label_7.setBounds(31, 60, 97, 14);
		panel_3.add(label_7);
		
		spinner_2 = new JSpinner();
		spinner_2.setBounds(138, 32, 86, 20);
		panel_3.add(spinner_2);
		
		spinner_3 = new JSpinner();
		spinner_3.setBounds(138, 57, 86, 20);
		panel_3.add(spinner_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datum otpisivanja sredstva", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(10, 259, 297, 95);
		contentPane.add(panel_4);
		
		JLabel label_8 = new JLabel("Gornja granica: ");
		label_8.setBounds(20, 33, 97, 14);
		panel_4.add(label_8);
		
		JLabel label_9 = new JLabel("Donja granica: ");
		label_9.setBounds(20, 64, 97, 14);
		panel_4.add(label_9);
		
		dateChooser_4 = new JDateChooser(dajeIsti);
		dateChooser_4.setBounds(127, 27, 143, 20);
		panel_4.add(dateChooser_4);
		
		dateChooser_5 = new JDateChooser(dajeIsti);
		dateChooser_5.setBounds(127, 58, 143, 20);
		panel_4.add(dateChooser_5);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dodatno", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(336, 259, 241, 95);
		contentPane.add(panel_5);
		
		JLabel label_10 = new JLabel("Lokacija:");
		label_10.setBounds(25, 28, 68, 14);
		panel_5.add(label_10);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(113, 22, 101, 20);
		panel_5.add(textField);
		
		JLabel label_12 = new JLabel("Grupa:");
		label_12.setBounds(35, 56, 47, 14);
		panel_5.add(label_12);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(113, 53, 101, 20);
		panel_5.add(comboBox);
		
		JButton btnIzai = new JButton("Izađi");
		btnIzai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnIzai.setBounds(493, 386, 89, 23);
		contentPane.add(btnIzai);
		
		
	
	}
}