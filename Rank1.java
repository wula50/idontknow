import java.util.Scanner;

public class Rank1 {
	static int MaxNum = 50; // 表示最大容量
	static int num = 0; // 表示实际人数
	static Student[] stu;

	public static void Sort() {
		int max;
		Student temp;
		for (int i = 0; i < num - 1; i++) // 选择排序
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
				throw new IDException("待添加的学生学号已存在！");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		stu = new Student[MaxNum];
		Scanner sc = new Scanner(System.in);
		int choice;

		// 添加5个学生的信息
		stu[0] = new Student("18001", "张三", 78, 79, 83);
		stu[1] = new Student("18002", "王元元", 81, 90, 83);
		stu[2] = new Student("18003", "胡和合", 70, 91, 80);
		stu[3] = new Student("18004", "陈庆", 80, 79, 73);
		stu[4] = new Student("18005", "伍明明", 68, 70, 90);
		num = 5;

		while (true) {
			System.out.println("-----------------------------------------------");
			System.out.println("1.显示所有学生");
			System.out.println("2.根据总分进行排序");
			System.out.println("3.添加学生");
			System.out.println("4.退出");
			System.out.print("请选择要进行的操作:");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("学号\t姓名\t语文\t英语\t数学\t总分");
				for (int i = 0; i < num; i++)
					System.out.println(stu[i]);
				break;
			case 2:
				Sort();
				System.out.println("按总分排序后");
				System.out.println("学号\t姓名\t语文\t英语\t数学\t总分");
				for (int i = 0; i < num; i++)
					System.out.println(stu[i]);
				break;
			case 3:
				sc.nextLine();// 过滤输入字符
				String s;
				if (num < MaxNum) {
					System.out.println("请按照学号\\t姓名\\t语文\\英语 \\t数学这样的格式输入需要添加的学生信息");
					try {
						s = sc.nextLine();
						Add(s);
					} catch (IDException e) {
						System.out.println(e.getMessage());
					} catch (Exception e) {
						System.out.println("输入有误，请重新操作！");
					}
				} else
					System.out.println("名额已满，不能再添加");

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
