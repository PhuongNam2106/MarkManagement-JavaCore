package search;


import java.util.Scanner;

import update.DanhSachDiem;
import update.DanhSachMonHoc;
import update.DanhSachSinhVien;


public class Search {
	static Scanner sc = new Scanner(System.in);
	public static void search()
	{
		int chon;
		do {
			System.out.println("============TIM KIEM THONG TIN============");
			System.out.println("Moi ban chon phuong thuc tim kiem thong tin");
			System.out.println("\t1. Hien thi diem cua sinh vien ");
			System.out.println("\t2. Hien thi danh sach sinh vien theo mon hoc ");
			System.out.println("\t0. Quay lai");
			chon=Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1: hienThiDiemCuaSV();break;
			case 2: hienThiDsSVTheoMH();break;
			case 0: return;

			default: System.out.println("Lua chon khong hop le");
				
			}
		} while (true);
	}
	
	private static void hienThiDiemCuaSV() {
		System.out.print("Nhap ma sinh vien: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = DanhSachSinhVien.sameID(id);
		if(index==-1)
		{
			System.out.println("Khong ton tai ma sinh vien nay");
			return;
		}
		int dem=0;
		double tongDiem=0;
		System.out.println("Ma sinh vien: "+ id);
		System.out.println("Ten sinh vien: " + DanhSachSinhVien.nameOfSV(id));
		System.out.printf("%-8s %-15s %7s %n","Ma MH","Ten MH","Diem so");
		for(int j=0;j<DanhSachDiem.list.size();j++)
		{
			if(DanhSachDiem.list.get(j).getIdSV() == id)
			{
				System.out.printf("%-8d %-15s %7.2f %n",DanhSachDiem.list.get(j).getIdMH(),DanhSachMonHoc.nameOfMH(DanhSachDiem.list.get(j).getIdMH()),DanhSachDiem.list.get(j).getDiemSo());
				dem=dem+1*(int)DanhSachMonHoc.heso(DanhSachDiem.list.get(j).getIdMH());
				tongDiem=tongDiem+DanhSachDiem.list.get(j).getDiemSo()*(int)DanhSachMonHoc.heso(DanhSachDiem.list.get(j).getIdMH());
			}
		
		}
		System.out.println("Diem tong ket trung binh mon: "+(tongDiem/dem));
		System.out.printf("%n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~%n");
	}
	private static void hienThiDsSVTheoMH() {
		System.out.print("Nhap ma mon hoc: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = DanhSachMonHoc.sameIDMh(id);
		if(index==-1)
		{
			System.out.println("Khong ton tai ma mon hoc nay");
			return;
		}
		int dem=0;
		double tongDiem=0;
		System.out.println("Ma mon hoc: "+ id);
		System.out.println("Ten mon hoc: " + DanhSachMonHoc.nameOfMH(id));
		System.out.printf("%-8s %-20s %7s %n","Ma SV","Ten SV","Diem so");
		for(int j=0;j<DanhSachDiem.list.size();j++)
		{
			
			if(DanhSachDiem.list.get(j).getIdMH() == id)
			{
				System.out.printf("%-8d %-20s %7.2f %n",DanhSachDiem.list.get(j).getIdSV(),DanhSachSinhVien.nameOfSV(DanhSachDiem.list.get(j).getIdSV()),DanhSachDiem.list.get(j).getDiemSo());
				dem=dem+1;
				tongDiem=tongDiem+DanhSachDiem.list.get(j).getDiemSo();
			}
		
		}
		System.out.println("Diem trung binh cua mon: "+(tongDiem/dem));
		System.out.printf("%n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~%n");
		
		
	}
}
