/*
 * Mục đích: Quản lý các nghiệp vụ liên quan đến Task cho Nhân viên
 * Người tạo: 
 * Ngày tạo: 
 * */
public class Task implements NhapXuat { 
	//1. Attributes
	private String maTask; 
	private String tenTask;
	private float gioThucHien;
	private String maNV;
	//2. Get, set
	public String getMaTask() {
		return maTask;
	}
	public void setMaTask(String maTask) {
		this.maTask = maTask;
	}
	public String getTenTask() {
		return tenTask;
	}
	public void setTenTask(String tenTask) {
		this.tenTask = tenTask;
	}
	public float getGioThucHien() {
		return gioThucHien;
	}
	public void setGioThucHien(float gioThucHien) {
		this.gioThucHien = gioThucHien;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	
	//3. Constructors
	public Task() {
		this.maNV = "-1";
	}
	
	public Task(String maTask, String tenTask, float gioThucHien, String maNV) {
		this.maTask = maTask;
		this.tenTask = tenTask;
		this.gioThucHien = gioThucHien;
		this.maNV = maNV;
	}
	
	public Task(String maTask, String tenTask, float gioThucHien) {
		this.maTask = maTask;
		this.tenTask = tenTask;
		this.gioThucHien = gioThucHien;
	}
	
	
	//4. Input , output
	public void xuat() {
		System.out.println("Task - Mã: " + this.maTask + "\t Tên Task: " + this.tenTask + "\tGiờ thực hiện: " + this.gioThucHien);
	}
	
	
	//5 . Business methods
}
