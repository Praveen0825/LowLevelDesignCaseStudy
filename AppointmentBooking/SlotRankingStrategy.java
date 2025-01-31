package AppointmentBooking;

import java.util.List;

public interface SlotRankingStrategy {
    List<Doctor> rank(List<Doctor> doctors);
}
