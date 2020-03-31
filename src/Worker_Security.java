import java.util.ArrayList;
import java.util.Date;

public class Worker_Security extends Worker {
    public Worker_Security(String name, String password, String type) {
        super(name, password, type);
    }

    @Override
    public String toString() {
        return "Security{" + getName() + "; " + getType() + "; " + getWorkingTime() + "}";
    }

    @Override
    public ArrayList<Date> getWorkingTime() {
        return super.getWorkingTime();
    }
}
