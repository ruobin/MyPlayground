package designpattern;

public class SingletonPracticeWithDoubleCheckedLocking {

    private SingletonPracticeWithDoubleCheckedLocking instance = null;

    public SingletonPracticeWithDoubleCheckedLocking getInstance() {
        if (instance == null) {
            //double-checked locking or 双重检查锁定模式
            synchronized (this) {
                if (instance == null) {
                    instance = new SingletonPracticeWithDoubleCheckedLocking();
                }
            }
        }

        return instance;
    }

    private SingletonPracticeWithDoubleCheckedLocking() {
        //default constructor
        System.out.println("constructing the instance...");
    }
}
