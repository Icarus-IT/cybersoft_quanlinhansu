package cybersoft.java12.oop.quanlynhansu.model;

public class TruongPhong extends NhanSu {
	/* properties */
	private int soNhanVien;

	/* constructors */

	/* getters/setters */
	public int getSoNhanVien() {
		return this.soNhanVien;
	}

	public TruongPhong(String hoTen, String soDienThoai, float soNgayLam, float luongMotNgay) {
		super(hoTen, soDienThoai, soNgayLam, luongMotNgay);
		// TODO Auto-generated constructor stub
		this.luongMotNgay = 200;
	}

	public void setSoNhanVien(int soNhanVien) {
		this.soNhanVien = soNhanVien;
	}

	public TruongPhong() {
		super();
		this.luongMotNgay = 200;
	}

	/* methods */
	@Override
	public float tinhLuong() {
		return super.tinhLuong() + soNhanVien * 100;
	}

	@Override
	public String getChucVu() {
		// TODO Auto-generated method stub
		return "Trưởng phòng";
	}

	@Override
	public String getThongTinThem() {
		// TODO Auto-generated method stub
		return String.valueOf(this.soNhanVien);
	}

	@Override
	public void removeThongTinThem() {
		// TODO Auto-generated method stub
		soNhanVien--;
	}

	public void tangSoNhanVien() {
		this.soNhanVien++;

	}

}
