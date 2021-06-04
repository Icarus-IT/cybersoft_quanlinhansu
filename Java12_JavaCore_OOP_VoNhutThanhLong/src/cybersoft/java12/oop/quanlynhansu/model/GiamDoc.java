package cybersoft.java12.oop.quanlynhansu.model;

import java.util.Scanner;

public class GiamDoc extends NhanSu{
	/* properties */
	private float coPhan;

	/* constructors */
	public GiamDoc(String hoTen, String soDienThoai, float soNgayLam, float luongMotNgay) {
		super(hoTen, soDienThoai, soNgayLam, luongMotNgay);
		// TODO Auto-generated constructor stub
		this.luongMotNgay=300;
	}
	public GiamDoc(String hoTen, String soDienThoai, float soNgayLam, float luongMotNgay,float coPhan) {
		super(hoTen, soDienThoai, soNgayLam, luongMotNgay);
		// TODO Auto-generated constructor stub
		this.coPhan=coPhan;
		this.luongMotNgay=300;
	}
	
	public GiamDoc() {
		super();
		this.luongMotNgay=300;
	}
	
	/* getters/setters */
	
	
	/* methods */
	@Override
	public String getChucVu() {
		// TODO Auto-generated method stub
		return "Giám đốc";
	}
	
	

	@Override
	public String getThongTinThem() {
		// TODO Auto-generated method stub
		return String.valueOf(this.coPhan);
	}
	@Override
	public void removeThongTinThem() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void nhapThongTin(Scanner sc) {
		// TODO Auto-generated method stub
		super.nhapThongTin(sc);
		do {
			this.coPhan =  cybersoft.java12.oop.quanlynhansu.controller.inputUtil.inputFloatPositive("Cổ phần:");
			if (this.coPhan>1) {
				System.out.println("Cổ phần chỉ từ 0->1");
			}
		} while (this.coPhan>1);
		
	}

}
