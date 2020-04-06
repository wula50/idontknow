import java.util.Scanner;

public class Rank1 {
	static int MaxNum = 50; // ��ʾ�������
	static int num = 0; // ��ʾʵ������
	static Student[] stu;

	public static void Sort() {
		int max;
		Student temp;
		for (int i = 0; i < num - 1; i++) // ѡ������
		{
			max = i;
			for (int j = i + 1; j < num; j++)
				if (stu[max].total < stu[j].total)
					max = j;
			if (max != i) {
				temp = stu[i];
				stu[i] = stu[max];
				stu[max] = temp;
			}
		}
	}

	public static void Add(String s) throws IDException {
		String[] ss = s.split("\t");
		Student new_student = new Student(ss[0], ss[1], Float.parseFloat(ss[2]), Float.parseFloat(ss[3]),
				Float.parseFloat(ss[4]));
		Check(new_student.ID);
		stu[num++] = new_student;
	}

	public static void Check(String s) throws IDException {
		for (int i = 0; i < num; i++)
			if (stu[i].ID.equals(s))
				throw new IDException("����ӵ�ѧ��ѧ���Ѵ��ڣ�");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		stu = new Student[MaxNum];
		Scanner sc = new Scanner(System.in);
		int choice;

		// ���5��ѧ������Ϣ
		stu[0] = new Student("18001", "����", 78, 79, 83);
		stu[1] = new Student("18002", "��ԪԪ", 81, 90, 83);
		stu[2] = new Student("18003", "���ͺ�", 70, 91, 80);
		stu[3] = new Student("18004", "����", 80, 79, 73);
		stu[4] = new Student("18005", "������", 68, 70, 90);
		num = 5;

		while (true) {
			System.out.println("-----------------------------------------------");
			System.out.println("1.��ʾ����ѧ��");
			System.out.println("2.�����ֽܷ�������");
			System.out.println("3.���ѧ��");
			System.out.println("4.�˳�");
			System.out.print("��ѡ��Ҫ���еĲ���:");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("ѧ��\t����\t����\tӢ��\t��ѧ\t�ܷ�");
				for (int i = 0; i < num; i++)
					System.out.println(stu[i]);
				break;
			case 2:
				Sort();
				System.out.println("���ܷ������");
				System.out.println("ѧ��\t����\t����\tӢ��\t��ѧ\t�ܷ�");
				for (int i = 0; i < num; i++)
					System.out.println(stu[i]);
				break;
			case 3:
				sc.nextLine();// ���������ַ�
				String s;
				if (num < MaxNum) {
					System.out.println("�밴��ѧ��\\t����\\t����\\Ӣ�� \\t��ѧ�����ĸ�ʽ������Ҫ��ӵ�ѧ����Ϣ");
					try {
						s = sc.nextLine();
						Add(s);
					} catch (IDException e) {
						System.out.println(e.getMessage());
					} catch (Exception e) {
						System.out.println("�������������²�����");
					}
				} else
					System.out.println("�������������������");

				break;
			case 4:
				sc.close();
				System.out.println("Bye");
				System.exit(0);
				break;
			}
		}
	}

}
