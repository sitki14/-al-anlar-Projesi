import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class GirisEkrani extends JFrame {
	//burada veritabaný iþlemleri için CalisanÝslemler sýnýfýnýn nesnesini olustururuz.
	
	CalisanIslemler islemler=new CalisanIslemler();
	
	
	

	private JPanel contentPane;
	private JTextField kullaniciAdiAlani;
	private JPasswordField parolaAlani;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GirisEkrani frame = new GirisEkrani();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GirisEkrani() {
		setBackground(new Color(255, 204, 204));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 397);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 102, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKullancAd = new JLabel("Kullan\u0131c\u0131 Ad\u0131:");
		lblKullancAd.setForeground(new Color(255, 255, 51));
		lblKullancAd.setFont(new Font("Tw Cen MT", Font.BOLD, 14));
		lblKullancAd.setBounds(60, 74, 110, 14);
		contentPane.add(lblKullancAd);
		
		JLabel lblParola = new JLabel("Parola:");
		lblParola.setForeground(new Color(255, 255, 51));
		lblParola.setFont(new Font("Tw Cen MT", Font.BOLD, 14));
		lblParola.setBounds(60, 129, 110, 14);
		contentPane.add(lblParola);
		
		kullaniciAdiAlani = new JTextField();
		kullaniciAdiAlani.setBounds(180, 71, 248, 20);
		contentPane.add(kullaniciAdiAlani);
		kullaniciAdiAlani.setColumns(10);
		
		JLabel mesajYazisi = new JLabel("");
		mesajYazisi.setBackground(new Color(240, 240, 240));
		mesajYazisi.setForeground(new Color(255, 51, 0));
		mesajYazisi.setBounds(92, 167, 301, 26);
		contentPane.add(mesajYazisi);
		
		parolaAlani = new JPasswordField();
		parolaAlani.setBounds(180, 126, 248, 20);
		contentPane.add(parolaAlani);
		
		JButton giris = new JButton("Giri\u015F Yap");
		giris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mesajYazisi.setText("");
				String kullaniciAdi=kullaniciAdiAlani.getText();
				String parola=new String(parolaAlani.getPassword());
				
				//simdi veritabanýndaki adminlerin adý ve parolasý ýle karsýlastýrýlacak 
				
				boolean girisBasarili =islemler.girisYap(kullaniciAdi,parola);
				if(girisBasarili==true) {
					CalisanIslemler islemler=new CalisanIslemler();
					CalisanEkrani calisanEkrani=new CalisanEkrani();
					calisanEkrani.CalisanlariGoruntule(); 
					setVisible(false);
					calisanEkrani.setVisible(true);
					//eger giris basarýlýysa baska bir frame e egecmek lazým 
				}else {
					mesajYazisi.setText("Giriþ Baþarýsýz");
					
				}
				
				
				
			}
		});
		giris.setBounds(318, 204, 110, 47);
		contentPane.add(giris);
		
		
		
		
	}
}
