package AppointmentBooking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppointmentSystem {
    Map<String,Doctor> doctors=new HashMap<>();
    Map<String, List<Doctor>> specialityMap=new HashMap<>();
    Map<String,Patient> patients=new HashMap<>();
    int bookingId=10000;
    Doctor trendingDoctor=null;
    SlotRankingStrategy rankingStrategy= new DefaultSlotRankingStrategy();

    void registerDoctor(String name, String speciality) {
        if (!doctors.containsKey(name)) {
            Doctor doctor = new Doctor(name, speciality);
            doctors.put(name, doctor);
            specialityMap.putIfAbsent(speciality, new ArrayList<>());
            specialityMap.get(speciality).add(doctor);
            System.out.println("Welcome Dr. " + name + " !!");
        }
    }

    void markAvailability(String doctorName, List<String> slots) {
        Doctor doc = doctors.get(doctorName);
        if (doc != null) {
            doc.markAvailability(slots);
        }
    }

    void showAvailableBySpeciality(String speciality) {
        List<Doctor> docs = specialityMap.getOrDefault(speciality, new ArrayList<>());
        docs = rankingStrategy.rank(docs);
        for (Doctor doc : docs) {
            for (String slot : doc.availableSlots) {
                System.out.println("Dr." + doc.name + ": (" + slot + ")");
            }
        }
    }

    void bookAppointment(String patientName, String doctorName, String slot) {
        Doctor doc = doctors.get(doctorName);
        if (doc != null && doc.availableSlots.contains(slot)) {
            Patient patient = patients.computeIfAbsent(patientName, k -> new Patient(patientName));
            if (patient.bookedAppointments.containsKey(slot)) {
                System.out.println("Patient already has an appointment at this time.");
                return;
            }
            doc.availableSlots.remove(slot);
            patient.bookedAppointments.put(slot, doctorName);
            doc.bookedAppointments++;
            updateTrendingDoctor(doc);
            System.out.println("Booked. Booking id: " + (++bookingId));
        } else {
            System.out.println("Slot not available. Adding to waitlist.");
            Patient patient = patients.computeIfAbsent(patientName, k -> new Patient(patientName));
            doc.waitlist.add(patient);
        }
    }

    void cancelBooking(String patientName, String slot) {
        Patient patient = patients.get(patientName);
        if (patient != null && patient.bookedAppointments.containsKey(slot)) {
            String doctorName = patient.bookedAppointments.remove(slot);
            Doctor doc = doctors.get(doctorName);
            doc.availableSlots.add(slot);
            doc.bookedAppointments--;
            System.out.println("Booking Cancelled");

            if (!doc.waitlist.isEmpty()) {
                Patient nextPatient = doc.waitlist.poll();
                nextPatient.notifyPatient(doctorName, slot);
                bookAppointment(nextPatient.name, doctorName, slot);
            }
        } else {
            System.out.println("No booking found for this slot");
        }
    }

    void viewAppointments(String name) {
        if (doctors.containsKey(name)) {
            System.out.println("Dr. " + name + " Appointments: " + doctors.get(name).bookedAppointments);
        } else if (patients.containsKey(name)) {
            System.out.println("Patient " + name + " Appointments: " + patients.get(name).bookedAppointments);
        } else {
            System.out.println("No records found.");
        }
    }

    void updateTrendingDoctor(Doctor doc) {
        if (trendingDoctor == null || doc.bookedAppointments > trendingDoctor.bookedAppointments) {
            trendingDoctor = doc;
        }
    }

    void showTrendingDoctor() {
        if (trendingDoctor != null) {
            System.out.println("Trending Doctor: Dr. " + trendingDoctor.name);
        } else {
            System.out.println("No trending doctor yet.");
        }
    }
}
