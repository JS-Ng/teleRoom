package videoroom.video;

import org.springframework.core.io.InputStreamResource;

public class VideoPlayer {
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
    private double progress;
    public VideoData play() {
        Video cur_video = new Video(this.fileName);
        if (cur_video.available())
            cur_video.jump(calculateProgress(this.progress));
        VideoData data = new VideoData(cur_video.available() ? cur_video.length() : 0, cur_video.available() ? new InputStreamResource(cur_video.stream()) : null, cur_video.available());
        return data;
    }
    private String fileName;
    public VideoPlayer() {
        this.fileName = LIVE_NAME;
        this.progress = 0.0;
    }
    public VideoPlayer(String filename) {
        this.progress = 0.0;
        this.fileName = filename;
    }
    private long calculateProgress(double progress) {
        // TODO: calculate the progress according to file attributes
        return 0;
    }

    public synchronized VideoData select(double progress) {
        this.progress = progress;
        return this.play();
    }

    public double showProgress() {
        return progress;
    }
}
