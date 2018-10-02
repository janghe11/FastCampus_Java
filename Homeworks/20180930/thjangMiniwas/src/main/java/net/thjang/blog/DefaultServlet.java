package net.thjang.blog;

public class DefaultServlet {
    private WASRequest wasRequest;
    private WASResponse wasResponse;

    public DefaultServlet() {
    }

    public void service(WASRequest wasRequest, WASResponse wasResponse) {
        this.wasRequest = wasRequest;
        this.wasResponse = wasResponse;
    }

}
