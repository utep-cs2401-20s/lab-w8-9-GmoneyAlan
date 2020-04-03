import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

public class AminoAcidLLTester {
//"GCUACGGAGCUUCGGAGCUAG"
    //Test 1 is testing making two instances of one single linked list by using the constructor
    //
    @Test
    public void AminoAcidLL1(){
        AminoAcidLL a = new AminoAcidLL("GCU");
        AminoAcidLL b = new AminoAcidLL("GCU");
        AminoAcidLL.sort(a);
        AminoAcidLL.sort(b);
        assertTrue(a.isSorted()); // Seeing whether the a and b are sorted
        assertTrue(b.isSorted());

        char aChar[], bChar[];     //Initiating Arrays for both AminoAcidLL which are a character array and a int count array
        int aCounts[], bCounts[];
        aChar = a.aminoAcidList();
        bChar = b.aminoAcidList();
        aCounts = a.aminoAcidCounts();
        bCounts = b.aminoAcidCounts();

        assertArrayEquals(aChar,bChar);  //Seeing if both character arrays equal each other
        assertArrayEquals(aCounts,bCounts); //Seeing if both count arrays equal each other
        assertEquals(0,a.aminoAcidCompare(b)); // Checking the diff using the aminoAcidCompare method between a & b
        assertEquals(0,a.codonCompare(b));  // diff for Codons btwn a & b
    }
    //Testing making an AminoAcid with a string that is a stopping condition, for both a & b
    @Test
    public void AminoAcidLL2(){
        AminoAcidLL a = new AminoAcidLL("UAG");
        AminoAcidLL b = new AminoAcidLL("UAG");
        AminoAcidLL.sort(a);  //Sorts both a & b
        AminoAcidLL.sort(b);
        assertTrue(a.isSorted()); //Checks if a & b are sorted
        assertTrue(b.isSorted());

        char aChar[], bChar[];    //Making the count and codon arrays for a & b
        int aCounts[], bCounts[];
        aChar = a.aminoAcidList();
        bChar = b.aminoAcidList();    //Setting the values for the previous arrays
        aCounts = a.aminoAcidCounts();
        bCounts = b.aminoAcidCounts();

        assertArrayEquals(aChar,bChar);  //Seeing if the arrays are equal then return true
        assertArrayEquals(aCounts,bCounts);
        assertEquals(0,a.aminoAcidCompare(b)); //Whether the compare methods count returns 0
        assertEquals(0,a.codonCompare(b));
    }
    //Testing for making an AminoAcidLL with an empty constructor
    @Test
    public void AminoAcidLL3(){
        AminoAcidLL a = new AminoAcidLL();
        AminoAcidLL b = new AminoAcidLL();
        AminoAcidLL.sort(a); //Sorting the lists
        AminoAcidLL.sort(b);
        assertTrue(a.isSorted()); // Checking if a & b is sorted
        assertTrue(b.isSorted());
        char aChar[], bChar[];   //Initializing the Count and Codon Arrays for a/b
        int aCounts[], bCounts[];
        aChar = a.aminoAcidList();
        bChar = b.aminoAcidList();
        aCounts = a.aminoAcidCounts();
        bCounts = b.aminoAcidCounts();
        assertArrayEquals(aChar,bChar);  //Checking to see if the arrays are equal
        assertArrayEquals(aCounts,bCounts);
    }
    //Testing building a single AminoAcidLL where the String is less than 3
    @Test
    public void AminoAcidLL4(){
        AminoAcidLL a = new AminoAcidLL("UA");
        AminoAcidLL b = new AminoAcidLL("UA");
        AminoAcidLL.sort(a);  //Use the sorting method to sort a/b
        AminoAcidLL.sort(b);
        assertTrue(a.isSorted());
        assertTrue(b.isSorted());  //Making sure both a/b are sorted
        char aChar[], bChar[];
        int aCounts[], bCounts[];  //Producing the 4 total arrays for a/b
        aChar = a.aminoAcidList();
        bChar = b.aminoAcidList();    //Getting their values from the methods aminoAcidList()/aminoAcidCounts
        aCounts = a.aminoAcidCounts();
        bCounts = b.aminoAcidCounts();

        assertArrayEquals(aChar,bChar);  //Making sure both aChar arrays are equal
        assertArrayEquals(aCounts,bCounts);  //Making sure the counts arrays are equal
        assertEquals(0,a.aminoAcidCompare(b));
        assertEquals(0,a.codonCompare(b)); //Using assertEquals for methods aminoAcidCompare/codonCompare
    }
    //Testing the method createRNAFromSequence with a codon and stopping condition
    @Test
    public void AminoAcidLL5(){
        AminoAcidLL a;
        a = AminoAcidLL.createFromRNASequence("GCUUAG");
        AminoAcidLL b;
        b = AminoAcidLL.createFromRNASequence("GCUUAG"); // Initiating both a/b to "GCU UAG"
        AminoAcidLL.sort(a);
        AminoAcidLL.sort(b);  //Sort a/b
        assertTrue(a.isSorted()); //Returns true if a/b are sorted
        assertTrue(b.isSorted());
        char aChar[], bChar[];
        int aCounts[], bCounts[]; //Making the counts and character arrays for each AminoAcidLL
        aChar = a.aminoAcidList();
        bChar = b.aminoAcidList();
        aCounts = a.aminoAcidCounts(); //Giving the arrays values
        bCounts = b.aminoAcidCounts();
        assertArrayEquals(aChar,bChar);
        assertArrayEquals(aCounts,bCounts);
        assertEquals(0,a.aminoAcidCompare(b)); //Return 0 if both arrays are equal
        assertEquals(0,a.codonCompare(b));
    }
    //Testing createRNAFromSequence where the stopping condition is between two codons
    @Test
    public void AminoAcidLL6(){
        AminoAcidLL a;
        a = AminoAcidLL.createFromRNASequence("GCUUAGAGC");
        AminoAcidLL b;
        b = AminoAcidLL.createFromRNASequence("GCUUAGAGC"); //
        AminoAcidLL.sort(a);
        AminoAcidLL.sort(b);
        assertTrue(a.isSorted());
        assertTrue(b.isSorted());
        char aChar[], bChar[];
        int aCounts[], bCounts[];
        aChar = a.aminoAcidList();
        bChar = b.aminoAcidList();
        aCounts = a.aminoAcidCounts();
        bCounts = b.aminoAcidCounts();
        assertArrayEquals(aChar,bChar);
        assertArrayEquals(aCounts,bCounts);
        assertEquals(0,a.aminoAcidCompare(b));
        assertEquals(0,a.codonCompare(b));
    }
    //Testing a sequence with a total length of 7
    @Test
    public void AminoAcidLL7(){
        AminoAcidLL a;
        a = AminoAcidLL.createFromRNASequence("GCUACGGAGCUUCGGAGCUAG");
        AminoAcidLL b;
        b = AminoAcidLL.createFromRNASequence("GCUACGGAGCUUCGGAGCUAG");
        AminoAcidLL.sort(a); //Sorting 7 nodes
        AminoAcidLL.sort(b);
        assertTrue(a.isSorted());
        assertTrue(b.isSorted()); //Make sure a/b are sorted
        char aChar[], bChar[];
        int aCounts[], bCounts[];
        aChar = a.aminoAcidList();
        bChar = b.aminoAcidList(); //Initiatig the count and codn arrays and setting them equal
        aCounts = a.aminoAcidCounts(); // to their respective values
        bCounts = b.aminoAcidCounts();
        assertArrayEquals(aChar,bChar);
        assertArrayEquals(aCounts,bCounts);
        assertEquals(0,a.aminoAcidCompare(b)); // Making sure the compare methods work, since it'll equal
        assertEquals(0,a.codonCompare(b));     // 0 if the the arrays are equal
    }
    @Test
    //Testing RNAFromSequence with a empty String
    public void AminoAcidLL8(){
        AminoAcidLL a;
        a = AminoAcidLL.createFromRNASequence("");
        AminoAcidLL b;
        b = AminoAcidLL.createFromRNASequence("");
        AminoAcidLL.sort(a);  //Since its a null object, the sort method just returns null
        AminoAcidLL.sort(b);
        assertNull(a);
        assertNull(b);  //Checking if the objects are null
    }
    //Testing RNAFromSequence with only one codon
    @Test
    public void AminoAcidLL9(){
        AminoAcidLL a;
        a = AminoAcidLL.createFromRNASequence("GCU");
        AminoAcidLL b;
        b = AminoAcidLL.createFromRNASequence("GCU");
        AminoAcidLL.sort(a); //Sort both a/b AminoAcidLL
        AminoAcidLL.sort(b);
        assertTrue(a.isSorted());
        assertTrue(b.isSorted()); // Checking if both a/b are sorted
        char aChar[], bChar[];
        int aCounts[], bCounts[];
        aChar = a.aminoAcidList();
        bChar = b.aminoAcidList();
        aCounts = a.aminoAcidCounts(); //Setting the values for the arrays that were initiated with counts and codons
        bCounts = b.aminoAcidCounts();
        assertArrayEquals(aChar,bChar);
        assertArrayEquals(aCounts,bCounts);
        assertEquals(0,a.aminoAcidCompare(b)); // Making sure compare methods work
        assertEquals(0,a.codonCompare(b));
    }
    //Testing RNAFromSequence with a string length less than 3
    @Test
    public void AminoAcidLL10(){
        AminoAcidLL a;
        a = AminoAcidLL.createFromRNASequence("GC");
        AminoAcidLL b;
        b = AminoAcidLL.createFromRNASequence("GC"); //Method will return null since if the string length is < 3
        AminoAcidLL.sort(a);                         // its not a valid codon
        AminoAcidLL.sort(b);  //Can sort a null object, since it will just return null
        assertNull(a);
        assertNull(b); //Making sure the AminoAcidLL are null
    }
}
