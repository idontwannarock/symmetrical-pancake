package com.jhforfun.symmetricalpancake.controller.payload;

import com.jhforfun.symmetricalpancake.usecase.CommandOutput;
import com.jhforfun.symmetricalpancake.util.CommandStatus;

public class CreateProductResponse implements CommandOutput {

    private CommandStatus status;
    private String message;

    @Override
    public void setStatus(CommandStatus status) {
        this.status = status;
    }

    @Override
    public CommandStatus getStatus() {
        return status;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
