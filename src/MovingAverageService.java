import java.util.List;

public interface MovingAverageService {
    double getMovingAverage();

    void addElement(double element);

    List<Double> getAllElement();
}
