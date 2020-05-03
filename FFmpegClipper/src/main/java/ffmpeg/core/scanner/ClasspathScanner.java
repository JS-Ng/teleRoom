package ffmpeg.core.scanner;

import ffmpeg.core.FFmpeg;
import ffmpeg.core.annotations.Clippable;
import org.reflections.Reflections;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

public enum ClasspathScanner {
    INSTANCE;
    Set<Class<? extends FFmpeg>> clippableClasses;
    private ClasspathScanner() {
        this.clippableClasses = new HashSet<>();
    }

    public void init() {
        this.clippableClasses.clear();
    }
    @SuppressWarnings("unchecked")
    public ClasspathScanner scanClippable(String packageName) {
        Reflections ref = new Reflections(packageName);
        for (Class<?> klass : ref.getTypesAnnotatedWith(Clippable.class)) {
            clippableClasses.add((Class<? extends FFmpeg>) klass);
        }
        return this;
    }

    public int size() {
        return this.clippableClasses.size();
    }
    public boolean checkName(String name) {
        for (Class<? extends FFmpeg> klass: this.clippableClasses) {
            if (klass.getName().equals(name)) return true;
        }

        return false;
    }
}
