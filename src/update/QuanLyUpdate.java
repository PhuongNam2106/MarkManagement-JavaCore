package update;

import java.util.Scanner;

public class QuanLyUpdate {
	static Scanner sc= new Scanner(System.in);
	public static void update()
	{
		int chon;
		do {
			System.out.println("===========CAP NHAT THONG TIN==========");
			System.out.println("\tChon thong tin ban muon cap nhat");
			System.out.println("\t1. Cap nhat thong tin sinh vien");
			System.out.println("\t2. Cap nhat thong tin mon hoc");
			System.out.println("\t3. Cap nhat thong tin diem ");
			System.out.println("\t0. Quay lai");
			chon=Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1: DanhSachSinhVien.capnhat();break;
			case 2: DanhSachMonHoc.capnhat();break;
			case 3: DanhSachDiem.capnhat();break;	
			case 0: return;
			default:System.out.println("Vui long chon lai");
				
			}
		} while (true);
	}
}
