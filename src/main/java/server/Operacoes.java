package server;

import models.Medico;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import models.Paciente;

/**
 *
 * @author Vinicius                 servidor
 */
public interface Operacoes extends Remote{
    public String helloWorld(String text) throws RemoteException;   
    public int cadastrarMedico(Medico m) throws RemoteException;
    public int cadastrarPaciente(int idMedico,Paciente p) throws RemoteException;
    public Medico logarMedico(int crm, String senha) throws RemoteException;
    public List<Paciente> listaPacientes(int idMedico) throws RemoteException;
    public Paciente buscarPaciente(int idMedico, int idPaciente) throws RemoteException;
    public int updatePaciente(int idMedico, Paciente p) throws RemoteException;
}
