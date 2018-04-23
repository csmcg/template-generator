
import com.sun.javafx.sg.prism.NGCanvas;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import sun.security.pkcs11.P11TlsKeyMaterialGenerator;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Testing class. 
 *
 * @author Connor S. McGarty <cmcgarty@uab.edu>
 */
public class TestMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        
        ScriptEditor script = new ScriptEditor(); // create scripteditor object
        String userDir = System.getProperty("user.dir"); // get the user directory 
        String ls = File.separator; // the OS 
        
        Path usrDocPath = Paths.get("C:/Users/Connor/School/myDoc.tex");
        try {
            usrDocPath = Files.createFile(usrDocPath);
        } catch (FileAlreadyExistsException faeex) {
            
        }

        /* formal
        script.newCommand(ScriptEditor.TAG_TITLE, "Test Title");
        script.newCommand(ScriptEditor.TAG_COURSE_CODE, "EE123");
        script.newCommand(ScriptEditor.TAG_ASSIGNMENT, "Test Assignment");
        script.newCommand(ScriptEditor.TAG_COURSE_NAME, "Test Course");
        script.newCommand(ScriptEditor.TAG_SCHOOL, "Test School");
        script.newCommand(ScriptEditor.TAG_DEPARTMENT, "Test Department");
        script.newCommand(ScriptEditor.TAG_SUBMISSION_DATE, "Test Sub Date");
        script.newCommand(ScriptEditor.TAG_EXPERIMENT_DATE, "Test Exp Date");
        */
        
        // informal
        script.newCommand(ScriptEditor.TAG_MEMO_TO, "Dr. David Green");
        script.newCommand(ScriptEditor.TAG_MEMO_FROM, "Team 6");
        script.newCommand(ScriptEditor.TAG_MEMO_DATE, "23 April 2018");
        script.newCommand(ScriptEditor.TAG_MEMO_SUBJECT, "This is a test");

        
        //Path userDoc = script.runScript(TEMPLATE.FORMAL, FORMAT.TEX, usrDocPath);
        Path userDoc = script.runScript(TEMPLATE.INFORMAL, FORMAT.TEX, usrDocPath);
        //Path userDoc = script.runScript(TEMPLATE.FORMAL, FORMAT.RTF, usrDocPath);
        //Path userDoc = script.runScript(TEMPLATE.INFORMAL, FORMAT.RTF, usrDocPath);

        try {
            Files.deleteIfExists(usrDocPath);
            Files.copy(userDoc, usrDocPath, StandardCopyOption.COPY_ATTRIBUTES);
        } catch (FileAlreadyExistsException faeex) {

        }

    }
    
}
