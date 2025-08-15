# Projeto---conversor-de-moedas-

# 💱 Conversor de Moedas - Java

Curso de raticando Java: Challenge conversor de moedas. Um projeto simples em **Java** para conversão de valores entre diferentes moedas, utilizando a [ExchangeRate API](https://www.exchangerate-api.com/) para obter taxas de câmbio em tempo real e a biblioteca **org.json** para processar os dados recebidos no formato JSON.

# 💱 Conversor de Moedas - Java


## 🚀 Funcionalidades

- Conversão entre múltiplas moedas
- Menu interativo no console
- Busca de taxas de câmbio em tempo real
- Estrutura com classes separadas para organização
- Tratamento de erros básicos

---

## 🛠 Tecnologias Utilizadas

- **Java 17+** (funciona também em versões anteriores compatíveis)
- **[ExchangeRate API](https://www.exchangerate-api.com/)** (necessária chave de API gratuita)
- **org.json** para manipulação de JSON
- **Scanner** para entrada de dados via console

---

## 📂 Estrutura do Projeto

Conversor de moedas/
├── br.com.alura.conversor.principal/
├── src/
   ├──  Conversor.java              # classe principal (main)
   ├──  ConversorMoedas.java        # Lógica de conversão e API
   ├──  ConversorRecords.java       # Record para dados da conversão
   ├──  br.com.alura.conversor.principal.iml
├── out/production/br.com.alura.conversor.principal/
   ├──  Conversor.class
   ├──  ConversorMoedas.class
   ├──  ConversorRecords.class
   ├──  Conversor de moedas.iml
   ├──  LICENÇA
   ├──  LEIA-ME.md     

   
---

## ⚙️ Como Executar

1. **Baixe** ou clone este repositório:
   ```bash
   git clone https://github.com/RomuloFelipe1309/Projeto---conversor-de-moedas-.git

 2.  Adicione o arquivo json-20240303.jar na pasta lib e configure-o no projeto.

3. Obtenha sua chave da ExchangeRate API em:
 https://www.exchangerate-api.com/

4. Substitua SUA_CHAVE_API no código pela sua chave real.

5. Compile e execute:
   javac -cp "lib/json-20240303.jar;src" src/ConversorMoedas.java
java -cp "lib/json-20240303.jar;src" ConversorMoedas

🖼 Exemplo de Uso
*********************************************************
Olá! Seja muito bem-vindo ao conversor de moedas!

Digite o número correspondente à moeda base:
(1) USD - Dólar americano
(2) BRL - Real brasileiro
...
Digite o valor que deseja converter: 100
💱 100.00 USD = 487.50 BRL

📜 Licença
Este projeto é de uso livre para fins educacionais e está licenciado sob a MIT License.

---

  




