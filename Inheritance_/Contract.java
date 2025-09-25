
public class Contract extends Employee {

  private double nbHours = -1.0;
  private double hourRate = -1.0;
  private double percentHourSup  = -1.0;
  private static final double dueHour  = 40.0;

/** Constructeur qui prend en paramètre que le nom de l'employé. 
 Hérite du nom provenant de Employee.**/

   Contract(String name) {
    super(name);
  }

/** Constructeur qui prend en paramètre que le nom de l'employé 
et toutes les informations pour le calcul du salaire. 
Hérite du nom provenant de Employee. mais les autres paramètres sont propres à la classe Contract**/

    Contract (String name, double nbHours, double hourRate, double percentHourSup) {
    super(name);
    this.nbHours = nbHours;
    this.hourRate = hourRate;
    this.percentHourSup = percentHourSup;
    
  }

/** Modificateur qui entre ou modifie les informations nécessaires pour calculer le salaire.**/

    public void setSalaryInfo(double nbHours, double hourRate, double percentHourSup) {
    this.nbHours = nbHours;
    this.hourRate = hourRate;
    this.percentHourSup = percentHourSup;
  }
  
   
/** Accesseur qui fait le calcul du salaire le renvoie. **/

    public double getSalary() {
    if (nbHours != -1.0 && hourRate != -1.0 && percentHourSup != -1.0 ) {
	if (nbHours>dueHour){
           return (nbHours*hourRate + (percentHourSup/100)*(nbHours-dueHour)*hourRate);
        }
        else{
            return nbHours*hourRate;
            }
	}
    else {
      return -1.0;
  }
   }

  public double getNbHours() {  
    return nbHours;
  }

  public double getHourRate() {
    return hourRate;
  }

  public double getPercentHourSup() {
    return percentHourSup;
  }

   public String toString() {
    return super.toString() + "; nbHours=" + nbHours 
      + "; Hour rate=" + hourRate + "; % Hour Sup=" + percentHourSup;
  }

}

