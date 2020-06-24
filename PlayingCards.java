Program 2 - Playing cards Sequence

public class Card {

    public static final String[] VALUES = {
        null, "Ace", "2", "3", "4", "5", "6", "7",
        "8", "9", "10", "Jack", "Queen", "King"};

    public static final String[] SUITS = {
        "Clubs", "Diamonds", "Hearts", "Spades"};

public String getSuitAsString() {
      switch ( suit ) {
      case SPADES:   return "S";
      case HEARTS:   return "H";
      case DIAMONDS: return "D";
      case CLUBS:    return "C";
      default:       return "J";
      }

 public String getValueAsString() {
      
      
         switch ( value ) {
         case 1:   return "Ace";
         case 2:   return "2";
         case 3:   return "3";
         case 4:   return "4";
         case 5:   return "5";
         case 6:   return "6";
         case 7:   return "7";
         case 8:   return "8";
         case 9:   return "9";
         case 10:  return "10";
         case 11:  return "J";
         case 12:  return "Q";
         default:  return "K";
      }   
      
   }

public int getNumericRank(){
 if (rank.equals("K"))
 return 13;
 if (rank.equals("Q"))
 return 12;
 if (rank.equals("J"))
 return 11;
 if (rank.equals("A"))
 return 1;
 return
Integer.parseInt(rank);
 } 

public String toString() {
         return getValueAsString() + " # " + getSuitAsString();
   }



}