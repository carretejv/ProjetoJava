package controller;

import model.Funcionario;

import java.io.*;
import java.util.ArrayList;

public class FuncionarioController {
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private final String filePath = "funcionarios.txt";

    public FuncionarioController() {
        carregarDados();
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
        salvarDados();
    }

    public void listarFuncionarios() {
        for (Funcionario f : funcionarios) {
            System.out.println(f.mostrarDetalhes());
        }
    }

    public void atualizarFuncionario(int id, String nome, double salario) {
        for (Funcionario f : funcionarios) {
            if (f.getId() == id) {
                f.setNome(nome);
                f.setSalario(salario);
                salvarDados();
                return;
            }
        }
        System.out.println("Funcionário não encontrado!");
    }

    public void removerFuncionario(int id) {
        funcionarios.removeIf(f -> f.getId() == id);
        salvarDados();
    }

    private void salvarDados() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(funcionarios);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private void carregarDados() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            funcionarios = (ArrayList<Funcionario>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            funcionarios = new ArrayList<>();
        }
    }
}
