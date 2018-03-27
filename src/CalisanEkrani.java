import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JSeparator;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class CalisanEkrani extends JDialog {
	private JTable calisanlarTablosu;
	DefaultTableModel model;
	CalisanIslemler islemler=new CalisanIslemler();
	private JTextField AramaCubugu;
	private JTextField adAlani;
	private JTextField soyadAlani;
	private JTextField departmanAlani;
	private JTextField maasAlani;
	//private JLabel mesajYazisi;

	//ÝMPORTANT !!!
	public void  CalisanlariGoruntule() {
		System.out.println("selam deneme sout u");
		model.setRowCount(0);
		ArrayList<Calisan> calisanlar=new ArrayList<Calisan>();
		calisanlar=islemler.CalisanlariGetir();
		if(calisanlar.size()!=0) {
			for(Calisan calisan:calisanlar) {
				Object[] eklenecek= {calisan.getId(),calisan.getAd(),calisan.getSoyad(),calisan.getDepartman(),calisan.getMaas()};
				model.addRow(eklenecek);
 			}
		}else {System.out.println("giremedi");}
	}
	
	public static void main(String[] args) {
		try {
			CalisanEkrani dialog = new CalisanEkrani();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public CalisanEkrani() {
		getContentPane().setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setBounds(100, 100, 808, 536);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(43, 104, 375, 291);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		calisanlarTablosu = new JTable();
		calisanlarTablosu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow=calisanlarTablosu.getSelectedRow();
				adAlani.setText((String) model.getValueAt(selectedRow, 1));
				
				soyadAlani.setText((String) model.getValueAt(selectedRow, 2));
				
				departmanAlani.setText(model.getValueAt(selectedRow, 3).toString());
				
				maasAlani.setText(model.getValueAt(selectedRow, 4).toString());
				
				
				
				
				
				
			}
			
		});
		
		calisanlarTablosu.setBounds(0, 0, 375, 291);
		panel.add(calisanlarTablosu);
		calisanlarTablosu.setForeground(Color.WHITE);
		calisanlarTablosu.setBackground(Color.DARK_GRAY);
		calisanlarTablosu.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "ad", "soyad", "depatman", "maas"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		calisanlarTablosu.getColumnModel().getColumn(0).setResizable(false);
		model=(DefaultTableModel)calisanlarTablosu.getModel();
		
		JLabel lblId = new JLabel("id");
		lblId.setBounds(53, 79, 46, 14);
		getContentPane().add(lblId);
		
		JLabel lblAd = new JLabel("ad");
		lblAd.setBounds(141, 79, 46, 14);
		getContentPane().add(lblAd);
		
		JLabel lblSoyad = new JLabel("soyad");
		lblSoyad.setBounds(225, 79, 46, 14);
		getContentPane().add(lblSoyad);
		
		JLabel lblDepartman = new JLabel("departman");
		lblDepartman.setBounds(297, 79, 63, 14);
		getContentPane().add(lblDepartman);
		
		JLabel lblMaas = new JLabel("maas");
		lblMaas.setBounds(393, 79, 46, 14);
		getContentPane().add(lblMaas);
		
		AramaCubugu = new JTextField();
		AramaCubugu.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				//bu method klavye ye her dokunusta dinamik olarak tetiklenen method.
				String ara=AramaCubugu.getText();
				dinamikAra(ara);
				
			}

			private void dinamikAra(String ara) {
				TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(model);
				calisanlarTablosu.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(ara));
				
			}
		});
		AramaCubugu.setBounds(53, 11, 372, 20);
		getContentPane().add(AramaCubugu);
		AramaCubugu.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(63, 42, 348, 11);
		getContentPane().add(separator);
		
		Button button = new Button("\u00C7al\u0131\u015Fan Ekle");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalisanEkle ekle=new CalisanEkle();
				ekle.setVisible(true);
				setVisible(false);
				
			}
		});
		button.setBounds(297, 430, 107, 31);
		getContentPane().add(button);
		
		adAlani = new JTextField();
		adAlani.setColumns(10);
		adAlani.setBounds(557, 122, 149, 20);
		getContentPane().add(adAlani);
		
		soyadAlani = new JTextField();
		soyadAlani.setColumns(10);
		soyadAlani.setBounds(557, 168, 149, 20);
		getContentPane().add(soyadAlani);
		
		departmanAlani = new JTextField();
		departmanAlani.setColumns(10);
		departmanAlani.setBounds(557, 214, 149, 20);
		getContentPane().add(departmanAlani);
		
		maasAlani = new JTextField();
		maasAlani.setColumns(10);
		maasAlani.setBounds(557, 260, 149, 20);
		getContentPane().add(maasAlani);
		

		JLabel mesajYazisi = new JLabel("");
		mesajYazisi.setForeground(Color.RED);
		mesajYazisi.setBounds(497, 381, 269, 14);
		getContentPane().add(mesajYazisi);
		
		JButton guncelle = new JButton("g\u00FCncelle");
		guncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow=calisanlarTablosu.getSelectedRow();
				String maas=maasAlani.getText();
				String soyad=soyadAlani.getText();
				String ad=adAlani.getText();
				String departman=departmanAlani.getText();
						
				if(selectedRow==-1) {
					if(model.getRowCount()==0) {
						
						mesajYazisi.setText("Tablo da eleman yok.");
					}else {
						mesajYazisi.setText("Tablodan secim yapmalýsýnýz");
						System.out.println("selam ben deneememme");
						
					}
				}else {
					int id=(int) model.getValueAt(selectedRow ,0);
					islemler.CalisanlariGuncelle(id,ad,soyad,departman,maas);
					CalisanlariGoruntule();
				}
				
				
			}
		});
		guncelle.setBounds(557, 312, 149, 46);
		getContentPane().add(guncelle);
		
		
		JButton btnNewButton = new JButton("Sil");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow=calisanlarTablosu.getSelectedRow();
				if(selectedRow==-1) {
					if(model.getRowCount()==0) {
						mesajYazisi.setText("Tabloda silinecek veri yok.");
					}else {
						mesajYazisi.setText("Tablodan silmek için bir veri saçmeniz gerekli.");
					}
				}else {
							int id=(int) model.getValueAt(selectedRow, 0);
							islemler.calisanSil(id);
							CalisanlariGoruntule();
							mesajYazisi.setText("Çalýþan Baþarýyla Silindi.");
					}
			
				
			}
		});
		btnNewButton.setBounds(53, 430, 116, 31);
		getContentPane().add(btnNewButton);
		
		JLabel lblAd_1 = new JLabel("Ad:");
		lblAd_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblAd_1.setBounds(469, 125, 46, 14);
		getContentPane().add(lblAd_1);
		
		JLabel lblSoyad_1 = new JLabel("Soyad:");
		lblSoyad_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblSoyad_1.setBounds(469, 171, 46, 14);
		getContentPane().add(lblSoyad_1);
		
		JLabel lblDepartman_1 = new JLabel("Departman:");
		lblDepartman_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblDepartman_1.setBounds(469, 217, 78, 14);
		getContentPane().add(lblDepartman_1);
		
		JLabel lblMaa = new JLabel("Maa\u015F:");
		lblMaa.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblMaa.setBounds(469, 263, 46, 14);
		getContentPane().add(lblMaa);
		
		JLabel lblAra = new JLabel("ARA ");
		lblAra.setForeground(Color.DARK_GRAY);
		lblAra.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAra.setBounds(10, 14, 40, 14);
		getContentPane().add(lblAra);
	}
}
