package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Jogo;

public class AcessarBanco {
	
	public AcessarBanco() {
		criarTabelas();
	}

	private void criarTabelas() {
		String sql = "CREATE TABLE IF NOT EXISTS jogos ("
				+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "nome TEXT,"
				+ "totalHoras DECIMAL(4,2),"
				+ "nota DECIMAL(4,2),"
				+ "review TEXT DEFAULT NULL,"
				+ "finalizou TEXT);";
		
		try(Connection conexao = Banco.conectar();
				Statement stmt = conexao.createStatement()) {
			stmt.execute(sql);
		}
		catch (SQLException e) {
			System.out.println("Erro ao criar tabelas");
			e.printStackTrace();
		}
		
	}
	
	public void adicionarJogo(Jogo jogo) {
		
		String sql = "INSERT INTO jogos (nome, totalHoras, nota, review, finalizou)"
				+ "VALUES (?, ?, ?, ?, ?)";
		
		try(Connection conexao = Banco.conectar();
				PreparedStatement ps = conexao.prepareStatement(sql)) {
			
			ps.setString(1, jogo.getNome());
			ps.setDouble(2, jogo.getTotalHoras());
			ps.setDouble(3, jogo.getNota());
			ps.setString(4, jogo.getReview());
			ps.setString(5, jogo.getFinalizou());
			
			ps.executeUpdate();
			System.out.println("\nJogo salvo a sua biblioteca!");
		}
		catch (SQLException e) {
			System.out.println("Erro ao salvar jogo");
			e.printStackTrace();
		}
		
	}
	
	public List<Jogo> meusJogos() {
		List<Jogo> listaDeJogos = new ArrayList<>();
		
		String sql = "SELECT * FROM jogos";
		
		try (Connection conexao = Banco.conectar();
				Statement stm = conexao.createStatement();
				ResultSet rs = stm.executeQuery(sql)) {
			
			while(rs.next()) {

				Jogo jogo = new Jogo(
						rs.getInt("id"),
						rs.getString("nome"),
						rs.getDouble("totalHoras"),
						rs.getDouble("nota"),
						rs.getString("review"),
						rs.getString("finalizou")
						);
				listaDeJogos.add(jogo);
			} 
		} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		return listaDeJogos;
		};
		
	public Jogo buscarPorId(int id) {
		String sql = "SELECT * FROM jogos WHERE id = ?";
		Jogo jogo = null;
		
		try(Connection conexao = Banco.conectar();
				PreparedStatement ps = conexao.prepareStatement(sql)){
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				jogo = new Jogo(
						rs.getInt("id"),
						rs.getString("nome"),
						rs.getDouble("totalHoras"),
						rs.getDouble("nota"),
						rs.getString("review"),
						rs.getString("finalizou"));
			};
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao procurar por id");
		}
		
		return jogo;
	}
	
	public boolean deletarJogo(int id) {
		String sql = "DELETE FROM jogos WHERE id = ?";
		
		try(Connection conexao = Banco.conectar();
				PreparedStatement ps = conexao.prepareStatement(sql)) {
			
			ps.setInt(1, id);
			
			int linhasAfetadas = ps.executeUpdate();
			return linhasAfetadas > 0;
			
		}catch (SQLException e) {
			System.out.println("Erro ao deletar projeto!");
			e.printStackTrace();
		}
		
		return false;
	}
	
		
	public void atualizarNome(int id, String nome) {
		Jogo jogo = buscarPorId(id);
		
		if(jogo != null) {
			jogo.setNome(nome);
			atualizarJogo(jogo);	
		}
	}
	public void atualizarTotalHoras(int id, double totalHoras) {
		Jogo jogo = buscarPorId(id);
		
		if(jogo != null) {
			jogo.setTotalHoras(totalHoras);
			atualizarJogo(jogo);	
		}
	}
	
	public void atualizarNota(int id, double nota) {
		Jogo jogo = buscarPorId(id);
		
		if(jogo != null) {
			jogo.setNota(nota);
			atualizarJogo(jogo);	
		}
	}
	
	public void atualizarReview(int id, String review) {
		Jogo jogo = buscarPorId(id);
		
		if(jogo != null) {
			jogo.setReview(review);
			atualizarJogo(jogo);	
		}
	}
	
	public void atualizarFinalizou(int id, String finalizou) {
		Jogo jogo = buscarPorId(id);
		
		if(jogo != null) {
			jogo.setFinalizou(finalizou);
			atualizarJogo(jogo);	
		}
	}
	
	public void atualizarJogo(Jogo jogo) {
		String sql = "UPDATE jogos set nome = ?,"
				+ "totalHoras = ?, nota = ?,"
				+ "review = ?, finalizou = ? "
				+ "WHERE id = ?";
		
		try(Connection conexao = Banco.conectar();
				PreparedStatement ps = conexao.prepareStatement(sql)) {
			
			ps.setString(1, jogo.getNome());
			ps.setDouble(2, jogo.getTotalHoras());
			ps.setDouble(3, jogo.getNota());
			ps.setString(4, jogo.getReview());
			ps.setString(5, jogo.getFinalizou());
			ps.setInt(6, jogo.getId());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Erro ao carregar jogo");
			e.printStackTrace();
		}
	}
		
		


}
