import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

public class figurinhaWhatsapp {

    public void cria () throws Exception
    {
        // leitura da imagem
        //InputStream inputStream = new FileInputStream("image/TopMovies_1.jpg");
        InputStream inputStream = new URL("https://images.savoysystems.co.uk/PCH/19529944.jpg").openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // cria nova imagem em memoria c transparencia e tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem =  new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        //copiar a imagem original pra nova imagem
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);


        // configurar a font
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 84);
        graphics.setColor(Color.yellow);
        graphics.setFont(fonte);

        //escrever uma frase
        graphics.drawString("Fallen Angels (1995)",100, novaAltura - 100);


        //escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File("saida/figurinha.png"));

    }

    public static void main(String[] args) throws Exception{
        var gerador = new figurinhaWhatsapp();
        gerador.cria();
    }

}
