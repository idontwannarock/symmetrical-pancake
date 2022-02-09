package com.jandh.symmetricalpancake.usecase;

import com.jandh.symmetricalpancake.util.CommandStatus;

public interface CommandOutput {

    void setStatus(CommandStatus status);
    CommandStatus getStatus();
    void setMessage(String message);
    String getMessage();
}
