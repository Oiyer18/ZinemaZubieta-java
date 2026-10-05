import java.util.Scanner;

public class Zinemazubieta {
    public void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //aldagaiak definitu
        // pelikulak[] gure pelikula guztiak gordeko ditu eta pelikula bakooitzeri zenbaki bat emango dio.
        // gelak[] dazkagun gela guztiak gorde eta zenbaki bat esleituko die
        //asteko egun bakoitzarentzat array bat sortu han eguneko pelikulak gordeko ditugulako
        String[] pelikulak = { "Lilo y Stitch", "Una película de Minecraft", "Mufasa: El rey león",
                "Cómo entrenar a tu dragón", "Capitán América: Brave New World", "Cónclave", "Sonic 3: La película",
                "Misión: Imposible. Sentencia Final", "Blancanieves", "Thunderbolt", "Padre no hay más que uno 5",
                "Wolfgang (Extraordinario)", "El casoplón", "Un funeral de locos", "Sirāt" },
                gelak = { "Umeen gela", "Superheroien gela", "thriller gela", "Zientzia fikzio gela", "komedia gela" };
        int[] astelehena = new int[4], asteartea = new int[4], asteazkena = new int[4], osteguna = new int[4],
                ostirala = new int[4], larunbata = new int[4], igandea = new int[4];
        // asteko egun bakoitzari 5 pelikula random esleitzen dizkio, i zenbakia izango
        // da pelikulak[i] dagoen pelikula
        for (int i = 0; i < pelikulak.length; i++) {
            astelehena[i] = (int) (Math.random() * 16);
            asteartea[i] = (int) (Math.random() * 16);
            asteazkena[i] = (int) (Math.random() * 16);
            osteguna[i] = (int) (Math.random() * 16);
            ostirala[i] = (int) (Math.random() * 16);
            larunbata[i] = (int) (Math.random() * 16);
            igandea[i] = (int) (Math.random() * 16);
        }
        
        sc.close();
    }
}