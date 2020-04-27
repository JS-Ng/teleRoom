package ffmpeg.job;

import java.io.InputStream;

// this is a job
public class CommandLineJob extends Job<InputStream>{
    private String command;
    public CommandLineJob(String command) {
        this.command = command;
    }
    public void runJob() {
    }
    @Override
    public InputStream getResult() {
        return InputStream.nullInputStream();
    }
}
