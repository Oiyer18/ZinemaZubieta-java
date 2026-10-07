import java.util.Scanner;

public class Zinemazubieta {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // aldagaiak definitu
        // pelikulak[] gure pelikula guztiak gordeko ditu eta pelikula bakooitzeri zenbaki bat emango dio.
        // gelak[] dazkagun gela guztiak gorde eta zenbaki bat esleituko die
        String[] pelikulak = { "Lilo y Stitch", "Una película de Minecraft", "Mufasa: El rey león",
                "Cómo entrenar a tu dragón", "Capitán América: Brave New World", "Cónclave", "Sonic 3: La película",
                "Misión: Imposible. Sentencia Final", "Blancanieves", "Thunderbolt", "Padre no hay más que uno 5",
                "Wolfgang (Extraordinario)", "El casoplón", "Un funeral de locos", "Sirāt" },
                gelak = { "Umeen gela", "Superheroien gela", "thriller gela", "Zientzia fikzio gela", "komedia gela" },
                egunak = { "Astelehena", "Asteartea", "Asteazkena", "Osteguna", "Ostirala", "Larunbata", "Igandea" };
         // asteko egun bakoitzarentzat array bat sortu han eguneko pelikulak gordeko ditugulako
        int[] astelehena = new int[5], asteartea = new int[5], asteazkena = new int[5], osteguna = new int[5],
                ostirala = new int[5], larunbata = new int[5], igandea = new int[5],
                generoak = { 0, 0, 0, 0, 1, 2, 3, 2, 0, 0, 4, 2, 2, 4, 2 }, sarrerak = new int[5],
                erositakosarr = new int[5];
        // Kartelera matrizea sortu det eta posizio bakoitzan asteko egun bakoitzaren
        //  array-a, hau da egun horretan egongo diren pelikulak gordetzen dira
        int[][] kartelera = new int[7][5];
        char aldat = 'B', aukeraeros = 'B';
        kartelera[0] = astelehena;
        kartelera[1] = asteartea;
        kartelera[2] = asteazkena;
        kartelera[3] = osteguna;
        kartelera[4] = ostirala;
        kartelera[5] = larunbata;
        kartelera[6] = igandea;
        int auk = 0, def = 0, aukeguna = 0, aukaldat = 0, sarrerakont = 0, sarrerakop = 0, erositakosar = 0,
         aukeros = 0, sarreraken = 0;
        // asteko egun bakoitzari 5 pelikula random esleitzen dizkio
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
        
            while ((auk <= 0 || auk > 5)) {
                // Menu nagusia imprimitu
                System.out.println(
                        "-----------MENU NAGUSIA-----------\n 1.Asteko eguna aukeratu\n 2.Zinemaren informazio orokorra\n 3.Kokapena\n 4.Irekiera ordutegia\n 5.Irten\n-----------------------------------");
                auk = sc.nextInt();
                //sartutako aukera baliozkoa den edo ez kontrolatu
                if (auk < 0 || auk > 5) {
                    System.out.println("Sartutako aukera ez da existitzen, faborez baliozko bat aukeratu");
                }
            }
            switch (auk) {
                case 1:
                    // Asteko egunen zerrenda imprimatuko du.
                    System.out.println(
                            "---------ASTEKO EGUNAK---------\n 1.Astelehena\n 2.Asteartea\n 3.Asteazkena\n 4.Osteguna\n 5.Ostirala\n 6.Larunbata\n 7.Igandea\n---------------------------");
                    aukeguna = 0;
                    while (aukeguna <= 0 || aukeguna > 7) {
                        aukeguna = sc.nextInt();
                        // konprobatu eguna baliozkoa dela
                        if (aukeguna <= 0 || aukeguna > 7) {
                            System.out
                                    .println("Sartutako aukera ez dago ondo, faborez sartu baliozkoa den aukera bat.");
                        }
                    }
                    // Aukeratutako egunean dauden pelikulak inprimatuko ditu.
                    System.out.println(" "+egunak[aukeguna - 1] + " egunean proiektatuko diren pelikulak:");
                    // Astean zenhar den kontrolatzen du zeren astean zehar ezin dira pelikulak
                    // proiektatu 15:00 baino lehen
                    if (aukeguna < 6) {
                        for (int i = 0; i < astelehena.length; i++) {
                            System.out.println((i + 1) + ". " + pelikulak[kartelera[aukeguna - 1][i]]
                                    + " pelikula-------------- " + gelak[generoak[kartelera[aukeguna - 1][i]]]
                                    + " gelan proiektatuko da--------------" + (15 + 2 * i) + ":00 etan.");
                        }
                    }
                    // Asteburua den kontrolatu
                    else {
                        for (int i = 0; i < astelehena.length; i++) {
                            System.out.println((i + 1) + ". " + pelikulak[kartelera[aukeguna - 1][i]]
                                    + " pelikula--------------" + gelak[generoak[kartelera[aukeguna - 1][i]]]
                                    + " gelan proiektatuko da--------------" + (12 + 2 * i) + ":00 etan.");
                        }
                    }
                    // Eguneko kartelera aldatu daiteke, beraz aldatzeko aukera eman, baino soilik
                    // kontraseña ondo jartzen badezu
                    System.out.println(" "+egunak[aukeguna - 1]
                            + " eguneko kartelera aldatu nahi badezu zineman egin behar dezu lan, sartu kontraseka(1-9 zenaki bat)");
                    if (sc.nextInt() == 8) {
                        aldat = 'B';
                        // Kartelera aldatzeko aukera eman soilik aldat!=E (Ez) bada
                        while (aldat != 'E') {
                            //aukaldat aldagaian gordeko da aldatu nahi dezun pelikularen zenbakia
                            //aukaldat reiniziatu pelikula bat baino gehiago aldatu ditzazkezulako
                            aukaldat = 0;
                            System.out.println("Zein pelikula aldatu nahi duzu?");
                            // Baliozko aukera bat sartu den edo ez kontrolatu
                            while (aukaldat <= 0 || aukaldat > astelehena.length) {
                                aukaldat = sc.nextInt();
                                if (aukaldat <= 0 || aukaldat > astelehena.length) {
                                    System.out.println("Aukera ez da egokia, faborez sartu egokia den aukera bat.");
                                }
                            }
                            System.out.println(pelikulak[kartelera[aukeguna - 1][aukaldat - 1]]//[aukaldat-1] zergatik? 0-4 delako!!
                                    + " pelikula aldatu nahi duzu, zer pelikulagatik aldatu nahi duzu? hauek dira pelikula guztiak:");
                                    //zineman dauden pelikula guztiak imprimatu jakiteko zein pelikulagatik aldatu.
                            System.out.println("------------PELIKULAK------------");
                            for (int i = 0; i < pelikulak.length; i++) {
                                System.out.println((i + 1) + ". " + pelikulak[i]);
                            }
                            //Behin erabakita zein pelikulagatik aldatu nahi dezun aldatu.
                            kartelera[aukeguna - 1][aukaldat - 1] = sc.nextInt() - 1;
                            // Kartelera aldatzen jarraitzeko aukera eman
                            System.out.println("Beste pelikularik aldatu nahi duzu? (B/E)");
                            //Aldatzen jarraitzeko (E) ez den edozein gauza jarri, B (Bai) aukera eman
                            aldat = sc.next().charAt(0);
                        }
                    }
                    // Ez daki kontraseña beraz ez du hemen lana egiten
                    else {
                        System.out.println("Ez duzu hemen lana egiten beraz ezin duzu kartelera aldatu.");
                    }
                    // Sarrerak erosteko aukera hemen
                    System.out.println("SARRERAK EROSI NAHI DITUZU? GEHIENEZ 4 AHAL DITUZU EROSI (B/E)");
                    //aukeraerosen gorde ea sarrerak erosi nahi dituen ala ez
                    aukeraeros = sc.next().charAt(0);
                    if (aukeraeros == 'B' && sarrerakont < 5) {

                        while (erositakosar < erositakosarr.length && aukeraeros == 'B') {
                            // erositakosarr-->array bat nun gordeko diren zein pelikulen sarrerak erosiko diren
                            // erositakosar--> Posizioa
                            System.out.println("Zein pelikularentzat erosi nahi dituzu sarrerak?");
                            //Egun horretan proiektatuko diren pelikula guztiak imprimatuko dira genereo eta orduekin
                            // Astean zehar den kontrolatzen du zeren astean zehar ezin dira pelikulak
                            // proiektatu 15:00 baino lehen
                            if (aukeguna < 6) {
                                for (int i = 0; i < astelehena.length; i++) {
                                    System.out.println((i + 1) + ". " + pelikulak[kartelera[aukeguna - 1][i]]
                                            + " pelikula-------------- " + gelak[generoak[kartelera[aukeguna - 1][i]]]
                                            + " gelan proiektatuko da--------------" + (15 + 2 * i) + ":00 etan.");
                                }
                            }
                            // Asteburua den kontrolatu
                            else {
                                for (int i = 0; i < astelehena.length; i++) {
                                    System.out.println((i + 1) + ". " + pelikulak[kartelera[aukeguna - 1][i]]
                                            + " pelikula--------------" + gelak[generoak[kartelera[aukeguna - 1][i]]]
                                            + " gelan proiektatuko da--------------" + (12 + 2 * i) + ":00 etan.");
                                }
                            }
                            aukeros=0;
                            //aukeros reiniziatu, bestela ez digu beste pelikula batentzat sarrerak erosten
                            //aukera egokia den edo ez jakiteko
                            while (aukeros <= 0 || aukeros > astelehena.length) {
                                aukeros = sc.nextInt();
                                if (aukeros <= 0 || aukeros > astelehena.length) {
                                    System.out.println("Aukera ez da egokia, faborez sartu egokia den aukera bat.");
                                }
                            }
                            erositakosarr[erositakosar] = kartelera[aukeguna - 1][aukeros - 1];
                            System.out.println("Zenbat sarrera erosi nahi dituzu?");
                            // Sarrerakop-->erositakosarr[erositakosar] pelikularentzat erosiko diren
                            // sarrera kopurua
                            // sarreral--> array-an gordeko da Sarrerakop
                            sarrerakop = sc.nextInt();
                            sarrerak[erositakosar] = sarrerakop;
                            // sarrerakont-->erosi diren sarrera kopuru totala
                            sarrerakont = sarrerakont + sarrerakop;
                            // Erosi daitezken sarrera guztiak erosi dituzu
                            if (sarrerakont >= 4) {
                                if (sarrerakont == 4) {
                                    System.out.println(
                                            "4 sarrera erosi dituzu jada, beraz sartutako azkenekoak ez dira kontuan eduki");
                                }
                                else {
                                    System.out.println(
                                            "4 sarrera edo gehiago erosi dituzu, beraz erositako azkenak murriztu zaizkizu.");
                                }
                                for (int i = 0; i < sarrerak.length; i++) {
                                    if (i != erositakosar) {
                                        //hemen sarreraken hartuko du azkeneko pelikularentzat erosi diren sarrera kopurua 
                                        sarreraken = sarreraken + sarrerak[i];
                                    }
                                }
                                //Erosi daitezken sarrera kopurua edo gehiago erosi badituzu 
                                // pasa zean pelikularen sarrera kopurua murriztuko da 4 izan dadin erositako sarrera kopuru totala
                                sarrerak[erositakosar] = 4 - sarreraken;
                                sarrerakont = 4;
                                aukeraeros = 'E';
                            }
                            erositakosar++;
                            // Sarrera gehiago erosi ditzazkezu beraz aukera ematen dizu.
                            if (sarrerakont < 4) {
                                System.out.println(
                                        "Beste pelikula batentzat sarrerak erosi nahi dituzu? (B/E) gogoratu 4 direla maximoa eta zuk "
                                                + sarrerakont + " dituzula jada");
                                aukeraeros = sc.next().charAt(0);
                                if (aukeraeros == 'E') {
                                    System.out.println("Eskerrikasko ZinemaZubietan erosteagatik");
                                }
                            }
                        }
                    }
                    break;
                case 2:
                    // Pelikulen informazioa erakutsi, aasteko gela eta pelikula kopurua
                    System.out.println("-----------PELIKULEN INFORMAZIOA-----------\n Pelikula kopurua: "
                            + pelikulak.length + "\n Gelen Kopurua: " + gelak.length + "\n");
                    for (int g = 0; g < gelak.length; g++) {
                        System.out.println("-----------" + gelak[g].toUpperCase() + "-----------");
                        for (int i = 0; i < pelikulak.length; i++) {
                            if (generoak[i] == g) {
                                System.out.println(pelikulak[i]);
                            }
                        }
                    }
                    break;
                case 3:
                    // Helbidea imprimatzeko funtzioa.
                    System.out.println("Zubieta zinema helbidea: Etarte bidea 9, 20170 Zubieta-Usurbil (Gipuzkoa)");
                    break;
                case 4:
                    // Ordutegia imprimatzeko funtzioa.
                    System.out.println(" ASTEAN ZEHAR: 15:00 - 00:00\n ASTEBURUAK 12:00 - 00:00");
                    break;
                case 5:
                    // Programa amaitzeko aukera.
                    // Erosi dituzun sarreren tiketa
                    if (sarrerakont != 0) {
                        System.out.println("-------------ZURE TIKETA-------------\n");
                        System.out.println("Eguna:" + egunak[aukeguna - 1]);
                        for (int i = 0; i < erositakosarr.length; i++) {
                            if (sarrerak[i] > 0) {
                                System.out.println((i + 1) + ". " + pelikulak[erositakosarr[i]]
                                        + "---------------- sarrera kop: " + sarrerak[i]);
                            }
                        }
                        System.out.println("--------------------------------------------------");
                    }
                    System.out.println("Eskerrikasko erabiltzeagatik");
                    // Programa exekutatu soilik def=0 bada
                    def = 1;
                    break;
            }
            // auk aldagaia inizializatu bazpaere
            auk = 0;
        }
        sc.close();
    }
}