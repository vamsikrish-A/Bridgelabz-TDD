public class InvoiceService {
    private static final int COST_PER_TIME = 1;
    private static final double MINIMU_COST_PER_KM = 10.0;
<<<<<<< HEAD
    private static final double MINIMU_FARE = 5;

    public double calculateFare(double distance, int time) {
        double totalFare = distance * MINIMU_COST_PER_KM + time * COST_PER_TIME;
        if (totalFare < MINIMU_FARE)
            return MINIMU_FARE;
=======
    private static final double MINIMUM_FARE = 5;

    public double calculateFare(double distance, int time) {
        double totalFare = distance * MINIMU_COST_PER_KM + time * COST_PER_TIME;
        return Math.max(totalFare,MINIMUM_FARE);
    }

    public double calculateFare(Ride[] rides) {
        double totalFare =0;
        for (Ride ride: rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);

        }
>>>>>>> step_2
        return totalFare;
    }
}
