package exceptions;

import javax.xml.ws.WebFault;

@WebFault(name = "LifeLeftException")
public class LifeLeftException extends Exception {

    /*
    on d�clare une instance de LifeLeftFault qu'on cr��e pr�c�demment
    afin de r�cup�rer ensuite les messages et codes d'erreurs � renvoyer dans cette exception
     */
    private LifeLeftFault fault;

    /*
    On cr�e un constructeur qui prend en param�tre un message d'erreur et un objet LifeLeftFault
    avec plus de d�tails sur l'erreur
    */
    public LifeLeftException(String message, LifeLeftFault fault) {
        super(message);
        this.fault = fault;
    }

    public LifeLeftException(String message, Throwable cause, LifeLeftFault fault) {
        super(message, cause);
        this.fault = fault;
    }
    
    

    public LifeLeftFault getFaultInfo() {
        return fault;
    }
   
}



