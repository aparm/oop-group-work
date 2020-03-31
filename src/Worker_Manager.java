import java.util.ArrayList;
import java.util.Date;

public class Worker_Manager extends Worker {
    public Worker_Manager(String name, String password, String type) {
        super(name, password, type);
    }

    @Override
    public String toString() {
        return "Manager{" + getName() + "; " + getType() + "; " + getWorkingTime() + "}";
    }

    @Override
    public ArrayList<Date> getWorkingTime() {
        return super.getWorkingTime();
    }
}
