import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

public class AminoAcidLLTester {
//"GCUACGGAGCUUCGGAGCUAG"
    @Test
    public void AminoAcidLL1(){
        AminoAcidLL a = new AminoAcidLL("GCU");
        AminoAcidLL b = new AminoAcidLL("GCU");
        AminoAcidLL.sort(a);
        AminoAcidLL.sort(b);
        assertTrue(a.isSorted());
        assertTrue(b.isSorted());
        char aCHar[], bChar[];
        int aCounts[], bCounts[];
        aCHar = a.aminoAcidList();
        bChar = b.aminoAcidList();
        aCounts = a.aminoAcidCounts();
        bCounts = b.aminoAcidCounts();

        assertArrayEquals(aCounts,bCounts);
    }
    @Test
    public void AminoAcidLL2(){
        AminoAcidLL a = new AminoAcidLL("UAG");
        AminoAcidLL b = new AminoAcidLL("UAG");
        AminoAcidLL.sort(a);
        AminoAcidLL.sort(b);
        assertTrue(a.isSorted());
        assertTrue(b.isSorted());
        char aCHar[], bChar[];
        int aCounts[], bCounts[];
        aCHar = a.aminoAcidList();
        bChar = b.aminoAcidList();
        aCounts = a.aminoAcidCounts();
        bCounts = b.aminoAcidCounts();
    }
    @Test
    public void AminoAcidLL3(){
        AminoAcidLL a = new AminoAcidLL();
        AminoAcidLL b = new AminoAcidLL();
        AminoAcidLL.sort(a);
        AminoAcidLL.sort(b);
        assertTrue(a.isSorted());
        assertTrue(b.isSorted());
        char aCHar[], bChar[];
        int aCounts[], bCounts[];
        aCHar = a.aminoAcidList();
        bChar = b.aminoAcidList();
        aCounts = a.aminoAcidCounts();
        bCounts = b.aminoAcidCounts();
    }
    @Test
    public void AminoAcidLL4(){
        AminoAcidLL a = new AminoAcidLL("UA");
        AminoAcidLL b = new AminoAcidLL("UA");
        AminoAcidLL.sort(a);
        AminoAcidLL.sort(b);
        assertTrue(a.isSorted());
        assertTrue(b.isSorted());
        char aCHar[], bChar[];
        int aCounts[], bCounts[];
        aCHar = a.aminoAcidList();
        bChar = b.aminoAcidList();
        aCounts = a.aminoAcidCounts();
        bCounts = b.aminoAcidCounts();
    }
    @Test
    public void AminoAcidLL5(){
        AminoAcidLL a;
        a = AminoAcidLL.createFromRNASequence("GCUUAG");
        AminoAcidLL b;
        b = AminoAcidLL.createFromRNASequence("GCUUAG");
        AminoAcidLL.sort(a);
        AminoAcidLL.sort(b);
        assertTrue(a.isSorted());
        assertTrue(b.isSorted());
        char aCHar[], bChar[];
        int aCounts[], bCounts[];
        aCHar = a.aminoAcidList();
        bChar = b.aminoAcidList();
        aCounts = a.aminoAcidCounts();
        bCounts = b.aminoAcidCounts();
    }
    @Test
    public void AminoAcidLL6(){
        AminoAcidLL a;
        a = AminoAcidLL.createFromRNASequence("GCUUAGAGC");
        AminoAcidLL b;
        b = AminoAcidLL.createFromRNASequence("GCUUAGAGC");
        AminoAcidLL.sort(a);
        AminoAcidLL.sort(b);
        assertTrue(a.isSorted());
        assertTrue(b.isSorted());
        char aCHar[], bChar[];
        int aCounts[], bCounts[];
        aCHar = a.aminoAcidList();
        bChar = b.aminoAcidList();
        aCounts = a.aminoAcidCounts();
        bCounts = b.aminoAcidCounts();
    }
    @Test
    public void AminoAcidLL7(){
        AminoAcidLL a;
        a = AminoAcidLL.createFromRNASequence("GCUACGGAGCUUCGGAGCUAG");
        AminoAcidLL b;
        b = AminoAcidLL.createFromRNASequence("GCUACGGAGCUUCGGAGCUAG");
        AminoAcidLL.sort(a);
        AminoAcidLL.sort(b);
        assertTrue(a.isSorted());
        assertTrue(b.isSorted());
        char aCHar[], bChar[];
        int aCounts[], bCounts[];
        aCHar = a.aminoAcidList();
        bChar = b.aminoAcidList();
        aCounts = a.aminoAcidCounts();
        bCounts = b.aminoAcidCounts();
    }
    @Test
    public void AminoAcidLL8(){
        AminoAcidLL a;
        a = AminoAcidLL.createFromRNASequence("");
        AminoAcidLL b;
        b = AminoAcidLL.createFromRNASequence("");
        AminoAcidLL.sort(a);
        AminoAcidLL.sort(b);
        assertNull(a);
        assertNull(b);
    }
    @Test
    public void AminoAcidLL9(){
        AminoAcidLL a;
        a = AminoAcidLL.createFromRNASequence("GCU");
        AminoAcidLL b;
        b = AminoAcidLL.createFromRNASequence("GCU");
        AminoAcidLL.sort(a);
        AminoAcidLL.sort(b);
        assertTrue(a.isSorted());
        assertTrue(b.isSorted());
        char aCHar[], bChar[];
        int aCounts[], bCounts[];
        aCHar = a.aminoAcidList();
        bChar = b.aminoAcidList();
        aCounts = a.aminoAcidCounts();
        bCounts = b.aminoAcidCounts();
    }
    @Test
    public void AminoAcidLL10(){
        AminoAcidLL a;
        a = AminoAcidLL.createFromRNASequence("GC");
        AminoAcidLL b;
        b = AminoAcidLL.createFromRNASequence("GC");
        AminoAcidLL.sort(a);
        AminoAcidLL.sort(b);
        assertNull(a);
        assertNull(b);
    }
}
