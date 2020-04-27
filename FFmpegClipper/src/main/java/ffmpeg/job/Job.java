package ffmpeg.job;

import java.io.InputStream;
/**
 * Job classes are created for retrieving the information from the command line
 *
 * */
public abstract class Job <T>{
    abstract void runJob();
    abstract T getResult();
}
