package teste;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculadora extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfnum01;
	private JTextField tfnum02;
	private JTextField tfResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora frame = new Calculadora();
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
	public Calculadora() {
		setTitle("Calculadora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);//localizacao da janela 450 é largura e 300 é altura  
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Numero 1");
		lblNewLabel.setFont(new Font("Algerian", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 10, 110, 12);
		contentPane.add(lblNewLabel);
		
		tfnum01 = new JTextField();
		tfnum01.setFont(new Font("Tahoma", Font.BOLD, 16));
		tfnum01.setBounds(10, 32, 141, 18);
		contentPane.add(tfnum01);
		tfnum01.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Numero 2:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 58, 110, 12);
		contentPane.add(lblNewLabel_1);
		
		tfnum02 = new JTextField();
		tfnum02.setBounds(10, 80, 141, 18);
		contentPane.add(tfnum02);
		tfnum02.setColumns(10);
		
		JButton btnNewButton = new JButton("Somar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double n1;
				double n2;
				double resultado;
				
				n1 = Double.parseDouble(tfnum01.getText());
				n2 = Double.parseDouble(tfnum02.getText());
				
				resultado = n1 + n2;
				
				//para precer um resultdado dentro do text field
				
				tfResultado.setText(""+resultado);
				//Double.ToString()
			}
		});
		btnNewButton.setBounds(20, 108, 84, 20);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("resultado:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(10, 150, 91, 12);
		contentPane.add(lblNewLabel_2);
		
		tfResultado = new JTextField();
		tfResultado.setBounds(10, 172, 96, 18);
		contentPane.add(tfResultado);
		tfResultado.setColumns(10);

	}
}
