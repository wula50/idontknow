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
				throw new IDException("待添加的学生学号已存在！");
	}
	
	public static void main(String[] args) {
		L1 = new ArrayList<Student>();
		Scanner sc = new Scanner(System.in);
		int choice1;
		char choice2;

		// 添加5个学生的信息
		L1.add(new Student("18001", "张三", 78, 79, 83));
		L1.add(new Student("18002", "王元元", 81, 90, 83));
		L1.add(new Student("18003", "胡和合", 70, 91, 80));
		L1.add(new Student("18004", "陈庆", 80, 79, 73));
		L1.add(new Student("18005", "伍明明", 68, 70, 90));

		while (true) {
			System.out.println("-----------------------------------------------");
			System.out.println("1.显示所有学生");
			System.out.println("2.对成绩进行排序");
			System.out.println("3.添加学生");
			System.out.println("4.退出");
			System.out.print("请选择要进行的操作:");
			choice1 = sc.nextInt();

			switch (choice1) {
			case 1:
				System.out.println("学号\t姓名\t语文\t英语\t数学\t总分");
				//for (int i = 0; i < L1.size(); i++)
					//System.out.println(L1.get(i));
				for(Student stu:L1) System.out.println(stu);
				break;
			case 2:
				System.out.println("请选择排序的标准：a.总分\tb.语文");
				sc.nextLine();
				choice2 = sc.nextLine().charAt(0);
				switch (choice2) {
				case 'a':
					System.out.println("------根据总分排序-------");
					Collections.sort(L1);
					break;
				case 'b':
					System.out.println("------根据语文成绩排序-------");
					Collections.sort(L1, new Comparator<Student>() {
						public int compare(Student s1, Student s2) {
							return (int) (s2.Chinese - s1.Chinese);
						}
					});
					break;
				}
				System.out.println("学号\t姓名\t语文\t英语\t数学\t总分");
				for (Student stu : L1)
					System.out.println(stu);
				break;
			case 3:
				sc.nextLine();// 过滤输入字符
				String s;
				System.out.println("请按照\"学号\\t姓名\\t语文\\t英语\\t数学\"这样的格式输入需要添加的学生信息");
				try {
					s = sc.nextLine();
					Add(s);
				} catch (IDException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					System.out.println("输入有误，请重新操作！");
				}
				break;
			case 4:
				break;
			}
		}
	}
}
