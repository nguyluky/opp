import java.util.Arrays;
import java.util.Scanner;

public class KhenThuong {
    private String ID;
    private String ngayKhenThuong;
    private String hinhThuc;
    private String liDo;
    private KhenThuong[] dsKhenThuong;
    private static KhenThuong instance;

   
    public static KhenThuong getInstance() {
        if (instance == null) {
            instance = new KhenThuong();
        }
        return instance;
    }

    
    public KhenThuong() {
        this.dsKhenThuong = new KhenThuong[0];
    }

    
    public KhenThuong[] getDanhSachKhenThuong() {
        return this.dsKhenThuong;
    }

    
    public void addKhenThuong(KhenThuong kt) {
        this.dsKhenThuong = Arrays.copyOf(this.dsKhenThuong, this.dsKhenThuong.length + 1);
        this.dsKhenThuong[this.dsKhenThuong.length - 1] = kt;
    }

    
    public void removeKhenThuong(String id) {
        for (int i = 0; i < this.dsKhenThuong.length; i++) {
            if (this.dsKhenThuong[i].getId() != null && this.dsKhenThuong[i].getId().equals(id)) {
                for (int j = i; j < this.dsKhenThuong.length - 1; j++) {
                    this.dsKhenThuong[j] = this.dsKhenThuong[j + 1];
                }
                break;
            }
        }
        this.dsKhenThuong = Arrays.copyOf(this.dsKhenThuong, this.dsKhenThuong.length - 1);
    }

   
    public String getId() {
        return this.ID;
    }

    public void setId(String ID) {
        this.ID = ID;
    }
    
    public String getNgayKhenThuong() {
        return this.ngayKhenThuong;
    }

    public void setNgayKhenThuong(String ngayKhenThuong) {
        this.ngayKhenThuong = ngayKhenThuong;
    }

    public String getHinhThuc() {
        return this.hinhThuc;
    }

    public void setHinhThuc(String hinhThuc) {
        this.hinhThuc = hinhThuc;
    }

    public String getLiDo() {
        return this.liDo;
    }

    public void setLiDo(String liDo) {
        this.liDo = liDo;
    }

    public static void main(String[] args) {
        KhenThuong manager = KhenThuong.getInstance();
        Scanner scanner = new Scanner(System.in);

        
        System.out.println("Nhap so luong nhan vien muon them: ");
        int n = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < n; i++) {
            KhenThuong kt = new KhenThuong();
            System.out.println("Nhap ID: ");
            kt.setId(scanner.nextLine());
            System.out.println("Nhap ngay khen thuong : ");
            kt.setNgayKhenThuong(scanner.nextLine());
            System.out.println("Nhap hinh thuc: ");
            kt.setHinhThuc(scanner.nextLine());    
            System.out.println("Nhap li do: ");
            kt.setLiDo(scanner.nextLine());

            manager.addKhenThuong(kt);
        }

   
        System.out.println("Danh sach khen thuong sau khi nhap:");
        for (KhenThuong kt : manager.getDanhSachKhenThuong()) {
            System.out.println("ID: " + kt.getId() + ", Ngày khen thưong: " + kt.getNgayKhenThuong() + 
                               ", Hinh thuc: " + kt.getHinhThuc() + ", Ly do: " + kt.getLiDo());
        }

        
        System.out.println("Nhap so luon nhan vien muon xoa: ");
        int m = scanner.nextInt();
        scanner.nextLine();  

        for (int i = 0; i < m; i++) {
            System.out.println("Nhap ID sau khi xoa: ");
            String id = scanner.nextLine();
            manager.removeKhenThuong(id);
        }

       
        System.out.println("Danh sach khen thuong sau khi xoa:");
        for (KhenThuong kt : manager.getDanhSachKhenThuong()) {
            System.out.println("ID: " + kt.getId() + ", Ngay khen thuong: " + kt.getNgayKhenThuong() + 
                               ", Hinh thuc: " + kt.getHinhThuc() + ", Ly do: " + kt.getLiDo());
        }

        scanner.close();
    }
}
