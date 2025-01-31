package AppointmentBooking;

import java.util.Comparator;
import java.util.List;

public class DefaultSlotRankingStrategy implements SlotRankingStrategy{
    @Override
    public List<Doctor> rank(List<Doctor> doctors) {
        doctors.sort(Comparator.comparing(doc -> doc.availableSlots.iterator().next()));
        return doctors;
    }
}
