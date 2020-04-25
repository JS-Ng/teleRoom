package videoroom.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import videoroom.video.VideoPlayer;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;

@RestController
public class VideoController {
    Logger logger = LogManager.getLogger();
    @Autowired
    private VideoPlayer myplayer;
    @RequestMapping("video/live")
    public ResponseEntity<InputStreamResource> live(HttpServletRequest req) {
        logger.info("Ip: " + req.getRemoteAddr() + " is requesting for video...");

        VideoPlayer.VideoData playData = myplayer.play();
        if (playData.available())
            return ResponseEntity.ok().contentLength(playData.getLength()).
                    contentType(MediaType.parseMediaType("application/octet-stream")).
                    body(playData.getResource());

        // can also be replaced with InputStream.nullInputStream() if not available
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(new InputStreamResource(new InputStream() {
            @Override
            public int read() {
                return -1;
            }
        }));
    }
}
