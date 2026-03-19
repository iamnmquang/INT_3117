import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class StudentAwardBoundaryTest {

    // ===== TEST hasBelowCPlus = false =====
    @ParameterizedTest
    @CsvSource({
            "-0.1, false, EXCEPTION",
            "0.0, false, Khong dat danh hieu",
            "0.1, false, Khong dat danh hieu",
            "3.0, false, Khong dat danh hieu",
            "3.1, false, Khong dat danh hieu",
            "3.2, false, Sinh vien Gioi",
            "3.3, false, Sinh vien Gioi",
            "3.4, false, Sinh vien Gioi",
            "3.5, false, Sinh vien Gioi",
            "3.6, false, Sinh vien Xuat sac",
            "3.7, false, Sinh vien Xuat sac",
            "3.8, false, Sinh vien Xuat sac",
            "3.9, false, Sinh vien Xuat sac",
            "4.0, false, Sinh vien Xuat sac",
            "4.1, false, EXCEPTION"
    })
    void testBoundary_False(double gpa, boolean hasBelowCPlus, String expected) {

        if (expected.equals("EXCEPTION")) {
            assertThrows(IllegalArgumentException.class,
                    () -> StudentAward.checkAward(gpa, hasBelowCPlus));
        } else {
            assertEquals(expected,
                    StudentAward.checkAward(gpa, hasBelowCPlus));
        }
    }

    // ===== TEST hasBelowCPlus = true =====
    @ParameterizedTest
    @CsvSource({
            "-0.1, true, EXCEPTION",
            "0.0, true, Khong dat danh hieu",
            "0.1, true, Khong dat danh hieu",
            "3.0, true, Khong dat danh hieu",
            "3.1, true, Khong dat danh hieu",
            "3.2, true, Khong dat danh hieu",
            "3.3, true, Khong dat danh hieu",
            "3.4, true, Khong dat danh hieu",
            "3.5, true, Khong dat danh hieu",
            "3.6, true, Khong dat danh hieu",
            "3.7, true, Khong dat danh hieu",
            "3.8, true, Khong dat danh hieu",
            "3.9, true, Khong dat danh hieu",
            "4.0, true, Khong dat danh hieu",
            "4.1, true, EXCEPTION"
    })
    void testBoundary_True(double gpa, boolean hasBelowCPlus, String expected) {

        if (expected.equals("EXCEPTION")) {
            assertThrows(IllegalArgumentException.class,
                    () -> StudentAward.checkAward(gpa, hasBelowCPlus));
        } else {
            assertEquals(expected,
                    StudentAward.checkAward(gpa, hasBelowCPlus));
        }
    }
}