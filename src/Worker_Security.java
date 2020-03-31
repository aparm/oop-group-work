import java.util.ArrayList;
import java.util.Date;

public class Worker_Security extends Worker {
    public Worker_Security(String name, String password) {
        super(name, password);
    }

    @Override
    public String toString() {
        return "Security{" + getName() + "; " + getWorkingTime() + "}";
    }

    @Override
    public ArrayList<Date> getWorkingTime() {
        return super.getWorkingTime();
    }
}
