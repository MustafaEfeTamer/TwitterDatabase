import com.fasterxml.jackson.databind.JsonNode;

import java.util.Arrays;
import java.util.Objects;

// Hash tablosu sınıfı
class HashTablosu {
    private final HashNode[] HashTablo;
    private  HashNode[] HashTablo2;
    private final int size = 128;


    private int indexBul(String data) {
        int adres = data.hashCode();
        return Math.abs(adres) % size;
    }


    public HashTablosu() {
        HashTablo = new HashNode[size];
        HashTablo2=new HashNode[size];
    }

    // Hash tablosuna eleman ekleme
    public void put(String data, JsonNode value) {
        int index = indexBul(data);
        HashNode hashNode = new HashNode(data, value);
        // İlgili indeksteki bağlantılı listeye ekleme
            HashTablo[index] = hashNode;
            HashNode nodeBagla = HashTablo[index];
            while (nodeBagla.next != null) {
                nodeBagla = nodeBagla.next;
            }
            nodeBagla.next = hashNode;
    }

    public void ekleme(String data,String value){
        String [][] deger = new String[value.length()][3];
        for (int i = 0; i <value.length() ; i++) {
            for (int j = 0; j <3 ; j++) {
                deger[i][j]=value;
            }
        }
            putS(data,deger);
    }
    public void putS(String data, String[][] value){
        int index = indexBul(data);
        HashNode hashNode = new HashNode(data, value);
        // İlgili indeksteki bağlantılı listeye ekleme
        HashTablo2[index] = hashNode;
        HashNode nodeBagla = HashTablo2[index];
        while (nodeBagla.next2 != null) {
            nodeBagla = nodeBagla.next2;
        }
        nodeBagla.next2 = hashNode;
    }

    // Hash tablosundan elemanı getirme
    public JsonNode get(String data) {
        int index = indexBul(data);
        HashNode node = HashTablo[index];
        // İlgili indeksteki bağlantılı listeyi kontrol etme
        while (node != null) {
            if (Objects.equals(node.data, data)) {
                return node.value;
            }
            node = node.next;
        }
        return null; // Eleman bulunamadı
    }

    public String[][] getS(String data){
        int index=indexBul(data);
        HashNode node=HashTablo2[index];
        while(node!=null){
            if(Objects.equals(node.data2, data)){
                return node.value2;
            }
            node=node.next2;
        }
        return null;
    }

}