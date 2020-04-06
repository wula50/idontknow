import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Rank2 {
	static List<Student> L1;
	
	public static void Add(String s) throws IDException {
		String[] ss = s.split("\t");
		Student new_student = new Student(ss[0], ss[1], Float.parseFloat(ss[2]), Float.parseFloat(ss[3]),
				Float.parseFloat(ss[4]));
		Check(new_student.ID);
		L1.add(new_student);
	}

	public static void Check(String s) throws IDException {
		for (int i = 0; i < L1.size(); i++)
			if (L1.get(i).ID.equals(s))
				throw new IDException("����ӵ�ѧ��ѧ���Ѵ��ڣ�");
	}
	
	public static void main(String[] args) {
		L1 = new ArrayList<Student>();
		Scanner sc = new Scanner(System.in);
		int choice1;
		char choice2;

		// ���5��ѧ������Ϣ
		L1.add(new Student("18001", "����", 78, 79, 83));
		L1.add(new Student("18002", "��ԪԪ", 81, 90, 83));
		L1.add(new Student("18003", "���ͺ�", 70, 91, 80));
		L1.add(new Student("18004", "����", 80, 79, 73));
		L1.add(new Student("18005", "������", 68, 70, 90));

		while (true) {
			System.out.println("-----------------------------------------------");
			System.out.println("1.��ʾ����ѧ��");
			System.out.println("2.�Գɼ���������");
			System.out.println("3.���ѧ��");
			System.out.println("4.�˳�");
			System.out.print("��ѡ��Ҫ���еĲ���:");
			choice1 = sc.nextInt();

			switch (choice1) {
			case 1:
				System.out.println("ѧ��\t����\t����\tӢ��\t��ѧ\t�ܷ�");
				//for (int i = 0; i < L1.size(); i++)
					//System.out.println(L1.get(i));
				for(Student stu:L1) System.out.println(stu);
				break;
			case 2:
				System.out.println("��ѡ������ı�׼��a.�ܷ�\tb.����");
				sc.nextLine();
				choice2 = sc.nextLine().charAt(0);
				switch (choice2) {
				case 'a':
					System.out.println("------�����ܷ�����-------");
					Collections.sort(L1);
					break;
				case 'b':
					System.out.println("------�������ĳɼ�����-------");
					Collections.sort(L1, new Comparator<Student>() {
						public int compare(Student s1, Student s2) {
							return (int) (s2.Chinese - s1.Chinese);
						}
					});
					break;
				}
				System.out.println("ѧ��\t����\t����\tӢ��\t��ѧ\t�ܷ�");
				for (Student stu : L1)
					System.out.println(stu);
				break;
			case 3:
				sc.nextLine();// ���������ַ�
				String s;
				System.out.println("�밴��\"ѧ��\\t����\\t����\\tӢ��\\t��ѧ\"�����ĸ�ʽ������Ҫ��ӵ�ѧ����Ϣ");
				try {
					s = sc.nextLine();
					Add(s);
				} catch (IDException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					System.out.println("�������������²�����");
				}
				break;
			case 4:
				break;
			}
		}
	}
}
