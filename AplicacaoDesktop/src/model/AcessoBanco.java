package model;

import controller.Consulta;
import controller.Funcionario;
import controller.Paciente;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class AcessoBanco {
    
    
    public static Funcionario funcionario = new Funcionario("", "");
    public static final String DELIMITADOR = ":";
   
    
    public static ArrayList<Paciente> pacientes = new ArrayList<>();
    public static final String CAMINHO_PACIENTE = "src//model//Pacientes.txt";
    
    
    public static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
    public static final String CAMINHO_FUNCIONARIO = "src//model//Funcionarios.txt";
    
    public static ArrayList<Consulta> consultas = new ArrayList<>();
    public static final String CAMINHO_CONSULTAS = "src//model//Consultas.txt";
 
    
    public static void writeDatabaseConsulta (Consulta consulta){
        try {
            FileWriter fileWriter = new FileWriter(CAMINHO_CONSULTAS, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            
            // vamos escrever no arquivo
            printWriter.println(
                          consulta.getId() 
            +DELIMITADOR+ consulta.getDescricao() +DELIMITADOR+ consulta.getDiagnostico() 
            +DELIMITADOR+ consulta.getStatus()
            +DELIMITADOR+ consulta.getEntrada() +DELIMITADOR+ consulta.getFim() 
            +DELIMITADOR+ consulta.getComeco() +DELIMITADOR+ consulta.getEspecializacao()
            +DELIMITADOR+ consulta.getDataMarcada());
                    
            printWriter.close();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException ex) {
        }
    }
    public static String novoIdConsultas() {
        try {
            Scanner leitura = new Scanner(new File (CAMINHO_CONSULTAS));
            ArrayList<String> idExistente = new ArrayList<>();
               
            while (leitura.hasNext()){
                String linha = leitura.nextLine();
                String vetor [] = linha.split(DELIMITADOR);
                idExistente.add (vetor[0]);
            }
            
            while (true){
                boolean achou = false;
                int matriculaGerada = (int) (Math.random()*100000);
                String retorno = Integer.toString(matriculaGerada);
            
                for (String s : idExistente){
                    if (s.equalsIgnoreCase(retorno)){
                        achou = true;
                    }
                }
                
                if (achou == false && retorno.length() == 5){
                    return retorno;
                }
            }
            } catch (FileNotFoundException ex) {
        }
        return null;
    }
    public static void readDatabaseConsultas (){
        try {
            Scanner leitura = new Scanner(new File (CAMINHO_CONSULTAS));
            consultas.clear();
            
            while (leitura.hasNext()){
                String linha = leitura.nextLine();
                String vetor [] = linha.split(DELIMITADOR);
                
                consultas.add(new Consulta(vetor[0], vetor[1], vetor[2], vetor[3], 
                vetor[4], vetor[5], vetor[6], vetor[7], vetor[8]));
            }
            leitura.close();
        } catch (FileNotFoundException ex) {
        }
    }    
    
    
    
    public static void writeDatabaseFuncionario (Funcionario funcionario){
        try {
            FileWriter fileWriter = new FileWriter(CAMINHO_FUNCIONARIO, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            
            // vamos escrever no arquivo
            printWriter.println(funcionario.getMatricula() + DELIMITADOR + 
            funcionario.getNome() + DELIMITADOR + funcionario.getSenha() + DELIMITADOR +
            funcionario.getFuncao() + DELIMITADOR + funcionario.getAcesso());
                    
            printWriter.close();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException ex) {
        }
    }
  
    
    public static void readDatabaseFuncionario (){
        try {
            Scanner leitura = new Scanner(new File (CAMINHO_FUNCIONARIO));
            funcionarios.clear();
            
            while (leitura.hasNext()){
                String linha = leitura.nextLine();
                String vetor [] = linha.split(DELIMITADOR);
                funcionarios.add(new Funcionario(vetor[0], vetor[1], vetor[2], vetor[3], vetor[4]));
            }
            
            
            leitura.close();
        } catch (FileNotFoundException ex) {
        }
    }    
    
    
    
    public static String novaMatricula() {
        try {
            Scanner leitura = new Scanner(new File (CAMINHO_FUNCIONARIO));
            ArrayList<String> matriculasExistentes = new ArrayList<>();
               
            while (leitura.hasNext()){
                String linha = leitura.nextLine();
                String vetor [] = linha.split(DELIMITADOR);
                matriculasExistentes.add (vetor[0]);
            }
            
            
            while (true){
                boolean achou = false;
                int matriculaGerada = (int) (Math.random()*100000);
                String retorno = Integer.toString(matriculaGerada);
            
                for (String s : matriculasExistentes){
                    if (s.equalsIgnoreCase(retorno)){
                        achou = true;
                    }
                }
                
                if (achou == false && retorno.length() == 5){
                    return retorno;
                }
            }
            
            } catch (FileNotFoundException ex) {
        }
        return null;
    }
    
    
    
    
    // PARA ESCREVER O USUÁRIO NO BANCO DE DADOS
    public static void writeDatabasePaciente (Paciente paciente){
        try {
            FileWriter fileWriter = new FileWriter(CAMINHO_PACIENTE, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            
            //   public Paciente(String cpf, String senha, String nome, String sexo, 
            //          String etnia, String rg, String dataEmissao, String uf, String orgaoEmissor, 
            //          String estadoCivil, String anotacoes, String nomePai, String nomeMae, 
            //          String sus, String foto, String nacionalidade, String naturalidade, 
            //          String dataNasciento, ArrayList<String> telefones) {
       
            
            // vamos escrever no arquivo
            printWriter.println(paciente.getCpf() +DELIMITADOR+ paciente.getSenha() 
                +DELIMITADOR+ paciente.getNome() +DELIMITADOR+ paciente.getSexo() 
                +DELIMITADOR+ paciente.getEtnia() +DELIMITADOR+ paciente.getRg() 
                    
                    
                +DELIMITADOR+ paciente.getDataEmissao() +DELIMITADOR+ paciente.getUf()
                +DELIMITADOR+ paciente.getOrgaoEmissor() +DELIMITADOR+ paciente.getEstadoCivil()
                
                    
                +DELIMITADOR+ "Anotações" +DELIMITADOR+ paciente.getNomePai()
                +DELIMITADOR+ paciente.getNomeMae() +DELIMITADOR+ paciente.getSus() 
                +DELIMITADOR+ "foto *" +DELIMITADOR+ paciente.getNacionalidade() 
                +DELIMITADOR+ paciente.getNaturalidade() +DELIMITADOR+ paciente.getDataNasciento());
            
            printWriter.close();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException ex) {
        }
    }
  
    
    public static void readDatabasePaciente (){
        try {
            Scanner leitura = new Scanner(new File (CAMINHO_PACIENTE));
            pacientes.clear();
            
            while (leitura.hasNext()){
                String linha = leitura.nextLine();
                String vetor [] = linha.split(DELIMITADOR);
                
                pacientes.add(new Paciente (vetor[0], vetor[1], vetor[2], vetor[3], 
                vetor[4],vetor[5],vetor[6],vetor[7], vetor[8],vetor[9],vetor[10],
                vetor[11],vetor[12],vetor[13] ,vetor[14] ,vetor[15],vetor[16],vetor[17],
                new ArrayList<String>()));
            }
            
            
            leitura.close();
        } catch (FileNotFoundException ex) {
        }
    }    
        
    
    // VAMOS BUSCAR OS PACIENTES NO BANCO
    public static void buscarPaciente (){
        try {
            Scanner leitura = new Scanner(new File (CAMINHO_PACIENTE));
        
            int i = 0; 
            for (Paciente p : pacientes){
                System.err.println(i++);
            }
            leitura.close();
        } catch (FileNotFoundException ex) {
        }
    }

    public static Consulta encontrarConsulta(String id) {
        try {
            Scanner leitura = new Scanner(new File (CAMINHO_CONSULTAS));
            
            while (leitura.hasNext()){
                String linha = leitura.nextLine();
                String vetor [] = linha.split(DELIMITADOR);
                
                if (vetor[0].equalsIgnoreCase(id)){
                    return new Consulta(vetor[0], vetor[1], vetor[2], vetor[3], 
                            vetor[4], vetor[5], vetor[6], vetor[7], vetor[8]);
                }
            }
        } catch (FileNotFoundException ex) {
        }
        return null;
    
    }
    
    
    
    
    
}
