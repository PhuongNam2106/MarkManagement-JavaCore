package update;

import java.util.ArrayList; 
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;





public class DanhSachSinhVien {
	static Scanner sc = new Scanner(System.in);
	public static ArrayList<SinhVien> list = new ArrayList<SinhVien>();
	
	public static void capnhat()
	{
		int chon;
		do {
			System.out.println("---------CAP NHAT THONG TIN SINH VIEN----------");
			System.out.println("\t Chon chuc nang");
			System.out.println("\t1. Them mot sinh vien moi");
			System.out.println("\t2. Sua thong tin sinh vien");
			System.out.println("\t3. Xoa thong tin sinh vien");
			System.out.println("\t4. Hien thi danh sach sinh vien");
			System.out.println("\t0. Quay lai");
		    chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1: themmoi();break;
			case 2: sua();break;
			case 3: xoa();break;
			case 4: sapXep();hienthi();break;
			case 0: return;
			default:System.out.println("Vui long chon lai: ");	
				
			}
		} while (true);
	}
	private static void themmoi() {
		System.out.println("~~~~~~Them moi sinh vien~~~~~~~~");
		System.out.print("Nhap ma sinh vien ");
		int id=Integer.parseInt(sc.nextLine());
		int index=sameID(id);
		if (id<=0) 
		{
			System.out.println("Ma sinh vien khong hop le, moi nhap lai ");
			return;
		}
		if(index!=-1)
		{
			System.out.println("Da co ma sinh vien nay trong danh sach");
			return;
		}
		
		System.out.print("Nhap ho dem sinh vien: ");
		String hoDem=sc.nextLine();
		if (hoDem.length() == 0) {
			System.out.println("\tHo dem khong duoc de trong");
			return;
		}
		
		System.out.print("Nhap ten sinh vien: ");
		String ten=sc.nextLine();
		if (ten.length() == 0) {
			System.out.println("\tTen khong duoc de trong");
			return;
		}
		System.out.print("Nhap nam sinh(1970->2003): ");
		int namSinh = Integer.parseInt(sc.nextLine());
		if(namSinh<1970 | namSinh>2003)
		{
			System.out.println("Nam sinh khong phu hop");
			return;
		}
		System.out.print("Nhap gioi tinh: ");
		String gioiTinh = sc.nextLine();
		SinhVien sv = new SinhVien(id,hoDem,ten,namSinh,gioiTinh);
		list.add(sv);
		
		System.out.println("Them mot sinh vien moi thanh cong...!");
			
	}
	private static void sua() {
		System.out.println("---------SUA THONG TIN SINH VIEN----------");
		System.out.print("Moi ban nhap ma sinh vien can sua thong tin: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = sameID(id);
		if(index==-1)
		{
			System.out.println("Khong ton tai ma sinh vien nay");
			return;
		}
		int chon;
		do {
			System.out.println("\t Chon thong tin can sua");
			System.out.println("\t1. Sua ho dem");
			System.out.println("\t2. Sua ten");
			System.out.println("\t3. Sua nam sinh");
			System.out.println("\t4. Sua gioi tinh");
			chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1: suaHoDem(list.get(index));break;
			case 2: suaTen(list.get(index));break;	
			case 3: suaNamSinh(list.get(index));break;
			case 4: suaGioiTinh(list.get(index));break;

			default: System.out.println("Danh sach khong hop le ");
			
				
			}
		} while (true);
	}
	private static void suaHoDem(SinhVien sinhVien) {
		System.out.println("\t --------SUA HO DEM------");
		System.out.print("Nhap ho dem moi");
		String hoDem = sc.nextLine();
		if (hoDem.length() == 0) {
			System.out.println("\tHo dem khong duoc de trong");
			return;
		}
		sinhVien.setHoDem(hoDem);
		System.out.println("Sua ho dem thanh cong...!");
		
	}
	private static void suaTen(SinhVien sinhVien) {
		System.out.println("\t -------SUA TEN--------");
		System.out.print("Nhap ten moi");
		String ten = sc.nextLine();
		if (ten.length() == 0) {
			System.out.println("\tTen khong duoc de trong");
			return;
		}
		sinhVien.setTen(ten);
		System.out.println("Sua ten thanh cong...!");
		
	}
	private static void suaNamSinh(SinhVien sinhVien) {
		System.out.println("\t SUA NAM SINH");
		System.out.print("Nhap nam sinh moi");
		int namSinh = Integer.parseInt(sc.nextLine());
		if(namSinh<1970 | namSinh>2003)
		{
			System.out.println("Nam sinh khong phu hop");
			return;
		}
		sinhVien.setNamSinh(namSinh);
		System.out.println("Sua nam sinh thanh cong...!");
		
	}
	private static void suaGioiTinh(SinhVien sinhVien) {
		System.out.println("\t -------SUA GIOI TINH--------");
		System.out.print("Nhap gioi tinh moi");
		String gioiTinh = sc.nextLine();
		if (gioiTinh.length() == 0) {
			System.out.println("\tTen khong duoc de trong");
			return;
		}
		sinhVien.setGioiTinh(gioiTinh);
		System.out.println("Sua gioi tinh thanh cong...!");
		
	}
	
	
	
	private static void xoa() {
		System.out.println("\n------Xoa thong tin sinh vien------");
		System.out.print("\tNhap ma mon hoc can xoa: ");
		int id = Integer.parseInt(sc.nextLine());		
		if(DanhSachDiem.checkSV(id)==id)
		{
			System.out.println("Sinh vien nay da co diem khong xoa duoc");
			return;
		}
		int index = sameID(id);
		if (index == -1) {
			System.out.println("\tSinh vien chua co trong danh sach");
			return;
		}
		list.remove(index);
		System.out.println("\tXoa sinh vien thanh cong...!");
		
	}
	
	private static void hienthi() {
		System.out.println("--------DANH SACH SINH VIEN--------");
		System.out.printf("%-10s %-15s %-7s %-8s %-9s %n","Ma Sv","Ho dem","Ten","Nam sinh","Gioi tinh");
		for(SinhVien sv : list)
		{
			sv.display();
		}
		
	}
	
	private static void sapXep() {
		Collections.sort(list, new Comparator<SinhVien>() {
			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				// TODO Auto-generated method stub
				return o1.getTen().compareToIgnoreCase(o2.getTen());
			}
		});
	}
	
	//Hàm dò id mới có trùng với idSV cũ hay không
	public static int sameID(int id)
	{
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				return i;
			}
		}
		return -1;
	}
	
	//hamf nhan id sinh vien tra ve ten sinh vien
	public static String nameOfSV(int id) {
		for (SinhVien sv : list) {
			if (sv.getId() == id) {
				return sv.getHoDem() + sv.getTen();
			}
		}
		return null;
	}
}
