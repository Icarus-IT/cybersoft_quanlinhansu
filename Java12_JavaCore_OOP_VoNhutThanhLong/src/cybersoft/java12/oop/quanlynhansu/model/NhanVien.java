package cybersoft.java12.oop.quanlynhansu.model;

public class NhanVien extends NhanSu {
	/* properties */
	private int truongPhong;
	
	/* constructors */
	public NhanVien(String hoTen, String soDienThoai
			, float soNgayLam, float luongMotNgay) {
		super(hoTen, soDienThoai, soNgayLam, luongMotNgay);
		this.luongMotNgay=100;
	}
	
	public NhanVien() {
		super();
		this.luongMotNgay=100;
	}
	
	/* getters/setters */
	
	
	/* methods */
	
	@Override
	public String getChucVu() {
		return "Nhân viên";
	}

	@Override
	public String getThongTinThem() {
		// TODO Auto-generated method stub
		return String.valueOf(this.truongPhong);
	}
	@Override
	public void removeThongTinThem() {
		// TODO Auto-generated method stub
		this.truongPhong=0;
	}
	public int getTruongPhong() {
		return truongPhong;
	}

	public void setTruongPhong(int truongPhong) {
		this.truongPhong = truongPhong;
	}

	

}
