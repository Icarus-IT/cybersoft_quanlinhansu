package cybersoft.java12.oop.quanlynhansu.model;

import java.util.Scanner;

public class CongTy {
	/* properties */
	private String ten;
	private String maSoThue;
	public static double doanhThuThang;
	
	/* methods */
	public void nhapThongTin(Scanner sc) {
		System.out.println("====NHẬP THÔNG TIN CÔNG TY====");
		
		ten = cybersoft.java12.oop.quanlynhansu.controller.inputUtil.inputString("Tên công ty:");
		boolean check = false;
		do {
			maSoThue = cybersoft.java12.oop.quanlynhansu.controller.inputUtil.inputString("Mã số thuế:");
			if (maSoThue.length()==12) {
				check = true;
			} else {
				System.out.println("Nhập lại, mã số thuế có 12 chữ!!!!");
				check = false;
			}
		} while (check == false);
		
		doanhThuThang = cybersoft.java12.oop.quanlynhansu.controller.inputUtil.inputDoublePositive("Doanh thu tháng:");
	}
	
	public void xuatThongTin() {
		System.out.println("Tên công ty: " + this.ten);
		System.out.println("Mã số thuế: " + this.maSoThue);
		System.out.println("Doanh thu tháng: " + doanhThuThang);
	}

	public double getDoanhThuThang() {
		return doanhThuThang;
	}


}
