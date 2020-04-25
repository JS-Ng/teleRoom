package videoroom.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import videoroom.model.Status;
import videoroom.video.Video;
import videoroom.video.VideoPlayer;

@Configuration
public class VideoBeans {
    @Autowired
    private ApplicationContext ctx;
    @Bean
    public VideoPlayer myPlayer() {
        return new VideoPlayer();
    }
    @Bean
    public Status successStatus() {
        Status status = new Status();
        status.setStatus(true);
        return status;
    }
}
