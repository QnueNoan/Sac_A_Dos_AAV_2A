/*
 Souccouchetty Darlène Groupe 204/ Merand Yoann Groupe 206
 Projet AAV-2A : Problème du sac à dos 
 Classe Sac à dos
 */
package problemeSacADos;
// Importation des packages
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
//Classe modélisant un sac à dos & ses attributs
public class SacADos {
	private static float poidsMax;//Poids max supporté par le sac
	private static float poidsAct;//Poids actualisé du sac
	private static ArrayList<Objet>obj;//Liste des objets disponibles
	private static ArrayList<Objet>objDuSac;//Liste des emplacements disponibles pour des objets dans le sac
	//Constructeur permettant de générer un sac à dos vide
	public SacADos() {
			obj = new ArrayList<Objet>();
			objDuSac = new ArrayList<Objet>();
}
//Constructeur permettant de générer un sac à dos, prennant en paramètre le chemin du fichier où le poids maximal et la liste des objets du sac à dos sont renseignés
	@SuppressWarnings("static-access")
	public SacADos(float poidsMax,String chemin) {
		this.poidsMax = poidsMax;
		objDuSac = new ArrayList<Objet>();
	}
	
//Getter renvoyant le PoidsMax du sac
public float getPoidsMax() {
	return poidsMax;
}
//Méthode permettant d'ajouter un objet supplémentaire dans la liste des objets disponibles
public static void ajouterObjetSuppl (float poids, float val, String nomObj) {
	Objet element = new Objet(poids,val,nomObj);
	obj.add(element);
}

//Méthode "For each" renvoyant la liste des objets disponibles/restants à pouvoir mettre dans le sac
public void getListeElement() {
	int cpt = 1;
	
	for (Objet element : obj) {
		System.out.println (cpt + ";" + element.getNomObj());
		++cpt;
	}
}
//Méthode permettant d'ajouter un objet parmi la liste "obj" à l'intérieur du sac

public void ajouterObj(Objet element) {
	objDuSac.add(element);
}
//Méthode renvoyant la liste des objets contenus dans le sac
public ArrayList<Objet> getElement() {
	return obj;
}
//Méthode "For each" renvoyant le nom des objets contenus dans le sac
public void getNomElement() {
	int cpt = 1;
	for (Objet element : objDuSac) {
		System.out.println (cpt + ";"+ element.getNomObj());
		++cpt;
	}
}
//Méthode renvoyant le poids cummulé courant du sac
public float getPoidsCourant() {
	float sommeP = 0;
	for(Objet element : obj) {
		sommeP+= element.getPoids();
	}
	return (sommeP);
}
//Méthode renvoyant la valeur cummulée courante des éléments dans le sac
public float getValCourante() {
	float sommeV = 0;
	for (Objet element : obj) {
		sommeV += element.getVal();
	}
	return (sommeV);
}
//Méthode permettant de contrôler le poids du sac de sorte à ce que "poids"<= "poidsMax"
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
				System.out.println("Impossible d'ajouter l'élément" + element.getNomObj()+ "on ne peut pas dépasser" + poidsMax + "kg");
			}
			else if (poidsAct==poidsMax)
				System.out.println("Vous avez atteint le poids maximal que peut contenir le sac");	
	
		}
	}
	
}

//Méthode permettant de lire/parcourir les éléments d'un fichier type "element.txt", prend en paramètre le nom du fichier + son chemin
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

	
		

	
