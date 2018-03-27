import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalisanEkle extends JFrame {

	private JPanel contentPane;
	private JTextField idEkle;
	private JTextField adEkle;
	private JTextField soyadEkle;
	private JTextField departmanEkle;
	private JTextField maasEkle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalisanEkle frame = new CalisanEkle();
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
	public CalisanEkle() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 424);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(222, 184, 135));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAd = new JLabel("Id:");
		lblAd.setFont(new Font("Yu Gothic Light", Font.BOLD | Font.ITALIC, 14));
		lblAd.setBounds(59, 51, 46, 14);
		contentPane.add(lblAd);
		
		JLabel label = new JLabel("Ad:");
		label.setFont(new Font("Yu Gothic Light", Font.BOLD | Font.ITALIC, 14));
		label.setBounds(59, 87, 46, 14);
		contentPane.add(label);
		
		JLabel lblSoyad = new JLabel("Soyad:");
		lblSoyad.setFont(new Font("Yu Gothic Light", Font.BOLD | Font.ITALIC, 14));
		lblSoyad.setBounds(59, 126, 46, 14);
		contentPane.add(lblSoyad);
		
		JLabel lblDepartman = new JLabel("Departman:");
		lblDepartman.setFont(new Font("Yu Gothic Light", Font.BOLD | Font.ITALIC, 14));
		lblDepartman.setBounds(59, 168, 90, 14);
		contentPane.add(lblDepartman);
		
		JLabel lblMaa = new JLabel("Maa\u015F");
		lblMaa.setFont(new Font("Yu Gothic Light", Font.BOLD | Font.ITALIC, 14));
		lblMaa.setBounds(59, 211, 46, 14);
		contentPane.add(lblMaa);
		
		idEkle = new JTextField();
		idEkle.setBounds(179, 49, 169, 20);
		contentPane.add(idEkle);
		idEkle.setColumns(10);
		
		adEkle = new JTextField();
		adEkle.setColumns(10);
		adEkle.setBounds(179, 85, 169, 20);
		contentPane.add(adEkle);
		
		soyadEkle = new JTextField();
		soyadEkle.setColumns(10);
		soyadEkle.setBounds(179, 124, 169, 20);
		contentPane.add(soyadEkle);
		
		departmanEkle = new JTextField();
		departmanEkle.setColumns(10);
		departmanEkle.setBounds(179, 166, 169, 20);
		contentPane.add(departmanEkle);
		
		maasEkle = new JTextField();
		maasEkle.setColumns(10);
		maasEkle.setBounds(179, 209, 169, 20);
		contentPane.add(maasEkle);
		
		JButton ekleButon = new JButton("EKLE");
		ekleButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalisanIslemler islemler=new CalisanIslemler();
				CalisanEkrani CalisanEkrani=new CalisanEkrani();
		   // 	String id=idEkle.getText();
				String ad=adEkle.getText();
				String soyad=soyadEkle.getText();
				String departman=departmanEkle.getText();
				String maas=maasEkle.getText();
				islemler.calisanEkle( ad, soyad, departman, maas);
				
			//	islemler.CalisanlariGetir();
				CalisanEkrani.CalisanlariGoruntule();
				CalisanEkrani.setVisible(true);
				
				
				
			}
		});
		ekleButon.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		ekleButon.setBounds(231, 258, 117, 39);
		contentPane.add(ekleButon);
	}
	
	
}
