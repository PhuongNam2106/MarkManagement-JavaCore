package update;
public class MonHoc {
	private int id;
	private String tenMH;
	private double heSo;
	
	public void display()
	{
		System.out.printf("%-8d %-20s %-5.2f %n",id,tenMH,heSo);
	}

	public MonHoc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MonHoc(int id, String tenMH, double heSo) {
		super();
		this.id = id;
		this.tenMH = tenMH;
		this.heSo = heSo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenMH() {
		return tenMH;
	}

	public void setTenMH(String tenMH) {
		this.tenMH = tenMH;
	}

	public double getHeSo() {
		return heSo;
	}

	public void setHeSo(double heSo) {
		this.heSo = heSo;
	}
	
	
}
