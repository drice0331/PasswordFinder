/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordfinder;

/**
 *
 * @author drice
 */
public class PasswordFinder {

private static String password;
    
    /**
     * Create random password with specified length in param
     * @param length
     */
    public static void makeRandomPassword(int length)
{
    char carray[] = new char[length];
    int asciiInd;
    
    for(int i = 0; i < length; i++)
    {
        asciiInd = (int)(Math.random()*94) + 32;           //converts ascii to
        carray[i] = (char)asciiInd;                                //char to string then
        //password = password.concat(Character.toString(c)); //add to password
    }
    password = new String(carray);
    System.out.println("password created - " + password);
}
    /**
     * 
     */
    public static void findRandomPassword()
    {
        int curLenTested = 0;
        boolean found = false;
        while(!found)//be careful - could cause infinite loop
        {
            curLenTested++;
            found = findRandomPasswordWithLen(curLenTested);
        }
        System.out.println("Ran up to length - " + curLenTested);
        
        
        
    }

    public static boolean findRandomPasswordWithLen(int length)
    {
        boolean isfound = false;
        if(password == null)
        {
            System.out.println("no password initialized yet");
            return isfound;
        }
        //boolean isfound = false;//may not need
        char []c = new char[length];//char array to hold single chars 
                                    //converted into String test
        int pos = (int)(Math.pow(95, length));//possible number of passwords
        int divider;//for dividing to get proper ascii index
        int modcounter;//for mod'ing to get proper ascii index
        int ascii; //ascii index to be turned into a char for String test        
        String test;//string to be compared to password
        for(int i = 0; i < length; i++) //init char array c
        {
            c[i] = (char)32;//check later in case of mistake
        }
        
        
            for(int a = 0; a < pos; a++)
            {
                divider = pos/95;
                modcounter = 0;
                System.out.println(a);
                for(int i = 0; i < length; i++)
                {
                    ascii = a/divider;
                    //System.out.println("ascii is - " + ascii + " - with divider " + divider);
                    for(int m = 0; m < modcounter; m++)
                    {
                        ascii = ascii % 95;
                    }
                    //System.out.println("ascii is - " + ascii + " - with modcounter " + modcounter);                    
                    c[i] = (char)(ascii + 32);//+32, index 32-126 are the 
                                              //typeable ascii's
                    divider = divider/95;
                    modcounter++;
                }
                test = new String(c);
                System.out.println("test = " + test);
                if(test.equals(password))
                {
                    isfound = true;//for passwordfind method without length as
                                   //a given
                    System.out.println("password found");
                    return isfound;

                }

                System.out.println();
        }
        return isfound;
    }
    
    public static void main(String[] args) 
    {
        boolean found = false;
        //makeRandomPassword(3);
        //findRandomPasswordWithLen(3);
        
        makeRandomPassword(3);
        findRandomPassword();

        
        // TODO code application logic here
    }

    
}
