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
                egunak = { "astelehena", "asteartea", "asteazkena", "osteguna", "ostirala", "larunbata", "igandea" },
                orduakaste={"15:00","17:00","19:00","21:00","23:00"},
                orduakbuk={"12:00","14:00","16:00","18:00","20:00","22:00"};
        int[] astelehena = new int[5], asteartea = new int[5], asteazkena = new int[5], osteguna = new int[5],
                ostirala = new int[5], larunbata = new int[5], igandea = new int[5], generoak={0,0,0,0,1,2,3,2,0,0,4,2,2,4,2};
        //Kartelera matrizea sortu det eta posizio bakoitzan asteko egun bakoitzaren array-a, hau da egun horretan egongo diren pelikulak gordetzen dira
        int[][] kartelera = new int[7][5];
        char aldat='B';
        kartelera[0]=astelehena; kartelera[1]=asteartea; kartelera[2]=asteazkena; kartelera[3]=osteguna;kartelera[4]=ostirala;kartelera[5]=larunbata;kartelera[6]=igandea;
        int auk = 0, def = 0, aukeguna=0, aukaldat=0;
        // asteko egun bakoitzari 5 pelikula random esleitzen dizkio, i zenbakia izango
        // da pelikulak[i] dagoen pelikula
        for (int i = 0; i < astelehena.length; i++) {
            astelehena[i] = (int) (Math.random() * 15);
            asteartea[i] = (int) (Math.random() * 15);
            asteazkena[i] = (int) (Math.random() * 15);
            osteguna[i] = (int) (Math.random() * 15);
            ostirala[i] = (int) (Math.random() * 15);
            larunbata[i] = (int) (Math.random() * 15);
            igandea[i] = (int) (Math.random() * 15);
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
                        //Asteko egunen zerrenda imprimatuko du.
                            "---------ASTEKO EGUNAK---------\n 1.Astelehena\n 2.Asteartea\n 3.Asteazkena\n 4.Osteguna\n 5.Ostirala\n 6.Larunbata\n 7.Igandea\n---------------------------");
                            aukeguna=0;
                            while(aukeguna<=0||aukeguna>7){
                                aukeguna=sc.nextInt();
                                if(aukeguna<=0||aukeguna>7){
                                 System.out.println("Sartutako aukera ez dago ondo, faborez sartu baliozkoa den aukera bat.");
                                }
                            }
                            //Aukeratutako egunean dauden pelikulak inprimatuko ditu.
                            System.out.println(egunak[aukeguna-1]+" egunean proiektatuko diren pelikulak:");
                            //Astean zenhar den kontrolatzen du zeren astean zehar ezin dira pelikulak proiektatu 15:00 baino lehen
                            if(aukeguna<6){
                                for(int i=0;i<astelehena.length;i++){
                                    System.out.println((i+1)+". "+pelikulak[kartelera[aukeguna-1][i]]+ " pelikula-------------- "+gelak[generoak[i]]+" gelan proiektatuko da--------------"+(15+2*i)+":00 etan.");
                                }
                            }  
                            //Asteburua den kontrolatu
                            else{
                                for(int i=0;i<astelehena.length;i++){
                                    System.out.println((i+1)+". "+pelikulak[kartelera[aukeguna-1][i]]+ " pelikula--------------"+gelak[generoak[i]]+" gelan proiektatuko da--------------"+(12 +2*i)+":00 etan.");
                                }
                            } 
                            //Eguneko kartelera aldatu daiteke, beraz aldatzeko aukera eman, baino soilik kontraseña ondo jartzen badezu
                            System.out.println(egunak[aukeguna-1]+ " eguneko kartelera aldatu nahi badezu zineman egin behar dezu lan, sartu kontraseka(1-9 zenaki bat");
                            if(sc.nextInt()==8){
                                aldat='B';
                                //Kartelera aldatzeko aukera eman soilik aldat=B bada
                                while(aldat!='E'){
                                    aukaldat=0;
                                    System.out.println("Zein pelikula aldatu nahi duzu?");
                                    while(aukaldat<=0||aukaldat>astelehena.length){
                                        aukaldat=sc.nextInt();
                                        if(aukaldat<=0||aukaldat>astelehena.length){
                                            System.out.println("Aukera ez da egokia, faborez sartu egokia den aukera bat.");
                                        }
                                    }
                                    System.out.println(pelikulak[kartelera[aukeguna-1][aukaldat-1]]+" pelikula aldatu nahi duzu, zer pelikulagatik aldatu nahi duzu? hauek dira pelikula guztiak:");
                                     System.out.println("------------PELIKULAK------------");
                                    for(int i=0;i<pelikulak.length;i++){
                                       System.out.println((i+1)+". "+pelikulak[i]);
                                    }
                                    kartelera[aukeguna-1][aukaldat-1] = sc.nextInt()-1;
                                    System.out.println("Beste pelikularik aldatu nahi duzu? (B/E)");
                                    aldat=sc.next().charAt(0);
                                }
                            }   
                            else{
                                System.out.println("Ez duzu hemen lana egiten beraz ezin duzu kartelera aldatu.");
                            }
                    break;
                case 2:

                    break;
                case 3:
                            System.out.println("Zubieta zinema helbidea: Etarte bidea 9, 20170 Zubieta-Usurbil (Gipuzkoa)");
                    break;
                case 4:
                            System.out.println(" ASTEAN ZEHAR: 15:00 - 00:00\n ASTEBURUAK 12:00 - 00:00");
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