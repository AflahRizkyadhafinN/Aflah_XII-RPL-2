package com.buku_telepon;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        BukuTelepon.LoadFile();
        Menu();
    }

    public static void Menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("====== Buku Telepon ======");
        System.out.println("1. Lihat seluruh kontak");
        System.out.println("2. Tambah kontak");
        System.out.println("3. Hapus kontak");
        System.out.print("Pilihan : ");
        int pilihanMenu = scanner.nextInt();

        switch (pilihanMenu) {
            case (1):
                BukuTelepon.Show();
                break;
            case (2):
                BukuTelepon.Tambah();
                break;
            case (3):
                BukuTelepon.Hapus();
                break;
            default:
                System.out.println("Pilihan salah");
                Menu();
        }

        scanner.close();
    }
}

class BukuTelepon {
    String nama;
    String email;
    String noTelepon;

    BukuTelepon(String nama, String email, String noTelepon) {
        this.nama = nama;
        this.email = email;
        this.noTelepon = noTelepon;
    }

    static ArrayList<BukuTelepon> indexBukuTelepon = new ArrayList<BukuTelepon>();
    static Scanner scanner = new Scanner(System.in);

    public static void Show() {
        System.out.println("====== List Kontak ======");
        if (indexBukuTelepon.size() >= 0) {
            for (int i = 0; i <= indexBukuTelepon.size() - 1; i++) {
                System.out
                        .println(i + 1 + ". " + indexBukuTelepon.get(i).nama + " : " + indexBukuTelepon.get(i).email
                                + " : "
                                + indexBukuTelepon.get(i).noTelepon);
            }
            System.out.println("=========================");
            Ending();
        } else {
            System.out.println("List kontak masih kosong");
            Main.main(null);
        }
    }

    public static void Tambah() {

        System.out.println("====== Tambah Kontak ======");
        System.out.print("Nama : ");
        String nama = scanner.next();
        System.out.print("Email : ");
        String email = scanner.next();
        System.out.print("No Telepon : ");
        String noTelepon = scanner.next();

        indexBukuTelepon.add(new BukuTelepon(nama, email, noTelepon));
        System.out.println(indexBukuTelepon);
        SaveFile();
        Ending();
    }

    public static void Hapus() {
        for (int i = 0; i <= indexBukuTelepon.size() - 1; i++) {
            System.out
                    .println(i + 1 + ". " + indexBukuTelepon.get(i).nama + " | " + indexBukuTelepon.get(i).email
                            + " | "
                            + indexBukuTelepon.get(i).noTelepon);
        }
        System.out.println("Hapus kontak ke :");
        int pilihan = scanner.nextInt();
        indexBukuTelepon.remove(pilihan - 1);
        SaveFile();
        Ending();
    }

    public static void Ending() {
        System.out.println("9. Kembali");
        System.out.println("0. Exit");
        System.out.print("Pilihan : ");
        int pilihan = scanner.nextInt();
        switch (pilihan) {
            case 9:
                Main.Menu();
            case 0:
                break;
            default:
                break;
        }
    }

    public static void SaveFile() {
        String path = "datas.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, false))) {
            String result = "";
            for (BukuTelepon element : indexBukuTelepon) {
                result = result + element.nama + ";" + element.email + ";" + element.noTelepon + "\n";
            }
            writer.write(result);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("An error occurred while saving the value to the file.");
        }
    }

    public static void LoadFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("datas.txt"))) {
            ArrayList<BukuTelepon> arr = new ArrayList<BukuTelepon>();
            String line;

            while ((line = reader.readLine()) != null) {
                // System.out.println(line);
                String[] splitValues = line.split(";");
                arr.add(new BukuTelepon(splitValues[0], splitValues[1], splitValues[2]));
            }
            indexBukuTelepon = arr;
            System.out.println(indexBukuTelepon.toString());
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("An error occurred while saving the value to the file.");
        }
    }
}