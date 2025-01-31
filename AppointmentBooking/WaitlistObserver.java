package AppointmentBooking;

public interface WaitlistObserver {
    void notifyPatient(String doctorName, String slot);
}
