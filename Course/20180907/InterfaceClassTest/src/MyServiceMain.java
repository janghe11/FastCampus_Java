public class MyServiceMain {
    public static void main(String[] args){
//        MyDAOImpl myDAO = new MyDAOImpl();
//        MyServiceImpl myService = new MyServiceImpl(myDAO);
        MyController controller = new MyController(new MyServiceImpl(new MyDAOImpl()));

        controller.hello();
    }
}
