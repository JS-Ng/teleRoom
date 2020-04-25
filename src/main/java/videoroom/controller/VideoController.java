package videoroom.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import videoroom.model.Progress;
import videoroom.model.Status;
import videoroom.video.VideoPlayer;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.InputStream;
@Validated
@RestController
public class VideoController {
    Logger logger = LogManager.getLogger();
    @Autowired
    private Status successStatus;
    @Autowired
    private VideoPlayer myplayer;
    @RequestMapping("video/live")
    public ResponseEntity<InputStreamResource> live(HttpServletRequest req) {
        logger.info("Ip: " + req.getRemoteAddr() + " is requesting for video...");

        VideoPlayer.VideoData playData = myplayer.play();
        if (playData.available()) {
            logger.info("Video serving, length: " + playData.getLength());
            return ResponseEntity.ok().contentLength(playData.getLength()).
                    contentType(MediaType.parseMediaType("application/octet-stream")).
                    body(playData.getResource());
        }

        // can also be replaced with InputStream.nullInputStream() if not available
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(new InputStreamResource(new InputStream() {
            @Override
            public int read() {
                return -1;
            }
        }));
    }
    @RequestMapping(path="video/progress",
            method = {RequestMethod.POST},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Status changeProgress(@Valid @RequestBody Progress progress, HttpServletRequest req) {
        logger.info("ip: " + req.getRemoteAddr() + " is try to change the progress to : " + progress.getProgress());
        myplayer.select(progress.getProgress());
        // TODO: add identity check
        return successStatus;
    }
}
