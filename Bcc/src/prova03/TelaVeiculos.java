package prova03;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

// GUI de exemplo para treinar para a prova
public class TelaVeiculos extends JFrame {

    private SistemaVeiculos sistema;

    // Componentes da tela
    private JTextField txtPlaca;
    private JTextField txtModelo;
    private JTextField txtMarca;
    private JTextField txtAno;

    private JTable tabelaVeiculos;
    private DefaultTableModel modeloTabela;

    private JButton btnCadastrar;
    private JButton btnAbastecer;
    private JButton btnMedia;

    public TelaVeiculos() {
        super("Sistema de Veículos - Exemplo de Prova");

        // Cria o sistema e carrega dados do arquivo (se existir)
        sistema = new SistemaVeiculos();
        sistema.carregar();

        initComponents();
        montarLayout();
        registrarEventos();

        // Atualiza a tabela com os dados carregados
        atualizarTabela();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 400);
        setLocationRelativeTo(null); // centraliza
    }

    private void initComponents() {
        txtPlaca = new JTextField(8);
        txtModelo = new JTextField(10);
        txtMarca = new JTextField(10);
        txtAno = new JTextField(4);

        // Modelo da tabela
        modeloTabela = new DefaultTableModel(
                new Object[]{"Placa", "Modelo", "Marca", "Ano", "Qtd. Abastecimentos"},
                0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // tabela somente leitura
                return false;
            }
        };

        tabelaVeiculos = new JTable(modeloTabela);

        btnCadastrar = new JButton("Cadastrar veículo");
        btnAbastecer = new JButton("Adicionar abastecimento");
        btnMedia = new JButton("Calcular última média");
    }

    private void montarLayout() {
        // Painel de cadastro (topo)
        JPanel painelCadastro = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painelCadastro.setBorder(BorderFactory.createTitledBorder("Cadastro de veículo"));

        painelCadastro.add(new JLabel("Placa:"));
        painelCadastro.add(txtPlaca);

        painelCadastro.add(new JLabel("Modelo:"));
        painelCadastro.add(txtModelo);

        painelCadastro.add(new JLabel("Marca:"));
        painelCadastro.add(txtMarca);

        painelCadastro.add(new JLabel("Ano:"));
        painelCadastro.add(txtAno);

        painelCadastro.add(btnCadastrar);

        // Painel da tabela (centro)
        JScrollPane scrollTabela = new JScrollPane(tabelaVeiculos);

        // Painel de botões (baixo)
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        painelBotoes.add(btnAbastecer);
        painelBotoes.add(btnMedia);

        // Monta tudo no frame
        setLayout(new BorderLayout());
        add(painelCadastro, BorderLayout.NORTH);
        add(scrollTabela, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);
    }

    private void registrarEventos() {
        // Botão cadastrar veículo
        btnCadastrar.addActionListener(e -> cadastrarVeiculo());

        // Botão adicionar abastecimento
        btnAbastecer.addActionListener(e -> adicionarAbastecimento());

        // Botão calcular última média
        btnMedia.addActionListener(e -> calcularUltimaMedia());
    }

    // Atualiza a tabela de veículos com base no SistemaVeiculos
    private void atualizarTabela() {
        // Limpa tabela
        modeloTabela.setRowCount(0);

        List<Veiculo> veiculos = sistema.getListaVeiculos();
        for (Veiculo v : veiculos) {
            Object[] linha = new Object[]{
                    v.getPlaca(),
                    v.getModelo(),
                    v.getMarca(),
                    v.getAno(),
                    v.getAbastecimentos().size()
            };
            modeloTabela.addRow(linha);
        }
    }

    private void cadastrarVeiculo() {
        try {
            String placa = txtPlaca.getText().trim();
            String modelo = txtModelo.getText().trim();
            String marca = txtMarca.getText().trim();
            String anoStr = txtAno.getText().trim();

            if (placa.isEmpty() || modelo.isEmpty() || marca.isEmpty() || anoStr.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Preencha todos os campos do veículo.",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            int ano = Integer.parseInt(anoStr);

            sistema.cadastrarVeiculo(placa, modelo, marca, ano);

            JOptionPane.showMessageDialog(this,
                    "Veículo cadastrado com sucesso!",
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);

            // Limpa campos
            txtPlaca.setText("");
            txtModelo.setText("");
            txtMarca.setText("");
            txtAno.setText("");

            // Atualiza tabela
            atualizarTabela();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Ano inválido. Digite um número inteiro.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao cadastrar veículo: " + ex.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void adicionarAbastecimento() {
        int linha = tabelaVeiculos.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this,
                    "Selecione um veículo na tabela.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            String kmStr = JOptionPane.showInputDialog(this, "Informe a quilometragem atual (km):");
            if (kmStr == null) return; // usuário cancelou

            String litrosStr = JOptionPane.showInputDialog(this, "Informe a quantidade de litros:");
            if (litrosStr == null) return;

            String precoStr = JOptionPane.showInputDialog(this, "Informe o preço por litro:");
            if (precoStr == null) return;

            double km = Double.parseDouble(kmStr);
            double litros = Double.parseDouble(litrosStr);
            double preco = Double.parseDouble(precoStr);

            sistema.adicionarAbastecimento(linha, km, litros, preco);

            JOptionPane.showMessageDialog(this,
                    "Abastecimento registrado com sucesso!",
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);

            atualizarTabela();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Valores inválidos. Digite números válidos para km, litros e preço.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao adicionar abastecimento: " + ex.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void calcularUltimaMedia() {
        int linha = tabelaVeiculos.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this,
                    "Selecione um veículo na tabela.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            double media = sistema.calcularUltimaMedia(linha);

            JOptionPane.showMessageDialog(this,
                    String.format("Média da última abastecida: %.2f km/l", media),
                    "Média",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (IllegalStateException ex) {
            // Exceção lançada quando não há abastecimentos suficientes
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao calcular média: " + ex.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // MAIN para você conseguir rodar a GUI
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaVeiculos().setVisible(true);
        });
    }
}
