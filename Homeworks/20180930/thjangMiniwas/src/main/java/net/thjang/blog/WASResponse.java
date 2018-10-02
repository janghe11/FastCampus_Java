package net.thjang.blog;

import java.io.OutputStream;
import java.io.PrintWriter;

public class WASResponse {
    private OutputStream outputStream;
    private PrintWriter printWriter;

    public WASResponse(OutputStream outputStream, PrintWriter printWriter) {
        this.outputStream = outputStream;
        this.printWriter = printWriter;
    }
}
