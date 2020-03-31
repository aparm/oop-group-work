import java.util.ArrayList;
import java.util.Date;

public class Worker_Worker extends Worker {
    public Worker_Worker(String name, String password) {
        super(name, password);
    }

    @Override
    public String toString() {
        return "Worker{" + getName() + "; " + getWorkingTime() + "}";
    }

    @Override
    public ArrayList<Date> getWorkingTime() {
        return super.getWorkingTime();
    }
}
