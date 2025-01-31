package AppointmentBooking;

import java.util.*;

public class Doctor {
    String name;
    String speciality;
    Set<String> availableSlots=new TreeSet<>();
    int bookedAppointments=0;
    Queue<Patient> waitlist=new LinkedList<>();

    Doctor(String name,String speciality){
        this.name=name;
        this.speciality=speciality;
    }

    boolean markAvailability(List<String> slots){
        for(String slot:slots){
            if(!isValidSlot(slot)||availableSlots.contains(slot)){
                System.out.println("Sorry Dr. " + name + " slots are 30 mins only or overlapping");
                return false;
            }
            availableSlots.add(slot);
        }
        System.out.println("Availablity marked!");
        return true;
    }

    private boolean isValidSlot(String slot) {
        return slot.matches("\\d{1,2}:\\d{2}-\\d{1,2}:\\d{2}");
    }
}
