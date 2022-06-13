package main;

import java.util.Scanner;

import search.Search;
import update.QuanLyUpdate;

public class Main {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int chon;
		do {
			System.out.println("=======CHUONG TRINH QUAN LY TRUONG HOC========");
			System.out.println("\t Moi ban chon chuc nang: ");
			System.out.println("\t1. Cap nhat thong tin");
			System.out.println("\t2. Tim kiem thong tin");
			System.out.println("\t0. Dong ung dung");
			chon=Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1: QuanLyUpdate.update();break;
			case 2: Search.search();break;
			case 0: System.out.println("Dong ung dung");System.exit(0);
			default: System.out.println("Lua chon khong hop le: ");
			}
		} while (true);
	}
}
