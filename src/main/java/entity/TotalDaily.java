package entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TotalDaily{

	@JsonProperty("VITB6A")
	private VITB6A vITB6A;

	@JsonProperty("VITC")
	private VITC vITC;

	@JsonProperty("CHOCDF")
	private CHOCDF cHOCDF;

	@JsonProperty("K")
	private K K;

	@JsonProperty("VITD")
	private VITD vITD;

	@JsonProperty("P")
	private P P;

	@JsonProperty("CHOLE")
	private CHOLE cHOLE;

	@JsonProperty("ENERC_KCAL")
	private ENERCKCAL eNERCKCAL;

	@JsonProperty("FASAT")
	private FASAT fASAT;

	@JsonProperty("VITK1")
	private VITK1 vITK1;

	@JsonProperty("MG")
	private MG mG;

	@JsonProperty("RIBF")
	private RIBF rIBF;

	@JsonProperty("CA")
	private CA cA;

	@JsonProperty("NIA")
	private NIA nIA;

	@JsonProperty("THIA")
	private THIA tHIA;

	@JsonProperty("FIBTG")
	private FIBTG fIBTG;

	@JsonProperty("VITB12")
	private VITB12 vITB12;

	@JsonProperty("TOCPHA")
	private TOCPHA tOCPHA;

	@JsonProperty("PROCNT")
	private PROCNT pROCNT;

	@JsonProperty("FOLDFE")
	private FOLDFE fOLDFE;

	@JsonProperty("NA")
	private NA nA;

	@JsonProperty("ZN")
	private ZN zN;

	@JsonProperty("VITA_RAE")
	private VITARAE vITARAE;

	@JsonProperty("FAT")
	private FAT fAT;

	@JsonProperty("FE")
	private FE fE;

	public void setVITB6A(VITB6A vITB6A){
		this.vITB6A = vITB6A;
	}

	public VITB6A getVITB6A(){
		return vITB6A;
	}

	public void setVITC(VITC vITC){
		this.vITC = vITC;
	}

	public VITC getVITC(){
		return vITC;
	}

	public void setCHOCDF(CHOCDF cHOCDF){
		this.cHOCDF = cHOCDF;
	}

	public CHOCDF getCHOCDF(){
		return cHOCDF;
	}

	public void setK(K K){
		this.K = K;
	}

	public K getK(){
		return K;
	}

	public void setVITD(VITD vITD){
		this.vITD = vITD;
	}

	public VITD getVITD(){
		return vITD;
	}

	public void setP(P P){
		this.P = P;
	}

	public P getP(){
		return P;
	}

	public void setCHOLE(CHOLE cHOLE){
		this.cHOLE = cHOLE;
	}

	public CHOLE getCHOLE(){
		return cHOLE;
	}

	public void setENERCKCAL(ENERCKCAL eNERCKCAL){
		this.eNERCKCAL = eNERCKCAL;
	}

	public ENERCKCAL getENERCKCAL(){
		return eNERCKCAL;
	}

	public void setFASAT(FASAT fASAT){
		this.fASAT = fASAT;
	}

	public FASAT getFASAT(){
		return fASAT;
	}

	public void setVITK1(VITK1 vITK1){
		this.vITK1 = vITK1;
	}

	public VITK1 getVITK1(){
		return vITK1;
	}

	public void setMG(MG mG){
		this.mG = mG;
	}

	public MG getMG(){
		return mG;
	}

	public void setRIBF(RIBF rIBF){
		this.rIBF = rIBF;
	}

	public RIBF getRIBF(){
		return rIBF;
	}

	public void setCA(CA cA){
		this.cA = cA;
	}

	public CA getCA(){
		return cA;
	}

	public void setNIA(NIA nIA){
		this.nIA = nIA;
	}

	public NIA getNIA(){
		return nIA;
	}

	public void setTHIA(THIA tHIA){
		this.tHIA = tHIA;
	}

	public THIA getTHIA(){
		return tHIA;
	}

	public void setFIBTG(FIBTG fIBTG){
		this.fIBTG = fIBTG;
	}

	public FIBTG getFIBTG(){
		return fIBTG;
	}

	public void setVITB12(VITB12 vITB12){
		this.vITB12 = vITB12;
	}

	public VITB12 getVITB12(){
		return vITB12;
	}

	public void setTOCPHA(TOCPHA tOCPHA){
		this.tOCPHA = tOCPHA;
	}

	public TOCPHA getTOCPHA(){
		return tOCPHA;
	}

	public void setPROCNT(PROCNT pROCNT){
		this.pROCNT = pROCNT;
	}

	public PROCNT getPROCNT(){
		return pROCNT;
	}

	public void setFOLDFE(FOLDFE fOLDFE){
		this.fOLDFE = fOLDFE;
	}

	public FOLDFE getFOLDFE(){
		return fOLDFE;
	}

	public void setNA(NA nA){
		this.nA = nA;
	}

	public NA getNA(){
		return nA;
	}

	public void setZN(ZN zN){
		this.zN = zN;
	}

	public ZN getZN(){
		return zN;
	}

	public void setVITARAE(VITARAE vITARAE){
		this.vITARAE = vITARAE;
	}

	public VITARAE getVITARAE(){
		return vITARAE;
	}

	public void setFAT(FAT fAT){
		this.fAT = fAT;
	}

	public FAT getFAT(){
		return fAT;
	}

	public void setFE(FE fE){
		this.fE = fE;
	}

	public FE getFE(){
		return fE;
	}

	@Override
 	public String toString(){
		return 
			"TotalDaily{" + 
			"vITB6A = '" + vITB6A + '\'' + 
			",vITC = '" + vITC + '\'' + 
			",cHOCDF = '" + cHOCDF + '\'' + 
			",K = '" + K + '\'' + 
			",vITD = '" + vITD + '\'' + 
			",P = '" + P + '\'' + 
			",cHOLE = '" + cHOLE + '\'' + 
			",eNERC_KCAL = '" + eNERCKCAL + '\'' + 
			",fASAT = '" + fASAT + '\'' + 
			",vITK1 = '" + vITK1 + '\'' + 
			",mG = '" + mG + '\'' + 
			",rIBF = '" + rIBF + '\'' + 
			",cA = '" + cA + '\'' + 
			",nIA = '" + nIA + '\'' + 
			",tHIA = '" + tHIA + '\'' + 
			",fIBTG = '" + fIBTG + '\'' + 
			",vITB12 = '" + vITB12 + '\'' + 
			",tOCPHA = '" + tOCPHA + '\'' + 
			",pROCNT = '" + pROCNT + '\'' + 
			",fOLDFE = '" + fOLDFE + '\'' + 
			",nA = '" + nA + '\'' + 
			",zN = '" + zN + '\'' + 
			",vITA_RAE = '" + vITARAE + '\'' + 
			",fAT = '" + fAT + '\'' + 
			",fE = '" + fE + '\'' + 
			"}";
		}
}