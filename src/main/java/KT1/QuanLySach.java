/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package KT1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class QuanLySach {
     private static ArrayList<Sach> LS = new ArrayList<>();
    private static Sach S = null;
    private static Scanner sc = new Scanner(System.in);

    public static void Menu() {
        LS.add(new Sach("K011", "Lap trinh java", 95000, 2017));
        LS.add(new Sach("K012", "Co so du lieu", 85000, 2001));
        LS.add(new Sach("K013", "Nhap mon Lap trinh", 72000, 2013));
        LS.add(new Sach("K014", "Lap trinh Python", 39000, 2018));
        LS.add(new Sach("K015", "Lap trinh C#", 82000, 2015));

        int chon = 0;
        while (chon != 7) {
            System.out.print("\n=====QUAN LY SACH=====");
            System.out.print("\n1. Xuat toan bo sach"
                    + "\n2. Lay ra sach xuat ban truoc 2015"
                    + "\n3. Tim cac sach co ky tu dau ten sach la 'Lap Trinh'"
                    + "\n4. Sap xep Sach theo gia tang dan"
                    + "\n5. Xoa sach theo ma sach"
                    + "\n6. Sua gia bia cua sach theo ma sach"
                    + "\n7. Tinh tong tri gia cu cac sach"
                    + "\nChon hanh dong ban muon thuc hien: ");
            chon = sc.nextInt();
            switch (chon) {
                case 1:
                    XuatDS();
                    break;
                case 2:
                    XuatDSTruoc2015();
                    break;
                case 3:
                    TimDS();
                    break;
                case 4:
                    SapXepTang();
                    break;
                case 5:
                    XoaSach();
                    break;
                case 6:
                    SuaSach();
                    break;
                case 7:
                    TongTGSach();
                    break;
            }
        }
    }

    public static void XuatDS() {
        int tong = 0;
        for (Sach S : LS) {
            tong += S.getGiaBia();
        }
        for (Sach sach : LS) {
            System.out.println("\n Ma sach: " + sach.getMaSach()
                    + "\nTen sach:" + sach.getTenSach()
                    + "\nGia bia: " + sach.getGiaBia()
                    + "\nNam xuat ban: " + sach.getNamXuatBan());

        }
        System.out.println("Tong tri gia cac sach: " + tong);
    }

    public static void XuatDSTruoc2015() {
        System.out.println("-----DANH SACH XUAT BAN TRUOC NAM 2015");
        for (Sach S : LS) {
            if (S.getNamXuatBan() < 2015) {
                System.out.println(S);
            }
        }
    }

    public static void TimDS() {
        String kyTu = "lap trinh";
        for(Sach s : LS){
            if(s.getTenSach().contains(kyTu)){
                  System.out.println(s);
            }
        }
    }
    
          
        

    public static void SapXepTang() {
        System.out.println("-----DANH SACH SAU KHI SAP XEP THEO GIA TANG-----");
        Comparator<Sach> cmp = new Comparator<Sach>() {
            @Override
            public int compare(Sach S1, Sach S2) {
                return Double.compare(S1.getGiaBia(), S2.getGiaBia());
            }
        };
        Collections.sort(LS, cmp);
        for (Sach S : LS) {
            System.out.println(S.toString());
        }
    }

    public static void XoaSach() {
        System.out.println("Nhap MS can xoa: ");
        String m = sc.nextLine();
        for (Sach S : LS) {
   
        if (S.getMaSach() == m) 
                LS.remove(m);
        
    }
    }

    public static void SuaSach() {
        int dem = 0;
        System.out.print("Nhap ma sach can sua: ");
        String maSach = sc.nextLine();
        for(Sach sach : LS){
            if(maSach.equalsIgnoreCase(sach.getMaSach())){
                System.out.print("\nNhap gia bia can sua: ");
                double giaSua = sc.nextDouble();
                sach.setGiaBia(giaSua);
                dem++;
            }
        }
        if(dem != 0){
            System.out.println("\nSua thanh cong");
        }
        else{
            System.out.println("\nSua ko thanh cong");
        }
    }

    public static void TongTGSach() {
        int tong = 0;
        for (Sach S : LS) {
            tong += S.getGiaBia();
        }
        System.out.println("Tong tri gia cua cac sach: " + tong);

    }
}
