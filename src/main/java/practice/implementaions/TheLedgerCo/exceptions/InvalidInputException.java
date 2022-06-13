package practice.implementaions.TheLedgerCo.exceptions;


public class InvalidInputException extends Exception{

   public InvalidInputException(String message, String additionalMessage){
       super(message);
   }
}
