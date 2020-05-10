import java.io.File;
// import java.util.Scanner; 
  
public class FileReader  
{ 
     static void Print(File[] array, int index, int subSection)  
     { 
         // this will 
         if(index == array.length) {
        	 
             return; 
             
         } // end if()
           
         // tabs over for Sub Sections 
         for (int i = 0; i < subSection; i++) {
          
        	 System.out.print("\t"); 
         
         } // end if()
           
         // if the file is not a folder (has sub directories), then this prints 
         if(array[index].isFile()) {
        	 
        	 if (subSection == 0) {
        		 
        		 System.out.println(array[index].getName());
        		 
        	 } // end if()
        	 
        	 // this just makes it a little more clear that this is a subsection
        	 if (subSection !=0 ) {
        		 
        		 System.out.println("--> " + array[index].getName());
        		 
        	 } // end if()
              
         } // end if()
           
         // this is for when a file is a folder and has sub directories
         else if(array[index].isDirectory()) 
         { 
             System.out.println(array[index].getName()); 
               
             // using recursion, the output tabs over since "subSection" would now == 1 
             Print(array[index].listFiles(), 0, subSection + 1); 
             
         } // end else if() 
            
         // recursion to advance until all of the files have been read by increasing the index 
         Print(array, ++index, subSection); 
         
    } // end Print() 
      
     
    public static void main(String[] args) 
    { 
        /* Attempt at having the user input the file path - failed
         *
         * System.out.print("Please give me the file path: ");
         * Scanner input = new Scanner(System.in);
         * String filePath = input.nextLine(); 
         * 
    	 */
    	
        File directory = new File("/Users/dwgoins98/Desktop/"); 
           
        if(directory.exists() && directory.isDirectory()) // This checks to make sure the pathname is a valid directory
        { 
            // array for files and sub-directories of directory pointed by directory 
            File array[] = directory.listFiles(); 
              
            System.out.println("**********************************************************************"); 
            System.out.println("Here's what returned from the directory: " + directory); 
            System.out.println("**********************************************************************"); 
              
            // Calls Print() method
            Print(array, 0, 0); 
            
       } // end if() 
        
    } // end main()
    
} // end FileReader class