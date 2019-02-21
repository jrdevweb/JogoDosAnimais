package com.jogodosanimais;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * @author Junior Ribeiro
 *
 * 20 de fev de 2019
 */
public class JogoDosAnimais {

	private static final String O_ANIMAL_QUE_VOCÊ_PENSOU = "O animal que você pensou ";
	private static final String O_ANIMAL_QUE_VOCÊ_PENSOU_É = "O animal que você pensou é ";

	public static void main(String[] args) {

		JFrame tela = new JFrame("Jogo dos Animais");
		JLabel titulo = new JLabel("Pense em um animal");
		JButton ok = new JButton("OK");

		tela.setVisible(true);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setLayout(null);
		tela.setSize(250, 110);
		tela.setLocationRelativeTo(null);
		tela.add(titulo);
		titulo.setBounds(55, -5, 150, 50);
		tela.add(ok);
		ok.setBounds(75, 40, 80, 20);

		Animal iniciarAnimal = new Animal();
		iniciarAnimal.nome = " vive na Água";
		iniciarAnimal.texto = O_ANIMAL_QUE_VOCÊ_PENSOU + iniciarAnimal.nome + "?";

		Animal baleia = new Animal();
		baleia.nome = "Baleia";
		baleia.texto = O_ANIMAL_QUE_VOCÊ_PENSOU_É + baleia.nome + "?";

		Animal cachorro = new Animal();
		cachorro.nome = "Cachorro";
		cachorro.texto = O_ANIMAL_QUE_VOCÊ_PENSOU_É + cachorro.nome + "?";

		iniciarAnimal.sim = baleia;
		iniciarAnimal.nao = cachorro;

		acaoBotaoOk(iniciarAnimal, ok);
	}

	public static void dadosAnimal(Animal animal) {

		int option = JOptionPane.showConfirmDialog(null, animal.texto, "Pergunta", JOptionPane.YES_NO_OPTION);

		if (option == 0) {
			if (animal.sim == null) {
				JOptionPane.showMessageDialog(null, "Acertou, parabéns!");
			} else {
				dadosAnimal(animal.sim);
			}
		} else {
			if (animal.nao == null) {
				String animalNovo = JOptionPane.showInputDialog("Qual o animal que você pensou?");
				String novosDetalhesAnimal = "Um(a) " + animalNovo + " _______ mas um(a) " + animal.nome + " não.";
				String detalhesAnimal = JOptionPane.showInputDialog(novosDetalhesAnimal);

				Animal novoAnimal = new Animal();
				novoAnimal.nome = detalhesAnimal;
				novoAnimal.texto = O_ANIMAL_QUE_VOCÊ_PENSOU + novoAnimal.nome + "?";

				Animal palpiteAnimal = new Animal();
				palpiteAnimal.nome = animalNovo;
				palpiteAnimal.texto = O_ANIMAL_QUE_VOCÊ_PENSOU_É + palpiteAnimal.nome + "?";

				novoAnimal.sim = palpiteAnimal;
				animal.nao = novoAnimal;
			} else {
				dadosAnimal(animal.nao);
			}
		}
	}

	public static void acaoBotaoOk(final Animal animal, JButton ok) {

		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dadosAnimal(animal);
			}
		});
	}
}