/* File: ScriptEditor.java
 * Author: Connor McGarty, cmcgarty@uab.edu
 * Assignment: Project 7 EE333 Spring 2018
 * Vers: 1.0.0 04/17/2018 csm - initial coding
 */


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
        
enum FORMAT {
    TEX, RTF
}

/**
 *
 * @author Connor
 */
public class ScriptEditor {
    
    public static final String TAG_TITLE           = "_USRTITLE_";
    public static final String TAG_ASSIGNMENT      = "_ASSIGNMENT_";
    public static final String TAG_AUTHORS         = "_AUTHORS_";
    public static final String TAG_EXPERIMENT_DATE = "_EXPDATE_";
    public static final String TAG_SUBMISSION_DATE = "_SUBDATE_";
    public static final String TAG_COURSE_CODE     = "_COURSECODE_";
    public static final String TAG_COURSE_NAME     = "_COURSENAME_";
    public static final String TAG_DEPARTMENT      = "_DEPARTMENT_";
    public static final String TAG_SCHOOL          = "_SCHOOL_";
    public static final String TAG_TEAM            = "_TEAMMEMBERS_";
    public static final String TAG_SECTIONS        = "_SECTIONTREE_";
    
    boolean isWindows = System.getProperty("os.name").toLowerCase().contains("windows");
    String userDir = System.getProperty("user.dir");
    
    /* File where sed scripts will be written to eventually be executed on
       a master template. */
    private FileOutputStream scriptStream;
    private File             script;

    
    public ScriptEditor() {
        
        try {
            script = new File(userDir + 
                              File.separator + 
                              "sedscript.txt");
            
            if (!script.exists())
                script.createNewFile();
            
            scriptStream = new FileOutputStream(script);
            
        } catch (IOException ex) {
            System.out.println(ex);
        }
        
        //this.userInfo = template;

    }
    
    public void newCommand(String templateField, String userField) throws IOException {
        String cmd;
        
        /* The sed substitution command  */
        cmd = String.format("s@%s@%s@g\n", templateField, userField);
        scriptStream.write(cmd.getBytes());
    }
    
    /**
     * Deletes the current working script file and creates a new empty file.
     * @throws java.io.IOException
     */
    public void deleteScript() throws IOException {
        script.delete();
        //this.script = new File("script.txt");
        scriptStream.flush();
        scriptStream.close();
    }

    /*
    public void makeHeaders(HeadingTree headers) {
        
    }*/
    
    /**
     * Executes sed script on master template. 
     * 
     * @param format
     * @param usrSaveLoc
     * @return 
     * @throws java.io.IOException 
     * @throws java.lang.InterruptedException 
     */
    public Path runScript(FORMAT format, Path usrSaveLoc) throws IOException, InterruptedException {
        
        String ls = File.separator;
        //ArrayList<String> sed = new ArrayList();
        
        // get full path of script file
        String scriptPath = script.getAbsolutePath();
        // get full path of the master template
        String masterTemplatePath = null;
        if (format == FORMAT.TEX) {
            masterTemplatePath = userDir + ls + "src" + ls + "templates" +
                                        ls + "masterTemplate" + ".tex";
        } if (format == FORMAT.RTF) {
            masterTemplatePath = userDir + ls + "src" + ls + "templates" +
                                        ls + "masterTemplate" + ".rtf";
        }

        // copy the master template to another file
        Path masterCopy = Paths.get(userDir + ls + "masterCopy.txt");
        
        //copyFile(new File(masterTemplatePath), masterCopy);
        Files.copy(Paths.get(masterTemplatePath), masterCopy, StandardCopyOption.REPLACE_EXISTING);

        /* build the str array sed command that execs the script file on the
           COPY of the master template
        */

        if (isWindows) {
            String sed = String.format("cmd.exe /c sed -r -f %s -i %s", script.getAbsolutePath(), masterCopy.toString().replace("/", "\\"));
            Process p = Runtime.getRuntime().exec(sed);
                        //script.getAbsolutePath(), masterCopy.getAbsolutePath()));
            try {
                p.waitFor();
            } catch (InterruptedException ie) {
            }

                    
        }
        else {
            Process p = Runtime.getRuntime().exec(String
                    .format("sh -c sed -r -f %s -i %s",
                            //script.getAbsolutePath(), masterCopy.getAbsolutePath()));
                            script.getAbsolutePath(), masterCopy.toString()));
        }
        
        //Files.copy(masterCopy, usrSaveLoc, StandardCopyOption.REPLACE_EXISTING);
        //Files.copy(masterCopy.toPath(), usrSaveLoc.toPath(), StandardCopyOption.REPLACE_EXISTING);
        masterCopy = Paths.get(userDir + ls + "masterCopy.txt");
        return masterCopy;
    }
    
    /**
     * Taken from: https://examples.javacodegeeks.com/core-java/io/file/4-ways-to-copy-file-in-java/
     * 
     * 
     * @param source
     * @param dest
     * @throws IOException 
     */
    public void copyFile(File source, File dest) throws IOException {

        FileChannel inputChannel = null;
        FileChannel outputChannel = null;

        try {
            inputChannel = new FileInputStream(source).getChannel();
            outputChannel = new FileOutputStream(dest).getChannel();
            outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
        } finally {
            inputChannel.close();
            outputChannel.close();
        }
    }

}
