package rental1.service;

import rental1.model.reservation.Invoice;
import rental1.model.reservation.VehicleReservation;

public interface InvoiceService {
    Invoice computeInvoice(VehicleReservation vehicleReservation);
}
