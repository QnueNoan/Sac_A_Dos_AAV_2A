/*
 Souccouchetty Darlène Groupe 204/ Merand Yoann Groupe 206
 Projet AAV-2A : Problème du sac à dos 
 Classe Objet
 */
package problemeSacADos;

// Classe modélisant un objet i à mettre dans le sac à dos & ses attributs
public class Objet {
	private float poids;//Poids d'un objet i 
	private float val;//Valeur d'un objet i
	private float rapportVP;//Rapport (vi/pi) d'un objet i;
	private String nomObj;//Nom d'un objet i
	
//Constructeur d'un objet i, prennant en paramètre poids,valeur & nomObj
public Objet(float poids,float val, String nomObj) {
	this.poids = poids;
	this.val = val;
	this.nomObj = nomObj;
	this.rapportVP = val / poids; //Rapport (vi/pi)
}
//Getter renvoyant un objet i de l'instance courante
public Objet getObjet() {
	return this;
}
//Getter renvoyant le poids d'un objet i
public float getPoids() {
	return poids;
}
//Getter renvoyant la valeur d'un objet i
public float getVal() {
	return val;
}
//Getter renvoyant le rapport (vi/pi) d'un objet i
public float getRapportVP() {
	return rapportVP;
}
//Getter renvoyant le nom d'un objet i choisi 
public String getNomObj () {
	return nomObj;
}
//Méthode toString() renvoyant les éléments caractéristiques d'un objet i 
public String toString() {
	return nomObj + ";" + val + ";" + poids ;
}
}
