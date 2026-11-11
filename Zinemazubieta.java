
import java.util.ArrayList;
import java.util.Scanner;

public class Zinemazubieta {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> pelikulakList = new ArrayList<>();
        ArrayList<String> generoakList = new ArrayList<>();
        // Pelikula bakoitzaren genero-kodea gordetzen du, pelikulen zerrendarekin batera.
        ArrayList<Integer> generoKodeak = new ArrayList<>();
        ArrayList<String> aretoakList = new ArrayList<>();
        ArrayList<String> egunakList = new ArrayList<>();
        ArrayList<String> erabiltzaileak = new ArrayList<>();
        ArrayList<String> pasahitzak = new ArrayList<>();

        erabiltzaileak.add("Oier");
        erabiltzaileak.add("Jon");
        erabiltzaileak.add("Kay");

        pasahitzak.add("1881");
        pasahitzak.add("0308");
        pasahitzak.add("3367");

        // aldagaiak definitu
        // pelikulak[] gure pelikula guztiak gordeko ditu eta pelikula bakooitzeri
        // zenbaki bat emango dio.
        // gelak[] dazkagun gela guztiak gorde eta zenbaki bat esleituko die
        String[] pelikulak = {"Lilo y Stitch", "Una película de Minecraft", "Mufasa: El rey león",
            "Cómo entrenar a tu dragón", "Capitán América: Brave New World", "Cónclave", "Sonic 3: La película",
            "Misión: Imposible. Sentencia Final", "Blancanieves", "Thunderbolt", "Padre no hay más que uno 5",
            "Wolfgang (Extraordinario)", "El casoplón", "Un funeral de locos", "Sirāt"},
                gelak = {"Umeen gela", "Superheroien gela", "thriller gela", "Zientzia fikzio gela", "komedia gela"},
                egunak = {"Astelehena", "Asteartea", "Asteazkena", "Osteguna", "Ostirala", "Larunbata", "Igandea"};
        // asteko egun bakoitzarentzat array bat sortu han eguneko pelikulak gordeko
        // ditugulako
        int[] astelehena = new int[5], asteartea = new int[5], asteazkena = new int[5], osteguna = new int[5],
                ostirala = new int[5], larunbata = new int[5], igandea = new int[5],
                generoak = {0, 0, 0, 0, 1, 2, 3, 2, 0, 1, 4, 2, 2, 4, 2};

        for (int i = 0; i < pelikulak.length; i++) {
            pelikulakList.add(pelikulak[i]);
            // Generoaren kodea zerrenda dinamikora gehitzen da pelikula bakoitzarentzat.
            generoKodeak.add(generoak[i]);

            switch (generoak[i]) {
                case 0 ->
                    generoakList.add(" haurrentzako");
                case 1 ->
                    generoakList.add(" superheroiak");
                case 2 ->
                    generoakList.add(" thriller");
                case 3 ->
                    generoakList.add(" zientzia fikzioa");
                case 4 ->
                    generoakList.add(" komedia");
            }
        }
        for (int p = 0; p < gelak.length; p++) {
            aretoakList.add(gelak[p]);
        }

        // Kartelera matrizea sortu det eta posizio bakoitzan asteko egun bakoitzaren
        // array-a, hau da egun horretan egongo diren pelikulak gordetzen dira
        int[][] kartelera = new int[7][5], sarrerak = new int[7][5];
        char aldat = 'B', aukeraeros = 'B';
        kartelera[0] = astelehena;
        kartelera[1] = asteartea;
        kartelera[2] = asteazkena;
        kartelera[3] = osteguna;
        kartelera[4] = ostirala;
        kartelera[5] = larunbata;
        kartelera[6] = igandea;
        int auk = 0, def = 0, aukeguna = 0, aukaldat = 0, sarrerakont = 0, sarrerakop = 0,
                aukeros = 0, aldataukpelik = 0, saiokop = astelehena.length;

        
        System.out.println("Ongi etorri ZinemaZubietara!!");
        // def aldagaia kontrolatuko du menua berriro erakustea funtzio bat egin ondoren
        // def(definitivo)
        while (def == 0) {
            // Menu nagusia imprimitu
            System.out.println(
                    "-----------MENU NAGUSIA-----------\n 1.Asteko eguna aukeratu\n 2.Zinemaren informazio orokorra\n 3.Kokapena\n 4.Irekiera ordutegia\n 5.Administrazioa\n 6.Irten\n----------------------------------\n Zer egin nahi duzu? sartu zenbakia.");
            // sartutako aukera baliozkoa den edo ez kontrolatu
            auk = 0;
            auk = Konprobatu(auk, 5, sc);
            switch (auk) {
                case 1:
                    // Asteko egunen zerrenda imprimatuko du.
                    System.out.println(
                            "---------ASTEKO EGUNAK---------\n 1.Astelehena\n 2.Asteartea\n 3.Asteazkena\n 4.Osteguna\n 5.Ostirala\n 6.Larunbata\n 7.Igandea\n---------------------------\n Erabakitzeko sartu zenbakia.");
                    aukeguna = 0;
                    aukeguna = Konprobatu(aukeguna, 6, sc);
                    // Aukeratutako egunean dauden pelikulak inprimatuko ditu.
                    Kartelera(aukeguna, saiokop, egunak, generoakList, pelikulakList, gelak, generoKodeak, kartelera);
                    // Eguneko kartelera aldatu daiteke, beraz aldatzeko aukera eman, baino soilik
                    // kontraseña ondo jartzen badezu
                    System.out.println(" " + egunak[aukeguna - 1]
                            + " eguneko kartelera aldatu nahi badezu zineman egin behar dezu lan, kartelera aldatu nahi dezu? (B/E)");
                    if (sc.next().charAt(0) == 'B') {
                        System.out
                                .println("Jakiteko hemen lana egiten duzun edo ez kontraseina sartu (1-9 zenbaki bat)");
                        if (sc.nextInt() == 8) {
                            // Kartelera aldatzeko aukera eman soilik aldat!=E (Ez) bada
                            aldat = 'B';
                            while (aldat != 'E') {
                                // aukaldat aldagaian gordeko da aldatu nahi dezun pelikularen zenbakia
                                // aukaldat reiniziatu pelikula bat baino gehiago aldatu ditzazkezulako
                                aukaldat = 0;
                                System.out.println("Zein pelikula aldatu nahi duzu?");
                                // Baliozko aukera bat sartu den edo ez kontrolatu
                                aukaldat = Konprobatu(aukaldat, astelehena.length, sc);
                                System.out.println(pelikulakList.get(kartelera[aukeguna - 1][aukaldat - 1])// [aukaldat-1]
                                        // zergatik? 0-4
                                        // delako!!
                                        + " pelikula aldatu nahi duzu, zer pelikulagatik aldatu nahi duzu? hauek dira pelikula guztiak:");
                                // zineman dauden pelikula guztiak imprimatu jakiteko zein pelikulagatik aldatu.
                                System.out.println("------------PELIKULAK------------");
                                for (int i = 0; i < pelikulak.length; i++) {
                                    System.out.println((i + 1) + ". " + pelikulakList.get(i));
                                }
                                // Behin erabakita zein pelikulagatik aldatu nahi dezun aldatu.
                                aldataukpelik = sc.nextInt();
                                // konprobatu aukera egokia dela
                                Konprobatu(aldataukpelik, 15, sc);
                                kartelera[aukeguna - 1][aukaldat - 1] = aldataukpelik - 1;
                                // Kartelera aldatzen jarraitzeko aukera eman
                                System.out.println("Beste pelikularik aldatu nahi duzu? (B/E)");
                                // Aldatzen jarraitzeko (E) ez den edozein gauza jarri, B (Bai) aukera eman
                                aldat = sc.next().charAt(0);
                            }
                        } // Ez daki kontraseña beraz ez du hemen lana egiten
                        else {
                            System.out.println("Ez duzu hemen lan egiten beraz ezin duzu kartelera aldatu");
                        }
                    }

                    // Sarrerak erosteko aukera hemen
                    System.out.println("SARRERAK EROSI NAHI DITUZU? GEHIENEZ 4 AHAL DITUZU EROSI (B/E)");
                    // aukeraerosen gorde ea sarrerak erosi nahi dituen ala ez
                    aukeraeros = sc.next().charAt(0);
                    while (aukeraeros == 'B' && sarrerakont < 4) {
                        System.out.println("Zein pelikularentzat erosi nahi dituzu sarrerak?");
                        // Egun horretan proiektatuko diren pelikula guztiak imprimatuko dira genereo
                        // eta orduekin
                        Kartelera(aukeguna, saiokop, egunak, generoakList, pelikulakList, gelak, generoKodeak, kartelera);
                        aukeros = 0;
                        /*
                         * aukeros reiniziatu, bestela ez digu beste pelikula batentzat sarrerak erosten
                         * aukera egokia den edo ez jakiteko
                         */
                        Konprobatu(aukeros, astelehena.length, sc);
                        // zenbat sarrera erosi nahi diren galdetu
                        System.out.println("Zenbat sarrera erosi nahi dituzu?");
                        sarrerakop = sc.nextInt();
                        /*
                         * sarrerakop aldagaian gorde zenbat erosi nahi diren eta kartelera matrizearen
                         * dimentsio berdineko
                         * sarrerak matrizean lehen aukeratutako pelikularen "kasillan" sarrerakop gorde
                         * Erosi daitezken sarrera kopurua edo gehiago erosi badituzu
                         * pasa zean pelikularen sarrera kopurua murriztuko da 4 izan dadin erositako
                         * sarrera kopuru totala
                         * Sarrera gehiago erosi ditzazkezu beraz aukera ematen dizu.
                         */
                        if (sarrerakont + sarrerakop >= 4) {
                            if (sarrerakont + sarrerakop == 4) {
                                System.out.println("4 sarrera erosi dituzu guztira");
                                if (sarrerak[aukeguna - 1][aukeros] != 0) {
                                    sarrerak[aukeguna - 1][aukeros] = sarrerak[aukeguna - 1][aukeros] + sarrerakop;
                                } else {
                                    sarrerak[aukeguna - 1][aukeros] = sarrerakop;
                                }
                                sarrerakont = sarrerakont + sarrerakop;

                            } else if (sarrerakont + sarrerakop > 4) {
                                System.out.println(
                                        "Erositako sarrera kopurua 4 baino gehiago da, beraz azkeneko pelikularen sarrerak murriztu zaizkizu.");
                                // 2 aldiz segidan erosten badituzu sarrerak egun berdinarentzat pelikula
                                // berdinarentzat
                                // detektatuko du eta lehen zeudenak berrietara gehituko ditu
                                if (sarrerak[aukeguna - 1][aukeros] != 0) {
                                    sarrerak[aukeguna - 1][aukeros] = sarrerak[aukeguna - 1][aukeros] + sarrerakop;
                                    if (sarrerak[aukeguna - 1][aukeros] + sarrerakop >= 4) {
                                        sarrerak[aukeguna - 1][aukeros] = 4;
                                    }
                                } // ez dira lehenagotikan sarrerak erosi
                                else {
                                    sarrerak[aukeguna - 1][aukeros] = 4 - sarrerakont;
                                }
                                sarrerakont = 4;
                            }
                            aukeraeros = 'E';
                        }
                        // 4 sarrera baino gutxiago erosi dituzu
                        if (sarrerakont + sarrerakop < 4) {
                            // 2 aldiz segidan erosten badituzu sarrerak egun berdinarentzat pelikula
                            // berdinarentzat
                            // detektatuko du eta lehen zeudenak berrietara gehituko ditu
                            if (sarrerak[aukeguna - 1][aukeros] != 0) {
                                sarrerak[aukeguna - 1][aukeros] = sarrerak[aukeguna - 1][aukeros] + sarrerakop;
                            } // lehen ez zeuden sarrerak erosita
                            else {
                                sarrerak[aukeguna - 1][aukeros] = sarrerakop;
                            }
                            // gehiago erosi nahi duzun edo ez galdetu
                            sarrerakont = sarrerakont + sarrerakop;
                            System.out.println(
                                    "Beste pelikula batentzat sarrerak erosi nahi dituzu? (B/E) gogoratu 4 direla maximoa eta zuk "
                                    + sarrerakont + " dituzula jada");
                            aukeraeros = sc.next().charAt(0);
                            if (aukeraeros == 'E') {
                                System.out.println("Eskerrikasko ZinemaZubietan erosteagatik");
                            }
                        }

                    }

                    break;
                case 2:
                    // Pelikulen informazioa erakutsi, asteko gela eta pelikula kopurua
                    System.out.println("-----------PELIKULEN INFORMAZIOA-----------\n Pelikula kopurua: "
                            + pelikulakList.size() + "\n Gelen Kopurua: " + gelak.length + "\n");
                    for (int g = 0; g < gelak.length; g++) {
                        System.out.println("-----------" + gelak[g].toUpperCase() + "-----------");
                        for (int i = 0; i < pelikulakList.size(); i++) {
                            if (generoKodeak.get(i) == g) {
                                System.out.println(pelikulakList.get(i));
                            }
                        }

                    }
                    System.out.println("\n");
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

                    System.out.println("Sartu erabiltzailea");
                    String erabiltzailea = sc.next();
                    if (erabiltzaileak.contains(erabiltzailea) == true) {
                        System.out.println("erabiltzailea ondo jarri duzu");
                        System.out.println("Sartu pasahitza");
                        String pasahitza = sc.next();
                        
                        if (pasahitzak.contains(pasahitza) & (erabiltzaileak.indexOf(erabiltzailea)) == (pasahitzak.indexOf(pasahitza)) == true) {
                            System.out.println("Pasahitza ondo jarri duzu");

                        
                        

                            int auk5 = 0;
                            while (auk5 == 0) {
                            System.out.println("");
                            System.out.println("-----------ADMINISTRAZIO ATALA-----------");
                            System.out.println("1. Pelikula berria gehitu");
                            System.out.println("2. Pelikula baten informazioa aldatu");
                            System.out.println("3. Pelikula bat zerrendatik ezabatu");
                            System.out.println("4. Pelikulen zerrenda erakutsi");
                            System.out.println("5. Irten");
                            System.out.println("-----------------------------------------");
                            System.out.println("");
                            System.out.println("Aukeratu zenbaki bat (1-5)");
                            int auk2 = sc.nextInt();

                            switch (auk2) {
                                case 1:
                                    System.out.println("sartu pelikula berriaren izena: ");
                                    sc.nextLine();
                                    String peliberri = sc.nextLine();
                                    pelikulakList.add(peliberri);
                                    System.out.println("Sartu pelikularen generoa (haurrentzako, superheroiak, thriller, zientzia fikzioa edo komedia):");
                                    String generoBerri = sc.nextLine().trim();
                                    int generoKodeBerri = GeneroKodea(generoBerri);
                                    while (generoKodeBerri < 0) {
                                        System.out.println("Genero hori ez da baliozkoa. Sartu: haurrentzako, superheroiak, thriller, zientzia fikzioa edo komedia.");
                                        generoBerri = sc.nextLine().trim();
                                        generoKodeBerri = GeneroKodea(generoBerri);
                                    }
                                    generoakList.add(generoBerri);
                                    // Genero-kodea ere gordetzen da, pelikula berriak array finkoaren muga gaindi ez dezan.
                                    generoKodeak.add(generoKodeBerri);

                                    // Kartelera berrantolatu eta saio bakoitzean gela desberdina esleitzen du.
                                    for (int egun = 0; egun < kartelera.length; egun++) {
                                        ArrayList<Integer> aretoakErabilita = new ArrayList<>();
                                        for (int saio = 0; saio < saiokop; saio++) {
                                            int pelikula;
                                            int aretoa;
                                            do {
                                                // Zerrendako edozein pelikula hautatzen du, azkena barne.
                                                pelikula = (int) (Math.random() * pelikulakList.size());
                                                aretoa = generoKodeak.get(pelikula);
                                            } while (aretoakErabilita.contains(aretoa));

                                            kartelera[egun][saio] = pelikula;
                                            aretoakErabilita.add(aretoa);
                                        }
                                    }
                                    break;
                                case 2:
                                    for (int i = 0; i < pelikulakList.size(); i++) {
                                        System.out.print((i + 1) + ". " + pelikulakList.get(i));
                                        System.out.println("" + " (" + generoakList.get(i) + " )");
                                    }
                                    System.out.println("zein pelikularen informazioa aldatu nahi dezu (1-"
                                            + pelikulakList.size() + ")?");
                                    System.out.println("");
                                    auk2 = sc.nextInt();
                                    System.out.println("");
                                    System.out.println("zein datu aldatu nahi duzu?");
                                    System.out.println("1. Pelikularen izena   2.pelikularen generoa");
                                    int auk3 = sc.nextInt();
                                    if (auk3 == 1) {
                                        System.out.println("sartu pelikularen izen berria:");
                                        sc.nextLine();
                                        String izenberri = sc.nextLine();

                                        pelikulakList.set(auk2 - 1, izenberri);
                                    } else if (auk3 == 2) {
                                        System.out.println("sartu pelikularen genero berria: ");
                                        sc.nextLine();
                                        String generoberri = sc.nextLine().trim();
                                        int generoKodeAldatu = GeneroKodea(generoberri);
                                        while (generoKodeAldatu < 0) {
                                            System.out.println("Genero hori ez da baliozkoa. Sartu: haurrentzako, superheroiak, thriller, zientzia fikzioa edo komedia.");
                                            generoberri = sc.nextLine().trim();
                                            generoKodeAldatu = GeneroKodea(generoberri);
                                        }
                                        generoakList.set(auk2 - 1, generoberri);
                                        // Bi genero-zerrendak eguneratzen dira gelaren esleipena ere aldatzeko.
                                        generoKodeak.set(auk2 - 1, generoKodeAldatu);
                                    } else {
                                        System.out.println("indize hori ez da esistitzen");
                                    }
                                    break;
                                case 3:
                                    for (int i = 0; i < pelikulakList.size(); i++) {
                                        System.out.print((i + 1) + ". " + pelikulakList.get(i));
                                        System.out.println("" + " (" + generoakList.get(i) + " )");
                                    }
                                    System.out.println("zein pelikula ezabatu nahi dezu (1-" + pelikulakList.size() + ")?");
                                    int auk4 = sc.nextInt();

                                    if (auk4 <= 0 || auk4 > pelikulakList.size()) {
                                        System.out.println("indize hori ez da esistitzen");
                                    } else {
                                        pelikulakList.remove(auk4 - 1);
                                        generoakList.remove(auk4 - 1);
                                        // Indizeak lerrokatuta mantentzeko, genero-kodea ere ezabatzen da.
                                        generoKodeak.remove(auk4 - 1);
                                    }

                                    break;
                                case 4:
                                    for (int i = 0; i < pelikulakList.size(); i++) {
                                        System.out.print((i + 1) + ". " + pelikulakList.get(i));
                                        System.out.println("" + " (" + generoakList.get(i) + " )");
                                    }
                                    break;
                                case 5:
                                    auk5 = -1;
                                    break;

                            }
                        }


                    } else {
                        System.out.println("pasahitza gaizki jarri duzu melon");
                    }
                    } else {
                        System.out.println("Erabiltzailea gaizki jarri duzu");
                    }

                    break;
                case 6:
                    // Programa amaitzeko aukera.
                    // Erosi dituzun sarreren tiketa
                    if (sarrerakont != 0) {
                        System.out.println("-------------ZURE TIKETA-------------\n");
                        for (int i = 0; i < 7; i++) {
                            for (int j = 0; j < 5; j++) {
                                if (sarrerak[i][j] != 0) {
                                    System.out.println("Eguna: " + egunak[i] + ", Pelikula: "
                                            + pelikulakList.get(kartelera[i][j]) + ", Sarrera kopurua: " + sarrerak[i][j]);
                                }
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

    static void Kartelera(int aukeguna, int saiokop, String[] egunak, ArrayList<String> generoakList, ArrayList<String> pelikulakList,
            String[] gelak, ArrayList<Integer> generoKodeak, int[][] kartelera) {
        // Aukeratutako egunean dauden pelikulak inprimatuko ditu.
        System.out.println(" " + egunak[aukeguna - 1] + " egunean proiektatuko diren pelikulak:");
        /*
         * Astean zenhar den kontrolatzen du zeren astean zehar ezin dira pelikulak
         * proiektatu 15:00 baino lehen
         */
        for (int i = 0; i < saiokop; i++) {
            System.out.print("    " + (i + 1) + ". " + pelikulakList.get(kartelera[aukeguna - 1][i]) + " ");
            for (int l = 0; l < 35 - pelikulakList.get(kartelera[aukeguna - 1][i]).length(); l++) {
                System.out.print("-");
                if (l == 35 - pelikulakList.get(kartelera[aukeguna - 1][i]).length()) {
                    System.out.print(" ");
                }
            }
            System.out.print(gelak[generoKodeak.get(kartelera[aukeguna - 1][i])]);
            for (int l = 0; l < 25 - gelak[generoKodeak.get(kartelera[aukeguna - 1][i])].length(); l++) {
                System.out.print("-");
                if (l == 25 - gelak[generoKodeak.get(kartelera[aukeguna - 1][i])].length() - 1) {
                    System.out.print(" ");
                }
            }
            // kontrolatu ea astebukaera den edo ez
            if (aukeguna < 6) {
                System.out.print((15 + 2 * i) + ":00 etan. \n");
            } else {
                System.out.print((12 + 2 * i) + ":00 etan. \n");
            }

        }
    }

    // Testuz sartutako generoa gelaren indize bihurtzen du.
    static int GeneroKodea(String genero) {
        return switch (genero.trim().toLowerCase()) {
            case "haurrentzako" -> 0;
            case "superheroiak" -> 1;
            case "thriller" -> 2;
            case "zientzia fikzioa" -> 3;
            case "komedia" -> 4;
            default -> -1;
        };
    }

    static int Konprobatu(int aukera, int luzeera, Scanner sc) {
        while (aukera <= 0 || aukera > luzeera) {
            aukera = sc.nextInt();
            // konprobatu eguna baliozkoa dela
            if (aukera <= 0 || aukera > luzeera) {
                System.out.println("Sartutako aukera ez dago ondo, faborez sartu baliozkoa den aukera bat.");
            }
        }

        return aukera;
    }
}