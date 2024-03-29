package hello.core.singleton;

public class SingletonService {

    // static 영역에 객체 instance를 미리 하나 생성해서 올려둔다.
    private static final SingletonService instance = new SingletonService();

    // public 으로 열어서 객체 인스턴스가 필요하면 이 static 메서드를 통해서만 조회하도록 허용.
    public static SingletonService getInstance() {
        return instance;
    }

    // private 으로 생성자를 선언해서 외부에서(다른 클래스, 패키지) new 키워드를 사용한 객체 생성을 못하게 막음.
    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
