package Menu;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Menu 
{    
    String kodeMenu;
    String namaMenu;
    double hargaMenu;
    int stokMenu;

    Menu(String kodeMenu, String namaMenu, double hargaMenu, int stokMenu) 
    {
        this.kodeMenu = kodeMenu;
        this.namaMenu = namaMenu;
        this.hargaMenu = hargaMenu;
        this.stokMenu = stokMenu;
    }
}

class MenuDatabasePudding 
{
    ArrayList<Menu> menuList = new ArrayList<>();

    void insertMenu(String namaMenu, double hargaMenu, int stokMenu) 
    {
        Random rand = new Random();
        int randomNum = rand.nextInt(1000);
        String kodeMenu = "PD-" + randomNum; 
        Menu menu = new Menu(kodeMenu, namaMenu, hargaMenu, stokMenu);
        menuList.add(menu);
        System.out.println("Berhasil menambahkan menu!");
    }

    void viewMenu() 
    {
        System.out.println("Daftar Menu:");
        for (Menu menu : menuList) 
        {
            System.out.println("Kode Menu: " + menu.kodeMenu);
            System.out.println("Nama Menu: " + menu.namaMenu);
            System.out.println("Harga Menu: " + menu.hargaMenu);
            System.out.println("Stok Menu: " + menu.stokMenu);
            System.out.println();
        }
    }

    void updateMenu(String namaMenu, double newHarga, int newStok) 
    {
        for (Menu menu : menuList) 
        {
            if (menu.namaMenu.equals(namaMenu)) 
            {
                menu.hargaMenu = newHarga;
                menu.stokMenu = newStok;
                System.out.println("Berhasil update menu!");
                return;
            }
        }
        System.out.println("Tidak ada menu tersedia");
    }

    void deleteMenu(String namaMenu) 
    {
        for (Menu menu : menuList) 
        {
            if (menu.namaMenu.equals(namaMenu)) 
            {
                menuList.remove(menu);
                System.out.println("Menu berhasil dihapus!");
                return;
            }
        }
        System.out.println("Menu tidak ditemukan.");
    }
}

public class Main 
{
    public static void main(String[] args) 
    {
        MenuDatabasePudding menuDatabasePudding = new MenuDatabasePudding();
        Scanner scanner = new Scanner(System.in);

        while (true) 
        {
            System.out.println("Ayo pilih menu:");
            System.out.println("1. Insert Menu Baru");
            System.out.println("2. View Menu yang sudah ada");
            System.out.println("3. Update Menu yang sudah ada");
            System.out.println("4. Delete Menu yang sudah ada");
            System.out.println("5. Keluar");
            System.out.print("Masukkan pilihan Anda: ");
            int choice = scanner.nextInt();

            switch (choice) 
            {
                case 1: // insert data disini
                    scanner.nextLine();
                    System.out.print("Masukkan nama menu: ");
                    String namaMenu = scanner.nextLine();
                    System.out.print("Masukkan harga menu: ");
                    double hargaMenu = scanner.nextDouble();
                    System.out.print("Masukkan stok menu: ");
                    int stokMenu = scanner.nextInt();
                    menuDatabasePudding.insertMenu(namaMenu, hargaMenu, stokMenu);
                    break;
                case 2: // view menu disini
                    menuDatabasePudding.viewMenu(); 
                    break;
                case 3: // update menu disini
                    scanner.nextLine(); 
                    System.out.print("Masukkan kode menu yang ingin diupdate: ");
                    String kodeMenuUpdate = scanner.nextLine();
                    System.out.print("Masukkan harga baru: ");
                    double newHarga = scanner.nextDouble();
                    System.out.print("Masukkan stok baru: ");
                    int newStok = scanner.nextInt();
                    menuDatabasePudding.updateMenu(kodeMenuUpdate, newHarga, newStok);
                    break;
                case 4: //delete menu disini
                    scanner.nextLine(); 
                    System.out.print("Masukkan kode menu yang ingin dihapus: ");
                    String kodeMenuDelete = scanner.nextLine();
                    menuDatabasePudding.deleteMenu(kodeMenuDelete);
                    break;
                case 5:
                    System.out.println("Terima kasih!");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}
