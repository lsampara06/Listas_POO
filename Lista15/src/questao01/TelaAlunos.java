package questao01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TelaAlunos extends JFrame {
	 private List<Aluno> alunos;

	    // Componentes da interface
	    private JRadioButton rbNome;
	    private JRadioButton rbMatricula;
	    private JRadioButton rbNotaEnem;

	    private JRadioButton rbCrescente;
	    private JRadioButton rbDecrescente;

	    private JTextArea txtAreaAlunos;
	    private JButton btnListar;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAlunos frame = new TelaAlunos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaAlunos() {
		setTitle("Lista de Alunos - Ordenação");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // centraliza na tela

        // Inicializa a lista de alunos (exemplo; no seu projeto pode vir de outro lugar)
        inicializaAlunosExemplo();

        // Inicializa os componentes de tela
        initComponents();

        // Monta o layout e adiciona os componentes na janela
        montarLayout();

	}
	 // Cria alguns alunos apenas para teste/visualização
    private void inicializaAlunosExemplo() {
        alunos = new ArrayList<>();
        alunos.add(new Aluno("Ana", "2023001", 720.5));
        alunos.add(new Aluno("Bruno", "2023003", 650.0));
        alunos.add(new Aluno("Carla", "2023002", 800.0));
        alunos.add(new Aluno("Diego", "2023004", 590.3));
    }

    // Cria e configura os componentes da tela
    private void initComponents() {
        // RadioButtons para coluna de ordenação
        rbNome = new JRadioButton("Nome");
        rbMatricula = new JRadioButton("Matrícula");
        rbNotaEnem = new JRadioButton("Nota ENEM");

        // Grupo para que apenas UM possa ser selecionado (Nome / Matrícula / Nota)
        ButtonGroup grupoColuna = new ButtonGroup();
        grupoColuna.add(rbNome);
        grupoColuna.add(rbMatricula);
        grupoColuna.add(rbNotaEnem);

        // Por padrão, vamos deixar "Nome" selecionado
        rbNome.setSelected(true);

        // RadioButtons para tipo de ordenação (crescente / decrescente)
        rbCrescente = new JRadioButton("Crescente");
        rbDecrescente = new JRadioButton("Decrescente");

        // Grupo para que apenas UM possa ser selecionado (Crescente / Decrescente)
        ButtonGroup grupoTipo = new ButtonGroup();
        grupoTipo.add(rbCrescente);
        grupoTipo.add(rbDecrescente);

        // Por padrão, crescente
        rbCrescente.setSelected(true);

        // Área de texto onde os alunos serão listados
        txtAreaAlunos = new JTextArea();
        txtAreaAlunos.setEditable(false); // usuário não digita aqui
        txtAreaAlunos.setFont(new Font("Monospaced", Font.PLAIN, 12));

        // Botão Listar
        btnListar = new JButton("Listar");
        // Associa a ação que será executada ao clicar no botão
        btnListar.addActionListener(this::onListarClick);
    }

    // Monta o layout da janela
    private void montarLayout() {
        // Painel superior para ordenação
        JPanel painelOrdenacao = new JPanel(new GridLayout(2, 1));

        // Linha 1: Coluna Ordenação (Nome / Matrícula / Nota)
        JPanel painelColuna = new JPanel();
        painelColuna.setBorder(BorderFactory.createTitledBorder("Coluna Ordenação"));
        painelColuna.add(rbNome);
        painelColuna.add(rbMatricula);
        painelColuna.add(rbNotaEnem);

        // Linha 2: Tipo Ordenação (Crescente / Decrescente)
        JPanel painelTipo = new JPanel();
        painelTipo.setBorder(BorderFactory.createTitledBorder("Tipo Ordenação"));
        painelTipo.add(rbCrescente);
        painelTipo.add(rbDecrescente);

        painelOrdenacao.add(painelColuna);
        painelOrdenacao.add(painelTipo);

        // Scroll para o JTextArea
        JScrollPane scroll = new JScrollPane(txtAreaAlunos);

        // Painel inferior com o botão
        JPanel painelBotoes = new JPanel();
        painelBotoes.add(btnListar);

        // Usa BorderLayout na janela
        setLayout(new BorderLayout());
        add(painelOrdenacao, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);
    }

    // Método chamado quando o usuário clica no botão "Listar"
    private void onListarClick(ActionEvent e) {
        // Antes de listar, ordena a lista de acordo com as opções escolhidas
        ordenarAlunos();

        // Limpa o JTextArea
        txtAreaAlunos.setText("");

        // Monta novamente a listagem
        for (Aluno a : alunos) {
            txtAreaAlunos.append(a.toString() + "\n");
        }
    }

    // Método que decide COMO ordenar os alunos
    private void ordenarAlunos() {
        // Define o comparador de acordo com a coluna escolhida
        Comparator<Aluno> comparator = null;

        if (rbNome.isSelected()) {
            // Ordena por nome (ignorando maiúsculas/minúsculas)
            comparator = new Comparator<Aluno>() {
                @Override
                public int compare(Aluno a1, Aluno a2) {
                    return a1.getNome().compareToIgnoreCase(a2.getNome());
                }
            };
        } else if (rbMatricula.isSelected()) {
            // Ordena por matrícula
            comparator = new Comparator<Aluno>() {
                @Override
                public int compare(Aluno a1, Aluno a2) {
                    return a1.getMatricula().compareTo(a2.getMatricula());
                }
            };
        } else if (rbNotaEnem.isSelected()) {
            // Ordena por nota do ENEM
            comparator = new Comparator<Aluno>() {
                @Override
                public int compare(Aluno a1, Aluno a2) {
                    // Double.compare compara dois valores double
                    return Double.compare(a1.getNotaEnem(), a2.getNotaEnem());
                }
            };
        }

        if (comparator == null) {
            return; // segurança, não era pra acontecer
        }

        // Se o usuário escolheu "Decrescente", inverte o comparador
        if (rbDecrescente.isSelected()) {
            comparator = comparator.reversed();
        }

        // Ordena a lista de alunos usando o comparador configurado
        Collections.sort(alunos, comparator);
    }

}
