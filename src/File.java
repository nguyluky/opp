import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class DocFileNIOByLines {
    public static void main(String[] args) {
        // Danh sách các file
        String[] fileNames = {
            "QuanLiNhanSu.txt",
            "QuanLiNhanVien.txt",
            "QuanLiDuAn.txt",
            "QuanLiPhongBan.txt"
        };

        // Hiển thị danh sách file để người dùng chọn
        System.out.println("Danh sách các file:");
        for (int i = 0; i < fileNames.length; i++) {
            System.out.println((i + 1) + ". " + fileNames[i]);
        }

        // Nhập lựa chọn từ bàn phím
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số thứ tự file bạn muốn đọc (1-4): ");
        int choice = scanner.nextInt();

        // Kiểm tra lựa chọn hợp lệ
        if (choice < 1 || choice > fileNames.length) {
            System.out.println("Lựa chọn không hợp lệ!");
        } else {
            String selectedFile = fileNames[choice - 1];
            System.out.println("Bạn đã chọn file: " + selectedFile);

            // Đọc nội dung file được chọn
            try {
                List<String> lines = Files.readAllLines(Paths.get(selectedFile));
                System.out.println("Nội dung file " + selectedFile + ":");
                for (String line : lines) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.err.println("Lỗi khi đọc file " + selectedFile + ": " + e.getMessage());
            }
        }

        scanner.close();
    }
}
