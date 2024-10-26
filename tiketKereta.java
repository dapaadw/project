package praktikum;

import java.util.Scanner;

public class tiketKereta {
    
    
    static String[][] keretaApi = {
        {"Jenis", "Harga", "Diskon", "AC", "Colokan"},
        {"Ekonomi", "50000", "2%", "Tidak Ada", "Tidak Ada"},
        {"Bisnis", "100000", "5%", "Ada", "Tidak Ada"},
        {"Eksekutif", "200000", "7%", "Ada", "Tidak Ada"},
        {"Pariwisata", "300000", "10%", "Ada", "Ada"}
    };
    static String[] pesananTiket = new String[10]; 
    static int jumlahPesanan = 0;
   
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Melihat daftar kereta api");
            System.out.println("2. Melihat daftar kereta api ber AC");
            System.out.println("3. Melihat daftar kereta api yang ber colokan");
            System.out.println("4. Memesan tiket kereta api");
            System.out.println("5. Melihat pesanan tiket");
            System.out.print("Masukkan nilai (1-5, masukkan diatas 5 untuk keluar program): ");

            int pil = sc.nextInt();

            switch (pil) {
                case 1:
                    for (int i = 0; i < keretaApi.length; i++) {
                        for (int j = 0; j < keretaApi.length; j++) {
                        System.out.printf("%-18s", keretaApi[i][j]);
                        }
                        System.out.println();
                    }
                    System.out.println();
                    break;
                
                case 2:
                    for (int i = 0; i < keretaApi.length; i++) {   
                        if (keretaApi[i][3].equals("Ada") || keretaApi[i][3].equals("AC")) {
                            for (int j = 0; j < keretaApi.length; j++) {
                                System.out.printf("%-18s", keretaApi[i][j]);                           
                            }
                            System.out.println();
                        }   
                    }
                    System.out.println();
                    break;
                
                case 3:
                    for (int i = 0; i < keretaApi.length; i++) {   
                        if (keretaApi[i][4].equals("Ada") || keretaApi[i][4].equals("Colokan")) {
                            for (int j = 0; j < keretaApi.length; j++) {
                                System.out.printf("%-18s", keretaApi[i][j]);     
                            }
                            System.out.println();
                        }
                    }
                    System.out.println();
                    break;
                
                case 4:
                    System.out.println("Pilih Kereta");
                    System.out.println("1. Ekonomi, Price: 50000");
                    System.out.println("2. Bisnis, Price: 100000");
                    System.out.println("3. Eksekutif, Price: 200000");
                    System.out.println("4. Pariwisata, Price: 300000");
                    System.out.print("Pilih dengan nomor antara 1-4: ");
                    int pilKereta = sc.nextInt();
                    
                    if (pilKereta >= 1 && pilKereta <= 4) {
                        pesananTiket[jumlahPesanan] = keretaApi[pilKereta][0];
                        jumlahPesanan++;
                        
                        System.out.println("Tiket " + keretaApi[pilKereta][0] + " berhasil dipesan. Anda juga mendapatkan diskon sebesar " + keretaApi[pilKereta][2] + "!");
                    } else {
                        System.out.println("Invalid, pilih antara 1-4.");
                    }
                    System.out.println();
                    break;

                case 5:
                    for (int i = 0; i < jumlahPesanan; i++) {
                        String index = pesananTiket[i];
                        int harga = 0;
                        String diskon = new String();
                        float hargareal = 0;
                        
                        for (int j = 0; j < keretaApi.length; j++) {
                            if (keretaApi[j][0].equals(index)) {
                                harga = Integer.parseInt(keretaApi[j][1]);
                                diskon = keretaApi[j][2];
                                
                                float diskonF = 1 - Float.parseFloat(diskon.replace("%","")) / 100;
                                hargareal = harga * diskonF;
                            }
                        }
                        System.out.println((i+1) + ". " + pesananTiket[i] + " dengan harga: " + harga + ", diskon: " + diskon + ", dan harga setelah diskon: " + hargareal);
                    }
                    System.out.println();
                    break;

                default:
                    System.out.println("Program selesai.");
                    return;
            }
        }
    }
}