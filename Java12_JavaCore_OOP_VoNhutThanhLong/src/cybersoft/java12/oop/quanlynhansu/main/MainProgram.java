package cybersoft.java12.oop.quanlynhansu.main;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import cybersoft.java12.oop.quanlynhansu.model.GiamDoc;
import cybersoft.java12.oop.quanlynhansu.model.NhanSu;
import cybersoft.java12.oop.quanlynhansu.model.NhanVien;
import cybersoft.java12.oop.quanlynhansu.model.TruongPhong;
import cybersoft.java12.oop.quanlynhansu.view.QuanLyNhanSuConsole;

public class MainProgram {
	public static void main(String[] args) {
		QuanLyNhanSuConsole quanLyNhanSuConsole = new QuanLyNhanSuConsole();
		
		quanLyNhanSuConsole.start();
	}
	
//	NhanSu nhanSu = new NhanSu();
//	NhanSu nhanVien = new NhanVien();
//	NhanSu truongPhong = new TruongPhong();
//	NhanSu giamDoc = new GiamDoc();
//	Scanner scanner = new Scanner(System.in);
//	
//	List<NhanVien> dsNhanVien;
//	List<TruongPhong> dsTruongPhong;
//	List<GiamDoc> dsGiamDoc;
//	
//	List<NhanSu> dsNhanSu = new LinkedList<NhanSu>();
//	
//	dsNhanSu.add(nhanVien);
//	dsNhanSu.add(truongPhong);
//	dsNhanSu.add(giamDoc);
//	
//	/* instance instanceof Object */
//	
//	System.out.println(nhanVien instanceof TruongPhong);
//	System.out.println(nhanVien instanceof NhanSu);
//	System.out.println(nhanSu instanceof NhanVien);
//	
//	for (NhanSu ns : dsNhanSu) {
//		if(ns instanceof TruongPhong) {
//			TruongPhong tp = (TruongPhong)ns;
//			tp.getSoNhanVien();
//		}
//	}
//	
//	nhanVien.tinhLuong();
//	truongPhong.tinhLuong();
//	giamDoc.tinhLuong();
//	
//	truongPhong.nhapThongTin(scanner);
//	truongPhong.xuatThongTin();
//	
//	System.out.println("Program has been ended.");
}
