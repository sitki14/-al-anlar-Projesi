import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class CalisanIslemler {
	private Connection con=null;
	private Statement statement=null; //sql sorgularýný çalýþtýrmamýza yarayan bir tane class
	private PreparedStatement preparedstatement=null;
	//ÝMPORTANT
	public boolean  girisYap(String kullaniciAdi, String parola) {
		String sorgu ="Select * from adminler where username = ? and password = ?";
		try {
			preparedstatement =con.prepareStatement(sorgu);
			preparedstatement.setString(1, kullaniciAdi);
			preparedstatement.setString(2, parola);
			ResultSet rs=preparedstatement.executeQuery();
			return rs.next();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		
		
		
	
		
	}
	
	public CalisanIslemler() {
		
		// //jbdc:mysql://localhost:3302/demo"
		String url="jdbc:mysql://" + Database.host + ":" + Database.port + "/"+Database.db_ismi+"?useUnicode=true&characterEncoding=utf8";
		
		//veritabanýna baglanmak için gerekli olan driver baslatýyoruz
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver bulundu...");
			
		}catch (ClassNotFoundException ex) {
			System.out.println("driver bulunamadý;");
		}
		try {
			 con = DriverManager.getConnection(url,Database.kullanici_adi,Database.parola);
			 System.out.println("baðlantý baþarýlý");
		} catch (SQLException e) {
			System.out.println("baglantý basarýsýz");
		}
	}
	public static void main(String[] args) {
		CalisanIslemler islemler=new CalisanIslemler();
		
	}

	
	 //ÝMPORTANT
	public ArrayList<Calisan> CalisanlariGetir() {
		ArrayList<Calisan> cikti=new ArrayList<Calisan>();
		try {
			statement=con.createStatement();
			String sorgu ="Select * from calisanlar ";
			ResultSet rs=statement.executeQuery(sorgu);
			while(rs.next()) {
				int id=rs.getInt("id");
				String ad=rs.getString("ad");
				String soyad=rs.getString("soyad");
				String dept=rs.getString("departman");
				String maas=rs.getString("maas");
				cikti.add(new Calisan(id, ad, soyad, dept, maas));
			}return cikti;
			} catch (SQLException e) {
			return null;
		}
		
		
		
	}
	
	public void calisanEkle(String ad, String soyad,String departman,String maas) {
		
		
	//	CalisanEkle ekle=new CalisanEkle();
		try {
	        String sorgu = "Insert Into calisanlar (ad,soyad,departman,maas) VALUES(?,?,?,?)";
			preparedstatement=con.prepareStatement(sorgu);
		//	preparedstatement.setString(1, "id");
			preparedstatement.setString(1, ad);
			preparedstatement.setString(2, soyad);
			preparedstatement.setString(3, departman);
			preparedstatement.setString(4, maas);
			preparedstatement.executeUpdate();
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
	        
		
	}
		public void calisanSil(int id) {
		try {
			String sorgu="Delete from calisanlar where id=?";
			preparedstatement=con.prepareStatement(sorgu);
			preparedstatement.setInt(1, id);
			preparedstatement.executeUpdate();	
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

	public void CalisanlariGuncelle(int id,String ad,String soyad,String departman,String maas) {
		
		try {
			CalisanEkrani ekran=new CalisanEkrani();
			String sorgu="Update calisanlar set ad=? , soyad=? ,departman=? , maas=? where id=?";
			preparedstatement=con.prepareStatement(sorgu);
			preparedstatement.setString(1, ad);
			preparedstatement.setString(2, soyad);
			preparedstatement.setString(3, departman);
			preparedstatement.setString(4, maas);
			preparedstatement.setInt(5, id);
			
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
	}
	
	
	


}
