package update;

import java.util.ArrayList;
import java.util.Scanner;

public class DanhSachDiem {
	public static ArrayList<Diem> list = new ArrayList<Diem>();
	public static ArrayList<Diem> danhSachSinhVienDaCoDiem = new ArrayList<Diem>();
	public static ArrayList<Diem> danhSachMonHocCoSVHoc = new ArrayList<Diem>();
	static Scanner sc = new Scanner(System.in);
	
	public static void capnhat()
	{
		int chon;
		do {
			System.out.println("==========CAP NHAT DIEM==========");
			System.out.println("Moi chon chuc nang");
			System.out.println("\t1. Nhap diem cho sinh vien ");
			System.out.println("\t2. Sua diem cho sinh vien");
			System.out.println("\t3. Xoa diem cua sinh vien");
			System.out.println("\t4. Hien thi danh sach diem cua tung sinh vien");
			System.out.println("\t5. Hien thi danh sach diem theo mon hoc");
			System.out.println("\t0. Quay lai");
			chon=Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1: themMoi();break;
			case 2: sua();break;
			case 3: xoa();break;
			case 4: hienThiTheoSV();break;
			case 5: hienThiTheoMH();break;
			case 0: return;

			default:System.out.println("Lua chon khong hop le");
				
			}
		} while (true);
	}

	private static void themMoi() {
		System.out.println("--------NHAP DIEM CHO SINH VIEN----------");
		System.out.print("Nhap ma sinh vien: ");
		int idSV = Integer.parseInt(sc.nextLine());
		if(DanhSachSinhVien.sameID(idSV)==-1)
		{
			System.out.println("Khong co sinh vien nay trong danh sach");
			return;
		}
		
		System.out.print("Nhap ma mon hoc: ");
		int idMH = Integer.parseInt(sc.nextLine());
		if(DanhSachMonHoc.sameIDMh(idMH)==-1)
		{
			System.out.println("Khong co mon hoc nay trong danh sach");
			return;
		}
		
		int check=checkCoDiemChua(idSV, idMH);
		if(check==1)
		{
			System.out.printf("Sinh vien %s da co diem mon %s",DanhSachSinhVien.nameOfSV(idSV),DanhSachMonHoc.nameOfMH(idMH));
			return;
		}
		
		System.out.print("Nhap diem(0<=diem<=10) : ");
		double diemSo;
		do {
			diemSo = Double.parseDouble(sc.nextLine());
			if (diemSo < 0||diemSo > 10) {
				System.out.println("Nhap lai diem: ");
			}
		} while (diemSo < 0 || diemSo >10); 
		
		Diem diem = new Diem(idSV,idMH,diemSo);
		
		//điều kiện này chỉ lấy đúng 1 lần mã sv vào trong danh sách để phục vụ việc hiển thị danh sách điểm theo từng sinh viên
		if(checkSV(idSV)==-1)
		{
			danhSachSinhVienDaCoDiem.add(diem);
		}
		//--------------
		
		//điều kiện này chỉ lấy đúng 1 lần mã mh vào trong danh sách để phục vụ việc hiển thị danh sách điểm theo từng môn hoc
		if(checkSV(idMH)==-1)
		{
			danhSachMonHocCoSVHoc.add(diem);
		}
		//-------------------
		
		list.add(diem);
		System.out.println("Them diem cho sinh vien thanh cong");
		
		
	}

	private static void sua() {
		System.out.println("---------SUA DIEM CHO SINH VIEN---------");
		System.out.print("Nhap ma sinh vien: ");
		int idSV = Integer.parseInt(sc.nextLine());
		if(DanhSachSinhVien.sameID(idSV)==-1)
		{
			System.out.println("Khong co sinh vien nay trong danh sach");
			return;
		}
		
		System.out.print("Nhap ma mon hoc: ");
		int idMH = Integer.parseInt(sc.nextLine());
		if(DanhSachMonHoc.sameIDMh(idMH)==-1)
		{
			System.out.println("Khong co mon hoc nay trong danh sach");
			return;
		}
		// kiểm tra sinh viên nay đã học môn này chưa, nếu chưa thì không cho phép sửa điểm
		int check=checkCoDiemChua(idSV, idMH);
		if(check==-1)
		{
			System.out.printf("Sinh vien %s chua co diem mon %s, khong sua duoc %n",DanhSachSinhVien.nameOfSV(idSV),DanhSachMonHoc.nameOfMH(idMH));
			return;
		}
		
		System.out.print("Nhap diem so moi: ");
		double diemSo = Double.parseDouble(sc.nextLine());
		for (int i=0; i<list.size(); i++) 
		{
			if (list.get(i).getIdSV()==idSV && list.get(i).getIdMH() == idMH) 
			{
				list.get(i).setDiemSo(diemSo);
				break;
			}
		}
		System.out.println("\tSua diem thanh cong...!");
		
	}

	private static void xoa() {
		System.out.println("--------XOA DIEM CUA SINH VIEN---------");
		System.out.print("Nhap ma sinh vien: ");
		int idSV = Integer.parseInt(sc.nextLine());
		if(DanhSachSinhVien.sameID(idSV)==-1)
		{
			System.out.printf("Khong co sinh vien nay trong danh sach %n");
			return;
		}
		
		System.out.print("Nhap ma mon hoc: ");
		int idMH = Integer.parseInt(sc.nextLine());
		if(DanhSachMonHoc.sameIDMh(idMH)==-1)
		{
			System.out.printf("Khong co mon hoc nay trong danh sach %n");
			return;
		}
		// kiểm tra sinh viên nay đã học môn này chưa, nếu chưa thì không cho phép xóa điểm
		int check=checkCoDiemChua(idSV, idMH);
		if(check==-1)
		{
			System.out.printf("Sinh vien %s chua co diem mon %s, khong xoa duoc %n",DanhSachSinhVien.nameOfSV(idSV),DanhSachMonHoc.nameOfMH(idMH));
			return;
		}
		
		for (int i=0; i<list.size(); i++) 
		{
			if (list.get(i).getIdSV()==idSV && list.get(i).getIdMH() == idMH) 
			{
				list.remove(i);
				break;
			}
		}
		System.out.println("\tXoa diem thanh cong...!");
		
	}
	
	
	private static void hienThiTheoSV() {
		System.out.println("---------Danh sach diem theo tung sinh vien---------");
		for(int i=0;i<danhSachSinhVienDaCoDiem.size();i++)
		{
			int dem=0;
			double tongDiem=0;
			System.out.println("Ma sinh vien: "+danhSachSinhVienDaCoDiem.get(i).getIdSV());
			System.out.println("Ten sinh vien: " + DanhSachSinhVien.nameOfSV(danhSachSinhVienDaCoDiem.get(i).getIdSV()));
			System.out.printf("%-8s %-15s %7s %n","Ma MH","Ten MH","Diem so");
			for(int j=0;j<list.size();j++)
			{
				if(list.get(j).getIdSV() == danhSachSinhVienDaCoDiem.get(i).getIdSV())
				{
					System.out.printf("%-8d %-15s %7.2f %n",list.get(j).getIdMH(),DanhSachMonHoc.nameOfMH(list.get(j).getIdMH()),list.get(j).getDiemSo());
					dem=dem+1*(int)DanhSachMonHoc.heso(list.get(j).getIdMH());
					tongDiem=tongDiem+list.get(j).getDiemSo()*(int)DanhSachMonHoc.heso(list.get(j).getIdMH());
				}
			
			}
			System.out.println("Diem tong ket trung binh mon: "+(tongDiem/dem));
			System.out.printf("%n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~%n");
		}
		
	}

	private static void hienThiTheoMH() {
		System.out.println("---------Danh sach diem theo tung mon hoc---------");
		for(int i=0;i<danhSachMonHocCoSVHoc.size();i++)
		{
			int dem=0;
			double tongDiem=0;
			System.out.println("Ma mon hoc: "+danhSachMonHocCoSVHoc.get(i).getIdMH());
			System.out.println("Ten mon hoc: " + DanhSachMonHoc.nameOfMH(danhSachMonHocCoSVHoc.get(i).getIdMH()));
			System.out.printf("%-8s %-20s %7s %n","Ma SV","Ten SV","Diem so");
			for(int j=0;j<list.size();j++)
			{
				
				if(list.get(j).getIdMH() == danhSachMonHocCoSVHoc.get(i).getIdMH())
				{
					System.out.printf("%-8d %-20s %7.2f %n",list.get(j).getIdSV(),DanhSachSinhVien.nameOfSV(list.get(j).getIdSV()),list.get(j).getDiemSo());
					dem=dem+1;
					tongDiem=tongDiem+list.get(j).getDiemSo();
				}
			
			}
			System.out.println("Diem trung binh cua mon: "+(tongDiem/dem));
			System.out.printf("%n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~%n");
		}
		
	}
	
	
	
	
	//kiem tra xem sinh vien da co diem mon nay chua, neu co thi tra ve 1, chua co thi tra ve -1
	public static int checkCoDiemChua(int idSV,int idMH)
	{
		for(int i=0;i<list.size();i++)
			if (list.get(i).getIdSV()==idSV && list.get(i).getIdMH() == idMH){
				return 1;
			}
		return -1;
	}
	
	//kiem tra xem sinh vien nay da co trong danh sach diem chua
	public static int checkSV(int idSV) {
		for(int i=0;i<list.size();i++)
			if (list.get(i).getIdSV()==idSV){
				return list.get(i).getIdSV();
			}
		return -1;
	}
	
	//kiem tra xem mon hoc da co sinh vien hoc chua
	public static int checkMH(int idMH) {
		for(int i=0;i<list.size();i++)
			if (list.get(i).getIdMH()==idMH){
				return list.get(i).getIdMH();
			}
		return -1;
	}
}











