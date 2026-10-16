package computer;

public class VideoProjecteur implements VGA{
    @Override
    public void print(String message) {
        System.out.println("Video Projecteur ==========================");
        System.out.println(message);
        System.out.println("Video Projecteur ==========================");
    }
}
