package main;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.programStructure.Task;
import main.programStructure.UserProgram;

/**
 * @author David Gronlund
 */
public class Main {

    public static void main(String[] args) throws UnknownHostException, IOException {
//        File file = new File("../UserProgram/build/classes/test/" +
//                    "ProgramTest.class");
//        System.out.println(file.isFile());
        UserProgramClassLoader loader = new UserProgramClassLoader(Main.class.getClassLoader());
        Class userProgramClass;
        UserProgram user = null;
        try {
            userProgramClass = loader.loadClass("../UserProgram/build/classes/test/" +
                    "ProgramTest.class");
            user = (UserProgram) userProgramClass.getConstructor(Main.class).newInstance(new Main());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        user.run();
    }
    
    public Map<String, Object> submitTask(Task task) {
        return null;
    }
}
