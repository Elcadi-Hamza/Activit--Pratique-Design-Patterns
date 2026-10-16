package computer.Aapter;

import computer.Hdmi;
import computer.VGA;


// Baser sur la compositon
public class HdmiVgaAdapter implements VGA {
    //utilisant la composition
    private Hdmi hdmi;

    @Override
    public void print(String message) {
        System.out.println("Adaptateur ==========================================");
        byte[] data = message.getBytes();
        hdmi.view(data);
        System.out.println("Adaptateur ==========================================");
    }

    public void setHdmi(Hdmi hdmi) {
        this.hdmi = hdmi;
    }
}
