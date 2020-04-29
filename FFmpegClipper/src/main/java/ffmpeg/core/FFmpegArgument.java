package ffmpeg.core;

import java.util.LinkedList;
import java.util.List;
/**
 * Returns the command line argument for video clip
 * */
public class FFmpegArgument {
    private double offset;
    private final List<Arguments> arguments;
    public FFmpegArgument() {
        this.arguments = new LinkedList<>();
    }
    //TODO: add functionalities of setCopy, setStartTime, pipeTo (optional), and setEndTime
}
