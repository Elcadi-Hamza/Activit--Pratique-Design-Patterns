package computer.Aapter;

import computer.TV;
import computer.VGA;


//utilisant l'heritage
public class HdmiVgaAdapterH extends TV implements VGA {

    @Override
    public void print(String message) {
        System.out.println("Adaptateur ==========================================");
        byte[] data = message.getBytes();
        super.view(data);
        System.out.println("Adaptateur ==========================================");
    }
}
