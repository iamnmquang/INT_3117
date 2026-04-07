import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentAwardTest {

    // ===== TC1: (-1, false) → Exception =====
    @Test
    void TC1_invalidGPA() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            StudentAward.checkAward(-1, false);
        });

        assertEquals("GPA khong hop le", exception.getMessage());
    }

    // ===== TC2: (3.8, false) → Xuất sắc =====
    @Test
    void TC2_xuatSac() {
        String result = StudentAward.checkAward(3.8, false);
        assertEquals("Sinh vien Xuat sac", result);
    }

    // ===== TC3: (3.4, false) → Giỏi =====
    @Test
    void TC3_gioi() {
        String result = StudentAward.checkAward(3.4, false);
        assertEquals("Sinh vien Gioi", result);
    }

    // ===== TC4: (3.4, true) → Không đạt =====
    @Test
    void TC4_khongDat() {
        String result = StudentAward.checkAward(3.4, true);
        assertEquals("Khong dat danh hieu", result);
    }
}