package AppointmentBooking;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        AppointmentSystem system = new AppointmentSystem();

        system.registerDoctor("Sharma", "Cardiologist");
        system.markAvailability("Sharma", Arrays.asList("9:30-10:00", "12:30-13:00", "16:00-16:30"));

        system.registerDoctor("Gupta", "Dermatologist");
        system.markAvailability("Gupta", Arrays.asList("10:30-11:00", "13:30-14:00", "17:00-17:30"));

        system.showAvailableBySpeciality("Cardiologist");
        system.bookAppointment("PatientA", "Sharma", "12:30-13:00");
        system.showAvailableBySpeciality("Cardiologist");
        system.cancelBooking("PatientA", "12:30-13:00");
        system.showAvailableBySpeciality("Cardiologist");

        system.showTrendingDoctor();
    }
}
