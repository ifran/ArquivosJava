import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Viagem extends Arquivo
{
    public void listarViagens(int iId)
    {
        ArrayList<String> aViagem = new ArrayList();
        aViagem = Selecionar("Viagem.txt");
        
        int iNumeroViagem = aViagem.size();
        int iIdDonoViagem = 1;
        
        for (int i = 0; i < iNumeroViagem; i++) 
        {
            if (i == iIdDonoViagem)
            {
                int iPkUser = Integer.parseInt(aViagem.get(i));
                if (iPkUser == iId)
                {
                    String iViagemId = aViagem.get(i-1);
                    String sViagemNome = aViagem.get(i+1);
                    String sViagemDataIni = aViagem.get(i+2);
                    String sViagemDataFim = aViagem.get(i+3);
                    String sViagemPontos = aViagem.get(i+4);
                    String sViagemPreço = aViagem.get(i+5);
                    
                    System.out.println(iViagemId + ": " + sViagemNome + " - " + sViagemDataIni + " - " + sViagemDataFim + " - " + sViagemPontos + " - " +sViagemPreço);
                }
                
                iIdDonoViagem += 7;
            }
        }
        
        String sOk;
        System.out.print("OK: ");
        Scanner oOk = new Scanner(System.in);
        sOk = oOk.nextLine();
        
        Menu.menuPrincipal(iId);
    }
    
    public void criarViagem(int iId)
    {
        Menu.cabecalho("Criar Viagem");
        
        String sDestino;
        System.out.print("Destino: ");
        Scanner oDestino = new Scanner(System.in);
        sDestino = oDestino.nextLine();
        
        String sDataInicial;
        System.out.print("Data Inicial: ");
        Scanner oDataInicial = new Scanner(System.in);
        sDataInicial = oDataInicial.nextLine();
        
        String sDataFinal;
        System.out.print("Data Final: ");
        Scanner oDataFinal = new Scanner(System.in);
        sDataFinal = oDataFinal.nextLine();
        
        String sPontos;
        System.out.print("Pontos Turísticos: ");
        Scanner oPontos = new Scanner(System.in);
        sPontos = oPontos.nextLine();
        
        String sPreco;
        System.out.print("Preço: ");
        Scanner oPreco = new Scanner(System.in);
        sPreco = oPreco.nextLine();
        
        ArrayList<String> aViagem = new ArrayList();
        aViagem.add(String.valueOf(iId));
        aViagem.add(sDestino);
        aViagem.add(sDataInicial);
        aViagem.add(sDataFinal);
        aViagem.add(sPontos);
        aViagem.add(sPreco);
        
        Cadastrar("Viagem.txt", 2, aViagem);
        Menu oMenu = new Menu();
        oMenu.menuPrincipal(iId);
    }
}