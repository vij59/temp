package com.lifeleft;

import javax.jws.WebMethod;
import javax.jws.WebService;

import exceptions.LifeLeftException;
import exceptions.LifeLeftFault;

import java.time.Year;
import java.util.concurrent.ThreadLocalRandom;


@WebService(serviceName = "LifeLeft")
public class LifeLeftService {

    private static final Integer ESPERANCE_VIE_HOMMES = 79;
    private static final Integer ESPERANCE_VIE_FEMMES = 85;

    String homme = "homme";
    String femme = "femme";

    Integer evDeReference = 0;

    @WebMethod
    public String  anneesRestantesAVivre (String prenom, String genre, Integer anneeNaissance) throws LifeLeftException {

        //vaut mieux remplacer 2017 par Year.now().getValue(), mais pour simplifier on laisse 2017
        if(anneeNaissance > 2017) {

            //On cr�er une nouvelle instance de notre POJO
            LifeLeftFault fault = new LifeLeftFault();

            //On y ajoute le code d'erreur et le d�tail de l'erreur en question
            fault.setFaultCode("1234");
            fault.setFaultString("L'ann�e re�u est sup�rieur l'ann�e actuelle");

            //on lance l'exception avec comme premier argument un message g�n�ral sur l'erreur.
            throw new LifeLeftException("Ann�e invalide", fault);
        }

        if(genre.equals(homme)) evDeReference = ESPERANCE_VIE_HOMMES;
        else evDeReference = ESPERANCE_VIE_FEMMES;

        //Remarque, en cas de probl�me, vous pouvez changer Year.now().getValue() par Calendar.getInstance().get(Calendar.YEAR)
        Integer anneeRestantes = evDeReference -(Year.now().getValue() - anneeNaissance );



        return "Bonjour " + prenom + ", il vous reste " + anneeRestantes + " ans, � vivre, Profitez-en au maximum !";
    }

}
