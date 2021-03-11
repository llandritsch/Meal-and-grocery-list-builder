package entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TotalNutrients{

	@JsonProperty("CHOCDF")
	private CHOCDF cHOCDF;
	@JsonProperty("ENERC_KCAL")
	private ENERCKCAL eNERCKCAL;
	@JsonProperty("PROCNT")
	private PROCNT pROCNT;
	@JsonProperty("FAT")
	private FAT fAT;

	public void setCHOCDF(CHOCDF cHOCDF){
		this.cHOCDF = cHOCDF;
	}

	public CHOCDF getCHOCDF(){
		return cHOCDF;
	}

	public void setENERCKCAL(ENERCKCAL eNERCKCAL){
		this.eNERCKCAL = eNERCKCAL;
	}

	public ENERCKCAL getENERCKCAL(){
		return eNERCKCAL;
	}

	public void setPROCNT(PROCNT pROCNT){
		this.pROCNT = pROCNT;
	}

	public PROCNT getPROCNT(){
		return pROCNT;
	}

	public void setFAT(FAT fAT){
		this.fAT = fAT;
	}

	public FAT getFAT(){
		return fAT;
	}

	@Override
 	public String toString(){
		return 
			"TotalNutrients{" + 
			",cHOCDF = '" + cHOCDF + '\'' +
			",eNERC_KCAL = '" + eNERCKCAL + '\'' +
			",pROCNT = '" + pROCNT + '\'' +
			",fAT = '" + fAT + '\'' +
			"}";
		}
}