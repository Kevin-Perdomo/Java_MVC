# Projeto MVC em JAVA

<div align="center">
 <img src=https://www.vectorlogo.zone/logos/java/java-horizontal.svg>
</div>

---

## Gerenciador de Eventos

Este projeto é um gerenciador de eventos simples desenvolvido em Java, utilizando a biblioteca Swing para a interface gráfica. O aplicativo permite que os usuários adicionem eventos, que são salvos em um arquivo de texto. Os eventos são exibidos na interface e persistem mesmo após o fechamento do aplicativo.

## Funcionalidades

- Adicionar eventos com nome, data e hora, e local.
- Validação do formato de data e hora (DD/MM/AAAA - HH:MM).
- Salvar eventos em um arquivo de texto (`eventos.txt`).
- Carregar eventos existentes do arquivo ao iniciar o aplicativo.
- Interface gráfica intuitiva desenvolvida com Swing.

## Estrutura do Projeto

O projeto é composto por três classes principais:

1. **EventoModel**: Representa um evento com nome, data/hora e local.
2. **EventoView**: Responsável pela interface gráfica e interação com o usuário.
3. **EventoController**: Controlador que gerencia a lógica do aplicativo, conectando a visão e o modelo.

## Tecnologias Utilizadas

- Java
- Swing (para a interface gráfica)
- IO (para manipulação de arquivos)

## Configuração do Ambiente

Antes de começar, certifique-se de que o compilador Java está instalado em sua máquina. Você pode verificar isso executando os seguintes comandos no terminal:

Este comando exibe a versão do runtime Java (Java Runtime Environment - JRE) instalada em seu sistema. <br>
É útil para verificar se o Java está instalado e qual versão você está utilizando para executar aplicativos Java.
```bash
java --version
```

Este comando exibe a versão do compilador Java (Java Compiler) instalado em seu sistema. <br>
O compilador é responsável por compilar arquivos de código-fonte Java (com extensão .java) em bytecode (arquivos .class) que podem ser executados pela Java Virtual Machine (JVM). 
```bash
javac --version
```

## Configuração do Ambiente

Para desenvolver este projeto, foi utilizado o **Java Extension Pack** da Microsoft no Visual Studio Code. Com esta extensão, você pode facilmente configurar o ambiente para projetos Java.

### Criando um Novo Projeto

1. Abra o Visual Studio Code.
2. Pressione `Ctrl + Shift + P` para abrir a barra de comando.
3. Digite `>Java: Create Java Project ...` e pressione `Enter`.
4. Siga as instruções para configurar seu novo projeto.

---
