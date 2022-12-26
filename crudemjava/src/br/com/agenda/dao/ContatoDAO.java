package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.JdbcPreparedStatement;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Contato;

public class ContatoDAO {

	public void save(Contato contato) {
		
		String sql = "INSERT INTO contatos(nome, idade, datacadastro) VALUES (?,?,?)";
		
		Connection conn = null;
		JdbcPreparedStatement pstm = null;
				
		try {
			//Cria conexão com o database
			conn = ConnectionFactory.createConnectionToMySQL();
			//Prepara para executar a query
			pstm = (JdbcPreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));
			System.out.println(pstm);
			// Executa a query
			pstm.execute();
			System.out.println("Contato salvo com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Fecha as conexões
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn!= null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


	public List<Contato> getContatos() {
		
		String sql = "SELECT * FROM contatos";
		List<Contato> contatos = new ArrayList<Contato>();
		Connection conn = null;
		JdbcPreparedStatement pstm = null;
		// rset vai receber os registros recuperados pelo SELECT
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (JdbcPreparedStatement)conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			// enquanto houver próximo registro no rset
			while (rset.next()) {
				Contato contato = new Contato();
				// recupera os campos do registro
				contato.setId(rset.getInt("id"));
				contato.setNome(rset.getString("nome"));
				contato.setIdade(rset.getInt("idade"));
				contato.setDataCadastro(rset.getDate("datacadastro"));
				
				contatos.add(contato);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rset!=null) {
					rset.close();
				}
				if (pstm!=null) {
					pstm.close();
				}
				if (conn!=null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return contatos;
	}

	public void update(Contato contato) {
		
		String sql = "UPDATE contatos SET nome = ?, idade = ?, datacadastro = ? WHERE id = ?";
		Connection conn = null;
		JdbcPreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL(); //cria a conexão
			pstm = (JdbcPreparedStatement)conn.prepareStatement(sql); //instancia um objeto da classe statement
			// adiciona ao statement os dados para o UPDATE
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));
			pstm.setInt(4, contato.getId()); // ID do registro que será atualizado
			pstm.execute(); // executa o UPDATE
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstm!=null) {
					pstm.close();
				}
				if (conn!=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void deleteByID (int id) {
		
		String sql = "DELETE FROM contatos WHERE id = ?";
		Connection conn = null;
		JdbcPreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL(); //cria a conexão
			pstm = (JdbcPreparedStatement)conn.prepareStatement(sql); //instancia um objeto da classe statement
			pstm.setInt(1, id);
			pstm.execute();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstm!=null) {
					pstm.close();
				}
				if (conn!=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

	