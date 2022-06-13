package update;

public class SinhVien {
	private int id;
	private String hoDem;
	private String ten;
	private int namSinh;
	private String gioiTinh;
	
	public void display()
	{
		System.out.printf("%-10d %-15s %-7s %-8d %-9s %n",id,hoDem,ten,namSinh,gioiTinh);
	}

	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SinhVien(int id, String hoDem, String ten, int namSinh, String gioiTinh) {
		super();
		this.id = id;
		this.hoDem = hoDem;
		this.ten = ten;
		this.namSinh = namSinh;
		this.gioiTinh = gioiTinh;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHoDem() {
		return hoDem;
	}

	public void setHoDem(String hoDem) {
		this.hoDem = hoDem;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	
	
}
