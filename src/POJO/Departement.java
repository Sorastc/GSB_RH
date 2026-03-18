package POJO;

public class Departement {
	private int idDepartement;
	private int codeDepartement;
	private String nomDepartement;
	private Region region;
	
	public Departement(int idDepartement, int codeDepartement, String nomDepartement, Region region) {
		super();
		this.idDepartement = idDepartement;
		this.codeDepartement = codeDepartement;
		this.nomDepartement = nomDepartement;
		this.region = region;
	}

	public int getIdDepartement() {
		return idDepartement;
	}

	public void setIdDepartement(int idDepartement) {
		this.idDepartement = idDepartement;
	}

	public int getCodeDepartement() {
		return codeDepartement;
	}

	public void setCodeDepartement(int codeDepartement) {
		this.codeDepartement = codeDepartement;
	}

	public String getNomDepartement() {
		return nomDepartement;
	}

	public void setNomDepartement(String nomDepartement) {
		this.nomDepartement = nomDepartement;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	@Override
	public String toString() {
		return "Departement [idDepartement=" + idDepartement + ", codeDepartement=" + codeDepartement
				+ ", nomDepartement=" + nomDepartement + ", region=" + region + "]";
	}
	
	
}
