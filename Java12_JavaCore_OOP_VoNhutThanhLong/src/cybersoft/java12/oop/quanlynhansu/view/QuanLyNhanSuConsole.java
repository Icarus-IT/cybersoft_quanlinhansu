package cybersoft.java12.oop.quanlynhansu.view;

import java.lang.ref.PhantomReference;
import java.util.Scanner;

import cybersoft.java12.oop.quanlynhansu.controller.QuanLyNhanSu;
import cybersoft.java12.oop.quanlynhansu.model.CongTy;
import cybersoft.java12.oop.quanlynhansu.model.GiamDoc;
import cybersoft.java12.oop.quanlynhansu.model.NhanSu;
import cybersoft.java12.oop.quanlynhansu.model.NhanVien;
import cybersoft.java12.oop.quanlynhansu.model.TruongPhong;

public class QuanLyNhanSuConsole {
	/* properties */
	private QuanLyNhanSu quanLyNhanSu;
	private CongTy congTy;

	/* constructors */
	public QuanLyNhanSuConsole() {
		quanLyNhanSu = new QuanLyNhanSu();
		congTy = new CongTy();
	}

	/* main to run program */
	public void start() {
		// main program
		Scanner scanner = new Scanner(System.in);
		int choice = -1;

		do {
			congTy.xuatThongTin();
			quanLyNhanSu.xuatDanhSachNhanSu();
			// show menu
			showMenu();

			// get user's choice
			choice = cybersoft.java12.oop.quanlynhansu.controller.inputUtil.inputN("");
			// choice == 0 -> exit

			// process the function which has chosen
			processOption(choice, scanner);
			
		} while (choice != 0);// show menu again
	}

	/* methods */
	public void showMenu() {
		System.out.println("========--MENU--========");
		System.out.println("1. Nhập thông tin công ty.");
		System.out.println("2. Phân bổ nhân viên.");
		System.out.println("3. Thêm nhân sự.");
		System.out.println("4. Xóa nhân sự.");
		System.out.println("5. Xuất danh sách nhân sự.");
		System.out.println("6. Xuất tổng lương công ty.");
		System.out.println("7. Tìm nhân viên có lương cao nhất.");
		System.out.println("8. Tìm trưởng phòng có số lượng nhân viên cao nhất.");
		System.out.println("9. Sắp xếp danh sách nhân sự theo alphabet.");
		System.out.println("10. Sắp xếp danh sách nhân sự theo lương.");
		System.out.println("11. Tìm giám đốc có số lượng cổ phần nhiều nhất.");
		System.out.println("12. Tính và xuất tổng thu nhập của từng giám đốc.");
		System.out.println("0. Thoát.");
		System.out.print("Lựa chọn: ");
	}

	public void processOption(int choice, Scanner sc) {
	
		switch (choice) {
		case 1: // nhập thông tin công ty
			congTy.nhapThongTin(sc);
			break;
		case 2: // Phân bổ nhân viên
			 quanLyNhanSu.phanBoNhanVien(sc);
			break;
		case 3: // Thêm nhân sự
			quanLyNhanSu.themNhanSu(sc);
			break;
		case 4: // Xóa nhân sự
			quanLyNhanSu.xoaNhanSu(sc);
			break;
		case 5: // Xuất danh sách nhân sự
			quanLyNhanSu.xuatDanhSachNhanSu();
			break;
		case 6: // Xuất danh tổng lương công ty
			quanLyNhanSu.xuatTongLuong();
			break;
		case 7: // Tìm nhân viên có lương cao nhất
			quanLyNhanSu.xuatNhanVienLuongCaoNhat();
			break;
		case 8: // Tìm trưởng phòng có số lượng nhân viên cao nhất.
			quanLyNhanSu.xuatTruongPhongNhieuNVNhat();
			break;
		case 9: // Sắp xếp danh sách nhân sự theo alphabet
			quanLyNhanSu.sortOrderByAlphabet();
			break;
		case 10: //Sắp xếp danh sách nhân sự theo lương.
			quanLyNhanSu.sortOrderBySalary();
			break;
		case 11: //Tìm giám đốc có số lượng cổ phần nhiều nhất.
			quanLyNhanSu.xuatGiamDocCoCoPhanNhieuNhat();
			break;
		case 12: //Tính và xuất tổng thu nhập của từng giám đốc.
			quanLyNhanSu.xuatThuNhapCuaGiamDoc();
			break;
		case 0:
			System.out.println("The program has been ended.");
			break;
		default:
			System.out.println("Lựa chọn không hợp lệ.");
			break;
		}
	}

	
	
	// methods....
}
