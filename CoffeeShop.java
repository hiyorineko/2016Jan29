import java.util.Calendar;
import java.io.*;
import java.util.ArrayList;


public class CoffeeShop{
	Calendar cal = Calendar.getInstance();
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	ArrayList a_no = new ArrayList();
	ArrayList a_kosuu = new ArrayList();
	
	int num = 0;
	int hantei = 0;
	String namae = "";
	int year_0 = 0;
	int month_0 = 0;
	String mon = "";
	int day_0 = 0;
	String d_day = "";
	int year = cal.get(Calendar.YEAR);
	int month = cal.get(Calendar.MONTH)+1;
	int day = cal.get(Calendar.DATE);
	int matsubi[] = {31,28,31,30,31,30,31,31,30,31,30,31};
	int shokei =0;
	int kingaku = 0;
	
	void s_menu()throws IOException{
		while(true){
			if(num ==0){
				System.out.println("商品リスト");
				System.out.println("------------------------------------------");
				System.out.println("No  | 商品名                     | 金額");
				System.out.println("----+----------------------------+--------");
				System.out.println("  1 | ブラジル                   | 1000円");
				System.out.println("  2 | グアテマラ                 | 1300円");
				System.out.println("  3 | キリマンジャロ             | 1500円");
				System.out.println("  4 | マンデリン                 | 1500円");
				System.out.println("  5 | ブルーアイズマウンテン     | 3000円");
				System.out.println("------------------------------------------");
				System.out.print("商品を選んでください[1-5] :");
				a_no.add(Integer.parseInt(br.readLine()));
				System.out.print("個数を入力してください");
				a_kosuu.add(Integer.parseInt(br.readLine()));
				System.out.print("買い物を続ける場合は「0」を\n");
				System.out.print("買い物を終了する場合は「1」を入力してください :");
				num = Integer.parseInt(br.readLine());
			}else{
				break;
			}
		}
	
	}
	
	void k_hyouji()throws IOException{
		String[][] s_data = {{"1","ブラジル","1000"},{"2","グアテマラ","1300"},{"3","キリマンジャロ","1500"},{"4","マンデリン","1500"},{"5","ブルーアイズマウンテン","3000"}};
		System.out.print("\n");
		System.out.println("             精　算　画　面");
		System.out.println("------------------------------------------");
		System.out.println("商品番号  商品名                     金額");
		System.out.println("------------------------------------------");
		for(int i=0;i<a_no.size();i++){
			int a_no_0 = (Integer)a_no.get(i);
			int a_kosuu_0 = (Integer)a_kosuu.get(i);
			System.out.print("No." + a_no_0);
			System.out.print("    :    "+"個 @"+s_data[a_no_0][2]+"  ￥ ");
			shokei += Integer.parseInt(s_data[a_no_0][2])*(int)a_kosuu_0;
			System.out.print(Integer.parseInt(s_data[a_no_0][2]) * (int)a_kosuu_0);
			System.out.print("円\n");
		}
		System.out.println("------------------------------------------");
		System.out.println("          小　計                ￥"+shokei +"円");
		System.out.println("          消費税                ￥"+(int)Math.floor(shokei * 0.05)+"円");
		System.out.println("          合　計                ￥"+(int)Math.floor(shokei * 1.05)+"円");
		System.out.print("\n");
		System.out.print("領収書を発行しますか？[1.発行/0.終了]");
		hantei = Integer.parseInt(br.readLine());
	}
	
	void ryoshu() throws IOException{
		if((year%4 == 0 && year% 100 != 0 || year%400 ==0 )){
			matsubi[1]= 29;
		}
		if(hantei == 1){
			System.out.print("領収書発行\n");
			System.out.print("宛名を入力してください。「全角」 : ");
			namae=br.readLine();
			System.out.print("年を入力してください。「半角」 : ");
			year_0 = Integer.parseInt(br.readLine());
			System.out.print("月を入力してください。「半角」 : ");
			month_0 =  Integer.parseInt(br.readLine());
			System.out.print("日を入力してください。「半角」 : ");
			day_0 =  Integer.parseInt(br.readLine());
			if((year_0<=year) && ((month_0<=month && year_0 == year)||
			(year_0 < year && month_0 <= 12))&&
				(((day_0 <= matsubi[month_0-1]&&year == year_0 && month_0<month)||
					(day_0 <= day && month == month_0 && year == year_0) ||
			(day_0 <= matsubi[month_0-1] && year_0 < year)) && month_0 <= 12)){
				System.out.println("------------------------------------------");
				System.out.print("\n");
				System.out.println("------------------------------------------");
				System.out.print("|                  領収書                |\n");
				System.out.print("|");
				namae = namae + " 様";
				for(int i=0;i<30;i++){
					if(i>=3 && i<=namae.length()+2){
						System.out.print(namae.charAt(i-3));
					}else{
						System.out.print(" ");
					}
				}
				System.out.print("|\n");
				System.out.print("|                                        |\n");
				System.out.print("|");
				kingaku = (int)Math.floor(shokei * 1.05);
				System.out.print("           ");
				System.out.print("金　額　￥");
				
				String moji_su = String.valueOf(kingaku);
				int m_jisu = moji_su.length();
				System.out.print(kingaku);
				
				System.out.print(" 円");
				for(int i=0;i<Math.floor(13-(m_jisu/2));i++){
					System.out.print(" ");
				}
				if(m_jisu%2 == 0){
					System.out.print(" ");
				}
				System.out.print("|\n");
				System.out.print("|                                        |\n");
				if(month_0 < 10){
					mon = "0"+String.valueOf(month_0);
				}else{
					mon = String.valueOf(month_0);
				}
				if(day_0 < 10){
					d_day = "0" + String.valueOf(day_0);
				}else{
					d_day = String.valueOf(day_0);
				}
				System.out.print("|                  ");
				System.out.print("発効日: " + year_0 + "年" + mon + "月"+ d_day +"日| \n");
				System.out.print("|----------------------------------------|\n");
			}else{
				System.out.println("年月日の入力に誤りがあります。");
			}
		}else{
			System.out.print("終了");
		}
	}

}
