public class AvionImpl implements Avion {
    private State state;
    public AvionImpl(){
        state=new EtatEnPiste(this);
    }

    @Override
    public void sortirDuGarage() {
        state.sortirDuGarage();
    }

    @Override
    public void entrerDuGarage() {
        state.entrerDuGarage();
    }

    @Override
    public void decoller() {
        state.decoller();
    }

    @Override
    public void atterir() {
        state.atterir();
    }

    @Override
    public void doActivity() {
        state.doActivity();

    }
    abstract class State{
        protected  AvionImpl avion;
        public State(AvionImpl a){
            this.avion=a;
        }
        abstract void sortirDuGarage();
        abstract void entrerDuGarage();
        abstract void decoller();
        abstract void atterir();
        abstract void doActivity();
    }
    class EtatEnPiste extends  State{

        public EtatEnPiste(AvionImpl a) {
            super(a);
        }

        @Override
        void sortirDuGarage() {
            System.out.println("Impossible de sortir du garage");
        }

        @Override
        void entrerDuGarage() {
            System.out.println("piste to garage");
            state=new EtatAuGarage(avion);
        }

        @Override
        void decoller() {
            System.out.println("piste to decollage");
            avion.state=new EtatEnLaire(avion);
        }

        @Override
        void atterir() {
            System.out.println("impossible je suis deja en piste");
        }

        @Override
        void doActivity() {
            System.out.println("Activites de l'etat en piste...");
        }
    }

    class EtatAuGarage extends State{

        public EtatAuGarage(AvionImpl a) {
            super(a);
        }

        @Override
        void sortirDuGarage() {
            System.out.println("garage vers piste");
            avion.state=new EtatEnPiste(avion);
        }

        @Override
        void entrerDuGarage() {
            System.out.println("je suis deja dans le garage");
        }

        @Override
        void decoller() {
            System.out.println("impossible je suis au grage");
        }

        @Override
        void atterir() {
            System.out.println("impossible de atterir je suis au garage");
        }

        @Override
        void doActivity() {
            for (int i = 0; i < 10; i++) {
                System.out.println("activite de l'etat");
            }
        }
    }

    class EtatEnLaire extends State{

        public EtatEnLaire(AvionImpl a) {
            super(a);
        }

        @Override
        void sortirDuGarage() {
            System.out.println("impossible je suis dans l'aire");
        }

        @Override
        void entrerDuGarage() {
            System.out.println("impossible je suis dans l'aire");
        }

        @Override
        void decoller() {
            System.out.println("impossible je suis dans l'aire");
        }

        @Override
        void atterir() {
            System.out.println("laire to piste");
            avion.state=new EtatEnPiste(avion);
        }

        @Override
        void doActivity() {
            for (int i = 0; i < 10; i++) {
                System.out.println("activite de l'etat");
            }
        }
    }
}
