public class MyController {
    // 다이어그램만 보면 new MyServiceImpl 할 필요는 없다.
    private MyService service;

    public MyController(MyService service) {
        this.service = service;
    }

    public void hello() {
        System.out.println("hello");
    }

}
