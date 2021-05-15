# language: pt
Funcionalidade: Preencher Formulario de Seguro
  Como um usuario do sistema
  Eu quero preencher os formularios de Seguro
  Para Enviar uma cotacao de seguro para meu email.
  
 @PreencherFormularioSeguro
  Esquema do Cenario: Preencher dados da aba Enter Vehicle Data Para Seguro de Automovel
    Dado que selecionei a cotacao do seguro para Automovel
    Quando preecho o formulario com dados do veiculo: <marca>, <performanceDoMotor>, <dataDeFabricacao>, <assentos>, <combustivel> , <precoDeTabela> , <placaVeiculo> e <mileagemAnual>
    E preencho o formulario com os dados do segurado: <nome>, <sobrenome>, <dataNascimento>, <genero>, <enderecoDaRua>, <pais>, <codigoPostal>, <cidade>, <ocupacao>, <hobbie> e <website>
    E preencho os dados do seguro desejado: <dataDeInicioSeguro>, <valorCobertoPeloSeguro>, <classeDeBonus>, <coberturaSeguro>, <produtosOpcionais> e <carroReserva>
    E seleciono o <plano> desejado
    E forneco os dados para envido da cotacao dos seguro: <email>, <telefone>, <usuario>, <senha>, <comentario> 
    Entao devo clicar em enviar
    E devo ver a mensagem de <enviadoComSucesso>
    #E devo prosseguir para o formulario de dados do segurado

    Exemplos: 
    | marca   | performanceDoMotor| dataDeFabricacao| assentos| combustivel| precoDeTabela| placaVeiculo| mileagemAnual|  nome | sobrenome| dataNascimento| genero| enderecoDaRua                | pais    | codigoPostal| cidade     | ocupacao  | hobbie          | website                     | dataDeInicioSeguro| valorCobertoPeloSeguro| valorCobertoPeloSeguro|  classeDeBonus| coberturaSeguro| produtosOpcionais        | carroReserva| plano | email                  | telefone      | usuario     | senha     | comentario                     | enviadoComSucesso        |
    | "Toyota"| "127"             | "06/29/2015"    | "5"     | "Gas"      | "12500"      | "JST6099"   | "9400"       | "Adam"| "Stone"  | "06/29/1988"  | "Male"| "Rua doze de Maio, numero 07"| "Brazil"| "14070007"  | "São Paulo"| "Employee"| "Bungee Jumping"| "https://github.com/fabioej"|"07/07/2021"       | "25000000"            | "25000000"            |  "Bonus 7"    | "Full Coverage"| "Legal Defense Insurance"| "Yes"       | "Gold"| "adam_stone@google.com"| "011988213344"| "adam_stone"| "aA123456"| "Comment only for test propose"| "Sending e-mail success!"|
 
  