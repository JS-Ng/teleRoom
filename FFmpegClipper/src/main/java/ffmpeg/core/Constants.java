package ffmpeg.core;

public enum Constants {
    FFMPEG(new Arguments<String>("ffmpeg")),
    CLIP_START(new Arguments<Double>("-ss")),
    CLIP_END(new Arguments<Double>("-t")),
    INPUT_FILE(new Arguments<String>("-i")),
    CLIP_COPY(new Arguments<String>("-c copy")),
    PURE_ARGS(new Arguments<>("")); // this is pure object for only adding the arguments
    Constants(Arguments arg) {
        this.arg = arg;
    }

    private Arguments arg;
    public Arguments getArg() {
        // extremely thread-safe
        return new Arguments<>(this.arg);
    }


}
