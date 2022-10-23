import java.util.ArrayList;
import java.util.Scanner;

public class CongTy implements NhapXuat {
//1. attributes
	private String tenCongTy;
	private String maSoThue;
	private float tongLuong;
	private DanhSachNhanSu objDSNhanSu;
	private DanhSachPhongBan objDSPhongBan;
	private DanhSachTask objDSTask;
	private ArrayList<TruongPhong> dsTruongPhong;

	// 2. get, set

	public String getTenCongTy() {
		return tenCongTy;
	}

	public void setTenCongTy(String tenCongTy) {
		this.tenCongTy = tenCongTy;
	}

	public DanhSachNhanSu getObjDSNhanSu() {
		return objDSNhanSu;
	}

	public void setObjDSNhanSu(DanhSachNhanSu objDSNhanSu) {
		this.objDSNhanSu = objDSNhanSu;
	}

	public DanhSachPhongBan getObjDSPhongBan() {
		return objDSPhongBan;
	}

	public void setObjDSPhongBan(DanhSachPhongBan objDSPhongBan) {
		this.objDSPhongBan = objDSPhongBan;
	}

	public String getMaSoThue() {
		return maSoThue;
	}

	public void setMaSoThue(String maSoThue) {
		this.maSoThue = maSoThue;
	}

	public DanhSachTask getObjDSTask() {
		return objDSTask;
	}

	public void setObjDSTask(DanhSachTask objDSTask) {
		this.objDSTask = objDSTask;
	}

	// 3. constructor
	public CongTy() {
		dsTruongPhong = new ArrayList<TruongPhong>();
	}

	// 4. input, out
	// 5. business
	@Override
	public void xuat() {

	}

	public void xuatDSNS() {
		this.objDSNhanSu.xuat();
	}

	public void xuatDSTask() {
		this.objDSTask.xuat();
	}

	public void xuatDSPhongBan() {
		this.objDSPhongBan.xuat();
	}

	public void taoDuLieu() {
		this.objDSNhanSu = new DanhSachNhanSu();
		this.objDSNhanSu.taoDuLieu();

		this.objDSPhongBan = new DanhSachPhongBan();
		this.objDSPhongBan.taoDuLieu();

		this.objDSTask = new DanhSachTask();
		this.objDSTask.taoDuLieu();

		this.layDSTruongPhong();
	}

	public void phanBoNhanVien() {
		// Duỵet danh sách nhân viên
		// Hỏi muốn phân bổ hay không,
		// 1: Phân bổ -> Liệt kê danh sách phòng ban
		// Chọn hập vào mã phòng ban
		// 2: Đi tiếp không phân bổ
		Scanner scan = new Scanner(System.in);
		for (NhanSu ns : this.objDSNhanSu.getListNhanSu()) {
			if (ns instanceof NhanVienThuong) {
				boolean flag = true;
				do {
					System.out.println("Đang phân bổ cho nhân viên: ");
					ns.xuatTenVaMa();
					System.out.println("Chọn 1 để phân bổ. Chọn 2 để đi tiếp");
					int chon = Integer.parseInt(scan.nextLine());
					switch (chon) {
					case 1:
						System.out.println("Đây là danh sách phòng ban");
						xuatDSPhongBan();
						System.out.println("Mời chọn >>");
						String maPhong = scan.nextLine();
						// Lấy phòng ban tương ứng với mã người dùng nhập
						PhongBan pb = layPhongBan(maPhong);
						if (pb != null) {
							// Gán mã phòng ban cho nhân sự này
							ns.setMaPhongBan(maPhong);
							// Thêm ns này vào danh sách nhân sự của phòng ban
							pb.getDsNhanVien().add((NhanVienThuong) ns);
						}
						flag = false;
						break;
					case 2:
						flag = false;
						break;
					default:
						System.out.println("Chỉ được nhập 1 hoặc 2");
					}
				} while (flag);
			}
		}
	}

	private PhongBan layPhongBan(String maPhong) {
		for (PhongBan pb : this.objDSPhongBan.getListPhongBan()) {
			if (pb.getMaPhongBan().equalsIgnoreCase(maPhong)) {
				return pb;
			}
		}
		return null;

	}

	public void layDSTruongPhong() {
		for (NhanSu ns : this.objDSNhanSu.getListNhanSu()) {
			if (ns instanceof TruongPhong) {
				this.dsTruongPhong.add((TruongPhong) ns);
			}
		}
	}

	public void chiDinhTruongPhong() {
		// Duỵet danh sách Truong Phòng
		// Hỏi muốn phân bổ hay không,
		// 1: Phân bổ -> Liệt kê danh sách phòng ban
		// Chọn nhập vào mã phòng ban
		// 2: Đi tiếp không phân bổ
		Scanner scan = new Scanner(System.in);
		for (TruongPhong tp : this.dsTruongPhong) {
			boolean flag = true;
			do {
				System.out.println("Đang chỉ định cho Trưởng phòng: ");
				tp.xuatTenVaMa();
				System.out.println("Chọn 1 để chỉ định. Chọn 2 để đi tiếp");
				int chon = Integer.parseInt(scan.nextLine());
				switch (chon) {
				case 1:
					System.out.println("Đây là danh sách phòng ban");
					xuatDSPhongBan();
					System.out.println("Mời chọn >>");
					String maPhong = scan.nextLine();
					// Lấy phòng ban tương ứng với mã người dùng nhập
					PhongBan pb = layPhongBan(maPhong);
					if (pb != null) {
						// Gán mã phòng ban cho nhân sự này
						tp.setMaPhongBan(maPhong);
						// Chỉ định Trường phòng về phòng ban
						pb.setTruongPhong(tp);
					}
					flag = false;
					break;
				case 2:
					flag = false;
					break;
				default:
					System.out.println("Chỉ được nhập 1 hoặc 2");
				}
			} while (flag);

		}
	}

	//Bước 1: Duyệt danh sách task
	//Bước 2: Cho phép người dùng nhập vào nhân sự theo mã, nhập cho đến khi nào có đúng 1 nhân sự
	// Bước 3: Phân task hoặc cho chọn lại hoặc bỏ qua task
	public void phanTask(Scanner scan) {
		for (Task task : objDSTask.getDsTask()) {
			System.out.println("Task đang phân bổ:");
			task.xuat();
			NhanSu ns = timNhanSuTheoMa(scan);
			boolean flag = true;
			do {
				System.out.println("Chọn 1: Phân Task cho nhân sự này. 2: Chọn lại nhân sự khác. 3: Bỏ qua không phân Task này");
				int chon = Integer.parseInt(scan.nextLine());
				switch (chon) {
				case 1:
					task.setMaNV(ns.getMaNV());// Gán mã nhân viên thực hiện task
					ns.getObjTask().getDsTask().add(task);// Thêm task vào danh sách task của nhân sự 
					System.out.println("Phân task thành công!");
					flag = false;
					break;
				case 2:
					ns = timNhanSuTheoMa(scan);
					break;
				case 3:
					flag = false;
					break;
				default:
					System.out.println("Vui lòng chọn 1 - 3 mà thôi!");
				}
			} while (flag);
		}
	}

	public NhanSu timNhanSuTheoMa(Scanner scan) {
		NhanSu ns = null;
		do {
			System.out.println("Nhập vào mã nhân sự để chỉ định task:");
			String ma = scan.nextLine();
			for (NhanSu nSu : this.objDSNhanSu.getListNhanSu()) {
				if (nSu.getMaNV().equalsIgnoreCase(ma)) {
					ns = nSu;
					System.out.println("Nhân sự bạn đang chọn là: ");
					ns.xuatTenVaMa();
					break;
				}
			}
		} while (ns == null);
		return ns;
	}
	
	//Xóa 1 nhân sự
	//Xét là Nhân Viên Thường -> Xóa liên kết task (reset các mã nhân viên của task đang quản lý bởi NS này là -1)
	//Xét là Trưởng phòng : Xóa trường phòng quản lý trong Phòng ban, reset null 
}
