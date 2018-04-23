
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;


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
        
        ScriptEditor script = new ScriptEditor();
        //String templatePath = "templates/";
        String userDir = System.getProperty("user.dir");
        //File userDocumentName = new File("mydoc.tex");
        String ls = File.separator;
        
        
        // user's name for their document
        String usrDocName = "myDocument";
        // desired location for user's doc to be saved
        File usrSaveLoc = new File("C:" + ls + "Users" + ls + "Connor" + ls
                                   + "School" + ls + "myReport.tex");
        
        
        
        script.newCommand(ScriptEditor.TAG_TITLE, "Test Title");
        script.newCommand(ScriptEditor.TAG_COURSE_CODE, "EE123");
        script.newCommand(ScriptEditor.TAG_ASSIGNMENT, "Test Assignment");
        script.newCommand(ScriptEditor.TAG_COURSE_NAME, "Test Course");
        script.newCommand(ScriptEditor.TAG_SCHOOL, "Test School");
        script.newCommand(ScriptEditor.TAG_DEPARTMENT, "Test Department");
        script.newCommand(ScriptEditor.TAG_SUBMISSION_DATE, "Test Sub Date");
        script.newCommand(ScriptEditor.TAG_EXPERIMENT_DATE, "Test Exp Date");
        
        File userDoc = script.runScript(FORMAT.TEX, usrSaveLoc);



    }
    
}
