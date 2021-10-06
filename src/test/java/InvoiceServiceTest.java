import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

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

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        InvoiceService invoiceService = new InvoiceService();
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        InvoiceSummary summary = invoiceService.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assertions.assertEquals(expectedInvoiceSummary,summary);
    }

    @Test
    public void getsTheListOfRides_UsingUserID() {
        InvoiceService invoiceService = new InvoiceService();
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        InvoiceSummary summary = invoiceService.calculateFare(rides);
        InvoiceSummary id = new InvoiceSummary(2, 30.0);
        id.setUserId(1, summary);
        Map<Integer, InvoiceSummary> userID = new HashMap<>();
        for (Map.Entry<Integer, InvoiceSummary> integerInvoiceSummaryEntry : userID.entrySet()) {
            integerInvoiceSummaryEntry.getValue();
        }

        Assertions.assertEquals(userID, id.getUserId());
    }
    @Test
    public void givesPremiumRates_ShouldReturnTotalFare() {
        InvoiceService invoiceService = new InvoiceService();
        double distance = 2.0;
        int time = 5;
        double premiumFare = invoiceService.calculatePremiumFare(distance, time);
        Assertions.assertEquals(40, premiumFare,0.0);
    }
    @Test
    public void givesPremiumRates_ShouldReturnMinimumFare() {
        InvoiceService invoiceService = new InvoiceService();
        double distance = 0.1;
        int time = 2;
        double premiumFare = invoiceService.calculatePremiumFare(distance, time);
        Assertions.assertEquals(20, premiumFare,0.0);
    }
}
