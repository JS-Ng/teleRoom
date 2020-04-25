package videoroom.video;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.channels.Channels;

public class Video implements Checkable {
    private static final Logger logger = LogManager.getLogger();
    private boolean isReady = false; // if the video is ready
    protected RandomAccessFile data;
    public Video(String fileName) {
        setUp(fileName);
    }

    public Video(File file) {
        setUp(file.getAbsolutePath());
    }

    public void setUp(String path) {
        try {
            this.data = new RandomAccessFile(path, "r");
            this.isReady = true;
        } catch (FileNotFoundException e) {
            logger.warn("THERE'S NO VIDEO STREAM AVAILABLE YET IN THE SERVER");
            this.isReady = false;
        }
        if (isReady) {
            logger.info("Video smoothly loaded into the server!");
        }
    }
    // check if there's video available
    @Override
    public boolean available() {
        return this.isReady;
    }

    public InputStream stream() {
        return Channels.newInputStream(this.data.getChannel());
    }

    public boolean jump(long pos) {
        try {
            this.data.seek(pos);
        }

        catch (IOException e) {
            logger.warn("The capacity of the live stream isn't enough to hold your step!");
            return false;
        }

        return true;
    }

    public long length() {
        try {
            return this.data.length();
        }

        catch (IOException e) {
            return -1;
        }
    }
}
