package Worker;

public class Worker_Manager extends Worker {
    public Worker_Manager(String name, String password) {
        super(name, password);
    }

    @Override
    public String toString() {
        return "Mänadžer{" + getName() + "}";
    }

}
