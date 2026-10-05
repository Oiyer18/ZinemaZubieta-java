import java.util.Scanner;

public class Zinemazubieta {
    public void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // aldagaiak definitu
        // pelikulak[] gure pelikula guztiak gordeko ditu eta pelikula bakooitzeri
        // zenbaki bat emango dio.
        // gelak[] dazkagun gela guztiak gorde eta zenbaki bat esleituko die
        // asteko egun bakoitzarentzat array bat sortu han eguneko pelikulak gordeko
        // ditugulako
        String[] pelikulak = { "Lilo y Stitch", "Una película de Minecraft", "Mufasa: El rey león",
                "Cómo entrenar a tu dragón", "Capitán América: Brave New World", "Cónclave", "Sonic 3: La película",
                "Misión: Imposible. Sentencia Final", "Blancanieves", "Thunderbolt", "Padre no hay más que uno 5",
                "Wolfgang (Extraordinario)", "El casoplón", "Un funeral de locos", "Sirāt" },
                gelak = { "Umeen gela", "Superheroien gela", "thriller gela", "Zientzia fikzio gela", "komedia gela" },
                egunak = { "astelehena", "asteartea", "asteazkena", "osteguna", "ostirala", "larunbata", "igandea" };
        int[] astelehena = new int[4], asteartea = new int[4], asteazkena = new int[4], osteguna = new int[4],
                ostirala = new int[4], larunbata = new int[4], igandea = new int[4];
        //Kartelera matrizea sortu det eta posizio bakoitzan asteko egun bakoitzaren array-a, hau da egun horretan egongo diren pelikulak gordetzen dira
        int[][] kartelera = new int[6][4];
        kartelera[0]=astelehena; kartelera[1]=asteartea; kartelera[2]=asteazkena; kartelera[3]=osteguna;kartelera[4]=ostirala;kartelera[5]=larunbata;kartelera[6]=igandea;
        int auk = 0, def = 0;
        // asteko egun bakoitzari 5 pelikula random esleitzen dizkio, i zenbakia izango
        // da pelikulak[i] dagoen pelikula
        for (int i = 0; i < astelehena.length; i++) {
            astelehena[i] = (int) (Math.random() * 16);
            asteartea[i] = (int) (Math.random() * 16);
            asteazkena[i] = (int) (Math.random() * 16);
            osteguna[i] = (int) (Math.random() * 16);
            ostirala[i] = (int) (Math.random() * 16);
            larunbata[i] = (int) (Math.random() * 16);
            igandea[i] = (int) (Math.random() * 16);
        }
        System.out.println("Ongi etorri ZinemaZubietara!!");
        // def aldagaia kontrolatuko du menua berriro erakustea funtzio bat egin ondoren
        // def(definitivo)
        while (def == 0) {
            // while honek kontrolatuko du sartutako aukera baliozkoa izatea, 0<auk<6
            while ((auk <= 0 || auk > 5) && def == 0) {
                // Menu nagusia imprimitu
                System.out.println(
                        "-----------MENU NAGUSIA-----------\n 1.Asteko eguna aukeratu\n 2.Zinemaren informazio orokorra\n 3.Kokapena\n 4.Irekiera ordutegia\n 5.Irten\n-----------------------------------");
                auk = sc.nextInt();
                if (auk < 0 || auk > 5) {
                    System.out.println("Sartutako aukera ez da existitzen, faborez baliozko bat aukeratu");
                }
            }
            switch (auk) {
                case 1:
                    System.out.println(
                            "---------ASTEKO EGUNAK---------\n 1.Astelehena\n 2.Asteartea\n 3.Asteazkena\n 4.Osteguna\n 5.Ostirala\n 6.Larunbata\n 7.Igandea\n---------------------------");

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    System.out.println("Eskerrikasko erabiltzeagatik");
                    def = 1;
                    break;
            }
            auk = 0;
        }
        sc.close();
    }
}