
import java.io.File;
import java.io.IOException;


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
        File myDocument = new File("mydoc.tex");
        File master = new File("masterTemplate.tex");
        
        
        script.newCommand(ScriptEditor.TAG_TITLE, "Test Title");
        script.newCommand(ScriptEditor.TAG_COURSE_CODE, "EE123");
        script.newCommand(ScriptEditor.TAG_ASSIGNMENT, "Test Assignment");
        script.newCommand(ScriptEditor.TAG_COURSE_NAME, "Test Course");
        script.newCommand(ScriptEditor.TAG_SCHOOL, "Test School");
        script.newCommand(ScriptEditor.TAG_DEPARTMENT, "Test Department");
        script.newCommand(ScriptEditor.TAG_SUBMISSION_DATE, "Test Sub Date");
        script.newCommand(ScriptEditor.TAG_EXPERIMENT_DATE, "Test Exp Date");
        
        script.runScript(master, myDocument);
        

    }
    
}
