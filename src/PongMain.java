import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.math.*;

public class PongMain {

	public static void main(String[] args) {
		try {
			Socket echoSocket = new Socket("localhost", 7000);
			BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
			PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
			
			int move = 0;
			while (true) {
				String[] ball = { "0", "0", "0", "0", "0" };
				String[] player = { "0", "0", "0" };
				String[] cpu = { "0", "0", "0" };
				String x = in.readLine();
				//player = x.split(" ");
				System.out.println(x+"playyer");
				x = in.readLine();
				//cpu = x.split(" ");
				//System.out.println(x+"cpu");
				x = in.readLine();
				ball = x.split(" ");
				//System.out.println(x+"ball");
				x = in.readLine();
				//System.out.println(x);
				move = Integer.parseInt(player[1]) - (int)(Double.parseDouble(ball[1])/6.5);
				System.out.println(move);
				if (move < -30) {
					move = (int)Double.parseDouble(ball[4])*6;
				} else if (move > -30) {
					move = -(int)Double.parseDouble(ball[4])*6;
				}
				System.out.println(move);
				out.println("move " + move);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
