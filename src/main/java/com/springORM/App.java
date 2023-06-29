package com.springORM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springORM.Dao.StudentDao;
import com.springORM.entities.Student;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		StudentDao dao = context.getBean("studentDao", StudentDao.class);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("******Welcome To My Application********");
		boolean flag = true;
		while (flag) {
			System.out.println("1. To Add New Student");
			System.out.println("2. To Display All Students");
			System.out.println("3. To Get Single Student");
			System.out.println("4. To Delete Student");
			System.out.println("5. To Update Student");
			System.out.println("6. Exit");

			try {

				int input = Integer.parseInt(br.readLine());

				switch (input) {
				case 1:
					System.out.println("Enter Student ID");
					int sId = Integer.parseInt(br.readLine());

					System.out.println("Enter Student Name");
					String sName = br.readLine();

					System.out.println("Enter Student City");
					String sCity = br.readLine();

					Student student = new Student();
					student.setStudentId(sId);
					student.setStudentname(sName);
					student.setStudentcity(sCity);

					int id = dao.insert(student);
					System.out.println(id + " Students Added");

					break;

				case 2:
					List<Student> list = dao.getAllStudents();
					for (Student s : list) {
						System.out.println("ID :" + s.getStudentId());
						System.out.println("Name :" + s.getStudentname());
						System.out.println("City :" + s.getStudentcity());
						System.out.println("________________________________");
					}

					break;

				case 3:
					System.out.println("Enter Student ID");
					int uId = Integer.parseInt(br.readLine());

					Student st = dao.getStudent(uId);
					System.out.println("ID :" + st.getStudentId());
					System.out.println("Name :" + st.getStudentname());
					System.out.println("City :" + st.getStudentcity());
					System.out.println("________________________________");

					break;
				case 4:
					System.out.println("Enter Student ID");
					int Id = Integer.parseInt(br.readLine());
					dao.deleteStudent(Id);
					System.out.println("Successfully Deleted Student details");

					break;
				case 5:
					System.out.println("Enter Student ID to Update");
					int sid = Integer.parseInt(br.readLine());
					System.out.println("Enter Student Name");
					String Name = br.readLine();

					System.out.println("Enter Student City");
					String City = br.readLine();

					Student student2 = new Student();
					student2.setStudentId(sid);
					student2.setStudentname(Name);
					student2.setStudentcity(City);
					dao.updateStudent(student2);

					System.out.println("Student Details Updated Successfully");

					break;

				case 6:

					flag = false;
					break;
				}
			} catch (Exception e) {
				System.out.println("Invalid Input Try with Another one");
			}

		}
		System.out.println("Thank you for using my Application");
		System.out.println("See you soon");

	}
}
