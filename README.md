# TP2 — Java e Programação Orientada a Objetos

Repositório educacional com exemplos independentes escritos em Java para praticar Programação Orientada a Objetos (POO). Cada pacote demonstra um conjunto de conceitos, como abstração, herança, encapsulamento, interfaces e polimorfismo.

O projeto é configurado com **Java 17** e **Maven** e pode ser compilado e executado pelo terminal ou por uma IDE compatível com Maven. A única dependência externa é o [Gson](https://github.com/google/gson), usada pelo exemplo de consulta de CEP para ler o JSON devolvido pela API.

## Objetivos de aprendizagem

Ao explorar os exemplos, você deverá ser capaz de:

- entender o papel de classes abstratas e interfaces;
- aplicar herança e sobrescrita de métodos;
- observar o polimorfismo em tempo de execução;
- identificar comportamento compartilhado e comportamento especializado;
- usar encapsulamento para proteger o estado de objetos;
- relacionar classes concretas ao contrato declarado pela abstração;
- comparar o cálculo e a seleção de valores em diferentes implementações;
- validar dados antes de usá-los e explicar o erro ao usuário;
- consumir uma API HTTP e converter a resposta JSON em objetos.

## Tecnologias

- Java 17
- Maven 3.x
- API padrão do Java
- [Gson](https://github.com/google/gson) 2.11.0 (somente no exemplo de CEP)
- Eclipse ou outra IDE com suporte a projetos Maven

## Pré-requisitos

Antes de começar, instale:

1. **JDK 17 ou superior**;
2. **Maven 3.x**;
3. Uma IDE, caso deseje executar os exemplos por interface gráfica.

Confira as versões instaladas:

```bash
java -version
mvn -version
```

O Maven deve estar disponível no `PATH` do sistema.

## Setup

Clone o repositório:

```bash
git clone git@github.com:fabiomedeirosf/tp2-2026-2.git
cd tp2-2026-2
```

Compile o projeto:

```bash
mvn clean compile
```

Ao concluir, as classes compiladas estarão em `target/classes` e as dependências baixadas em `target/lib`.

Como o exemplo de CEP precisa do Gson em tempo de execução, a execução dele usa um classpath com os dois diretórios. No Windows, o separador é `;`:

```bash
java -cp "target/classes:target/lib/*" br.fatec.cep.App
```

### Usando uma IDE

No Eclipse:

1. selecione **File > Import**;
2. escolha **Existing Maven Projects**;
3. selecione a pasta raiz do projeto;
4. conclua a importação;
5. abra uma das classes `App` listadas abaixo;
6. execute o método `main`.

Se a IDE solicitar um JDK, selecione o Java 17.

## Como executar os exemplos

O `pom.xml` não define uma classe principal padrão. Por isso, cada exemplo deve ser executado individualmente.

```bash
java -cp target/classes br.fatec.Main
java -cp target/classes br.fatec.banco.App
java -cp target/classes br.fatec.heranca.App
java -cp target/classes br.fatec.heranca.apostas.App
java -cp target/classes br.fatec.delivery.App
java -cp target/classes br.fatec.imc.App
java -cp "target/classes:target/lib/*" br.fatec.cep.App
```

A tabela abaixo resume as classes de entrada:

| Exemplo | Classe principal | Comando |
|---|---|---|
| Coleções | `br.fatec.Main` | `java -cp target/classes br.fatec.Main` |
| Sistema financeiro | `br.fatec.banco.App` | `java -cp target/classes br.fatec.banco.App` |
| Impostos | `br.fatec.heranca.App` | `java -cp target/classes br.fatec.heranca.App` |
| Apuração de apostas | `br.fatec.heranca.apostas.App` | `java -cp target/classes br.fatec.heranca.apostas.App` |
| Cálculo de frete | `br.fatec.delivery.App` | `java -cp target/classes br.fatec.delivery.App` |
| Cálculo de IMC | `br.fatec.imc.App` | `java -cp target/classes br.fatec.imc.App` |
| Consulta de CEP | `br.fatec.cep.App` | `java -cp "target/classes:target/lib/*" br.fatec.cep.App` |

O exemplo de IMC é interativo: pede peso e altura digitados no teclado e aceita tanto `1.75` quanto `1,75`.

O exemplo de CEP também é interativo: pede o CEP digitado no teclado e faz requisições reais à internet.

## Mapa dos exemplos

### 1. Coleções e frequência de números

**Pacote:** `br.fatec`  
**Classe principal:** `Main`

Esse exemplo gera uma lista de números aleatórios, conta quantas vezes cada número aparece e apresenta o resultado em ordem crescente.

Conceitos e recursos estudados:

- `Random` para geração de números aleatórios;
- `ArrayList` para armazenar os números gerados;
- `HashMap` para contar frequências;
- `getOrDefault` para obter e atualizar contadores;
- `TreeMap` para ordenar as chaves;
- `Map.Entry` para percorrer pares chave–valor;
- `Stream` e `mapToInt` para somar as frequências;
- métodos estáticos como `gerarNumeros` e `contarFrequencia`.

Por padrão, o programa gera 100 números entre 0 e 99. Como valores aleatórios são usados, a saída muda a cada execução.

```bash
java -cp target/classes br.fatec.Main
```

### 2. Sistema financeiro com abstração e polimorfismo

**Pacote:** `br.fatec.banco`  
**Classe principal:** `App`

O exemplo modeliza contas e três instituições financeiras que compartilham o contrato definido pela interface `Financeira`.

#### Componentes principais

- `Financeira`: interface com as operações de depósito e saque;
- `FinanceiraPadrao`: classe abstrata com a implementação padrão dessas operações;
- `RoniPay`: instituição que também oferece financiamento;
- `DennerBank`: aplicação de incentivo em determinados depósitos;
- `Duda2Pay`: saque com limite adicional calculado sobre o saldo;
- `Financiamento`: contrato implementado por `RoniPay`;
- `Conta`: encapsula saldo, financiamento e extrato.

A mesma variável do tipo `Financeira` recebe implementações diferentes. Em Java, essa referência permite que o comportamento chamado seja resolvido em tempo de execução por meio de sobrescrita de métodos, demonstrando polimorfismo.

```bash
java -cp target/classes br.fatec.banco.App
```

O diagrama de classes está disponível em [diagrama do sistema financeiro](diagramas/financeira.png). O código-fonte do diagrama em PlantUML está em [financeira.puml](diagramas/financeira.puml).

### 3. Herança e cálculo de impostos

**Pacote:** `br.fatec.heranca`  
**Classe principal:** `App`

Este exemplo compara três implementações de cálculo de impostos:

- `ImpostoPadrao`: aplica 10% sobre o valor da venda;
- `ImpostoMG`: define faixas de imposto específicas para Minas Gerais;
- `ImpostoRJ`: reutiliza o comportamento padrão e sobrescreve o método para aplicar as regras do Rio de Janeiro.

A mesma referência do tipo `Imposto` é reutilizada para as três implementações. Isso demonstra novamente o polimorfismo.

```bash
java -cp target/classes br.fatec.heranca.App
```

A saída esperada é:

```text
Valor IMposto: 150.0
mg: 180.0
RJ: 960.0
```

### 4. Abstração na apuração de apostas

**Pacote:** `br.fatec.heranca.apostas`  
**Classe principal:** `App`

A classe abstrata `Apuracao` concentra o cálculo dos números acertados, enquanto cada modalidade implementa seu próprio método de avaliação do prêmio.

Componentes:

- `Apuracao`: define a operação comum e o método `apurar`;
- `ApuracaoLotoFacil`: reconhece apenas o resultado com 15 acertos;
- `ApuracaoMegaSena`: classifica quadra, quina e prêmio principal;
- `ApuracaoTeleSena`: permanece abstrata, deixando a implementação concreta como evolução do exemplo.

A referência `Apuracao` pode trabalhar com diferentes modalidades sem que o código principal dependa da implementação concreta.

```bash
java -cp target/classes br.fatec.heranca.apostas.App
```

### 5. Abstração e comparação de fretes

**Pacote:** `br.fatec.delivery`  
**Classe principal:** `App`

O exemplo define a abstração `Cotacao` e três transportadoras com regras diferentes:

- `CarolLog`;
- `ThiLog`;
- `RichLog`.

A classe `BIDTransporte` solicita as cotações, imprime os resultados e devolve a opção com o menor valor. O tipo `Cotacao` permite tratar as três empresas de maneira uniforme.

Também são usados:

- classe abstrata;
- sobrescrita;
- polimorfismo;
- encapsulamento dos dados em `Frete`;
- enumeração das UFs brasileiras;
- comparação de objetos.

```bash
java -cp target/classes br.fatec.delivery.App
```

### 6. Encapsulamento, validação e enumeração no cálculo de IMC

**Pacote:** `br.fatec.imc`  
**Classe principal:** `App`

Este exemplo calcula o Índice de Massa Corporal a partir do peso e da altura e classifica o resultado. Diferente dos demais, ele é **interativo**: os valores são digitados no teclado.

Componentes:

- `IMC`: guarda peso e altura, valida a entrada e calcula o índice;
- `ClassificacaoIMC`: enumeração com as faixas da OMS e um emoji representativo por faixa;
- `App`: realiza a leitura do teclado e a exibição do resultado.

Comportamentos estudados:

- validação de dados no construtor, com `IllegalArgumentException` e mensagem explicativa;
- encapsulate e expõe por `getters` e `setters`;
- `enum` com atributos e construtor privado;
- método `static` de fábrica (`ClassificacaoIMC.de`) que localiza a faixa correspondente;
- leitura de entrada com `Scanner`, tratando erro de formato com `try`/`catch`;
- laço de repetição que permite calcular vários índices na mesma execução.

As faixas seguem a classificação da OMS para adultos. Cada faixa é fechada na esquerda e aberta na direita, por isso um IMC de exatamente `25.00` já pertence a **Sobrepeso** e não a **Normal**.

| Faixa | Classificação |
|---|---|
| abaixo de 18,5 | Magreza |
| 18,5 a 24,9 | Normal |
| 25,0 a 29,9 | Sobrepeso |
| 30,0 a 34,9 | Obesidade grau I |
| 35,0 a 39,9 | Obesidade grau II |
| 40,0 ou mais | Obesidade grau III |

O IMC é uma estimativa. O exemplo exibe, junto do resultado, um aviso de que ele não substitui uma avaliação médica.

```bash
java -cp target/classes br.fatec.imc.App
```

Quando a entrada é um número, o programa calcula, classifica e pergunta se deseja calcular outro índice. Peso e altura iguais a zero ou negativos são recusados com uma explicação, e a leitura de um valor não numérico repete a pergunta.

### 7. Consulta de CEP com HTTP e JSON

**Pacote:** `br.fatec.cep`  
**Classe principal:** `App`

Este exemplo consulta a API pública da [ViaCEP](https://viacep.com.br). O usuário digita um CEP e o programa exibe o endereço correspondente.

Componentes:

- `Endereco`: guarda os dados do endereço devolvidos pela API;
- `ViaCepClient`: monta a requisição HTTP, envia e transforma o JSON em um `Endereco`;
- `App`: realiza a leitura do teclado e a exibição do resultado.

Recursos estudados:

- `HttpClient` e `HttpRequest`, da API padrão do Java, para a requisição `GET`;
- `BodyHandlers.ofString`, com `UTF-8`, para ler o corpo da resposta;
- `Gson` para converter o JSON em objetos;
- `JsonObject` para inspecionar a resposta antes de convertê-la;
- tempo limite (`timeout`) de conexão e de requisição;
- `IOException` para falha de rede e `InterruptedException` para interrupção da execução;
- leitura de entrada com `Scanner` e laço que repete a consulta.

O endereço da requisição é montado a partir do CEP digitado:

```text
https://viacep.com.br/ws/{cep}/json/
```

Antes da chamada, o exemplo remove tudo que não for dígito, de modo que tanto `01310100` quanto `01310-100` funcionam. Quando o CEP não existe, a API responde apenas com `{"erro": true}` e o programa avisa que o CEP não foi encontrado; falhas de rede ou de status HTTP Produzem uma mensagem explicativa, e a consulta pode ser repetida na mesma execução.

```bash
java -cp "target/classes:target/lib/*" br.fatec.cep.App
```

Para um CEP válido, como `01310-100`, a saída é:

```text
Informe o CEP: 01310-100

CEP: 01310-100
Logradouro: Avenida Paulista
Complemento: de 612 a 1510 - lado par
Bairro: Bela Vista
Cidade: São Paulo
UF: SP
DDD: 11
```

Este exemplo é o único do projeto que depende do Gson. Por isso a execução usa o classpath com `target/lib`, onde o `maven-dependency-plugin` copia as dependências durante a compilação.

## Conceitos de POO em resumo

| Conceito | Onde observar |
|---|---|
| Abstração | `Financeira`, `Imposto`, `Apuracao` e `Cotacao` |
| Herança | `FinanceiraPadrao`, `ImpostoPadrao` e `Apuracao` |
| Polimorfismo | referências dos tipos `Financeira`, `Imposto`, `Apuracao` e `Cotacao` |
| Encapsulamento | estado e operações de `Conta`, `Frete` e `Endereco` |
| Sobrescrita | métodos de saque e cálculo específico das subclasses |
| Composição | `Conta` associada às operações financeiras e ao extrato |

## Testes

O projeto não possui testes automatizados. A pasta `src/test/java` não existe e nenhuma biblioteca de testes, como JUnit, está declarada no Maven.

A fase de testes do Maven pode ser executada, mas atualmente não valida regras de negócio:

```bash
mvn test
```

Para validar que todos os exemplos continuam compilando, use:

```bash
mvn clean compile
```

## Limitações e observações

Os exemplos foram propostos para estudo e possuem pontos que podem ser discutidos ou aprimorados:

- `FinanceiraPadrao.sacar` não valida explicitamente valores negativos;
- `Duda2Pay.sacar` calcula um limite sobre um saldo que pode ter se tornado negativo;
- o comentário `//erro` em `br.fatec.banco.App` não corresponde a uma exceção na sequência atual de saques;
- `BIDTransporte` não verifica se as cotações retornadas são nulas;
- `CarolLog.cotar` pode retornar `null` para pesos acima do limite suportado;
- algumas regras não validam entradas nulas ou valores negativos;
- a formatação de datas em `Conta` utiliza `YYYY`, que pode representar semana do ano em vez do ano calendário em Java;
- `ApuracaoTeleSena` está abstrata e não possui implementação concreta;
- `ViaCepClient` depende da API pública da ViaCEP, que exige conexão com a internet e pode ficar indisponível ou mudar de formato.

Essas limitações não são corrigidas neste repositório para preservar os exemplos originais da aula.

## Estrutura do projeto

```text
.
├── pom.xml
├── diagramas/
│   ├── financeira.png
│   └── financeira.puml
└── src/
    └── main/
        └── java/
            └── br/
                └── fatec/
                    ├── Main.java
                    ├── banco/
                    ├── cep/
                    ├── delivery/
                    ├── imc/
                    └── heranca/
                        └── apostas/
```

Os diretórios `.git`, `.settings`, `.classpath` e `target` também podem existir no ambiente de desenvolvimento, mas não são apresentados aqui como parte da estrutura didática principal.
