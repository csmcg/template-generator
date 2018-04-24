import java.util.ArrayList;

/*
 * File: Headings.java
 * Author: Malik Midani mikex535@uab.edu
 * Assignment:  SEDproject - EE333 Spring 2018
 * Vers: 1.0.0 04/20/2018 MM - initial coding
 *
 * Credits:  (if any for sections of code)
 */

/**
 *
 * @author Malik Midani mikex535@uab.edu
 */
public class Headings {
    
    private ArrayList<Heading> headings;
    private int hcount;
    
    public Headings(){
        headings = new ArrayList();
        hcount = 0;
    }
    
    /**
     *
     * @param template Paramater of enum type {@link TEMPLATE} that denotes
     * the default master template to fill the GUI/user document with. 
     */
    public Headings(TEMPLATE template){
        headings = new ArrayList();
        hcount = 0;
        if (template == TEMPLATE.FORMAL){
            
            add1(new Heading("Introduction"));
            add1(new Heading("Theory"));
            add1(new Heading("Methods"));
            headings.get(hcount-1).add(new Subheading("Experimental Procedure"));
            headings.get(hcount-1).add(new Subheading("Experimental Apparatus"));
            headings.get(hcount-1).add(new Subheading("Material List"));
            add1(new Heading("Results"));
            add1(new Heading("Discussion"));
            add1(new Heading("Conclusion"));
            add1(new Heading("References"));
            add1(new Heading("Appendix"));
        }

        else if (template == TEMPLATE.INFORMAL){
            add1(new Heading("Summary"));
            headings.get(hcount-1).add(new Subheading("Figures and Tables"));
            add1(new Heading("References"));
            headings.get(hcount-1).add(new Subheading("Calculations"));
        }
    }
    
    /**
     * 
     * @return {@link String} containing all document sections, separated by
     * newlines, with subheadings tabbed in below their respective headings.
     */
    public String getAll(){
        String s = "";
        for (int i=0;i<hcount;i++){
            s += headings.get(i).getName() +"\n";
            if (headings.get(i).getCount() != 0){ // if it has subsections
                for (int j=0 ; j<headings.get(i).getCount() ; j++){
                    s += "\t" + headings.get(i).getSH(j).getName() + "\n";
                }
            }
        }
        
        return s;
    }

    /**
     * Iterates through all sections provided by the user (headings and 
     * subheadings), surrounding them with the proper formatting for LaTeX 
     * source code. 
     * 
     * @return s {@link String} containing LaTeX formatting for sections
     */
    public String formatTeX() {
        String s = "";
        String section = null;
        
        for (int i = 0; i < hcount; i++) {
            // place the heading name into the rtf styling for top-level headers
            s += String.format("\\\\section{%s}\\\n",
                          headings.get(i).getName());

            if (headings.get(i).getCount() != 0) { // if the heading has subs under it
                for (int j = 0; j < headings.get(i).getCount(); j++) {
                    // place the SH name into the rtf styling for subheadings
                    s += String.format("\\\\subsection{%s}\\\n", headings.get(i).
                                                             getSH(j).getName());
                }
            }
        }
        
        return s;        
    }
    
    /**
     * Iterates through all sections provided by the user (headings and 
     * subheadings), surrounding them with the proper styling for display in 
     * Rich Text Format documents.
     * 
     * @return s {@link String} containing RTF formatting for sections 
     */
    public String formatRTF() {
        String s = "";
        String section = null;
        
        for (int i = 0; i < hcount; i++) {
            // place the heading name into the rtf styling for top-level headers
            s += String.format("\\\\pard\\\\sa200\\\\sl360\\\\slmult1\\\\qc\\\\b %s\\\\par",
                          headings.get(i).getName().toUpperCase());

            if (headings.get(i).getCount() != 0) { // if the heading has subs under it
                for (int j = 0; j < headings.get(i).getCount(); j++) {
                    // place the SH name into the rtf styling for subheadings
                    s += String.format("\\\\pard\\\\sa200\\\\sl360\\\\slmult1\\\\i " +
                                       "%s\\\\par\\\\i0", headings.get(i).getSH(j).getName());
                }
            }
        }
        
        return s;
    }    
    
    public String formatRTFToC() {
        String s = "";
        String section = null;
        
        for (int i = 0; i < hcount; i++) {
            // place the heading name into the rtf styling for top-level headers
            s += String.format("\\\\pard\\\\sa200\\\\sl360\\\\slmult1\\\\tldot\\\\tx8000\\\\b "
                               + "%s\\\\tab 1\\\\par", headings.get(i).getName().toUpperCase());

            if (headings.get(i).getCount() != 0) { // if the heading has subs under it
                for (int j = 0; j < headings.get(i).getCount(); j++) {
                    // place the SH name into the rtf styling for subheadings
                    s += String.format("\\\\pard\\\\sa200\\\\sl360\\\\slmult1\\\\tldot\\\\tx8000\\\\b0 "
                                       + "%s\\\\tab 1\\\\par", headings.get(i).getSH(j).getName());
                }
            }
        }        

        return s;
    }
    
    private void add1(Heading h){
        headings.add(h);
        hcount++;
    }
    
    public void add(Heading h){
        headings.add(h);
        hcount++;
    }
    
    public void remove(Heading h){
        headings.remove(h);
        hcount--;
    }
     
    public void remove(int index){
        headings.remove(index); 
        hcount--;
    }
     
     
    public Heading getHeading(int index){
        return headings.get(index);
    }
    
    public void setHeading(int index, Heading h){
        headings.set(index, h);
    }
    
    public int getCount(){
        return hcount;
    }
    

}
