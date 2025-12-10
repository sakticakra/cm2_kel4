import java.util.Scanner;

public class cm {
    static String[][] data = new String[29][6]; // [nama, nim, prodi, perusahaan, semester, status]
    static int jumlahData = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;

        do {
            System.out.println("\n=== Sistem Pendaftaran Magang Mahasiswa ===");
            System.out.println("1. Tambah Data Magang");
            System.out.println("2. Tampilkan Semua Pendaftar Magang");
            System.out.println("3. Cari Pendaftar berdasarkan Program Studi");
            System.out.println("4. Hitung Jumlah Pendaftar untuk Setiap Status");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");
            pilihan = sc.nextInt();
            sc.nextLine(); // buang buffer

            switch (pilihan) {
                case 1:
                    tambahData();
                    break;
                default:
                    System.out.println("Pilihan tidak valid! Silakan pilih 1-5.");
            }
        } while (pilihan != 5);
    }

    // Menu 1: Tambah Data Magang
    static void tambahData() {
        if (jumlahData >= 29) {
            System.out.println("Kuota sudah penuh!");
            return;
        }

        System.out.print("Nama Mahasiswa: ");
        String nama = sc.nextLine();

        System.out.print("NIM: ");
        String nim = sc.nextLine();

        System.out.print("Program Studi: ");
        String prodi = sc.nextLine();

        System.out.print("Perusahaan Tujuan Magang: ");
        String perusahaan = sc.nextLine();

        int semester = 0;
        while (true) {
            System.out.print("Semester pengambilan magang (6 atau 7): ");
            semester = sc.nextInt();
            sc.nextLine(); // buang buffer
            if (semester == 6 || semester == 7) {
                break;
            } else {
                System.out.println("Semester harus 6 atau 7!");
            }
        }

        String status = "";
        while (true) {
            System.out.print("Status magang (Diterima/Menunggu/Ditolak): ");
            status = sc.nextLine().trim();
            if (status.equalsIgnoreCase("Diterima") || 
                status.equalsIgnoreCase("Menunggu") || 
                status.equalsIgnoreCase("Ditolak")) {
                break;
            } else {
                System.out.println("Status hanya boleh: Diterima, Menunggu, atau Ditolak.");
            }
        }

        // Simpan data
        data[jumlahData][0] = nama;
        data[jumlahData][1] = nim;
        data[jumlahData][2] = prodi;
        data[jumlahData][3] = perusahaan;
        data[jumlahData][4] = "" + semester;
        data[jumlahData][5] = status;

        jumlahData++;
        System.out.println("Data pendaftar magang berhasil ditambahkan. Total pendaftar: " + jumlahData);
    }
}