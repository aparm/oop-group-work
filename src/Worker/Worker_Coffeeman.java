package Worker;

public class Worker_Coffeeman extends Worker {
    public Worker_Coffeeman(String name, String password) {
        super(name, password);
    }

    @Override
    public String toString() {
        return "Barista{" + getName() + "}";
    }

}
