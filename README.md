# Biblioteca

##Informações:

###Programa criado pelos alunos:
- Rafael Kenji Nissi - 8937013
- Luiz Massao Miyazaki - 8937080

####Objetivo: 
Criar uma biblioteca, que contém as seguintes características:
- Cadastrar usuários, que podem ser alunos (emprestam até 4 livros por até 15 dias), professores (emprestam até 6 livros por até 60 dias) ou comunidade (emprestam 2 livros por até 15 dias).
- Cadastrar livros, que podem ser texto (somente alunos e professores podem emprestar) ou geral (que todos podem emprestar).
- Registrar os empréstimos, avisar quando está em atraso, registrar devoluções
- Calcular a suspensão em caso de atraso. Atraso na entrega do livro implica em suspensão pela quantidade de dias atrasados.
- Listar todos os livros cadastrados, todos os usuários, todos os empréstimos.
- O sistema deve ler e recuperar as informações em arquivos, no formato CSV.
- O sistema deve permitir simular qual é a data atual.

##Como usar o programa:

###Parte inicial:
1 - Se tiver todos os arquivos, use o Netbeans para iniciar o projeto.

2 - Copile o programa.

3 - Inicie o programa.

4 - Escreva a sua escolha de Locale (en US para Ingles ou pt BR para português).

OBS: Note que entre o idioma e o país, é necessário apertar Enter.
Exemplo:

en

US

5 - Escreva a data desejada. Caso seja uma data do passado, ele entrará no modo Read Only. Caso seja qualquer outra data, ele funcionará normal. Caso queira usar a data do computador, apenas escreva 0.

OBS: Note que o programa supôe que todo mês tem 30 dias, e uma ano tem 365 dias;

6 - Use o programa normalmente! Caso esteja em modo Read Only, nada pode ser modificado. Como ordenar a lista continuará igual, ela ainda funcionará.

###Parte Normal:

O programa contém vários items a sua escolha para fazer várias ações, como emprestar um livro, receber um livro, adicionar ou remover pessoas e livros, ver informações sobre certo livro ou pessoa etc.

- Menu de Pessoa: Inclui items para você fazer algo com as pessoas cadastradas, como adicionar/remover, imprimir todas as pessoas, ver quais livros tem uma certa pessoa etc. Note que para a maioria das ações, é necessário o ID da pessoa.

- Menu de livros: Contém items como adicionar/remover, emprestar ou receber um livro de alguém etc. Note que para fazer alguma ação (por exemplo emprestar um livro) será necessário informar o nome exato do livro (incluindo letras maiúsculas ou minúsculas).

- Menu de datas: Mostra qual a data que você selecionou no início e qual data é a mais atual do sistema. Qualquer data a partir da data mais atual do sistema não entra no modo Read Only.

- Menu de histórico: Inclui informações de empréstimos e recebimentos de livros. Esse modo é sicronizado com a data escolhida no início. Então, se você "voltar ao passado", você vê o histórico da época.

- Sair: Fecha o programa e atualiza os arquivos.

OBS: O menu de histórico é o único que é sicronizado coma  data escolhida no início. O resto, como informações da pessoa, estão de acordo com a data mais atual.

OBS: Para ter acesso ao arquivo .jar, vá até a pasta dist.
