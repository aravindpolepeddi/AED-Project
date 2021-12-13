///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package assignmentfive;
//
///**
// *
// * @author deepv
// */
//import com.db4o.Db4oEmbedded;
//import com.db4o.ObjectContainer;
//import com.db4o.ObjectSet;
//import java.nio.file.Paths;
//
//public class DB4O {
//
//    private static final String FILENAME = Paths.get("Databank.db4o").toAbsolutePath().toString();// path to the data store
//    private static DB4O dB4OUtil;
//
//    public static void main(String[] args) {
//
//        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded
//                .newConfiguration(), FILENAME);
//        try {
//
//            /**
//             *
//             * Creating data
//             *
//             */
////            Pilot pilot1 = new Pilot("Aravind", 10);
////            db.store(pilot1);
////            System.out.println("Stored " + pilot1);
//            /**
//             *
//             * Retrieving data
//             *
//             */
//            Pilot proto = new Pilot("Aravind", 0);
//            ObjectSet result = db.query(Pilot.class);
//            listResult(result);
//            /**
//             *
//             * Updating data
//             *
//             */
////            ObjectSet result = db
////                    .queryByExample(new Pilot("Michael Schumacher", 0));
////            Pilot found = (Pilot) result.next();
////            found.addPoints(11);
////            db.store(found);
////            System.out.println("Added 11 points for " + found);
//
//        } finally {
//            db.close();
//        }
//
//    }
//
//    public static void listResult(ObjectSet result) {
//        System.out.println(result.size());
//        while (result.hasNext()) {
//            System.out.println(result.next());
//        }
//    }
//}
