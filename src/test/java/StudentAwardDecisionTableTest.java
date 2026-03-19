import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentAwardDecisionTableTest {

    // ===== R1: GPA > 4.0 → Exception =====
    @Test
    void testR1_GPA_LonHon4() {
        assertThrows(IllegalArgumentException.class, () -> {
            StudentAward.checkAward(4.1, false);
        });
    }

    // ===== R2: Xuất sắc =====
    @Test
    void testR2_XuatSac() {
        String result = StudentAward.checkAward(3.8, false);
        assertEquals("Sinh vien Xuat sac", result);
    }

    // ===== R3: Giỏi =====
    @Test
    void testR3_Gioi() {
        String result = StudentAward.checkAward(3.3, false);
        assertEquals("Sinh vien Gioi", result);
    }

    // ===== R4: Không đạt (GPA thấp) =====
    @Test
    void testR4_KhongDat_DoGPA() {
        String result = StudentAward.checkAward(3.0, false);
        assertEquals("Khong dat danh hieu", result);
    }

    // ===== R5: GPA < 0 → Exception =====
    @Test
    void testR5_GPA_Am() {
        assertThrows(IllegalArgumentException.class, () -> {
            StudentAward.checkAward(-1.0, false);
        });
    }

    // ===== R6: GPA > 4 + fail môn → Exception =====
    @Test
    void testR6_GPA_LonHon4_VaFailMon() {
        assertThrows(IllegalArgumentException.class, () -> {
            StudentAward.checkAward(4.5, true);
        });
    }

    // ===== R7: Xuất sắc nhưng fail môn =====
    @Test
    void testR7_XuatSac_NhungFailMon() {
        String result = StudentAward.checkAward(3.7, true);
        assertEquals("Khong dat danh hieu", result);
    }

    // ===== R8: Giỏi nhưng fail môn =====
    @Test
    void testR8_Gioi_NhungFailMon() {
        String result = StudentAward.checkAward(3.4, true);
        assertEquals("Khong dat danh hieu", result);
    }

    // ===== R9: GPA thấp + fail môn =====
    @Test
    void testR9_GPAThap_VaFailMon() {
        String result = StudentAward.checkAward(3.0, true);
        assertEquals("Khong dat danh hieu", result);
    }

    // ===== R10: GPA < 0 + fail môn → Exception =====
    @Test
    void testR10_GPAAm_VaFailMon() {
        assertThrows(IllegalArgumentException.class, () -> {
            StudentAward.checkAward(-2.0, true);
        });
    }
}