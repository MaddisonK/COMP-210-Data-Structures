package hospital;

import javax.sound.midi.SysexMessage;

public class Main {

    public static void main(String[] args) {
        /*
        Part 1
         */
//        SimpleEmergencyRoom ER_room = new SimpleEmergencyRoom();
//        fillER(ER_room);
//        long time_sum = 0;
//        for (int i=0; i<10; i++) {
//            long start = System.nanoTime();
//            ER_room.dequeue();
//            // some time passes
//            long end = System.nanoTime();
//            time_sum += end - start;
//        }
//        System.out.println(time_sum/10);




       /*
        Part 2
         */
        MinBinHeapER NR = new MinBinHeapER();
        NR.enqueue("Sally");
        NR.enqueue("Jonathan");
        NR.enqueue("Macy");
        NR.enqueue("Tim");
        NR.enqueue("Herald");
        for (Prioritized patient: NR.getAsArray()) {
            System.out.println(patient.getValue());
            System.out.println(patient.getPriority());
        }
        System.out.println("___after___");
        System.out.println(NR.dequeue());
        for (Prioritized patient: NR.getAsArray()) {
            System.out.println(patient.getValue());
            System.out.println(patient.getPriority());
        }




        /*
        Part 3
         */
//        MinBinHeapER transfer = new MinBinHeapER(makePatients());
//        Prioritized[] arr = transfer.getAsArray();
//        for(int i = 0; i < transfer.size(); i++) {
//            System.out.println("Value: " + arr[i].getValue()
//                    + ", Priority: " + arr[i].getPriority());
        }
//    }

    public static void fillER(MinBinHeapER complexER) {
        for(int i = 0; i < 100000; i++) {
            complexER.enqueue(i);
        }
    }
    public static void fillER(SimpleEmergencyRoom simpleER) {
        for(int i = 0; i < 100000; i++) {
            simpleER.addPatient(i);
        }
    }

    public static Patient[] makePatients() {
        Patient[] patients = new Patient[10];
        for(int i = 0; i < 10; i++) {
            patients[i] = new Patient(i);
        }
        return patients;
    }



}



