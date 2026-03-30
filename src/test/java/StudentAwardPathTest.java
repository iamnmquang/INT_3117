import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentAwardPathTest {

    // ===== Path 1: 1 → 2 → 3 → 9 (Exception) =====
    @Test
    void testPath1_Exception() {
        assertThrows(IllegalArgumentException.class, () -> {
            StudentAward.checkAward(-1, false);
        });
    }

    // ===== Path 2: 1 → 2 → 4 → 5 → 9 (Xuất sắc) =====
    @Test
    void testPath2_XuatSac() {
        String result = StudentAward.checkAward(3.8, false);
        assertEquals("Sinh vien Xuat sac", result);
    }

    // ===== Path 3: 1 → 2 → 4 → 6 → 7 → 9 (Giỏi) =====
    @Test
    void testPath3_Gioi() {
        String result = StudentAward.checkAward(3.4, false);
        assertEquals("Sinh vien Gioi", result);
    }

    // ===== Path 4: 1 → 2 → 4 → 6 → 8 → 9 (Không đạt) =====
    @Test
    void testPath4_KhongDat() {
        String result = StudentAward.checkAward(3.4, true);
        assertEquals("Khong dat danh hieu", result);
    }
}