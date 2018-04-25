Team 5 EE333 Spring 2018 Final Project: Template Generator


Template Generator is a graphical report template editor written in Java SE8 utilizing GNU sed as a backend. Two templates are provided, a formal report document
and an informal report document that comply with the University of Alabama at Birmingham Department of Engineering standards. Templates can be generated in both LaTeX source code format and Rich Text Format for editing in word processing software such as Microsoft Word. 

Template Generator requires GNU sed to be installed and located in the your system's
PATH environment variable. Template Generator is confirmed to work on Windows, and
should work on UNIX systems as well, but is untested. 

To run Template Generator:
1) From the command line, navigate to the folder 'template-generator' located within the folder the document you are currently reading resides.
2) Type the following at the prompt: java -jar dist/template-generator.jar

Files included: 
/template-generator - NetBeans Java Project
/template-generator/dist/template-generator.jar - executable JAR for starting Template Generator
/template-generator/src/templates - master templates !!!DO NOT EDIT!!!



/javadoc/ - JavaDoc documentation of source code
/team5-handout.pdf - Handout for Final Presentation
/team5-ppt-presentation.pdf - Powerpoint for Final Presentation
/Group 5 Meeting Log.docx - meeting logs
/EEFormal.tex - additional styling for Formal report in LaTeX format
/EEInformal.tex - additional styling for Informal report in LaTeX format
/texMemo.cls    - memorandum latex class for informal report
