package springmvc.core.singleton;

public class SingletonService {

    //싱글턴 패턴
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    //생성자를 private으로 생성 못하게 막음
    private SingletonService() {
    }
    
    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
