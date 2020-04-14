public class Main {

    public static void main(String[] args) {
        MovingAverageServiceImpl movingAverageService = new MovingAverageServiceImpl(2);
        movingAverageService.addElement(-1d);
        movingAverageService.addElement(3d);
        System.out.println(movingAverageService.getMovingAverage());
        movingAverageService.addElement(5d);
        movingAverageService.addElement(7d);
        System.out.println(movingAverageService.getMovingAverage());
        movingAverageService.addElement(11d);
        movingAverageService.addElement(-13d);
        System.out.println(movingAverageService.getMovingAverage());
        movingAverageService.getAllElement().stream().forEach(element -> System.out.print(element + " "));
    }
}
