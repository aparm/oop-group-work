import java.util.ArrayList;
import java.util.Date;

public class Worker_Manager extends Worker {
    public Worker_Manager(String name, String password) {
        super(name, password);
    }

    @Override
    public String toString() {
        return "Manager{" + getName() + "; " + getWorkingTime() + "}";
    }

    @Override
    public ArrayList<Date> getWorkingTime() {
        return super.getWorkingTime();
    }
}
