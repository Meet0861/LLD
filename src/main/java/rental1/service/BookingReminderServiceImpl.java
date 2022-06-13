package rental1.service;

import rental1.model.account.User;
import rental1.model.common.NotificationStatus;
import rental1.model.reservation.ReservationReminder;
import rental1.model.reservation.VehicleReservation;
import rental1.repository.UserRepository;
import rental1.repository.VehicleReservationRepository;

public class BookingReminderServiceImpl implements BookingReminderService {

    VehicleReservationRepository vehicleReservationRepository = new VehicleReservationRepository();

    @Override
    public void notifyUser(ReservationReminder reservationReminder) {
        VehicleReservation vehicleReservation =
                vehicleReservationRepository.getVehicleReservation(reservationReminder.getReservationId());
        User user = UserRepository.userMap.get(vehicleReservation.getUsrId());
        System.out.println("Notified user" + user.getContact().getEmail());
        reservationReminder.setNotificationStatus(NotificationStatus.SENT);
    }
}
