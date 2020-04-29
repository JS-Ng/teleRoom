package ffmpeg.core;

import ffmpeg.probe.FFmpegProbe;

public class FFmpeg {
    private FFmpegProbe probe;
    private String fileName;
    public FFmpeg(String fileName) {
        this.fileName = fileName;
    }
    public FFmpeg() {}
}
