import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Zinemazubieta {
    private static final int SAIO_KOPURUA = 5;
    private static final int EGUN_KOPURUA = 7;
    private static final int AFORO_MAXIMOA = 25;
    private static final int SARRERA_MUGA = 4;

    private final Scanner sc = new Scanner(System.in);
    private final List<Pelikula> pelikulak = new ArrayList<>();
    private final String[] gelak = {
        "Umeen gela",
        "Superheroien gela",
        "thriller gela",
        "Zientzia fikzio gela",
        "komedia gela"
    };
    private final String[] egunak = {
        "Astelehena", "Asteartea", "Asteazkena", "Osteguna",
        "Ostirala", "Larunbata", "Igandea"
    };
    private final String[] erabiltzaileak = { "Oier", "Jon", "Kay" };
    private final String[] pasahitzak = { "1881", "0308", "3367" };
    private final int[][] kartelera = new int[EGUN_KOPURUA][SAIO_KOPURUA];
    private final int[][] sarrerak = new int[EGUN_KOPURUA][SAIO_KOPURUA];
    private final int[][] eserlekuOkupatuak = new int[EGUN_KOPURUA][SAIO_KOPURUA];
    private int eroslearenSarreraKopurua;

    public static void main(String[] args) {
        new Zinemazubieta().hasi();
    }

    private Zinemazubieta() {
        hasierakoPelikulakKargatu();
        eserlekuOkupatuak[0][0] = 25;
        eserlekuOkupatuak[0][1] = 23;
        karteleraBerriaSortu();
    }

    private void hasi() {
        System.out.println("Ongi etorri ZinemaZubietara!!");
        boolean martxan = true;

        while (martxan) {
            erakutsiMenuNagusia();
            int aukera = aukeraIrakurri(6);

            switch (aukera) {
                case 1 -> egunaAukeratuEtaSarrerakErosi();
                case 2 -> pelikulenInformazioaErakutsi();
                case 3 -> System.out.println(
                        "Zubieta zinema helbidea: Etarte bidea 9, 20170 Zubieta-Usurbil (Gipuzkoa)");
                case 4 -> System.out.println(" ASTEAN ZEHAR: 15:00 - 00:00\n ASTEBURUAK 12:00 - 00:00");
                case 5 -> administrazioaKudeatu();
                case 6 -> {
                    tiketaInprimatu();
                    System.out.println("Eskerrikasko erabiltzeagatik");
                    martxan = false;
                }
                default -> throw new IllegalStateException("Aukera baliogabea");
            }
        }

        sc.close();
    }

    private void hasierakoPelikulakKargatu() {
        String[] izenak = {
            "Lilo y Stitch", "Una película de Minecraft", "Mufasa: El rey león",
            "Cómo entrenar a tu dragón", "Capitán América: Brave New World",
            "Cónclave", "Sonic 3: La película", "Misión: Imposible. Sentencia Final",
            "Blancanieves", "Thunderbolt", "Padre no hay más que uno 5",
            "Wolfgang (Extraordinario)", "El casoplón", "Un funeral de locos", "Sirāt"
        };
        int[] generoKodeak = { 0, 0, 0, 0, 1, 2, 3, 2, 0, 1, 4, 2, 2, 4, 2 };

        for (int i = 0; i < izenak.length; i++) {
            pelikulak.add(new Pelikula(izenak[i], generoKodeak[i]));
        }
    }

    private void erakutsiMenuNagusia() {
        System.out.println(
                "-----------MENU NAGUSIA-----------\n"
                + " 1.Asteko eguna aukeratu\n"
                + " 2.Zinemaren informazio orokorra\n"
                + " 3.Kokapena\n"
                + " 4.Irekiera ordutegia\n"
                + " 5.Administrazioa\n"
                + " 6.Irten\n"
                + "----------------------------------\n"
                + " Zer egin nahi duzu? sartu zenbakia.");
    }

    private void egunaAukeratuEtaSarrerakErosi() {
        boolean egunAukeratzenJarraitu = true;

        while (egunAukeratzenJarraitu) {
            egunakErakutsi();
            int egunIndizea = aukeraIrakurri(egunak.length) - 1;
            karteleraInprimatu(egunIndizea);

            if (baiezkoaEskatu("SARRERAK EROSI NAHI DITUZU? GEHIENEZ 4 AHAL DITUZU EROSI (B/E)")) {
                sarrerakErosi(egunIndizea);
            }

            egunAukeratzenJarraitu = baiezkoaEskatu("Beste egun bat aukeratu nahi duzu? (B/E)");
        }
    }

    private void egunakErakutsi() {
        System.out.println(
                "---------ASTEKO EGUNAK---------\n"
                + " 1.Astelehena\n"
                + " 2.Asteartea\n"
                + " 3.Asteazkena\n"
                + " 4.Osteguna\n"
                + " 5.Ostirala\n"
                + " 6.Larunbata\n"
                + " 7.Igandea\n"
                + "---------------------------\n"
                + " Erabakitzeko sartu zenbakia.");
    }

    private void sarrerakErosi(int egunIndizea) {
        boolean erostenJarraitu = true;

        while (erostenJarraitu && eroslearenSarreraKopurua < SARRERA_MUGA) {
            System.out.println("Zein pelikularentzat erosi nahi dituzu sarrerak?");
            karteleraInprimatu(egunIndizea);
            int saioIndizea = aukeraIrakurri(SAIO_KOPURUA) - 1;

            if (eserlekuOkupatuak[egunIndizea][saioIndizea] >= AFORO_MAXIMOA) {
                System.out.println("\naforoa beteta dago, aukeratu beste pelikula bat\n");
                continue;
            }

            int eroslearentzatGehienez = SARRERA_MUGA - eroslearenSarreraKopurua;
            int saiorakoGehienez = AFORO_MAXIMOA - eserlekuOkupatuak[egunIndizea][saioIndizea];
            int sarreraKopurua = sarreraKopuruaIrakurri();

            if (sarreraKopurua > saiorakoGehienez) {
                System.out.println("Aforoa gainditzen du; gehienez " + saiorakoGehienez
                        + " sarrera erosi ahalko dituzu. Aurrera segi nahi duzu? (B/E)");
                if (!baiezkoaEskatu("B/E")) {
                    continue;
                }
                sarreraKopurua = saiorakoGehienez;
            }

            if (sarreraKopurua > eroslearentzatGehienez) {
                System.out.println("Erositako sarrera kopurua 4 baino gehiago da; "
                        + "zure azken erosketa " + eroslearentzatGehienez + " sarreratara mugatuko da.");
                sarreraKopurua = eroslearentzatGehienez;
            }

            sarreraGehitu(egunIndizea, saioIndizea, sarreraKopurua);
            System.out.println("Guztira " + eroslearenSarreraKopurua + " sarrera erosi dituzu.");

            if (eroslearenSarreraKopurua < SARRERA_MUGA) {
                erostenJarraitu = baiezkoaEskatu(
                        "Beste pelikula batentzat sarrerak erosi nahi dituzu? (B/E) "
                        + "Gogoratu 4 direla maximoa eta zuk " + eroslearenSarreraKopurua + " dituzula jada");
            } else {
                System.out.println("4 sarrera erosi dituzu guztira");
            }
        }

        if (eroslearenSarreraKopurua > 0) {
            System.out.println("Eskerrikasko ZinemaZubietan erosteagatik");
        }
    }

    private int sarreraKopuruaIrakurri() {
        int kopurua;
        do {
            System.out.println("Zenbat sarrera erosi nahi dituzu?");
            kopurua = sc.nextInt();
            if (kopurua <= 0) {
                System.out.println("Sarrera kopuruak 0 baino handiagoa izan behar du.");
            }
        } while (kopurua <= 0);
        return kopurua;
    }

    private void sarreraGehitu(int egunIndizea, int saioIndizea, int kopurua) {
        sarrerak[egunIndizea][saioIndizea] += kopurua;
        eserlekuOkupatuak[egunIndizea][saioIndizea] += kopurua;
        eroslearenSarreraKopurua += kopurua;
    }

    private void pelikulenInformazioaErakutsi() {
        System.out.println("-----------PELIKULEN INFORMAZIOA-----------\n"
                + " Pelikula kopurua: " + pelikulak.size()
                + "\n Gelen Kopurua: " + gelak.length + "\n");

        for (int gelaIndizea = 0; gelaIndizea < gelak.length; gelaIndizea++) {
            System.out.println("-----------" + gelak[gelaIndizea].toUpperCase() + "-----------");
            for (Pelikula pelikula : pelikulak) {
                if (pelikula.generoKodea == gelaIndizea) {
                    System.out.println(pelikula.izena);
                }
            }
        }
        System.out.println();
    }

    private void administrazioaKudeatu() {
        System.out.println("Sartu erabiltzailea");
        String erabiltzailea = sc.next();
        int erabiltzaileIndizea = zerrendanBilatu(erabiltzaileak, erabiltzailea);

        if (erabiltzaileIndizea < 0) {
            System.out.println("Erabiltzailea gaizki jarri duzu");
            return;
        }

        System.out.println("erabiltzailea ondo jarri duzu");
        System.out.println("Sartu pasahitza");
        String pasahitza = sc.next();
        if (!pasahitzak[erabiltzaileIndizea].equals(pasahitza)) {
            System.out.println("pasahitza gaizki jarri duzu melon");
            return;
        }

        System.out.println("Pasahitza ondo jarri duzu");
        boolean administrazioaIrekita = true;
        while (administrazioaIrekita) {
            administrazioMenuaErakutsi();
            int aukera = aukeraIrakurri(5);
            switch (aukera) {
                case 1 -> pelikulaGehitu();
                case 2 -> pelikulaAldatu();
                case 3 -> pelikulaEzabatu();
                case 4 -> pelikulakZerrendatu();
                case 5 -> administrazioaIrekita = false;
                default -> throw new IllegalStateException("Aukera baliogabea");
            }
        }
    }

    private void administrazioMenuaErakutsi() {
        System.out.println("\n-----------ADMINISTRAZIO ATALA-----------");
        System.out.println("1. Pelikula berria gehitu");
        System.out.println("2. Pelikula baten informazioa aldatu");
        System.out.println("3. Pelikula bat zerrendatik ezabatu");
        System.out.println("4. Pelikulen zerrenda erakutsi");
        System.out.println("5. Irten");
        System.out.println("-----------------------------------------\n");
        System.out.println("Aukeratu zenbaki bat (1-5)");
    }

    private void pelikulaGehitu() {
        System.out.println("sartu pelikula berriaren izena: ");
        sc.nextLine();
        String izena = sc.nextLine();
        int generoKodea = generoKodeaEskatu();
        pelikulak.add(new Pelikula(izena, generoKodea));
        karteleraBerriaSortu();
    }

    private void pelikulaAldatu() {
        pelikulakZerrendatu();
        System.out.println("zein pelikularen informazioa aldatu nahi dezu (1-" + pelikulak.size() + ")?");
        int pelikulaIndizea = aukeraIrakurri(pelikulak.size()) - 1;
        System.out.println("zein datu aldatu nahi duzu?");
        System.out.println("1. Pelikularen izena   2.pelikularen generoa");
        int datuAukera = aukeraIrakurri(2);

        if (datuAukera == 1) {
            System.out.println("sartu pelikularen izen berria:");
            sc.nextLine();
            pelikulak.get(pelikulaIndizea).izena = sc.nextLine();
        } else {
            pelikulak.get(pelikulaIndizea).generoKodea = generoKodeaEskatu();
        }
    }

    private void pelikulaEzabatu() {
        pelikulakZerrendatu();
        System.out.println("zein pelikula ezabatu nahi dezu (1-" + pelikulak.size() + ")?");
        int pelikulaIndizea = aukeraIrakurri(pelikulak.size()) - 1;
        pelikulak.remove(pelikulaIndizea);
        karteleraBerriaSortu();
    }

    private void pelikulakZerrendatu() {
        for (int i = 0; i < pelikulak.size(); i++) {
            Pelikula pelikula = pelikulak.get(i);
            System.out.println((i + 1) + ". " + pelikula.izena
                    + " (" + generoIzena(pelikula.generoKodea) + ")");
        }
    }

    private int generoKodeaEskatu() {
        System.out.println("Sartu pelikularen generoa "
                + "(haurrentzako, superheroiak, thriller, zientzia fikzioa edo komedia):");
        while (true) {
            String generoa = sc.nextLine().trim();
            int generoKodea = generoKodea(generoa);
            if (generoKodea >= 0) {
                return generoKodea;
            }
            System.out.println("Genero hori ez da baliozkoa. Sartu: haurrentzako, superheroiak, "
                    + "thriller, zientzia fikzioa edo komedia.");
        }
    }

    private int aukeraIrakurri(int gehienez) {
        int aukera;
        do {
            aukera = sc.nextInt();
            if (aukera <= 0 || aukera > gehienez) {
                System.out.println("Sartutako aukera ez dago ondo, faborez sartu baliozkoa den aukera bat.");
            }
        } while (aukera <= 0 || aukera > gehienez);
        return aukera;
    }

    private boolean baiezkoaEskatu(String mezua) {
        while (true) {
            System.out.println(mezua);
            String erantzuna = sc.next().trim();
            if (erantzuna.equalsIgnoreCase("B")) {
                return true;
            }
            if (erantzuna.equalsIgnoreCase("E")) {
                return false;
            }
            System.out.println("Sartu B edo E.");
        }
    }

    private void karteleraBerriaSortu() {
        for (int egunIndizea = 0; egunIndizea < kartelera.length; egunIndizea++) {
            Set<Integer> erabilitakoGelak = new HashSet<>();

            for (int saioIndizea = 0; saioIndizea < kartelera[egunIndizea].length; saioIndizea++) {
                List<Integer> aukerak = new ArrayList<>();
                for (int i = 0; i < pelikulak.size(); i++) {
                    if (!erabilitakoGelak.contains(pelikulak.get(i).generoKodea)) {
                        aukerak.add(i);
                    }
                }

                if (aukerak.isEmpty()) {
                    for (int i = 0; i < pelikulak.size(); i++) {
                        aukerak.add(i);
                    }
                    erabilitakoGelak.clear();
                }

                int pelikulaIndizea = aukerak.get((int) (Math.random() * aukerak.size()));
                kartelera[egunIndizea][saioIndizea] = pelikulaIndizea;
                erabilitakoGelak.add(pelikulak.get(pelikulaIndizea).generoKodea);
            }
        }
    }

    private void karteleraInprimatu(int egunIndizea) {
        System.out.println(" " + egunak[egunIndizea] + " egunean proiektatuko diren pelikulak:");
        for (int saioIndizea = 0; saioIndizea < SAIO_KOPURUA; saioIndizea++) {
            Pelikula pelikula = pelikulak.get(kartelera[egunIndizea][saioIndizea]);
            String gela = gelak[pelikula.generoKodea];
            System.out.printf("    %d. %-35s %-25s %d:00 etan.%n",
                    saioIndizea + 1,
                    pelikula.izena,
                    gela,
                    (egunIndizea < 5 ? 15 : 12) + 2 * saioIndizea);
        }
    }

    private void tiketaInprimatu() {
        if (eroslearenSarreraKopurua == 0) {
            return;
        }

        System.out.println("-------------ZURE TIKETA-------------\n");
        for (int egunIndizea = 0; egunIndizea < sarrerak.length; egunIndizea++) {
            for (int saioIndizea = 0; saioIndizea < sarrerak[egunIndizea].length; saioIndizea++) {
                if (sarrerak[egunIndizea][saioIndizea] > 0) {
                    String pelikula = pelikulak.get(kartelera[egunIndizea][saioIndizea]).izena;
                    System.out.println("Eguna: " + egunak[egunIndizea] + ", Pelikula: " + pelikula
                            + ", Sarrera kopurua: " + sarrerak[egunIndizea][saioIndizea]);
                }
            }
        }
        System.out.println("--------------------------------------------------");
    }

    private int zerrendanBilatu(String[] zerrenda, String bilatutakoa) {
        for (int i = 0; i < zerrenda.length; i++) {
            if (zerrenda[i].equals(bilatutakoa)) {
                return i;
            }
        }
        return -1;
    }

    private int generoKodea(String genero) {
        return switch (genero.trim().toLowerCase()) {
            case "haurrentzako" -> 0;
            case "superheroiak" -> 1;
            case "thriller" -> 2;
            case "zientzia fikzioa" -> 3;
            case "komedia" -> 4;
            default -> -1;
        };
    }

    private String generoIzena(int generoKodea) {
        return switch (generoKodea) {
            case 0 -> "haurrentzako";
            case 1 -> "superheroiak";
            case 2 -> "thriller";
            case 3 -> "zientzia fikzioa";
            case 4 -> "komedia";
            default -> throw new IllegalArgumentException("Genero-kode baliogabea: " + generoKodea);
        };
    }

    private static class Pelikula {
        private String izena;
        private int generoKodea;

        private Pelikula(String izena, int generoKodea) {
            this.izena = izena;
            this.generoKodea = generoKodea;
        }
    }
}
