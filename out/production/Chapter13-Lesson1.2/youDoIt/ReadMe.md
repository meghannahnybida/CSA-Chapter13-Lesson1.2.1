<h1> Chapter 13 </h1>
<p> A try and catch statement are two separate blocks that work together in a program. The try statement executes a block of code
and tests it for errors. The catch block is there to "catch" or process any exception errors that may occur from the code in the
try block. If the catch block doesn't handle the exception, that means the wrong handler was used to catch the error. </p>

<p>Read Text Files</p>
<p>First, the program has the user enter the file they want to read, so the program knows where to retrieve data from. Next, the program uses a try catch block. The try statement contains an InputStream and a BufferedReader, which reads data from the text files.
Then, there is another try catch block that uses a file channel which is used to read data from the file. It alsohas a ByteBuffer that also reads data from a file. So when the user enters the account number they are trying to seek,the
program uses file channel (fc) to find the position of the desired account and then fc to read the data (buffer is used in this to speed up process I think). Then the catch block is there to throw any potential errors. That is how text is read on
the text files. </p>

<p>Write to Text Files </p>
<p> First, the program retrieves the filepaths of the two text files InStateCusts.txt and OutOfStateCusts.txt. Next, the method createEmptyFile is called. This method contains a BufferedWriter and an OutputStreamWriter.
This method places the initial  text on the file, which in this case is 1000 placeholder values for customer account number, name, and state. Next, a try
catch block is in the program, which is where the user enters data. Next, the file channels open the file, which allows the data the user enters to be written in the placeholders in
the text files, however it doesn't actually place the user entries there yet, the ByteBuffer helps with this.The buffer transfers the bytes from the file channels to the actual file. After
this, the catch statement is there to catch any possible errors. That is how text is written on the text files.  </p>
