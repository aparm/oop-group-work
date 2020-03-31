import java.util.ArrayList;
import java.util.Date;

public class Worker_Coffeeman extends Worker {
    public Worker_Coffeeman(String name, String password) {
        super(name, password);
    }

    @Override
    public String toString() {
        return "Barista{" + getName() + "; " + getWorkingTime() + "}";
    }

    @Override
    public ArrayList<Date> getWorkingTime() {
        return super.getWorkingTime();
    }
}
