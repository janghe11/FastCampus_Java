package net.thjang.blog;

import java.io.BufferedReader;
import java.io.InputStream;
import java.nio.Buffer;

public class WASRequest {
    private InputStream inputStream;
    private BufferedReader bufferedReader;

    public WASRequest(InputStream inputStream, BufferedReader bufferedReader) {
        this.inputStream = inputStream;
        this.bufferedReader = bufferedReader;
    }
}
