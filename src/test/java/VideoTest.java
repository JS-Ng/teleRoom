import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import videoroom.video.Video;
import videoroom.video.VideoPlayer;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class VideoTest {
    Logger logger = LogManager.getLogger(VideoTest.class);
    @Before
    public void showLog() {
        logger.info("current directory: " + System.getProperty("user.dir"));
    }
    @Test
    public void testAvailable() {
        Video video = new Video("");
        assertFalse(video.available());
    }

    @Test
    public void testLength () throws IOException, NoSuchFieldException, IllegalAccessException {
        Video video = new Video("");
        RandomAccessFile mockedFile = Mockito.mock(RandomAccessFile.class);
        Mockito.when(mockedFile.length()).thenReturn(5L);
        Field dataField = video.getClass().getDeclaredField("data");
        dataField.setAccessible(true);
        dataField.set(video, mockedFile);
        assertEquals(5, video.length());
    }

    @Test
    public void testPlayer() {
        VideoPlayer player = new VideoPlayer("??/");
        VideoPlayer.VideoData data = player.play();
        assertFalse(data.available());
    }

    @Test
    public void testProgress() {
        VideoPlayer player = new VideoPlayer();
        assertEquals(0L, player.showProgress());
    }
}
