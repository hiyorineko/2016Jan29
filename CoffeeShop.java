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
				System.out.println("���i���X�g");
				System.out.println("------------------------------------------");
				System.out.println("No  | ���i��                     | ���z");
				System.out.println("----+----------------------------+--------");
				System.out.println("  1 | �u���W��                   | 1000�~");
				System.out.println("  2 | �O�A�e�}��                 | 1300�~");
				System.out.println("  3 | �L���}���W����             | 1500�~");
				System.out.println("  4 | �}���f����                 | 1500�~");
				System.out.println("  5 | �u���[�A�C�Y�}�E���e��     | 3000�~");
				System.out.println("------------------------------------------");
				System.out.print("���i��I��ł�������[1-5] :");
				a_no.add(Integer.parseInt(br.readLine()));
				System.out.print("������͂��Ă�������");
				a_kosuu.add(Integer.parseInt(br.readLine()));
				System.out.print("�������𑱂���ꍇ�́u0�v��\n");
				System.out.print("���������I������ꍇ�́u1�v����͂��Ă������� :");
				num = Integer.parseInt(br.readLine());
			}else{
				break;
			}
		}
	
	}
	
	void k_hyouji()throws IOException{
		String[][] s_data = {{"1","�u���W��","1000"},{"2","�O�A�e�}��","1300"},{"3","�L���}���W����","1500"},{"4","�}���f����","1500"},{"5","�u���[�A�C�Y�}�E���e��","3000"}};
		System.out.print("\n");
		System.out.println("             ���@�Z�@��@��");
		System.out.println("------------------------------------------");
		System.out.println("���i�ԍ�  ���i��                     ���z");
		System.out.println("------------------------------------------");
		for(int i=0;i<a_no.size();i++){
			int a_no_0 = (Integer)a_no.get(i);
			int a_kosuu_0 = (Integer)a_kosuu.get(i);
			System.out.print("No." + a_no_0);
			System.out.print("    :    "+"�� @"+s_data[a_no_0][2]+"  �� ");
			shokei += Integer.parseInt(s_data[a_no_0][2])*(int)a_kosuu_0;
			System.out.print(Integer.parseInt(s_data[a_no_0][2]) * (int)a_kosuu_0);
			System.out.print("�~\n");
		}
		System.out.println("------------------------------------------");
		System.out.println("          ���@�v                ��"+shokei +"�~");
		System.out.println("          �����                ��"+(int)Math.floor(shokei * 0.05)+"�~");
		System.out.println("          ���@�v                ��"+(int)Math.floor(shokei * 1.05)+"�~");
		System.out.print("\n");
		System.out.print("�̎����𔭍s���܂����H[1.���s/0.�I��]");
		hantei = Integer.parseInt(br.readLine());
	}
	
	void ryoshu() throws IOException{
		if((year%4 == 0 && year% 100 != 0 || year%400 ==0 )){
			matsubi[1]= 29;
		}
		if(hantei == 1){
			System.out.print("�̎������s\n");
			System.out.print("��������͂��Ă��������B�u�S�p�v : ");
			namae=br.readLine();
			System.out.print("�N����͂��Ă��������B�u���p�v : ");
			year_0 = Integer.parseInt(br.readLine());
			System.out.print("������͂��Ă��������B�u���p�v : ");
			month_0 =  Integer.parseInt(br.readLine());
			System.out.print("������͂��Ă��������B�u���p�v : ");
			day_0 =  Integer.parseInt(br.readLine());
			if((year_0<=year) && ((month_0<=month && year_0 == year)||
			(year_0 < year && month_0 <= 12))&&
				(((day_0 <= matsubi[month_0-1]&&year == year_0 && month_0<month)||
					(day_0 <= day && month == month_0 && year == year_0) ||
			(day_0 <= matsubi[month_0-1] && year_0 < year)) && month_0 <= 12)){
				System.out.println("------------------------------------------");
				System.out.print("\n");
				System.out.println("------------------------------------------");
				System.out.print("|                  �̎���                |\n");
				System.out.print("|");
				namae = namae + " �l";
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
				System.out.print("���@�z�@��");
				
				String moji_su = String.valueOf(kingaku);
				int m_jisu = moji_su.length();
				System.out.print(kingaku);
				
				System.out.print(" �~");
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
				System.out.print("������: " + year_0 + "�N" + mon + "��"+ d_day +"��| \n");
				System.out.print("|----------------------------------------|\n");
			}else{
				System.out.println("�N�����̓��͂Ɍ�肪����܂��B");
			}
		}else{
			System.out.print("�I��");
		}
	}

}
