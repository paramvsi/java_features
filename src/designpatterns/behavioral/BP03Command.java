package designpatterns.behavioral;

public class BP03Command {

    public static void main(String[] args) {
        RemoteControl control = new RemoteControl();
        Light light = new Light();
        Fan fan = new Fan();

        Command lightsOn = new LightOnCommand(light);
        Command lightsOff = new LightOffCommand(light);
        Command fanOn = new FanOnCommand(fan);
        Command fanOff = new FanOffCommand(fan);

        control.setCommand(0, lightsOn, lightsOff);
        control.setCommand(1, fanOn, fanOff);

        control.onButtonWasPressed(0);
        control.offButtonWasPressed(0);
        control.onButtonWasPressed(1);
        control.offButtonWasPressed(1);
        control.undoButtonWasPressed();
    }

    public interface Command {
        void execute();

        void undo();
    }

    public static class LightOnCommand implements Command {
        private Light light;

        public LightOnCommand(Light light) {
            this.light = light;
        }

        @Override
        public void execute() {
            light.on();
        }

        @Override
        public void undo() {
            light.off();
        }
    }

    public static class LightOffCommand implements Command {
        private Light light;

        public LightOffCommand(Light light) {
            this.light = light;
        }

        @Override
        public void execute() {
            light.off();
        }

        @Override
        public void undo() {
            light.on();
        }
    }

    public static class FanOnCommand implements Command {
        private Fan fan;

        public FanOnCommand(Fan fan) {
            this.fan = fan;
        }

        @Override
        public void execute() {
            fan.on();
        }

        @Override
        public void undo() {
            fan.off();
        }
    }

    public static class FanOffCommand implements Command {
        private Fan fan;

        public FanOffCommand(Fan fan) {
            this.fan = fan;
        }

        @Override
        public void execute() {
            fan.off();
        }

        @Override
        public void undo() {
            fan.on();
        }
    }

    public static class Light {
        public void on() {
            System.out.println("Light is on");
        }

        public void off() {
            System.out.println("Light is off");
        }
    }

    public static class Fan {
        public void on() {
            System.out.println("Fan is on");
        }

        public void off() {
            System.out.println("Fan is off");
        }
    }

    public static class RemoteControl {
        private Command[] onCommands;
        private Command[] offCommands;
        private Command undoCommand;

        public RemoteControl() {
            // Assuming we have 2 slots for simplicity
            onCommands = new Command[2];
            offCommands = new Command[2];

            // Initialize with no-operation commands to avoid null checks
            Command noOp = new NoCommand();
            for (int i = 0; i < 2; i++) {
                onCommands[i] = noOp;
                offCommands[i] = noOp;
            }
            undoCommand = noOp;
        }

        public void setCommand(int slot, Command onCommand, Command offCommand) {
            if (slot < 0 || slot >= onCommands.length) {
                System.out.println("Invalid slot!");
                return;
            }
            onCommands[slot] = onCommand;
            offCommands[slot] = offCommand;
        }

        public void onButtonWasPressed(int slot) {
            if (slot < 0 || slot >= onCommands.length) {
                System.out.println("Invalid slot!");
                return;
            }
            onCommands[slot].execute();
            undoCommand = onCommands[slot];
        }

        public void offButtonWasPressed(int slot) {
            if (slot < 0 || slot >= offCommands.length) {
                System.out.println("Invalid slot!");
                return;
            }
            offCommands[slot].execute();
            undoCommand = offCommands[slot];
        }

        public void undoButtonWasPressed() {
            undoCommand.undo();
        }

        @Override
        public String toString() {
            StringBuilder stringBuild = new StringBuilder();
            stringBuild.append("\n----- Remote Control -----\n");
            for (int i = 0; i < onCommands.length; i++) {
                stringBuild.append("[slot ").append(i).append("] ")
                        .append(onCommands[i].getClass().getName())
                        .append("    ")
                        .append(offCommands[i].getClass().getName())
                        .append("\n");
            }
            return stringBuild.toString();
        }
    }

    // The NoCommand class as a default for initialization and to avoid null checks
    static class NoCommand implements Command {
        public void execute() {
        }

        public void undo() {
        }
    }

}
