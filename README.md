# template-generator

template-generator is a graphical tool for generating document outlines that adhere to the Informal and Formal report templates of the University of Alabama at Birmingham Electrical and Computer Engineering Department's specifications.

t-g generates both LaTeX source files (.tex) as well as Rich Text Format (.rtf) files for use with WYSIWYG editors, such as LibreOffice Writer and Microsoft Word.

t-g utilizes [GNU sed](https://www.gnu.org/software/sed/), and as such requires it as a dependency. GNU sed is not packaged with t-g. To use t-g, install GNU sed and make sure the binary is in your executable path. 

## From (readme)[README.txt]
>Template Generator is a graphical report template editor written in Java SE8 utilizing GNU sed as a backend. Two templates are provided, a formal report document
and an informal report document that comply with the University of Alabama at Birmingham Department of Engineering standards. Templates can be generated in both LaTeX source code format and Rich Text Format for editing in word processing software such as Microsoft Word. 

>Template Generator requires GNU sed to be installed and located in the your system's
PATH environment variable. Template Generator is confirmed to work on Windows, and
should work on UNIX systems as well, but is untested. 

>To run Template Generator:
>1) From the command line, navigate to the folder 'template-generator' located within the folder the document you are currently reading resides.
>2) Type the following at the prompt: java -jar dist/template-generator.jar
