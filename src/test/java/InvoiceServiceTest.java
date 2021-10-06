import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InvoiceServiceTest {
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        InvoiceService invoiceService = new InvoiceService();
        double distance = 2.0;
        int time = 5;
        double fare = invoiceService.calculateFare(distance, time);
        Assertions.assertEquals(25, fare,0.0);

    }
    @Test
    public void givenLessDistanceOrTime_ShouldReturnMinimumFare() {
        InvoiceService invoiceService = new InvoiceService();
        double distance = 0.1;
        int time = 1;
        double fare = invoiceService.calculateFare(distance, time);
        Assertions.assertEquals(5, fare,0.0);

    }
//    @Test
//    public void shouldNowTakeInMultipleRide_CalculateAggregateTotal() {
//        InvoiceService invoiceService= new InvoiceService();
//        invoiceService.multipleRidesWithAggregateTotal();
//    }

    @Test
    public void givenMultipleRides_ShouldsReturnTotalFare() {
        InvoiceService invoiceService = new InvoiceService();
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        double fare = invoiceService.calculateFare(rides);
        Assertions.assertEquals(30, fare,0.0);

    }
}
