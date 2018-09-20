package my.examples.was;

import java.util.HashMap;

public class WasRequest{
    private HashMap<String, String> headerInfo = new HashMap<String, String>();

    public WasRequest(HashMap<String, String> headerInfo){
        this.headerInfo = headerInfo;
    }

}
