import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class LankTest {
	static List<GameBoy> lank1 = new ArrayList<GameBoy>();
	static List<GameBoy> lank2 = new ArrayList<GameBoy>();
	static List<GameBoy> lank3 = new ArrayList<GameBoy>();
	static List<GameBoy> lank4 = new ArrayList<GameBoy>();
	static GameBoy gb = new GameBoy();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 보고싶은 게임고르기
		while (true) {
			Scanner key = new Scanner(System.in);
			System.out.println("마! 어느게임의 랭킹이 보고싶나! ");
			System.out.println("1.임욱표형게임\n2.김욱표형게임\n3.박욱표형게임\n4.최욱표형게임");
			int choice = key.nextInt();
			switch (choice) {
			case 1:
				System.out.println("==게임1의 랭킹 현황입니다==");
				showFirstGame();
				break;
			case 2:
				System.out.println("==게임2의 랭킹 현황입니다==");
				showSecondGame();
				break;
			case 3:
				System.out.println("==게임3의 랭킹 현황입니다==");
				showThirdGame();
				break;
			case 4:
				System.out.println("==게임4의 랭킹 현황입니다==");
				showFourthGame();
				break;

			default:
				System.out.println("잘못입력하셨습니다");
				break;
			}
		}
	}

//1번게임
	static void showFirstGame() {
		gb.saveData();
		Collections.sort(lank1, new comprator());
		for (int i = 0; i < lank1.size(); i++) {
			System.out.println("-----" + (i + 1) + "등" + "-----");
			lank1.get(i).showData();
		}
		return;
	}

//2번게임
	static void showSecondGame() {
		lank2.add(new GameBoy("놀", 80));
		lank2.add(new GameBoy("룰", 50));
		lank2.add(new GameBoy("호", 120));
		lank2.add(new GameBoy("루", 20));
		Collections.sort(lank2, new comprator());
		for (int i = 0; i < lank2.size(); i++) {
			System.out.println("-----" + (i + 1) + "등" + "-----");
			lank2.get(i).showData();
		}
		return;

	}

//3번게임
	static void showThirdGame() {
		lank3.add(new GameBoy("리", 80));
		lank3.add(new GameBoy("라", 50));
		lank3.add(new GameBoy("스", 120));
		lank3.add(new GameBoy("차", 20));
		Collections.sort(lank3, new comprator());
		for (int i = 0; i < lank3.size(); i++) {
			System.out.println("-----" + (i + 1) + "등" + "-----");
			lank3.get(i).showData();
		}
		return;
	}

//4번게임
	static void showFourthGame() {
		lank4.add(new GameBoy("욱", 80));
		lank4.add(new GameBoy("표", 50));
		lank4.add(new GameBoy("임", 120));
		lank4.add(new GameBoy("짱", 20));
		Collections.sort(lank4, new comprator());
		for (int i = 0; i < lank4.size(); i++) {
			System.out.println("-----" + (i + 1) + "등" + "-----");
			lank4.get(i).showData();
		}
		return;
	}

}

//기본 유저 정보

class GameBoy extends LankTest implements GameBasic {
	String name = "펭귄프사";
	int point = 71;

	GameBoy() {
	}

	GameBoy(String name, int point) {
		this.name = name;
		this.point = point;
	}

	public void showData() {
		System.out.println("USERNAME:" + name);
		System.out.println("POINT   :" + point);
	}

	public void saveData() {
		lank1.add(new GameBoy(name, point));
		lank2.add(new GameBoy(name, point));
		lank3.add(new GameBoy(name, point));
		lank4.add(new GameBoy(name, point));
	}

}

//소트정렬을 위한 클래스
class comprator implements Comparator<GameBoy> {
	@Override
	public int compare(GameBoy o1, GameBoy o2) {
		return o2.point - o1.point;
	}
}