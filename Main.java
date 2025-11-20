class Node {
    String bunga;
    int angka;
    Node left;
    Node right;

    public Node(String bunga, int angka) {
        this.bunga = bunga;
        this.angka = angka;
        this.left = null;
        this.right = null;
    }
}

class Tree {
    Node akar;

    public Tree() {
        akar = null;
    }

    public void tambah(String bunga, int angka) {
        akar = tambahRekursif(akar, bunga, angka);
    }

    private Node tambahRekursif(Node current, String bunga, int angka) {
        if (current == null) {
            return new Node(bunga, angka);
        }

        if (angka < current.angka) {
            current.left = tambahRekursif(current.left, bunga, angka);
        } else if (angka > current.angka) {
            current.right = tambahRekursif(current.right, bunga, angka);
        }
        return current;
    }

    public void tampilIn(Node node) {
        if (node != null) {
            tampilIn(node.left);
            System.out.printf("| %-12s | %-5d |\n", node.bunga, node.angka);
            tampilIn(node.right);
        }
    }

    public Node nilaiMax(Node node) {
        if (node == null) {
            return null;
        }
        Node current = node;
        while (current.right != null) {
            current = current.right;
        }
        return current;
    }

    public void cetakGenap(Node node) {
        if (node != null) {
            cetakGenap(node.left);
            if (node.angka % 2 == 0) {
                System.out.printf("| %-12s | %-5d |\n", node.bunga, node.angka);
            }
            cetakGenap(node.right);
        }
    }

    public void cari(Node node, String namaBunga) {
        if (node != null) {
            if (node.bunga.equalsIgnoreCase(namaBunga)) {
                System.out.println("Bunga kesukaan (" + namaBunga + ") ditemukan dengan nilai: " + node.angka);
                return;
            }
            cari(node.left, namaBunga);
            cari(node.right, namaBunga);
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Tree pohon = new Tree();

        pohon.tambah("Mawar", 50);
        pohon.tambah("Melati", 30);
        pohon.tambah("Anggrek", 70);
        pohon.tambah("Lavander", 20);
        pohon.tambah("Tulip", 40);
        pohon.tambah("Dahlia", 60);
        pohon.tambah("Sakura", 80);

        System.out.println("\n=== IN-Order Traversal (Terurut berdasarkan Angka) ===");
        header();
        pohon.tampilIn(pohon.akar);
        footer();

        System.out.println("\n=== Tampilkan Bunga dengan Nilai Terbesar ===");
        Node besar = pohon.nilaiMax(pohon.akar);
        if (besar != null) {
             System.out.println("Nilai terbesar: " + besar.bunga + " [" + besar.angka + "]");
        } else {
             System.out.println("Tree kosong.");
        }

        System.out.println("\n=== Tampilkan Genap ===");
        header();
        pohon.cetakGenap(pohon.akar);
        footer();

        System.out.println("\n=== Tampilkan bunga kesukaan ===");
        pohon.cari(pohon.akar, "sakura");
    }

    static void header() {
        System.out.println("+--------------+-------+");
        System.out.println("| Nama Bunga   | Nilai |");
        System.out.println("+--------------+-------+");
    }

    static void footer() {
        System.out.println("+--------------+-------+");
    }
}