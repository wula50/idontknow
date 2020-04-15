using System;
using System.IO;

namespace Test {
    class Program {
        static void Main (string[] args) {
            Console.Write ("输出中文试试");
            for (int i = 0; i < 100; i++) {
                Console.WriteLine (i);
            }
            Student student = new Student (1, 2);
            Console.Write ("\n>>Cs中文一切正常，但是速度明显慢");
            Console.WriteLine(student.Print());
        }
    }
    class Student {
        int sno;
        int sname;
        public Student (int a, int b) {
            sno = a;
            sname = b;
        }
        public string Print()
        {
            return sno+""+sname;
        }
    }
}