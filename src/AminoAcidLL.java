class AminoAcidLL{
  char aminoAcid;
  String[] codons; //AAA BBB
  int[] counts;
  AminoAcidLL next;

  AminoAcidLL(){

  }


  /********************************************************************************************/
  /* Creates a new node, with a given amino acid/codon 
   * pair and increments the codon counter for that codon.
   * NOTE: Does not check for repeats!! */
  AminoAcidLL(String inCodon){
    aminoAcid = AminoAcidResources.getAminoAcidFromCodon(inCodon);
    codons = AminoAcidResources.getCodonListForAminoAcid(aminoAcid);
    counts = new int[codons.length];//helper method incrCodons
    incrCodons(inCodon);
    next = null;
  }

  /********************************************************************************************/
  /* Recursive method that increments the count for a specific codon:
   * If it should be at this node, increments it and stops, 
   * if not passes the task to the next node. 
   * If there is no next node, add a new node to the list that would contain the codon. 
   */
  private void addCodon(String inCodon) {
    if (AminoAcidResources.getAminoAcidFromCodon(inCodon) == aminoAcid) {
      incrCodons(inCodon);
    } else if (this.next != null) {
      next.addCodon(inCodon);
    } else{
      next = new AminoAcidLL(inCodon);
    }
  }


  /********************************************************************************************/
  /* Shortcut to find the total number of instances of this amino acid */
  private int totalCount(){
    int sum = 0;
    for(int i = 0; i < counts.length; i++){
      sum+=counts[i];
    }
    return sum;
  }

  /********************************************************************************************/
  /* helper method for finding the list difference on two matching nodes
  *  must be matching, but this is not tracked */
  private int totalDiff(AminoAcidLL inList){
    return Math.abs(totalCount() - inList.totalCount());
  }


  /********************************************************************************************/
  /* helper method for finding the list difference on two matching nodes
  *  must be matching, but this is not tracked */
  private int codonDiff(AminoAcidLL inList){
    int diff = 0;
    for(int i=0; i<codons.length; i++){
      diff += Math.abs(counts[i] - inList.counts[i]);
    }
    return diff;
  }

  /********************************************************************************************/
  /* Recursive method that finds the differences in **Amino Acid** counts. 
   * the list *must* be sorted to use this method */
  public int aminoAcidCompare(AminoAcidLL inList){
    int diff = 0;
    if(inList.isSorted() && this.isSorted()){
      diff = aminoAcidCompare(this, inList, diff);
    }
    return diff;
  }
  public int aminoAcidCompare(AminoAcidLL inList, AminoAcidLL inList2, int diff){//inList : A>B>C>D
    if(inList == null && inList2 == null){                                       //inList2: A>B>C>D>E
      return diff;
    } else if(inList == null){
      diff = diff - inList2.totalCount();
      return aminoAcidCompare(inList, inList2, diff);
    } else if(inList2 == null){
      diff = diff + inList.totalCount();
    }else
      diff = diff + (inList.totalDiff(inList2));
      return aminoAcidCompare(inList.next,inList2.next,diff);
  }

  /********************************************************************************************/
  /* Same ad above, but counts the codon usage differences
   * Must be sorted. */
  public int codonCompare(AminoAcidLL inList){
    int diff = 0;
    if(inList.isSorted()){
      diff = codonCompare(this, inList, diff);
    }
    return diff;
  }

  public int codonCompare(AminoAcidLL inList, AminoAcidLL inList2, int diff){
    if(inList == null && inList2 == null) {
      return diff;
    } else if(inList == null){
      diff = diff + codonDiff(inList2);
      codonCompare(inList,inList2.next,diff);
    } else if(inList2 == null){
      diff = diff + inList.codonDiff(inList2);
      return codonCompare(inList.next,inList2,diff);
    }
      diff = diff + inList.codonDiff(inList2);
      return codonCompare(inList.next, inList2.next, diff);

  }

  /********************************************************************************************/
  /* Recursively returns the total list of amino acids in the order that they are in in the linked list. */
  public char[] aminoAcidList(){
    char list[] = new char[LListLength()];
    aminoAcidList(this,0,list);
    return list;
  }

  public char[] aminoAcidList(AminoAcidLL head, int count, char[] list){
    if(head.next == null){
      list[count] = head.aminoAcid;
      return list;
    }
      list[count] = head.aminoAcid;
      count++;
      return aminoAcidList(head.next,count,list);

  }

  /********************************************************************************************/
  /* Recursively returns the total counts of amino acids in the order that they are in in the linked list. */
  public int[] aminoAcidCounts(){
    int[] oof = new int[LListLength()];
    aminoAcidCounts(this,0,oof);
    return oof;
  }

  public int[] aminoAcidCounts(AminoAcidLL head, int count, int[] oof){
   if(head.next == null){
     oof[count] = head.aminoAcid;
     return oof;
   }
    oof[count] = head.aminoAcid;
    count++;
    return aminoAcidCounts(head.next,count,oof);
  }

  /********************************************************************************************/
  /* recursively determines if a linked list is sorted or not */
  public boolean isSorted(){
    if(next == null){
      return true;
    }
    return (this.aminoAcid < next.aminoAcid && next.isSorted());
  }


  /********************************************************************************************/
  /* Static method for generating a linked list from an RNA sequence */
  public static AminoAcidLL createFromRNASequence(String inSequence){
      //dasdvscvcxv
      int count = 3;
      if(inSequence.length() < 3)
          return null;
      AminoAcidLL iterator = new AminoAcidLL(inSequence.substring(0,3)); //head "das"

      while(count < inSequence.length()){
        //condition for * to break from the loop
        if(AminoAcidResources.getAminoAcidFromCodon(inSequence.substring(0,3)) == '*'){// stopping condition *
          break;
        }
        inSequence = inSequence.substring(count); //dasdvscvcxv -> dvscvcxv
        iterator.addCodon(inSequence.substring(0, 3)); //dvs
      }
      return iterator;
  }


  /*****************************************  Sorting   ********************************************/
  /* sorts a list by amino acid character*/
  public static AminoAcidLL sort(AminoAcidLL inList) {

    if (inList == null || inList.next == null) {
      return inList;
    }
    // get the middle of the list
    AminoAcidLL mid = getMiddle(inList);
    AminoAcidLL mNext = mid.next;
    // set the next of middle node to null
    mid.next = null;

    // Apply mergeSort on left list
    AminoAcidLL left = sort(inList);

    // Apply mergeSort on right list
    AminoAcidLL right = sort(mNext);

    // Merge the left and right lists
    AminoAcidLL sortedlist = merge(left, right);
    return sortedlist;
  }
  private static AminoAcidLL getMiddle(AminoAcidLL head){
    if(head == null)
      return head;
    AminoAcidLL oneStep = head;
    AminoAcidLL twoStep = head;

    while(twoStep.next != null && twoStep.next.next != null){
      oneStep = oneStep.next;
      twoStep = twoStep.next.next;
    }
    return oneStep;
  }
  public static AminoAcidLL merge(AminoAcidLL a, AminoAcidLL b) {
    AminoAcidLL result = null;
    /* Base cases */
    if (a == null)
      return b;
    if (b == null)
      return a;

    /* Pick either a or b, and recur */
    if (a.aminoAcid <= b.aminoAcid) {
      result = a;
      result.next = merge(a.next, b);
    }
    else {
      result = b;
      result.next = merge(a, b.next);
    }
    return result;
  }
  /************************************ Helper Methods **********************************************/

  public void incrCodons(String c){
    //increase appropriate codon by traversing the list
      for(int i = 0; i < codons.length; i++){
        if(codons[i].equals(c)) {
          counts[i]++;
          break;
        }
      }
  }

  public int LListLength(){
    int l = 0;
    AminoAcidLL iterator = this;
    while(iterator != null){
      iterator = iterator.next;
      l++;
    }
    return l;
  }
}