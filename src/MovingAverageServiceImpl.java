import java.util.ArrayList;
import java.util.List;

public class MovingAverageServiceImpl implements MovingAverageService{
    private List<Double> elements;
    private int subsetSize;
    private Double sum;

    public MovingAverageServiceImpl(int subsetSize) {
        if(subsetSize <= 0){
            throw new IllegalArgumentException("Subset size must be bigger than 0");
        }
        elements = new ArrayList<>();
        this.subsetSize = subsetSize;
        sum = 0d;
    }

    /**
     * Calculate the moving average by dividing the sum
     * @return
     */
    @Override
    public double getMovingAverage() {
        if (elements.size() < subsetSize){
            throw new IllegalArgumentException("Dataset is too small, please add more numbers.");
        }
        return sum / subsetSize;
    }

    /**
     * Add element to the list as well as calculate the sum of all elements in the subset
     * @param element
     */
    @Override
    public void addElement(double element) {
        elements.add(element);
        if(elements.size() <= subsetSize){
            sum += element;
        } else {
            sum += element - elements.get(elements.size()- subsetSize - 1);
        }
    }

    @Override
    public List<Double> getAllElement() {
        return elements;
    }
}
