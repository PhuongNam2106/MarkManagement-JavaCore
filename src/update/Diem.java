package update;

public class Diem {
	private int idSV;
	private int idMH;
	private double diemSo;
	
	public void display() 
	{
		System.out.printf("%-18s %-8s %7.2f %n",DanhSachSinhVien.nameOfSV(idSV),DanhSachMonHoc.nameOfMH(idMH),diemSo);
		
	}

	public Diem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Diem(int idSV, int idMH, double diemSo) {
		super();
		this.idSV = idSV;
		this.idMH = idMH;
		this.diemSo = diemSo;
	}

	public int getIdSV() {
		return idSV;
	}

	public void setIdSV(int idSV) {
		this.idSV = idSV;
	}

	public int getIdMH() {
		return idMH;
	}

	public void setIdMH(int idMH) {
		this.idMH = idMH;
	}

	public double getDiemSo() {
		return diemSo;
	}

	public void setDiemSo(double diemSo) {
		this.diemSo = diemSo;
	}
	
	
}
