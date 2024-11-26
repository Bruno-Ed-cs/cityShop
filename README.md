# Documentação da Classe `Database`

A classe `Database` é um singleton responsável por gerenciar os dados de um aplicativo, permitindo carregar, salvar, adicionar, alterar e remover registros de usuários, lojas e produtos. Os dados são armazenados em arquivos JSON localizados no diretório `./src/resources/`.

## Índice

- [Como Usar a Classe](#como-usar-a-classe)
- [Métodos Públicos](#métodos-públicos)
  - [Instância Singleton](#instância-singleton)
  - [Carregar e Salvar Dados](#carregar-e-salvar-dados)
  - [Consultar Registros](#consultar-registros)
  - [Adicionar Registros](#adicionar-registros)
  - [Alterar Registros](#alterar-registros)
  - [Remover Registros](#remover-registros)

---

## Como Usar a Classe

A classe `Database` segue o padrão Singleton, ou seja, apenas uma instância dela será criada e compartilhada ao longo da aplicação.

### Exemplo de Uso

```java
Database db = Database.getInstance();

// Adicionar um novo usuário
Usuario usuario = new Usuario(...);
db.addUsuario(usuario);

// Consultar um produto
Produto produto = db.getProduto(1L);

// Alterar uma loja
Loja lojaAtualizada = new Loja(...);
db.changeLoja(lojaAtualizada, 1L);

// Remover um produto
db.removeProduto(2L);
```

---

## Métodos Públicos

### Instância Singleton

#### `static Database getInstance()`
Retorna a instância única da classe `Database`.

**Exemplo:**
```java
Database db = Database.getInstance();
```

---

### Carregar e Salvar Dados

#### `void load()`
Carrega os dados do arquivo JSON para a memória. Chamado automaticamente no construtor da classe.

#### `void save()`
Salva os dados modificados da memória de volta para o arquivo JSON.

---

### Consultar Registros

#### `Usuario getUsuario(Long idUser)`
Retorna um usuário pelo seu ID.

**Exemplo:**
```java
Usuario usuario = db.getUsuario(1L);
```

#### `Loja getLoja(Long idLoja)`
Retorna uma loja pelo seu ID.

**Exemplo:**
```java
Loja loja = db.getLoja(1L);
```

#### `Produto getProduto(Long idProduto)`
Retorna um produto pelo seu ID.

**Exemplo:**
```java
Produto produto = db.getProduto(1L);
```

#### `Produto[] querryProduto(Long idLoja)`
Retorna os produtos associados a uma loja específica pelo ID da loja.

**Exemplo:**
```java
Produto[] produtos = db.querryProduto(1L);
```

#### `Produto[] querryProduto()`
Retorna todos os produtos.

**Exemplo:**
```java
Produto[] produtos = db.querryProduto();
```

#### `Loja[] querryLoja()`
Retorna todas as lojas.

**Exemplo:**
```java
Loja[] lojas = db.querryLoja();
```

#### `Usuario[] querryUsuarios()`
Retorna todos os usuários.

**Exemplo:**
```java
Usuario[] usuarios = db.querryUsuarios();
```

---

### Adicionar Registros

#### `void addUsuario(Usuario usuario)`
Adiciona um novo usuário à base de dados.

**Exemplo:**
```java
Usuario usuario = new Usuario(...);
db.addUsuario(usuario);
```

#### `void addLoja(Loja loja)`
Adiciona uma nova loja à base de dados.

**Exemplo:**
```java
Loja loja = new Loja(...);
db.addLoja(loja);
```

#### `void addProduto(Produto produto)`
Adiciona um novo produto à base de dados.

**Exemplo:**
```java
Produto produto = new Produto(...);
db.addProduto(produto);
```

---

### Alterar Registros

#### `Boolean changeUsuario(Usuario novoUsuario, Long idTarget)`
Altera um usuário pelo ID.

**Exemplo:**
```java
Usuario usuarioAtualizado = new Usuario(...);
db.changeUsuario(usuarioAtualizado, 1L);
```

#### `Boolean changeLoja(Loja novaLoja, Long idTarget)`
Altera uma loja pelo ID.

**Exemplo:**
```java
Loja lojaAtualizada = new Loja(...);
db.changeLoja(lojaAtualizada, 1L);
```

#### `Boolean changeProduto(Produto novoProduto, Long idTarget)`
Altera um produto pelo ID.

**Exemplo:**
```java
Produto produtoAtualizado = new Produto(...);
db.changeProduto(produtoAtualizado, 1L);
```

---

### Remover Registros

#### `Boolean removeUsuario(Long idUsuario)`
Remove um usuário pelo ID.

**Exemplo:**
```java
Boolean sucesso = db.removeUsuario(1L);
```

#### `Boolean removeLoja(Long idLoja)`
Remove uma loja pelo ID.

**Exemplo:**
```java
Boolean sucesso = db.removeLoja(1L);
```

#### `Boolean removeProduto(Long idProduto)`
Remove um produto pelo ID.

**Exemplo:**
```java
Boolean sucesso = db.removeProduto(1L);
```

---

## Observações

- Certifique-se de inicializar a classe `Database` antes de utilizá-la.
- A classe utiliza arquivos JSON (`originalDB.json` e `active.json`) para persistência dos dados. Certifique-se de que esses arquivos estejam no diretório `./src/resources/`.
- As classes `Usuario`, `Loja` e `Produto` devem implementar métodos como `toJSON()` para integração com o `Database`.
