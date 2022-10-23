import java.util.ArrayList;

/*
 * 
 * */
public class PhongBan implements NhapXuat {

	// 1. Attributes
	private String maPhongBan;
	private String tenPhongBan;
	private TruongPhong truongPhong;
	private ArrayList<NhanVienThuong> dsNhanVien;

	// 2. Get, set
	public String getMaPhongBan() {
		return maPhongBan;
	}

	public void setMaPhongBan(String maPhongBan) {
		this.maPhongBan = maPhongBan;
	}

	public String getTenPhongBan() {
		return tenPhongBan;
	}

	public void setTenPhongBan(String tenPhongBan) {
		this.tenPhongBan = tenPhongBan;
	}

	public TruongPhong getTruongPhong() {
		return truongPhong;
	}

	public void setTruongPhong(TruongPhong truongPhong) {
		this.truongPhong = truongPhong;
	}

	public ArrayList<NhanVienThuong> getDsNhanVien() {
		return dsNhanVien;
	}

	public void setDsNhanVien(ArrayList<NhanVienThuong> dsNhanVien) {
		this.dsNhanVien = dsNhanVien;
	}

	// 3. Constructor
	public PhongBan() {
		this.truongPhong = null;
		this.dsNhanVien = new ArrayList<NhanVienThuong>();
	}
	
	
	public PhongBan(String maPhongBan, String tenPhongBan) {
		this.maPhongBan = maPhongBan;
		this.tenPhongBan = tenPhongBan;
		this.dsNhanVien = new ArrayList<NhanVienThuong>();
	}

	// 4. Input, out
	// 5. business

	@Override
	public void xuat() {
		System.out.println("***** Đây là thông tin phòng ban ****");
		System.out.println("Tên: " + this.tenPhongBan + " Mã: " + this.maPhongBan);
		
		if (this.truongPhong != null) {
			System.out.println("Đây là thông tin Trưởng phòng:");
			this.truongPhong.xuat();
		}else {
			System.out.println(" Phòng ban này chưa có Trưởng phòng");
		}
		for(NhanVienThuong nvt: this.dsNhanVien) {
			nvt.xuat();
		}
		System.out.println("========= End thông tin phòng ban =========");

	}

}
