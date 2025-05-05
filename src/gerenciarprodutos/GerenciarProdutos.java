/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gerenciarprodutos;
import java.util.Scanner;
import java.util.List;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * 
 */
public class GerenciarProdutos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner scanner = new Scanner(System.in);
        Produtos p = new Produtos();
        
     
       // System.out.print("Digite o nome do produto: ");
       // p.setNome(scanner.nextLine());
        
        /*
        aqui é coisa simples, jogo rápido. 
        Scanner.nextLine() para ver o que o usuário digitou
        aí a gente vai guardar o que foi digitado dentro do set
        nextLine é para string rapá
        outros metodos você vai ter que procurar ex: double é nextDouble()
       */
        
       // System.out.print("Digite a descricao do produto: ");
       // p.setDescricao(scanner.nextLine());
      
       // System.out.print("Digite o preco do produto: ");
       // p.setPreco(scanner.nextDouble());
        /* 
        Pode causar erro se a entrada for invalida (ponto/virgula) se o Java estiver em PT-BR ele só vai aceitar virgula.
        Para alterar o idioma para ingles faça isso
        No NetBeans, você pode ir em:

        Run > Set Project Configuration > Customize

        Em Run ou VM Options, adicione:
        -Duser.language=en -Duser.country=US
        */
        
      
       // try{
         //   p.cadastrar();
           // System.out.println("Cadastrado com sucesso.");
        // jogo rapído também, vai tentar cadastrar o produto    
         
       // }catch(SQLException |ClassNotFoundException ex){
         //   System.out.println("Error: "+ex.getMessage());
        // se der erro(como problema de conexão ou driver), o catch captura e exibe a mensagem de erro 
        // é literalmente você traduzir as palavras para português, bota fé ? 
      
        System.out.print("Digite o ID do item que gostaria de deltar: ");
         p.setId(scanner.nextInt());
       
        try{ 
            if (p.deletarPorID()){
                System.out.println("Deletado");
            } else {
                System.out.println("Nenhum id para deletar");
            }
        }catch(NumberFormatException e){
            System.out.println("Por favor, digite apenas numeros no campo de id");
        } catch (SQLException | ClassNotFoundException ex ){
            System.out.println("ERROR: " +ex.getMessage());
        }

        
        
        
        /*
        System.out.print("Digite o id do item que deseja deletar: ");
        p.setId(scanner.nextInt());
        
        try{
            p.deletarPorId();
            System.out.println("Deletado com sucesso.");
        } catch (SQLException | ClassNotFoundException  ex){
            System.out.println("Error: "+ex.getMessage());
        */
        
        /*
        System.out.print("Digite o ID do item que deseja alterar: ");
        p.setId(scanner.nextInt());
        scanner.nextLine();
        
        System.out.print("Digite o novo nome do item: ");
        p.setNome(scanner.nextLine());
        
        System.out.print("Digite a nova descricao do item: ");
        p.setDescricao(scanner.nextLine());
        
        System.out.print("Digite o novo preco do item: ");
        p.setPreco(scanner.nextDouble());
        
        try{
            p.atualizarPorId();
            System.out.println("Item atualizado");
        } catch ( SQLException | ClassNotFoundException ex){
            System.out.println("Error: " +ex.getMessage());
        }
        */
        
        /*
        
        System.out.print("Digite o ID do item que deseja verificar: ");
        p.setId(scanner.nextInt());
        
        try{
            p = p.consultarPorId();
            if(p.getDescricao() != null){
                System.out.println("ID...." +p.getId());
                System.out.println("Nome..." +p.getNome());
                System.out.println("Descricao..." +p.getDescricao());
                System.out.println("Preco..."+p.getPreco());
            }
            }catch(SQLException | ClassNotFoundException ex){
                System.out.println("Error: "+ex.getMessage());
            }
        
        */
    }      
}
