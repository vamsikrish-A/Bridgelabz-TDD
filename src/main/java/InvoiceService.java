public class InvoiceService {
    private static final int COST_PER_TIME = 1;
    private static final double MINIMU_COST_PER_KM = 10.0;

    public double calculateFare(double distance, int time) {
        return distance * MINIMU_COST_PER_KM + time * COST_PER_TIME;
    }
}
