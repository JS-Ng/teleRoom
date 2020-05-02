package ffmpeg.core.scanner;

import ffmpeg.core.FFmpeg;

import java.util.HashSet;
import java.util.Set;

public enum ClasspathScanner {
    INSTANCE;
    Set<Class<? extends FFmpeg>> clippableClasses;
    private ClasspathScanner() {
        this.clippableClasses = new HashSet<>();
    }

    public void init() {
        this.clippableClasses.clear();
    }

    public ClasspathScanner scan(String packageName) {

        return this;
    }
}
