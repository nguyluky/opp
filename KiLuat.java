import java.util.Arrays;
import java.util.Scanner;

public class KiLuat {
    private String ID;
    private String ngayKiLuat;
    private String hinhThuc;
    private String liDo;
    private KiLuat[] dsKiLuat;
    private static KiLuat instance;

    
    public static KiLuat getInstance() {
        if (instance == null) {
            instance = new KiLuat();
        }
        return instance;
    }

    
    public KiLuat() {
        this.dsKiLuat = new KiLuat[0];
    }

    
    public KiLuat[] getDanhSachKiLuat() {
        return this.dsKiLuat;
    }

   
    public void addKiLuat(KiLuat kl) {
        this.dsKiLuat = Arrays.copyOf(this.dsKiLuat, this.dsKiLuat.length + 1);
        this.dsKiLuat[this.dsKiLuat.length - 1] = kl;
    }

   
    public void removeKiLuat(String id) {
        for (int i = 0; i < this.dsKiLuat.length; i++) {
            if (this.dsKiLuat[i].getId() != null && this.dsKiLuat[i].getId().equals(id)) {
                for (int j = i; j < this.dsKiLuat.length - 1; j++) {
                    this.dsKiLuat[j] = this.dsKiLuat[j + 1];
                }
                break;
            }
        }
        this.dsKiLuat = Arrays.copyOf(this.dsKiLuat, this.dsKiLuat.length - 1);
    }

   
    public String getId() {
        return this.ID;
    }

    public void setId(String ID) {
        this.ID = ID;
    }
    
    public String getNgayKiLuat() {
        return this.ngayKiLuat;
    }

    public void setNgayKiLuat(String ngayKiLuat) {
        this.ngayKiLuat = ngayKiLuat;
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
        KiLuat manager = KiLuat.getInstance();
        Scanner scanner = new Scanner(System.in);

        
        System.out.println("Nhap so luong nhan vien bi ki luat muon them: ");
        int n = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < n; i++) {
            KiLuat kl = new KiLuat();
            System.out.println("Nhap ID: ");
            kl.setId(scanner.nextLine());
            System.out.println("Nhap ngay ky luat: ");
            kl.setNgayKiLuat(scanner.nextLine());
            System.out.println("nhap hinh thuc: ");
            kl.setHinhThuc(scanner.nextLine());    
            System.out.println("Nhap li  do: ");
            kl.setLiDo(scanner.nextLine());

            manager.addKiLuat(kl);
        }

        
        System.out.println("Danh sach ki luat sau khi nhap:");
        for (KiLuat kl : manager.getDanhSachKiLuat()) {
            System.out.println("ID: " + kl.getId() + ", Ngay ki luat: " + kl.getNgayKiLuat() + 
                               ", Hinh thuc: " + kl.getHinhThuc() + ", Ly do " + kl.getLiDo());
        }

       
        System.out.println("Nhap so luong nhan vien da bi ki luat muon xoa: ");
        int m = scanner.nextInt();
        scanner.nextLine();  

        for (int i = 0; i < m; i++) {
            System.out.println("Nhap ID cua nhan vien muon xoa: ");
            String id = scanner.nextLine();
            manager.removeKiLuat(id);
        }

        
        System.out.println("Danh sach ki luat sau khi xoa");
        for (KiLuat kl : manager.getDanhSachKiLuat()) {
            System.out.println("ID: " + kl.getId() + ", Ngay ki luat: " + kl.getNgayKiLuat() + 
                               ", Hinh thuc: " + kl.getHinhThuc() + ", Ly do: " + kl.getLiDo());
        }

        scanner.close();
    }
}
