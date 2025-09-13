package actividad2.process;

import actividad2.data.*;
import java.util.*;

public class Manager {
    HashMap<Integer, Patient> patients = new HashMap<>();

    public void addPatient(String name, int id, String sick, int priority){
        if(patients.containsKey(id) || id == 0){
            throw new IllegalArgumentException("El ID ya existe o es inválido.");
        }
        Patient patient = new Patient(name, id, sick, priority);
        patients.put(id, patient);
        System.out.println("Paciente agregado exitosamente.");
    }

    public void removePatient(int id){
        if(!patients.containsKey(id)){
            throw new IllegalArgumentException("El ID no existe.");
        }
        patients.remove(id);
        System.out.println("Paciente eliminado con exito.");
    }

    public List<Patient> showPatientsLevel(int priority){
        List<Patient> patientsList = new ArrayList<>();
        for(Patient patient : patients.values()){
            if(patient.getPriority() == priority){
                patientsList.add(patient);
            }
        } 
        return patientsList;
    }

    public List<Patient> showPatients(){
        return new ArrayList<>(patients.values());
    }
}
