/* File: ScriptEditor.java
 * Author: Connor McGarty, cmcgarty@uab.edu
 * Assignment: Project 7 EE333 Spring 2018
 * Vers: 1.0.0 04/17/2018 csm - initial coding
 */


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;

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
    
    boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
    
    /* File where sed scripts will be written to eventually be executed on
       a master template. */
    private FileOutputStream scriptStream;
    //private UserDoc          userInfo;
    private File             script;

    
    public ScriptEditor() {
        
        try {
            
            script = new File("script.txt");
            
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
        this.script = new File("script.txt");
        scriptStream.flush();
        scriptStream.close();
    }

    /*
    public void makeHeaders(HeadingTree headers) {
        
    }*/
    
    /**
     * Executes sed script on master template. 
     * 
     * @param master 
     * @param usersDocument 
     * @throws java.io.IOException 
     * @throws java.lang.InterruptedException 
     */
    public void runScript(File master, File usersDocument) throws IOException, InterruptedException {
        
        ProcessBuilder p;
        String scriptPath = script.getPath();
        String masterTemplatePath = master.getPath();
        String OS = System.getProperty("os.name");
        boolean isWindows;
        List<String> cmd = new ArrayList();
        copyFile(master, usersDocument);
        String usersDocumentPath = usersDocument.getPath();
        isWindows = (OS.contains("windows") || OS.contains("Windows"));

        if (isWindows) {
            cmd.add("cmd.exe");
            cmd.add("/c");
            cmd.add("sed");
            cmd.add("-r");
            cmd.add("-f");
            cmd.add(scriptPath);
            cmd.add("-i");
        }
        else {
            cmd.add("sh"); 
            cmd.add("-c");
            cmd.add("sed");
            cmd.add("-r");            
            cmd.add("-f");
            cmd.add(scriptPath);
            cmd.add("-i");            
        }
        
        cmd.add(usersDocumentPath);
        p = new ProcessBuilder(cmd);
        //p.redirectOutput(usersDocument);        
        p.start();
        
        /* first try at implementation, 
            see commit 6a22a98d78ee9cd203c33b0e1a339f84ab5aa849
            was having trouble writing sed output to file
        Process process;
        OutputStream userDocStream;
        String scriptPath = script.getPath();
        String masterTemplatePath = master.getPath();
        String usersDocumentPath = usersDocument.getPath();
        if (isWindows) {
            process = Runtime.getRuntime()
                    .exec(String.format("cmd.exe /c sed -f %s %s", scriptPath,
                            masterTemplatePath));
            usersDocument.setWritable(true);
            userDocStream = process.getOutputStream();
            userDocStream.write(userDocStream.toString().getBytes());
        }
        else {
            process = Runtime.getRuntime()
                    .exec(String.format("sh -c sed -f %s %s > %s", script.getPath(),
                            master.getPath(), usersDocument.getPath()));
        }
        //StreamGobbler streamGobbler;
        //streamGobbler = new StreamGobbler(process.getInputStream(),
        //        System.out::println);
        //Executors.newSingleThreadExecutor().submit(streamGobbler);
        int exitCode = process.waitFor();
        //assert exitCode == 0; 
        */
    }
    
    /**
     * Taken from: https://stackoverflow.com/questions/106770/standard-concise-way-to-copy-a-file-in-java/115086#115086
     * 
     * 
     * @param sourceFile
     * @param destFile
     * @throws IOException 
     */
    public void copyFile(File sourceFile, File destFile) throws IOException {
        if(!destFile.exists()) {
            destFile.createNewFile();
        }
        
        FileChannel source = null;
        FileChannel destination = null;
        
        try {
            source = new FileInputStream(sourceFile).getChannel();
            destination = new FileOutputStream(destFile).getChannel();
            destination.transferFrom(source, 0, source.size());
        } finally {
            if (source != null) {
                source.close();
            }
        }
    }
}
