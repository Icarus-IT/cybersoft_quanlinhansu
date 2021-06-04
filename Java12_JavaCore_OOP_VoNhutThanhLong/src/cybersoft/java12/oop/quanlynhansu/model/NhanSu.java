package cybersoft.java12.oop.quanlynhansu.model;

import java.util.Scanner;

public abstract class NhanSu {
	/* properties */
	private int maSo;
	protected String hoTen;
	protected String soDienThoai;
	protected float soNgayLam;
	protected float luongMotNgay;
	
	private static int STT = 1;
	
	/* constructors */
	public NhanSu() {
		this.maSo = STT++;
	}
	
	public NhanSu(String hoTen, String soDienThoai, float soNgayLam, float luongMotNgay) {
		this.maSo = STT++;
		this.hoTen = hoTen;
		this.soDienThoai = soDienThoai;
		this.soNgayLam = soNgayLam;
		this.luongMotNgay = luongMotNgay;
	}

	/* getters/setters */
	public int getMaSo() {
		return this.maSo;
	}
	
	public String getHoTen() {
		return hoTen;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public float getSoNgayLam() {
		return soNgayLam;
	}

	public float getLuongMotNgay() {
		return luongMotNgay;
	}

	/* methods */
	public float tinhLuong() {
		return soNgayLam * luongMotNgay;
	}
	
	public void nhapThongTin(Scanner sc) {
		System.out.println("====NHẬP THÔNG TIN====");
		
	
		this.hoTen =  cybersoft.java12.oop.quanlynhansu.controller.inputUtil.inputString("Họ tên:");
		do {
			this.soDienThoai = cybersoft.java12.oop.quanlynhansu.controller.inputUtil.inputString("Số điện thoại:");	
			if (this.soDienThoai.length()!=10) {
				System.out.println("Số điện thoại phải có 10 số, Nhập lại !!!");
			}
		} while (this.soDienThoai.length()!=10);
		
		this.soNgayLam =  cybersoft.java12.oop.quanlynhansu.controller.inputUtil.inputFloatPositive("Số ngày làm:");

	}
	
	public void xuatThongTin() {
		System.out.println("====XUẤT THÔNG TIN===");
		System.out.printf("Mã số: %d\n", maSo);
		System.out.printf("Họ tên: %s\n", hoTen);
		System.out.printf("Chức vụ: %s\n", getChucVu());
		System.out.printf("Số điện thoại: %s\n", soDienThoai);
		System.out.printf("Số ngày làm: %.0f\n", soNgayLam);
		System.out.printf("Lương một ngày: %.0f\n", luongMotNgay);
	}
	
	public abstract String getChucVu();
	public abstract String getThongTinThem();
	public abstract void removeThongTinThem();
}
