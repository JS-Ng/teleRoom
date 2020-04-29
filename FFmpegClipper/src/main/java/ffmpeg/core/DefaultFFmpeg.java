package ffmpeg.core;

import ffmpeg.probe.AbstractProbe;
import ffmpeg.probe.FFmpegProbe;

public class DefaultFFmpeg extends FFmpeg {
    private static String defaultFormat = "ismv";
    private AbstractProbe probe;
    private String fileName;
    public static DefaultFFmpeg ffmpegWithFFprobe() {
        return new DefaultFFmpeg().probe(new FFmpegProbe());
    }
    public static DefaultFFmpeg nullFFmpeg() {
        return new DefaultFFmpeg();
    }
    private DefaultFFmpeg(){}

    @Override
    public DefaultFFmpeg src(String fileName) {
        this.fileName = fileName;
        return this;
    }
    @Override
    public DefaultFFmpeg probe(AbstractProbe probe) {
        this.probe = probe;
        return this;
    }
}
