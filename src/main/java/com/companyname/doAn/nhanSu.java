import java.util.Scanner;

public abstract class nhanSu {
    private String id;
    private String name;
    private String phone;
    private String diaChi;
    private int namVaolam;
    private String heSothidua;


    public static Scanner sc = new Scanner(System.in);

    abstract double bonusMoneyhesothidua();
    abstract double bonusChucvu();
    abstract double tienLuong();
    abstract double luongCoban();

    public nhanSu() {
    }

    public nhanSu(String id, String name, String phone, String diaChi, int namVaolam) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.diaChi = diaChi;
        this.namVaolam = namVaolam;
    }

    public String getHeSothidua() {
        return heSothidua;
    }

    public void setHeSothidua(String heSothidua) {
        while(true){
            if(heSothidua.equals("A") || heSothidua.equals("B") || heSothidua.equals("C") || heSothidua.equals("D") || heSothidua.equals("E") || heSothidua.equals("F")){
                this.heSothidua = heSothidua;
                break;
            }else{
                System.out.println("Khong hop le !!!!");
                heSothidua = sc.nextLine();
            }
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getNamVaolam() {
        return namVaolam;
    }

    public void setNamVaolam(int namVaolam) {
        this.namVaolam = namVaolam;
    }


    public void nhap(){
        System.out.println("Ma nhan su : ");
        setId(sc.nextLine());
        System.out.println("Ten nhan su :");
        setName(sc.nextLine());
        System.out.println("Dia chi :");
        setDiaChi(sc.nextLine());
        System.out.println("So dien thoai :");
        setPhone(sc.nextLine());
        System.out.println("Nam vao lam :");
        setNamVaolam(Integer.parseInt(sc.nextLine()));
        System.out.println("He so thi dua :");
        setHeSothidua(sc.nextLine());
    }

    @Override
    public String toString() {
        return "Nhan su :\n" +
                "ID : " + this.getId() + "\t\tTen : " +this.getName() +
                "\t\tDia chi : " + this.getDiaChi() +"\t\tSo dien thoai : " + this.getPhone() +
                "\t\tNam vao lam : " + this.getNamVaolam();
    }
    public void xuat(){
        System.out.println(toString());
    }
}
