package videoroom.video;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.io.InputStreamResource;

import java.util.concurrent.atomic.AtomicLong;

public class VideoPlayer {
    private static Logger logger = LogManager.getLogger();
    public static class VideoData implements Checkable {
        private long length;
        private InputStreamResource resource;
        private boolean isAvail = false;
        private VideoData(long length, InputStreamResource resource, boolean isAvail) {
            this.length = length;
            this.resource = resource;
            this.isAvail = isAvail;
        }

        public long getLength() {
            return this.length;
        }

        public InputStreamResource getResource() {
            return this.resource;
        }

        @Override
        public boolean available() {
            return this.isAvail;
        }
    }
    private static String LIVE_NAME = "target.mp4";
    private AtomicLong progress = new AtomicLong(0);
    public VideoData play() {
        Video cur_video = new Video(this.fileName);
        if (cur_video.available() && !cur_video.jump(this.progress.get())) {
            logger.info("Replaying the video due to the invalid progress setting");
            this.progress.set(0L);
            cur_video.jump(0); // replay if the progress if not availble
        }
        VideoData data = new VideoData(cur_video.available() ? cur_video.length() : 0, cur_video.available() ? new InputStreamResource(cur_video.stream()) : null, cur_video.available());
        return data;
    }
    private String fileName;
    public VideoPlayer() {
        this.fileName = LIVE_NAME;
        this.progress.set(0L);
    }
    public VideoPlayer(String filename) {
        this.progress.set(0L);
        this.fileName = filename;
    }

    public synchronized VideoData select(long progress) {
        this.progress.set(progress);
        return this.play();
    }

    public long showProgress() {
        return this.progress.get();
    }
}
