import com.fasterxml.jackson.databind.JsonNode;

public class HashNode {
    String data;
    JsonNode value;
   HashNode next;
   String[][] value2;
   String data2;
   HashNode next2;

    public HashNode(String data, JsonNode value) {
        this.data = data;
        this.value=value;
        this.next = null;
    }
    public HashNode(String data,String[][] value){
        this.data2=data;
        this.value2=value;
        this.next2=null;
    }
}
