import org.junit.Test;

import static org.junit.Assert.*;

public class MovingAverageServiceImplTest {

    @Test(expected = IllegalArgumentException.class)
    public void testCreateWithNegativeSubsetSize() {
        MovingAverageServiceImpl movingAverageService = new MovingAverageServiceImpl(-2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateWithZeroSubsetSize() {
        MovingAverageServiceImpl movingAverageService = new MovingAverageServiceImpl(0);
    }

    @Test
    public void testAddElementsToList() {
        MovingAverageServiceImpl movingAverageService = new MovingAverageServiceImpl(1);
        movingAverageService.addElement(1d);
        assertEquals(1, movingAverageService.getAllElement().size());
        movingAverageService.addElement(3d);
        movingAverageService.addElement(5d);
        assertEquals(3, movingAverageService.getAllElement().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetMovingAverageWithNotEnoughElements() {
        MovingAverageServiceImpl movingAverageService = new MovingAverageServiceImpl(3);
        movingAverageService.addElement(1d);
        movingAverageService.getMovingAverage();
    }

    @Test
    public void testGetMovingAverageWithEnoughElements() {
        MovingAverageServiceImpl movingAverageService = new MovingAverageServiceImpl(2);
        movingAverageService.addElement(-1d);
        movingAverageService.addElement(3.88);
        assertEquals(1.44, movingAverageService.getMovingAverage(), 0);
        movingAverageService.addElement(5.54);
        movingAverageService.addElement(7.56);
        assertEquals(6.55, movingAverageService.getMovingAverage(), 0);
        movingAverageService.addElement(11.39);
        movingAverageService.addElement(-13.39);
        assertEquals(-1, movingAverageService.getMovingAverage(), 0);
    }

    @Test
    public void testGetAllElements() {
        MovingAverageServiceImpl movingAverageService = new MovingAverageServiceImpl(5);
        double firstElement = 1.11;
        double secondElement = 2.22;
        double thirdElement = 3.33;
        movingAverageService.addElement(firstElement);
        movingAverageService.addElement(secondElement);
        movingAverageService.addElement(thirdElement);
        assertEquals(firstElement, movingAverageService.getAllElement().get(0), 0);
        assertEquals(secondElement, movingAverageService.getAllElement().get(1), 0);
        assertEquals(thirdElement, movingAverageService.getAllElement().get(2), 0);
    }
}