# TP2 — Java e Programação Orientada a Objetos

Repositório educacional com exemplos independentes escritos em Java para praticar Programação Orientada a Objetos (POO). Cada pacote demonstra um conjunto de conceitos, como abstração, herança, encapsulamento, interfaces e polimorfismo.

O projeto é configurado com **Java 17** e **Maven**, não possui dependências externas e pode ser compilado e executado pelo terminal ou por uma IDE compatível com Maven.

## Objetivos de aprendizagem

Ao explorar os exemplos, você deverá ser capaz de:

- entender o papel de classes abstratas e interfaces;
- aplicar herança e sobrescrita de métodos;
- observar o polimorfismo em tempo de execução;
- identificar comportamento compartilhado e comportamento especializado;
- usar encapsulamento para proteger o estado de objetos;
- relacionar classes concretas ao contrato declarado pela abstração;
- comparar o cálculo e a seleção de valores em diferentes implementações.

## Tecnologias

- Java 17
- Maven 3.x
- API padrão do Java
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

Ao concluir, as classes compiladas estarão em `target/classes`.

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
```

A tabela abaixo resume as classes de entrada:

| Exemplo | Classe principal | Comando |
|---|---|---|
| Coleções | `br.fatec.Main` | `java -cp target/classes br.fatec.Main` |
| Sistema financeiro | `br.fatec.banco.App` | `java -cp target/classes br.fatec.banco.App` |
| Impostos | `br.fatec.heranca.App` | `java -cp target/classes br.fatec.heranca.App` |
| Apuração de apostas | `br.fatec.heranca.apostas.App` | `java -cp target/classes br.fatec.heranca.apostas.App` |
| Cálculo de frete | `br.fatec.delivery.App` | `java -cp target/classes br.fatec.delivery.App` |

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

## Conceitos de POO em resumo

| Conceito | Onde observar |
|---|---|
| Abstração | `Financeira`, `Imposto`, `Apuracao` e `Cotacao` |
| Herança | `FinanceiraPadrao`, `ImpostoPadrao` e `Apuracao` |
| Polimorfismo | referências dos tipos `Financeira`, `Imposto`, `Apuracao` e `Cotacao` |
| Encapsulamento | estado e operações de `Conta` e `Frete` |
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
- `ApuracaoTeleSena` está abstrata e não possui implementação concreta.

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
                    ├── delivery/
                    └── heranca/
                        └── apostas/
```

Os diretórios `.git`, `.settings`, `.classpath` e `target` também podem existir no ambiente de desenvolvimento, mas não são apresentados aqui como parte da estrutura didática principal.
