
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Zinemazubieta {
    public static void main(String[] args) {
        // Erabiltzailearen teklatuko sarrerak irakurtzeko.
        Scanner sc = new Scanner(System.in);

        // Filmen eta haien generoen informazioa gordetzeko zerrendak.
        ArrayList<String> pelikulakList = new ArrayList<>();
        ArrayList<String> generoakList = new ArrayList<>();
        // Film bakoitzaren genero-kodea gordetzen du; indizea filmarenarekin bat dator.
        ArrayList<Integer> generoKodeak = new ArrayList<>();

        // Aretoen izenak eta administraziorako erabiltzaile-izenak eta pasahitzak.
        ArrayList<String> aretoakList = new ArrayList<>();
        ArrayList<String> erabiltzaileak = new ArrayList<>();
        ArrayList<String> pasahitzak = new ArrayList<>();

        // Administraziorako erabiltzaile-izenak eta dagozkien pasahitzak indize berean daude.
        erabiltzaileak.add("Oier");
        erabiltzaileak.add("Jon");
        erabiltzaileak.add("Kay");

        pasahitzak.add("1881");
        pasahitzak.add("0308");
        pasahitzak.add("3367");

        // Hasierako filmak, aretoak eta asteko egunak gordetzeko arrayak.
        String[] pelikulak = { "Lilo y Stitch", "Una película de Minecraft", "Mufasa: El rey león",
                "Cómo entrenar a tu dragón", "Capitán América: Brave New World", "Cónclave", "Sonic 3: La película",
                "Misión: Imposible. Sentencia Final", "Blancanieves", "Thunderbolt", "Padre no hay más que uno 5",
                "Wolfgang (Extraordinario)", "El casoplón", "Un funeral de locos", "Sirāt" },
                gelak = { "Umeen gela", "Superheroien gela", "thriller gela", "Zientzia fikzio gela", "komedia gela" },
                egunak = { "Astelehena", "Asteartea", "Asteazkena", "Osteguna", "Ostirala", "Larunbata", "Igandea" };

        // Egun bakoitzeko saioak eta hasierako film bakoitzaren genero-kodea.
        int[] astelehena = new int[5], asteartea = new int[5], asteazkena = new int[5], osteguna = new int[5],
                ostirala = new int[5], larunbata = new int[5], igandea = new int[5],
                generoak = { 0, 0, 0, 0, 1, 2, 3, 2, 0, 1, 4, 2, 2, 4, 2 };

        // Egun eta saio bakoitzean saldu diren sarreren kopurua gordetzen du.
        int[][] sarrerakopMAX = new int[7][5];

        // Aforoaren egoera probatzeko, asteleheneko lehen bi saioak ia beteta uzten dira.
        sarrerakopMAX[0][0] = 25;
        sarrerakopMAX[0][1] = 23;

        // Hasierako filmak zerrenda dinamikoetan sartu eta bakoitzaren generoa zehazten du.
        for (int i = 0; i < pelikulak.length; i++) {
            pelikulakList.add(pelikulak[i]);
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

        // Aretoen array-a zerrenda dinamikoan kopiatzen du.
        for (int p = 0; p < gelak.length; p++) {
            aretoakList.add(gelak[p]);
        }

        // Kartelera matrizeak egun eta saio bakoitzean proiektatuko den filmaren indizea gordetzen du.
        int[][] kartelera = new int[7][5], sarrerak = new int[7][5];

        // Egun bakoitzeko saioen array-ak kartelerarekin lotzen ditu.
        char aukeraeros = 'B';
        kartelera[0] = astelehena;
        kartelera[1] = asteartea;
        kartelera[2] = asteazkena;
        kartelera[3] = osteguna;
        kartelera[4] = ostirala;
        kartelera[5] = larunbata;
        kartelera[6] = igandea;

        // Menuaren aukerak, hautatutako eguna, erosketen kopurua eta saio-kopurua.
        int auk = 0, def = 0, aukeguna = 0, sarrerakont = 0, sarrerakop = 0,
                aukeros = 0, saiokop = astelehena.length;

        // Egun bakoitzeko kartelera ausaz betetzen du, saio berean generoak ez errepikatzeko.
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

        System.out.println("Ongi etorri ZinemaZubietara!!");
        // Menu nagusia berriz erakusten du erabiltzaileak irteteko aukera hautatu arte.
        while (def == 0) {
            // Menu nagusiko aukerak erakutsi.
            System.out.println(
                    "-----------MENU NAGUSIA-----------\n 1.Asteko eguna aukeratu\n 2.Zinemaren informazio orokorra\n 3.Kokapena\n 4.Irekiera ordutegia\n 5.Administrazioa\n 6.Irten\n----------------------------------\n Zer egin nahi duzu? sartu zenbakia.");
            // Sarrerak 1etik 6ra bitarteko zenbaki bat izan behar du.
            auk = 0;

            try {
                auk = Konprobatu(auk, 6, sc);
            } catch (InputMismatchException e) {
                System.err.println("ERROREA: zenbakia ez da");
            }
            switch (auk) {
                case 1:

                    // Egun bat hautatu, kartelera erakutsi eta sarrerak erosteko aukera ematen du.
                    do {
                        if (sarrerakop <= 4){
                            break;
                        }
                        // Asteko egunak erakutsi eta hautatutako eguna balioztatu.
                        System.out.println(
                                "---------ASTEKO EGUNAK---------\n 1.Astelehena\n 2.Asteartea\n 3.Asteazkena\n 4.Osteguna\n 5.Ostirala\n 6.Larunbata\n 7.Igandea\n---------------------------\n Erabakitzeko sartu zenbakia.");
                        aukeguna = 0;
                        aukeguna = Konprobatu(aukeguna, egunak.length, sc);
                        // Hautatutako eguneko filmak eta saioak erakutsi.
                        Kartelera(aukeguna, saiokop, egunak, generoakList, pelikulakList, gelak, generoKodeak,
                                kartelera);
                        // Erabiltzaileari sarrerak erosi nahi dituen galdetu.
                        System.out.println("SARRERAK EROSI NAHI DITUZU? GEHIENEZ 4 AHAL DITUZU EROSI (B/E)");
                        // Erantzuna aukeraeros aldagaian gordetzen du.
                        aukeraeros = aukIrakBE(sc);

                        while (aukeraeros == 'B' && sarrerakont < 4) {
                            // Erosketa egin aurretik eguneko kartelera berriro erakutsi.
                            System.out.println("Zein pelikularentzat erosi nahi dituzu sarrerak?");
                            // Egun horretako filmak, aretoak eta ordutegiak berriro erakusten ditu.
                            Kartelera(aukeguna, saiokop, egunak, generoakList, pelikulakList, gelak, generoKodeak,
                                    kartelera);
                            aukeros = 0;
                            // Filmaren saio-zenbakia irakurri eta zeroan hasten den indizera bihurtu.
                            aukeros = Konprobatu(aukeros, astelehena.length, sc) - 1;
                            if (sarrerakopMAX[aukeguna - 1][aukeros] == 25) {
                                // Saioa beteta badago, ezin da sarrerarik erosi.
                                System.out.println("");
                                System.out.println("aforoa beteta dago, aukeratu beste pelikula bat");
                                System.out.println("");
                            } else {
                                // Erosketa bakoitzean 1 eta 4 sarrera artean onartzen dira.
                                System.out.println("Zenbat sarrera erosi nahi dituzu?");
                                while (true) {
                                    if (!sc.hasNextInt()) {
                                        System.out.println("ERROREA: sartu zenbaki bat.");
                                        sc.next();
                                        continue;
                                    }

                                    sarrerakop = sc.nextInt();
                                    if (sarrerakop >= 1 && sarrerakop <= 4) {
                                        break;
                                    }

                                    System.out.println("Sartu 1 eta 4 arteko zenbaki bat.");
                                }
                                // Saioaren aforoa gaindituko litzatekeen egiaztatu.
                                if ((sarrerakopMAX[aukeguna - 1][aukeros] + sarrerakop) > 25) {
                                    System.out.print(
                                            "Erositako sarrera kopurua aforo maximoa gainditzen du, aurrera segi nahi duzu kontuan hartuta ");
                                    int aux = sarrerakopMAX[aukeguna - 1][aukeros] + sarrerakop;
                                    int exc = aux - 25;
                                    int sarrerakMAX = sarrerakop - exc;

                                    System.out.println(
                                            "gehienez " + sarrerakMAX + " sarrera erosi ahalko dituzula? (B/E)");
                                    aukeraeros = aukIrakBE(sc);

                                    if (aukeraeros == 'B') {
                                        // Erabiltzaileak aforoan geratzen diren sarrerak bakarrik erosten ditu.
                                        sarrerakop = sarrerakMAX;
                                        if (sarrerakont + sarrerakop >= 4) {
                                            if (sarrerakont + sarrerakop == 4) {
                                                System.out.println("4 sarrera erosi dituzu guztira");
                                                if (sarrerak[aukeguna - 1][aukeros] != 0) {
                                                    sarrerak[aukeguna - 1][aukeros] = sarrerak[aukeguna - 1][aukeros]
                                                            + sarrerakop;
                                                } else {
                                                    sarrerak[aukeguna - 1][aukeros] = sarrerakop;
                                                }
                                                sarrerakont = sarrerakont + sarrerakop;
                                                sarrerakopMAX[aukeguna
                                                        - 1][aukeros] = sarrerakopMAX[aukeguna - 1][aukeros]
                                                                + sarrerakont;
                                                System.out.println(sarrerakopMAX[aukeguna - 1][aukeros]);
                                            } else if (sarrerakont + sarrerakop > 4) {
                                                System.out.println(
                                                        "Erositako sarrera kopurua 4 baino gehiago da, beraz azkeneko pelikularen sarrerak murriztu zaizkizu.");
                                                // Egun eta film berean aurretik erosita badago, kopurua metatu.
                                                if (sarrerak[aukeguna - 1][aukeros] != 0) {
                                                    sarrerak[aukeguna - 1][aukeros] = sarrerak[aukeguna - 1][aukeros]
                                                            + sarrerakop;
                                                    if (sarrerak[aukeguna - 1][aukeros] + sarrerakop >= 4) {
                                                        sarrerak[aukeguna - 1][aukeros] = 4;
                                                    }
                                                }
                                                // Saio honetarako aurretik sarrerarik erosi ez bada, kopurua hasieratu.
                                                else {
                                                    sarrerak[aukeguna - 1][aukeros] = 4 - sarrerakont;
                                                }
                                                sarrerakont = 4;
                                                sarrerakopMAX[aukeguna
                                                        - 1][aukeros] = sarrerakopMAX[aukeguna - 1][aukeros]
                                                                + sarrerakont;

                                            }
                                            aukeraeros = 'E';
                                        }
                                        // Guztira lau sarrera baino gutxiago erosi badira, erosketa gorde.
                                        if (sarrerakont + sarrerakop < 4) {
                                            // Film eta egun berean aurretik erosita badago, sarrera-kopurua metatu.
                                            if (sarrerak[aukeguna - 1][aukeros] != 0) {
                                                sarrerak[aukeguna - 1][aukeros] = sarrerak[aukeguna - 1][aukeros]
                                                        + sarrerakop;
                                                sarrerakopMAX[aukeguna
                                                        - 1][aukeros] = sarrerakopMAX[aukeguna - 1][aukeros]
                                                                + sarrerakont;

                                            }
                                            // Bestela, aukeratutako saiorako erosketa berria gorde.
                                            else {
                                                sarrerak[aukeguna - 1][aukeros] = sarrerakop;
                                                sarrerakopMAX[aukeguna
                                                        - 1][aukeros] = sarrerakopMAX[aukeguna - 1][aukeros]
                                                                + sarrerakop;

                                            }
                                            // Beste film baterako sarrerarik erosi nahi duen galdetu.
                                            sarrerakont = sarrerakont + sarrerakop;

                                            System.out.println(
                                                    "Beste pelikula batentzat sarrerak erosi nahi dituzu? (B/E) gogoratu 4 direla maximoa eta zuk "
                                                            + sarrerakont + " dituzula jada");
                                            aukeraeros = aukIrakBE(sc);
                                            if (aukeraeros == 'E') {
                                                System.out.println("Eskerrikasko ZinemaZubietan erosteagatik");
                                            }
                                        }
                                    } else {
                                        aukeraeros = 'E';
                                    }
                                } else {
                                    if (aukeraeros == 'B') {
                                        // Aforoa gainditu gabe, hautatutako sarrerak erregistratu.
                                        if (sarrerakont + sarrerakop >= 4) {
                                            if (sarrerakont + sarrerakop == 4) {
                                                System.out.println("4 sarrera erosi dituzu guztira");
                                                if (sarrerak[aukeguna - 1][aukeros] != 0) {
                                                    sarrerak[aukeguna - 1][aukeros] = sarrerak[aukeguna - 1][aukeros]
                                                            + sarrerakop;
                                                } else {
                                                    sarrerak[aukeguna - 1][aukeros] = sarrerakop;
                                                }
                                                sarrerakont = sarrerakont + sarrerakop;
                                                sarrerakopMAX[aukeguna
                                                        - 1][aukeros] = sarrerakopMAX[aukeguna - 1][aukeros]
                                                                + sarrerakont;

                                            } else if (sarrerakont + sarrerakop > 4) {
                                                System.out.println(
                                                        "Erositako sarrera kopurua 4 baino gehiago da, beraz azkeneko pelikularen sarrerak murriztu zaizkizu.");
                                                // Egun eta film berean aurretik erosita badago, kopurua metatu.
                                                if (sarrerak[aukeguna - 1][aukeros] != 0) {
                                                    sarrerak[aukeguna - 1][aukeros] = sarrerak[aukeguna - 1][aukeros]
                                                            + sarrerakop;
                                                    if (sarrerak[aukeguna - 1][aukeros] + sarrerakop >= 4) {
                                                        sarrerak[aukeguna - 1][aukeros] = 4;
                                                    }
                                                }
                                                // Saio honetarako aurretik sarrerarik erosi ez bada, kopurua hasieratu.
                                                else {
                                                    sarrerak[aukeguna - 1][aukeros] = 4 - sarrerakont;
                                                }
                                                sarrerakont = 4;
                                                sarrerakopMAX[aukeguna
                                                        - 1][aukeros] = sarrerakopMAX[aukeguna - 1][aukeros]
                                                                + sarrerakont;

                                            }
                                            aukeraeros = 'E';
                                        }
                                        // Guztira lau sarrera baino gutxiago erosi badira, erosketa gorde.
                                        if (sarrerakont + sarrerakop < 4) {
                                            // Film eta egun berean aurretik erosita badago, sarrera-kopurua metatu.
                                            if (sarrerak[aukeguna - 1][aukeros] != 0) {
                                                sarrerak[aukeguna - 1][aukeros] = sarrerak[aukeguna - 1][aukeros]
                                                        + sarrerakop;
                                                sarrerakopMAX[aukeguna
                                                        - 1][aukeros] = sarrerakopMAX[aukeguna - 1][aukeros]
                                                                + sarrerakont;
                                                System.out.println(sarrerakopMAX[aukeguna - 1][aukeros]);
                                            }
                                            // Bestela, aukeratutako saiorako erosketa berria gorde.
                                            else {
                                                sarrerak[aukeguna - 1][aukeros] = sarrerakop;
                                                sarrerakopMAX[aukeguna
                                                        - 1][aukeros] = sarrerakopMAX[aukeguna - 1][aukeros]
                                                                + sarrerakop;
                                                System.out.println(sarrerakopMAX[aukeguna - 1][aukeros]);
                                            }
                                            // Beste film baterako sarrerarik erosi nahi duen galdetu.
                                            sarrerakont = sarrerakont + sarrerakop;

                                            System.out.println(
                                                    "Beste pelikula batentzat sarrerak erosi nahi dituzu? (B/E) gogoratu 4 direla maximoa eta zuk "
                                                            + sarrerakont + " dituzula jada");
                                            aukeraeros = aukIrakBE(sc);
                                            if (aukeraeros == 'E') {
                                                System.out.println("Eskerrikasko ZinemaZubietan erosteagatik");
                                            }
                                        }
                                    } else {
                                        aukeraeros = 'E';
                                    }
                                }

                            }
                        }

                    } while (aukeraeros != 'E');

                    break;
                case 2:
                    // Film-kopurua eta areto bakoitzean proiektatzen diren filmak erakutsi.
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
                    // Zinemaren helbidea erakutsi.
                    System.out.println("Zubieta zinema helbidea: Etarte bidea 9, 20170 Zubieta-Usurbil (Gipuzkoa)");
                    break;
                case 4:
                    // Zinemaren irekiera-ordutegia erakutsi.
                    System.out.println(" ASTEAN ZEHAR: 15:00 - 00:00\n ASTEBURUAK 12:00 - 00:00");
                    break;
                case 5:
                    // Administrazioan sartzeko erabiltzaile-izena eta pasahitza egiaztatu.
                    System.out.println("Sartu erabiltzailea");
                    String erabiltzailea = sc.next();
                    if (erabiltzaileak.contains(erabiltzailea) == true) {
                        System.out.println("erabiltzailea ondo jarri duzu");
                        System.out.println("Sartu pasahitza");
                        String pasahitza = sc.next();

                        if (pasahitzak.contains(pasahitza)
                                & (erabiltzaileak.indexOf(erabiltzailea)) == (pasahitzak.indexOf(pasahitza)) == true) {
                            System.out.println("Pasahitza ondo jarri duzu");

                            int auk5 = 0;
                            // Administrazio-menua errepikatu "Irten" hautatu arte.
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
                                int auk2 = Konprobatu(0, 5, sc);

                                switch (auk2) {
                                    case 1:
                                        // Film berria gehitu, haren genero balioduna eskatu eta kartelera eguneratu.
                                        System.out.println("sartu pelikula berriaren izena: ");
                                        sc.nextLine();
                                        String peliberri = sc.nextLine();
                                        pelikulakList.add(peliberri);
                                        System.out.println(
                                                "Sartu pelikularen generoa (haurrentzako, superheroiak, thriller, zientzia fikzioa edo komedia):");
                                        String generoBerri = sc.nextLine().trim();
                                        int generoKodeBerri = GeneroKodea(generoBerri);
                                        while (generoKodeBerri < 0) {
                                            System.out.println(
                                                    "Genero hori ez da baliozkoa. Sartu: haurrentzako, superheroiak, thriller, zientzia fikzioa edo komedia.");
                                            generoBerri = sc.nextLine().trim();
                                            generoKodeBerri = GeneroKodea(generoBerri);
                                        }
                                        generoakList.add(generoBerri);
                                        // Genero-kodea ere gordetzen da, pelikula berriak array finkoaren muga gaindi
                                        // ez dezan.
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
                                        // Zerrendako film bat hautatu eta haren izena edo generoa aldatu.
                                        for (int i = 0; i < pelikulakList.size(); i++) {
                                            System.out.print((i + 1) + ". " + pelikulakList.get(i));
                                            System.out.println("" + " (" + generoakList.get(i) + " )");
                                        }
                                        System.out.println("zein pelikularen informazioa aldatu nahi dezu (1-"
                                                + pelikulakList.size() + ")?");
                                        System.out.println("");
                                        auk2 = Konprobatu(0, pelikulakList.size(), sc);
                                        System.out.println("");
                                        System.out.println("zein datu aldatu nahi duzu?");
                                        System.out.println("1. Pelikularen izena   2.pelikularen generoa");
                                        int auk3 = Konprobatu(0, 2, sc);
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
                                                System.out.println(
                                                        "Genero hori ez da baliozkoa. Sartu: haurrentzako, superheroiak, thriller, zientzia fikzioa edo komedia.");
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
                                        // Zerrendatik film bat ezabatu, lotutako genero-datuak sinkronizatuz.
                                        for (int i = 0; i < pelikulakList.size(); i++) {
                                            System.out.print((i + 1) + ". " + pelikulakList.get(i));
                                            System.out.println("" + " (" + generoakList.get(i) + " )");
                                        }
                                        System.out.println(
                                                "zein pelikula ezabatu nahi dezu (1-" + pelikulakList.size() + ")?");
                                        int auk4 = Konprobatu(0, pelikulakList.size(), sc);
                                        pelikulakList.remove(auk4 - 1);
                                        generoakList.remove(auk4 - 1);
                                        // Indizeak lerrokatuta mantentzeko, genero-kodea ere ezabatzen da.
                                        generoKodeak.remove(auk4 - 1);

                                        break;
                                    case 4:
                                        // Film guztien izenak eta generoak zerrendatu.
                                        for (int i = 0; i < pelikulakList.size(); i++) {
                                            System.out.print((i + 1) + ". " + pelikulakList.get(i));
                                            System.out.println("" + " (" + generoakList.get(i) + " )");
                                        }
                                        break;
                                    case 5:
                                        // Administrazio-menutik irteteko begiztaren kontrol-aldagaia aldatu.
                                        auk5 = -1;
                                        break;

                                }
                            }

                        } else {
                            System.out.println("pasahitza gaizki jarri duzu");
                        }
                    } else {
                        System.out.println("Erabiltzailea gaizki jarri duzu");
                    }

                    break;
                case 6:
                    // Programa amaitu aurretik, erositako sarreren tiketa erakutsi.
                    if (sarrerakont != 0) {
                        System.out.println("-------------ZURE TIKETA-------------\n");
                        for (int i = 0; i < 7; i++) {
                            for (int j = 0; j < 5; j++) {
                                if (sarrerak[i][j] != 0) {
                                    System.out.println("Eguna: " + egunak[i] + ", Pelikula: "
                                            + pelikulakList.get(kartelera[i][j]) + ", Sarrera kopurua: "
                                            + sarrerak[i][j]);
                                }
                            }
                        }
                        System.out.println("--------------------------------------------------");
                    }
                    System.out.println("Eskerrikasko erabiltzeagatik");
                    // Def aldagaia aldatuta, menu nagusiaren begizta amaitzen da.
                    def = 1;
                    break;
            }
            // Hurrengo menu-aukera irakurtzeko aldagaia hasieratu.
            auk = 0;
        }
        sc.close();
    }

    static void Kartelera(int aukeguna, int saiokop, String[] egunak, ArrayList<String> generoakList,
            ArrayList<String> pelikulakList,
            String[] gelak, ArrayList<Integer> generoKodeak, int[][] kartelera) {
        // Hautatutako eguneko filmak, aretoak eta saio-orduak pantailan erakusten ditu.
        System.out.println(" " + egunak[aukeguna - 1] + " egunean proiektatuko diren pelikulak:");
        // Saio bakoitzean filmaren izena eta aretoaren izena lerrokatuta erakusten ditu.
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
            // Astegunetan saioak 15:00etan hasten dira; asteburuetan, 12:00etan.
            if (aukeguna < 6) {
                System.out.print((15 + 2 * i) + ":00 etan. \n");
            } else {
                System.out.print((12 + 2 * i) + ":00 etan. \n");
            }

        }
    }

    // Generoaren testua dagokion areto-indize bihurtzen du; ezezaguna bada, -1 itzultzen du.
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
        // Baliozko zenbaki bat irakurri arte eskatzen jarraitzen du.
        while (aukera <= 0 || aukera > luzeera) {
            if (!sc.hasNextInt()) {
                // Zenbakia ez den tokena baztertu, berriro irakurtzean bueltan ez hartzeko.
                System.out.println("ERROREA: sartu zenbaki bat.");
                sc.next();
                continue;
            }

            aukera = sc.nextInt();
            // Zenbakia baimendutako tartean dagoen egiaztatu.
            if (aukera <= 0 || aukera > luzeera) {
                System.out.println("Sartutako aukera ez dago ondo, faborez sartu baliozkoa den aukera bat.");
            }
        }

        return aukera;
    }

    static char aukIrakBE(Scanner sc) {
        // B edo E letra bakarra onartu, maiuskulaz zein minuskulaz.
        while (true) {
            String respuesta = sc.next().trim();
            if (respuesta.length() == 1) {
                char opcion = Character.toUpperCase(respuesta.charAt(0));
                if (opcion == 'B' || opcion == 'E') {
                    return opcion;
                }
            }

            System.out.println("ERROREA: B edo E idatzi");
        }
    }
}