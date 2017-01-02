# JavaPIO

<h2>Description & requirements</h2>

JavaPIO is a simple high-level Java Public I/O library designed for managing various file types. Library is written with the use 
of Java in version 1.8.0_77 using functionalities of Java 1.8. Thus, JavaPIO requires software development kit (SDK) 
at least in version 1.8.0_77.

<h2>How to use JavaPIO in your project?</h2>

In order to use JavaPIO library just copy `org.JavaPIO.*` package to your project.

<h2>Docs</h2>

For library documentation go to http://piotrdz.ayz.pl/javapio/docs/index.html.

<h2>License</h2>

The source code is released under the terms of <a href="https://github.com/piotrdzwiniel/Specvis/blob/master/GNU%20GPL%20v3.txt">
GNU General Public License in version 3</a> as published by the Free Software Foundation. If you want to use JavaPIO library in a commercial project, 
mail to me - piotr.dzwiniel@gmail.com.

<h2>Usage examples</h2>
<h3>public class org.JavaPIO.utility.FileUtility</h3>
<h4>Example 1 - get file extension</h4>
Java code:

    File file = new File("Foo.txt");
    String extension = FileUtility.getFileExtension(file);
    
    System.out.println(extension);
    
Console output:

    txt

<h3>public class org.JavaPIO.input.FileInput</h3>
<h4>Example 1 - reading file content as single string</h4>
File content ("DATA_1.txt"):
    
    When you are courting a nice girl an hour seems like a second.
    When you sit on a red-hot cinder a second seems like an hour.
    That's relativity.
    -Albert Einstein

Java code:

    File fileData = new File("DATA_1.txt");
    String fileContent = FileInput.asSingleString(fileData);
    
    System.out.println(fileContent);
    
Console output:

    When you are courting a nice girl an hour seems like a second.
    When you sit on a red-hot cinder a second seems like an hour.
    That's relativity.
    -Albert Einstein

<h4>Example 2 - reading file content line by line</h4>
File content the same as in Example 1.

Java code:

    ArrayList<String> fileContent = FileInput.asArrayListOfIndividualLines(fileData);
    
    for (String s: fileContent) System.out.println(s);

Console output the same as in Example 1.

<h4>Example 3 - reading file content as individual characters</h4>
File content ("DATA_2.txt"):

    1234 5678

Java code:

    File fileData = new File("DATA_2.txt");
    String[] fileContent = FileInput.asIndividualCharacters(fileData);
    
    for (String s: fileContent) System.out.println(s);
    
Console output:

    1
    2
    3
    4
    
    5
    6
    7
    8
    
<h4>Example 4 - extracting from the file individual digits</h4>
File content the same as in Example 3.

Java code:

    Byte[] fileContent = FileInput.asIndividualDigits(fileData);
    
    for (byte b: fileContent) System.out.println(b);
    
Console output:

    1
    2
    3
    4
    5
    6
    7
    8

<h4>Example 5 - reading from the file separated float values</h4>
File content ("DATA_3.txt"):

    123.4325 1323.3125454 123.1234 3.12315
    
Java code:

    File fileData = new File("DATA_3.txt");
    Float[] fileContent = FileInput.asFloatValues(fileData, "\\s+");
    
    for (float f: fileContent) System.out.println(f);
    
Console output:

    123.4325
    1323.3125
    123.1234
    3.12315
    
