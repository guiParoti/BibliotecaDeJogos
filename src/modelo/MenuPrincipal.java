package modelo;

import java.util.Scanner;

import banco.AcessarBanco;

public class MenuPrincipal {

	public MenuPrincipal() {

		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		AcessarBanco manipularBanco = new AcessarBanco();

// Loop principal do menu
		
		while (true) {
			System.out.println("\n|---------- Menu ----------|");
			System.out.println("1 - Adicionar novo jogo");
			System.out.println("2 - Meus jogos");
			System.out.println("3 - Editar jogos");
			System.out.println("4 - Deletar jogos");
			System.out.println("5 - Sair");
			System.out.println("|--------------------------|");
			System.out.print("R: ");
			String opcaoMenuPrincipal = entrada.nextLine();

			int opcaoMenuPrincipalInt;
			try {
				opcaoMenuPrincipalInt = Integer.parseInt(opcaoMenuPrincipal);
			} catch (NumberFormatException e) {
				System.out.println("Insira somente números!");
				continue;
			}

			switch (opcaoMenuPrincipalInt) {

			default:
				System.out.println("Insira uma opção válida!");
				continue;

// Adicionar novo jogo
				
			case 1:
				while (true) {
					try {

						System.out.print("\n-------------- Novo Jogo --------------");
						System.out.print("\nNome do jogo: ");
						String nome = entrada.nextLine();

						if (nome.equalsIgnoreCase("sair")) {
							break;
						}

						System.out.print("Total de horas: ");
						String totalHorasStr = entrada.nextLine().replace(",", ".");
						double totalHoras = Double.parseDouble(totalHorasStr);
						System.out.print("Nota: ");
						String notaStr = entrada.nextLine().replace(",", ".");
						double nota = Double.parseDouble(notaStr);
						System.out.print("Review: ");
						String review = entrada.nextLine();
						System.out.print("Zerou: ");
						String zerou = entrada.nextLine();

						manipularBanco.adicionarJogo(new Jogo(nome, totalHoras, nota, review, zerou));
						break;

					} catch (Exception e) {
						System.out.println(
								"Erro! Tente novamente e com informações válidas!\nOu digite 'sair' para cancelar!");
						continue;
					}
				}
				break;
// Meus jogos
				
			case 2:
				manipularBanco.meusJogos().forEach(p -> {
					System.out.println(p);
				});
				break;

// Editar jogos
				
			case 3:
				boolean loop = true;

				while (loop) {
					int idBusca = 0;
					try {
						System.out.print("Digite o id do jogo(0 para cancelar): ");
						String idStr = entrada.nextLine();

						if (idStr.equals("0")) {
							break;
						}

						idBusca = Integer.parseInt(idStr);
						Jogo jogo = manipularBanco.buscarPorId(idBusca);

						if (jogo != null) {
							System.out.println(jogo);

						} else if (jogo == null) {
							System.out.println("Jogo não encontrado!");
							continue;
						}

					} catch (Exception e) {
						System.out.println("Digite um id válido!");
						continue;
					}

					int id = idBusca;

					System.out.print("\nSelecione o que deseja editar\n" + "1- Nome\n" + "2- Total de horas\n"
							+ "3- Nota\n" + "4- Review\n" + "5- Zerou\n" + "6- Sair\n" + "R: ");

					String opcaoStr = entrada.nextLine();
					int opcao;
					try {
						opcao = Integer.parseInt(opcaoStr);

						switch (opcao) {

						case 1:
							System.out.print("\nDigite o novo nome: ");
							String nome = entrada.nextLine();
							manipularBanco.atualizarNome(id, nome);
							mensagemDeAtualizado();
							break;
						case 2:
							System.out.print("\nDigite o novo total de horas: ");
							String totalHorasStr = entrada.nextLine().replace(",", ".");
							double totalHoras = Double.parseDouble(totalHorasStr);
							manipularBanco.atualizarTotalHoras(id, totalHoras);
							mensagemDeAtualizado();
							break;
						case 3:
							System.out.print("\nDigite a nova nota: ");
							String notaStr = entrada.nextLine().replace(",", ".");
							double nota = Double.parseDouble(notaStr);
							manipularBanco.atualizarNota(id, nota);
							mensagemDeAtualizado();
							break;
						case 4:
							System.out.print("\nDigite a nova review: ");
							String review = entrada.nextLine();
							manipularBanco.atualizarReview(id, review);
							mensagemDeAtualizado();
							break;
						case 5:
							System.out.print("\nFinalizou o jogo: ");
							String zerou = entrada.nextLine();
							manipularBanco.atualizarFinalizou(id, zerou);
							mensagemDeAtualizado();
							break;
						case 6:
							loop = false;
							break;

						default:
							System.out.println("Insira um número de 1 a 6!");
						}

					} catch (Exception e) {
						System.out.println("Selecione uma opção válida!");
					}
				}
				break;

// Deletar jogos
				
			case 4:
				while (true) {
					System.out.print("Digite o id que deseja deletar(0 para cancelar):");
					String idStr = entrada.nextLine();

					if (idStr.equals("0")) {
						break;
					}
					try {
						int idDel = Integer.parseInt(idStr);
						Jogo jogo = manipularBanco.buscarPorId(idDel);
						if (jogo != null) {
							manipularBanco.deletarJogo(jogo.getId());
							System.out.println("\n------------------------\nJogo deletado!\n------------------------");
							break;
						} else {
							System.out.println("Jogo não encontrado");
							continue;
						}
					} catch (Exception e) {
						System.out.println("Insira um id válido!");
					}
				}
				break;

			case 5:
				System.out.println("Até mais!");
				return;
			}

		}
// Fim do loop principal
	}

	static void mensagemDeAtualizado() {
		System.out.println("\n------------------------\nJogo atualizado!\n------------------------");
	}

}
