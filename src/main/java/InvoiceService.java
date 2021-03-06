public class InvoiceService {
    private static final int COST_PER_TIME = 1;
    private static final double MINIMU_COST_PER_KM = 10.0;
    private static final double MINIMUM_FARE = 5;
    private static final int PREMIUM_COST_PER_MINUTE = 2;
    private static final double PREMIUM_COST_PER_KM = 15;
    private static final double MINIMUM_PREMIUM_FARE = 20;

    public double calculateFare(double distance, int time) {
        double totalFare = distance * MINIMU_COST_PER_KM + time * COST_PER_TIME;
        return Math.max(totalFare, MINIMUM_FARE);

    }


    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare =0;
        for (Ride ride: rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);

        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    public double calculatePremiumFare(double distance, int time) {
        double totalFare = distance * PREMIUM_COST_PER_KM + time * PREMIUM_COST_PER_MINUTE;
        return Math.max(totalFare, MINIMUM_PREMIUM_FARE);
    }
}
