import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DanhSachNhanSu implements NhapXuat {

	private ArrayList<NhanSu> listNhanSu;

	public ArrayList<NhanSu> getListNhanSu() {
		return listNhanSu;
	}

	public void setListNhanSu(ArrayList<NhanSu> listNhanSu) {
		this.listNhanSu = listNhanSu;
	}

	public DanhSachNhanSu() {
		this.listNhanSu = new ArrayList<NhanSu>();
	}

	@Override
	public void xuat() {
		for (NhanSu ns : this.listNhanSu) {
			ns.xuat();
		}
	}

	public void taoDuLieu() {
		try {
			FileReader reader = new FileReader("src/DSNV.txt");
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String[] listInfo = line.split(" # ");
				NhanSu ns;
				//Kiểm tra là trưởng phòng hay nhân viên thường
				if (listInfo[listInfo.length - 1].equalsIgnoreCase("true")) {
					ns = new TruongPhong();
				} else {
					ns = new NhanVienThuong();
				}
				//Tạo dữ liệu cho mỗi nhân sự
				ns.setMaNV(listInfo[0]);
				ns.setTenNV(listInfo[1]);
				ns.setNamSinh(listInfo[2]);
				ns.setEmail(listInfo[3]);
				ns.setSoDienThoai(listInfo[4]);
				//Thêm nhân sự vào list
				this.listNhanSu.add(ns);
			}
			reader.close();// Đóng tập tin
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
