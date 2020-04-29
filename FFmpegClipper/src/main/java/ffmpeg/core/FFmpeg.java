package ffmpeg.core;

import ffmpeg.probe.AbstractProbe;
import ffmpeg.probe.FFmpegProbe;
/**
 * Core class. the java interface of ffmpeg
 * */
public abstract class FFmpeg {

    public abstract FFmpeg src(String fileName);

    public abstract FFmpeg probe(AbstractProbe probe);
}
