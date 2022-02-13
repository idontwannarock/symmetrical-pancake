package com.jhforfun.symmetricalpancake.usecase;

import com.jhforfun.symmetricalpancake.util.CommandStatus;

public interface CommandOutput {

    void setStatus(CommandStatus status);
    CommandStatus getStatus();
    void setMessage(String message);
    String getMessage();
}
