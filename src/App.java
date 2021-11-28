public class App {

    public static void main(String[] args) {
         Avion avion=new AvionImpl();
         avion.doActivity();
         avion.sortirDuGarage();
         avion.entrerDuGarage();
         avion.doActivity();
         avion.decoller();
         avion.atterir();
         avion.sortirDuGarage();
         avion.doActivity();
         avion.decoller();
         avion.doActivity();
         avion.entrerDuGarage();
         avion.decoller();
         avion.atterir();
         avion.doActivity();
    }
}
