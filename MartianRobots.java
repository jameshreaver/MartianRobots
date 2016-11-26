import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


class MartianRobots {

    private static MartianPlanet planet;
    private static List<MartianRobot> robots;


    public static void main(String args[]) {
        if (args.length == 0) {
            System.err.print("Provide input file.");
            return;
        }
        String filename = args[0];

        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            createPlanet(br);
            createRobots(br);
            br.close();
        } catch (Exception e) {
            System.err.print(e.getMessage());
            return;
        }

        for (MartianRobot robot : robots) {
            robot.executeInstructions();
            robot.printInfo(System.out);
        }
    }

    private static void createPlanet(BufferedReader br) throws IOException {
        String input = br.readLine();
        String[] bounds = input.split(" ");
        int x = Integer.parseInt(bounds[0]);
        int y = Integer.parseInt(bounds[1]);

        planet = new MartianPlanet(x+1, y+1);
    }

    private static void createRobots(BufferedReader br) throws IOException {
        robots = new LinkedList<>();
        String line;
        while ((line = br.readLine()) != null) {
            String[] configs = line.split(" ");
            int x = Integer.parseInt(configs[0]);
            int y = Integer.parseInt(configs[1]);

            Orientation o = Orientation.valueOf(configs[2]);
            String instr = br.readLine();

            MartianRobot robot = new MartianRobot(x, y, o, instr, planet);
            robots.add(robot);
            br.readLine();
        }
    }

}