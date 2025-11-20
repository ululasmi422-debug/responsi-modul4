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
        } else {
            return current;
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
            cari(node.left, namaBunga);
            if (node.bunga.equalsIgnoreCase(namaBunga)) {
                System.out.println("Bunga kesukaan (" + namaBunga + ") ditemukan dengan nilai: " + node.angka);
                return;
            }
            cari(node.right, namaBunga);
        }
    }
}