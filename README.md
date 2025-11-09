## 📌 Sobre o Projeto

Este serviço implementa um **CRUD de Usuários** estruturado com **Domain-Driven Design (DDD)** e **Arquitetura Hexagonal**.

A aplicação utiliza **Java 21**, **Spring Boot 3.5**.

---

## ✅ Funcionalidades

O serviço expõe operações essenciais para gerenciamento de usuários:

- **Criar usuário**
- **Buscar usuário por ID**
- **Buscar usuário por nome**
- **Atualizar dados do usuário**
- **Ativar / desativar usuário**
- **Listar usuários**
- **Remover usuário**

---

## ✅ Características Arquiteturais

- **Domínio isolado de frameworks**  
  Modelos de domínio explícitos (`User`, `UserName`, `UserEmail`) e regras encapsuladas.

- **Validações de domínio dedicadas**  
  Implementadas via `UserValidator`, reforçando invariantes e consistência.

- **Portas e Adaptadores (Hexagonal)**  
  - Porta de saída: `DomainUserRepository`  
  - Adaptadores de persistência e entrada evolutivos.

---
