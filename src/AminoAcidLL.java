class AminoAcidLL{
  char aminoAcid;
  String[] codons;
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
    return 0;
  }

  /********************************************************************************************/
  /* Same ad above, but counts the codon usage differences
   * Must be sorted. */
  public int codonCompare(AminoAcidLL inList){
    return 0;
  }


  /********************************************************************************************/
  /* Recursively returns the total list of amino acids in the order that they are in in the linked list. */
  public char[] aminoAcidList(){
    char list[] = new char[LListLength(this)];
    aminoAcidList(this,0,list);
    return list;
  }

  public char[] aminoAcidList(AminoAcidLL head, int count, char[] list){
    if(head.next == null){
      list[count] = head.aminoAcid;
      return list;
    }
      list[count] = head.aminoAcid;
      return aminoAcidList(head.next,count++,list);

  }

  /********************************************************************************************/
  /* Recursively returns the total counts of amino acids in the order that they are in in the linked list. */
  public int[] aminoAcidCounts(){
    return new int[]{};
  }


  /********************************************************************************************/
  /* recursively determines if a linked list is sorted or not */
  public boolean isSorted(){
    return false;
  }


  /********************************************************************************************/
  /* Static method for generating a linked list from an RNA sequence */
  public static AminoAcidLL createFromRNASequence(String inSequence){

      int count = 3;
      AminoAcidLL iterator = new AminoAcidLL(inSequence.substring(0,3));
     // inSequence = inSequence.substring(count);
      while(count < inSequence.length()){
        //condition for * to break from the loop
        inSequence = inSequence.substring(count);
          iterator.addCodon(inSequence.substring(0, 3));
      }
      return iterator;
  }


  /**************************************************************************************************/
  /* sorts a list by amino acid character*/
  public static AminoAcidLL sort(AminoAcidLL inList) {
    int n = inList.LListLength(inList);
    AminoAcidLL iterator = inList;
    for (int i = 0; i < n - 1; i++){
      for (int j = 0; j < n - i - 1; j++){
        if (iterator.next != null && iterator.aminoAcid > iterator.next.aminoAcid) {
          AminoAcidLL temp = iterator.next;
          iterator.next = iterator;
          iterator = temp;
        }
      }
    }

    return iterator;
  }
  /************************************ Helper Methods **********************************************/

  public void incrCodons(String c){
    //increase appropriate codon by traversing the list
      for(int i = 0; i < codons.length; i++){
        if(codons[i].equals(c))
            counts[i]++;
      }
  }

  public int LListLength(AminoAcidLL head){
    int l = 0;
    AminoAcidLL iterator = head;
    while(iterator != null){
      iterator = iterator.next;
      l++;
    }
    return l;
  }
}