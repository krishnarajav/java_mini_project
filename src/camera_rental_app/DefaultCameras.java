package camera_rental_app;

public class DefaultCameras extends CameraRentalApp {
    protected static void loadDefaultCameras() {
        Camera c1 = new Camera("Samsung", "DS123", 500);
        Camera c2 = new Camera("Sony", "HD214", 1000);
        Camera c3 = new Camera("Panasonic", "XC", 500);
        Camera c4 = new Camera("Canon", "XLR", 750);
        Camera c5 = new Camera("Fujitsu", "J5", 500);
        Camera c6 = new Camera("Sony", "HD226", 700);
        Camera c7 = new Camera("LG", "L123", 500);
        Camera c8 = new Camera("Canon", "XPL", 800);
        Camera c9 = new Camera("Chroma", "CT", 500);
        Camera c10 = new Camera("Nikon", "DSLR-D7500", 1200);

        cameraMap.put(c1.getId(), c1);
        cameraMap.put(c2.getId(), c2);
        cameraMap.put(c3.getId(), c3);
        cameraMap.put(c4.getId(), c4);
        cameraMap.put(c5.getId(), c5);
        cameraMap.put(c6.getId(), c6);
        cameraMap.put(c7.getId(), c7);
        cameraMap.put(c8.getId(), c8);
        cameraMap.put(c9.getId(), c9);
        cameraMap.put(c10.getId(), c10);
    }
}
