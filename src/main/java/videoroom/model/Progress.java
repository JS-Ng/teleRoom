package videoroom.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Progress {
    private long progress;

    public String getValidationCode() {
        return validationCode;
    }

    public void setValidationCode(String validationCode) {
        this.validationCode = validationCode;
    }

    @NotNull(message = "please tell me who you are")
    @NotEmpty(message = "Please adjust the progress in the video browser")
    private String validationCode;
    public long getProgress() {
        return this.progress;
    }

    public void setProgress(long progress) {
        this.progress = progress;
    }
}
