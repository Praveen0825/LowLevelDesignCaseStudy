package AppointmentBooking;

import java.util.HashMap;
import java.util.Map;

public class Patient implements WaitlistObserver{
    String name;
    Map<String,String> bookedAppointments=new HashMap<>();
    Patient(String name){
        this.name=name;
    }
    @Override
    public void notifyPatient(String doctorName, String slot){
        System.out.println("Notification: " + name + ", your waitlisted slot " + slot + " with Dr. " + doctorName + " is now available!");
    }
}
