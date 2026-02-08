🎮 Biblioteca de Jogos em Java

Projeto de biblioteca de jogos desenvolvido em Java, com interface via console e persistência de dados utilizando SQLite.
A aplicação permite ao usuário gerenciar sua coleção de jogos de forma simples, segura e organizada.

Este projeto foi pensado desde o início para ser evolutivo, começando no console e, futuramente, sendo atualizado para uma versão com interface gráfica (GUI).

📌 Funcionalidades

➕ Adicionar novos jogos, informando:

Nome do jogo

Total de horas jogadas

Nota

Review

Status de finalização (zerou ou não)

📋 Listar todos os jogos cadastrados na biblioteca

✏️ Editar jogos existentes, permitindo atualizar individualmente:

Nome

Total de horas

Nota

Review

Status de finalização

🗑️ Deletar jogos pelo ID, com verificação de existência

🛡️ Menu totalmente validado, com tratamento de:

Entradas inválidas

IDs inexistentes

Opções fora do menu

Cancelamento de operações

🧱 Estrutura do Projeto

O projeto segue uma organização baseada em responsabilidades bem definidas:

MenuPrincipal
Responsável por toda a interação com o usuário via console, controle do menu e validação de entradas.

Jogo (Model)
Classe que representa a entidade Jogo, contendo seus atributos e métodos de acesso.

AcessarBanco (DAO)
Responsável por todas as operações de banco de dados (CRUD) utilizando SQLite e JDBC, mantendo a lógica de persistência separada da interface.

Essa separação facilita a manutenção, leitura do código e futuras expansões do projeto.

🛠️ Tecnologias Utilizadas

Java

SQLite

JDBC

Programação Orientada a Objetos (POO)

DAO (Data Access Object)

🔮 Próximas Atualizações

🚧 Planejamento futuro:

Implementar uma interface gráfica (GUI) utilizando Java Swing

Reaproveitar toda a lógica de negócio e acesso ao banco de dados já existente

Separar ainda mais as camadas do projeto (interface, lógica e persistência)

O desenvolvimento no console foi feito propositalmente para garantir uma base sólida antes da migração para a interface gráfica.

📂 Como Executar

Clone o repositório:

git clone https://github.com/seu-usuario/seu-repositorio.git


Abra o projeto em uma IDE Java (Eclipse, IntelliJ ou similar).

Adicione o driver JDBC do SQLite ao projeto:

Baixe o driver em:
https://github.com/xerial/sqlite-jdbc

Adicione o .jar ao Build Path do projeto.

Certifique-se de que o driver do SQLite está corretamente configurado na IDE.

Execute a classe Main.

Utilize o menu interativo no console para gerenciar sua biblioteca de jogos.

⚠️ Observação Importante

Sem o driver JDBC do SQLite, a aplicação não conseguirá se conectar ao banco de dados.
Esse passo é obrigatório para o funcionamento correto do projeto.

📖 Observações

Este projeto tem como foco o aprendizado prático de Java, banco de dados e organização de código, servindo como base para evoluções futuras.
