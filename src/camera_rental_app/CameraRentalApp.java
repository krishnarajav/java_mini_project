package camera_rental_app;
 
import java.util.*;
 
public class CameraRentalApp {
 
    protected static TreeMap<Integer, Camera> cameraMap = new TreeMap<>();
    private static TreeMap<Integer, Camera> myCameraMap = new TreeMap<>();
 
    private static Wallet wallet = new Wallet();
    private static Scanner sc = new Scanner(System.in);
 
    public static void main(String[] args) {
        loginScreen();
        DefaultCameras.loadDefaultCameras();
 
        while (true) {
            showMainMenu();
            String choice = sc.nextLine().trim();
 
            switch (choice) {
                case "1": myCameraMenu(); break;
                case "2": rentCamera(); break;
                case "3": viewAllCameras(); break;
                case "4": walletMenu(); break;
                case "5":
                    System.out.println("EXITING APPLICATION...");
                    System.exit(0);
                default:
                    System.out.println("INVALID OPTION. TRY AGAIN.");
            }
        }
    }
 
    private static void loginScreen() {
        System.out.println("+---------------------------+");
        System.out.println("|  WELCOME TO RENTMYCAM.IO  |");
        System.out.println("|  DEVELOPER: KRISHNARAJA V |");
        System.out.println("+---------------------------+");
        System.out.println("PLEASE LOGIN TO CONTINUE");
 
        while (true) {
            System.out.print("USERNAME: ");
            String user = sc.nextLine();
 
            System.out.print("PASSWORD: ");
            String pass = sc.nextLine();
 
            if (user.equals("admin") && pass.equals("admin123")) {
                break;
            }
            System.out.println("INVALID CREDENTIALS. TRY AGAIN.\n");
        }
    }
 
    private static void showMainMenu() {
    	System.out.println("\n+---------------------------+");
    	System.out.println("|         MAIN MENU         |");
    	System.out.println("+---------------------------+");
        System.out.println("|1. MY CAMERA               |");
        System.out.println("|2. RENT A CAMERA           |");
        System.out.println("|3. VIEW ALL CAMERAS        |");
        System.out.println("|4. MY WALLET               |");
        System.out.println("|5. EXIT                    |");
        System.out.println("+---------------------------+");
    }
 
    private static void myCameraMenu() {
        while (true) {
        	System.out.println("\n+---------------------------+");
        	System.out.println("|        CAMERA MENU        |");
        	System.out.println("+---------------------------+");
            System.out.println("|1. ADD                     |");
            System.out.println("|2. REMOVE                  |");
            System.out.println("|3. VIEW MY CAMERAS         |");
            System.out.println("|4. GO TO PREVIOUS MENU     |");
            System.out.println("+---------------------------+");
 
            String ch = sc.nextLine();
 
            switch (ch) {
                case "1": addCamera(); break;
                case "2": removeCamera(); break;
                case "3": viewMyCameras(); break;
                case "4": return;
                default: System.out.println("INVALID OPTION.");
            }
        }
    }
 
    private static void addCamera() {
        System.out.print("ENTER THE CAMERA BRAND: ");
        String brand = sc.nextLine();
 
        System.out.print("ENTER THE MODEL: ");
        String model = sc.nextLine();
 
        System.out.print("ENTER THE PER DAY PRICE (INR): ");
        double price = readDouble();
 
        Camera cam = new Camera(brand, model, price);
        cameraMap.put(cam.getId(), cam);
        myCameraMap.put(cam.getId(), cam);
 
        System.out.println("YOUR CAMERA HAS BEEN SUCCESSFULLY ADDED TO THE LIST.");
    }
 
    private static void removeCamera() {
        if (myCameraMap.isEmpty()) {
            System.out.println("NO CAMERAS TO REMOVE.");
            return;
        }
 
        renderTable(myCameraMap);
 
        System.out.print("ENTER THE CAMERA ID TO REMOVE: ");
        int id = readInt();
 
        if (myCameraMap.containsKey(id)) {
            myCameraMap.remove(id);
            cameraMap.remove(id);
            System.out.println("CAMERA SUCCESSFULLY REMOVED FROM THE LIST.\n");
        } else {
            System.out.println("INVALID CAMERA ID.");
        }
    }
 
    private static void viewMyCameras() {
        if (myCameraMap.isEmpty()) {
            System.out.println("NO CAMERAS FOUND.");
            return;
        }
        renderTable(myCameraMap);
    }
 
    private static void viewAllCameras() {
        if (cameraMap.isEmpty()) {
            System.out.println("NO DATA PRESENT AT THIS MOMENT.");
            return;
        }
 
        renderTable(cameraMap);
    }
 
    private static void renderTable(TreeMap<Integer, Camera> map) {
        System.out.println("+===================================================================+");
        System.out.println("|CAMERA ID  |BRAND        |MODEL        |PRICE(PER DAY)  |STATUS    |");
        System.out.println("+===========+=============+=============+================+==========+");
 
        for (Camera c : map.values()) {
            System.out.printf("|%-10d |%-12s |%-12s |%-15s |%-10s|\n",
                    c.getId(),
                    c.getBrand(),
                    c.getModel(),
                    c.getRentPerDay(),
                    c.getStatus());
        }
        System.out.println("+===================================================================+");
    }
 
    private static void rentCamera() {
        if (cameraMap.isEmpty()) {
            System.out.println("NO DATA PRESENT AT THIS MOMENT.");
            return;
        }
 
        renderTable(cameraMap);
 
        System.out.print("ENTER THE CAMERA ID YOU WANT TO RENT: ");
        int id = readInt();
 
        if (!cameraMap.containsKey(id)) {
            System.out.println("INVALID CAMERA ID.");
            return;
        }
 
        Camera c = cameraMap.get(id);
 
        if (c.getStatus().equals("Rented")) {
            System.out.println("THIS CAMERA IS ALREADY RENTED.");
            return;
        }
 
        try {
            wallet.deduct(c.getRentPerDay());
            c.setStatus("Rented");
 
            System.out.println("YOUR TRANSACTION FOR CAMERA - " + c.getBrand() + " " + c.getModel() +
                    " WITH RENT INR." + c.getRentPerDay() +
                    " HAS SUCCESSFULLY COMPLETED.");
 
        } catch (RuntimeException e) {
            System.out.println("ERROR : TRANSACTION FAILED DUE TO INSUFFICIENT WALLET BALANCE. PLEASE DEPOSIT THE AMOUNT TO YOUR WALLET.");
        }
    }
 
    private static void walletMenu() {
    	while (true) {
    		System.out.println("\n+---------------------------+");
    		System.out.println("|        WALLET MENU        |");
    		System.out.println("+---------------------------+");
            System.out.println("|1. VIEW BALANCE            |");
            System.out.println("|2. ADD FUNDS               |");
            System.out.println("|3. GO TO PREVIOUS MENU     |");
            System.out.println("+---------------------------+");
 
            int ch = readInt();
 
            switch (ch) {
                case 1: System.out.println("YOUR CURRENT WALLET BALANCE IS - INR." + wallet.getBalance()); break;
                case 2:
                	System.out.print("ENTER THE AMOUNT (INR): ");
                	double amt = readDouble();
                	wallet.addAmount(amt);
                	System.out.println("YOUR WALLET BALANCE UPDATED SUCCESSFULLY. CURRENT WALLET BALANCE - INR." + wallet.getBalance()); break;
                case 3: return;
                default: System.out.println("INVALID OPTION.");
            }
        }
    }
 
    private static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.print("ENTER VALID NUMBER: ");
            }
        }
    }
 
    private static double readDouble() {
        while (true) {
            try {
            	Double d = Double.parseDouble(sc.nextLine().trim());
            	if(d > 0.0) {
            		return d;
            	}
            	else {
            		 System.out.print("ENTER VALID AMOUNT: ");
            	}
            } catch (Exception e) {
                System.out.print("ENTER VALID AMOUNT: ");
            }
        }
    }
}