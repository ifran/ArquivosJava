import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Usuario extends Arquivo
{
    /*********************************
    * Criando atributos e get set INI 
    *********************************/
    private int iUsuarioId;
    
    public int getUsuarioId() {
        return this.iUsuarioId;
    }
    
    public void setUsuarioId(int iUsuarioId) {
        this.iUsuarioId = iUsuarioId;
    }
    /*********************************
    * Criando atributos e get set FIM
    *********************************/
    
    public void loginAction()
    {
        try {
            /***********************************
            * Criando a s opcoes de DIGITAR INI
            ***********************************/
            String sEmail;
            String sSenha;
            
            System.out.print("Email: ");
            Scanner oEmail = new Scanner(System.in);
            sEmail = oEmail.nextLine();
            
            System.out.print("Senha: ");
            Scanner oSenha = new Scanner(System.in);
            sSenha = oSenha.nextLine();
            /***********************************
            * Criando a s opcoes de DIGITAR FIM
            ***********************************/
            
            /*********************************
            * Buscando dados nos arquivos INI 
            *********************************/
            ArrayList<String> aUsuario = new ArrayList();
            aUsuario = Selecionar("Usuario.txt");
            
            int iLinha = Integer.parseInt(Sequence("Usuario.txt"));
            iLinha = iLinha * 5;
            int iId = 0;
            int bLogar = 0;
            int iEmail = 2;
            int iSenha = 3;
            String sEmailArquivo = "";
            String sSenhaArquivo = "";
            String sLoger = "";
            String sLogerDigitado = sEmail + sSenha;
            
            for (int i = 1; i <= iLinha; i++) {
                if (i <= aUsuario.size()) {
                    if (i == iEmail) {
                        sEmailArquivo = aUsuario.get(i);
                        iEmail += 5;
                    } else if (i == iSenha) {
                        sSenhaArquivo = aUsuario.get(i);
                        iSenha += 5;
                        sLoger = sEmailArquivo + sSenhaArquivo;
                    }
                    
                    if (sLogerDigitado.equals(sLoger))
                    {
                        if (iId == 0)
                        {
                            System.out.println("==" + sLogerDigitado);
                            System.out.println(i + "==" + sLoger);
                            System.out.println(aUsuario.get(i-3));
                            iId = Integer.parseInt(aUsuario.get(i-3));
                        }
                        
                        bLogar = 1;
                    }
                }
            }
            
            if (bLogar == 1) {
                Menu oMenu = new Menu();
                oMenu.menuPrincipal(iId);
            } else {
                System.out.print("Usu·rio n„o encontrado");
            }
            /*********************************
            * Buscando dados nos arquivos FIM
            *********************************/
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    public void atualizarDados(int iId)
    {
        ArrayList<String> aUsuario = new ArrayList();
        aUsuario = Selecionar("Usuario.txt");
        
        int iNumeroUsuario = aUsuario.size();
        int iIdUsuario = 0; // Numero da linha onde esta a PK 
        int bRemove = 0;
        String sId = "";
        
        for (int i = 0; i < iNumeroUsuario; i++) 
        {
            if (i == iIdUsuario)
            {
                if (bRemove == 0)
                {
                    sId = aUsuario.get(i);
                    int iPkUser = Integer.parseInt(aUsuario.get(i));
                    if (iPkUser == iId)
                    {
                        String sUsuarioNome = aUsuario.get(i+1);
                        String sUsuarioEmail = aUsuario.get(i+2);
                        String sUsuarioSenha = aUsuario.get(i+3);
                        String sUsuarioTelefone = aUsuario.get(i+4);
                        
                        bRemove = 1;
                        aUsuario.remove(i);
                        aUsuario.remove(i);
                        aUsuario.remove(i);
                        aUsuario.remove(i);
                        aUsuario.remove(i);
                        
                        System.out.println("Nome: " + sUsuarioNome);
                        System.out.println("E-mail: " + sUsuarioEmail);
                        System.out.println("Senha: " + sUsuarioSenha);
                        System.out.println("Telefone: " + sUsuarioTelefone);
                    }
                }
                iIdUsuario += 5;
            }
        }
        
        String sNome;
        System.out.print("Novo Nome: ");
        Scanner oNome = new Scanner(System.in);
        sNome = oNome.nextLine();
        
        String sEmail;
        System.out.print("Novo E-mail: ");
        Scanner oEmail = new Scanner(System.in);
        sEmail = oEmail.nextLine();
        
        String sSenha;
        System.out.print("Novo Senha: ");
        Scanner oSenha = new Scanner(System.in);
        sSenha = oSenha.nextLine();
        
        String sTelefone;
        System.out.print("Novo Telefone: ");
        Scanner oTelefone = new Scanner(System.in);
        sTelefone = oTelefone.nextLine();
        
        ArrayList<String> aUsuarioNovo = new ArrayList();
        
        for (int i = 0; i < aUsuario.size(); i++) 
        {
            aUsuarioNovo.add(aUsuario.get(i));
        }
        
        aUsuarioNovo.add(sId);
        aUsuarioNovo.add(sNome);
        aUsuarioNovo.add(sEmail);
        aUsuarioNovo.add(sSenha);
        aUsuarioNovo.add(sTelefone);
        
        Atualizar("Usuario.txt", aUsuarioNovo);
        Menu.menuPrincipal(iId);
    }
    
    public void criarUsuario()
    {
        Menu.cabecalho("Criar Usu·rio");
        
        String sNome;
        System.out.print("Nome: ");
        Scanner oNome = new Scanner(System.in);
        sNome = oNome.nextLine();
        
        String sEmail;
        System.out.print("Email: ");
        Scanner oEmail = new Scanner(System.in);
        sEmail = oEmail.nextLine();
        
        String sSenha;
        System.out.print("Senha: ");
        Scanner oSenha = new Scanner(System.in);
        sSenha = oSenha.nextLine();
        
        String sTelefone;
        System.out.print("Telefone: ");
        Scanner oTelefone = new Scanner(System.in);
        sTelefone = oTelefone.nextLine();        
        
        ArrayList<String> aUsuario = new ArrayList();
        aUsuario.add(sNome);
        aUsuario.add(sEmail);
        aUsuario.add(sSenha);
        aUsuario.add(sTelefone);
        
        Cadastrar("Usuario.txt", 1, aUsuario);
        Menu oMenu = new Menu();
        oMenu.menuInicial();
        
    }
    
    public void usuarioMenu()
    {
        try {
            String sOption;
            
            do {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Limpando a linha 
                System.out.println("=============================");
                System.out.println("=========== Menu ============");
                System.out.println("=============================");
                System.out.println("\n");
                System.out.println("A) Menu Viajantes");
                System.out.println("B) Menu Agenda");
                System.out.println("\n");
                System.out.println("Escolha sua op√ß√£o: ");
                Scanner in = new Scanner(System.in);
                sOption = in.nextLine();
                
                if (sOption == "A") 
                {
                    System.out.println("boa");
                }
            } while (!sOption.equals("A")); //
        } catch (Exception e) {
            System.out.println("Erro");
        }        
    }
}