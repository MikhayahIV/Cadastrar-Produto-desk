/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerenciarprodutos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * 
 */
public class Produtos {
    
    private int id;
    private String nome;
    private String descricao;
    private double preco;
    
    
   public int getId(){
       return id;
   }
   
   public void setId(int id){
       this.id = id;
   }
   
   public String getDescricao(){
       return descricao;
   }
  
   public void setDescricao(String descricao){
       this.descricao = descricao;
   }
   
   public String getNome(){
       return nome;
   }
   
   public void setNome(String nome){
       this.nome = nome;
   }
   
   public double getPreco(){
       return preco;
   }
   
   public void setPreco(double preco){
       this.preco = preco;
   }
   
   
   public Connection getConexao() throws ClassNotFoundException, SQLException{
  
       String DRIVER = "com.mysql.cj.jdbc.Driver";
       /* 
       Obiviamente DRIVER é o nome(mesma coisa do URL).
       com.mysql.cj.jdbc.Driver é a classe do driver oficial do MySql connector/j .
       Necessária para carregar o driver que estabelece a ponte entre Java  o MySql.
       */
       
       String URL = "jdbc:mysql://localhost:3306/gerenciador_produtos";
       /*
       URL (NOME DE ESCOLHA, Mas bom saber manter o que é, né.) Define o endereço do banco de dados
       jdbc:mysql:// indica que está usando JDBC com MySql.
       localhost significa que o banco está sendo acessado na máquina local.
       Posso mudar o host(localhost) alterando para o endereço de IP ou nome do domínio onde o banco de dados está hospedado.
       3306 é a porta padrão do MySql.
       gerenciador_produtos é o nome do banco de dados que eu quero acessar.
       Seria algo tipo jdbc:mysql://Host:port(porta)/database(banco de dados).
       */
       
       String USER = "root";
       /*
       USER é o nome de usuário do banco de dados(nessee caso,root, que é o usuário padrao do MySql com prmissões administrativas).
       */ 
      
       String PASSWORD = "";
       /*
       PASSWORD é a senha do usuário. Aqui está vazia(""), o que signifca que o usuário "root" não tem senha configurada.
       (Em produção, isso seria uma falha de segurança... sempre proteja o usuário(TU escolhe o nome do usuário) com uma snha forte.)
       */
       
       Class.forName(DRIVER); 
       // O método forName carrega e inicia o driver passado por parâmetro
       
       return DriverManager.getConnection(URL, USER, PASSWORD);
       // Estabele a conexão
   }
   
   public void cadastrar() throws ClassNotFoundException, SQLException {
       /*
       ClassNotFoundException: caso a classe do driver JDBC não seja encontrada.
       SQLException: se acontecer algum erro na comunicação com o banco de dados.
       */
       
       Connection con = getConexao();
       PreparedStatement comando = con.prepareStatement("insert into produto (nome,descricao,preco) values(?,?,?)");
       /*
       Cria um PreparedStatement 
       PreparedStatement é uma interface do JDBC usada para excutar comandos SQL coom parâmentos de form segura e eficiente.
       os ? reresenta parâmentros que serão substituídos posteriormente.
       */ 
       
       comando.setString(1,nome);
       comando.setString(2,descricao);
       comando.setDouble(3, preco);
       /*
       Define os parâmentros com o valor da variável 
       ex: o ? na posição 1 vai receber o valor da variável nome
       o ? na segunda posição vai receber o valor da variávl descriicao
       e o terceiro ? vai receber o valor da variável preco.
       */
       
       comando.execute();
       // Ele executa o comando SQL... nesse caso, ele insere o produto no banco de dados.
       
       con.close();
       // Fecha a conexão com o banco de dados para liberar recursos.
   }

    public boolean deletarPorID() throws SQLException, ClassNotFoundException {
        Connection con = getConexao();
        PreparedStatement comando = con.prepareStatement("DELETE FROM produto WHERE id = ?");
        comando.setInt(1,id);
        int linhasAfetadas = comando.executeUpdate();
        con.close();
        return linhasAfetadas > 0;
    }
   
   
   /*
   public void deletarPorId() throws ClassNotFoundException, SQLException {
       Connection con = getConexao();
       PreparedStatement comando = con.prepareStatement("delete from produto where id = ?");
       comando.setInt(1, id);
       comando.execute();
       con.close();
   } */
   
   public void atualizarPorId() throws ClassNotFoundException, SQLException {
       Connection con = getConexao();
       PreparedStatement comando = con.prepareStatement("update produto set nome = ?, descricao = ?, preco = ? where id = ?");
       comando.setString(1, nome);
       comando.setString(2,descricao);
       comando.setDouble(3, preco);
       comando.setInt(4, id);
       comando.execute();
       con.close();
   }
   
   public Produtos consultarPorId() throws ClassNotFoundException, SQLException{
       Connection con = getConexao();
       String SQL = "select * from produto where id = ?";
       PreparedStatement comando = con.prepareStatement(SQL);
       comando.setInt(1,id);
       ResultSet resultado = comando.executeQuery();
       Produtos prod = new Produtos();
       if(resultado.next()){
           prod.setId(resultado.getInt("id"));
           prod.setNome(resultado.getString("nome"));
           prod.setDescricao(resultado.getString("descricao"));
           prod.setPreco(resultado.getDouble("preco"));
       }
       con.close();
       return prod;
   } 
}
