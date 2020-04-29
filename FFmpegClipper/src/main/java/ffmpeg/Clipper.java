package ffmpeg;

import ffmpeg.core.FFmpeg;
import ffmpeg.core.Main;

import java.io.InputStream;

/**
 * Utility class used to clip the video
 * Entry class for the whole ffmpeg tool
 * */
public abstract class Clipper {
    protected FFmpeg ffmpeg; // ffmpeg resource
    /**
     * get Result after we click start()
     * */
    public InputStream getResult() {
        return InputStream.nullInputStream();
    }
    /**
     * Entry function, this basically performs behavior defined in @main annotated function
     * */
    public void start() {}
}
