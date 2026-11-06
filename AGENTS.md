# AGENTS.md

Repositório didático de Java (aula TP2) sobre POO. Repo, README e comentários são em português — escreva código, identificadores e mensagens no mesmo idioma.

## Comandos

```bash
mvn clean compile                              # ÚNICA verificação válida do projeto
java -cp target/classes br.fatec.delivery.App  # executar um exemplo
```

- **Não existe teste algum.** Não há `src/test/java`, JUnit nem qualquer dependência no `pom.xml`. `mvn test` passa sem validar nada — nunca cite-o como verificação. `mvn clean compile` (BUILD SUCCESS) é o gate.
- Sem lint, formatador, typecheck separado, CI, pre-commit, codegen ou gerenciador de tarefas. Não invente comandos; rode `mvn` direto.
- `pom.xml` não define `mainClass`: cada exemplo roda pelo nome totalmente qualificado. Existem **cinco** classes `App` em pacotes diferentes (`br.fatec`, `br.fatec.banco`, `br.fatec.delivery`, `br.fatec.heranca`, `br.fatec.heranca.apostas`) — todas são entrypoints válidos e legítimas.

## Bugs intencionais — NÃO corrija

O README tem uma seção "Limitações e observações" que lista falhas de propósito, preservadas como material didático: ausência de validação de valores negativos, `//erro` em `br/fatec/banco/App.java`, retorno `null` em `CarolLog.cotar`, `YYYY` (semana do ano) no `Conta`, `ApuracaoTeleSena` abstrata sem implementação concreta, import `java.util.List` não usado, entre outros.

Se precisar alterar algo nessa lista, trate como mudança de aula: pergunte antes e atualize também a seção de limitações do README. Não "limpe" o código por conta própria.

## Git

- `exercicios/` está excluído por `.git/info/exclude` (exclusão **local**, não versionada, ausente do `.gitignore`). Por isso enunciados de exercício não aparecem no `git status` — nunca os adicione ao commit.
- Commits seguem Conventional Commits com assunto em português, um tema por commit: `feat: cotacao frete`, `docs: readme`, `feat: extrado e financiamento`.
- `target/`, `.settings/`, `.classpath` são ignorados; `.project` (Eclipse/m2e) é versionado.

## Quirks do build

- O `pom.xml` define `project.build.sourceEncoding` como UTF-8 — **não remova**: vários fontes têm acentos (`banco/RoniPay.java`, `banco/Conta.java`, `banco/FinanceiraPadrao.java`, `banco/DennerBank.java`, `heranca/Imposto.java`) e os emojis de `imc/ClassificacaoIMC.java` dependem disso para compilar em máquina não-UTF-8.
- O pom usa `maven.compiler.source/target` em vez de `maven.compiler.release`, daí o warning `location of system modules is not set in conjunction with -source 17` no JDK 25 local. Inofensivo; não "conserte" sem necessidade.

## Estrutura e convenções

Cada pacote é um exemplo independente e autocontido, um conceito por arquivo, sem Javadoc:

| Pacote | Conceito | Entry point |
|---|---|---|
| `br.fatec` | Coleções (`HashMap`/`TreeMap`/`Stream`) | `Main` |
| `br.fatec.banco` | Interface + classe abstrata, polimorfismo | `App` |
| `br.fatec.heranca` | Herança e sobrescrita de impostos | `App` |
| `br.fatec.heranca.apostas` | Abstração em apuração | `App` |
| `br.fatec.delivery` | Abstração e seleção de frete | `App` |
| `br.fatec.imc` | Encapsulamento, validação e `enum` | `App` |

- **Indentação inconsistente por arquivo:** `br/fatec/Main.java` usa 4 espaços; todo o resto usa tabs. Preserve o estilo do arquivo que você está editando.
- Tabelas de tensão/comparação e diagramas: `diagramas/financeira.puml` gera `diagramas/financeira.png` via PlantUML **manualmente** — não há integração com o Maven. Se alterar o modelo, regenere o PNG à mão ou avise que ele ficou desatualizado.

## Sincronize o README

O README é a referência do projeto (tabela de entry points, mapa dos exemplos, limitações). Ao adicionar/remover uma classe principal ou corrigir algo listado em "Limitações", atualize o README junto — a tabela de classes principais não é gerada automaticamente e já está desatualizada.

Estado do working tree no momento da escrita (não commite nada disto sem instrução): `pom.xml` ganhou `project.build.sourceEncoding`; `br/fatec/imc/` (App, IMC, ClassificacaoIMC) e o README são novos; `br/fatec/App.java`, `br/fatec/Calculadora.java` e `br/fatec/delivery/CotacaoAviao.java` seguem sem commit; `delivery/App.java`, `delivery/BIDTransporte.java` e `delivery/CarolLog.java` têm alterações locais.