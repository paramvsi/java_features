package designpatterns.structural;

public class SP03Facade {
    public static void main(String[] args) {
        Projector projector = new Projector();
        DvdPlayer dvdPlayer = new DvdPlayer();
        SoundSystem soundSystem = new SoundSystem();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(projector, dvdPlayer, soundSystem);
        homeTheater.watchMovie("Inception");
        homeTheater.endMovie();
    }

    static class Projector {
        public void on() {
            System.out.println("Projector turning on...");
        }

        public void off() {
            System.out.println("Projector turning off...");
        }

        public void setInput(String input) {
            System.out.println("Projector input set to " + input);
        }
    }

    static class DvdPlayer {
        public void on() {
            System.out.println("DVD Player turning on...");
        }

        public void off() {
            System.out.println("DVD Player turning off...");
        }

        public void play(String movie) {
            System.out.println("Playing movie: " + movie);
        }
    }

    static class SoundSystem {
        public void on() {
            System.out.println("Sound system turning on...");
        }

        public void off() {
            System.out.println("Sound system turning off...");
        }

        public void setVolume(int level) {
            System.out.println("Sound volume set to " + level);
        }
    }

    static class HomeTheaterFacade {
        private Projector projector;
        private DvdPlayer dvdPlayer;
        private SoundSystem soundSystem;

        public HomeTheaterFacade(Projector projector, DvdPlayer dvdPlayer, SoundSystem soundSystem) {
            this.projector = projector;
            this.dvdPlayer = dvdPlayer;
            this.soundSystem = soundSystem;
        }

        public void watchMovie(String movie) {
            System.out.println("Get ready to watch a movie...");
            projector.on();
            projector.setInput("DVD");
            soundSystem.on();
            soundSystem.setVolume(5);
            dvdPlayer.on();
            dvdPlayer.play(movie);
        }

        public void endMovie() {
            System.out.println("Shutting down movie theater...");
            projector.off();
            soundSystem.off();
            dvdPlayer.off();
        }
    }


}
