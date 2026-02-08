package modelo;

public class Jogo {
	
	private int id;
	private String nome;
	private double totalHoras;
	private double nota;
	private String review;
	private String finalizou;
	
	public Jogo(String nome, double totalHoras, double nota, String review, String finalizou) {
		super();
		this.nome = nome;
		this.totalHoras = totalHoras;
		this.nota = nota;
		this.review = review;
		this.finalizou = finalizou;
	}
	
	public Jogo(int id, String nome, double totalHoras, double nota, String review, String finalizou) {
		super();
		this.id = id;
		this.nome = nome;
		this.totalHoras = totalHoras;
		this.nota = nota;
		this.review = review;
		this.finalizou = finalizou;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getTotalHoras() {
		return totalHoras;
	}
	public void setTotalHoras(double totalHoras) {
		this.totalHoras = totalHoras;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	
	public String getFinalizou() {
		return finalizou;
	}

	public void setFinalizou(String finalizou) {
		this.finalizou = finalizou;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String toString() {
		return "\n-------------- Card do Jogo --------------\n"
				+ "Id: " + this.getId() + 
				"\nNome: " + this.getNome() + "\nTotal de horas: " + this.getTotalHoras() +
				"\nNota: " + this.getNota() + "\nReview: " + this.getReview() +
				"\nZerou: " + this.getFinalizou() +
				"\n-----------------------------------------";
	}
	
	
	

}
