/*
 Souccouchetty Darl�ne Groupe 204/ Merand Yoann Groupe 206
 Projet AAV-2A : Probl�me du sac � dos 
 Classe Sac � dos
 */
package problemeSacADos;
// Importation des packages
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
//Classe mod�lisant un sac � dos & ses attributs
public class SacADos {
	private static float poidsMax;//Poids max support� par le sac
	private static float poidsAct;//Poids actualis� du sac
	private static ArrayList<Objet>obj;//Liste des objets disponibles
	private static ArrayList<Objet>objDuSac;//Liste des emplacements disponibles pour des objets dans le sac
	//Constructeur permettant de g�n�rer un sac � dos vide
	public SacADos() {
			obj = new ArrayList<Objet>();
			objDuSac = new ArrayList<Objet>();
}
//Constructeur permettant de g�n�rer un sac � dos, prennant en param�tre le chemin du fichier o� le poids maximal et la liste des objets du sac � dos sont renseign�s
	@SuppressWarnings("static-access")
	public SacADos(float poidsMax,String chemin) {
		this.poidsMax = poidsMax;
		objDuSac = new ArrayList<Objet>();
	}
	
//Getter renvoyant le PoidsMax du sac
public float getPoidsMax() {
	return poidsMax;
}
//M�thode permettant d'ajouter un objet suppl�mentaire dans la liste des objets disponibles
public static void ajouterObjetSuppl (float poids, float val, String nomObj) {
	Objet element = new Objet(poids,val,nomObj);
	obj.add(element);
}

//M�thode "For each" renvoyant la liste des objets disponibles/restants � pouvoir mettre dans le sac
public void getListeElement() {
	int cpt = 1;
	
	for (Objet element : obj) {
		System.out.println (cpt + ";" + element.getNomObj());
		++cpt;
	}
}
//M�thode permettant d'ajouter un objet parmi la liste "obj" � l'int�rieur du sac

public void ajouterObj(Objet element) {
	objDuSac.add(element);
}
//M�thode renvoyant la liste des objets contenus dans le sac
public ArrayList<Objet> getElement() {
	return obj;
}
//M�thode "For each" renvoyant le nom des objets contenus dans le sac
public void getNomElement() {
	int cpt = 1;
	for (Objet element : objDuSac) {
		System.out.println (cpt + ";"+ element.getNomObj());
		++cpt;
	}
}
//M�thode renvoyant le poids cummul� courant du sac
public float getPoidsCourant() {
	float sommeP = 0;
	for(Objet element : obj) {
		sommeP+= element.getPoids();
	}
	return (sommeP);
}
//M�thode renvoyant la valeur cummul�e courante des �l�ments dans le sac
public float getValCourante() {
	float sommeV = 0;
	for (Objet element : obj) {
		sommeV += element.getVal();
	}
	return (sommeV);
}
//M�thode permettant de contr�ler le poids du sac de sorte � ce que "poids"<= "poidsMax"
public static void controlePoids() {
	while (poidsAct!=poidsMax);
	{
		for (Objet element : obj)
		{
			if(element.getPoids()<poidsMax) {
				objDuSac.add(element);
				poidsAct = poidsAct + element.getPoids();
			}
			else if (element.getPoids()>poidsMax) {
				System.out.println("Impossible d'ajouter l'�l�ment" + element.getNomObj()+ "on ne peut pas d�passer" + poidsMax + "kg");
			}
			else if (poidsAct==poidsMax)
				System.out.println("Vous avez atteint le poids maximal que peut contenir le sac");	
	
		}
	}
	
}

//M�thode permettant de lire/parcourir les �l�ments d'un fichier type "element.txt", prend en param�tre le nom du fichier + son chemin
public static void LireFichierTxt(String chemin) throws FileNotFoundException {
	try {
		File fichier = new File (chemin + ".txt");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(fichier).useDelimiter(" ; |\n");
		
		while (scanner.hasNext()) {
			ajouterObjetSuppl(Float.parseFloat(scanner.next()), Float.parseFloat(scanner.next()), scanner.next());
		}
		
		scanner.close();
	}
	catch (FileNotFoundException NotFounded) {
		System.out.println("Fichier inexistant");
	}
}
public ArrayList <Objet> getObjDuSac()
{
	return objDuSac;
}

}

	
		

	
