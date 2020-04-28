package ffmpeg.util;

import java.util.Arrays;

public class ArrayUtils {
    public static <T> T[] concat(T[] a1, T[] a2) {
        T[] extended = Arrays.copyOf(a1, a1.length + a2.length);
        System.arraycopy(a2, 0, extended, a1.length, a2.length);
        return extended;
    }
}
