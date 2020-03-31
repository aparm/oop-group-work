import java.util.ArrayList;
import java.util.Date;

public class Worker_Coffeeman extends Worker {
    public Worker_Coffeeman(String name, String password, String type) {
        super(name, password, type);
    }

    @Override
    public String toString() {
        return "Coffeeman{" + getName() + "; " + getType() + "; " + getWorkingTime() + "}";
    }

    @Override
    public ArrayList<Date> getWorkingTime() {
        return super.getWorkingTime();
    }
}
