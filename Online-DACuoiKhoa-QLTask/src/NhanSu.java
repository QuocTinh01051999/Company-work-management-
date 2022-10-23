import java.util.ArrayList;

/*
 * Mục đích: Tạo lớp Nhân sự để quản lý thông tin nhân sự cho các lớp khác kế thừa
 * */
public abstract class NhanSu implements NhapXuat {
	// 1. Attributes
	protected String maNV;
	protected String tenNV;
	protected String namSinh;
	protected String email;
	protected String soDienThoai;
	protected String maPhongBan;
	protected DanhSachTask objDSTask; // SỬA LẠI TÊN 
	protected float luong;
	protected float soNgayLamViec;

	// 2. get, set
	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public String getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(String namSinh) {
		this.namSinh = namSinh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getMaPhongBan() {
		return maPhongBan;
	}

	public void setMaPhongBan(String maPhongBan) {
		this.maPhongBan = maPhongBan;
	}
	//SỬA LẠI TÊN
	public DanhSachTask getObjTask() {
		return objDSTask;
	}
	//SỬA LẠI TÊN
	public void setObjTask(DanhSachTask dsTask) {
		this.objDSTask = dsTask;
	}

	public float getSoNgayLamViec() {
		return soNgayLamViec;
	}

	public void setSoNgayLamViec(float soNgayLamViec) {
		this.soNgayLamViec = soNgayLamViec;
	}

	// 3. constructor
	// Thiết lập giá trị mặc định
	private void init() {
		this.maPhongBan = "-1";
		//BỔ SUNG ĐỂ KHÔNG BỊ LỖI NULL KHI GỌI
		this.objDSTask = new DanhSachTask();
	}

	public NhanSu() {
		init();
	}

	public NhanSu(String maNV, String tenNV, String namSinh, String email, String soDienThoai) {
		init();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.namSinh = namSinh;
		this.email = email;
		this.soDienThoai = soDienThoai;

	}

	public NhanSu(String maNV, String tenNV, String namSinh, String email, String soDienThoai, String maPhongBan,
			float soNgayLamViec) {
		init();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.namSinh = namSinh;
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.maPhongBan = maPhongBan;
		this.soNgayLamViec = soNgayLamViec;
	}

	// 4. input, output
	public void xuat() {
		String temp = this.maPhongBan;
		if (this.maPhongBan.equalsIgnoreCase("-1")) {
			temp = " Chưa phân bổ";
		}
		System.out.println("Mã: " + this.maNV + "\tTên: " + this.tenNV + "\t Năm sinh: " + this.namSinh + " \tEmail: "
				+ this.email + "\t SĐT: " + this.soDienThoai + " \tMã phòng ban:" + temp + "\t Ngày làm: "
				+ this.soNgayLamViec + "\t Lương: " + this.luong);
		
		//BỔ SUNG ĐỂ XUẤT DS TASK CỦA NHÂN SỰ
		if (this.objDSTask.getDsTask().size() > 0) {
			System.out.println("Danh sách task của nhân sự này đang thực hiện: ");
			this.objDSTask.xuat();
		}

	}

	// 5. business methods
	public void xuatTenVaMa() {
		System.out.println("Mã: " + this.maNV + " \t Tên:" + this.tenNV);
	}

	public abstract void tinhLuong();

}
