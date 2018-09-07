public class MyServiceImpl implements MyService {
    private MyDAO dao;

    public MyServiceImpl(MyDAO dao){
        this.dao = dao;
    }

    @Override
    public void hi() {
        System.out.println("hi");
    }

}
