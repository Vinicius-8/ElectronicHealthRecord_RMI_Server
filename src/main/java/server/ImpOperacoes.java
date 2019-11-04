package server;


import models.Medico;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Paciente;

/**
 *  https://stackoverflow.com/questions/55054193/trouble-connecting-to-mysql-db-with-spring-boot
 *  https://support.rackspace.com/how-to/installing-mysql-server-on-ubuntu/
 *  https://howchoo.com/g/mtm3zdq2nzv/how-to-add-a-mysql-user-and-grant-privileges
 * 
 * Método que implementa a interface Operacoes
 * @author Vinicius
 */
public class ImpOperacoes extends UnicastRemoteObject implements Operacoes{
    /**
     * Seção de conexao com o banco de dados
     */
    private Connection con;
    /**
     * Host do banco de dados
     */
    private final String HOST = "127.0.0.1";
    /**
     * Nome do banco de dados
     */
    private final String BANCO = "db_rmi";
    
    /**
     * Nome do usuário no banco de dados
     */
    private final String USER = "vini";       //ubunt
    
    /**
     * Senha do usuário no banco
     */
    private final String PASS = "error";      //ubunt
    /**
     * Nome do usuário no banco de dados
     */
    //private final String USER = "root";       //windows
    /**
     * Senha do usuário no banco
     */
    //private final String PASS = "";           //windows
    
    /**
     * Variavel de debug
     */
    private boolean debug;
    /**
     * Construtor da classe ImpOperacoes que realiza a conexao com o banco de dados
     * @throws RemoteException
     * @throws SQLException 
     */
    public ImpOperacoes()throws RemoteException, SQLException{
        super();
        try {
            debug = Boolean.TRUE;
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("conectando com o banco...");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://"+HOST+":3306/"+BANCO+"?serverTimezone=UTC", USER,PASS);
            log("Conectado!");
            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
       
    }
    /**
     * Log de informações
     * @param a informação a ser mostrada
     */
    private void log(String a) {
        if (debug) {
            System.out.println(a);
        }
    }
    
    /**
     * Método que realiza um hello world com o cliente
     * @param text String que sera usado na resposta
     * @return String de resposta
     * @throws RemoteException 
     */
    @Override
    public String helloWorld(String text) throws RemoteException {
        return "Hello World, "+text+"!";
    }

    /**
     * Método para inserir os dados do médico no banco de dados
     * @param m Objeto do tipo Medico que contém as informações que serão 
     * cadastradas
     * @return Um inteiro com o id do médico no banco é retornado
     * @throws RemoteException 
     */
    @Override
    public int cadastrarMedico(Medico m) throws RemoteException {
        int id = 0;
        try {
            String inserir = "INSERT INTO medicos(crm,cpf,nome,especialidade,email,senha) VALUES (?,?,?,?,?,?)";
            PreparedStatement stat = (PreparedStatement) con.prepareStatement(inserir);
            stat.setInt(1, m.getCrm());
            stat.setString(2, m.getCpf());
            stat.setString(3, m.getNome());
            stat.setString(4, m.getEspecialidade());
            stat.setString(5, m.getEmail());
            stat.setString(6, m.getSenha());

            id = stat.executeUpdate();
            stat.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        log("Médico Cadastrado");
        return id;
    }
    
    /**
     * Método para obter o objeto de um determinado médico com base no seu CRM
     * e sua senha
     * @param crm   CRM de acesso ao sistema
     * @param senha Senha de acesso ao sistema
     * @return  Um objeto contendo todas as informações do médico é retornado 
     * @throws RemoteException 
     */
    @Override
    public Medico logarMedico(int crm, String senha) throws RemoteException {
        Medico m = new Medico();
        m.setNome("Médico vazio");
        m.setCrm(0);
        try {
            String inserir = "SELECT * FROM medicos WHERE crm = ? and senha = ?";
            PreparedStatement stat = (PreparedStatement) con.prepareStatement(inserir);
            stat.setInt(1, crm);
            stat.setString(2, senha);

            ResultSet rs = (ResultSet) stat.executeQuery();
            //id, crm,cpf,nome,especialidade,email,senha
            while (rs.next()){
                m.setId(rs.getInt(1));
                m.setCrm(rs.getInt(2));
                m.setCpf(rs.getString(3));
                m.setNome(rs.getString(4));
                m.setEspecialidade(rs.getString(5));
                m.setSenha(rs.getString(6));
            }
            stat.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        log("Médico "+m.getNome()+" consultado");
        return m;
    }

     /**
     * Médoto de inserção do paciente no banco de dados
     * @param idMedico o id do medico que realiza a inserção
     * @param p Objeto contendo todas as informações do Paciente
     * @return Um inteiro que corresponde ao id do paciente no banco é retornado
     * @throws RemoteException 
     */
    @Override
    public int cadastrarPaciente(int idMedico, Paciente p) throws RemoteException {
        int id = 0;
        try {
            String inserir = "INSERT INTO pacientes(nome,cpf,dataNasc,rg,sexo,estadoCivil,endereco,telefone,queixa_principal,alergia,doenca,cirurgia,tipo_sanguineo,gestante,usa_medicamentos, diagnostico, receita, idMedico) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stat = (PreparedStatement) con.prepareStatement(inserir);

            stat.setString(1, p.getNome());
            stat.setString(2, p.getCpf());
            stat.setString(3, p.getDataNasc());
            stat.setString(4, p.getRg());
            stat.setString(5, p.getSexo());
            stat.setString(6, p.getEstadoCivil());
            stat.setString(7,p.getEndereco());
            stat.setString(8,p.getTelefone()); 
            stat.setString(9, p.getQueixa_princial()); 
            stat.setString(10, p.getAlergia()); 
            stat.setString(11, p.getDoenca()); 
            stat.setString(12,p.getCirurgia()); 
            stat.setString(13, p.getTipo_sanguineo()); 
            stat.setString(14, p.getGestante()); 
            stat.setString(15, p.getUsa_medicamentos()); 
            stat.setString(16, p.getDiagonstico()); 
            stat.setString(17, p.getReceita()); 
            stat.setInt(18, idMedico);
            
            
            
            id = stat.executeUpdate();
            stat.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        log("Paciente "+p.getNome()+" Cadastrado");
        return id;
    }

    /**
     * Método que realiza a busca da lista de pacientes no banco de dados
     *
     * @param idMedico id do médico que realia essa busca
     * @return Um objeto do tipo lista contendo todos os pacientes é retornado
     * @throws RemoteException 
     */
    @Override
    public List<Paciente> listaPacientes(int idMedico) throws RemoteException {
        List<Paciente> lp = new ArrayList();
        try {
            //String inserir = "SELECT * FROM pacientes WHERE idMedico = ?";
            String inserir = "SELECT * FROM pacientes";
            PreparedStatement stat = (PreparedStatement) con.prepareStatement(inserir);
            //stat.setInt(1, idMedico);
            ResultSet rs = stat.executeQuery();
            
            while(rs.next()){
                Paciente p = new Paciente();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setCpf(rs.getString("cpf"));
                p.setDataNasc(rs.getString("dataNasc"));
                p.setRg(rs.getString("rg"));
                p.setSexo(rs.getString("sexo"));
                p.setEstadoCivil(rs.getString("estadoCivil"));
                p.setEndereco(rs.getString("endereco"));
                p.setTelefone(rs.getString("telefone"));
                p.setQueixa_princial(rs.getString("queixa_principal"));
                p.setAlergia(rs.getString("alergia"));
                p.setDoenca(rs.getString("doenca"));
                p.setCirurgia(rs.getString("cirurgia"));
                p.setTipo_sanguineo(rs.getString("tipo_sanguineo"));
                p.setGestante(rs.getString("gestante"));
                p.setUsa_medicamentos(rs.getString("usa_medicamentos"));
                p.setDiagonstico(rs.getString("diagnostico"));
                p.setReceita(rs.getString("receita"));
                lp.add(p);
            }
            
            stat.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        log("Lista de pacientes obtida!");
        return lp;
    }

    /**
     * Método para buscar apenas um paciente no banco de dados com base no seu
     * ID
     *
     * @param idMedico Id do médico que tenta acessar o paciente
     * @param idPaciente Id que corresponde ao paciente no banco de dados
     * @return Retorna um objeto do tipo Paciente que contém todos os dados do
     * paciente
     * @throws RemoteException 
     */
    @Override
    public Paciente buscarPaciente(int idMedico, int idPaciente) throws RemoteException {
        Paciente p = new Paciente();
        p.setNome("Paciente Vazio");
        p.setId(0);
        try {
            //String inserir = "SELECT * FROM pacientes WHERE id = ? and idMedico = ?";
            String inserir = "SELECT * FROM pacientes WHERE id = ?";
            PreparedStatement stat = (PreparedStatement) con.prepareStatement(inserir);
            stat.setInt(1, idPaciente);
            //stat.setInt(2, idMedico);
            

            ResultSet rs = (ResultSet) stat.executeQuery();
            
            while (rs.next()) {                
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setCpf(rs.getString("cpf"));
                p.setDataNasc(rs.getString("dataNasc"));
                p.setRg(rs.getString("rg"));
                p.setSexo(rs.getString("sexo"));
                p.setEstadoCivil(rs.getString("estadoCivil"));
                p.setEndereco(rs.getString("endereco"));
                p.setTelefone(rs.getString("telefone"));
                p.setQueixa_princial(rs.getString("queixa_principal"));
                p.setAlergia(rs.getString("alergia"));
                p.setDoenca(rs.getString("doenca"));
                p.setCirurgia(rs.getString("cirurgia"));
                p.setTipo_sanguineo(rs.getString("tipo_sanguineo"));
                p.setGestante(rs.getString("gestante"));
                p.setUsa_medicamentos(rs.getString("usa_medicamentos"));
                p.setDiagonstico(rs.getString("diagnostico"));
                p.setReceita(rs.getString("receita"));
            }
            stat.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        log("Paciente " + p.getNome() + " consultado");
        return p;
    }

    /**
     * Método para atualizar as informações do paciente
     *
     * @param idMedico Id do médico que realiza a atualização no paciente
     * @param p Objeto do Paciente que contem as informações atualizadas
     * @return Um inteiro é retornado contendo o id do paciente atualizado
     * @throws RemoteException 
     */
    @Override
    public int updatePaciente(int idMedico, Paciente p) throws RemoteException {
        int id = 0;
        try {
            //String inserir = "UPDATE pacientes SET nome = ?, cpf = ?, dataNasc = ?, rg = ?, sexo = ?, estadoCivil = ?, endereco = ?, telefone = ?, queixa_principal = ?, alergia = ?, doenca = ?, cirurgia = ?, tipo_sanguineo = ?, gestante = ?, usa_medicamentos = ?, diagnostico = ?, receita = ? WHERE id = ? and idMedico = ?";
            String inserir = "UPDATE pacientes SET nome = ?, cpf = ?, dataNasc = ?, rg = ?, sexo = ?, estadoCivil = ?, endereco = ?, telefone = ?, queixa_principal = ?, alergia = ?, doenca = ?, cirurgia = ?, tipo_sanguineo = ?, gestante = ?, usa_medicamentos = ?, diagnostico = ?, receita = ? WHERE id = ?";
            PreparedStatement stat = (PreparedStatement) con.prepareStatement(inserir);
            stat.setString(1, p.getNome());
            stat.setString(2, p.getCpf());
            stat.setString(3, p.getDataNasc());
            stat.setString(4, p.getRg());
            stat.setString(5, p.getSexo());
            stat.setString(6, p.getEstadoCivil());
            stat.setString(7, p.getEndereco());
            stat.setString(8, p.getTelefone());
            stat.setString(9, p.getQueixa_princial());
            stat.setString(10, p.getAlergia());
            stat.setString(11, p.getDoenca());
            stat.setString(12, p.getCirurgia());
            stat.setString(13, p.getTipo_sanguineo());
            stat.setString(14, p.getGestante());
            stat.setString(15, p.getUsa_medicamentos());
            stat.setString(16, p.getDiagonstico());
            stat.setString(17, p.getReceita());
            stat.setInt(18 , p.getId());
            //stat.setInt(19, idMedico);
            
            id = stat.executeUpdate();
            stat.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        log("Paciente Atualizado!");
        return id;
    }
    
    

}
