import ffmpeg.core.scanner.ClasspathScanner;
import org.junit.Assert;
import org.junit.Test;

public class ScannerTest {
    @Test
    public void testScanner() {
        ClasspathScanner scanner = ClasspathScanner.INSTANCE;
        scanner.init();
        scanner.scanClippable("packageSlime");
        Assert.assertEquals(1, scanner.size());
        Assert.assertTrue(scanner.checkName("packageSlime.FFtest"));
    }
}
