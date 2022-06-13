package update;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;



public class DanhSachMonHoc {
	static Scanner sc=new Scanner(System.in);
	public static ArrayList<MonHoc> list = new ArrayList<MonHoc>();
	public static void capnhat()
	{
		int chon;
		do {
			System.out.println("=======CAP NHAT THONG TIN MON HOC========");
			System.out.println("\t Chon chuc nang");
			System.out.println("\t1. Them mot mon hoc moi");
			System.out.println("\t2. Sua mon hoc");
			System.out.println("\t3. Xoa mon hoc");
			System.out.println("\t4. Hien thi danh sach mon hoc");
			System.out.println("\t0. Quay lai");
			chon= Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1: themMoi(); break;
			case 2: sua();break;
			case 3: xoa();break;
			case 4: sapXep();hienThi();break;
			case 0: return;

			default: System.out.println("Lua chon khong hop le");
				
			}
		} while (true);
	}
	private static void themMoi() {
		System.out.println("-------THEM MOI MOT MON HOC-------");
		System.out.print("Nhap ma mon hoc: ");
		int id=Integer.parseInt(sc.nextLine());
		int index=sameIDMh(id);
		if (id<=0) 
		{
			System.out.println("Ma mon hoc khong hop le, moi nhap lai ");
			return;
		}
		if(index!=-1)
		{
			System.out.println("Da co ma mon hoc nay trong danh sach");
			return;
		}
		
		System.out.print("Nhap ten mon hoc: ");
		String tenMH=sc.nextLine();
		if (tenMH.length() == 0) {
			System.out.println("\tTen khong duoc de trong");
			return;
		}
		
		System.out.print("Nhap he so: ");
		double heSo = Double.parseDouble(sc.nextLine());
		if(heSo<1)
		{
			System.out.println("He so khong duoc < 1");
			return;
		}
		
		MonHoc mh = new MonHoc(id,tenMH,heSo);
		list.add(mh);
		System.out.println("Them moi mon hoc thanh cong...!");
		
	}
	private static void sua() {
		System.out.println("=======SUA THONG TIN MON HOC========");
		System.out.print("Nhap ma mon hoc can sua: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = sameIDMh(id);
		if(index==-1)
		{
			System.out.println("Khong ton tai ma mon hoc nay");
			return;
		}
		int chon;
		do {
			System.out.println("\t Chon thong tin can sua");
			System.out.println("\t1. Sua ten mon hoc");
			System.out.println("\t2. Sua he so");
			System.out.println("\t3. Quay lai");
			chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1: suaTenMH(list.get(index));break;
			case 2: suaHeSo(list.get(index));break;	
			case 0: return;
			default:System.out.println("Lua chon khong hop le: ");
				break;
			}
		} while (true);
		
	}
	private static void suaTenMH(MonHoc monHoc) {
		System.out.println("\t -------SUA TEN MON HOC--------");
		System.out.print("Nhap ten moi");
		String tenMH = sc.nextLine();
		if (tenMH.length() == 0) {
			System.out.println("\tTen khong duoc de trong");
			return;
		}
		monHoc.setTenMH(tenMH);
		System.out.println("Sua ten mon hoc thanh cong...!");
		
	}
	private static void suaHeSo(MonHoc monHoc) {
		System.out.println("-------SUA NAM SINH----------");
		System.out.print("Nhap he so moi");
		double heSo = Double.parseDouble(sc.nextLine());
		if(heSo<1)
		{
			System.out.println("He so phai lon hon 1");
			return;
		}
		monHoc.setHeSo(heSo);
		System.out.println("Sua he so thanh cong...!");
		
	}
	private static void xoa() {
		System.out.println("\n------Xoa thong tin mon hoc------");
		System.out.print("\tNhap ma mon hoc can xoa: ");
		int id = Integer.parseInt(sc.nextLine());		
		if(DanhSachDiem.checkMH(id)==id)
		{
			System.out.println("Mon hoc nay da co sinh vien hoc, khong xoa duoc");
			return;
		}
		int index = sameIDMh(id); 
		if (index == -1) {
			System.out.println("\tMon hoc chua co trong danh sach");
			return;
		}
		list.remove(index);
		System.out.println("\tXoa mon hoc thanh cong...!");
		
	}
	private static void hienThi() {
		System.out.println("---------DANH SACH MON HOC----------");
		System.out.printf("%-8s %-20s %-5s %n","MaMH","Ten MH","He so");
		for(MonHoc mh : list)
		{
			mh.display();
		}
	}
	
	private static void sapXep() {
		Collections.sort(list, new Comparator<MonHoc>() {
			@Override
			public int compare(MonHoc o1, MonHoc o2) {
				return o1.getTenMH().compareToIgnoreCase(o2.getTenMH());
			}
		});
	}
	
	//Hàm dò id mới có trùng với idMH cũ hay không
		public static int sameIDMh(int id)
		{
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getId() == id) {
					return i;
				}
			}
			return -1;
		}
		
	//ham nhan id mon hoc tra ve ten mon hoc
		public static String nameOfMH(int id) {
			for (MonHoc mh : list) {
				if (mh.getId() == id) {
					return mh.getTenMH();
				}
			}
			return null;
		}
		
		//hàm nhận id mh trả về hệ số môn học 
		public static double heso(int id)
		{
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getId() == id) {
					return list.get(i).getHeSo();
				}
			}
			return -1;
		}
}
