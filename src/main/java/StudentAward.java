public class StudentAward {

    public static String checkAward(double gpa, boolean hasBelowCPlus) {

        // ===== 1. Exception handling =====
        if (gpa < 0 || gpa > 4.0) {
            throw new IllegalArgumentException("GPA khong hop le");
        }

        // ===== 2. Điều kiện loại trừ (fail-fast) =====
        if (hasBelowCPlus) {
            return "Khong dat danh hieu";
        }

        // ===== 3. Xét danh hiệu =====

        // Xuất sắc
        if (gpa >= 3.6) {
            return "Sinh vien Xuat sac";
        }

        // Giỏi
        if (gpa >= 3.2) { // không cần < 3.6 vì đã lọc ở trên
            return "Sinh vien Gioi";
        }

        // Không đạt
        return "Khong dat danh hieu";
    }
}