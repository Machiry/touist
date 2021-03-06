## How to update the syntax hightlighter

You basically need to follow the tutorial described in
https://github.com/bobbylight/rsyntaxtextarea/ 
in wiki -> Adding Syntax Highlighting for a new Language.

Basically, you need to

1. download and unzip jflex-1.4.1.zip that you can find on 
   https://sourceforge.net/projects/jflex/files/jflex/1.4.1/
   and run `java -jar jflex-1.4.1/lib/JFlex.jar Touistl.jflex`
   IMPORTANT: you cannot use jflex-1.6.1 and above because the code
   it generates is not compatible with the "hacks" of the lexer
   we introduce (zzRefill, yyreset...)

2. In generated TouistTokenMaker, remove duplicate definitions of
   zzRefill and yyreset (keep only the one that says
       	// Patched version to keep!

   Here is the outdated inscructions from the wiki page:
   
   ``There are two zzRefill() and yyreset() methods with the same
     signatures in the generated file. You need to delete the
     (second) -> it depends of each definition (the ones generated by
     the lexer). 
     Change the declaration/definition of zzBuffer to NOT be initialized. 
     This is a needless memory allocation for us since we will be pointing
     the array somewhere else anyway.''