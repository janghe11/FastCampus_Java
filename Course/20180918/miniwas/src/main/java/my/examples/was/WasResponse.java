package my.examples.was;

import java.io.OutputStream;
import java.io.PrintWriter;

public class WasResponse {
    private OutputStream outputStream;
    private PrintWriter printWriter;

    public WasResponse(OutputStream outputStream, PrintWriter printWriter) {
        this.outputStream = outputStream;
        this.printWriter = printWriter;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }

    public PrintWriter getPrintWriter() {
        return printWriter;
    }
}
