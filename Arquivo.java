import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.lang.NoSuchMethodException;
import java.util.ArrayList;

public abstract class Arquivo 
{
    /*
     * Se iArquivoOpcao = 1,entao usar arquivo de usuario
     * Se iArquivoOpcao = 2,entao usar arquivo de viagem
     * Se iArquivoOpcao = 3,entao usar arquivo de pontos turisticos
     */    

    public void Cadastrar(String sArquivo, int iArquivoOpcao, ArrayList<String> aObj)
    {
        File arquivo = new File("Arquivos/" + sArquivo);
        
        try
        { 
            if (!arquivo.exists()) 
            {
                // Cria um arquivo vazio
                arquivo.createNewFile();
            }
            
            // Caso seja um diretório, é possível listar seus arquivos e diretórios
            File[] arquivos = arquivo.listFiles();
            
            // Escreve no arquivo
            FileWriter fw = new FileWriter(arquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            
            /*****************
            * Cadastrando INI
            *****************/
            SequenceAdd(sArquivo);
            bw.write(Sequence(sArquivo) + "\n");
            
            int j = aObj.size();
            for (int i = 0; i < j; i++)
            {
                bw.write(aObj.get(i) + "\n");
            }
            /*****************
            * Cadastrando INI
            *****************/
            
            bw.close();
            fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void Atualizar(String sArquivo, ArrayList<String> oObj)
    {
        File arquivo = new File("Arquivos/" + sArquivo);
        String linha = Sequence(sArquivo);
        
        try
        { 
            if (!arquivo.exists()) 
            {
                // Cria um arquivo vazio
                arquivo.createNewFile();
            }
            
            // Caso seja um diretório, é possível listar seus arquivos e diretórios
            File[] arquivos = arquivo.listFiles();
            
            // Escreve no arquivo
            FileWriter fw = new FileWriter(arquivo, false);
            BufferedWriter bw = new BufferedWriter(fw);
            
            fw.write("");
            fw.flush();
            
            for (int i = 0; i < oObj.size(); i++)
            {
                bw.write(oObj.get(i) + "\n");
            }
            
            bw.close();
            fw.close();
        } 
        catch (IOException ex) 
        {
            ex.printStackTrace();
        }
    }
    
    public ArrayList<String> Selecionar(String sArquivo)
    {
        File arquivo = new File("Arquivos/" + sArquivo);
        ArrayList<String> aObj = new ArrayList();
        
        try
        { 
            if (!arquivo.exists()) 
            {
                // Cria um arquivo vazio
                arquivo.createNewFile();
            }
            
            // Caso seja um diretório, é possível listar seus arquivos e diretórios
            File[] arquivos = arquivo.listFiles();
            
            //faz a leitura do arquivo
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);
            
            //enquanto houver mais linhas
            while (br.ready()) {
                // Lê a proxima linha
                String linha = br.readLine();
                aObj.add(linha);
            }
            
            br.close();
            fr.close();
        } 
        catch (IOException ex) 
        {
            ex.printStackTrace();
        }
        
        return aObj;
    }
    
    public String Sequence(String sArquivo)
    {
        File arquivo = new File("Arquivos/Sequence" + sArquivo);
        String linha = null;
        
        try
        { 
            if (!arquivo.exists()) 
            {
                // Cria um arquivo vazio
                arquivo.createNewFile();
            }
            
            // Caso seja um diretório, é possível listar seus arquivos e diretórios
            File[] arquivos = arquivo.listFiles();
            
            //faz a leitura do arquivo
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);
            
            //enquanto houver mais linhas
            while (br.ready()) {
                //lê a proxima linha
                linha = br.readLine();
            }
            
            br.close();
            fr.close();
        } 
        catch (IOException ex) 
        {
            ex.printStackTrace();
        }
        
        return linha;
    }
    
    public void SequenceAdd(String sArquivo)
    {
        File arquivo = new File("Arquivos/Sequence" + sArquivo);
        String linha = Sequence(sArquivo);
        
        try
        { 
            if (!arquivo.exists()) 
            {
                // Cria um arquivo vazio
                arquivo.createNewFile();
            }
            
            // Caso seja um diretório, é possível listar seus arquivos e diretórios
            File[] arquivos = arquivo.listFiles();
            
            // Escreve no arquivo
            FileWriter fw = new FileWriter(arquivo, false);
            BufferedWriter bw = new BufferedWriter(fw);
            
            fw.write("");
            fw.flush();
            
            // Adicionando um novo registro
            int iLinha = Integer.parseInt(linha);  
            iLinha = iLinha + 1;
            linha = String.valueOf(iLinha);
                
            bw.write(linha);
            
            bw.close();
            fw.close();
        } 
        catch (IOException ex) 
        {
            ex.printStackTrace();
        }
    }
}