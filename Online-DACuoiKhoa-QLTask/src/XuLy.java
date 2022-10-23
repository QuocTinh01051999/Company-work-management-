import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class XuLy {

	public static void main(String[] args) {
		CongTy  cty = new CongTy();
		cty.taoDuLieu();
		//cty.phanBoNhanVien();
		//cty.chiDinhTruongPhong();
		//cty.xuatDSNS();
		//cty.xuatDSPhongBan();
		Scanner scan = new Scanner(System.in);
		
		cty.phanTask(scan);
		cty.xuatDSNS();
	}
	
	

}
