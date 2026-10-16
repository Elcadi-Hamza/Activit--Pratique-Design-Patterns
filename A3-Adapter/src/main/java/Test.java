import computer.*;
import computer.Aapter.HdmiVgaAdapter;
import computer.Aapter.HdmiVgaAdapterH;

public class Test {
    public static void main(String[] args) {
        UniteCentre uniteCentre = new UniteCentre();
        uniteCentre.setVga(new Ecran());
        uniteCentre.print("bonjour depuis l'ecran");
        uniteCentre.setVga(new VideoProjecteur());
        uniteCentre.print("bonjour depuis le VideoProjecteur");

//      Adaptateur base sur la composition
        HdmiVgaAdapter hdmiVgaAdapter = new HdmiVgaAdapter();
        hdmiVgaAdapter.setHdmi(new TV());
        uniteCentre.setVga(hdmiVgaAdapter);
        hdmiVgaAdapter.print("Bonjour depuis VgaAdapter baser sur la composition");

//      la class SuperVp on peut utiliser sans adaptateur ou
//      avec adaptateur car il implement les deux interface au meme temp.
        uniteCentre.setVga(new SuperVp());
        uniteCentre.print("hello from Super VP sans adaptateur");


        HdmiVgaAdapter hdmiVgaAdapter_ = new HdmiVgaAdapter();
        hdmiVgaAdapter_.setHdmi(new SuperVp());
        uniteCentre.setVga(hdmiVgaAdapter_);
        uniteCentre.print("hello from Super VP avec adaptateur");

        // Adaptateur base sur l'heritage
        HdmiVgaAdapterH hdmiVgaAdapterH = new HdmiVgaAdapterH();
        uniteCentre.setVga(hdmiVgaAdapterH);
        hdmiVgaAdapterH.print("Bonjour depuis VgaAdapter baser sur l'heritage");


    }
}
