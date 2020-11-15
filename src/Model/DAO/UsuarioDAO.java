package Model.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Model.VO.Endereco;
import Model.VO.Usuario;
import Util.HibernateUtil;



public class UsuarioDAO {
	public static void main(String[] args) {
		Usuario usuario = new Usuario();
		usuario.setCodigo(1);
		usuario.setNome("Mocorongo");
		usuario.setCpf("112321454357");
		usuario.setDtnascimento(12201929);
		usuario.setNuContatoPrincipal("98377348");
		usuario.setNomeMae("nomeMae");
		usuario.setEmail("email@email.com");
		usuario.setFlGestante(false);
		usuario.setFlIdoso(false);
		usuario.setFlMenorIdade(false);
		usuario.setFlPne(false);
		usuario.setSus("123");
		Endereco endereco = new Endereco();
		endereco.setBairro("bairro");
		endereco.setCep("23435754");
		endereco.setCidade("cidade");
		endereco.setNumero(12);
		endereco.setRua("rua");
		endereco.setUf("uf");
		usuario.setEndereco(endereco);
		salvaUsuario(usuario);
		//listarTodos();
	}

	public static void salvaUsuario(Usuario usuario) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			System.out.println("usuario " + usuario);
			session.save(usuario);

			transaction.commit();

		} catch (Exception e) {
			System.out.println("Erro salvaUsuario");
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public static List<Usuario> listarTodos() {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();

			Criteria query = session.createCriteria(Usuario.class);
			List<Usuario> usuarios = query.list();

			System.out.println("Usuarios" + usuarios);

			transaction.commit();

			return usuarios;

		} catch (Exception e) {
			System.out.println("Erro listarTodos");
			e.printStackTrace();
			return null;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

}

