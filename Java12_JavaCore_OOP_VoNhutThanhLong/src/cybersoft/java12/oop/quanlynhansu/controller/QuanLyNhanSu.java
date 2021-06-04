package cybersoft.java12.oop.quanlynhansu.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ForkJoinWorkerThread;

import cybersoft.java12.oop.quanlynhansu.model.CongTy;
import cybersoft.java12.oop.quanlynhansu.model.GiamDoc;
import cybersoft.java12.oop.quanlynhansu.model.NhanSu;
import cybersoft.java12.oop.quanlynhansu.model.NhanVien;
import cybersoft.java12.oop.quanlynhansu.model.TruongPhong;
import cybersoft.java12.oop.quanlynhansu.view.QuanLyNhanSuConsole;
import cybersoft.java12.oop.quanlynhansu.view.util.PrintFormat;

public class QuanLyNhanSu {
	/* properties */
	private List<NhanSu> dsNhanSu;

	/* constructors */
	public QuanLyNhanSu() {
		dsNhanSu = new ArrayList<NhanSu>();

		dsNhanSu.add(new NhanVien("Tuấn", "113", 20, 200));
		dsNhanSu.add(new NhanVien("Vương", "114", 20, 200));
		dsNhanSu.add(new NhanVien("Thiên", "115", 20, 200));
		dsNhanSu.add(new NhanVien("Nhất", "116", 22, 200));
		dsNhanSu.add(new NhanVien("Trịnh", "117", 22, 200));
		dsNhanSu.add(new NhanVien("Duy", "113", 20, 200));
		dsNhanSu.add(new NhanVien("Đồng", "113", 20, 200));
		dsNhanSu.add(new NhanVien("Nguyễn Thành Bảo", "113", 20, 200));
		dsNhanSu.add(new NhanVien("Triệu", "113", 20, 200));
		dsNhanSu.add(new NhanVien("Hâm", "113", 20, 200));
		dsNhanSu.add(new NhanVien("Hâm", "113", 20, 200));

		dsNhanSu.add(new TruongPhong("Hoàn", "113", 20, 300));
		dsNhanSu.add(new TruongPhong("Khoa", "113", 20, 300));

		dsNhanSu.add(new GiamDoc("Phúc", "225", 20, 500));
		dsNhanSu.add(new GiamDoc("Long", "225", 20, 500, (float) 0.5));
	}

	/* methods */
	public boolean them(NhanSu nhanSu) {
		if (nhanSu == null)
			return false;

		if (nhanSu.getMaSo() == 0)
			return false;

		for (NhanSu ns : dsNhanSu) {
			if (ns.getMaSo() == nhanSu.getMaSo())
				return false;
		}

		return dsNhanSu.add(nhanSu);
	}

	public void phanBoNhanVien(Scanner sc) {
		int luaChon = -1;
		List<NhanVien> dsNhanVienChuaPhanBo = new ArrayList<NhanVien>();
		List<TruongPhong> dsTruongPhong = new ArrayList<TruongPhong>();
		/*
		 * Trích xuất danh sách nhân viên chưa được phân bổ và danh sách trưởng phòng từ
		 * danh sách nhân sự from 15:35 -> 15:45
		 */
		for (NhanSu ns : dsNhanSu) {
			if (ns instanceof NhanVien) {
				if (((NhanVien) ns).getTruongPhong() == 0)
					dsNhanVienChuaPhanBo.add((NhanVien) ns);
			}

			if (ns instanceof TruongPhong)
				dsTruongPhong.add((TruongPhong) ns);
		}

		// cho người dùng phân bổ từng nhân viên
		for (NhanVien nv : dsNhanVienChuaPhanBo) {
			System.out.println("=====--PHÂN BỔ NHÂN VIÊN--=====");
			nv.xuatThongTin();
			drawLine(20);
			System.out.println("Chọn trưởng phòng để phân bổ: ");
			for (int i = 0; i < dsTruongPhong.size(); i++) {
				TruongPhong tp = dsTruongPhong.get(i);
				System.out.printf("%d. %20s %5d\n", i + 1, tp.getHoTen(), tp.getMaSo());
			}
			System.out.println("0. Không phân bổ.");
			System.out.println("-1. Thoát chức năng phân bổ.");

			luaChon = cybersoft.java12.oop.quanlynhansu.controller.inputUtil.inputInt("Lựa chọn:");

			if (luaChon == 0)
				continue;

			if (luaChon == -1)
				return;

			if (luaChon > 0 && luaChon <= dsTruongPhong.size()) {
				nv.setTruongPhong(dsTruongPhong.get(luaChon - 1).getMaSo());
				dsTruongPhong.get(luaChon - 1).tangSoNhanVien();
			} else {
				System.out.println("Lựa chọn không hợp lệ. Vui lòng tiến hành phân bổ lần sau.");
			}
		}

	}

	public float tinhTongLuong() {
		float tongLuong = 0;

		for (NhanSu nhanSu : dsNhanSu) {
			tongLuong += nhanSu.tinhLuong();
		}

		return tongLuong;
	}

	public void xuatDanhSachNhanSu() {
		int width = 160;
		// in header
		drawLine(width);
		System.out.printf(PrintFormat.HEADER_FORMAT, "STT", "Mã số", "Họ tên", "Số điện thoại", "Số ngày làm",
				"Lương một ngày", "Lương", "Chức vụ", "Trưởng phòng/Số nhân viên/Cổ phần");
		drawLine(width);
		// in body
		for (int i = 0; i < dsNhanSu.size(); i++) {
			NhanSu ns = dsNhanSu.get(i);
			System.out.printf(PrintFormat.BODY_FORMAT, i + 1, ns.getMaSo(), ns.getHoTen(), ns.getSoDienThoai(),
					ns.getSoNgayLam(), ns.getLuongMotNgay(), ns.tinhLuong(), ns.getChucVu(), ns.getThongTinThem());
		}
		// in bottom
		drawLine(width);
		System.out.printf(PrintFormat.BOTTOM_FORMAT, "Tổng lương", this.tinhTongLuong(), "");
		drawLine(width);
	}

	private void drawLine(int length) {
		for (int i = 0; i < length; i++)
			System.out.print("-");
		System.out.println();
	}

	public int findNhanSu(int maSo) {
		for (int i = 0; i < dsNhanSu.size(); i++) {
			if (dsNhanSu.get(i).getMaSo() == maSo) {
				return i;
			}
		}
		return -1;
	}

	public void themNhanSu(Scanner sc) {
		NhanSu newNhanSu;
		String loaiNhanSu = "";

		System.out.println("Bạn muốn thêm: ");
		System.out.println("1. Nhân viên.");
		System.out.println("2. Trưởng phòng.");
		System.out.println("3. Giám đốc.");
		System.out.print("Lựa chọn: ");

		loaiNhanSu = sc.nextLine();

		switch (loaiNhanSu) {
		case "1":
			newNhanSu = new NhanVien();
			break;
		case "2":
			newNhanSu = new TruongPhong();
			break;
		case "3":
			newNhanSu = new GiamDoc();
			break;
		default:
			System.out.println("Sai format");
			return;
		}

		newNhanSu.nhapThongTin(sc);

		if (them(newNhanSu))
			System.out.println("Đã thêm nhân sự thành công.");
		else
			System.out.println("Thêm nhân sự thất bại.");
	}

	public void xoaNhanSu(Scanner sc) {
		int maSo = cybersoft.java12.oop.quanlynhansu.controller.inputUtil.inputN("Nhập mã nhân sự muốn xóa:");
		if (findNhanSu(maSo) >= 0) {
			NhanSu reMoveNhanSu = dsNhanSu.get(findNhanSu(maSo));
			if (reMoveNhanSu instanceof NhanVien) {
				int maTruongPhong = Integer.parseInt(reMoveNhanSu.getThongTinThem());
				for (int i = 0; i < dsNhanSu.size(); i++) {
					if (dsNhanSu.get(i) instanceof TruongPhong) {
						if (maTruongPhong == dsNhanSu.get(i).getMaSo()) {
							dsNhanSu.get(i).removeThongTinThem();
						}

					}
				}
				dsNhanSu.remove(reMoveNhanSu);
			}
			if (reMoveNhanSu instanceof TruongPhong) {
				for (int i = 0; i < dsNhanSu.size(); i++) {
					if (dsNhanSu.get(i) instanceof NhanVien) {
						if (dsNhanSu.get(i).getThongTinThem().equals(reMoveNhanSu.getMaSo() + "")) {
							dsNhanSu.get(i).removeThongTinThem();
						}

					}
				}
				dsNhanSu.remove(reMoveNhanSu);
			}
			if (reMoveNhanSu instanceof GiamDoc) {
				dsNhanSu.remove(reMoveNhanSu);
			}
		} else {
			System.out.println("Mã số không tồn tại");
		}
	}

	public void xuatTongLuong() {
		System.out.println("Tổng lương: " + tinhTongLuong());
	}

	public void xuatNhanVienLuongCaoNhat() {
		ArrayList<NhanSu> list = new ArrayList<NhanSu>();
		float max = -1;
		for (NhanSu x : dsNhanSu) {
			if (x instanceof NhanVien) {
				if (x.tinhLuong() > max) {
					max = x.tinhLuong();
				}
			}
		}

		for (NhanSu x : dsNhanSu) {
			if (x instanceof NhanVien) {
				if (x.tinhLuong() == max) {
					list.add(x);
				}
			}
		}
		if (list.size() > 0) {
			System.out.println("Các nhân viên có tổng lương lớn nhất là:");
			System.out.printf("%20s |%20s |%20s", "Mã số", "Tên Nhân Viên", "Tổng lương");
			System.out.println();
			for (NhanSu x : list) {
				System.out.printf("%20d |%20s |%20f", x.getMaSo(), x.getHoTen(), x.tinhLuong());
				System.out.println();
			}
		} else {
			System.out.println("Không tồn tại nhân viên!!!");
		}

	}

	public void xuatTruongPhongNhieuNVNhat() {
		ArrayList<NhanSu> list = new ArrayList<NhanSu>();
		float max = -1;
		for (NhanSu x : dsNhanSu) {
			if (x instanceof TruongPhong) {
				if (Float.parseFloat(x.getThongTinThem()) > max) {
					max = Float.parseFloat(x.getThongTinThem());
				}
			}
		}

		for (NhanSu x : dsNhanSu) {
			if (x instanceof TruongPhong) {
				if (Float.parseFloat(x.getThongTinThem()) == max) {
					list.add(x);
				}
			}
		}
		if (list.size() > 0) {
			if (max > 0) {
				System.out.println("Các trưởng phòng có nhiều nhân viên nhất là:");
				System.out.printf("%20s |%20s |%20s", "Mã số", "Tên trưởng phòng", "Số lượng nhân viên");
				System.out.println();
				for (NhanSu x : list) {
					System.out.printf("%20d |%20s |%20s", x.getMaSo(), x.getHoTen(), x.getThongTinThem());
					System.out.println();
				}
			} else {
				System.out.println("Tất cả trưởng phòng đều có số lượng nhân viên = 0");
			}
		}

		else {
			System.out.println("Không tồn tại trưởng phòng!!!");
		}

	}

	public void xuatGiamDocCoCoPhanNhieuNhat() {
		ArrayList<NhanSu> list = new ArrayList<NhanSu>();
		float max = -1;
		for (NhanSu x : dsNhanSu) {
			if (x instanceof GiamDoc) {
				if (Float.parseFloat(x.getThongTinThem()) > max) {
					max = Float.parseFloat(x.getThongTinThem());
				}
			}
		}

		for (NhanSu x : dsNhanSu) {
			if (x instanceof GiamDoc) {
				if (Float.parseFloat(x.getThongTinThem()) == max) {
					list.add(x);
				}
			}
		}
		if (list.size() > 0) {
			if (max > 0) {
				System.out.println("Các giám đốc có số cổ phần nhiều nhất là:");
				System.out.printf("%20s |%20s |%20s", "Mã số", "Tên Giám Đốc", "Số cổ phần");
				System.out.println();
				for (NhanSu x : list) {
					System.out.printf("%20d |%20s |%20s", x.getMaSo(), x.getHoTen(), x.getThongTinThem());
					System.out.println();
				}
			} else {
				System.out.println("Các giám đốc có số cổ phần đều bằng = 0");
			}

		} else {
			System.out.println("Không tồn tại giám đốc!!!");
		}

	}

	public void xuatThuNhapCuaGiamDoc() {
		ArrayList<NhanSu> list = new ArrayList<NhanSu>();
		QuanLyNhanSuConsole quanLyNSCon = new QuanLyNhanSuConsole();
		for (NhanSu x : dsNhanSu) {
			if (x instanceof GiamDoc) {
				list.add(x);
			}
		}

		if (list.size() > 0) {
			System.out.println("Các giám đốc có số cổ phần nhiều nhất là:");
			System.out.printf("%20s |%20s |%20s", "Mã số", "Tên Giám Đốc", "Tổng thu nhập");
			System.out.println();
			for (NhanSu x : list) {
				float loinhuan = (float)cybersoft.java12.oop.quanlynhansu.model.CongTy.doanhThuThang-tinhTongLuong();
				System.out.printf("%20d |%20s |%20s", x.getMaSo(), x.getHoTen(),x.tinhLuong()+ Float.parseFloat(x.getThongTinThem())*loinhuan);
				System.out.println();
			}
		}

		else {
			System.out.println("Không tồn tại giám đốc!!!");
		}

	}
	public void sortOrderByAlphabet() {
		NhanSu ns1,ns2,ns3;
		for (int i = 0; i < dsNhanSu.size(); i++) {
			for (int j = i+1; j < dsNhanSu.size(); j++) {
				ns1 = dsNhanSu.get(i);
				ns2 = dsNhanSu.get(j);
				if (ns1.getHoTen().compareTo(ns2.getHoTen())>0) {
					ns3 = dsNhanSu.get(i);
					dsNhanSu.set(i,dsNhanSu.get(j));
					dsNhanSu.set(j,ns3);
				}
			}
		}
	}
	public void sortOrderBySalary() {
		NhanSu ns1,ns2,ns3;
		for (int i = 0; i < dsNhanSu.size(); i++) {
			for (int j = i+1; j < dsNhanSu.size(); j++) {
				ns1 = dsNhanSu.get(i);
				ns2 = dsNhanSu.get(j);
				if (ns1.tinhLuong()>ns2.tinhLuong()) {
					ns3 = dsNhanSu.get(i);
					dsNhanSu.set(i,dsNhanSu.get(j));
					dsNhanSu.set(j,ns3);
				}
			}
		}
	}
}
