package rental1.service;

import rental1.model.account.User;
import rental1.model.common.NotificationStatus;
import rental1.model.reservation.InvoiceNotification;
import rental1.model.reservation.VehicleReservation;
import rental1.repository.UserRepository;
import rental1.repository.VehicleReservationRepository;

public class InvoiceNotificationServiceImpl implements InvoiceNotificationService {

    public void notifyUser(InvoiceNotification invoiceNotification) {
        VehicleReservation vehicleReservation = VehicleReservationRepository.vehicleReservationMap
                .get(invoiceNotification.getReservationId());
        User user = UserRepository.userUserIdMap.get(vehicleReservation.getUsrId());
        System.out.println("Notification sent " + user.getContact().getEmail());
        invoiceNotification.setNotificationStatus(NotificationStatus.SENT);
    }
}
