package videoroom.video;

import org.springframework.core.io.InputStreamResource;

public class VideoPlayer implements Checkable {
    private static String LIVE_NAME = "target.mp4";
    private Video video;
    private double progress;
    public InputStreamResource play() {
        return new InputStreamResource(video.stream());
    }

    public VideoPlayer() {
        loadVideo(new Video(LIVE_NAME));
        this.progress = 0.0;
    }
    public VideoPlayer(String filename) {
        loadVideo(new Video(filename));
        this.progress = 0.0;
    }
    private long calculateProgress(double progress) {
        // TODO: calculate the progress according to file attributes
        return 0;
    }

    public synchronized void loadVideo(Video video) {
        this.video = video;
    }

    public synchronized InputStreamResource select(double progress) {
        this.progress = progress;
        this.video.jump(calculateProgress(this.progress));
        return this.play();
    }

    public double showProgress() {
        return progress;
    }

    @Override
    public boolean available() {
        return this.video.available();
    }

    public Video rawVideo() {
        return this.video;
    }
}
